package br.com.ernanilima.jpdv.Model.TableModel;

import br.com.ernanilima.jpdv.Model.PaymentReceived;
import br.com.ernanilima.jpdv.Util.Format;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Table Model de pagamento recebido.
 *
 * @author Ernani Lima
 */
public class PaymentReceivedTableModel extends AbstractTableModel {

    // Constantes representando o indice das colunas
    private static final int DESCRICAO = 0;
    private static final int VALOR = 1;

    // Lista de pagamentos recebidos
    private final List<PaymentReceived> lsPaymentsReceived = new ArrayList<>();
    private final String[] columns = {"PAGAMENTO", "VALOR"};

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
        return lsPaymentsReceived.size();
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
        System.out.println("LOOP GET PAYMENT RECEIVED");
        switch (columnIndex) {
            case DESCRICAO:
                return lsPaymentsReceived.get(rowIndex).getmPayment().getDescription();
            case VALOR:
                return Format.brCurrencyFormat.format(lsPaymentsReceived.get(rowIndex).getValue());
        }
        return null;
    }

    /**
     * Adiciona pagamento recebido na JTable
     * @param mPaymentReceived {@link PaymentReceived} - Model de pagamento recebido
     */
    public void addRow(PaymentReceived mPaymentReceived) {
        // Adiciona novo pagamento recebido
        lsPaymentsReceived.add(mPaymentReceived);

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
        lsPaymentsReceived.remove(rowIndex);

        //Notifica a JTable que determinada linha foi removida
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    /**
     * Utilizado para obter conteudo exibido ou nao na JTable
     * @param rowIndex int - Linha que deseja obter o conteudo
     * @return {@link PaymentReceived} - Model de pagamento recebido
     */
    public PaymentReceived getLs(int rowIndex) {
        return lsPaymentsReceived.get(rowIndex);
    }
}
