package br.com.ernanilima.jpdv.Presenter.Listener;

import br.com.ernanilima.jpdv.Presenter.PopUPMessageDialogPresenter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Classe que escuta teclas precionadas na View PopUPMessageDialog
 *
 * @author Ernani Lima
 */
public class PopUPMessageDialogKeyListener {

    /**
     * Executa o metodo "{@link PopUPMessageDialogPresenter#closePopUP()}"
     * que fecha o Dialog se precionado a tecla ENTER no botao OK.
     */
    public static class OkKeyListener extends KeyAdapter {
        private final PopUPMessageDialogPresenter presenter;

        /**
         * Metodo construtor
         * @param presenter {@link PopUPMessageDialogPresenter} - Classe presenter da View PopUPMessageDialog.
         */
        public OkKeyListener(PopUPMessageDialogPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                presenter.closePopUP();
            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                presenter.closePopUP();
            }
        }
    }
}