package br.com.ernanilima.jpdv.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * TableCellRenderer da JTable de produtos
 *
 * @author Ernani Lima
 */
public class ProductFrontRenderer extends DefaultTableCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Alterna as cores a cada linha inserida na JTable
        if (row % 2 == 0) {
            setBackground(new Color(0,0,0,5));
        } else {
            setBackground(new Color(0, 0, 0, 20));
        }

        // Define a cor da linha selecionada na JTable
        if (isSelected) {
            setBackground(new Color(0,0,0,40));
        }

        table.getTableHeader().setReorderingAllowed(false);
        table.getColumnModel().getColumn(0).setResizable(false);

        return this;
    }
}
