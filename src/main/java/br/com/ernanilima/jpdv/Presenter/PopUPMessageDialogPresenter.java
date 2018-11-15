package br.com.ernanilima.jpdv.Presenter;

import br.com.ernanilima.jpdv.Util.Background;
import br.com.ernanilima.jpdv.Model.Backgrounds;
import br.com.ernanilima.jpdv.Model.Icons;
import br.com.ernanilima.jpdv.Presenter.Listener.PopUPMessageDialogActionListener;
import br.com.ernanilima.jpdv.Presenter.Listener.PopUPMessageDialogKeyListener;
import br.com.ernanilima.jpdv.Presenter.Listener.PopUPMessageDialogMouseMotionListener;
import br.com.ernanilima.jpdv.View.IPopUPMessageDialog;
import br.com.ernanilima.jpdv.View.PopUPMessageDialog;

/**
 * Presenter da View PopUPMessageDialog
 *
 * @author Ernani Lima
 */
public class PopUPMessageDialogPresenter {

    // Interface da View PopUPMessageDialog
    private final IPopUPMessageDialog viewPopUPMessage;

    // Model de Icones do sistema
    private final Icons mIcons;

    // Model de imagens de background do sistema
    private final Backgrounds mBg;

    // Construtor
    public PopUPMessageDialogPresenter() {
        this.mIcons = new Icons();
        this.mBg = new Backgrounds();
        this.viewPopUPMessage = new PopUPMessageDialog(null, true);
        this.myListiners();
        this.viewPopUPMessage.setBackground(Background.getBackgroundSideBySide(mBg.getPathBgDialog()));
    }

    // Listiner de "Botons", "Campos" e outros.
    private void myListiners() {
        viewPopUPMessage.setOKActionPerformed(new PopUPMessageDialogActionListener.OkActionListener(this));
        viewPopUPMessage.setTopBarMousePressed(new PopUPMessageDialogMouseMotionListener.TopBarMouseListener());
        viewPopUPMessage.setTopBarMouseDragged(new PopUPMessageDialogMouseMotionListener.TopBarMouseMotionListener(this));
        viewPopUPMessage.setOKKeyPressed(new PopUPMessageDialogKeyListener.OkKeyListener(this));
    }

    /**
     * Exibe o Dialog de "ALERTA" com titulo, mensagem e icone de alerta.
     * @param title String - Titulo do Dialog
     * @param message String - Mensagem para exibir no Dialog
     */
    public void showAlert(String title, String message) {
        viewPopUPMessage.setShowPopUP(title, message, mIcons.getIconAlert());
    }

    /**
     * Exibe o Dialog de "OK" com titulo, mensagem e icone de ok
     * @param title String - Titulo do Dialog
     * @param message String - Mensagem para exibir no Dialog
     */
    public void showOkay(String title, String message) {
        viewPopUPMessage.setShowPopUP(title, message, mIcons.getIconOkay());
    }

    /**
     * Fecha o Dialog com setVisible(false)
     */
    public void closePopUP() {
        viewPopUPMessage.setClosePopUP();
    }

    /**
     * Movimenta o Dialog ao clicar e arrastar na barra superior
     * @param x int - Valor referente ao ponto do click no Dialog
     * @param y int - Valor referente ao ponto do click na Tela
     */
    public void mouseMotionPopUP(int x, int y) {
        viewPopUPMessage.setMouseMotion(x, y);
    }
}