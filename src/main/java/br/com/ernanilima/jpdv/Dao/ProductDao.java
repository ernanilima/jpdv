package br.com.ernanilima.jpdv.Dao;

import br.com.ernanilima.jpdv.Connection.ConnectionSQLite;
import br.com.ernanilima.jpdv.Model.Coupon;
import br.com.ernanilima.jpdv.Model.Product;
import br.com.ernanilima.jpdv.Model.Unit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static br.com.ernanilima.jpdv.Connection.ConnectionSQLite.closeSQLite;

/**
 * Classe DAO de prudoto
 *
 * @author Ernani Lima
 */
public class ProductDao {

    /**
     * Realiza busca de produto por codigo de barras, se localizar o produto, o Model eh atualizado
     * @param mCoupon {@link Coupon} - Model de cupom
     * @return boolean - "true" se produto encontrado
     */
    public boolean searchProductByBarcode(Coupon mCoupon) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM produtos WHERE cod_bar = ?";

        try {
            conn = ConnectionSQLite.openConnection();
            pst = conn.prepareStatement(sql);
            pst.setLong(1, mCoupon.getmProduct().getBarcode());
            rs = pst.executeQuery();

            if (rs.next()) {
                Product mProduct = new Product();
                Unit mUnit = new Unit();
                mProduct.setId(rs.getInt("cod_pro"));
                mProduct.setDescription(rs.getString("desc_pro"));
                mProduct.setDescriptionCoupon(rs.getString("desc_procp"));
                mProduct.setBarcode(rs.getLong("cod_bar"));
                mUnit.setId(rs.getInt("cod_un_medida"));
                mUnit.setDescription(rs.getString("desc_un_medida"));
                mProduct.setmUnits(mUnit);
                mProduct.setSalePrice(rs.getDouble("prec_vend"));
                mProduct.setPromotionalPrice(rs.getDouble("prec_prom"));
                mCoupon.setmProduct(mProduct);
                return true;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO AO ABRIR CONEXAO COM DBJPDV: " + e);
        } catch (SQLException e) {
            System.out.println("ERRO AO REALIZAR BUSCA DE PRODUTO: " + e);
        } finally {
            closeSQLite(conn);
        }
        return false;
    }
}
