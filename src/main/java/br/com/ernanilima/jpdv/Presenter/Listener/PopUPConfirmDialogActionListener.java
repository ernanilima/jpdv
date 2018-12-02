package br.com.ernanilima.jpdv.Presenter.Listener;

import br.com.ernanilima.jpdv.Presenter.PopUPConfirmDialogPresenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe que escuta as acoes do usuario na View {@link br.com.ernanilima.jpdv.View.PopUPConfirmDialog}
 *
 * @author Ernani Lima
 */
public class PopUPConfirmDialogActionListener {

    /**
     * Atribui "true" na variavel "{@link PopUPConfirmDialogPresenter#resultSelected}"
     * e fecha o Dialog ao clicar no botao SIM.
     * Retorna "true" no metodo "{@link PopUPConfirmDialogPresenter#questionResult()}"
     */
    public static class YesActionListener implements ActionListener {
        private final PopUPConfirmDialogPresenter presenter;

        /**
         * @param presenter {@link PopUPConfirmDialogPresenter} - Classe presenter da View {@link br.com.ernanilima.jpdv.View.PopUPConfirmDialog}.
         */
        public YesActionListener(PopUPConfirmDialogPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            presenter.resultSelected = true;
            presenter.closePopUP();
        }
    }

    /**
     * Atribui "false" na variavel "{@link PopUPConfirmDialogPresenter#resultSelected}"
     * e fecha o Dialog ao clicar no botao NAO.
     * Retorna "false" no metodo "{@link PopUPConfirmDialogPresenter#questionResult()}"
     */
    public static class NoActionListener implements ActionListener {
        private final PopUPConfirmDialogPresenter presenter;

        /**
         * @param presenter {@link PopUPConfirmDialogPresenter} - Classe presenter da View {@link br.com.ernanilima.jpdv.View.PopUPConfirmDialog}.
         */
        public NoActionListener(PopUPConfirmDialogPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            presenter.resultSelected = false;
            presenter.closePopUP();
        }
    }
}
