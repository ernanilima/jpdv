package br.com.ernanilima.jpdv.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * TableCellRenderer da JTable de busca de produtos.
 *
 * @author Ernani Lima
 */
public class ProductSearchRenderer extends DefaultTableCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        final int CODE = 0;
        final int DESCRIPTION = 1;
        final int BARCODE = 2;
        final int PRICE = 3;
        final int UNIT = 4;

        // ALTERNA AS CORES DAS LINHAS
        if (row % 2 == 0) {
            setBackground(new Color(250, 250, 250));
        } else {
            setBackground(new Color(240, 240, 240));
        }

        // DEFINE A COR DA LINHA SELECIONADA
        if (isSelected) {
            setBackground(new Color(0, 0, 104));
        }

        table.getTableHeader().setReorderingAllowed(false);
        table.getColumnModel().getColumn(CODE).setResizable(false);
        table.getColumnModel().getColumn(DESCRIPTION).setResizable(false);
        table.getColumnModel().getColumn(BARCODE).setResizable(false);
        table.getColumnModel().getColumn(PRICE).setResizable(false);
        table.getColumnModel().getColumn(UNIT).setResizable(false);
        table.getColumnModel().getColumn(CODE).setPreferredWidth(2);
        table.getColumnModel().getColumn(DESCRIPTION).setPreferredWidth(300);
        table.getColumnModel().getColumn(BARCODE).setPreferredWidth(100);
        table.getColumnModel().getColumn(PRICE).setPreferredWidth(100);
        table.getColumnModel().getColumn(UNIT).setPreferredWidth(10);

        return this;
    }
}
