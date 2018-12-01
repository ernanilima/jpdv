package br.com.ernanilima.jpdv.View;

import com.towel.swing.img.JImagePanel;

import javax.swing.*;
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
    public String getUserID();

    // Seta o ID do usuario
    public void setUserID(String id);

    // Seta o Nome do usuario
    public void setUsername(String username);

    // Retorna a senha do usuario
    public String getPassword();

    // Retorna o codigo de barras digitado
    public String getBarcode();

    // Retorna a quantidade vendida
    public String getQuantity();

    // Seta quantidade a ser vendida
    public void setQuantity(String quantity);

    // Seta preco do produto
    public void setSalePrice(String salePrice);

    // Seta preco total do produto (quantidade * preco de venda)
    public void setTotalProductValue(String totalProductValue);

    // Seta o valor total do cupom
    public void setTotalCouponValue(String totalCouponValue);

    // Seta o valor total a receber
    public void setTotalValueReceivable(String totalValueReceivable);

    // Retorna o valor de desconto informado
    public String getDiscountValue();

    // Retorna o valor total a receber
    public String getFieldTotalValueReceivable();

    // Retorna o percentual de desconto informado
    public String getDiscountPercentage();

    // Retorna o conteudo digitado na busca de produto
    public String getFieldSearchProduct();

    // Retorna o valor total recebido
    public String getFieldTotalValueReceived();

    // Retorna o ID do cupom atual
    public String getCurrentCouponID();

    public void setCurrentDate(String date);

    public void setCurrentTime(String time);

    // Seta o ID do cupom atual
    public void setcurrentCouponID(String couponID);

    // Seta o ID do PDV
    public void setPDVID(String PDVID);

    // Seta o ID da Filial
    public void setCompanyID(String companyID);

    public void setVersion(String version);

    public String getTotal(); // MUDAR NOMENCLATURA

    public void setProductDescription(String productDescription);

    public void setDiscountDescription(String description);

    public void setChangeValue(String changeValue);

    public void setValueReceivableChange(String receivableChange);

    public void setValueReceivedChange(String receivedChange);

    public boolean getTotalProductIsVisible();
    public boolean getTotalCouponIsVisible();
    public boolean getChangeScreenIsVisible();
    public boolean getBarcodeIsFocusOwner();
    public boolean getSearchProductIsFocusOwner();
    public boolean getDiscountValueIsFocusOwner();
    public boolean getDiscountPercentageIsFocusOwner();

    // Seta escutas em componentes do PDV
    public void setBtnLoginActionPerformed(ActionListener listener);
    public void setBtnExitActionPerformed(ActionListener listener);
    public void setFieldIDKeyPressed(KeyAdapter adapter);
    public void setFieldPasswordKeyPressed(KeyAdapter adapter);
    public void setFieldBarcodeKeyPressed(KeyAdapter adapter);
    public void setProductTableBackKeyPressed(KeyAdapter adapter);
    public void setFieldTotalValueReceivedKeyPressed(KeyAdapter adapter);
    public void setFieldDiscountValueKeyPressed(KeyAdapter adapter);
    public void setFieldDiscountPercentageKeyPressed(KeyAdapter adapter);
    public void setBtnConfirmDiscountActionPerformed(ActionListener listener);
    public void setFieldSearchProductKeyPressed(KeyAdapter adapter);
    public void setBtnClearSearchActionPerformed(ActionListener listener);
    public void setFieldChangeValueKeyPressed(KeyAdapter adapter);

    // Associa um campo de texto a um Document
    public void setFieldBarcodeDocument(Document document);
    public void setFieldIDDocument(Document document);
    public void setFieldSalePriceDocument(Document document);
    public void setFieldTotalProductValueDocument(Document document);
    public void setFieldTotalCouponValueDocument(Document document);
    public void setFieldTotalDiscountDocument(Document document);
    public void setFieldTotalOutstandingAmountDocument(Document document);
    public void setFieldTotalValueReceivedDocument(Document document);
    public void setFieldDiscountValueDocument(Document document);
    public void setFieldDiscountPercentageDocument(Document document);
    public void setFieldChangeValueDocument(Document document);
    public void setFieldValueReceivableChangeDocument(Document document);
    public void setValueReceivedChangeDocument(Document document);

    // Definir foco em determinado componente do PDV
    public void setFocusFieldID();
    public void setFocusFieldPassword();
    public void setFocusFieldBarcode();
    public void setFocusProductTableBack();
    public void setFocusFieldTotalValueReceived();
    public void setFocusFieldDiscountValue();
    public void setFocusFieldDiscountPercentage();
    public void setFocusFieldSearchProduct();
    public void setFocusFieldChangeValue();

    // Habilitar ou desabilitar foco
    public void setFocusableFieldBarcode(boolean focus);
    public void setFocusableFieldTotalValueReceived(boolean focus);

    // Limpar campos
    public void cleanBarcodeField();
    public void cleanDiscountValue();
    public void cleanDiscountPercentage();
    public void cleanProductSearch();
    public void cleanTotalValueReceived();

    // Seta qual cardLayout deseja exibir
    public void setStartCardL(String cardName);
    public void setSaleCardL(String cardName);
    public void setValueCardL(String cardName);
    public void setLogoCardL(String cardName);

    // Retorna o componente JTable
    public JTable getProductTableFront();
    public JTable getProductTableBack();
    public JTable getProductSearchTable();
    public JTable getPaymentMethodTable();
    public JTable getPaymentReceivedTable();

    // Seta a Imagem de background direto no jPanel
    public void setBackgroundLogin(JImagePanel imagePanel);

    // Exibe a tela do PDV
    public void packAndShow();
}