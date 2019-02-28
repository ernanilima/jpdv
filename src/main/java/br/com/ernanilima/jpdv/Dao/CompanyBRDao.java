package br.com.ernanilima.jpdv.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.ernanilima.jpdv.Model.CompanyBR;

import static br.com.ernanilima.jpdv.Connection.ConnectionSQLite.closeSQLite;
import static br.com.ernanilima.jpdv.Connection.ConnectionSQLite.openConnectionParame;

/**
 * Classe DAO da Empresa/Filial
 *
 * @author Ernani Lima
 */
public class CompanyBRDao {

    /**
     * Obtem os dados da Empresa/Filial
     * @param mCompanyBR {@link CompanyBR} - Model da Empresa/Filial
     * @return boolean - "true" se localizar a Empresa/Filial
     */
    public boolean getCompany(CompanyBR mCompanyBR) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM companybr LIMIT 1";

        try {
            conn = openConnectionParame();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                mCompanyBR.setId(rs.getInt("id"));
                mCompanyBR.setRazaoSocial(rs.getString("razaoSocial"));
                mCompanyBR.setNomeFantasia(rs.getString("nomeFantasia"));
                mCompanyBR.setCnpj(rs.getLong("cnpj"));
                mCompanyBR.setInscEstadual(rs.getLong("inscEstadual"));
                mCompanyBR.setEndereco(rs.getString("endereco"));
                mCompanyBR.setNumero(rs.getString("numero"));
                mCompanyBR.setBairro(rs.getString("bairro"));
                mCompanyBR.setComplemento(rs.getString("complemento"));
                mCompanyBR.setCidade(rs.getString("cidade"));
                mCompanyBR.setUf(rs.getString("uf"));
                return true;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO AO ABRIR CONEXAO COM PARAME: " + e);
        } catch (SQLException e) {
            System.out.println("ERRO AO LOCALIZAR OS DADOS DA FILIAL: " + e);
        } finally {
            closeSQLite(conn, pst, rs);
        }
        return false;
    }
}
