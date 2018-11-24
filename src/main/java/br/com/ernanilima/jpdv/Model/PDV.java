package br.com.ernanilima.jpdv.Model;

/**
 * Model do PDV
 *
 * @author Ernani Lima
 */
public class PDV {

    // Variaveis do PDV
    private int id;
    private String ip;
    private String version;

    // Construtor vazio
    public PDV() {}

    /**
     * @return int - ID do PDV
     */
    public int getId() {
        return id;
    }

    /**
     * @param id int - ID do PDV
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String - IP do PDV
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip String - IP do PDV
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return String - Versao do sistema do PDV
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version String - Versao do sistema do PDV
     */
    public void setVersion(String version) {
        this.version = version;
    }
}
