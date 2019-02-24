package br.com.ernanilima.jpdv.Presenter;

import br.com.ernanilima.jpdv.Dao.UserDao;
import br.com.ernanilima.jpdv.Model.User;
import br.com.ernanilima.jpdv.Presenter.Listener.ViewOpeningActionListener.*;
import br.com.ernanilima.jpdv.Presenter.Listener.ViewOpeningFocusListener.*;
import br.com.ernanilima.jpdv.Presenter.Listener.ViewOpeningKeyListener.*;
import br.com.ernanilima.jpdv.Presenter.Listener.ViewOpeningMouseMotionListener.*;
import br.com.ernanilima.jpdv.Util.FieldManager;
import br.com.ernanilima.jpdv.Util.Format;
import br.com.ernanilima.jpdv.View.IViewOpening;
import br.com.ernanilima.jpdv.View.ViewOpening;

/**
 * Presenter da {@link br.com.ernanilima.jpdv.View.ViewOpening}
 *
 * @author Ernani Lima
 */
public class OpeningPresenter {

    // Interface da ViewOpening
    private final IViewOpening viewOpening;

    // Model do usuario
    private final User mUser;

    // Dao do usuario
    private final UserDao dUser;

    // Presenter do pop-up de alertas/ok
    private final PopUPMessageDialogPresenter pPopUPMessage;

    // Construtor
    public OpeningPresenter() {
        this.viewOpening = new ViewOpening(null, true);
        this.mUser = new User();
        this.dUser = new UserDao();
        this.pPopUPMessage = new PopUPMessageDialogPresenter();
        this.viewOpening.setCurrentDate(Format.DFDATE_BR.format(System.currentTimeMillis()));
        this.showTime();
        this.myListiners();
        this.myFilters();
    }

    // Thread que atualiza a hora
    private void showTime() {
        new Thread (() -> {
            try {
                while (true) {
                    viewOpening.setCurrentTime(Format.DFTIME.format(System.currentTimeMillis()));
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("ERRO COM HORA ATUAL: " + e);
            }
        }).start();
    }

    // Listiner de "Botons", "Campos" e outros.
    private void myListiners() {
        viewOpening.setActionPerformedBtnConfirm(new ConfirmActionListener(this));
        viewOpening.setActionPerformedBtnCancel(new CancelActionListener(this));
        viewOpening.setMouseDraggedTopBar(new TopBarMouseMotionListener(this));
        viewOpening.setMousePressedTopBar(new TopBarMouseListener());
        viewOpening.setFocusLostOperatorIDField(new OperatorIDFieldFocusListener(this));
        viewOpening.setKeyPressedOperatorIDField(new OperatorIDFieldKeyListener(this));
        viewOpening.setKeyPressedInitialValueField(new InitialValueFieldKeyListener(this));
    }

    // Metodo que gerencia os campos
    private void myFilters() {
        viewOpening.setDocumentOperatorIDField(new FieldManager.FieldFilterInt(3));
        viewOpening.setDocumentInitialValueField(new FieldManager.FieldFilterMonetary());
    }

    /**
     * Exibe o Dialog de abertura de caixa PDV.
     */
    void showViewOpening() {
        viewOpening.setShow();
    }

    /**
     * Validacao ID do operador
     */
    public void validateOperatorID() {
        String id = viewOpening.getOperatorID();
        boolean dialogVisible = viewOpening.getVisible();

        if (id.equals("") & dialogVisible) {
            System.out.println("INFORME O CODIGO DO OPERADOR!");
            pPopUPMessage.showAlert("ATENÇÃO!", "INFORME O CÓDIGO DO OPERADOR!");
            viewOpening.setFocusOperatorIDField();
            viewOpening.clearOperator();

        } else if (dialogVisible) {
            mUser.setId(Integer.parseInt(id));

            if (dUser.validateUserID(mUser)) {
                viewOpening.setOperatorName(mUser.getName());
                viewOpening.setFocusInitialValueField();

            } else {
                System.out.println("OPERADOR INEXISTENTE!");
                pPopUPMessage.showAlert("ATENÇÃO!", "CÓDIGO DE OPERADOR INEXISTENTE OU INATIVO!");
                viewOpening.setFocusOperatorIDField();
                viewOpening.clearOperator();
            }
        }
    }

    public void validateOpening() {
        
    }

    /**
     * Movimenta o Dialog ao clicar e arrastar na barra superior
     * @param x int - Valor referente ao ponto do click no Dialog
     * @param y int - Valor referente ao ponto do click na Tela
     */
    public void mouseMotionPopUP(int x, int y) {
        viewOpening.setMouseMotion(x, y);
    }

    /**
     * Fecha o Dialog com setVisible(false)
     */
    public void closePopUP() {
        viewOpening.setClose();
    }
}
