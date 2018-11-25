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
 * produtos ja vendidos para cancelar
 *
 * @author Ernani Lima
 */
public class ProductBackRenderer extends DefaultTableCellRenderer implements TableCellRenderer {


    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        final int ITEM = 0;
        final int DESCRICAO = 1;
        final int COD_BARRAS = 2;
        final int PRECO_UND = 3;
        final int QUANTIDADE = 4;
        final int UNIDADE = 5;
        final int DESCONTO = 6;
        final int SUBTOTAL = 7;
        final int CANCELADO = 8;

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

        // Risca a linha do produto cancelado
        if (!table.getValueAt(row, CANCELADO).equals("")) {
            Font font = new Font("Verdana", 0, 18);
            Map<TextAttribute, Object> fontCancel = new HashMap<>();
            fontCancel.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
            setFont(font.deriveFont(fontCancel));
        }

        table.getTableHeader().setReorderingAllowed(false);
        table.getColumnModel().getColumn(ITEM).setResizable(false);
        table.getColumnModel().getColumn(DESCRICAO).setResizable(false);
        table.getColumnModel().getColumn(COD_BARRAS).setResizable(false);
        table.getColumnModel().getColumn(PRECO_UND).setResizable(false);
        table.getColumnModel().getColumn(QUANTIDADE).setResizable(false);
        table.getColumnModel().getColumn(UNIDADE).setResizable(false);
        table.getColumnModel().getColumn(DESCONTO).setResizable(false);
        table.getColumnModel().getColumn(SUBTOTAL).setResizable(false);
        table.getColumnModel().getColumn(CANCELADO).setResizable(false);
        table.getColumnModel().getColumn(ITEM).setPreferredWidth(30);
        table.getColumnModel().getColumn(DESCRICAO).setPreferredWidth(400);
        table.getColumnModel().getColumn(COD_BARRAS).setPreferredWidth(150);
        table.getColumnModel().getColumn(PRECO_UND).setPreferredWidth(150);
        table.getColumnModel().getColumn(QUANTIDADE).setPreferredWidth(70);
        table.getColumnModel().getColumn(UNIDADE).setPreferredWidth(30);
        table.getColumnModel().getColumn(DESCONTO).setPreferredWidth(150);
        table.getColumnModel().getColumn(SUBTOTAL).setPreferredWidth(150);
        table.getColumnModel().getColumn(CANCELADO).setPreferredWidth(2);

        return this;
    }
}
