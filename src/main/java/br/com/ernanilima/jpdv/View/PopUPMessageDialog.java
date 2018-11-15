package br.com.ernanilima.jpdv.View;

import com.towel.swing.img.JImagePanel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import javax.swing.*;

/**
 * View que exibe "pop-up de alerta" ou "pop-up de ok"
 * @author Ernani Lima
 */
public class PopUPMessageDialog extends JDialog implements IPopUPMessageDialog {

    public PopUPMessageDialog(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void initComponents() {

        panelDialog = new JPanel();
        panelBarra = new JPanel();
        campoTitulo = new JLabel();
        icoOkErro = new JLabel();
        campoConteudo = new JLabel();
        panelBtn = new JPanel();
        btnOK = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        panelDialog.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 102), 3));
        panelDialog.setOpaque(false);

        panelBarra.setBackground(new Color(0, 0, 102));

        campoTitulo.setFont(new Font("Verdana", 1, 14)); // NOI18N
        campoTitulo.setForeground(new Color(255, 255, 255));

        GroupLayout panelBarraLayout = new GroupLayout(panelBarra);
        panelBarra.setLayout(panelBarraLayout);
        panelBarraLayout.setHorizontalGroup(
                panelBarraLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelBarraLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(campoTitulo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panelBarraLayout.setVerticalGroup(
                panelBarraLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelBarraLayout.createSequentialGroup()
                                .addComponent(campoTitulo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        icoOkErro.setFont(new Font("Verdana", 1, 14)); // NOI18N
        icoOkErro.setHorizontalAlignment(SwingConstants.CENTER);

        campoConteudo.setFont(new Font("Verdana", 1, 14)); // NOI18N
        campoConteudo.setHorizontalAlignment(SwingConstants.CENTER);

        panelBtn.setOpaque(false);

        btnOK.setBackground(new Color(255, 255, 204));
        btnOK.setFont(new Font("Verdana", 1, 14)); // NOI18N
        btnOK.setText("OK");

        GroupLayout panelBtnLayout = new GroupLayout(panelBtn);
        panelBtn.setLayout(panelBtnLayout);
        panelBtnLayout.setHorizontalGroup(
                panelBtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, panelBtnLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnOK, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBtnLayout.setVerticalGroup(
                panelBtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelBtnLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(btnOK)
                                .addGap(0, 0, 0))
        );

        GroupLayout panelDialogLayout = new GroupLayout(panelDialog);
        panelDialog.setLayout(panelDialogLayout);
        panelDialogLayout.setHorizontalGroup(
                panelDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelBarra, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDialogLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(icoOkErro, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoConteudo, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                .addContainerGap(110, Short.MAX_VALUE))
                        .addComponent(panelBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelDialogLayout.setVerticalGroup(
                panelDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelDialogLayout.createSequentialGroup()
                                .addComponent(panelBarra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(campoConteudo, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(icoOkErro, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelDialog, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelDialog, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private JButton btnOK;
    private JLabel campoConteudo;
    private JLabel campoTitulo;
    private JLabel icoOkErro;
    private JPanel panelBarra;
    private JPanel panelBtn;
    private JPanel panelDialog;

    @Override
    public void setShowPopUP(String title, String message, ImageIcon icon) {
        campoTitulo.setText(title);
        icoOkErro.setIcon(icon);
        campoConteudo.setText(message);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void setClosePopUP() {
        setVisible(false);
    }

    @Override
    public void setOKKeyPressed(KeyAdapter adapter) {
        btnOK.addKeyListener(adapter);
    }

    @Override
    public void setOKActionPerformed(ActionListener listener) {
        btnOK.addActionListener(listener);
    }

    @Override
    public void setMouseMotion(int x, int y) {
        setLocation(x, y);
    }

    @Override
    public void setBackground(JImagePanel imagePanel) {
        getContentPane().add(imagePanel);
    }

    @Override
    public void setTopBarMousePressed(MouseAdapter adapter) {
        panelBarra.addMouseListener(adapter);
    }

    @Override
    public void setTopBarMouseDragged(MouseAdapter adapter) {
        panelBarra.addMouseMotionListener(adapter);
    }
}
