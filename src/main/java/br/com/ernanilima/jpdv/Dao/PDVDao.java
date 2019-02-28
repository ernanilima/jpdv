package br.com.ernanilima.jpdv.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.ernanilima.jpdv.Model.PDV;

import static br.com.ernanilima.jpdv.Connection.ConnectionSQLite.closeSQLite;
import static br.com.ernanilima.jpdv.Connection.ConnectionSQLite.openConnectionParame;

/**
 * Classe DAO dos dados do PDV
 *
 * @author Ernani Lima
 */
public class PDVDao {

    /**
     * Obtem os dados do PDV
     * @param mPdv {@link PDV} - Model dos dados do PDV
     * @return boolean - "true" se localizar os dados do PDV
     */
    public boolean getPDV(PDV mPdv) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM pdv LIMIT 1";

        try {
            conn = openConnectionParame();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                mPdv.setId(rs.getInt("id"));
                mPdv.setIp(rs.getString("ip"));
                mPdv.setReleasekey(rs.getString("releasekey"));
                mPdv.setVersion(rs.getString("version"));
                return true;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO AO ABRIR CONEXAO COM PARAME: " + e);
        } catch (SQLException e) {
            System.out.println("ERRO AO LOCALIZAR OS DADOS DO PDV: " + e);
        } finally {
            closeSQLite(conn, pst, rs);
        }
        return false;
    }
}
