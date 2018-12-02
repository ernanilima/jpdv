package br.com.ernanilima.jpdv.Model.TableModel;

import br.com.ernanilima.jpdv.Model.Coupon;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * TableModel de produtos front.
 * A tabela de produtos front eh a tabela que exibe os
 * produtos vendidos
 *
 * @author Ernani Lima
 */
public class ProductFrontTableModel extends AbstractTableModel {

    private static final int PRODUCT_SOLD = 0;

    private final List<Coupon> lsProducts = new ArrayList<>();

    /**
     * @return int - Quantidade total de linhas
     */
    @Override
    public int getRowCount() {
        return lsProducts.size();
    }

    /**
     * @return int - Quantidade total de colunas
     */
    @Override
    public int getColumnCount() {
        return 1;
    }

    /**
     * @param rowIndex int - Linha
     * @param columnIndex int - Coluna
     * @return Object - Conteudo da celula especificada
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case PRODUCT_SOLD:
                return lsProducts.get(rowIndex).getProductHTML();
        }
        return null;
    }

    /**
     * @param mCoupon {@link Coupon} - Model de cupom
     */
    public void addRow(Coupon mCoupon) {
        lsProducts.add(mCoupon);
        fireTableDataChanged(); // ATUALIZA A JTABLE
    }

    /**
     * @param rowIndex int - Linha para remover
     */
    public void removeRow(int rowIndex) {
        lsProducts.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex); // ATUALIZA A LINHA REMOVIDA DA JTABLE
    }
}
