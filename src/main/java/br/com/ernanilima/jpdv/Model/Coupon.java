package br.com.ernanilima.jpdv.Model;

import br.com.ernanilima.jpdv.Util.Format;

import java.sql.Date;
import java.sql.Time;

/**
 * Model de Cupom de PDV
 *
 * @author Ernani Lima
 */
public class Coupon {

    // Variaveis do Cupom de PDV
    private int coupon;
    private boolean productCanceled;
    private int productRowIndex;
    private boolean couponCanceled;
    private Date date;
    private Time hour;
    private boolean couponStatus;
    private float quantity;
    //private float totalProductValue;
    private float totalCouponValue;
    private int formOfPayment1;
    private float paymentAmount1;
    private int formOfPayment2;
    private float paymentAmount2;
    private int formOfPayment3;
    private float paymentAmount3;
    private float totalDiscount;
    private float totalProductDiscount;
    private int table;
    private Product mProduct;
    private CompanyBR mCompany;
    private User mUser;

    // Construtor vazio
    public Coupon() {}

    /**
     * @return int - Numero do cupom
     */
    public int getCoupon() {
        return coupon;
    }

    /**
     * Atribui o numero do cupom na variavel "{@link #coupon}"
     * @param coupon int - Numero do cupom
     */
    public void setCoupon(int coupon) {
        this.coupon = coupon;
    }

    /**
     * @return boolean - "True" para produto cancelado
     */
    public boolean isProductCanceled() {
        return productCanceled;
    }

    /**
     * Atrobui "true" na variavel "{@link #productCanceled}" caso o produto seja cancelado
     * @param productCanceled boolean - "True" para produto cancelado
     */
    public void setProductCanceled(boolean productCanceled) {
        this.productCanceled = productCanceled;
    }

    /**
     * @return int - Numero da linha do produto de cupom
     */
    public int getProductRowIndex() {
        return productRowIndex;
    }

    /**
     * Atribui o numero da linha do produto de cupom na variavel {@link #productRowIndex}
     * @param productRowIndex int - Numero da linha do produto de cupom
     */
    public void setProductRowIndex(int productRowIndex) {
        this.productRowIndex = productRowIndex;
    }

    /**
     * @return boolean - "True" para cupom cancelado
     */
    public boolean isCouponCanceled() {
        return couponCanceled;
    }

    /**
     * Atribui "true" na variavel "{@link #couponCanceled}" caso o cupom seja cancelado
     * @param couponCanceled boolean - "True" para cupom cancelado
     */
    public void setCouponCanceled(boolean couponCanceled) {
        this.couponCanceled = couponCanceled;
    }

    /**
     * @return Date - Data do cupom
     */
    public Date getDate() {
        return date;
    }

    /**
     * Atribui a data do cupom na variavel "{@link #date}"
     * @param date Date - Data do cupom
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return Time - Hora do cupom
     */
    public Time getHour() {
        return hour;
    }

    /**
     * Atribui a hora do cupom na variavel "{@link #hour}"
     * @param hour Time - Hora do cupom
     */
    public void setHour(Time hour) {
        this.hour = hour;
    }

    /**
     * @return boolean - Status do cupom, "true" para cupom gravado no servidor
     */
    public boolean isCouponStatus() {
        return couponStatus;
    }

    /**
     * Atribui "true" na variavel "{@link #couponStatus}" para cupom gravado no servidor
     * @param couponStatus boolean - "True" para cupom gravado no servidor
     */
    public void setCouponStatus(boolean couponStatus) {
        this.couponStatus = couponStatus;
    }

    /**
     * @return float - Quantidade total do produto
     */
    public float getQuantity() {
        return quantity;
    }

    /**
     * Atribui a quantidade total do produto na variavel "{@link #quantity}"
     * @param quantity float - Quantidade total do produto
     */
    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    /**
     * @return float - Valor total do produto
     */
    //public float getTotalProductValue() {
    //    return totalProductValue;
    //}
    public float getTotalProductValue() {
        return getQuantity() * mProduct.getSalePrice();
    }

    /**
     * Atribui o valor total do produto na variavel "{@link #totalProductValue}"
     * @param totalProductValue float - Valor total do produto
     */
    //public void setTotalProductValue(float totalProductValue) {
    //    this.totalProductValue = totalProductValue;
    //}

    /**
     * @return float - Valor total do cupom
     */
    public float getTotalCouponValue() {
        return totalCouponValue;
    }

    /**
     * Atribui o valor total do cupom na variavel "{@link #totalCouponValue}"
     * @param totalCouponValue float - Valor total do cupom
     */
    public void setTotalCouponValue(float totalCouponValue) {
        this.totalCouponValue = totalCouponValue;
    }

    /**
     * @return int - Forma de pagamento 1
     */
    public int getFormOfPayment1() {
        return formOfPayment1;
    }

    /**
     * Atribui o codigo da forma de pagamento 1 na variavel "{@link #formOfPayment1}"
     * @param formOfPayment1 int - Forma de pagamento 1
     */
    public void setFormOfPayment1(int formOfPayment1) {
        this.formOfPayment1 = formOfPayment1;
    }

    /**
     * @return float - Valor total do pagamento 1
     */
    public float getPaymentAmount1() {
        return paymentAmount1;
    }

    /**
     * Atribui o valor total do pagamento 1 na variavel "{@link #paymentAmount1}"
     * @param paymentAmount1 float - Valor total do pagamento 1
     */
    public void setPaymentAmount1(float paymentAmount1) {
        this.paymentAmount1 = paymentAmount1;
    }

