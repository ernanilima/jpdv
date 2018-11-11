package br.com.ernanilima.jpdv.Presenter;

import br.com.ernanilima.jpdv.Controller.ProductRenderer;
import br.com.ernanilima.jpdv.Dao.ProductDao;
import br.com.ernanilima.jpdv.Dao.ShortcutKeyDao;
import br.com.ernanilima.jpdv.Model.*;
import br.com.ernanilima.jpdv.Model.Enum.IndexShortcutKey;
import br.com.ernanilima.jpdv.Model.TableModel.ProductTableModel;
import br.com.ernanilima.jpdv.Util.*;
import br.com.ernanilima.jpdv.Dao.UserDao;
import br.com.ernanilima.jpdv.Presenter.Listener.ViewPDVActionListener;
import br.com.ernanilima.jpdv.Presenter.Listener.ViewPDVKeyListener;
import br.com.ernanilima.jpdv.View.Enum.CardLayoutPDV;
import br.com.ernanilima.jpdv.View.IViewPDV;
import br.com.ernanilima.jpdv.View.ViewPDV;

import static br.com.ernanilima.jpdv.View.Enum.CardLayoutPDV.*;

/**
 * Presenter da ViewPDV
 *
 * @author Ernani Lima
 */
public class PDVPresenter {

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
    private final Product mProduct;

    // Model de cupom
    private Coupon mCoupon;

    // Model teclas de atalho
    private final ShortcutKey mShortcutKey;

