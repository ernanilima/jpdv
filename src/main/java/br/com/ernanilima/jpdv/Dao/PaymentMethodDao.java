package br.com.ernanilima.jpdv.Dao;

import br.com.ernanilima.jpdv.Connection.ConnectionSQLite;
import br.com.ernanilima.jpdv.Model.PaymentMethod;

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
public class PaymentMethodDao {

    /**
     * Cria uma lista com todas as formas de pagamento
     * @return List {@link PaymentMethod} - Lista de formas de pagamento
     */
    public List<PaymentMethod> listPayments() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<PaymentMethod> lsPayments = new ArrayList<>();
        String sql = "SELECT * FROM fpagamento";

        try {
            conn = ConnectionSQLite.openConnectionParame();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                PaymentMethod mPayment = new PaymentMethod();
                mPayment.setId(rs.getInt("cod"));
                mPayment.setDescription(rs.getString("desc"));
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
