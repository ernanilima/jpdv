package br.com.ernanilima.jpdv.Presenter;

import br.com.ernanilima.jpdv.Controller.*;
import br.com.ernanilima.jpdv.Dao.*;
import br.com.ernanilima.jpdv.Model.*;
import br.com.ernanilima.jpdv.Model.Enum.IndexShortcutKey;
import br.com.ernanilima.jpdv.Model.TableModel.*;
import br.com.ernanilima.jpdv.Util.*;
import br.com.ernanilima.jpdv.Presenter.Listener.ViewPDVActionListener;
import br.com.ernanilima.jpdv.Presenter.Listener.ViewPDVKeyListener;
import br.com.ernanilima.jpdv.View.Enum.CardLayoutPDV;
import br.com.ernanilima.jpdv.View.IViewPDV;
import br.com.ernanilima.jpdv.View.ViewPDV;

import javax.swing.*;
import javax.swing.table.TableRowSorter;

import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static br.com.ernanilima.jpdv.View.Enum.CardLayoutPDV.*;

/**
 * Presenter da ViewPDV
 *
 * @author Ernani Lima
 */
public class PDVPresenter {

    // Variaveis do PDV
    private final double maxQty = 100; // Quantidade maxima do mesmo produto por linha
    private final double minQty = 0.001; // Quantidade minima do mesmo produto por linha

    // Interface da ViewPDV
    private final IViewPDV viewPDV;

    // Presenter do pop-up de alertas/ok
    private final PopUPMessageDialogPresenter pPopUPMessage;

    // Presenter do pop-up de confirmacao (sim/nao)
    private final PopUPConfirmDialogPresenter pPopUPConfirm;

    // Presenter do pop-up de validar nivel do usuario
    private final PopUPUserPermissionDialogPresenter pPopUPUserPermission;

    // Model do usuario
    private final User mUser;

    // Model do suporte
    private final Support mSupport;

    // Model de imagens de background do sistema
    private final Backgrounds mBg;

    // Dao do usuario
    private final UserDao dUser;

    // Dao de produto
    private final ProductDao dProduct;

    // Dao de cupom
    private final CouponDao dCoupon;

    // Model de produto
    private Product mProduct;

    // Model de cupom
    private Coupon mCoupon;

    // Model do PDV
    private PDV mPDV;

    // Model teclas de atalho
    private final ShortcutKey mShortcutKey;

    // TableModel de itens vendidos
    private final ProductFrontTableModel tmProductFront;

    // TableModel de produtos back
    private final ProductBackTableModel tmProductBack;

    // TableModel de buscar produtos
    private final ProductSearchTableModel tmProductSearch;

    // TableRowSorter de buscar produtos
    private final TableRowSorter<ProductSearchTableModel> trsProductSearch;

    // TableModel de formas de pagamento
    private final PaymentMethodTableModel tmPayment;

    // TableModel de pagamento recebido
    private final PaymentReceivedTableModel tmPaymentReceived;

    private int currentUserLevel;
    private int pdvID = 1;
    private int companyID = 1;

    private boolean save = false;
    private boolean cancel = true;

    // Colunas da JTable produtos back
    private final int proBackDiscountColumn = 6;
    private final int proBackSubtotalColumn = 7;
    private final int proBackCancellationColumn = 8;

    // Coluna da JTable de pagamentos recebidos
    private final int payReceivedValueColumn = 1;

    // Niveis solicitados
    private int levelCancelProduct = 2;
    private int levelCancelCurrentCoupon = 2;
    private int levelItemDiscount = 2;

    // Construtor
    public PDVPresenter() {
        this.viewPDV = new ViewPDV();
        this.pPopUPMessage = new PopUPMessageDialogPresenter();
        this.pPopUPConfirm = new PopUPConfirmDialogPresenter();
        this.pPopUPUserPermission = new PopUPUserPermissionDialogPresenter();
        this.mUser = new User();
        this.mSupport = new Support();
        this.mBg = new Backgrounds();
        this.dUser = new UserDao();
        this.dProduct = new ProductDao();
        this.dCoupon = new CouponDao();
        this.mProduct = new Product();
        this.mCoupon = new Coupon();
        this.mPDV = new PDV();
        this.mShortcutKey = new ShortcutKey();
        this.tmProductFront = new ProductFrontTableModel();
        this.tmProductBack = new ProductBackTableModel();
        this.tmProductSearch = new ProductSearchTableModel();
        this.trsProductSearch = new TableRowSorter<>(tmProductSearch);
        this.tmPayment = new PaymentMethodTableModel();
        this.tmPaymentReceived = new PaymentReceivedTableModel();
        this.myTables();
        this.fillProductSearchTable();
        this.fillPaymentMethodTable();
        this.myListiners();
        this.myFilters();
        this.myShortcutKey();
        this.viewPDV.setcurrentCouponID(couponID());
        this.viewPDV.setCurrentDate(Format.DFDATE_BR.format(System.currentTimeMillis()));
        this.showTime();
        this.viewPDV.setPDVID(Format.formatThreeDigits.format(pdvID));
        this.viewPDV.setCompanyID(Format.formatThreeDigits.format(companyID));
        this.viewPDV.setVersion("0.1.10");
        this.viewPDV.setBackgroundLogin(Background.getBackgroundCenter(mBg.getPathBgPDVLogin()));
        this.viewPDV.setQuantity(Format.formatQty.format(1));
        this.viewPDV.packAndShow();
    }

    // Thread que atualiza a hora
    private void showTime() {
        new Thread (() -> {
            try {
                while (true) {
                    viewPDV.setCurrentTime(Format.DFTIME.format(System.currentTimeMillis()));
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("ERRO COM HORA ATUAL: " + e);
            }
        }).start();
    }

    // Thread que controle o tempo da tela de troco
    private class ChangeScreen extends Thread {

        private int changeCoupon = 0;
        private final int waitingTime = 10;

        private ChangeScreen(int changeCoupon) {
            this.changeCoupon = changeCoupon;
        }

        @Override
        public void run() {
            try {
                ChangeScreen.sleep(1000 * waitingTime);
                int currentCoupon = Integer.parseInt(viewPDV.getCurrentCouponID());
                if (viewPDV.getChangeScreenIsVisible() & changeCoupon == currentCoupon) {
                    newSale();
                } else {
                    this.interrupt();
                }
            } catch (InterruptedException e) {
                System.out.println("ERRO NO TEMPO DA TELA DE TROCO: " + e);
            }
        }
    }

    // Primeiro cupom
    private String couponID() {
        String id = dCoupon.nextCouponID();
        if (id == null){
            return id = "1";
        }
        return id;
    }

    // Minhas JTables
    private void myTables() {
        viewPDV.getProductTableFront().setModel(tmProductFront);
        viewPDV.getProductTableFront().setDefaultRenderer(Object.class, new ProductFrontRenderer());
        viewPDV.getProductTableBack().setModel(tmProductBack);
        viewPDV.getProductTableBack().setDefaultRenderer(Object.class, new ProductBackRenderer());
        viewPDV.getProductSearchTable().setModel(tmProductSearch);
        viewPDV.getProductSearchTable().setDefaultRenderer(Object.class, new ProductSearchRenderer());
        viewPDV.getProductSearchTable().setRowSorter(trsProductSearch);
        viewPDV.getPaymentMethodTable().setModel(tmPayment);
        viewPDV.getPaymentMethodTable().setDefaultRenderer(Object.class, new PaymentMethodRenderer());
        viewPDV.getPaymentReceivedTable().setModel(tmPaymentReceived);
        viewPDV.getPaymentReceivedTable().setDefaultRenderer(Object.class, new PaymentReceivedRenderer());
        viewPDV.getPaymentReceivedTable().setRowSelectionAllowed(false);
    }

    // Preenche a tabela de buscar produtos
    private void fillProductSearchTable() {
        int rows = tmProductSearch.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            tmProductSearch.removeRow(i);
        }
        dProduct.listProducts().forEach(tmProductSearch::addRow);
    }

