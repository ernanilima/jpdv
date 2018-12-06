package br.com.ernanilima.jpdv.Model;

import br.com.ernanilima.jpdv.Util.Filter;
import br.com.ernanilima.jpdv.Util.Format;

import java.sql.Date;
import java.sql.Time;

/**
 * Model de Cupom de PDV
 *
 * @author Ernani Lima
 */
public class Coupon {

    private int coupon;
    private boolean productCanceled;
    private int productRowIndex;
    private boolean couponCanceled;
    private Date date;
    private Time hour;
    private boolean couponStatus;
    private double quantity;
    //private double totalProductValue;
    private double totalCouponValue;
    private int formOfPayment1;
    private double paymentAmount1;
    private int formOfPayment2;
    private double paymentAmount2;
    private int formOfPayment3;
    private double paymentAmount3;
    private double totalDiscount;
    private double totalProductDiscount;
    private int supervisorID;
    private int table;
    private Product mProduct;
    private CompanyBR mCompany;
    private User mUser;
    private PDV mPDV;

    // Construtor vazio
    public Coupon() {}

    /**
     * @return int - Numero do cupom
     */
    public int getCoupon() {
        return coupon;
    }

    /**
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
     * @param couponStatus boolean - "True" para cupom gravado no servidor
     */
    public void setCouponStatus(boolean couponStatus) {
        this.couponStatus = couponStatus;
    }

    /**
     * @return double - Quantidade total do produto
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * @param quantity double - Quantidade total do produto
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * @return double - Valor total do produto
     */
    //public double getTotalProductValue() {
    //    return totalProductValue;
    //}
    public double getTotalProductValue() {
        return Filter.filterDouble(Format.roundingTwoUP.format((getQuantity() * mProduct.getSalePrice()) - getTotalProductDiscount()));
    }

    /**
     * @param totalProductValue double - Valor total do produto
     */
    /*public void setTotalProductValue(double totalProductValue) {
        this.totalProductValue = totalProductValue;
    }*/

    /**
     * @return double - Valor total do cupom
     */
    public double getTotalCouponValue() {
        return totalCouponValue;
    }

    /**
     * @param totalCouponValue double - Valor total do cupom
     */
    public void setTotalCouponValue(double totalCouponValue) {
        this.totalCouponValue = totalCouponValue;
    }

    /**
     * @return int - Forma de pagamento 1
     */
    public int getFormOfPayment1() {
        return formOfPayment1;
    }

    /**
     * @param formOfPayment1 int - Forma de pagamento 1
     */
    public void setFormOfPayment1(int formOfPayment1) {
        this.formOfPayment1 = formOfPayment1;
    }

    /**
     * @return double - Valor total do pagamento 1
     */
    public double getPaymentAmount1() {
        return paymentAmount1;
    }

    /**
     * @param paymentAmount1 double - Valor total do pagamento 1
     */
    public void setPaymentAmount1(double paymentAmount1) {
        this.paymentAmount1 = paymentAmount1;
    }

    /**
     * @return int - Forma de pagamento 2
     */
    public int getFormOfPayment2() {
        return formOfPayment2;
    }
    /**
     * @param formOfPayment2 int - Forma de pagamento 2
     */
    public void setFormOfPayment2(int formOfPayment2) {
        this.formOfPayment2 = formOfPayment2;
    }

    /**
     * @return double - Valor total do pagamento 2
     */
    public double getPaymentAmount2() {
        return paymentAmount2;
    }

    /**
     * @param paymentAmount2 double - Valor total do pagamento 2
     */
    public void setPaymentAmount2(double paymentAmount2) {
        this.paymentAmount2 = paymentAmount2;
    }

    /**
     * @return int - Forma de pagamento 3
     */
    public int getFormOfPayment3() {
        return formOfPayment3;
    }

