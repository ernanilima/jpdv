package br.com.ernanilima.jpdv.Dao;

import br.com.ernanilima.jpdv.Connection.ConnectionSQLite;
import br.com.ernanilima.jpdv.Model.Coupon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static br.com.ernanilima.jpdv.Connection.ConnectionSQLite.closeSQLite;

/**
 * Classe DAO de cupom
 *
 * @author Ernani Lima
 */
public class CouponDao {

    /**
     * Salva os dados de venda de cupom
     * @param mCoupon {@link Coupon} - Model de cupom
     */
    public void saveSaleCoupon(Coupon mCoupon) {
        Connection conn = null;
        PreparedStatement pst = null;
        String sql = "INSERT INTO vendpdv ("
                + "cod_filial, cod_pdv, cod_pag01, val_fpg01, cod_pag02, val_fpg02, cod_pag03, val_fpg03, "
                + "cup_total, cup_desconto, cod_ope, cod_sup, cup_canc, data_data, data_hora, vend_status, cod_mesa) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = ConnectionSQLite.openConnection();
            pst = conn.prepareStatement(sql);

            pst.setInt(1, mCoupon.getmCompany().getId());
            pst.setInt(2, 1); // PENDENTE DE DEFINIR CODIGO DO PDV
            pst.setInt(3, mCoupon.getFormOfPayment1());
            pst.setFloat(4,mCoupon.getPaymentAmount1());
            pst.setInt(5, mCoupon.getFormOfPayment2());
            pst.setFloat(6,mCoupon.getPaymentAmount2());
            pst.setInt(7, mCoupon.getFormOfPayment3());
            pst.setFloat(8,mCoupon.getPaymentAmount3());
            pst.setFloat(9, mCoupon.getTotalCouponValue());
            pst.setFloat(10, mCoupon.getTotalDiscount());
            pst.setInt(11, mCoupon.getmUser().getId());
            pst.setInt(12, 0); // PENDENTE DE DEFINIR CODIGO DO SUPERVISOR
            pst.setBoolean(13, mCoupon.isCouponCanceled());
            pst.setString(14, String.valueOf(mCoupon.getDate()));
            pst.setString(15, String.valueOf(mCoupon.getHour()));
            pst.setBoolean(16, mCoupon.isCouponStatus());
            pst.setInt(17, mCoupon.getTable());
            pst.executeUpdate();
            System.out.println("GRAVOU A VENDA NO BANCO DE DADOS");

        } catch (ClassNotFoundException e) {
            System.out.println("ERRO AO ABRIR CONEXAO COM DBJPDV: " + e);
        } catch (SQLException e) {
            System.out.println("ERRO AO REALIZAR SALVAR VENDA: " + e);
        } finally {
            closeSQLite(conn, pst);
        }
    }

    /**
     * Salva os produtos de cupom
     * @param mCoupon {@link Coupon} - Model de cupom
     */
    public void saveCouponProducts(Coupon mCoupon) {
        // PENDENTE DE CRIACAO
    }
}
