package br.com.ernanilima.jpdv.View;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * View de abertura de caixa PDV.
 *
 * @author Ernani Lima
 */
public class ViewOpening extends JDialog implements IViewOpening {

    public ViewOpening(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void initComponents() {

        panelDialog = new JPanel();
        panelBarra = new JPanel();
        jLabelTitulo = new JLabel();
        jLabelData = new JLabel();
        campoData = new JLabel();
        jLabelHora = new JLabel();
        campoHora = new JLabel();
        jLabelOperador = new JLabel();
        campoCodOperador = new JTextField();
        campoNomeOperador = new JTextField();
        jLabelValInicial = new JLabel();
        campoValInicial = new JTextField();
        jLabelRS1 = new JLabel();
        btnConfirmar = new JButton();
        btnCancelar = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        panelDialog.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 102), 3));
        panelDialog.setOpaque(false);

        panelBarra.setBackground(new Color(0, 0, 102));

        jLabelTitulo.setFont(new Font("Verdana", 1, 14));
        jLabelTitulo.setForeground(new Color(255, 255, 255));
        jLabelTitulo.setText("ABERTURA DE CAIXA");

        GroupLayout panelBarraLayout = new GroupLayout(panelBarra);
        panelBarra.setLayout(panelBarraLayout);
        panelBarraLayout.setHorizontalGroup(
                panelBarraLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelBarraLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitulo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panelBarraLayout.setVerticalGroup(
                panelBarraLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelTitulo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        );

        jLabelData.setFont(new Font("Verdana", 0, 18));
        jLabelData.setText("DATA:");

        campoData.setFont(new Font("Verdana", 0, 18));

        jLabelHora.setFont(new Font("Verdana", 0, 18));
        jLabelHora.setText("HORA:");

        campoHora.setFont(new Font("Verdana", 0, 18));

        jLabelOperador.setFont(new Font("Verdana", 0, 18));
        jLabelOperador.setText("OPERADOR:");

        campoCodOperador.setFont(new Font("Verdana", 0, 18));
        campoCodOperador.setHorizontalAlignment(JTextField.RIGHT);

        campoNomeOperador.setEditable(false);
        campoNomeOperador.setFont(new Font("Verdana", 0, 18));
        campoNomeOperador.setFocusable(false);

        jLabelValInicial.setFont(new Font("Verdana", 0, 18));
        jLabelValInicial.setText("VALOR INICIAL:");

        jLabelRS1.setBackground(new Color(255, 255, 255));
        jLabelRS1.setFont(new Font("Verdana", 0, 18));
        jLabelRS1.setText("R$");
        jLabelRS1.setOpaque(true);
        campoValInicial.setFont(new Font("Verdana", 0, 18));
        campoValInicial.setHorizontalAlignment(JTextField.RIGHT);
        campoValInicial.setLayout(new BorderLayout());
        campoValInicial.add(jLabelRS1,BorderLayout.LINE_START);

        btnConfirmar.setBackground(new Color(0, 102, 0));
        btnConfirmar.setFont(new Font("Verdana", 1, 14));
        btnConfirmar.setForeground(new Color(255, 255, 255));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setFocusable(false);

        btnCancelar.setBackground(new Color(153, 0, 0));
        btnCancelar.setFont(new Font("Verdana", 1, 14));
        btnCancelar.setForeground(new Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setFocusable(false);

        GroupLayout panelDialogLayout = new GroupLayout(panelDialog);
        panelDialog.setLayout(panelDialogLayout);
        panelDialogLayout.setHorizontalGroup(
                panelDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelBarra, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDialogLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panelDialogLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(panelDialogLayout.createSequentialGroup()
                                                .addGroup(panelDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(panelDialogLayout.createSequentialGroup()
                                                                .addComponent(jLabelData)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(campoData, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                                                .addComponent(jLabelHora)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(campoHora, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(panelDialogLayout.createSequentialGroup()
                                                                .addComponent(jLabelOperador)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(campoCodOperador, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(panelDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(campoValInicial)
                                                                        .addComponent(campoNomeOperador))))
                                                .addContainerGap())
                                        .addGroup(panelDialogLayout.createSequentialGroup()
                                                .addComponent(jLabelValInicial)
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelDialogLayout.setVerticalGroup(
                panelDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelDialogLayout.createSequentialGroup()
                                .addComponent(panelBarra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panelDialogLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelData)
                                        .addComponent(jLabelHora)
                                        .addComponent(campoData, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(campoHora, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelDialogLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelOperador)
                                        .addComponent(campoCodOperador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campoNomeOperador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelDialogLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelValInicial)
                                        .addComponent(campoValInicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(panelDialogLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnConfirmar)
                                        .addComponent(btnCancelar))
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelDialog, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelDialog, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private JButton btnCancelar;
    private JButton btnConfirmar;
    private JTextField campoCodOperador;
    private JLabel campoData;
    private JLabel campoHora;
    private JTextField campoNomeOperador;
    private JLabel jLabelRS1;
    private JTextField campoValInicial;
    private JLabel jLabelData;
    private JLabel jLabelHora;
    private JLabel jLabelOperador;
    private JLabel jLabelTitulo;
    private JLabel jLabelValInicial;
    private JPanel panelBarra;
    private JPanel panelDialog;

    @Override
    public void setShow() {
        campoCodOperador.requestFocus();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void setClose() {
        setVisible(false);
    }

    @Override
    public String getOperatorID() {
        return campoCodOperador.getText();
    }

    @Override
    public void setOperatorName(String name) {
        campoNomeOperador.setText(name);
    }

    @Override
    public void clearOperator() {
        campoCodOperador.setText("");
        campoNomeOperador.setText("");
    }

    @Override
    public void setFocusOperatorIDField() {
        campoCodOperador.requestFocus();
    }

    @Override
    public void setFocusInitialValueField() {
        campoValInicial.requestFocus();
    }

    @Override
    public void setCurrentDate(String date) {
        campoData.setText(date);
    }

    @Override
    public void setCurrentTime(String time) {
        campoHora.setText(time);
    }

    @Override
    public void setDocumentOperatorIDField(Document document) {
        campoCodOperador.setDocument(document);
    }

    @Override
    public void setDocumentInitialValueField(Document document) {
        campoValInicial.setDocument(document);
    }

    @Override
    public void setActionPerformedBtnConfirm(ActionListener listener) {
        btnConfirmar.addActionListener(listener);
    }

    @Override
    public void setActionPerformedBtnCancel(ActionListener listener) {
        btnCancelar.addActionListener(listener);
    }

    @Override
    public void setFocusLostOperatorIDField(FocusAdapter adapter) {
        campoCodOperador.addFocusListener(adapter);
    }

    @Override
    public void setKeyPressedOperatorIDField(KeyAdapter adapter) {
        campoCodOperador.addKeyListener(adapter);
    }

    @Override
    public void setKeyPressedInitialValueField(KeyAdapter adapter) {
        campoValInicial.addKeyListener(adapter);
    }

    @Override
    public void setMousePressedTopBar(MouseAdapter adapter) {
        panelBarra.addMouseListener(adapter);
    }

    @Override
    public void setMouseDraggedTopBar(MouseAdapter adapter) {
        panelBarra.addMouseMotionListener(adapter);
    }

    @Override
    public void setMouseMotion(int x, int y) {
        setLocation(x, y);
    }

    @Override
    public boolean getVisible() {
        return this.isVisible();
    }
}
