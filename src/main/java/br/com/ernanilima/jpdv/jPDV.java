package br.com.ernanilima.jpdv;

import br.com.ernanilima.jpdv.Connection.CreateDatabaseSQLite;
import br.com.ernanilima.jpdv.Presenter.PDVPresenter;

public class jPDV {
    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println(ex);
        }

        new CreateDatabaseSQLite().createDB();
        PDVPresenter presenter = new PDVPresenter();
    }
}