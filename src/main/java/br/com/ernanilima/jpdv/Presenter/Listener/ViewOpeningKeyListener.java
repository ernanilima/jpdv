package br.com.ernanilima.jpdv.Presenter.Listener;

import br.com.ernanilima.jpdv.Presenter.OpeningPresenter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Classe que escuta teclas precionadas em {@link br.com.ernanilima.jpdv.View.ViewOpening}
 *
 * @author Ernani Lima
 */
public class ViewOpeningKeyListener {

    /** Campo de ID do operador */
    public static class OperatorIDFieldKeyListener extends KeyAdapter {
        private final OpeningPresenter presenter;

        /**
         * @param presenter {@link OpeningPresenter}
         */
        public OperatorIDFieldKeyListener(OpeningPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                presenter.validateOperatorID();
            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                presenter.closePopUP();
            }
        }
    }

    /** Campo de senha do usuario */
    public static class InitialValueFieldKeyListener extends KeyAdapter {
        private final OpeningPresenter presenter;

        /**
         * @param presenter {@link OpeningPresenter}
         */
        public InitialValueFieldKeyListener(OpeningPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                presenter.validateOpening();
            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                presenter.closePopUP();
            }
        }
    }
}
