package br.com.ernanilima.jpdv.Model.TableModel;

import br.com.ernanilima.jpdv.Model.Product;
import br.com.ernanilima.jpdv.Util.Format;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * TableModel de produtos.
 * A tabela de produtos eh onde o usuario pode escolher o
 * produto para adicionar na venda
 *
 * @author Ernani Lima
 */
public class ProductSearchTableModel extends AbstractTableModel {

    private static final int CODE = 0;
    private static final int DESCRIPTION = 1;
    private static final int BARCODE = 2;
    private static final int PRICE = 3;
    private static final int UNIT = 4;

    private final List<Product> lsProducts = new ArrayList<>();
    private final String[] columns = {"COD", "DESCRIÇÃO", "COD. BARRAS", "PREÇO UND", "UND"};

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
        System.out.println("LOOP GET SEARCH");
        switch (columnIndex) {
            case CODE:
                return lsProducts.get(rowIndex).getId();
            case DESCRIPTION:
                return lsProducts.get(rowIndex).getDescriptionCoupon();
            case BARCODE:
                return Format.formatBarcode.format(lsProducts.get(rowIndex).getBarcode());
            case PRICE:
                return Format.brCurrencyFormat.format(lsProducts.get(rowIndex).getSalePrice());
            case UNIT:
                return lsProducts.get(rowIndex).getmUnits().getDescription();
        }
        return null;
    }

    /**
     * @param mProduct {@link Product} - Model de produto
     */
    public void addRow(Product mProduct) {
        lsProducts.add(mProduct);
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
     * @return {@link Product} - Model de produto de acordo com o parametro informado
     */
    public Product getLs(int rowIndex) {
        return lsProducts.get(rowIndex);
    }
}
