package br.com.ernanilima.jpdv.Presenter;

import br.com.ernanilima.jpdv.Dao.OpeningPDVDao;
import br.com.ernanilima.jpdv.Dao.UserDao;
import br.com.ernanilima.jpdv.Model.CompanyBR;
import br.com.ernanilima.jpdv.Model.OpeningPDV;
import br.com.ernanilima.jpdv.Model.PDV;
import br.com.ernanilima.jpdv.Model.User;
import br.com.ernanilima.jpdv.Presenter.Listener.ViewOpeningActionListener.*;
import br.com.ernanilima.jpdv.Presenter.Listener.ViewOpeningFocusListener.*;
import br.com.ernanilima.jpdv.Presenter.Listener.ViewOpeningKeyListener.*;
import br.com.ernanilima.jpdv.Presenter.Listener.ViewOpeningMouseMotionListener.*;
import br.com.ernanilima.jpdv.Util.FieldManager;
import br.com.ernanilima.jpdv.Util.Filter;
import br.com.ernanilima.jpdv.Util.Format;
import br.com.ernanilima.jpdv.View.IViewOpening;
import br.com.ernanilima.jpdv.View.ViewOpening;

import java.sql.Date;
import java.sql.Time;

/**
 * Presenter da {@link br.com.ernanilima.jpdv.View.ViewOpening}
 *
 * @author Ernani Lima
 */
public class OpeningPresenter {

    private final IViewOpening viewOpening; // Interface da ViewOpening

    /** Model */
    private CompanyBR mCompany; // Model da Empresa/Filial
    private PDV mPdv; // Model do PDV
    private final User mUser; // Model do usuario

    /** Dao */
    private final UserDao dUser; // Dao do usuario

    /** Presenter */
    private final PopUPMessageDialogPresenter pPopUPMessage; // Presenter do pop-up de alertas/ok

    private int supervisorID; // ID do supervisor
    private double initialValue = 0; // Valor inicial padrao

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
     * @param mCompany {@link CompanyBR} - Model da Empresa/Filial
     * @param mPdv {@link PDV} - Model do PDV
     * @param supervisorID int - ID do supervisor
     */
    void showViewOpening(CompanyBR mCompany, PDV mPdv, int supervisorID) {
        this.mCompany = mCompany;
        this.mPdv = mPdv;
        this.supervisorID = supervisorID;

        viewOpening.setInitialValue(Format.brCurrencyFormat.format(initialValue));
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

    /**
     * Validacao de valor digitado
     * Grava abertura de caixa PDV
     */
    public void saveOpening() {
        String initialValue = viewOpening.getInitialValue();
        if (initialValue.equals("") | initialValue.equals(",")) {
            pPopUPMessage.showAlert("ATENÇÃO!", "VALOR INICIAL INVÁLIDO!");
            return;
        }
        OpeningPDVDao dOpening = new OpeningPDVDao();
        OpeningPDV mOpening = new OpeningPDV();

        mOpening.setSupervisorID(supervisorID);
        mOpening.setInitialValue(Filter.filterDouble(initialValue));
        mOpening.setDate(Date.valueOf(Format.DFDATE.format(System.currentTimeMillis())));
        mOpening.setHour(Time.valueOf(Format.DFTIME.format(System.currentTimeMillis())));
        mOpening.setStatus(true);
        mOpening.setmCompany(mCompany);
        mOpening.setmUser(mUser);
        mOpening.setmPDV(mPdv);

        dOpening.saveOpeningPDV(mOpening);

        closePopUP();
    }

    /**
     * @return User - Model do usuario informano na abertura de caixa PDV
     */
    User getOpeningUser() {
        return this.mUser;
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
     * Limpa todos os campos
     */
    public void closePopUP() {
        viewOpening.clearFields();
        viewOpening.setClose();
    }
}
