package br.com.ernanilima.jpdv.Dao;

import br.com.ernanilima.jpdv.Connection.ConnectionSQLite;
import br.com.ernanilima.jpdv.Model.CompanyBR;
import br.com.ernanilima.jpdv.Model.OpeningPDV;
import br.com.ernanilima.jpdv.Model.PDV;
import br.com.ernanilima.jpdv.Model.User;

import java.sql.*;

import static br.com.ernanilima.jpdv.Connection.ConnectionSQLite.closeSQLite;

/**
 * Classe DAO de Abertura de caixa PDV
 *
 * @author Ernani Lima
 */
public class OpeningPDVDao {

    /**
     * Realiza busca para saber se ja foi realizado abertura de caixa PDV
     * @param mOpeningPDV {@link OpeningPDV} - Model de abertuda de caixa PDV
     * @return boolean - "true" se PDV ja estiver aberto
     */
    public boolean checkOpeningPDV(OpeningPDV mOpeningPDV) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM opening WHERE status = ?";

        try {
            conn = ConnectionSQLite.openConnectionFinanc();
            pst = conn.prepareStatement(sql);
            pst.setBoolean(1, true);
            rs = pst.executeQuery();

            if (rs.next()) {
                CompanyBR mCompanyBR = new CompanyBR();
                User mUser = new User();
                PDV mPdv = new PDV();

                mOpeningPDV.setId(rs.getInt("id"));
                mCompanyBR.setId(rs.getInt("cod_filial"));
                mOpeningPDV.setmCompany(mCompanyBR);
                mPdv.setId(rs.getInt("cod_pdv"));
                mOpeningPDV.setmPDV(mPdv);
                mUser.setId(rs.getInt("cod_ope"));
                mOpeningPDV.setmUser(mUser);
                mOpeningPDV.setSupervisorID(rs.getInt("cod_sup"));
                mOpeningPDV.setInitialValue(rs.getDouble("initial_value"));
                mOpeningPDV.setDate(Date.valueOf(rs.getString("opening_date")));
                mOpeningPDV.setHour(Time.valueOf(rs.getString("opening_time")));
                mOpeningPDV.setStatus(rs.getBoolean("status"));
                return true;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO AO ABRIR CONEXAO COM FINANC: " + e);
        } catch (SQLException e) {
            System.out.println("ERRO AO REALIZAR BUSCA EM FINANC: " + e);
        } finally {
            closeSQLite(conn, pst, rs);
        }
        return false;
    }

    /**
     * Salva a abertura de caixa PDV
     * @param mOpeningPDV {@link OpeningPDV} - Model de abertuda de caixa PDV
     */
    public void saveOpeningPDV(OpeningPDV mOpeningPDV) {
        Connection conn = null;
        PreparedStatement pst = null;
        String sql = "INSERT INTO opening ("
                + "cod_filial, cod_pdv, cod_ope, cod_sup, initial_value, opening_date, opening_time, status) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = ConnectionSQLite.openConnectionFinanc();
            pst = conn.prepareStatement(sql);

            pst.setInt(1, mOpeningPDV.getmCompany().getId());
            pst.setInt(2, mOpeningPDV.getmPDV().getId());
            pst.setInt(3, mOpeningPDV.getmUser().getId());
            pst.setInt(4, mOpeningPDV.getSupervisorID());
            pst.setDouble(5, mOpeningPDV.getInitialValue());
            pst.setString(6, String.valueOf(mOpeningPDV.getDate()));
            pst.setString(7, String.valueOf(mOpeningPDV.getHour()));
            pst.setBoolean(8, mOpeningPDV.isStatus());
            pst.executeUpdate();
            System.out.println("GRAVOU A ABERTURA DE CAIXA PDV");

        } catch (ClassNotFoundException e) {
            System.out.println("ERRO AO ABRIR CONEXAO COM FINANC: " + e);
        } catch (SQLException e) {
            System.out.println("ERRO AO SALVAR ABERTURA DE CAIXA PDV: " + e);
        } finally {
            closeSQLite(conn, pst);
        }
    }
}
