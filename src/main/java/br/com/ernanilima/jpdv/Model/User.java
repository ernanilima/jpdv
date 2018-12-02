package br.com.ernanilima.jpdv.Model;

/**
 * Model de usuario
 *
 * @author Ernani Lima
 */
public class User {

    private int id;
    private String name;
    private String pwd;
    private int level;

    // Construtor vazio
    public User() {}

    /**
     * @return int - ID do usuario
     */
    public int getId() {
        return id;
    }

    /**
     * @param id int - ID do usuario
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String - Nome do usuario
     */
    public String getName() {
        return name;
    }

    /**
     * @param name String - Nome do usuario
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String - Senha do usuario
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd String - Senha do usuario
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return int - Nivel de acesso do usuario
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level int - Nivel de acesso do usuario
     */
    public void setLevel(int level) {
        this.level = level;
    }
}
