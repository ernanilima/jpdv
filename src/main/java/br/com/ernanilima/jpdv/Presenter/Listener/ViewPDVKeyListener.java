package br.com.ernanilima.jpdv.Presenter.Listener;

import br.com.ernanilima.jpdv.Model.Enum.IndexShortcutKey;
import br.com.ernanilima.jpdv.Presenter.PDVPresenter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static br.com.ernanilima.jpdv.View.Enum.CardLayoutPDV.*;

/**
 * Classe que escuta teclas precionadas na {@link br.com.ernanilima.jpdv.View.ViewPDV}
 *
 * @author Ernani Lima
 */
public class ViewPDVKeyListener {

    /**
     * Ao precionar "ENTER", define foco no campo de senha do usuario.
     */
    public static class FieldIDKeyListener extends KeyAdapter {
        private final PDVPresenter presenter;

        /**
         * @param presenter {@link PDVPresenter} - Classe presenter da {@link br.com.ernanilima.jpdv.View.ViewPDV}.
         */
        public FieldIDKeyListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                presenter.focusFieldPassword();
            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
                presenter.exitPDV();
            }
        }
    }

    /**
     * Ao precionar "ENTER", executa o metodo "{@link PDVPresenter#userLogin()}".
     * que realiza a validacao de login do usuario ou do suporte tecnico.
     */
    public static class FieldPassqordKeyListener extends KeyAdapter {
        private final PDVPresenter presenter;

        /**
         * @param presenter {@link PDVPresenter} - Classe presenter da {@link br.com.ernanilima.jpdv.View.ViewPDV}.
         */
        public FieldPassqordKeyListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                presenter.userLogin();
            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
                presenter.exitPDV();
            }
        }
    }

    /**
     * Escuta as teclas precionadas no campo de "codigo de barras".
     */
    public static class FieldBarcodeKeyListener extends KeyAdapter {
        private final PDVPresenter presenter;

        /**
         * @param presenter {@link PDVPresenter} - Classe presenter da {@link br.com.ernanilima.jpdv.View.ViewPDV}.
         */
        public FieldBarcodeKeyListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                // Executa o metodo que busca o produto por codigo de barras
                presenter.productFromBarcodeField();

            } else if (e.getKeyCode() == presenter.getShortcutKey(IndexShortcutKey.TOTALIZE)){
                // Tela para finalizar a venda
                presenter.selectValueCardL(CARD_VALOR_CUPOM);

            } else if (e.getKeyCode() == presenter.getShortcutKey(IndexShortcutKey.CANCEL_GENERIC_PRODUCT)) {
                // Cancela produto generico
                presenter.selectSaleCardL(CARD_ITENS);

            } else if (e.getKeyCode() == presenter.getShortcutKey(IndexShortcutKey.CANCEL_LAST_PRODUCT)) {
                // Cancela ultimo produto
                System.out.println("CANCELA ULTIMO PRODUTO");

            } else if (e.getKeyCode() == presenter.getShortcutKey(IndexShortcutKey.CANCEL_CURRENT_SALE)) {
                // Cancela venda atual
                presenter.cancelCurrentSale();

            } else if (e.getKeyCode() == presenter.getShortcutKey(IndexShortcutKey.CANCEL_LAST_SALE)) {
                // Cancela ultima venda
                System.out.println("CANCELA ULTIMA VENDA");

            } else if (e.getKeyCode() == presenter.getShortcutKey(IndexShortcutKey.DISCOUNT_ON_PRODUCT)) {
                // Desconto do produto
                presenter.selectDiscountCardL(CARD_DESCONTO);

            } else if (e.getKeyCode() == presenter.getShortcutKey(IndexShortcutKey.REPEAT_LAST_PRODUCT)) {
                // Repetir ultimo produto inserido
                System.out.println("REPETIR ULTIMO PRODUTO");

            } else if (e.getKeyCode() == presenter.getShortcutKey(IndexShortcutKey.QUANTITY)) {
                // Alterar a quantidade a ser vendida
                presenter.newQuantity();

            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                // Exibe mensagem para voltar para a tela de login
                presenter.loginScreen();

            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                // MOVE PARA A LINHA SUPERIOR NA TABELA DE PRODUTOS VENDIDOS
                presenter.moveTableRow(KeyEvent.VK_UP);

            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                // MOVE PARA A LINHA INFERIOR NA TABELA DE PRODUTOS VENDIDOS
                presenter.moveTableRow(KeyEvent.VK_DOWN);

            }
        }
    }

    /**
     * Escuta as teclas precionadas na "tabela de produtos back".
     */
    public static class ProductTableBackKeyListener extends KeyAdapter {
        private final PDVPresenter presenter;

        /**
         * @param presenter {@link PDVPresenter} - Classe presenter da {@link br.com.ernanilima.jpdv.View.ViewPDV}.
         */
        public ProductTableBackKeyListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                // CANCELA O PRODUTO SELECIONADO
                presenter.cancelProduct();

            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
                // VOLTA PARA A TELA DE VENDA
                presenter.selectSaleCardL(CARD_VENDA);

            }
        }
    }

    /**
     * Escuta as teclas precionadas no campo de "buscar produto".
     */
    public static class FieldSearchProductKeyListener extends KeyAdapter {
        private final PDVPresenter presenter;

        /**
         * @param presenter {@link PDVPresenter} - Classe presenter da {@link br.com.ernanilima.jpdv.View.ViewPDV}.
         */
        public FieldSearchProductKeyListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                // ADICIONA O PRODUTO SELECIONADO NA VENDA
                presenter.productFromSearchTable();
                presenter.cleanAllProductSearch();

            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
                // VOLTA PARA A TELA DE VENDA
                presenter.selectSaleCardL(CARD_VENDA);
                presenter.cleanAllProductSearch();

            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                // MOVE PARA A LINHA SUPERIOR NA TABELA DE BUSCA DE PRODUTO
                presenter.moveTableRow(KeyEvent.VK_UP);

            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                // MOVE PARA A LINHA INFERIOR NA TABELA DE BUSCA DE PRODUTO
                presenter.moveTableRow(KeyEvent.VK_DOWN);

            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() != KeyEvent.VK_UP & e.getKeyCode() != KeyEvent.VK_DOWN
                & e.getKeyCode() != KeyEvent.VK_LEFT & e.getKeyCode() != KeyEvent.VK_RIGHT) {
                presenter.productSearchFilter();
            }
        }
    }

    /**
     * Escuta as teclas precionadas no campo de "valor total recebido".
     */
    public static class FieldTotalValueReceivedKeyListener extends KeyAdapter {
        private final PDVPresenter presenter;

        /**
         * @param presenter {@link PDVPresenter} - Classe presenter da {@link br.com.ernanilima.jpdv.View.ViewPDV}.
         */
        public FieldTotalValueReceivedKeyListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                // FINALIZA A VENDA
                presenter.finalizeSale();

            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
                // VOLTA PARA A TELA DE VENDA
                presenter.selectValueCardL(CARD_VALOR_PRODUTO);

            } else if (e.getKeyCode() == presenter.getShortcutKey(IndexShortcutKey.DISCOUNT_ON_SALE)) {
                // DESCONTO NA VENDA
                presenter.selectDiscountCardL(CARD_DESCONTO);

            } else if (e.getKeyCode() == presenter.getShortcutKey(IndexShortcutKey.PAYMENT_MONEY)) {
                // PAGAMENTO EM DINHEIRO
                presenter.selectPaymentMethod(0);

            } else if (e.getKeyCode() == presenter.getShortcutKey(IndexShortcutKey.PAYMENT_CREDIT_CARD)) {
                // PAGAMENTO CARTAO DE CREDITO
                presenter.selectPaymentMethod(1);

            } else if (e.getKeyCode() == presenter.getShortcutKey(IndexShortcutKey.PAYMENT_DEBIT_CARD)) {
                // PAGAMENTO CARTAO DE DEBIDO
                presenter.selectPaymentMethod(2);

            }
        }
    }

    /**
     * Escuta as teclas precionadas no campo de "desconto por valor".
     */
    public static class FieldDiscountValueKeyListener extends KeyAdapter {
        private final PDVPresenter presenter;

        /**
         * @param presenter {@link PDVPresenter} - Classe presenter da {@link br.com.ernanilima.jpdv.View.ViewPDV}.
         */
        public FieldDiscountValueKeyListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                // DESCONTO POR VALOR
                presenter.validateDiscount();

            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
                // SAI DA TELA DE DESCONTO
                presenter.exitDiscount();

            }
        }
    }

    /**
     * Escuta as teclas precionadas no campo de "desconto por percentual".
     */
    public static class FieldDiscountPercentageKeyListener extends KeyAdapter {
        private final PDVPresenter presenter;

        /**
         * @param presenter {@link PDVPresenter} - Classe presenter da {@link br.com.ernanilima.jpdv.View.ViewPDV}.
         */
        public FieldDiscountPercentageKeyListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                // DESCONTO POR PERCENTUAL
                presenter.validateDiscount();

            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
                // SAI DA TELA DE DESCONTO
                presenter.exitDiscount();

            }
        }
    }

    /**
     * Escuta as teclas precionadas no campo de "troco".
     */
    public static class FieldChangeValueKeyListener extends KeyAdapter {
        private final PDVPresenter presenter;

        /**
         * @param presenter {@link PDVPresenter} - Classe presenter da {@link br.com.ernanilima.jpdv.View.ViewPDV}.
         */
        public FieldChangeValueKeyListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
                // VOLTA PRA TELA DE VENDA
                presenter.newSale();

            }
        }
    }

    /**
     * Escuta as teclas precionadas no painel de opcoes do admin.
     */
    public static class AdminOptionKeyListener extends KeyAdapter {
        private final PDVPresenter presenter;

        /**
         * @param presenter {@link PDVPresenter} - Classe presenter da {@link br.com.ernanilima.jpdv.View.ViewPDV}.
         */
        public AdminOptionKeyListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER | e.getKeyCode() == KeyEvent.VK_SPACE) {
                presenter.adminOptions();

            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                presenter.loginScreen();
            }
        }
    }
}
