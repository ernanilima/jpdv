package br.com.ernanilima.jpdv.Dao;

import br.com.ernanilima.jpdv.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static br.com.ernanilima.jpdv.Connection.ConnectionSQLite.closeSQLite;
import static br.com.ernanilima.jpdv.Connection.ConnectionSQLite.openConnectionParame;

/**
 * Classe DAO do usuario de PDV
 *
 * @author Ernani Lima
 */
public class UserDao {

    /**
     * Realizar validacao de login de usuario de PDV
     * @param mUser {@link User} - Model de usuario
     * @return boolean - "true" se login realizado com sucesso
     */
    public boolean userLogin(User mUser) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM tabuser WHERE user_id = ? AND user_senha = ?";

        try {
            conn = openConnectionParame();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, mUser.getId());
            pst.setString(2, mUser.getPwd());

            rs = pst.executeQuery();

            if (rs.next()) {
                mUser.setId(rs.getInt("user_id"));
                mUser.setName(rs.getString("user_nome"));
                mUser.setLevel(rs.getInt("user_nivel"));
                return true;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO AO ABRIR CONEXAO COM PARAME: " + e);
        } catch (SQLException e) {
            System.out.println("ERRO AO REALIZAR LOGIN DE USUARIO: " + e);
        } finally {
            closeSQLite(conn, pst, rs);
        }
        return false;
    }
}