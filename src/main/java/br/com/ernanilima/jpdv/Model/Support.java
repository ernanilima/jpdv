package br.com.ernanilima.jpdv.Model;

/**
 * Classe com os dados de acesso do suporte tecnico.
 *
 * @author Ernani Lima
 */
public class Support {

    /** ID do usuario Suporte */
    private int id = 999;

    /**
     * Senha do usuario Suporte criptografada em sha256
     * @see br.com.ernanilima.jpdv.Util.Encrypt
     */
    private String pwd = "83CF8B609DE60036A8277BD0E96135751BBC07EB234256D4B65B893360651BF2";

    // Construtor vazio
    public Support() {}

    /**
     * @return int - ID do usuario Suporte
     */
    public int getId() {
        return id;
    }

    /**
     * @return String - Senha do usuario Suporte
     */
    public String getPwd() {
        return pwd;
    }
}