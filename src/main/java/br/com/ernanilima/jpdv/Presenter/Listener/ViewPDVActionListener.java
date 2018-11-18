package br.com.ernanilima.jpdv.Presenter.Listener;

import br.com.ernanilima.jpdv.Presenter.PDVPresenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe que escuta as acoes do usuario na ViewPDV.
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
         * Metodo construtor
         * @param presenter {@link PDVPresenter} - Classe presenter da ViewPDV.
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
         * Metodo construtor
         * @param presenter {@link PDVPresenter} - Classe presenter da ViewPDV.
         */
        public BtnExitActionListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            presenter.exitPDV();
        }
    }
}
