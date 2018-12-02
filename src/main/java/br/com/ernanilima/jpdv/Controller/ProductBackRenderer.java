package br.com.ernanilima.jpdv.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

/**
 * TableCellRenderer da JTable de produtos back.
 * A tabela de produtos back eh onde o usuario pode escolher
 * algum produtos vendidos para cancelar
 *
 * @author Ernani Lima
 */
public class ProductBackRenderer extends DefaultTableCellRenderer implements TableCellRenderer {


    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        final int ROW = 0;
        final int DESCRIPTION = 1;
        final int BARCODE = 2;
        final int PRICE = 3;
        final int QUANTITY = 4;
        final int UNIT = 5;
        final int DISCOUNT = 6;
        final int SUBTOTAL = 7;
        final int CANCELED = 8;

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

        // RISCA A LINHA DO PRODUTO CANCELADO
        if (!table.getValueAt(row, CANCELED).equals("")) {
            Font font = new Font("Verdana", 0, 18);
            Map<TextAttribute, Object> fontCancel = new HashMap<>();
            fontCancel.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
            setFont(font.deriveFont(fontCancel));
        }

        table.getTableHeader().setReorderingAllowed(false);
        table.getColumnModel().getColumn(ROW).setResizable(false);
        table.getColumnModel().getColumn(DESCRIPTION).setResizable(false);
        table.getColumnModel().getColumn(BARCODE).setResizable(false);
        table.getColumnModel().getColumn(PRICE).setResizable(false);
        table.getColumnModel().getColumn(QUANTITY).setResizable(false);
        table.getColumnModel().getColumn(UNIT).setResizable(false);
        table.getColumnModel().getColumn(DISCOUNT).setResizable(false);
        table.getColumnModel().getColumn(SUBTOTAL).setResizable(false);
        table.getColumnModel().getColumn(CANCELED).setResizable(false);
        table.getColumnModel().getColumn(ROW).setPreferredWidth(30);
        table.getColumnModel().getColumn(DESCRIPTION).setPreferredWidth(400);
        table.getColumnModel().getColumn(BARCODE).setPreferredWidth(150);
        table.getColumnModel().getColumn(PRICE).setPreferredWidth(150);
        table.getColumnModel().getColumn(QUANTITY).setPreferredWidth(70);
        table.getColumnModel().getColumn(UNIT).setPreferredWidth(30);
        table.getColumnModel().getColumn(DISCOUNT).setPreferredWidth(150);
        table.getColumnModel().getColumn(SUBTOTAL).setPreferredWidth(150);
        table.getColumnModel().getColumn(CANCELED).setPreferredWidth(2);

        return this;
    }
}
