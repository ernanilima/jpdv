package br.com.ernanilima.jpdv.Dao;

import br.com.ernanilima.jpdv.Connection.ConnectionSQLite;
import br.com.ernanilima.jpdv.Model.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static br.com.ernanilima.jpdv.Connection.ConnectionSQLite.closeSQLite;

/**
 * Classe DAO forma de pagamento
 *
 * @author Ernani Lima
 */
public class PaymentDao {

    /**
     * Cria uma lista com todas as formas de pagamento gravadas no bando de dados.
     * @return List {@link Payment} - Lista de formas de pagamento
     */
    public List<Payment> listPayments() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Payment> lsPayments = new ArrayList<>();
        String sql = "SELECT * FROM forpag";

        try {
            conn = ConnectionSQLite.openConnectionParame();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Payment mPayment = new Payment();
                mPayment.setId(rs.getInt("cod_fpag"));
                mPayment.setDescription(rs.getString("desc_fpag"));
                lsPayments.add(mPayment);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO AO ABRIR CONEXAO COM PARAME: " + e);
        } catch (SQLException e) {
            System.out.println("ERRO AO GERAR A LISTA DE FORMAS DE PAGAMENTO: " + e);
        } finally {
            closeSQLite(conn, pst, rs);
        }
        return lsPayments;
    }
}