    /**
     * @param formOfPayment3 int - Forma de pagamento 3
     */
    public void setFormOfPayment3(int formOfPayment3) {
        this.formOfPayment3 = formOfPayment3;
    }

    /**
     * @return double - Valor total do pagamento 3
     */
    public double getPaymentAmount3() {
        return paymentAmount3;
    }

    /**
     * @param paymentAmount3 double - Valor total do pagamento 3
     */
    public void setPaymentAmount3(double paymentAmount3) {
        this.paymentAmount3 = paymentAmount3;
    }

    /**
     * @return double - Valor total de desconto
     */
    public double getTotalDiscount() {
        return totalDiscount;
    }

    /**
     * @param totalDiscount double - Valor total de desconto
     */
    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    /**
     * @return double - Valor total de desconto no produto
     */
    public double getTotalProductDiscount() {
        return totalProductDiscount;
    }

    /**
     * @param totalProductDiscount double - Valor total de desconto no produto
     */
    public void setTotalProductDiscount(double totalProductDiscount) {
        this.totalProductDiscount = totalProductDiscount;
    }

    /**
     * @return int - ID do supervisor que realizou liberacao
     */
    public int getSupervisorID() {
        return supervisorID;
    }

    /**
     * @param supervisorID int - ID do supervisor que realizou liberacao
     */
    public void setSupervisorID(int supervisorID) {
        this.supervisorID = supervisorID;
    }

    /**
     * @return int - Numero da mesa do estabelecimento
     */
    public int getTable() {
        return table;
    }

    /**
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
     * @param mUser {@link User} - Classe Model de usuario
     */
    public void setmUser(User mUser) {
        this.mUser = mUser;
    }

    /**
     * @return PDV - Model do PDV
     */
    public PDV getmPDV() {
        return mPDV;
    }

    /**
     * @param mPDV - Model do PDV
     */
    public void setmPDV(PDV mPDV) {
        this.mPDV = mPDV;
    }


    public String getProductHTML() {
        if (isProductCanceled()) {
            return "<html>" // CANCELADO
                    + "<table cellpadding='0'; cellspacing='0'; width='100%'><tr><td width='45px'><strike>"+
                        // LINHA DO ITEM
                        Format.formatThreeDigits.format(getProductRowIndex())
                    +"</strike></td><td width='120px'><strike>"+
                        // CODIGO DE BARRAS
                        Format.formatBarcode.format(getmProduct().getBarcode())
                    +"</strike></td><td width='500px'><strike>"+
                        // DESCRICAO
                        getmProduct().getDescriptionCoupon()
                    +"</strike></td></tr></table>"

                    + "<table cellpadding='0'; cellspacing='0'; width='100%'><tr><td align='right'; width='55px'><strike>"+
                        // QUANTIDADE
                        Format.formatQty.format(getQuantity())
                    +"</strike></td><td align='center'; width='35px'><strike>"+
                        // UNIDADE
                        getmProduct().getmUnits().getDescription()
                    +"</strike></td><td align='center'; width='25px'><strike>" +
                        // MULTIPLICA
                        "X"
                    +"</strike></td><td width='100px'><strike>"+
                        // PRECO DE VENDA
                        Format.brCurrencyFormat.format(getmProduct().getSalePrice())
                    +"</strike></td><td width='90px'; color='#FF0000'>"+
                        "CANCELADO"
                    +"</td><td align='right'><strike>"+
                        // VALOR TOTAL
                        Format.brCurrencyFormat.format(getTotalProductValue())
                    +"</strike></td></tr></table>"+
                    "</html>";
        } else {
            return "<html>" // VENDA NORMAL
                    + "<table cellpadding='0'; cellspacing='0'; width='100%'><tr><td width='45px'>"+
                        // LINHA DO ITEM
                        Format.formatThreeDigits.format(getProductRowIndex())
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
                    +"</td><td align='center'; width='25px'>" +
                        // MULTIPLICA
                        "X"
                    +"</td><td width='100px'>"+
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
}