package br.com.ernanilima.jpdv.Presenter.Listener;

import br.com.ernanilima.jpdv.Presenter.PopUPMessageDialogPresenter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Classe que escuta a movimentacao e click do mouse na View PopUPMessageDialog
 *
 * @author Ernani Lima
 */
public class PopUPMessageDialogMouseMotionListener {

    private static int xMouse, yMouse;

    /**
     * Define movimentacao do Dialog de acordo com o tamanho da tela
     * e local onde clicou na barra superior.
     */
    public static class TopBarMouseMotionListener extends MouseAdapter {
        private final PopUPMessageDialogPresenter presenter;
        private int x, y;

        /**
         * Metodo construtor
         * @param presenter {@link PopUPMessageDialogPresenter} - Classe presenter da View PopUPMessageDialog.
         */
        public TopBarMouseMotionListener(PopUPMessageDialogPresenter presenter) {
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

        /**
         * Metodo construtor vazio
         */
        public TopBarMouseListener() {}

        @Override
        public void mousePressed(MouseEvent e) {
            xMouse = e.getX();
            yMouse = e.getY();
        }
    }
}