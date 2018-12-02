package br.com.ernanilima.jpdv.Presenter;

import br.com.ernanilima.jpdv.Dao.UserDao;
import br.com.ernanilima.jpdv.Model.User;
import br.com.ernanilima.jpdv.Presenter.Listener.PopUPUserPermissionDialogActionListener.*;
import br.com.ernanilima.jpdv.Presenter.Listener.PopUPUserPermissionDialogKeyListener.*;
import br.com.ernanilima.jpdv.Presenter.Listener.PopUPUserPermissionDialogMouseMotionListener.*;
import br.com.ernanilima.jpdv.Util.Encrypt;
import br.com.ernanilima.jpdv.Util.FieldManager;
import br.com.ernanilima.jpdv.View.IPopUPUserPermissionDialog;
import br.com.ernanilima.jpdv.View.PopUPUserPermissionDialog;

/**
 * Presenter da View {@link br.com.ernanilima.jpdv.View.PopUPUserPermissionDialog}
 *
 * @author Ernani Lima
 */
public class PopUPUserPermissionDialogPresenter {

    // Interface da View PopUPUserPermissionDialog
    private final IPopUPUserPermissionDialog viewIPopUPUserPermission;

    // Presenter do pop-up de alertas/ok
    private final PopUPMessageDialogPresenter pPopUPMessage;

    // Model do usuario
    private final User mUser;

    // Dao do usuario
    private final UserDao dUser;

    // Nivel de acesso solicitado
    private int requestedLevel;

    // ID do usuario com a permissao
    private int userIdPermission;

    // Nivel do usuario com a permissao
    private int userLevelPermission;

    // Confirma a validacao do nivel
    private boolean validation;

    // Construtor
    public PopUPUserPermissionDialogPresenter() {
        this.viewIPopUPUserPermission = new PopUPUserPermissionDialog(null, true);
        this.pPopUPMessage = new PopUPMessageDialogPresenter();
        this.mUser = new User();
        this.dUser = new UserDao();
        this.myListiners();
        this.myFilters();
    }

    // Listiner de "Botons", "Campos" e outros.
    private void myListiners() {
        viewIPopUPUserPermission.setBtnOkActionPerformed(new OkActionListener(this));
        viewIPopUPUserPermission.setBtnExitActionPerformed(new ExitActionListener(this));
        viewIPopUPUserPermission.setTopBarMouseDragged(new TopBarMouseMotionListener(this));
        viewIPopUPUserPermission.setTopBarMousePressed(new TopBarMouseListener());
        viewIPopUPUserPermission.setUserIDFieldKeyPressed(new UserIDFieldKeyListener(this));
        viewIPopUPUserPermission.setUserPasswordFieldKeyPressed(new UserPasswordFieldKeyListener(this));
    }

    // Metodo que gerencia os campos
    private void myFilters() {
        viewIPopUPUserPermission.setUserIDFieldDocument(new FieldManager.FieldFilterInt(3));
    }

    /**
     * Exibe o Dialog de "VALIDACAO DE PERMISSAO DO USUARIO".
     * @param requestedLevel int - Nivel que deseja validar
     * @param title String - Titulo do Dialog
     * @param message String - Mensagem para exibir no Dialog
     */
    public void showUserPermissionDialog(int requestedLevel, String title, String message) {
        validation = false; userLevelPermission = 0; userIdPermission = 0;
        viewIPopUPUserPermission.clearIDPassword();
        this.requestedLevel = requestedLevel;
        viewIPopUPUserPermission.setShowPopUP(title, message);
    }

    /**
     * Validacao dos campos do dialog
     */
    public void validateDialogFields() {
        String id = viewIPopUPUserPermission.getUserID();
        String password = Encrypt.sha256(viewIPopUPUserPermission.getUserPassword());

        if (id.equals("")) {
            System.out.println("INFORME O CODIGO DO OPERADOR!");
            pPopUPMessage.showAlert("ATENÇÃO!", "INFORME O CÓDIGO DO USUÁRIO!");
            focusUserID();
        } else if (password.equals("")) {
            System.out.println("INFORME A SENHA DO OPERADOR!");
            pPopUPMessage.showAlert("ATENÇÃO!", "INFORME A SENHA DO USUÁRIO!");
            focusUserPassword();
        } else {
            validateUserLevel(id, password);
        }
    }

    /**
     * Validacao das credenciais do usuario.
     * Comparacao do "requestedLevel" com o nivel do usuario
     *
     * @param id String - ID do usuario
     * @param password - Senha do usuario
     */
    private void validateUserLevel(String id, String password) {
        mUser.setId(Integer.parseInt(id));
        mUser.setPwd(password);

        if (dUser.userLogin(mUser)) {
            if (mUser.getLevel() >= requestedLevel) {
                System.out.println("NIVEL DE ACESSO OK!");
                userIdPermission = Integer.parseInt(id);
                userLevelPermission = mUser.getLevel();
                validation = true;
                closePopUP();

            } else {
                System.out.println("NIVEL DE ACESSO INSUFICIENTE!");
                pPopUPMessage.showAlert("ATENÇÃO!", "NECESSÁRIO NÍVEL " + requestedLevel);
                viewIPopUPUserPermission.clearIDPassword();
                focusUserID();
            }

        } else {
            System.out.println("USUARIO INVALIDO!");
            pPopUPMessage.showAlert("ATENÇÃO!", "DADOS INCORRETOS OU USUÁRIO NÃO CADASTRADO!");
            focusUserID();
        }
    }

    /**
     * @return boolean - Resultado da validacao do susuario com permissao
     */
    public boolean getValidation() {
        return validation;
    }

    /**
     * @return int - ID do usuario com a permissao
     */
    public int getUserId() {
        return userIdPermission;
    }

    /**
     * @return int - Nivel do usuario com a permissao
     */
    public int getUserLevel() {
        return userLevelPermission;
    }

    /**
     * Define o foco no campo de ID do usuario
     */
    public void focusUserID() {
        viewIPopUPUserPermission.setFocusUserIDField();
    }

    /**
     * Define o foco no campo de senha do usuario
     */
    public void focusUserPassword() {
        viewIPopUPUserPermission.setFocusUserPasswordField();
    }

    /**
     * Movimenta o Dialog ao clicar e arrastar na barra superior
     * @param x int - Valor referente ao ponto do click no Dialog
     * @param y int - Valor referente ao ponto do click na Tela
     */
    public void mouseMotionPopUP(int x, int y) {
        viewIPopUPUserPermission.setMouseMotion(x, y);
    }

    /**
     * Fecha o Dialog com setVisible(false)
     */
    public void closePopUP() {
        viewIPopUPUserPermission.setClosePopUP();
    }
}
