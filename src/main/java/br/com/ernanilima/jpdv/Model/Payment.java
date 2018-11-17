package br.com.ernanilima.jpdv.Model;

/**
 * Model de forma de pagamento.
 *
 * @author Ernani Lima
 */
public class Payment {

    // Variaveis de forma de pagamento
    private int id;
    private String description;

    // Construtor vazio
    public Payment() {}

    /**
     * @return int - ID da forma de pagamento
     */
    public int getId() {
        return id;
    }

    /**
     * Atribui o ID da forma de pagamento na variavel "{@link #id}"
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
     * Atribui a descricao da forma de pagamento na variavel "{@link #description}"
     * @param description String - Descricao da forma de pagamento
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