    // Preenche a tabela de formas de pagamento
    private  void fillPaymentMethodTable() {
        PaymentMethodDao dPayment = new PaymentMethodDao();
        int rows = tmPayment.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            tmPayment.removeRow(i);
        }
        dPayment.listPayments().forEach(tmPayment::addRow);
    }

    // Gera lista de teclas de atalho
    private void myShortcutKey() {
        ShortcutKeyDao dShortcutKey = new ShortcutKeyDao();
        mShortcutKey.setLsShortcutKeys(dShortcutKey.listShortcutKeys());
    }

    // Listiner de "Botons", "Campos" e outros.
    private void myListiners() {
        viewPDV.setBtnLoginActionPerformed(new ViewPDVActionListener.BtnLoginUserActionListener(this));
        viewPDV.setBtnExitActionPerformed(new ViewPDVActionListener.BtnExitActionListener(this));
        viewPDV.setFieldIDKeyPressed(new ViewPDVKeyListener.FieldIDKeyListener(this));
        viewPDV.setFieldPasswordKeyPressed(new ViewPDVKeyListener.FieldPassqordKeyListener(this));
        viewPDV.setFieldBarcodeKeyPressed(new ViewPDVKeyListener.FieldBarcodeKeyListener(this));
        viewPDV.setProductTableBackKeyPressed(new ViewPDVKeyListener.ProductTableBackKeyListener(this));
        viewPDV.setFieldSearchProductKeyPressed(new ViewPDVKeyListener.FieldSearchProductKeyListener(this));
        viewPDV.setBtnClearSearchActionPerformed(new ViewPDVActionListener.BtnClearSearchActionListener(this));
        viewPDV.setFieldTotalValueReceivedKeyPressed(new ViewPDVKeyListener.FieldTotalValueReceivedKeyListener(this));
        viewPDV.setFieldDiscountValueKeyPressed(new ViewPDVKeyListener.FieldDiscountValueKeyListener(this));
        viewPDV.setFieldDiscountPercentageKeyPressed(new ViewPDVKeyListener.FieldDiscountPercentageKeyListener(this));
        viewPDV.setBtnConfirmDiscountActionPerformed(new ViewPDVActionListener.BtnConfirmDiscountActionListener(this));
        viewPDV.setFieldChangeValueKeyPressed(new ViewPDVKeyListener.FieldChangeValueKeyListener(this));
    }

    // Metodo que gerencia os campos do ViewPDV
    private void myFilters() {
        viewPDV.setFieldBarcodeDocument(new FieldManager.FieldFilterDouble(14));
        viewPDV.setFieldIDDocument(new FieldManager.FieldFilterInt(3));
        viewPDV.setFieldSalePriceDocument(new FieldManager.FieldFilterMonetary());
        viewPDV.setFieldTotalProductValueDocument(new FieldManager.FieldFilterMonetary());
        viewPDV.setFieldTotalCouponValueDocument(new FieldManager.FieldFilterMonetary());
        viewPDV.setFieldTotalDiscountDocument(new FieldManager.FieldFilterMonetary());
        viewPDV.setFieldTotalOutstandingAmountDocument(new FieldManager.FieldFilterMonetary());
        viewPDV.setFieldTotalValueReceivedDocument(new FieldManager.FieldFilterMonetary());
        viewPDV.setFieldDiscountValueDocument(new FieldManager.FieldFilterMonetary());
        //viewPDV.setFieldDiscountPercentageDocument( CRIAR UM DOCUMENTO DE %);
        viewPDV.setFieldChangeValueDocument(new FieldManager.FieldFilterMonetary());
        viewPDV.setFieldValueReceivableChangeDocument(new FieldManager.FieldFilterMonetary());
        viewPDV.setValueReceivedChangeDocument(new FieldManager.FieldFilterMonetary());
    }

    // Nova venda
    public void newSale() {
        // LIMPAR PRODUTOS VENDIDOS
        int productRows = viewPDV.getProductTableFront().getRowCount();
        if (productRows > 0) {
            int rows = tmProductFront.getRowCount();
            for (int i = rows - 1; i >= 0; i--) {
                tmProductFront.removeRow(i);
                tmProductBack.removeRow(i);
            }
        }

        // LIMPAR PAGAMENTO DEREBIDO
        int receiptRows = viewPDV.getPaymentReceivedTable().getRowCount();
        if (receiptRows > 0) {
            int rows = tmPaymentReceived.getRowCount();
            for (int i = rows - 1; i >= 0; i--) {
                tmPaymentReceived.removeRow(i);
            }
        }

        viewPDV.setcurrentCouponID(dCoupon.nextCouponID());
        cleanBasicFields();
        viewPDV.setProductDescription("CAIXA LIVRE!");

        selectValueCardL(CARD_VALOR_PRODUTO);
        selectSaleCardL(CARD_VENDA);
    }

    // Limpa os campos basicos
    private void cleanBasicFields() {
        viewPDV.setProductDescription("");
        viewPDV.cleanBarcodeField();
        viewPDV.setSalePrice("");
        viewPDV.setTotalProductValue("");
        viewPDV.cleanDiscountValue();
        viewPDV.cleanDiscountPercentage();
        if (viewPDV.getProductTableBack().getRowCount() < 1) {
            viewPDV.setTotalCouponValue("");
            viewPDV.setTotalValueProducts("");
            viewPDV.setTotalValueReceivable("");
            viewPDV.cleanTotalValueReceived();
        }
    }

    /**
     * Metodo que realiza a validacao de login do usuario ou do suporte tecnico
     */
    public void userLogin() {
        String id = viewPDV.getUserID();
        String password = Encrypt.sha256(viewPDV.getPassword());

        if (id.equals("")) {
            System.out.println("INFORME O CODIGO DO OPERADOR!");
            pPopUPMessage.showAlert("ATENÇÃO!", "INFORME O CÓDIGO DO USUÁRIO!");
            focusFieldID();
        } else if (password.equals("")) {
            System.out.println("INFORME A SENHA DO OPERADOR!");
            pPopUPMessage.showAlert("ATENÇÃO!", "INFORME A SENHA DO USUÁRIO!");
            focusFieldPassword();
        } else if (Integer.parseInt(id) == (mSupport.getId()) & password.equals(mSupport.getPwd())) {
            System.out.println("LOGIN DO SUPORTE TECNICO!");
            OpeningPresenter openingPresenter = new OpeningPresenter();
            openingPresenter.showViewOpening();
            pPopUPMessage.showAlert("ALERTA", "Login do Suporte!");
        } else {
            mUser.setId(Integer.parseInt(id));
            mUser.setPwd(password);

            if (dUser.userLogin(mUser)) {
                System.out.println("LOGIN REALIZADO!");
                viewPDV.setUserID(String.valueOf(mUser.getId()));
                viewPDV.setUsername(mUser.getName());
                currentUserLevel = mUser.getLevel();
                selectStartCardL(CARD_PDV);
                focusFieldBarCode();
                viewPDV.setProductDescription("CAIXA LIVRE!");
            } else {
                System.out.println("Dados incorretos ou usuário não cadastrado!");
                pPopUPMessage.showAlert("ATENÇÃO!", "DADOS INCORRETOS OU USUÁRIO NÃO CADASTRADO!");
                focusFieldID();
            }
        }
    }

    /**
     * Metodo que fecha o sistema do PDV.
     * O metodo exibe um Dialog de confirmacao para fechar a tela do PDV.
     */
    public void exitPDV() {
        pPopUPConfirm.showConfirmDialog("ATENÇÃO!", "DESEJA SAIR DO SISTEMA?");
        if (pPopUPConfirm.questionResult()) {
            System.exit(0);
        }
    }

    /**
     * Adiciona na venda o produto informado no campo de codigo de barras
     */
    public void productFromBarcodeField() {
        String barcode = viewPDV.getBarcode();
        if (barcode.equals("")) {
            // Exibe o painel de buscar produtos
            selectSaleCardL(CARD_BUSCAR);

        } else if (barcode.contains(".")) {
            // Para a execucao do metodo se existir ponto(.) no campo de codigo de barras
            pPopUPMessage.showAlert("ATENÇÃO!", "CÓDIGO DE BARRAS INVÁLIDO!");
            viewPDV.cleanBarcodeField();

        } else {
            // Envia codigo de barras informado para o metodo
            // que realiza a busca e adiciona na venda
            mProduct = new Product();
            mProduct.setBarcode(Long.parseLong(barcode));
            searchProduct(mProduct);
        }
    }

    /**
     * Adiciona na venda o produto selecionado na tabela de buscar produtos
     */
    public void productFromSearchTable() {
        int selectedRow = viewPDV.getProductSearchTable().getSelectedRow();
        int rowCount = viewPDV.getProductSearchTable().getRowCount();
        if (selectedRow != -1 & rowCount > 0) {
            mProduct = tmProductSearch.getLs(viewPDV.getProductSearchTable().convertRowIndexToModel(selectedRow));
            searchProduct(mProduct);
            selectSaleCardL(CARD_VENDA);
        } else {
            pPopUPMessage.showAlert("ATENÇÃO!", "NENHUM PRODUTO SELECIONADO!");
        }
    }

    /**
     * Filtro de busca de produto
     */
    public void productSearchFilter() {
        trsProductSearch.setRowFilter(RowFilter.regexFilter("(?i)" + viewPDV.getFieldSearchProduct()));
        viewPDV.getProductSearchTable().changeSelection(0, 0, false, false);
    }

    /**
     * Metodo que realiza a busca de produto pelo seu codigo de barras
     */
    private void searchProduct(Product mProduct) {
        if (dProduct.searchProductByBarcode(mProduct)) {
            // Executa caso o produto seja encontrado
            mCoupon = new Coupon();
            mCoupon.setmProduct(mProduct);
            mCoupon.setQuantity(Filter.filterDouble(viewPDV.getQuantity()));
            mCoupon.setProductRowIndex(viewPDV.getProductTableFront().getRowCount()+1);
            tmProductFront.addRow(mCoupon);
            tmProductBack.addRow(mCoupon);
            viewPDV.getProductTableFront().changeSelection(viewPDV.getProductTableFront().getRowCount()-1, 0, false, false);
            viewPDV.getProductTableBack().changeSelection(viewPDV.getProductTableBack().getRowCount()-1, 0, false, false);
            viewPDV.setSalePrice(Format.brCurrencyFormat.format(mCoupon.getmProduct().getSalePrice()));
            viewPDV.setTotalProductValue(Format.brCurrencyFormat.format(mCoupon.getTotalProductValue()));
            viewPDV.setTotalValueProducts(Format.brCurrencyFormat.format(totalValueOfProducts()));
            System.out.println("PRODUTO: " + mCoupon.getmProduct().getDescriptionCoupon());
            viewPDV.setProductDescription(mProduct.getDescriptionCoupon());
            viewPDV.setQuantity(Format.formatQty.format(1));
            viewPDV.cleanBarcodeField();
        } else {
            // Exibe um alerta caso o produto nao seja encontrado
            System.out.println("PRODUTO NAO ENCONTRADO");
            pPopUPMessage.showAlert("ATENÇÃO!", "PRODUTO NÃO ENCONTRADO!");
            viewPDV.cleanBarcodeField();
            viewPDV.getProductTableFront().changeSelection(viewPDV.getProductTableFront().getRowCount()-1, 0, false, false);
        }
    }

    /**
     * Inseri uma nova quantidade de venda
     */
    public void newQuantity() {
        if (!viewPDV.getBarcode().equals("") & !viewPDV.getBarcode().equals(".")) {
            // Executa se o campo de codigo de barras nao estiver vazio
            double qtyPDV = Double.parseDouble(viewPDV.getBarcode());
            if (qtyPDV >= minQty & qtyPDV <= maxQty) {
                // Executa se a quantidade informada estiver entre
                // o minimo e maximo permitido nos parametros
                viewPDV.setQuantity(Format.formatQty.format(qtyPDV));
                viewPDV.cleanBarcodeField();
            } else {
                pPopUPMessage.showAlert("ATENÇÃO!", "QUANTIDADE INVÁLIDA!");
                viewPDV.cleanBarcodeField();
            }
        } else if (viewPDV.getBarcode().equals("") & !viewPDV.getQuantity().equals("1,000")) {
            // Executa se o campo de codigo de barras estiver vazio
            // e se o campo de quantidade for diferente de 1,000.
            // Restaura a quantidade padrao de venda para produtos
            viewPDV.setQuantity(Format.formatQty.format(1));
        }
    }

    /**
     * Metodo que retorna o Model de tecla de atalho
     * @param index {@link IndexShortcutKey} - index da tecla de atalho no lista
     * @return int - KeyCode da tecla de atalho
     */
    public int getShortcutKey(IndexShortcutKey index) {
        return mShortcutKey.getLsShortcutKeys().get(index.getId()).getKeyCode();
    }

    /**
     * Exibe o cardLayout que informar no parametro
     * {@link CardLayoutPDV#CARD_PDV} - Tela do PDV
     * {@link CardLayoutPDV#CARD_LOGIN} - Tela de login do PDV
     * @param cardLayoutPDV {@link CardLayoutPDV}
     */
    public void selectStartCardL(CardLayoutPDV cardLayoutPDV) {
        if (cardLayoutPDV.getNameCardLayout().equals(CARD_PDV.getNameCardLayout())) {
            // TELA DO PDV
            viewPDV.setStartCardL(cardLayoutPDV.getNameCardLayout());

        } else if (cardLayoutPDV.getNameCardLayout().equals(CARD_LOGIN.getNameCardLayout())) {
            // TELA DE LOGIN
            viewPDV.setStartCardL(cardLayoutPDV.getNameCardLayout());

        }
    }

    /**
     * Exibe o cardLayout que informar no parametro
     * {@link CardLayoutPDV#CARD_VENDA} - Painel de venda
     * {@link CardLayoutPDV#CARD_TROCO} - Painel de troco
     * {@link CardLayoutPDV#CARD_ITENS} - Painel de itens vendidos
     * {@link CardLayoutPDV#CARD_BUSCAR} - Painel de busca de produto
     * @param cardLayoutPDV {@link CardLayoutPDV}
     */
    public void selectSaleCardL(CardLayoutPDV cardLayoutPDV) {
        if (cardLayoutPDV.getNameCardLayout().equals(CARD_VENDA.getNameCardLayout())) {
            // PAINEL DE VENDA
            viewPDV.setSaleCardL(cardLayoutPDV.getNameCardLayout());
            viewPDV.setFocusFieldBarcode();

        } else if (cardLayoutPDV.getNameCardLayout().equals(CARD_TROCO.getNameCardLayout())) {
            // PAINEL DE TROCO
            viewPDV.setSaleCardL(cardLayoutPDV.getNameCardLayout());

        } else if (cardLayoutPDV.getNameCardLayout().equals(CARD_ITENS.getNameCardLayout())) {
            // PAINEL DE PRODUTOS BACK, LISTA DE PRODUTOS PARA CANCELAR

            int productsSold = 0;
            int rowsTableBack = viewPDV.getProductTableBack().getRowCount();
            for (int i = 0; i < rowsTableBack; i++) {
                // FAZ UMA VERIFICACAO DE QUANTOS PRODUTOS FORAM VENDIDOS, IGNORANDO OS CANCELADOS
                if (viewPDV.getProductTableBack().getValueAt(i, proBackCancellationColumn).equals("")) {
                    productsSold += 1;
                }
            }

            if (productsSold > 1) {
                viewPDV.setSaleCardL(cardLayoutPDV.getNameCardLayout());
                viewPDV.setFocusProductTableBack();
                viewPDV.getProductTableFront().changeSelection(rowsTableBack -1, 0, false, false);
                viewPDV.getProductTableBack().changeSelection(rowsTableBack -1, 0, false, false);

            } else if (productsSold == 1) {
                pPopUPConfirm.showConfirmDialog("CANCELAR ITEM!", "EXISTE APENAS UM ITEM, DESEJA CANCELAR O CUPOM?");
                if (pPopUPConfirm.questionResult()) {
                    cancelCurrentSale();
                }

            } else {
                pPopUPMessage.showAlert("CANCELAR ITEM!", "NÃO EXISTE ITEM PARA CANCELAR!");

            }

        } else if (cardLayoutPDV.getNameCardLayout().equals(CARD_BUSCAR.getNameCardLayout())) {
            // PAINEL DE BUSCAR PRODUTOS
            viewPDV.setSaleCardL(cardLayoutPDV.getNameCardLayout());
            viewPDV.setFocusFieldSearchProduct();

        }
    }

    /**
     * Exibe o cardLayout que informar no parametro
     * {@link CardLayoutPDV#CARD_VALOR_CUPOM} - Painel de valores do cupom
     * {@link CardLayoutPDV#CARD_VALOR_PRODUTO} - Painel de valores do produto
     * @param cardLayoutPDV {@link CardLayoutPDV}
     */
    public void selectValueCardL(CardLayoutPDV cardLayoutPDV) {
        if (cardLayoutPDV.getNameCardLayout().equals(CARD_VALOR_CUPOM.getNameCardLayout())) {
            if (viewPDV.getProductTableBack().getRowCount() > 0) {
                // EXECUTA APENAS SE JA EXISTIR ALGUM ITEM VENDIDO
                viewPDV.cleanTotalValueReceived();
                viewPDV.setTotalValueReceivable(Format.brCurrencyFormat.format(totalValueReceivable()));
                viewPDV.getPaymentMethodTable().clearSelection();

                viewPDV.setTotalCouponValue(Format.brCurrencyFormat.format(totalCouponValue()));

                boolean discount = totalDiscountProducts() > 0;
                viewPDV.setVisibleDiscountField(discount);
                viewPDV.setTotalDiscountValue((discount ? Format.brCurrencyFormat.format(totalDiscountProducts()) : ""));

                // PAINEL DE VALORES DO CUPOM
                viewPDV.setValueCardL(cardLayoutPDV.getNameCardLayout());

                // PAINEL DE FORMAS DE PAGAMENTO
                selectLogoCardL(CARD_FPAGAMENTO);

                viewPDV.setFocusableFieldTotalValueReceived(true);
                viewPDV.setFocusFieldTotalValueReceived();

            } else {
                pPopUPMessage.showAlert("ATENÇÃO!", "SEM VENDA PARA FINALIZAR!");
            }
        } else if (cardLayoutPDV.getNameCardLayout().equals(CARD_VALOR_PRODUTO.getNameCardLayout())) {
            // PAINEL DE VALORES DO PRODUTO
            viewPDV.setValueCardL(cardLayoutPDV.getNameCardLayout());

            // PAINEL DE LOGOTIPO
            selectLogoCardL(CARD_LOGO);
            viewPDV.setFocusableFieldBarcode(true);
            viewPDV.setFocusFieldBarcode();

        }
    }

    /**
     * Exibe o cardLayout que informar no parametro
     * {@link CardLayoutPDV#CARD_LOGO} - Painel de logotipo
     * {@link CardLayoutPDV#CARD_FPAGAMENTO} - Painel de formas de pagamento
     * {@link CardLayoutPDV#CARD_BOTONS_TOUCH} - Painel de botons touch
     * @param cardLayoutPDV {@link CardLayoutPDV}
     */
    public void selectLogoCardL(CardLayoutPDV cardLayoutPDV) {
        if (cardLayoutPDV.getNameCardLayout().equals(CARD_LOGO.getNameCardLayout())) {
            // PAINEL DE LOGOTIPO
            viewPDV.setLogoCardL(cardLayoutPDV.getNameCardLayout());

        } else if (cardLayoutPDV.getNameCardLayout().equals(CARD_FPAGAMENTO.getNameCardLayout())) {
            // PAINEL DE FORMAS DE PAGAMENTO
            viewPDV.setLogoCardL(cardLayoutPDV.getNameCardLayout());

        } else if (cardLayoutPDV.getNameCardLayout().equals(CARD_BOTONS_TOUCH.getNameCardLayout())) {
            // PAINEL DE BOTONS TOUCH
            viewPDV.setLogoCardL(cardLayoutPDV.getNameCardLayout());

        }
    }

    /**
     * Exibe o cardLayout de desconto
     * {@link CardLayoutPDV#CARD_DESCONTO} - Painel de informar desconto
     * @param cardLayoutPDV {@link CardLayoutPDV}
     */
    public void selectDiscountCardL(CardLayoutPDV cardLayoutPDV) {
        boolean totalProductIsVisible = viewPDV.getTotalProductIsVisible();
        boolean totalCouponIsVisible = viewPDV.getTotalCouponIsVisible();
        int productRows = viewPDV.getProductTableBack().getRowCount();
        int selectedRowFront = viewPDV.getProductTableFront().getSelectedRow();

        if (totalProductIsVisible & productRows > 0) {
            // DESCONTO NO PRODUTO
            double discountValue = Filter.filterDouble((String) viewPDV.getProductTableBack().getValueAt(selectedRowFront, proBackDiscountColumn));
            if (discountValue > 0) {
                pPopUPMessage.showAlert("ATENÇÃO!", "PRODUTO JÁ POSSUI DESCONTO!");
                return;
            }

            boolean productCanceled = !viewPDV.getProductTableBack().getValueAt(selectedRowFront, proBackCancellationColumn).equals("");
            if (!productCanceled) {
                cleanBasicFields();
                viewPDV.setDiscountDescription("DESCONTO NO ITEM");
                viewPDV.setLogoCardL(cardLayoutPDV.getNameCardLayout());
                viewPDV.setFocusFieldDiscountValue();
                viewPDV.setFocusableFieldBarcode(false);

            } else {
                pPopUPMessage.showAlert("ATENÇÃO!", "DESCONTO NÃO PERMITIDO EM PRODUTO CANCELADO!");

            }
        } else if (totalCouponIsVisible & productRows > 0) {
            // DESCONTO NO CUPOM
            cleanBasicFields();
            viewPDV.setDiscountDescription("DESCONTO NO CUPOM");
            viewPDV.setLogoCardL(cardLayoutPDV.getNameCardLayout());
            viewPDV.setFocusFieldDiscountValue();
            viewPDV.setFocusableFieldTotalValueReceived(false);
            System.out.println("DESCONTO NO CUPOM");

        }
    }

    /**
     * @param rowIndex int - Linha que deseja selecionar na JTable
     */
    public void selectPaymentMethod(int rowIndex) {
        viewPDV.getPaymentMethodTable().setRowSelectionInterval(rowIndex, rowIndex);
    }

    /**
     * Realiza a validacao do desconto informado para produto ou cupom, em valor e percentual
     */
    public void validateDiscount() {

        String fieldDiscountValue = viewPDV.getDiscountValue();
        String fieldDiscountPercentage = viewPDV.getDiscountPercentage();
        boolean totalProductIsVisible = viewPDV.getTotalProductIsVisible();
        boolean totalCouponIsVisible = viewPDV.getTotalCouponIsVisible();

        boolean discountValueIsFocusOwner = viewPDV.getDiscountValueIsFocusOwner();
        boolean discountPercentageIsFocusOwner = viewPDV.getDiscountPercentageIsFocusOwner();

        if (!fieldDiscountValue.equals("") & !fieldDiscountValue.equals(",") & fieldDiscountPercentage.equals("")) {
            System.out.println("TEM VALOR");
            if (totalProductIsVisible) {
                // DESCONTO NO PRODUTO
                double discountValue = Filter.filterDouble(fieldDiscountValue);
                if (discountValue > totalValueReceivable()){
                    pPopUPMessage.showAlert("DESCONTO NO ITEM!", "DESCONTO COM VALOR MAIOR QUE O TOTAL A RECEBER!");
                    return;
                } else if (discountValue == totalValueReceivable()) {
                    pPopUPMessage.showAlert("DESCONTO NO ITEM!", "DESCONTO COM VALOR IGUAL AO TOTAL A RECEBER!");
                    return;
                }

                int selectedRowFront = viewPDV.getProductTableFront().getSelectedRow();
                double totalValueProduct = Filter.filterDouble((String) viewPDV.getProductTableBack().getValueAt(selectedRowFront, proBackSubtotalColumn));
                if (discountValue > totalValueProduct) {
                    pPopUPMessage.showAlert("DESCONTO NO ITEM!", "DESCONTO COM VALOR MAIOR QUE O TOTAL DO ITEM!");
                    return;
                } else if (discountValue == totalValueProduct) {
                    pPopUPMessage.showAlert("DESCONTO NO ITEM!", "DESCONTO COM VALOR IGUAL AO VALOR TOTAL DO ITEM!");
                    return;
                } else if (discountValue == 0) {
                    pPopUPMessage.showAlert("DESCONTO NO ITEM!", "VALOR DE DESCONTO INVÁLIDO!");
                    viewPDV.cleanDiscountValue();
                    viewPDV.cleanDiscountPercentage();
                    return;
                }

                if (currentUserLevel < levelItemDiscount) {
                    // VALIDACAO DE NIVEL PARA REALIZAR DESCONTO NO ITEM
                    pPopUPUserPermission.showUserPermissionDialog(levelItemDiscount, "SOLICITAÇÃO DE SUPERVISOR", "DESCONTO NO ITEM");
                    if (!pPopUPUserPermission.getValidation()) {
                        return;
                    }
                }

                productDiscount(selectedRowFront, discountValue);

            } else if (totalCouponIsVisible) {
                // DESCONTO NO CUPOM
            }
        } else if (fieldDiscountValue.equals("") & !fieldDiscountPercentage.equals("")) {
            System.out.println("TEM PERCENTUAL");
            selectValueCardL(CARD_VALOR_CUPOM);
        } else if (!fieldDiscountValue.equals("") & !fieldDiscountPercentage.equals("")) {
            System.out.println("TEM VALOR E PERCENTUAL");
            viewPDV.cleanDiscountValue();
            viewPDV.cleanDiscountPercentage();
            viewPDV.setFocusFieldDiscountValue();
        } else if (fieldDiscountValue.equals("") & fieldDiscountPercentage.equals("") & discountValueIsFocusOwner) {
            System.out.println("NAO TEM NADA NO CAMPO VALOR");
            System.out.println("VAI PARA PERCENTUAL");
            viewPDV.setFocusFieldDiscountPercentage();
        } else if (fieldDiscountValue.equals("") & fieldDiscountPercentage.equals("") & discountPercentageIsFocusOwner) {
            System.out.println("NAO TEM NADA NO CAMPO PERCENTUAL");
            System.out.println("VAI PARA VALOR");
            viewPDV.setFocusFieldDiscountValue();
        }
    }

    /**
     * Realiza desconto no produto
     * @param selectedRowFront int - Linha do produto selecionado
     * @param discountValue double - Valor do desconto
     */
    private void productDiscount(int selectedRowFront, double discountValue) {
        // SETA O VALOR DO DESCONTO NA TABELA DE VENDA

        tmProductBack.getLs(selectedRowFront).setSupervisorID((currentUserLevel < levelItemDiscount ? pPopUPUserPermission.getUserId() : mUser.getId()));
        tmProductBack.setValueAt(discountValue, selectedRowFront, proBackDiscountColumn);
        viewPDV.setTotalValueProducts(Format.brCurrencyFormat.format(totalValueOfProducts()));

        tmProductFront.fireTableDataChanged();
        viewPDV.getProductTableFront().changeSelection(selectedRowFront, 0, false, false);

        selectValueCardL(CARD_VALOR_PRODUTO);
    }

    /**
     * @return double - Valor total do cupom sem os descontos
     */
    private double totalCouponValue() {
        return totalValueOfProducts() + totalDiscountProducts();
    }

    /**
     * @return double - Valor total de produtos vendidos
     */
    private double totalValueOfProducts() {
        double sum = 0, subtotal;
        int rows = viewPDV.getProductTableBack().getRowCount();

        for (int i = 0; i < rows; i++) {
            if (viewPDV.getProductTableBack().getValueAt(i, proBackCancellationColumn).equals("")){
                // SOMA O VALOR TOTAL DOS PRODUTOS VENDIDOS, IGNORANDO OS CANCELADOS
                subtotal = Filter.filterDouble((String) viewPDV.getProductTableBack().getValueAt(i, proBackSubtotalColumn));
                sum += subtotal;
            }
        }
        return sum;
    }

    /**
     * @return double - Valor total de desconto nos produtos
     */
    private double totalDiscountProducts() {
        double sum = 0, subtotal;
        int rows = viewPDV.getProductTableBack().getRowCount();

        for (int i = 0; i < rows; i++) {
            // SOMA O VALOR TOTAL DE DESCONTO DOS PRODUTOS
            subtotal = Filter.filterDouble((String) viewPDV.getProductTableBack().getValueAt(i, proBackDiscountColumn));
            sum += subtotal;
        }
        return sum;
    }

    /**
     * Subtrai o valor recebido e outros valores ja recebidos (caso existam).
     * @return double - Valor a receber
     */
    private double totalValueReceivable() {
        double totalAlreadyReceived;
        double totalCouponValue = totalValueOfProducts();
        String fieldValueReceived = viewPDV.getFieldTotalValueReceived();
        double valueReceived = !fieldValueReceived.equals("") ? Filter.filterDouble(fieldValueReceived) : 0;

        int rows = viewPDV.getPaymentReceivedTable().getRowCount();

        for (int i = 0; i < rows; i++) {
            totalAlreadyReceived = Filter.filterDouble((String) viewPDV.getPaymentReceivedTable().getValueAt(i, payReceivedValueColumn));
            totalCouponValue -= totalAlreadyReceived;
        }

        totalCouponValue -= valueReceived;

        return totalCouponValue;
    }

    /**
     * Metodo que define o foco no campo de senha do usuario
     */
    public void focusFieldPassword() {
        viewPDV.setFocusFieldPassword();
    }

    /**
     * Metodo que define o foco no campo de ID do usuario
     */
    public void focusFieldID() {
        viewPDV.setFocusFieldID();
    }

    /**
     * Metodo que define o foco no campo de codigo de barras
     */
    public void focusFieldBarCode() {
        viewPDV.setFocusFieldBarcode();
    }

    /**
     * Limpa toda a busca de produto
     */
    public void cleanAllProductSearch() {
        viewPDV.cleanProductSearch();
        productSearchFilter();
    }

    /**
     * Movimenta a linha da tabela
     */
    public void moveTableRow (int event) {
        int rows = 0, row = 0;

        boolean barcodeIsFocusOwner = viewPDV.getBarcodeIsFocusOwner();
        boolean searchProductIsFocusOwner = viewPDV.getSearchProductIsFocusOwner();

        if (barcodeIsFocusOwner) {
            // PRODUTO FRONT
            rows = viewPDV.getProductTableFront().getRowCount();
            row = viewPDV.getProductTableFront().getSelectedRow();
        } else if (searchProductIsFocusOwner) {
            // BUSCA DE PRODUTO
            rows = viewPDV.getProductSearchTable().getRowCount();
            row = viewPDV.getProductSearchTable().getSelectedRow();
        }

        if (event == KeyEvent.VK_UP & row > 0) {
            // SELECIONA A LINHA SUPERIOR
            (barcodeIsFocusOwner ? viewPDV.getProductTableFront() : viewPDV.getProductSearchTable())
                    .changeSelection(row - 1, 0, false, false);

        } else if (event == KeyEvent.VK_DOWN & (row + 1) < rows) {
            // SELECIONA A LINHA INFERIOR
            (barcodeIsFocusOwner ? viewPDV.getProductTableFront() : viewPDV.getProductSearchTable())
                    .changeSelection(row + 1, 0, false, false);
        }
    }

    /**
     * Valida e finaliza a venda
     */
    public void finalizeSale() {
        int moneyPaymentIndex = 0;
        int paymentMethodsMaximum = 2;
        int paymentSelectedRow  = viewPDV.getPaymentMethodTable().getSelectedRow();
        String fieldValueReceived = viewPDV.getFieldTotalValueReceived(); // VALOR RECEBIDO
        String fieldValueReceivable = viewPDV.getFieldTotalValueReceivable(); // VALOR A RECEBER

        if (paymentSelectedRow == -1) {
            pPopUPMessage.showAlert("ATENÇÃO!", "ESCOLHA UMA FORMA DE PAGAMENTO!");
            return;
        }

        if (fieldValueReceived.equals("")) {
            // VALOR RECEBIDO EH IGUAL AO VALOR DO CUPOM
            System.out.println("VALOR RECEBIDO IGUAL AO CUPOM");
            addPaymentReceived(Filter.filterDouble(fieldValueReceivable));
            viewPDV.getPaymentMethodTable().clearSelection();
            saveSale(save);
            newSale();

        } else {
            if (fieldValueReceived.equals(",") || Filter.filterDouble(fieldValueReceived) < 0.01) {
                pPopUPMessage.showAlert("ATENÇÃO!", "VALOR INVÁLIDO!");
                return;
            }

            double valueReceived = Filter.filterDouble(fieldValueReceived); // VALOR RECEBIDO
            double valueReceivable = Filter.filterDouble(fieldValueReceivable); // VALOR A RECEBER

            if (valueReceived == valueReceivable) {
                // VALOR RECEBIDO EH IGUAL AO VALOR A RECEBER
                System.out.println("VALOR RECEBIDO IGUAL");
                addPaymentReceived(valueReceivable);
                viewPDV.getPaymentMethodTable().clearSelection();
                saveSale(save);
                newSale();

            } else if (valueReceived < valueReceivable) {
                // VALOR RECEBIDO EH MENOR QUE O VALOR A RECEBER
                if (viewPDV.getPaymentReceivedTable().getRowCount() == paymentMethodsMaximum ) {
                    // VALIDACAO QUE PERMITE APENAS 3 FORMAS DE PAGAMENTO
                    pPopUPMessage.showAlert("ATENÇÃO, MÁXIMO DE 3 FORMAS DE PAGAMENTO!",
                            "INFORME UM VALOR ACIMA DE " + Format.brCurrencyFormat.format(valueReceivable));
                    return;
                }

                System.out.println("VALOR RECEBIDO MENOR");
                viewPDV.setTotalValueReceivable(Format.brCurrencyFormat.format(totalValueReceivable()));
                addPaymentReceived(valueReceived);
                viewPDV.getPaymentMethodTable().clearSelection();
                viewPDV.cleanTotalValueReceived();

            } else if (valueReceived > valueReceivable & paymentSelectedRow == moneyPaymentIndex) {
                // VALOR RECEBIDO EH MAIOR QUE O VALOR A RECEBER
                // VALOR MAIOR PERMITIDO APENAS PARA PAGAMENTO EM DINHEIRO
                System.out.println("VALOR RECEBIDO MAIOR");
                addPaymentReceived(valueReceivable);
                viewPDV.getPaymentMethodTable().clearSelection();
                viewPDV.setValueReceivableChange(Format.brCurrencyFormat.format(valueReceivable));
                viewPDV.setValueReceivedChange(Format.brCurrencyFormat.format(valueReceived));
                viewPDV.setChangeValue(Format.brCurrencyFormat.format(valueReceived - valueReceivable));
                selectSaleCardL(CARD_TROCO );
                viewPDV.setFocusFieldChangeValue();
                ChangeScreen changeScreen = new ChangeScreen(Integer.parseInt(viewPDV.getCurrentCouponID()));
                changeScreen.start();
                saveSale(save);

            } else {
                System.out.println("TROCO APENAS PARA DINHEIRO");
                pPopUPMessage.showAlert("ATENÇÃO!", "PERMITIDO TROCO APENAS PARA PAGAMENTO EM DINHEIRO!");

            }
        }
    }

    // Adiciona recebimento na tabela
    private void addPaymentReceived(double value) {
        PaymentMethod mPayment = new PaymentMethod();
        PaymentReceived mPaymentReceived = new PaymentReceived();

        int paymentRowSelected = viewPDV.getPaymentMethodTable().getSelectedRow();

        mPayment.setId(tmPayment.getLs(paymentRowSelected).getId());
        mPayment.setDescription(tmPayment.getLs(paymentRowSelected).getDescription());
        mPaymentReceived.setmPayment(mPayment);
        mPaymentReceived.setValue(value);

        tmPaymentReceived.addRow(mPaymentReceived);
    }

    /**
     * Cancela o produto selecionado na JTable back
     */
    public void cancelProduct() {

        int selectedRow = viewPDV.getProductTableBack().getSelectedRow();

        if (!viewPDV.getProductTableBack().getValueAt(selectedRow, proBackCancellationColumn).equals("")) {
            pPopUPMessage.showAlert("CANCELAR ITEM!", "PRODUTO JÁ ESTÁ CANCELADO!");
            return;
        }

        double subtotalToCancel = Filter.filterDouble((String) viewPDV.getProductTableBack().getValueAt(selectedRow, proBackSubtotalColumn));
        if (subtotalToCancel >= totalValueReceivable()){
            pPopUPMessage.showAlert("CANCELAR ITEM!", "PRODUTO COM VALOR MAIOR QUE O TOTAL A RECEBER!");
            return;
        }

        double discountValue = Filter.filterDouble((String) viewPDV.getProductTableBack().getValueAt(selectedRow, proBackDiscountColumn));
        if (discountValue > 0) {
            pPopUPConfirm.showConfirmDialog("ATENÇÃO!", "ITEM COM DESCONTO, TEM CERTEZA QUE DESEJA CANCELAR?");
            if (!pPopUPConfirm.questionResult()) {
                return;
            }
        }

        if (currentUserLevel < levelCancelProduct) {
            // VALIDACAO DE NIVEL PARA CANCELAR PRODUTO
            pPopUPUserPermission.showUserPermissionDialog(levelCancelProduct, "SOLICITAÇÃO DE SUPERVISOR", "CANCELAR PRODUTO");
            if (!pPopUPUserPermission.getValidation()) {
                return;
            }
        }

        tmProductBack.getLs(selectedRow).setSupervisorID((currentUserLevel < levelCancelProduct ? pPopUPUserPermission.getUserId() : mUser.getId()));
        tmProductBack.setValueAt(cancel, selectedRow, proBackCancellationColumn);
        tmProductBack.setValueAt(0.0, selectedRow, proBackDiscountColumn); //DEFINE VALOR DE DESCONTO = 0
        viewPDV.setTotalValueProducts(Format.brCurrencyFormat.format(totalValueOfProducts()));
        selectSaleCardL(CARD_VENDA);

        cleanBasicFields();

    }

    /**
     * Cancela a venda atual
     */
    public void cancelCurrentSale() {
        if (viewPDV.getProductTableBack().getRowCount() > 0) {
            // EXECUTA APENAS SE JA EXISTIR ALGUM ITEM VENDIDO

            if (currentUserLevel < levelCancelCurrentCoupon) {
                // VALIDACAO DE NIVEL PARA CANCELAR CUPOM ATUAL
                pPopUPUserPermission.showUserPermissionDialog(levelCancelCurrentCoupon, "SOLICITAÇÃO DE SUPERVISOR", "CANCELAR CUPOM ATUAL");
                if (!pPopUPUserPermission.getValidation()) {
                    return;
                }
            }

            // QUANTIDADE DE PRODUTOS VENDIDOS
            int productRows = viewPDV.getProductTableBack().getRowCount();
            for (int i = 0; i < productRows; i++) {
                // ATRIBUI O ID DE QUEM CANCELOU O CUPOM EM TODOS OS PRODUTOS
                tmProductBack.getLs(i).setSupervisorID((currentUserLevel < levelCancelCurrentCoupon ? pPopUPUserPermission.getUserId() : mUser.getId()));
            }

            saveSale(cancel);
            newSale();

        } else {
            pPopUPMessage.showAlert("CANCELAR CUPOM ATUAL", "NÃO EXISTE CUPOM PARA CANCELAR!");
        }
    }

    // Salva ou cancela a venda atual
    private void saveSale(boolean saveOrCancel) {
        CompanyBR mCompanyBR = new CompanyBR();
        mProduct = new Product();
        mCoupon = new Coupon();

        // QUANTIDADE DE FORMAS DE PAGAMENTO UTILIZADAS
        int payments = viewPDV.getPaymentReceivedTable().getRowCount();

        mCompanyBR.setId(companyID);
        mCoupon.setmCompany(mCompanyBR);
        mPDV.setId(pdvID);
        mCoupon.setmPDV(mPDV);
        mCoupon.setFormOfPayment1((payments >= 1) ? tmPaymentReceived.getLs(0).getmPayment().getId() : 0);
        mCoupon.setPaymentAmount1((payments >= 1) ? tmPaymentReceived.getLs(0).getValue() : 0);
        mCoupon.setFormOfPayment2((payments >= 2) ? tmPaymentReceived.getLs(1).getmPayment().getId() : 0);
        mCoupon.setPaymentAmount2((payments >= 2) ? tmPaymentReceived.getLs(1).getValue() : 0);
        mCoupon.setFormOfPayment3((payments == 3) ? tmPaymentReceived.getLs(2).getmPayment().getId() : 0);
        mCoupon.setPaymentAmount3((payments == 3) ? tmPaymentReceived.getLs(2).getValue() : 0);
        mCoupon.setTotalCouponValue(Filter.filterDouble(viewPDV.getTotal()));
        mCoupon.setTotalDiscount(totalDiscountProducts());
        mCoupon.setmUser(mUser);
        mCoupon.setSupervisorID((saveOrCancel ? (currentUserLevel < levelCancelCurrentCoupon ? pPopUPUserPermission.getUserId() : mUser.getId()) : 0));
        mCoupon.setCouponCanceled(saveOrCancel);
        mCoupon.setDate(Date.valueOf(Format.DFDATE.format(System.currentTimeMillis())));
        mCoupon.setHour(Time.valueOf(Format.DFTIME.format(System.currentTimeMillis())));
        mCoupon.setCouponStatus(false); // PENDENTE DE IMPLEMENTACAO
        mCoupon.setTable(0); // PENDENTE DE IMPLEMENTACAO
        // SALVA A VENDA DO CUPOM
        dCoupon.saveSaleCoupon(mCoupon);

        saveProduct(saveOrCancel);
    }

    // Gravar os produtos do cupom
    private void saveProduct(boolean saveOrCancel) {
        CompanyBR mCompanyBR = new CompanyBR();
        List<Coupon> lsCoupon = new ArrayList<>();

        // QUANTIDADE DE PRODUTOS VENDIDOS
        int productRows = viewPDV.getProductTableBack().getRowCount();

        for (int i = 0; i < productRows; i++) {
            mProduct = new Product();
            Unit mUnit = new Unit();
            mCoupon = new Coupon();

            mCompanyBR.setId(companyID);
            mCoupon.setmCompany(mCompanyBR);
            mPDV.setId(pdvID);
            mCoupon.setmPDV(mPDV);
            mCoupon.setCoupon(Integer.parseInt(viewPDV.getCurrentCouponID()));
            mUnit.setId(tmProductBack.getLs(i).getmProduct().getmUnits().getId());
            mUnit.setDescription(tmProductBack.getLs(i).getmProduct().getmUnits().getDescription());
            mProduct.setmUnits(mUnit);
            mProduct.setId(tmProductBack.getLs(i).getmProduct().getId());
            mProduct.setDescriptionCoupon(tmProductBack.getLs(i).getmProduct().getDescriptionCoupon());
            mProduct.setBarcode(tmProductBack.getLs(i).getmProduct().getBarcode());
            mProduct.setSalePrice(tmProductBack.getLs(i).getmProduct().getSalePrice());
            mCoupon.setmProduct(mProduct);
            mCoupon.setQuantity(tmProductBack.getLs(i).getQuantity());
            //mCoupon.setTotalProductValue(tmProductBack.getLs(i).getTotalProductValue()); ATE O MOMENTO, ESSA LINHA EH DISPENSAVEL
            mCoupon.setTotalProductDiscount(tmProductBack.getLs(i).getTotalProductDiscount());
            mCoupon.setmUser(mUser);
            mCoupon.setSupervisorID(tmProductBack.getLs(i).getSupervisorID());
            mCoupon.setProductCanceled((tmProductBack.getLs(i).isProductCanceled() || saveOrCancel));
            mCoupon.setDate(Date.valueOf(Format.DFDATE.format(System.currentTimeMillis())));
            mCoupon.setHour(Time.valueOf(Format.DFTIME.format(System.currentTimeMillis())));
            mCoupon.setCouponStatus(false); // PENDENTE DE IMPLEMENTACAO
            mCoupon.setTable(0); // PENDENTE DE IMPLEMENTACAO

            lsCoupon.add(mCoupon);
        }

        dCoupon.saveCouponProducts(lsCoupon);
    }

    /**
     * Sai da tela de desconto
     */
    public void exitDiscount() {
        boolean totalProductIsVisible = viewPDV.getTotalProductIsVisible();
        boolean totalCouponIsVisible = viewPDV.getTotalCouponIsVisible();
        if (totalProductIsVisible) {
            // VOLTA PARA A TELA DE INSERIR PRODUTO
            selectValueCardL(CARD_VALOR_PRODUTO);
        } else if (totalCouponIsVisible) {
            // VOLTA PARA A TELA DE FINALIZAR CUPOM
            selectValueCardL(CARD_VALOR_CUPOM);
        }
    }
}