    /**
     * @return int - Forma de pagamento 2
     */
    public int getFormOfPayment2() {
        return formOfPayment2;
    }
    /**
     * Atribui o codigo da forma de pagamento 2 na variavel "{@link #formOfPayment2}"
     * @param formOfPayment2 int - Forma de pagamento 2
     */
    public void setFormOfPayment2(int formOfPayment2) {
        this.formOfPayment2 = formOfPayment2;
    }

    /**
     * @return float - Valor total do pagamento 2
     */
    public float getPaymentAmount2() {
        return paymentAmount2;
    }

    /**
     * Atribui o valor total do pagamento 2 na variavel "{@link #paymentAmount2}"
     * @param paymentAmount2 float - Valor total do pagamento 2
     */
    public void setPaymentAmount2(float paymentAmount2) {
        this.paymentAmount2 = paymentAmount2;
    }

    /**
     * @return int - Forma de pagamento 3
     */
    public int getFormOfPayment3() {
        return formOfPayment3;
    }

    /**
     * Atribui o codigo da forma de pagamento 3 na variavel "{@link #formOfPayment3}"
     * @param formOfPayment3 int - Forma de pagamento 3
     */
    public void setFormOfPayment3(int formOfPayment3) {
        this.formOfPayment3 = formOfPayment3;
    }

    /**
     * @return float - Valor total do pagamento 3
     */
    public float getPaymentAmount3() {
        return paymentAmount3;
    }

    /**
     * Atribui o valor total do pagamento 3 na variavel "{@link #paymentAmount3}"
     * @param paymentAmount3 float - Valor total do pagamento 3
     */
    public void setPaymentAmount3(float paymentAmount3) {
        this.paymentAmount3 = paymentAmount3;
    }

    /**
     * @return float - Valor total de desconto
     */
    public float getTotalDiscount() {
        return totalDiscount;
    }

    /**
     * Atribui na variavel "{@link #totalDiscount}" o valor total de desconto
     * @param totalDiscount float - Valor total de desconto
     */
    public void setTotalDiscount(float totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    /**
     * @return float - Valor total de desconto no produto
     */
    public float getTotalProductDiscount() {
        return totalProductDiscount;
    }

    /**
     * Atribui na variavel "{@link #totalProductDiscount}" o valor total de desconto no produto
     * @param totalProductDiscount float - Valor total de desconto no produto
     */
    public void setTotalProductDiscount(float totalProductDiscount) {
        this.totalProductDiscount = totalProductDiscount;
    }

    /**
     * @return int - Numero da mesa do estabelecimento
     */
    public int getTable() {
        return table;
    }

    /**
     * Atribui o numero da mesa do estabelecimento na variavel "{@link #table}"
     * @param table int - Numero da mesa do estabelecimento
     */
    public void setTable(int table) {
        this.table = table;
    }

    /**
     * @return Product - Classe Model de produto
     */
    public Product getmProduct() {
        return mProduct;
    }

    /**
     * Atribui o produto na Classe Model {@link Product}
     * @param mProduct {@link Product} - Classe Model de produto
     */
    public void setmProduct(Product mProduct) {
        this.mProduct = mProduct;
    }

    /**
     * @return CompanyBR - Classe Model da Empresa/Filial
     */
    public CompanyBR getmCompany() {
        return mCompany;
    }

    /**
     * Atribui a Empresa/Filial na Classe Model {@link CompanyBR}
     * @param mCompany {@link CompanyBR} - Classe Model da Empresa/Filial
     */
    public void setmCompany(CompanyBR mCompany) {
        this.mCompany = mCompany;
    }

    /**
     * @return User - Classe Model de usuario
     */
    public User getmUser() {
        return mUser;
    }

    /**
     * Atribui o usuario na Classe Model {@link User}
     * @param mUser {@link User} - Classe Model de usuario
     */
    public void setmUser(User mUser) {
        this.mUser = mUser;
    }

    public String getProductHTML() {
        return "<html>"
                + "<table cellpadding='0'; cellspacing='0'; width='100%'><tr><td width='45px'>"+
                    // LINHA DO ITEM
                    Format.formatProductRowIndex.format(getProductRowIndex())
                +"</td><td width='120px'>"+
                    // CODIGO DE BARRAS
                    Format.formatBarcode.format(getmProduct().getBarcode())
                +"</td><td width='500px'>"+
                    // DESCRICAO
                    getmProduct().getDescriptionCoupon()
                +"</td></tr></table>"

                + "<table cellpadding='0'; cellspacing='0'; width='100%'><tr><td align='right'; width='55px'>"+
                    // QUANTIDADE
                    Format.formatQty.format(getQuantity())
                +"</td><td align='center'; width='35px'>"+
                    // UNIDADE
                    getmProduct().getmUnits().getDescription()
                +"</td><td align='center'; width='25px'>X</td><td width='100px'>"+
                    // PRECO DE VENDA
                    Format.brCurrencyFormat.format(getmProduct().getSalePrice())
                +"</td><td width='90px'; color='#088A29'>"+
                    // DESCONTO
                    (getTotalProductDiscount() != 0 ? Format.brCurrencyFormat.format(-getTotalProductDiscount()) : "")
                +"</td><td align='right'>"+
                    // VALOR TOTAL
                    Format.brCurrencyFormat.format(getTotalProductValue())
                +"</td></tr></table>"+
                "</html>";
    }
}