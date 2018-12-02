package br.com.ernanilima.jpdv.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * TableCellRenderer da JTable de produtos front.
 * A tabela de produtos front eh a tabela que exibe os
 * produtos vendidos
 *
 * @author Ernani Lima
 */
public class ProductFrontRenderer extends DefaultTableCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        final int PRODUCT_SOLD = 0;

        // ALTERNA AS CORES DAS LINHAS
        if (row % 2 == 0) {
            setBackground(new Color(0,0,0,5));
        } else {
            setBackground(new Color(0, 0, 0, 15));
        }

        // DEFINE A COR DA LINHA SELECIONADA
        if (isSelected) {
            setBackground(new Color(0, 0, 104));
        }

        table.getTableHeader().setReorderingAllowed(false);
        table.getColumnModel().getColumn(PRODUCT_SOLD).setResizable(false);

        return this;
    }
}
