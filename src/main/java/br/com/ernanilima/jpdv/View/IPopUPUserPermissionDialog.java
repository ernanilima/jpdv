package br.com.ernanilima.jpdv.View;


import javax.swing.text.Document;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * Interface da View {@link PopUPUserPermissionDialog}
 *
 * @author Ernani Lima
 */
public interface IPopUPUserPermissionDialog {

    // Exibe o Dialog
    public void setShowPopUP(String title, String message);

    // Fecha o Dialog
    public void setClosePopUP();

    // Retorna o ID do usuario
    public String getUserID();

    // Retorna a senha do usuario
    public String getUserPassword();

    // Definir foco no campo de codigo do usuario
    public void setFocusUserIDField();

    // Definir foco no campo de senha do usuario
    public void setFocusUserPasswordField();

    // Limpa todos os campos de texto
    public void clearIDPassword();

    // Associa um campo de texto a um Document
    public void setUserIDFieldDocument(Document document);

    // Seta escutas em componentes do PDV
    public void setBtnOkActionPerformed(ActionListener listener);
    public void setBtnExitActionPerformed(ActionListener listener);
    public void setUserIDFieldKeyPressed(KeyAdapter adapter);
    public void setUserPasswordFieldKeyPressed(KeyAdapter adapter);
    public void setTopBarMousePressed(MouseAdapter adapter);
    public void setTopBarMouseDragged(MouseAdapter adapter);

    // Seta a movimentacao do Dialog na barra superior
    public void setMouseMotion(int x, int y);
}
