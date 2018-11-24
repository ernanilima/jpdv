package br.com.ernanilima.jpdv.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * TableCellRenderer da JTable de pagamento recebido.
 *
 * @author Ernani Lima
 */
public class PaymentReceivedRenderer extends DefaultTableCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Alterna as cores a cada linha inserida na JTable
        if (row % 2 == 0) {
            setBackground(new Color(250, 250, 250));
        } else {
            setBackground(new Color(240, 240, 240));
        }

        table.getTableHeader().setReorderingAllowed(false);
        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(100); //DESCRICAO
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(1).setPreferredWidth(10); //VALOR

        return this;
    }
}
