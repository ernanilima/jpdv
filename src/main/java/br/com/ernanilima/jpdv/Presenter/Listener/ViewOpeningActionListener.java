package br.com.ernanilima.jpdv.Presenter.Listener;

import br.com.ernanilima.jpdv.Presenter.OpeningPresenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe que escuta as acoes do usuario em {@link br.com.ernanilima.jpdv.View.ViewOpening}
 *
 * @author Ernani Lima
 */
public class ViewOpeningActionListener {

    /** Botao Confirmar */
    public static class ConfirmActionListener implements ActionListener {
        private final OpeningPresenter presenter;

        /**
         * @param presenter {@link OpeningPresenter}
         */
        public ConfirmActionListener(OpeningPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            presenter.validateOpening();
        }
    }

    /** Botao Cancelar */
    public static class CancelActionListener implements ActionListener {
        private final OpeningPresenter presenter;

        /**
         * @param presenter {@link OpeningPresenter}
         */
        public CancelActionListener(OpeningPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            presenter.closePopUP();
        }
    }
}
