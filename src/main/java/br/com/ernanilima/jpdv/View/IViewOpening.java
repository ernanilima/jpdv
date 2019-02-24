package br.com.ernanilima.jpdv.View;

import javax.swing.text.Document;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * Interface da View ViewOpening.
 *
 * @author Ernani Lima
 */
public interface IViewOpening {

    // Exibe o Dialog
    public void setShow();

    // Fecha o Dialog
    public void setClose();

    // Operador
    public String getOperatorID();
    public void setOperatorName(String name);
    public void clearOperator();

    // Definir foco no campo de codigo do operador
    public void setFocusOperatorIDField();

    // Definir foco no campo de valor inicial
    public void setFocusInitialValueField();

    // Definir Data e Hora
    public void setCurrentDate(String date);
    public void setCurrentTime(String time);

    // Associa um campo de texto a um Document
    public void setDocumentOperatorIDField(Document document);
    public void setDocumentInitialValueField(Document document);

    // Seta escutas em componentes do PDV
    public void setActionPerformedBtnConfirm(ActionListener listener);
    public void setActionPerformedBtnCancel(ActionListener listener);
    public void setFocusLostOperatorIDField(FocusAdapter adapter);
    public void setKeyPressedOperatorIDField(KeyAdapter adapter);
    public void setKeyPressedInitialValueField(KeyAdapter adapter);
    public void setMousePressedTopBar(MouseAdapter adapter);
    public void setMouseDraggedTopBar(MouseAdapter adapter);

    // Seta a movimentacao do Dialog na barra superior
    public void setMouseMotion(int x, int y);

    // Retorna true se o dialog estiver visivel
    public boolean getVisible();
}
