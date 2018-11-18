package br.com.ernanilima.jpdv.Presenter;

import br.com.ernanilima.jpdv.Controller.PaymentRenderer;
import br.com.ernanilima.jpdv.Controller.ProductBackRenderer;
import br.com.ernanilima.jpdv.Controller.ProductFrontRenderer;
import br.com.ernanilima.jpdv.Controller.ProductSearchRenderer;
import br.com.ernanilima.jpdv.Dao.PaymentDao;
import br.com.ernanilima.jpdv.Dao.ProductDao;
import br.com.ernanilima.jpdv.Dao.ShortcutKeyDao;
import br.com.ernanilima.jpdv.Model.*;
import br.com.ernanilima.jpdv.Model.Enum.IndexShortcutKey;
import br.com.ernanilima.jpdv.Model.TableModel.PaymentTableModel;
import br.com.ernanilima.jpdv.Model.TableModel.ProductBackTableModel;
import br.com.ernanilima.jpdv.Model.TableModel.ProductFrontTableModel;
import br.com.ernanilima.jpdv.Model.TableModel.ProductSearchTableModel;
import br.com.ernanilima.jpdv.Util.*;
import br.com.ernanilima.jpdv.Dao.UserDao;
import br.com.ernanilima.jpdv.Presenter.Listener.ViewPDVActionListener;
import br.com.ernanilima.jpdv.Presenter.Listener.ViewPDVKeyListener;
import br.com.ernanilima.jpdv.View.Enum.CardLayoutPDV;
import br.com.ernanilima.jpdv.View.IViewPDV;
import br.com.ernanilima.jpdv.View.ViewPDV;

