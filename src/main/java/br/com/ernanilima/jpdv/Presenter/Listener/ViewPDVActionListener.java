package br.com.ernanilima.jpdv.Presenter.Listener;

import br.com.ernanilima.jpdv.Presenter.PDVPresenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe que escuta as acoes do usuario na {@link br.com.ernanilima.jpdv.View.ViewPDV}.
 *
 * @author Ernani Lima
 */
public class ViewPDVActionListener {

    /**
     * Executa o metodo "{@link PDVPresenter#userLogin()}" que realiza
     * a validacao de login do usuario ou do suporte tecnico.
     */
    public static class BtnLoginUserActionListener implements ActionListener {
        private final PDVPresenter presenter;

        /**
         * @param presenter {@link PDVPresenter} - Classe presenter da {@link br.com.ernanilima.jpdv.View.ViewPDV}.
         */
        public BtnLoginUserActionListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            presenter.userLogin();
        }
    }

    /**
     * Executa o metodo "{@link PDVPresenter#exitPDV()}" que fecha a tela do PDV.
     */
    public static class BtnExitActionListener implements ActionListener {
        private final PDVPresenter presenter;

        /**
         * @param presenter {@link PDVPresenter} - Classe presenter da {@link br.com.ernanilima.jpdv.View.ViewPDV}.
         */
        public BtnExitActionListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            presenter.exitPDV();
        }
    }

    /**
     * Executa o metodo "{@link PDVPresenter#cleanAllProductSearch()}" que limpa a busca de produto.
     */
    public static class BtnClearSearchActionListener implements ActionListener {
        private final PDVPresenter presenter;

        /**
         * @param presenter {@link PDVPresenter} - Classe presenter da {@link br.com.ernanilima.jpdv.View.ViewPDV}.
         */
        public BtnClearSearchActionListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            presenter.cleanAllProductSearch();
        }
    }

    /**
     * Executa o metodo "{@link PDVPresenter#validateDiscount()}".
     */
    public static class BtnConfirmDiscountActionListener implements ActionListener {
        private final PDVPresenter presenter;

        /**
         * @param presenter {@link PDVPresenter} - Classe presenter da {@link br.com.ernanilima.jpdv.View.ViewPDV}.
         */
        public BtnConfirmDiscountActionListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            presenter.validateDiscount();
        }
    }
}
