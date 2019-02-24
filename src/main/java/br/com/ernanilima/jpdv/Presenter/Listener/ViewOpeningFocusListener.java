package br.com.ernanilima.jpdv.Presenter.Listener;

import br.com.ernanilima.jpdv.Presenter.OpeningPresenter;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Classe que monitora foco em {@link br.com.ernanilima.jpdv.View.ViewOpening}
 *
 * @author Ernani Lima
 */
public class ViewOpeningFocusListener {

    /** Campo de ID do operador */
    public static class OperatorIDFieldFocusListener extends FocusAdapter {
        private final OpeningPresenter presenter;

        public OperatorIDFieldFocusListener(OpeningPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void focusLost(FocusEvent e) {
            presenter.validateOperatorID();
        }
    }
}
