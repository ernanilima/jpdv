package br.com.ernanilima.jpdv.Model;

/**
 * Model de unidade de medida
 *
 * @author Ernani Lima
 */
public class Unit {

    private int id;
    private String description;

    // Construtor vazio
    public Unit() {}

    /**
     * @return int - ID da unidade de medida
     */
    public int getId() {
        return id;
    }

    /**
     * @param id int - ID da unidade de medida
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String - Descricao da unidade de medida
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description String - Descricao da unidade de medida
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