import javax.swing.*;
import javax.swing.table.TableRowSorter;

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

    // Model de produto
    private Product mProduct;

    // Model de cupom
    private Coupon mCoupon;

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
    private final PaymentTableModel tmPayment;

    private String id;
    private String password;

    // Construtor
    public PDVPresenter() {
        this.viewPDV = new ViewPDV();
        this.pPopUPMessage = new PopUPMessageDialogPresenter();
        this.pPopUPConfirm = new PopUPConfirmDialogPresenter();
        this.mUser = new User();
        this.mSupport = new Support();
        this.mBg = new Backgrounds();
        this.dUser = new UserDao();
        this.dProduct = new ProductDao();
        this.mProduct = new Product();
        this.mCoupon = new Coupon();
        this.mShortcutKey = new ShortcutKey();
        this.tmProductFront = new ProductFrontTableModel();
        this.tmProductBack = new ProductBackTableModel();
        this.tmProductSearch = new ProductSearchTableModel();
        this.trsProductSearch = new TableRowSorter<>(tmProductSearch);
        this.tmPayment = new PaymentTableModel();
        this.myTables();
        this.fillProductSearchTable();
        this.fillPaymentMethodTable();
        this.myListiners();
        this.myFilters();
        this.myShortcutKey();
        this.viewPDV.setBackgroundLogin(Background.getBackgroundCenter(mBg.getPathBgPDVLogin()));
        this.viewPDV.setQuantity(Format.formatQty.format(1));
        this.viewPDV.packAndShow();
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
        viewPDV.getPaymentMethodTable().setDefaultRenderer(Object.class, new PaymentRenderer());
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
        PaymentDao dPayment = new PaymentDao();
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
        viewPDV.setFieldTotalValueReceivedKeyPressed(new ViewPDVKeyListener.FieldTotalValueReceivedKeyListener(this));
        viewPDV.setFieldDiscountValueKeyPressed(new ViewPDVKeyListener.FieldDiscountValueKeyListener(this));
        viewPDV.setFieldDiscountPercentageKeyPressed(new ViewPDVKeyListener.FieldDiscountPercentageKeyListener(this));
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
    }

    /**
     * Metodo que realiza a validacao de login do usuario ou do suporte tecnico
     */
    public void userLogin() {
        id = viewPDV.getIdUser();
        password = Encrypt.sha256(viewPDV.getPassword());

        if (id.equals("")) {
            System.out.println("INFORME O CODIGO DO OPERADOR!");
            pPopUPMessage.showAlert("Atenção", "Informe o código do usuário!");
            focusFieldID();
        } else if (password.equals("")) {
            System.out.println("INFORME A SENHA DO OPERADOR!");
            pPopUPMessage.showAlert("Atenção", "Informe a senha do usuário!");
            focusFieldPassword();
        } else if (Integer.parseInt(id) == (mSupport.getId()) & password.equals(mSupport.getPwd())) {
            System.out.println("LOGIN DO SUPORTE TECNICO!");
            pPopUPMessage.showAlert("ALERTA", "Login do Suporte!");
        } else {
            mUser.setId(Integer.parseInt(id));
            mUser.setPwd(password);

            if (dUser.userLogin(mUser)) {
                System.out.println("LOGIN REALIZADO!");
                selectStartCardL(CARD_PDV);
                focusFieldBarCode();
            } else {
                System.out.println("Dados incorretos ou usuário não cadastrado!");
                pPopUPMessage.showAlert("Atenção", "Dados incorretos ou usuário não cadastrado!");
                focusFieldID();
            }
        }
    }

    /**
     * Metodo que fecha o sistema do PDV.
     * O metodo exibe um Dialog de confirmacao para fechar a tela do PDV.
     */
    public void exitPDV() {
        pPopUPConfirm.showConfirmDialog("Atenção", "Deseja sair do sistema?");
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
        if (selectedRow != -1) {
            mProduct = tmProductSearch.getLs(viewPDV.getProductSearchTable().convertRowIndexToModel(selectedRow));
            searchProduct(mProduct);
            selectSaleCardL(CardLayoutPDV.CARD_VENDA);
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
            viewPDV.setTotalCouponValue(Format.brCurrencyFormat.format(totalValueOfProducts()));
            System.out.println("PRODUTO: " + mCoupon.getmProduct().getDescriptionCoupon());
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
        if (!viewPDV.getBarcode().equals("")) {
            // Executa se o campo de codigo de barras nao estiver vazio
            double qtyPDV = Double.parseDouble(viewPDV.getBarcode());
            if ( qtyPDV >= minQty & qtyPDV <= maxQty ) {
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
            // PAINEL DE PRODUTOS BACK
            viewPDV.setSaleCardL(cardLayoutPDV.getNameCardLayout());
            viewPDV.setFocusProductTableBack();
            viewPDV.getProductTableFront().changeSelection(viewPDV.getProductTableFront().getRowCount()-1, 0, false, false);
            viewPDV.getProductTableBack().changeSelection(viewPDV.getProductTableBack().getRowCount()-1, 0, false, false);

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
                // PAINEL DE VALORES DO CUPOM
                viewPDV.setValueCardL(cardLayoutPDV.getNameCardLayout());

                // PAINEL DE FORMAS DE PAGAMENTO
                viewPDV.setLogoCardL(CARD_FPAGAMENTO.getNameCardLayout());

                viewPDV.setFocusableFieldTotalValueReceived(true);
                viewPDV.setFocusFieldTotalValueReceived();

            } else {
                pPopUPMessage.showAlert("ATENÇÃO!", "SEM VENDA PARA FINALIZAR!");
            }
        } else if (cardLayoutPDV.getNameCardLayout().equals(CARD_VALOR_PRODUTO.getNameCardLayout())) {
            // PAINEL DE VALORES DO PRODUTO
            viewPDV.setValueCardL(cardLayoutPDV.getNameCardLayout());

            // PAINEL DE LOGOTIPO
            viewPDV.setLogoCardL(CARD_LOGO.getNameCardLayout());
            viewPDV.setFocusableFieldBarcode(true);
            viewPDV.setFocusFieldBarcode();

        }
    }

    /**
     * Exibe o cardLayout que informar no parametro
     * {@link CardLayoutPDV#CARD_LOGO} - Painel de logotipo
     * {@link CardLayoutPDV#CARD_FPAGAMENTO} - Painel de formas de pagamento
     * {@link CardLayoutPDV#CARD_DESCONTO} - Painel de informar desconto
     * {@link CardLayoutPDV#CARD_BOTONS_TOUCH} - Painel de botons touch
     * @param cardLayoutPDV {@link CardLayoutPDV}
     */
    public void selectLogoCardL(CardLayoutPDV cardLayoutPDV) {
        if (cardLayoutPDV.getNameCardLayout().equals(CARD_LOGO.getNameCardLayout())) {
            // PAINEL DE LOGOTIPO
            viewPDV.setLogoCardL(CARD_LOGO.getNameCardLayout());
        } else if (cardLayoutPDV.getNameCardLayout().equals(CARD_FPAGAMENTO.getNameCardLayout())) {
            // PAINEL DE FORMAS DE PAGAMENTO
            viewPDV.setLogoCardL(CARD_FPAGAMENTO.getNameCardLayout());

        } else if (cardLayoutPDV.getNameCardLayout().equals(CARD_DESCONTO.getNameCardLayout())) {
            // PAINEL DE DESCONTO
            viewPDV.setLogoCardL(cardLayoutPDV.getNameCardLayout());
            viewPDV.setFocusFieldDiscountValue();
            viewPDV.setFocusableFieldTotalValueReceived(false);
            viewPDV.setFocusableFieldBarcode(false);

        } else if (cardLayoutPDV.getNameCardLayout().equals(CARD_BOTONS_TOUCH.getNameCardLayout())) {
            // PAINEL DE BOTONS TOUCH
            viewPDV.setLogoCardL(cardLayoutPDV.getNameCardLayout());

        }
    }

    /**
     * Cancela produto selecionado na JTable back
     */
    public void cancelProduct() {
        System.out.println("CANCELAR PRODUTO");
        selectSaleCardL(CardLayoutPDV.CARD_VENDA);
    }

    /**
     * Metodo que verifica o desconto informado para o produto ou para o cupom
     * @param focus int - 1 Foco desconto valor / 2 Foco desconto percentual
     */
    public void validateDiscount(int focus) {

        String discountValue = viewPDV.getDiscountValue();
        String discountPercentage = viewPDV.getDiscountPercentage();

        if (!discountValue.equals("") & discountPercentage.equals("")) {
            System.out.println("TEM VALOR");
            selectValueCardL(CardLayoutPDV.CARD_VALOR_CUPOM);
        } else if (discountValue.equals("") & !discountPercentage.equals("")) {
            System.out.println("TEM PERCENTUAL");
            selectValueCardL(CardLayoutPDV.CARD_VALOR_CUPOM);
        } else if (!discountValue.equals("") & !discountPercentage.equals("")) {
            System.out.println("TEM VALOR E PERCENTUAL");
            viewPDV.cleanDiscountValue();
            viewPDV.cleanDiscountPercentage();
            viewPDV.setFocusFieldDiscountValue();
        } else if (discountValue.equals("") & discountPercentage.equals("") & focus == 1) {
            System.out.println("NAO TEM NADA");
            System.out.println("VAI PARA PERCENTUAL");
            viewPDV.setFocusFieldDiscountPercentage();
        } else if (discountValue.equals("") & discountPercentage.equals("") & focus == 2) {
            System.out.println("NAO TEM NADA");
            System.out.println("VAI PARA VALOR");
            viewPDV.setFocusFieldDiscountValue();
        }
    }

    /**
     * Valor total de produtos vendidos
     */
    private float totalValueOfProducts() {
        float sum = 0, subtotal;
        int rows = viewPDV.getProductTableBack().getRowCount();
        int column = viewPDV.getProductTableBack().getColumnCount() - 2; // Coluna de subtotal de cada produto

        for (int i = 0; i < rows; i++) {
            subtotal = Filter.filterFloat((String) viewPDV.getProductTableBack().getValueAt(i, column));
            sum += subtotal;
        }
        return sum;
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
     * Movimenta a linha da tabela
     * @param move int - 1=UP / 0=DOWN
     */
    public void moveTableRow(int move) {
        int rows = viewPDV.getProductSearchTable().getRowCount();
        int row = viewPDV.getProductSearchTable().getSelectedRow();

        if (move == 1 & row > 0) {
            // SELECIONA A LINHA SUPERIOR
            viewPDV.getProductSearchTable().changeSelection(row - 1, 0, false, false);

        } else if (move == 0 & (row + 1) < rows) {
            // SELECIONA A LINHA INFERIOR
            viewPDV.getProductSearchTable().changeSelection(row + 1, 0, false, false);
        }
    }
}