package br.com.ernanilima.jpdv.Model;

/**
 * Model de produto
 *
 * @author Ernani Lima
 */
public class Product {

    private int id;
    private String description;
    private String descriptionCoupon;
    private long barcode;
    private double salePrice;
    private double promotionalPrice;
    private Unit mUnit;

    // Construtor vazio
    public Product() {}

    /**
     * @return int - ID do produto
     */
    public int getId() {
        return id;
    }

    /**
     * @param id int - ID do produto
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String - Descricao do produto
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description String - Descricao do produto
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return String - Descricao de cupom do produto
     */
    public String getDescriptionCoupon() {
        return descriptionCoupon;
    }

    /**
     * @param descriptionCoupon String - Descricao de cupom do produto
     */
    public void setDescriptionCoupon(String descriptionCoupon) {
        this.descriptionCoupon = descriptionCoupon;
    }

    /**
     * @return long - Codigo de barras do produto
     */
    public long getBarcode() {
        return barcode;
    }

    /**
     * @param barCode long - Codigo de barras do produto
     */
    public void setBarcode(long barCode) {
        this.barcode = barCode;
    }

    /**
     * @return double - Preco de venda do produto
     */
    public double getSalePrice() {
        return salePrice;
    }

    /**
     * @param salePrice double - Preco de venda do produto
     */
    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * @return double - Preco promocional do produto
     */
    public double getPromotionalPrice() {
        return promotionalPrice;
    }

    /**
     * @param promotionalPrice double - Preco promocional do produto
     */
    public void setPromotionalPrice(double promotionalPrice) {
        this.promotionalPrice = promotionalPrice;
    }

    /**
     * @return Unit - Unidade de pedida do produto
     */
    public Unit getmUnits() {
        return mUnit;
    }

    /**
     * @param mUnits {@link Unit} - Unidade de medida do produto
     */
    public void setmUnits(Unit mUnits) {
        this.mUnit = mUnits;
    }
}