    // Table Model de intens vendidos
    private final ProductTableModel tmProduct;

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
        this.tmProduct = new ProductTableModel();
        this.myTables();
        this.myListiners();
        this.myFilters();
        this.myShortcutKey();
        this.viewPDV.setBackgroundLogin(Background.getBackgroundCenter(mBg.getPathBgPDVLogin()));
        this.viewPDV.packAndShow();
    }

    // Minhas JTables
    private void myTables() {
        this.viewPDV.getTableProduct().setModel(tmProduct);
        this.viewPDV.getTableProduct().setDefaultRenderer(Object.class, new ProductRenderer());
    }

    // Gera lista de teclas de atalho
    private void myShortcutKey() {
        ShortcutKeyDao dShortcutKey = new ShortcutKeyDao();
        this.mShortcutKey.setLsShortcutKeys(dShortcutKey.listShortcutKeys());
    }

    // Listiner de "Botons", "Campos" e outros.
    private void myListiners() {
        this.viewPDV.setLoginActionPerformed(new ViewPDVActionListener.LoginUserActionListener(this));
        this.viewPDV.setExitActionPerformed(new ViewPDVActionListener.ExitActionListener(this));
        this.viewPDV.setFieldIDKeyPressed(new ViewPDVKeyListener.FieldIDKeyListener(this));
        this.viewPDV.setFieldPasswordKeyPressed(new ViewPDVKeyListener.FieldPassqordKeyListener(this));
        this.viewPDV.setFieldBarcodeKeyPressed(new ViewPDVKeyListener.FieldBarcodeKeyListener(this));
    }

    // Metodo que gerencia os campos do ViewPDV
    private void myFilters() {
        this.viewPDV.setFieldBarcodeDocument(new FieldManager.FieldFilterInt(14));
        this.viewPDV.setFieldIDDocument(new FieldManager.FieldFilterInt(3));
    }

    /**
     * Metodo que realiza a validacao de login do usuario ou do suporte tecnico
     */
    public void userLogin() {
        this.id = viewPDV.getIdUser();
        this.password = Encrypt.sha256(viewPDV.getPassword());

        if (id.equals("")) {
            System.out.println("INFORME O CODIGO DO OPERADOR!");
            this.pPopUPMessage.showAlert("Atenção", "Informe o código do usuário!");
            this.focusFieldID();
        } else if (password.equals("")) {
            System.out.println("INFORME A SENHA DO OPERADOR!");
            this.pPopUPMessage.showAlert("Atenção", "Informe a senha do usuário!");
            this.focusFieldPassword();
        } else if (Integer.parseInt(id) == (mSupport.getId()) & password.equals(mSupport.getPwd())) {
            System.out.println("LOGIN DO SUPORTE TECNICO!");
            this.pPopUPMessage.showAlert("ALERTA", "Login do Suporte!");
        } else {
            this.mUser.setId(Integer.parseInt(id));
            this.mUser.setPwd(password);

            if (dUser.userLogin(mUser)) {
                System.out.println("LOGIN REALIZADO!");
                this.cardsPDV(CARD_PDV);
                this.focusFieldBarCode();
            } else {
                System.out.println("Dados incorretos ou usuário não cadastrado!");
                this.pPopUPMessage.showAlert("Atenção", "Dados incorretos ou usuário não cadastrado!");
                this.focusFieldID();
            }
        }
    }

    /**
     * Metodo que fecha o sistema do PDV.
     * O metodo exibe um Dialog de confirmacao para fechar a tela do PDV.
     */
    public void exitPDV() {
        this.pPopUPConfirm.showConfirmDialog("Atenção", "Deseja sair do sistema?");
        if (this.pPopUPConfirm.questionResult()) {
            System.exit(0);
        }
    }

    /**
     * Metodo que realiza a busca de produto pelo seu codigo de barras
     */
    public void searchProduct() {
        if (!this.viewPDV.getBarcode().equals("")) {
            // Realiza a busca se o campo de codigo de barras for diferente de vazio

            mCoupon = new Coupon();

            this.mProduct.setBarcode(Long.parseLong(viewPDV.getBarcode()));
            this.mCoupon.setmProduct(mProduct);

            if (dProduct.searchProductByBarcode(mCoupon)) {
                this.mCoupon.setQuantity(1);
                this.mCoupon.setProductRowIndex(viewPDV.getTableProduct().getRowCount()+1);
                this.tmProduct.addRow(mCoupon);
                viewPDV.getTableProduct().changeSelection(viewPDV.getTableProduct().getRowCount()-1, 0, false, false);
                System.out.println("PRODUTO: " + mCoupon.getmProduct().getDescriptionCoupon());
                this.viewPDV.cleanFieldBarcode();
            } else {
                // Exibe um alerta caso o produto nao seja encontrado
                System.out.println("PRODUTO NAO ENCONTRADO");
                this.pPopUPMessage.showAlert("ATENÇÃO!", "PRODUTO NÃO ENCONTRADO!");
                this.viewPDV.cleanFieldBarcode();
            }
        } else {
            // Exibe uma mensagem de alerta caso o campo de codigo de barras esteja vazio
            System.out.println("INFORME O CODIGO DE BARRAS");
            this.pPopUPMessage.showAlert("ATENÇÃO!", "INFORME O CÓDIGO DE BARRAS!");
            this.viewPDV.cleanFieldBarcode();
        }
    }

    /**
     * Metodo que retorna o Model de tecla de atalho
     * @param index {@link IndexShortcutKey} - index da tecla de atalho no lista
     * @return int - KeyCode da tecla de atalho
     */
    public int getShortcutKey(IndexShortcutKey index) {
        return this.mShortcutKey.getLsShortcutKeys().get(index.getId()).getKeyCode();
    }

    /**
     * @param cardLayoutPDV {@link CardLayoutPDV} - CardLayout que sera exibido
     */
    public void cardsPDV(CardLayoutPDV cardLayoutPDV) {

        if (cardLayoutPDV.getNameCardLayout().equals(CARD_PDV.getNameCardLayout())) {
            System.out.println("TELA DO PDV");
            this.viewPDV.setCardPDV(cardLayoutPDV.getNameCardLayout());
        } else if (cardLayoutPDV.getNameCardLayout().equals(CARD_LOGIN.getNameCardLayout())) {
            System.out.println("TELA DE LOGIN");
            this.viewPDV.setCardPDV(cardLayoutPDV.getNameCardLayout());
        } else if (cardLayoutPDV.getNameCardLayout().equals(CARD_VENDA.getNameCardLayout())) {
            System.out.println("TELA DE VENDA");
            this.viewPDV.setCardPDVVendas(cardLayoutPDV.getNameCardLayout());
        } else if (cardLayoutPDV.getNameCardLayout().equals(CARD_TROCO.getNameCardLayout())) {
            System.out.println("TELA DE TROCO");
            this.viewPDV.setCardPDVVendas(cardLayoutPDV.getNameCardLayout());
        } else if (cardLayoutPDV.getNameCardLayout().equals(CARD_ITENS.getNameCardLayout())) {
            System.out.println("TELA DE ITENS VENDIDOS");
            this.viewPDV.setCardPDVVendas(cardLayoutPDV.getNameCardLayout());
        } else if (cardLayoutPDV.getNameCardLayout().equals(CARD_BUSCAR.getNameCardLayout())) {
            System.out.println("TELA DE BUSCAR PRODUTOS");
            this.viewPDV.setCardPDVVendas(cardLayoutPDV.getNameCardLayout());
        } else if (cardLayoutPDV.getNameCardLayout().equals(CARD_VALOR_CUPOM.getNameCardLayout())) {
            System.out.println("TELA DE FINALIZAR VENDA");
            this.viewPDV.setCardPDVValores(cardLayoutPDV.getNameCardLayout());
            this.viewPDV.setCardPDVLogo(CARD_FPAGAMENTO.getNameCardLayout());
        } else if (cardLayoutPDV.getNameCardLayout().equals(CARD_VALOR_PRODUTO.getNameCardLayout())) {
            System.out.println("TELA DE VALORES DOS PRODUTOS");
            this.viewPDV.setCardPDVValores(cardLayoutPDV.getNameCardLayout());
            this.viewPDV.setCardPDVLogo(CARD_LOGO.getNameCardLayout());
        } else if (cardLayoutPDV.getNameCardLayout().equals(CARD_DESCONTO.getNameCardLayout())) {
            System.out.println("TELA DE DESCONTO");
            this.viewPDV.setCardPDVLogo(cardLayoutPDV.getNameCardLayout());
        } else if (cardLayoutPDV.getNameCardLayout().equals(CARD_BOTONS_TOUCH.getNameCardLayout())) {
            System.out.println("TELA DE BOTONS TOUCH");
            this.viewPDV.setCardPDVLogo(cardLayoutPDV.getNameCardLayout());
        }
    }

    /**
     * Metodo que define o foco no campo de senha do usuario
     */
    public void focusFieldPassword() {
        this.viewPDV.setFocusFieldPassword();
    }

    /**
     * Metodo que define o foco no campo de ID do usuario
     */
    public void focusFieldID() {
        this.viewPDV.setFocusFieldID();
    }

    /**
     * Metodo que define o foco no campo de codigo de barras
     */
    public void focusFieldBarCode() {
        this.viewPDV.setFocusFieldBarcode();
    }
}