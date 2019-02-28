package br.com.ernanilima.jpdv.Model.ListModel;

import javax.swing.*;
import java.util.*;

/**
 * ListModel das opcoes do painel do admin (fiscal de caixa)
 *
 * @author Ernani Lima
 */
public class AdminOptionsListModel extends AbstractListModel {

    private List<String> lsOptions = new ArrayList<>();

    // Construtor
    public AdminOptionsListModel() {}

    @Override
    public int getSize() {
        return lsOptions.size();
    }

    @Override
    public Object getElementAt(int index) {
        return lsOptions.get(index);
    }

    public void addOptions(String option) {
        lsOptions.add(option);
        fireContentsChanged(option, 0, lsOptions.size());
    }
}
