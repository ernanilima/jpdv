package br.com.ernanilima.jpdv.Model.TableModel;

import br.com.ernanilima.jpdv.Model.PaymentReceived;
import br.com.ernanilima.jpdv.Util.Format;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * TableModel de pagamento recebido.
 *
 * @author Ernani Lima
 */
public class PaymentReceivedTableModel extends AbstractTableModel {

    private static final int DESCRIPTION = 0;
    private static final int VALUE = 1;

    private final List<PaymentReceived> lsPaymentsReceived = new ArrayList<>();
    private final String[] columns = {"PAGAMENTO", "VALOR"};

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
        return lsPaymentsReceived.size();
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
        System.out.println("LOOP GET PAYMENT RECEIVED");
        switch (columnIndex) {
            case DESCRIPTION:
                return lsPaymentsReceived.get(rowIndex).getmPayment().getDescription();
            case VALUE:
                return Format.brCurrencyFormat.format(lsPaymentsReceived.get(rowIndex).getValue());
        }
        return null;
    }

    /**
     * @param mPaymentReceived {@link PaymentReceived} - Model de pagamento recebido
     */
    public void addRow(PaymentReceived mPaymentReceived) {
        lsPaymentsReceived.add(mPaymentReceived);
        fireTableDataChanged(); // ATUALIZA A JTABLE
    }

    /**
     * @param rowIndex int - Linha para remover
     */
    public void removeRow(int rowIndex) {
        lsPaymentsReceived.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex); // ATUALIZA A LINHA REMOVIDA DA JTABLE
    }

    /**
     * Utilizado para obter algum conteudo exibido ou nao na JTable
     * @param rowIndex int - Linha que deseja obter o conteudo
     * @return {@link PaymentReceived} - Model de pagamento recebido
     */
    public PaymentReceived getLs(int rowIndex) {
        return lsPaymentsReceived.get(rowIndex);
    }
}
