package br.com.ernanilima.jpdv.Model.TableModel;

import br.com.ernanilima.jpdv.Model.Payment;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Table Model de formas de pagamento.
 *
 * @author Ernani Lima
 */
public class PaymentTableModel extends AbstractTableModel {

    // Constantes representando o indice das colunas
    private static final int COD = 0;
    private static final int DESCRICAO = 1;

    // Lista de formas de pagamento
    private final List<Payment> lsPayments = new ArrayList<>();
    private final String[] columns = {"COD", "DESCRIÇÃO"};

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
        return lsPayments.size();
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
        System.out.println("LOOP GET PAYMENT");
        switch (columnIndex) {
            case COD:
                return lsPayments.get(rowIndex).getId();
            case DESCRICAO:
                return lsPayments.get(rowIndex).getDescription();
        }
        return null;
    }

    /**
     * Adiciona forma de pagamento na JTable
     * @param mPayment {@link Payment} - Model de forma de pagamento
     */
    public void addRow(Payment mPayment) {
        // Adiciona nova forma de pagamento a tabela
        lsPayments.add(mPayment);

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
        lsPayments.remove(rowIndex);

        //Notifica a JTable que determinada linha foi removida
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}
