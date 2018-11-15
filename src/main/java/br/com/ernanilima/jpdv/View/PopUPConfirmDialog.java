package br.com.ernanilima.jpdv.View;

import com.towel.swing.img.JImagePanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * View que exibe "pop-up de confirmacao" com os botoes SIM e NAO
 * @author Ernani Lima
 */
public class PopUPConfirmDialog extends JDialog implements IPopUPConfirmDialog {

    public PopUPConfirmDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void initComponents() {

        panelDialog = new JPanel();
        panelBarra = new JPanel();
        campoTitulo = new JLabel();
        icoSelecao = new JLabel();
        campoConteudo = new JLabel();
        btnSim = new JButton();
        btnNao = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        panelDialog.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 3));
        panelDialog.setOpaque(false);

        panelBarra.setBackground(new java.awt.Color(0, 0, 102));

        campoTitulo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        campoTitulo.setForeground(new java.awt.Color(255, 255, 255));

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
                        .addComponent(campoTitulo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        );

        icoSelecao.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        icoSelecao.setHorizontalAlignment(SwingConstants.CENTER);

        campoConteudo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        campoConteudo.setHorizontalAlignment(SwingConstants.CENTER);

        btnSim.setBackground(new java.awt.Color(153, 0, 0));
        btnSim.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnSim.setForeground(new java.awt.Color(255, 255, 255));
        btnSim.setText("Sim");

        btnNao.setBackground(new java.awt.Color(255, 255, 204));
        btnNao.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnNao.setText("Não");

        GroupLayout panelDialogLayout = new GroupLayout(panelDialog);
        panelDialog.setLayout(panelDialogLayout);
        panelDialogLayout.setHorizontalGroup(
                panelDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelBarra, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDialogLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelDialogLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(panelDialogLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnSim, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnNao, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(panelDialogLayout.createSequentialGroup()
                                                .addComponent(icoSelecao, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoConteudo, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                                .addContainerGap(114, Short.MAX_VALUE))))
        );
        panelDialogLayout.setVerticalGroup(
                panelDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelDialogLayout.createSequentialGroup()
                                .addComponent(panelBarra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(panelDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(icoSelecao, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campoConteudo, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelDialogLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSim)
                                        .addComponent(btnNao))
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

    private JButton btnNao;
    private JButton btnSim;
    private JLabel campoConteudo;
    private JLabel campoTitulo;
    private JLabel icoSelecao;
    private JPanel panelBarra;
    private JPanel panelDialog;

    @Override
    public void setShowPopUP(String title, String message, ImageIcon icon) {
        campoTitulo.setText(title);
        btnNao.requestFocus();
        icoSelecao.setIcon(icon);
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
    public void setYesKeyPressed(KeyAdapter adapter) {
        btnSim.addKeyListener(adapter);
    }

    @Override
    public void setYesActionPerformed(ActionListener listener) {
        btnSim.addActionListener(listener);
    }

    @Override
    public void setNoKeyPressed(KeyAdapter adapter) {
        btnNao.addKeyListener(adapter);
    }

    @Override
    public void setNoActionPerformed(ActionListener listener) {
        btnNao.addActionListener(listener);
    }

    @Override
    public void setTopBarMousePressed(MouseAdapter adapter) {
        panelBarra.addMouseListener(adapter);
    }

    @Override
    public void setTopBarMouseDragged(MouseAdapter adapter) {
        panelBarra.addMouseMotionListener(adapter);
    }

    @Override
    public void setFocusBtnYes() {
        btnSim.requestFocus();
    }

    @Override
    public void setFocusBtnNo() {
        btnNao.requestFocus();
    }

    @Override
    public void setMouseMotion(int x, int y) {
        setLocation(x, y);
    }

    @Override
    public void setBackground(JImagePanel imagePanel) {
        getContentPane().add(imagePanel);
    }
}