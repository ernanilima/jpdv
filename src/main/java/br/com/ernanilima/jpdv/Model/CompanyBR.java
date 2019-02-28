package br.com.ernanilima.jpdv.Model;

/**
 * Model da Empresa/Filial
 *
 * @author Ernani Lima
 */
public class CompanyBR {

    private int id;
    private String razaoSocial;
    private String nomeFantasia;
    private long cnpj;
    private long inscEstadual;
    private String endereco;
    private String numero;
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
     * @param nomeFantasia String - Nome Fantasia da Empresa/Filial
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    /**
     * @return long - CNPJ da Empresa/Filial
     */
    public long getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj long - CNPJ da Empresa/Filial
     */
    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return long - Inscricao Estadual da Empresa/Filial
     */
    public long getInscEstadual() {
        return inscEstadual;
    }

    /**
     * @param inscEstadual long - Inscricao Estadual da Empresa/Filial
     */
    public void setInscEstadual(long inscEstadual) {
        this.inscEstadual = inscEstadual;
    }

    /**
     * @return String - Endereco da Empresa/Filial
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco String - Endereco da Empresa/Filial
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return String - Numero (endereco) da Empresa/Filial
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero String - Numero (endereco) da Empresa/Filial
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return String - Bairro da Empresa/Filial
     */
    public String getBairro() {
        return bairro;
    }

    /**
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
     * @param uf String - Estado (unidade federativa) da Empresa/Filial
     */
    public void setUf(String uf) {
        this.uf = uf;
    }
}