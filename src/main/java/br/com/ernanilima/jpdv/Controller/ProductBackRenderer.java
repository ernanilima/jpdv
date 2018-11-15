package br.com.ernanilima.jpdv.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * TableCellRenderer da JTable de produtos back.
 * A tabela de produtos back eh onde o usuario pode escolher
 * produtos ja vendidos para cancelar
 *
 * @author Ernani Lima
 */
public class ProductBackRenderer extends DefaultTableCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Alterna as cores a cada linha inserida na JTable
        if (row % 2 == 0) {
            setBackground(new Color(250, 250, 250));
        } else {
            setBackground(new Color(240, 240, 240));
        }

        // Define a cor da linha selecionada na JTable
        if (isSelected) {
            setBackground(new Color(0, 0, 104));
        }

        table.getTableHeader().setReorderingAllowed(false);
        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(2).setResizable(false);
        table.getColumnModel().getColumn(3).setResizable(false);
        table.getColumnModel().getColumn(4).setResizable(false);
        table.getColumnModel().getColumn(5).setResizable(false);
        table.getColumnModel().getColumn(6).setResizable(false);
        table.getColumnModel().getColumn(7).setResizable(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(2); //ITEM
        table.getColumnModel().getColumn(1).setPreferredWidth(400); //DESCRIÇÃO
        table.getColumnModel().getColumn(2).setPreferredWidth(130); //COD. BARRAS
        table.getColumnModel().getColumn(3).setPreferredWidth(110); //PREÇO UN
        table.getColumnModel().getColumn(4).setPreferredWidth(50); //QUANTIDADE
        table.getColumnModel().getColumn(5).setPreferredWidth(20); //UNIDADE
        table.getColumnModel().getColumn(6).setPreferredWidth(110); //DESCONTO
        table.getColumnModel().getColumn(7).setPreferredWidth(110); //SUBTOTAL
        table.getColumnModel().getColumn(8).setPreferredWidth(2); //C

        return this;
    }
}
