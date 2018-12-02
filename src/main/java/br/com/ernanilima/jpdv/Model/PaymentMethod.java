package br.com.ernanilima.jpdv.Model;

/**
 * Model de forma de pagamento.
 *
 * @author Ernani Lima
 */
public class PaymentMethod {

    private int id;
    private String description;

    // Construtor vazio
    public PaymentMethod() {}

    /**
     * @return int - ID da forma de pagamento
     */
    public int getId() {
        return id;
    }

    /**
     * @param id int - ID da forma de pagamento
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String - Descricao da forma de pagamento
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description String - Descricao da forma de pagamento
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
