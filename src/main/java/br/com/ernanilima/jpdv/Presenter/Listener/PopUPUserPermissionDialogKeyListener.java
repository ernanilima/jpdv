package br.com.ernanilima.jpdv.Presenter.Listener;

import br.com.ernanilima.jpdv.Presenter.PopUPUserPermissionDialogPresenter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Classe que escuta teclas precionadas na View {@link br.com.ernanilima.jpdv.View.PopUPUserPermissionDialog}
 *
 * @author Ernani Lima
 */
public class PopUPUserPermissionDialogKeyListener {

    /** Campo de ID do usuario */
    public static class UserIDFieldKeyListener extends KeyAdapter {
        private final PopUPUserPermissionDialogPresenter presenter;

        /**
         * @param presenter {@link PopUPUserPermissionDialogPresenter}
         */
        public UserIDFieldKeyListener(PopUPUserPermissionDialogPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                presenter.focusUserPassword();
            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                presenter.closePopUP();
            }
        }
    }

    /** Campo de senha do usuario */
    public static class UserPasswordFieldKeyListener extends KeyAdapter {
        private final PopUPUserPermissionDialogPresenter presenter;

        /**
         * @param presenter {@link PopUPUserPermissionDialogPresenter}
         */
        public UserPasswordFieldKeyListener(PopUPUserPermissionDialogPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                presenter.validateDialogFields();
            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                presenter.closePopUP();
            }
        }
    }
}
