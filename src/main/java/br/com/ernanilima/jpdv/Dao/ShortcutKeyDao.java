package br.com.ernanilima.jpdv.Dao;

import br.com.ernanilima.jpdv.Connection.ConnectionSQLite;
import br.com.ernanilima.jpdv.Model.ShortcutKey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static br.com.ernanilima.jpdv.Connection.ConnectionSQLite.closeSQLite;

/**
 * Classe DAO de tecla de atalho do PDV
 *
 * @author Ernani Lima
 */
public class ShortcutKeyDao {

    /**
     * Cria uma lista com as teclas de atalho.
     * @return List {@link ShortcutKey} - Lista de teclas de atalho
     */
    public List<ShortcutKey> listShortcutKeys() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<ShortcutKey> lsShortcutKeys = new ArrayList<>();
        String sql = "SELECT * FROM tclatalho";

        try {
            conn = ConnectionSQLite.openConnectionParame();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                ShortcutKey mShortcutKey = new ShortcutKey();
                mShortcutKey.setId(rs.getInt("id"));
                mShortcutKey.setDescription(rs.getString("desc_atalho"));
                mShortcutKey.setKeyCode(rs.getInt("codtcl"));
                mShortcutKey.setKeyText(rs.getString("tecla"));
                lsShortcutKeys.add(mShortcutKey);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO AO ABRIR CONEXAO COM PARAME: " + e);
        } catch (SQLException e) {
            System.out.println("ERRO AO GERAR A LISTA DE TECLAS DE TALHO: " + e);
        } finally {
            closeSQLite(conn, pst, rs);
        }
        return lsShortcutKeys;
    }
}
