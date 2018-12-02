package br.com.ernanilima.jpdv.View;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * View que solicita os dados do usuario para verificar seu nivel de acesso
 *
 * @author Ernani Lima
 */
public class PopUPUserPermissionDialog extends JDialog implements IPopUPUserPermissionDialog {

    public PopUPUserPermissionDialog(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void initComponents() {

        panelDialog = new JPanel();
        panelBarra = new JPanel();
        campoTitulo = new JLabel();
        panelConteudo = new JPanel();
        jScrollPaneConteudo = new JScrollPane();
        campoConteudo = new JTextPane();
        panelDadosAcesso = new JPanel();
        labelCodUsuario = new JLabel();
        campoCodUsuario = new JTextField();
        labelSenhaUsuario = new JLabel();
        campoSenhaUsuario = new JPasswordField();
        btnSair = new JButton();
        btnOk = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        panelDialog.setBackground(new Color(255, 255, 255));
        panelDialog.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 102), 3));

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
                        .addComponent(campoTitulo, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        panelConteudo.setBackground(new Color(255, 255, 255));
        panelConteudo.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));

        jScrollPaneConteudo.setBorder(null);

        campoConteudo.setEditable(false);
        campoConteudo.setFont(new Font("Verdana", 1, 18)); // NOI18N
        campoConteudo.setFocusable(false);

        StyledDocument styledDocument = campoConteudo.getStyledDocument();
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setAlignment(sas, StyleConstants.ALIGN_CENTER);
        styledDocument.setParagraphAttributes(0, styledDocument.getLength(), sas, false);

        jScrollPaneConteudo.setViewportView(campoConteudo);

        GroupLayout panelConteudoLayout = new GroupLayout(panelConteudo);
        panelConteudo.setLayout(panelConteudoLayout);
        panelConteudoLayout.setHorizontalGroup(
                panelConteudoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPaneConteudo, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
        );
        panelConteudoLayout.setVerticalGroup(
                panelConteudoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, panelConteudoLayout.createSequentialGroup()
                                .addGap(0, 107, Short.MAX_VALUE)
                                .addComponent(jScrollPaneConteudo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        panelDadosAcesso.setOpaque(false);

        labelCodUsuario.setFont(new Font("Verdana", 0, 12)); // NOI18N
        labelCodUsuario.setText("CÓDIGO DE USUÁRIO");

        campoCodUsuario.setFont(new Font("Verdana", 0, 18)); // NOI18N

        labelSenhaUsuario.setFont(new Font("Verdana", 0, 12)); // NOI18N
        labelSenhaUsuario.setText("SENHA");

        campoSenhaUsuario.setFont(new Font("Verdana", 0, 18)); // NOI18N

        btnSair.setBackground(new Color(153, 0, 0));
        btnSair.setFont(new Font("Verdana", 1, 14)); // NOI18N
        btnSair.setForeground(new Color(255, 255, 255));
        btnSair.setText("SAIR");
        btnSair.setFocusable(false);

        btnOk.setBackground(new Color(0, 153, 0));
        btnOk.setFont(new Font("Verdana", 1, 14)); // NOI18N
        btnOk.setForeground(new Color(255, 255, 255));
        btnOk.setText("OK");
        btnOk.setFocusable(false);

        GroupLayout panelDadosAcessoLayout = new GroupLayout(panelDadosAcesso);
        panelDadosAcesso.setLayout(panelDadosAcessoLayout);
        panelDadosAcessoLayout.setHorizontalGroup(
                panelDadosAcessoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelDadosAcessoLayout.createSequentialGroup()
                                .addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelDadosAcessoLayout.createSequentialGroup()
                                .addGroup(panelDadosAcessoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(campoCodUsuario, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campoSenhaUsuario, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelSenhaUsuario)
                                        .addComponent(labelCodUsuario))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelDadosAcessoLayout.setVerticalGroup(
                panelDadosAcessoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelDadosAcessoLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelCodUsuario)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoCodUsuario, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelSenhaUsuario)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoSenhaUsuario, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelDadosAcessoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
        );

        GroupLayout panelDialogLayout = new GroupLayout(panelDialog);
        panelDialog.setLayout(panelDialogLayout);
        panelDialogLayout.setHorizontalGroup(
                panelDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelBarra, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDialogLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panelDialogLayout.createSequentialGroup()
                                                .addComponent(panelDadosAcesso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(panelConteudo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        panelDialogLayout.setVerticalGroup(
                panelDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelDialogLayout.createSequentialGroup()
                                .addComponent(panelBarra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelConteudo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelDadosAcesso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelDialog, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelDialog, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private JButton btnOk;
    private JButton btnSair;
    private JTextPane campoConteudo;
    private JPasswordField campoSenhaUsuario;
    private JLabel campoTitulo;
    private JTextField campoCodUsuario;
    private JScrollPane jScrollPaneConteudo;
    private JLabel labelSenhaUsuario;
    private JLabel labelCodUsuario;
    private JPanel panelBarra;
    private JPanel panelConteudo;
    private JPanel panelDadosAcesso;
    private JPanel panelDialog;

    @Override
    public void setShowPopUP(String title, String message) {
        campoTitulo.setText(title);
        campoCodUsuario.requestFocus();
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
    public String getUserID() {
        return campoCodUsuario.getText();
    }

    @Override
    public String getUserPassword() {
        return new String(campoSenhaUsuario.getPassword());
    }

    @Override
    public void setFocusUserIDField() {
        campoCodUsuario.requestFocus();
        campoCodUsuario.selectAll();
    }

    @Override
    public void setFocusUserPasswordField() {
        campoSenhaUsuario.requestFocus();
        campoSenhaUsuario.selectAll();
    }

    @Override
    public void clearIDPassword() {
        campoCodUsuario.setText("");
        campoSenhaUsuario.setText("");
    }

    @Override
    public void setUserIDFieldDocument(Document document) {
        campoCodUsuario.setDocument(document);
    }

    @Override
    public void setBtnOkActionPerformed(ActionListener listener) {
        btnOk.addActionListener(listener);
    }

    @Override
    public void setBtnExitActionPerformed(ActionListener listener) {
        btnSair.addActionListener(listener);
    }

    @Override
    public void setUserIDFieldKeyPressed(KeyAdapter adapter) {
        campoCodUsuario.addKeyListener(adapter);
    }

    @Override
    public void setUserPasswordFieldKeyPressed(KeyAdapter adapter) {
        campoSenhaUsuario.addKeyListener(adapter);
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
    public void setMouseMotion(int x, int y) {
        setLocation(x, y);
    }
}