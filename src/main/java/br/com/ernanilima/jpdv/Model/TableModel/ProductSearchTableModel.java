package br.com.ernanilima.jpdv.Model.TableModel;

import br.com.ernanilima.jpdv.Model.Product;
import br.com.ernanilima.jpdv.Util.Format;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Table Model de produtos.
 * A tabela de produtos eh onde o usuario pode escolher o
 * produto para adicionar na venda
 *
 * @author Ernani Lima
 */
public class ProductSearchTableModel extends AbstractTableModel {

    // Constantes representando o indice das colunas
    private static final int COD = 0;
    private static final int DESCRICAO = 1;
    private static final int COD_BARRAS = 2;
    private static final int PRECO_UND = 3;
    private static final int UNIDADE = 4;

    // Lista de produtos do cupom
    private final List<Product> lsProducts = new ArrayList<>();
    private final String[] columns = {"COD", "DESCRIÇÃO", "COD. BARRAS", "PREÇO UND", "UND"};

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
     * O valor retornado define a quantidade de colinas na JTable
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
            case COD:
                return lsProducts.get(rowIndex).getId();
            case DESCRICAO:
                return lsProducts.get(rowIndex).getDescriptionCoupon();
            case COD_BARRAS:
                return Format.formatBarcode.format(lsProducts.get(rowIndex).getBarcode());
            case PRECO_UND:
                return Format.brCurrencyFormat.format(lsProducts.get(rowIndex).getSalePrice());
            case UNIDADE:
                return lsProducts.get(rowIndex).getmUnits().getDescription();
        }
        return null;
    }

    /**
     * Adiciona produto na JTable
     * @param mProduct {@link Product} - Model de produto
     */
    public void addRow(Product mProduct) {
        // Adiciona produto na tabela
        lsProducts.add(mProduct);

        // Notifica a JTable que todos os dados da tabela podem ter sido alterados.
        // A JTable usa esta informacao para redesenhar todas as celulas, atualizando seu conteudo.
        fireTableDataChanged();
    }

    /**
     * Remove produto da JTable
     * @param rowIndex int - Linha para remover
     */
    public void removeRow(int rowIndex) {
        // Remove o produto da linha informada
        lsProducts.remove(rowIndex);

        //Notifica a JTable que determinada linha foi removida
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    /**
     * Utilizado para obter conteudo nao exibido na JTable
     * @param rowIndex int - Linha que deseja obter o conteudo
     * @return {@link Product} - Model de produto de acordo com o parametro informado
     */
    public Product getLs(int rowIndex) {
        return lsProducts.get(rowIndex);
    }
}
