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
                this.presenter.focusFieldPassword();
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
                this.presenter.userLogin();
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
                this.presenter.searchProduct();
            } else if (e.getKeyCode() == presenter.getShortcutKey(IndexShortcutKey.TOTALIZE)){
                // Tela para finalizar a venda
                this.presenter.cardsPDV(CardLayoutPDV.CARD_VALOR_CUPOM);
            } else if (e.getKeyCode() == presenter.getShortcutKey(IndexShortcutKey.CANCEL_GENERIC_PRODUCT)) {
                // Cancela produto generico
                this.presenter.cardsPDV(CardLayoutPDV.CARD_ITENS);
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
                this.presenter.newQuantity();
            }
        }
    }
}
