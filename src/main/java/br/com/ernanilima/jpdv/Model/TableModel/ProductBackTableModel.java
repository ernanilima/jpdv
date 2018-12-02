package br.com.ernanilima.jpdv.Model.TableModel;

import br.com.ernanilima.jpdv.Model.Coupon;
import br.com.ernanilima.jpdv.Util.Format;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * TableModel de produtos back.
 * A tabela de produtos back eh onde o usuario pode escolher
 * algum produtos vendidos para cancelar
 *
 * @author Ernani Lima
 */
public class ProductBackTableModel extends AbstractTableModel {

    private static final int ROW = 0;
    private static final int DESCRIPTION = 1;
    private static final int BARCODE = 2;
    private static final int PRICE = 3;
    private static final int QUANTITY = 4;
    private static final int UNIT = 5;
    private static final int DISCOUNT = 6;
    private static final int SUBTOTAL = 7;
    private static final int CANCELED = 8;

    private final List<Coupon> lsProducts = new ArrayList<>();
    private final String[] columns = {"ITEM", "DESCRIÇÃO", "COD. BARRAS", "PREÇO UND", "QTD", "UND", "DESCONTO", "SUBTOTAL", "C"};

    /**
     * @param column int - indice da coluna
     * @return String - Nome da coluna
     */
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

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
        return columns.length;
    }

    /**
     * @param rowIndex int - Linha
     * @param columnIndex int - Coluna
     * @return Object - Conteudo da celula especificada
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        System.out.println("LOOP BACK");
        switch (columnIndex) {
            case ROW:
                return Format.formatThreeDigits.format(lsProducts.get(rowIndex).getProductRowIndex());
            case DESCRIPTION:
                return lsProducts.get(rowIndex).getmProduct().getDescriptionCoupon();
            case BARCODE:
                return Format.formatBarcode.format(lsProducts.get(rowIndex).getmProduct().getBarcode());
            case PRICE:
                return Format.brCurrencyFormat.format(lsProducts.get(rowIndex).getmProduct().getSalePrice());
            case QUANTITY:
                return Format.formatQty.format(lsProducts.get(rowIndex).getQuantity());
            case UNIT:
                return lsProducts.get(rowIndex).getmProduct().getmUnits().getDescription();
            case DISCOUNT:
                return Format.brCurrencyFormat.format(lsProducts.get(rowIndex).getTotalProductDiscount());
            case SUBTOTAL:
                return Format.brCurrencyFormat.format(lsProducts.get(rowIndex).getTotalProductValue());
            case CANCELED:
                return (lsProducts.get(rowIndex).isProductCanceled() ? "*" : "");
        }
        return null;
    }

    /**
     * @param aValue Object - Conteudo a ser atualizado na JTable
     * @param rowIndex int - linha
     * @param columnIndex int - Coluna
     */
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case DISCOUNT:
                lsProducts.get(rowIndex).setTotalProductDiscount((double) aValue);
                break;
            case CANCELED:
                lsProducts.get(rowIndex).setProductCanceled((Boolean) aValue);
                break;
        }

        fireTableRowsUpdated(rowIndex, columnIndex); // ATUALIZA A LINHA DA JTABLE
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

    /**
     * Utilizado para obter algum conteudo exibido ou nao na JTable
     * @param rowIndex int - Linha que deseja obter o conteudo
     * @return {@link Coupon} - Model de cupom de acordo com o parametro informado
     */
    public Coupon getLs(int rowIndex) {
        return lsProducts.get(rowIndex);
    }
}
