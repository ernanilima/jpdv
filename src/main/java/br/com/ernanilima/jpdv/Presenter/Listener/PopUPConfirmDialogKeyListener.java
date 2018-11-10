package br.com.ernanilima.jpdv.Presenter.Listener;

import br.com.ernanilima.jpdv.Presenter.PopUPConfirmDialogPresenter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Classe que escuta teclas precionadas na View PopUPConfirmDialog
 *
 * @author Ernani Lima
 */
public class PopUPConfirmDialogKeyListener {

    /**
     * Atribui "true" na variavel "{@link PopUPConfirmDialogPresenter#resultSelected}"
     * e fecha o Dialog ao precionar ENTER no botao SIM.
     * Retorna "true" no metodo "{@link PopUPConfirmDialogPresenter#questionResult()}"
     */
    public static class YesKeyListener extends KeyAdapter {
        private final PopUPConfirmDialogPresenter presenter;

        /**
         * Metodo construtor
         * @param presenter {@link PopUPConfirmDialogPresenter} - Classe presenter da View PopUPConfirmDialog.
         */
        public YesKeyListener(PopUPConfirmDialogPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                this.presenter.resultSelected = true;
                this.presenter.closePopUP();
            } else if (e.getKeyCode() == KeyEvent.VK_UP | e.getKeyCode() == KeyEvent.VK_RIGHT |
                    e.getKeyCode() == KeyEvent.VK_DOWN | e.getKeyCode() == KeyEvent.VK_LEFT) {
                // Muda o foco ao precionar qualquer tecla direcional
                this.presenter.focusBtnNo();
            }
        }
    }

    /**
     * Atribui "false" na variavel "{@link PopUPConfirmDialogPresenter#resultSelected}"
     * e fecha o Dialog ao precionar ENTER no botao NAO.
     * Retorna "false" no metodo "{@link PopUPConfirmDialogPresenter#questionResult()}"
     */
    public static class NoKeyListener extends KeyAdapter {
        private final PopUPConfirmDialogPresenter presenter;

        /**
         * Metodo construtor
         * @param presenter {@link PopUPConfirmDialogPresenter} - Classe presenter da View PopUPConfirmDialog.
         */
        public NoKeyListener(PopUPConfirmDialogPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                this.presenter.resultSelected = false;
                this.presenter.closePopUP();
            } else if (e.getKeyCode() == KeyEvent.VK_UP | e.getKeyCode() == KeyEvent.VK_RIGHT |
                    e.getKeyCode() == KeyEvent.VK_DOWN | e.getKeyCode() == KeyEvent.VK_LEFT) {
                // Muda o foco ao precionar qualquer tecla direcional
                this.presenter.focusBtnYes();
            }
        }
    }
}
