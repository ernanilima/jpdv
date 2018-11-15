package br.com.ernanilima.jpdv.Presenter;

import br.com.ernanilima.jpdv.Util.Background;
import br.com.ernanilima.jpdv.Model.Backgrounds;
import br.com.ernanilima.jpdv.Model.Icons;
import br.com.ernanilima.jpdv.Presenter.Listener.PopUPConfirmDialogActionListener;
import br.com.ernanilima.jpdv.Presenter.Listener.PopUPConfirmDialogKeyListener;
import br.com.ernanilima.jpdv.Presenter.Listener.PopUPConfirmDialogMouseMotionListener;
import br.com.ernanilima.jpdv.View.IPopUPConfirmDialog;
import br.com.ernanilima.jpdv.View.PopUPConfirmDialog;

/**
 * Presenter da View PopUPConfirmDialog
 *
 * @author Ernani Lima
 */
public class PopUPConfirmDialogPresenter {

    // Interface da View PopUPConfirmDialog
    private final IPopUPConfirmDialog viewPopUPConfirm;

    // Model de Icones do sistema
    private final Icons mIcons;

    // Model de Backgrounds do sistema
    private final Backgrounds mBg;

    // Construtor
    public PopUPConfirmDialogPresenter() {
        this.mIcons = new Icons();
        this.mBg = new Backgrounds();
        this.viewPopUPConfirm = new PopUPConfirmDialog(null, true);
        this.myListiners();
        this.viewPopUPConfirm.setBackground(Background.getBackgroundSideBySide(mBg.getPathBgDialog()));
    }

    // Listiner de "Botons", "Campos" e outros.
    private void myListiners() {
        viewPopUPConfirm.setYesKeyPressed(new PopUPConfirmDialogKeyListener.YesKeyListener(this));
        viewPopUPConfirm.setNoKeyPressed(new PopUPConfirmDialogKeyListener.NoKeyListener(this));
        viewPopUPConfirm.setYesActionPerformed(new PopUPConfirmDialogActionListener.YesActionListener(this));
        viewPopUPConfirm.setNoActionPerformed(new PopUPConfirmDialogActionListener.NoActionListener(this));
        viewPopUPConfirm.setTopBarMousePressed(new PopUPConfirmDialogMouseMotionListener.TopBarMouseListener());
        viewPopUPConfirm.setTopBarMouseDragged(new PopUPConfirmDialogMouseMotionListener.TopBarMouseMotionListener(this));
    }

    /**
     * Exibe o Dialog de "CONFIRMACAO" com titulo, mensagem e icone de pergunta.
     * Botons "SIM" e "NAO" serao exibidos
     * @param title String - Titulo do Dialog
     * @param message String - Mensagem para exibir no Dialog
     */
    public void showConfirmDialog(String title, String message) {
        viewPopUPConfirm.setShowPopUP(title, message, mIcons.getIconQuestion());
    }

    /**
     * Variavel que armazena opcao escolhida no Dialog
     */
    public boolean resultSelected = false;

    /**
     * Metodo que retorna opcao escolhida (SIM/NAO)
     * @return boolean - "true" se selecionado SIM no dialog
     * ou "false" se selecionado NAO
     */
    public boolean questionResult() {
        boolean result = false;
        if (resultSelected) {
            result = true;
        }
        return result;
    }

    /**
     * Fecha o Dialog com setVisible(false)
     */
    public void closePopUP() {
        viewPopUPConfirm.setClosePopUP();
    }

    /**
     * Movimenta o Dialog ao clicar e arrastar na barra superior
     * @param x int - Valor referente ao ponto do click no Dialog
     * @param y int - Valor referente ao ponto do click na Tela
     */
    public void mouseMotionPopUP(int x, int y) {
        viewPopUPConfirm.setMouseMotion(x, y);
    }

    /**
     * Metodo que define o foco no botao SIM do Dialog
     */
    public void focusBtnYes() {
        viewPopUPConfirm.setFocusBtnYes();
    }

    /**
     * Metodo que define o foco no botao NAO do Dialog
     */
    public void focusBtnNo() {
        viewPopUPConfirm.setFocusBtnNo();
    }
}
