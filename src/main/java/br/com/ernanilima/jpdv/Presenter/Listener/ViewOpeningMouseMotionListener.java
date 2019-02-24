package br.com.ernanilima.jpdv.Presenter.Listener;

import br.com.ernanilima.jpdv.Presenter.OpeningPresenter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Classe que escuta a movimentacao e click do mouse em {@link br.com.ernanilima.jpdv.View.ViewOpening}
 *
 * @author Ernani Lima
 */
public class ViewOpeningMouseMotionListener {

    private static int xMouse, yMouse;

    /**
     * Define movimentacao do Dialog de acordo com o tamanho da tela
     * e local onde clicou na barra superior.
     */
    public static class TopBarMouseMotionListener extends MouseAdapter {
        private final OpeningPresenter presenter;
        private int x, y;

        /**
         * @param presenter {@link OpeningPresenter}
         */
        public TopBarMouseMotionListener(OpeningPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            x = e.getXOnScreen();
            y = e.getYOnScreen();
            presenter.mouseMotionPopUP(x - xMouse, y - yMouse);
        }
    }

    /**
     * Captura local exato onde clicou na barra superior do Dialog.
     */
    public static class TopBarMouseListener extends MouseAdapter {

        // Construtor vazio
        public TopBarMouseListener() {}

        @Override
        public void mousePressed(MouseEvent e) {
            xMouse = e.getX();
            yMouse = e.getY();
        }
    }
}
