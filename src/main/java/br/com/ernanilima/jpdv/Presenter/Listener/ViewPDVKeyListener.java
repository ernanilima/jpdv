package br.com.ernanilima.jpdv.Presenter.Listener;

import br.com.ernanilima.jpdv.Model.Enum.IndexShortcutKey;
import br.com.ernanilima.jpdv.Presenter.PDVPresenter;
import br.com.ernanilima.jpdv.View.Enum.CardLayoutPDV;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Classe que escuta teclas precionadas na ViewPDV
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
         * Metodo construtor
         * @param presenter {@link PDVPresenter} - Classe presenter da ViewPDV.
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
         * Metodo construtor
         * @param presenter {@link PDVPresenter} - Classe presenter da ViewPDV.
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
     * Escuta as teclas precionadas no campo de codigo de barras.
     */
    public static class FieldBarcodeKeyListener extends KeyAdapter {
        private final PDVPresenter presenter;

        /**
         * Metodo construtor
         * @param presenter {@link PDVPresenter} - Classe presenter da ViewPDV.
         */
        public FieldBarcodeKeyListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                // Executa o metodo que busca o produto por codigo de barras
                presenter.searchProduct();

            } else if (e.getKeyCode() == presenter.getShortcutKey(IndexShortcutKey.TOTALIZE)){
                // Tela para finalizar a venda
                presenter.selectValueCardL(CardLayoutPDV.CARD_VALOR_CUPOM);

            } else if (e.getKeyCode() == presenter.getShortcutKey(IndexShortcutKey.CANCEL_GENERIC_PRODUCT)) {
                // Cancela produto generico
                presenter.selectSaleCardL(CardLayoutPDV.CARD_ITENS);

            } else if (e.getKeyCode() == presenter.getShortcutKey(IndexShortcutKey.CANCEL_LAST_PRODUCT)) {
                // Cancela ultimo produto
                System.out.println("CANCELA ULTIMO PRODUTO");

            } else if (e.getKeyCode() == presenter.getShortcutKey(IndexShortcutKey.CANCEL_CURRENT_SALE)) {
                // Cancela venda atual
                System.out.println("CANCELA VENTA ATUAL");

            } else if (e.getKeyCode() == presenter.getShortcutKey(IndexShortcutKey.CANCEL_LAST_SALE)) {
                // Cancela ultima venda
                System.out.println("CANCELA ULTIMA VENDA");

            } else if (e.getKeyCode() == presenter.getShortcutKey(IndexShortcutKey.DISCOUNT_ON_PRODUCT)) {
                // Desconto do produto
                System.out.println("DESCONTO NO PRODUTO");

            } else if (e.getKeyCode() == presenter.getShortcutKey(IndexShortcutKey.REPEAT_LAST_PRODUCT)) {
                // Repetir ultimo produto inserido
                System.out.println("REPETIR ULTIMO PRODUTO");

            } else if (e.getKeyCode() == presenter.getShortcutKey(IndexShortcutKey.QUANTITY)) {
                // Alterar a quantidade a ser vendida
                presenter.newQuantity();

            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                // Exibe mensagem para sair do sistema
                presenter.exitPDV();

            }
        }
    }

    /**
     * Escuta as teclas precionadas na "tabela de produtos back".
     */
    public static class ProductTableBackKeyListener extends KeyAdapter {
        private final PDVPresenter presenter;

        /**
         * Metodo construtor
         * @param presenter {@link PDVPresenter} - Classe presenter da ViewPDV.
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
                presenter.selectSaleCardL(CardLayoutPDV.CARD_VENDA);

            }
        }
    }

    /**
     * Escuta as teclas precionadas no campo de "valor total recebido".
     */
    public static class FieldTotalValueReceivedKeyListener extends KeyAdapter {
        private final PDVPresenter presenter;

        /**
         * Metodo construtor
         * @param presenter {@link PDVPresenter} - Classe presenter da ViewPDV.
         */
        public FieldTotalValueReceivedKeyListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                // FINALIZA A VENDA
                System.out.println("FINALIZA E SALVA A VENDA");

            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
                // VOLTA PARA A TELA DE VENDA
                presenter.selectValueCardL(CardLayoutPDV.CARD_VALOR_PRODUTO);

            } else if (e.getKeyCode() == presenter.getShortcutKey(IndexShortcutKey.DISCOUNT_ON_SALE)) {
                // DESCONTO NA VENDA
                presenter.selectLogoCardL(CardLayoutPDV.CARD_DESCONTO);

            }
        }
    }

    /**
     * Escuta as teclas precionadas no campo de "desconto por valor".
     */
    public static class FieldDiscountValueKeyListener extends KeyAdapter {
        private final PDVPresenter presenter;

        /**
         * Metodo construtor
         * @param presenter {@link PDVPresenter} - Classe presenter da ViewPDV.
         */
        public FieldDiscountValueKeyListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                // DESCONTO POR VALOR
                presenter.validateDiscount(1);

            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
                // VOLTA PARA A TELA DE FINALIZAR VENDA
                presenter.selectValueCardL(CardLayoutPDV.CARD_VALOR_CUPOM);

            }
        }
    }

    /**
     * Escuta as teclas precionadas no campo de "desconto por percentual".
     */
    public static class FieldDiscountPercentageKeyListener extends KeyAdapter {
        private final PDVPresenter presenter;

        /**
         * Metodo construtor
         * @param presenter {@link PDVPresenter} - Classe presenter da ViewPDV.
         */
        public FieldDiscountPercentageKeyListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                // DESCONTO POR PERCENTUAL
                presenter.validateDiscount(2);

            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
                // VOLTA PARA A TELA DE FINALIZAR VENDA
                presenter.selectValueCardL(CardLayoutPDV.CARD_VALOR_CUPOM);

            }
        }
    }
}
