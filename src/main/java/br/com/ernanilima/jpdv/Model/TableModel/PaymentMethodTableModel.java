package br.com.ernanilima.jpdv.Model.TableModel;

import br.com.ernanilima.jpdv.Model.PaymentMethod;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * TableModel de formas de pagamento.
 *
 * @author Ernani Lima
 */
public class PaymentMethodTableModel extends AbstractTableModel {

    private static final int DESCRIPTION = 0;

    private final List<PaymentMethod> lsPayments = new ArrayList<>();
    private final String[] columns = {"FORMAS DE PAGAMENTO"};

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
        return lsPayments.size();
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
        System.out.println("LOOP GET PAYMENT METHOD");
        switch (columnIndex) {
            case DESCRIPTION:
                return lsPayments.get(rowIndex).getDescription();
        }
        return null;
    }

    /**
     * @param mPayment {@link PaymentMethod} - Model de forma de pagamento
     */
    public void addRow(PaymentMethod mPayment) {
        lsPayments.add(mPayment);
        fireTableDataChanged(); // ATUALIZA A JTABLE
    }

    /**
     * @param rowIndex int - Linha para remover
     */
    public void removeRow(int rowIndex) {
        lsPayments.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex); //Notifica a JTable que determinada linha foi removida
    }

    /**
     * Utilizado para obter algum conteudo exibido ou nao na JTable
     * @param rowIndex int - Linha que deseja obter o conteudo
     * @return {@link PaymentMethod} - Model de forma de pagamento
     */
    public PaymentMethod getLs(int rowIndex) {
        return lsPayments.get(rowIndex);
    }
}
