package br.com.ernanilima.jpdv.Presenter.Listener;

import br.com.ernanilima.jpdv.Presenter.PopUPMessageDialogPresenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe que escuta as acoes do usuario na View {@link br.com.ernanilima.jpdv.View.PopUPMessageDialog}
 *
 * @author Ernani Lima
 */
public class PopUPMessageDialogActionListener {
    /**
     * Executa o metodo "{@link PopUPMessageDialogPresenter#closePopUP()}"
     * que fecha o Dialog se clicar no botao OK.
     */
    public static class OkActionListener implements ActionListener {
        private final PopUPMessageDialogPresenter presenter;

        /**
         * @param presenter {@link PopUPMessageDialogPresenter} - Classe presenter da View {@link br.com.ernanilima.jpdv.View.PopUPMessageDialog}.
         */
        public OkActionListener(PopUPMessageDialogPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            presenter.closePopUP();
        }
    }
}