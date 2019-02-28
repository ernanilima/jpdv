package br.com.ernanilima.jpdv.Presenter.Listener;

import br.com.ernanilima.jpdv.Presenter.PDVPresenter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Classe que escuta a movimentacao e click do mouse na {@link br.com.ernanilima.jpdv.View.ViewPDV}
 *
 * @author Ernani Lima
 */
public class ViewPDVMouseMotionListener {

    /**
     * Captura opcao escolida na lista admin options.
     */
    public static class AdminOptionMouseListener extends MouseAdapter {
        private final PDVPresenter presenter;

        /**
         * @param presenter {@link PDVPresenter} - Classe presenter da {@link br.com.ernanilima.jpdv.View.ViewPDV}.
         */
        public AdminOptionMouseListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            presenter.adminOptions();
        }
    }
}
