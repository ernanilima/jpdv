package br.com.ernanilima.jpdv.Model.TableModel;

import br.com.ernanilima.jpdv.Model.Coupon;
import br.com.ernanilima.jpdv.Util.Format;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Table Model de produtos back.
 * A tabela de produtos back eh onde o usuario pode escolher
 * produtos ja vendidos para cancelar
 *
 * @author Ernani Lima
 */
public class ProductBackTableModel extends AbstractTableModel {

    // Constantes representando o indice das colunas
    private static final int ITEM = 0;
    private static final int DESCRICAO = 1;
    private static final int COD_BARRAS = 2;
    private static final int PRECO_UND = 3;
    private static final int QUANTIDADE = 4;
    private static final int UNIDADE = 5;
    private static final int DESCONTO = 6;
    private static final int SUBTOTAL = 7;
    private static final int CANCELADO = 8;

    // Lista de produtos do cupom
    private final List<Coupon> lsProducts = new ArrayList<>();
    private final String[] columns = {"ITEM", "DESCRIÇÃO", "COD. BARRAS", "PREÇO UND", "QTD", "UND", "DESCONTO", "SUBTOTAL", "C"};

    /**
     * Determinha o nome de cada coluna da JTable
     * @param column int - indice da coluna
     * @return String - Nome da coluna
     */
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    /**
     * Com esta informacao, a JTable sabe quantas linhas devem ser exibidas
     * @return int - Quantidade total de linhas
     */
    @Override
    public int getRowCount() {
        return lsProducts.size();
    }

    /**
     * O valor retornado define a quantidade de colunas da JTable
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
            case ITEM:
                return Format.formatThreeDigits.format(lsProducts.get(rowIndex).getProductRowIndex());
            case DESCRICAO:
                return lsProducts.get(rowIndex).getmProduct().getDescriptionCoupon();
            case COD_BARRAS:
                return Format.formatBarcode.format(lsProducts.get(rowIndex).getmProduct().getBarcode());
            case PRECO_UND:
                return Format.brCurrencyFormat.format(lsProducts.get(rowIndex).getmProduct().getSalePrice());
            case QUANTIDADE:
                return Format.formatQty.format(lsProducts.get(rowIndex).getQuantity());
            case UNIDADE:
                return lsProducts.get(rowIndex).getmProduct().getmUnits().getDescription();
            case DESCONTO:
                return Format.brCurrencyFormat.format(lsProducts.get(rowIndex).getTotalProductDiscount());
            case SUBTOTAL:
                return Format.brCurrencyFormat.format(lsProducts.get(rowIndex).getTotalProductValue());
            case CANCELADO:
                return lsProducts.get(rowIndex).isProductCanceled();
        }
        return null;
    }

    /**
     * Metodo utilizado para atualizar algum conteudo da JTable
     * @param aValue Object - Conteudo a ser atualizado na JTable
     * @param rowIndex int - linha
     * @param columnIndex int - Coluna
     */
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case DESCONTO:
                lsProducts.get(rowIndex).setTotalProductDiscount((double) aValue);
                break;
            case CANCELADO:
                lsProducts.get(rowIndex).setProductCanceled((Boolean) aValue);
                break;
        }

        // Notifica que as linhas na faixa especificada
        // tiveram seu conteudo modificado
        fireTableRowsUpdated(rowIndex, columnIndex);
    }

    /**
     * Metodo que adiciona produto na JTable
     * @param mCoupon {@link Coupon} - Model de cupom
     */
    public void addRow(Coupon mCoupon) {
        // Adiciona novo produto a tabela
        lsProducts.add(mCoupon);

        // Notifica a JTable que todos os dados da tabela podem ter sido alterados.
        // A JTable usa esta informacao para redesenhar todas as celulas, atualizando seu conteudo.
        fireTableDataChanged();
    }

    /**
     * Remove linha da JTable
     * @param rowIndex int - Linha para remover
     */
    public void removeRow(int rowIndex) {
        // Remove a linha informada
        lsProducts.remove(rowIndex);

        //Notifica a JTable que determinada linha foi removida
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    /**
     * Utilizado para obter conteudo nao exibido na JTable
     * @param rowIndex int - Linha que deseja obter o conteudo
     * @return {@link Coupon} - Model de cupom de acordo com o parametro informado
     */
    public Coupon getLs(int rowIndex) {
        return lsProducts.get(rowIndex);
    }
}
