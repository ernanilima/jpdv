package br.com.ernanilima.jpdv.Presenter.Listener;

import br.com.ernanilima.jpdv.Presenter.PopUPUserPermissionDialogPresenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe que escuta as acoes do usuario na View {@link br.com.ernanilima.jpdv.View.PopUPUserPermissionDialog}
 *
 * @author Ernani Lima
 */
public class PopUPUserPermissionDialogActionListener {

    /** Botao OK */
    public static class OkActionListener implements ActionListener {
        private final PopUPUserPermissionDialogPresenter presenter;

        /**
         * @param presenter {@link PopUPUserPermissionDialogPresenter}
         */
        public OkActionListener(PopUPUserPermissionDialogPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            presenter.validateDialogFields();
        }
    }

    /** Botao Sair */
    public static class ExitActionListener implements ActionListener {
        private final PopUPUserPermissionDialogPresenter presenter;

        /**
         * @param presenter {@link PopUPUserPermissionDialogPresenter}
         */
        public ExitActionListener(PopUPUserPermissionDialogPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            presenter.closePopUP();
        }
    }
}
