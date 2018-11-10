package br.com.ernanilima.jpdv.View;

import com.towel.swing.img.JImagePanel;

import javax.swing.text.Document;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

/**
 * Interface da ViewPDV
 *
 * @author Ernani Lima
 */
public interface IViewPDV {

    // Retorna o ID do usuario
    public String getIdUser();

    // Seta o ID do usuario
    public void setIdUser(String id);

    // Retorna a senha do usuario
    public String getPassword();

    // Retorna o codigo de barras digitado
    public String getBarcode();

    // Seta escutas em componentes do PDV
    public void setLoginActionPerformed(ActionListener listener);
    public void setExitActionPerformed(ActionListener listener);
    public void setFieldIDKeyPressed(KeyAdapter adapter);
    public void setFieldPasswordKeyPressed(KeyAdapter adapter);
    public void setFieldBarcodeKeyPressed(KeyAdapter adapter);

    // Associa um campo de texto a um Document
    public void setFieldBarcodeDocument(Document document);
    public void setFieldIDDocument(Document document);

    // Definir foco em determinado componente do PDV
    public void setFocusFieldID();
    public void setFocusFieldPassword();
    public void setFocusFieldBarcode();

    // Limpar campos
    public void cleanFieldBarcode();

    // Seta qual cardLayout deseja exibir
    public void setCardPDV(String cardName);
    public void setCardPDVVendas(String cardName);
    public void setCardPDVValores(String cardName);
    public void setCardPDVLogo(String cardName);

    // Seta a Imagem de background direto no jPanel
    public void setBackgroundLogin(JImagePanel imagePanel);

    // Exibe a tela do PDV
    public void packAndShow();
}