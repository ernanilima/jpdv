package br.com.ernanilima.jpdv.Model;

/**
 * Model da Empresa/Filial
 *
 * @author Ernani Lima
 */
public class CompanyBR {

    // Variaveis da Empresa/Filial
    private int id;
    private String razaoSocial;
    private String nomeFantasia;
    private int cnpj;
    private int inscEstadual;
    private String endereco;
    private int numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String uf;

    // Construtor vazio
    public CompanyBR() {}

    /**
     * @return int - ID da Empresa/Filial
     */
    public int getId() {
        return id;
    }

    /**
     * Atribui o ID da Empresa/Filial na variavel "{@link #id}"
     * @param id int - ID da Empresa/Filial
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String - Razao Social da Empresa/Filial
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * Atribui a Razao Social da Empresa/Filial na variavel "{@link #razaoSocial}"
     * @param razaoSocial String - Razao Social da Empresa/Filial
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**
     * @return String - Nome Fantasia da Empresa/Filial
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     * Atribui o Nome Fantasia da Empresa/Filial na variavel "{@link #nomeFantasia}"
     * @param nomeFantasia String - Nome Fantasia da Empresa/Filial
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    /**
     * @return int - CNPJ da Empresa/Filial
     */
    public int getCnpj() {
        return cnpj;
    }

    /**
     * Atribui o CNPJ da Empresa/Filial na variavel "{@link #cnpj}"
     * @param cnpj int - CNPJ da Empresa/Filial
     */
    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return int - Inscricao Estadual da Empresa/Filial
     */
    public int getInscEstadual() {
        return inscEstadual;
    }

    /**
     * Atribui a Inscricao Estadual da Empresa/Filial na variavel "{@link #inscEstadual}"
     * @param inscEstadual int - Inscricao Estadual da Empresa/Filial
     */
    public void setInscEstadual(int inscEstadual) {
        this.inscEstadual = inscEstadual;
    }

    /**
     * @return String - Endereco da Empresa/Filial
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Atribui o Endereco da Empresa/Filial na variavel "{@link #endereco}"
     * @param endereco String - Endereco da Empresa/Filial
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return int - Numero (endereco) da Empresa/Filial
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Atribui o Numero (endereco) da Empresa/Filial na variavel "{@link #numero}"
     * @param numero int - Numero (endereco) da Empresa/Filial
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return String - Bairro da Empresa/Filial
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Atribui o Bairro da Empresa/Filial na variavel "{@link #bairro}"
     * @param bairro String - Bairro da Empresa/Filial
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return String - Complemento de endereco da Empresa/Filial
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * Atribui o Complemento de Endereco da Empresa/Filial na variavel "{@link #complemento}"
     * @param complemento String - Complemento de endereco da Empresa/Filial
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return String - Cidade da Empresa/Filial
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Atribui a Cidade da Empresa/Filial na variavel "{@link #cidade}"
     * @param cidade String - Cidade da Empresa/Filial
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return String - Estado (unidade federativa) da Empresa/Filial
     */
    public String getUf() {
        return uf;
    }

    /**
     * Atribui o Estado (unidade federativa) da Empresa/Filial na variavel "{@link #uf}"
     * @param uf String - Estado (unidade federativa) da Empresa/Filial
     */
    public void setUf(String uf) {
        this.uf = uf;
    }
}