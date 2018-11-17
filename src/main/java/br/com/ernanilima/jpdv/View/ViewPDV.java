package br.com.ernanilima.jpdv.View;

import com.towel.swing.img.JImagePanel;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

/**
 * View do PDV
 *
 * @author Ernani Lima
 */
public class ViewPDV extends JFrame implements IViewPDV {

    public ViewPDV() {
        initComponents();
    }

    private void initComponents() {

        painelCardPDV = new JPanel();
        painelLogin = new JPanel();
        jPanelLogin = new JPanel();
        labelUsuarioLogin = new JLabel();
        campoCodUsuario = new JTextField();
        labelSenhaLogin = new JLabel();
        campoSenhaUsuario = new JPasswordField();
        btnLoginSair = new JButton();
        btnLoginEntrar = new JButton();
        painelPDV = new JPanel();
        painelCabecalhoPDV = new JPanel();
        painelCardVendas = new JPanel();
        painelVendas = new JPanel();
        jPanelItensPDV = new JPanel();
        jPanelCabecalhoItensPDV = new JPanel();
        jLabelData = new JLabel();
        campoData = new JLabel();
        jLabelHora = new JLabel();
        campoHora = new JLabel();
        jLabelCupom = new JLabel();
        campoCupom = new JLabel();
        jScrollPaneItensPDV = new JScrollPane();
        tbItensPDV = new JTable();
        painelInserirItens = new JPanel();
        painelCardValores = new JPanel();
        painelValProduto = new JPanel();
        jLabelCodBarras = new JLabel();
        campoCodBarras = new JTextField();
        jLabelQtd = new JLabel();
        campoQuantidade = new JTextField();
        jLabelPrecoProduto = new JLabel();
        campoPrecoProduto = new JTextField();
        jLabelSubTotalProduto = new JLabel();
        campoSubTotalProduto = new JTextField();
        jLabelValTotalProdutos = new JLabel();
        campoValTotalProdutos = new JTextField();
        painelValCupom = new JPanel();
        jLabelValTotalCupom = new JLabel();
        campoValTotalCupom = new JTextField();
        jLabelValTotalDesconto = new JLabel();
        campoValTotalDesconto = new JTextField();
        jLabelValTotalAReceber = new JLabel();
        campoValTotalAReceber = new JTextField();
        jLabelValTotalRecebido = new JLabel();
        campoValTotalRecebido = new JTextField();
        jScrollPaneRecebimentos = new JScrollPane();
        tbRecebimentos = new JTable();
        painelCardLogo = new JPanel();
        painelLogo = new JPanel();
        imgLogo = new JLabel();
        painelFormasPagamento = new JPanel();
        jScrollPaneFPagamento = new JScrollPane();
        tbFPagamento = new JTable();
        painelDesconto = new JPanel();
        campoLabelLocalDesconto = new JLabel();
        jLabelDescontoRS = new JLabel();
        campoDescontoRS = new JTextField();
        jLabelDescontoPer = new JLabel();
        campoDescontoPer = new JTextField();
        btnConfirmarDesconto = new JButton();
        painelBtnTouch = new JPanel();
        btnAtalho1 = new JButton();
        btnAtalho2 = new JButton();
        btnAtalho3 = new JButton();
        btnAtalho4 = new JButton();
        btnAtalho5 = new JButton();
        btnAtalho6 = new JButton();
        btnAtalho7 = new JButton();
        btnAtalho8 = new JButton();
        btnAtalho9 = new JButton();
        btnAtalho10 = new JButton();
        painelBotonsNumericos = new JPanel();
        btn7 = new JButton();
        btn8 = new JButton();
        btn9 = new JButton();
        btn4 = new JButton();
        btn5 = new JButton();
        btn6 = new JButton();
        btn1 = new JButton();
        btn2 = new JButton();
        btn3 = new JButton();
        btn00 = new JButton();
        btn0 = new JButton();
        jLabelRS1 = new JLabel();
        jLabelRS2 = new JLabel();
        jLabelRS3 = new JLabel();
        jLabelRS4 = new JLabel();
        jLabelRS5 = new JLabel();
        jLabelRS6 = new JLabel();
        jLabelRS7 = new JLabel();
        jLabelRS8 = new JLabel();
        btnVirgula = new JButton();
        btnBackspace = new JButton();
        btnSairNumerico = new JButton();
        btnTotalizar = new JButton();
        btnFPagCartaoCred = new JButton();
        btnFPagDinheiro = new JButton();
        btnFPagCartaoDeb = new JButton();
        btnQuantidade = new JButton();
        btnEnterNumerico = new JButton();
        painelTroco = new JPanel();
        painelItensVendidos = new JPanel();
        jScrollPaneItensVendidosPDV = new JScrollPane();
        tbItensVendidosPDV = new JTable();
        painelBuscarProduto = new JPanel();
        painelBtnBuscarProdutos = new JPanel();
        jScrollPaneBuscarProdutos = new JScrollPane();
        tbBuscarProdutos = new JTable();
        painelRodapePDV = new JPanel();
        jLabelPDV = new JLabel();
        campoCodPDV = new JLabel();
        jLabelFilial = new JLabel();
        campoCodFilial = new JLabel();
        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();
        jLabelVersao = new JLabel();
        campoVersao = new JLabel();
        jSeparator3 = new JSeparator();
        jLabelOperador = new JLabel();
        campoCodOperador = new JLabel();
        campoNomeOperador = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setExtendedState(6);
        //setUndecorated(true);
        setMinimumSize(new Dimension(1280, 720));
        //setResizable(false);

        painelCardPDV.setLayout(new CardLayout());

        labelUsuarioLogin.setFont(new Font("Verdana", 0, 12)); // NOI18N
        labelUsuarioLogin.setText("USUÁRIO");

        campoCodUsuario.setFont(new Font("Verdana", 0, 18)); // NOI18N

        labelSenhaLogin.setFont(new Font("Verdana", 0, 12)); // NOI18N
        labelSenhaLogin.setText("SENHA");

        campoSenhaUsuario.setFont(new Font("Verdana", 0, 18)); // NOI18N

        btnLoginSair.setBackground(new Color(153, 0, 0));
        btnLoginSair.setFont(new Font("Verdana", 1, 14)); // NOI18N
        btnLoginSair.setForeground(new Color(255, 255, 255));
        btnLoginSair.setText("SAIR");
        btnLoginSair.setFocusable(false);

        btnLoginEntrar.setBackground(new Color(0, 102, 0));
        btnLoginEntrar.setFont(new Font("Verdana", 1, 14)); // NOI18N
        btnLoginEntrar.setForeground(new Color(255, 255, 255));
        btnLoginEntrar.setText("ENTRAR");
        btnLoginEntrar.setFocusable(false);

        GroupLayout jPanelLoginLayout = new GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
                jPanelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLoginLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelLoginLayout.createSequentialGroup()
                                                .addGroup(jPanelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(campoCodUsuario, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(labelUsuarioLogin))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(labelSenhaLogin)
                                                        .addComponent(campoSenhaUsuario, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelLoginLayout.createSequentialGroup()
                                                .addComponent(btnLoginSair, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnLoginEntrar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanelLoginLayout.setVerticalGroup(
                jPanelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLoginLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelLoginLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelUsuarioLogin)
                                        .addComponent(labelSenhaLogin))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelLoginLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(campoCodUsuario, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campoSenhaUsuario, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelLoginLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnLoginEntrar, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnLoginSair, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout painelLoginLayout = new GroupLayout(painelLogin);
        painelLogin.setLayout(painelLoginLayout);
        painelLoginLayout.setHorizontalGroup(
                painelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(painelLoginLayout.createSequentialGroup()
                                .addContainerGap(421, Short.MAX_VALUE)
                                .addComponent(jPanelLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(421, Short.MAX_VALUE))
        );
        painelLoginLayout.setVerticalGroup(
                painelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, painelLoginLayout.createSequentialGroup()
                                .addContainerGap(537, Short.MAX_VALUE)
                                .addComponent(jPanelLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))
        );

        painelCardPDV.add(painelLogin, "cardLogin");

        painelCabecalhoPDV.setBackground(new Color(255, 255, 255));
        painelCabecalhoPDV.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        GroupLayout painelCabecalhoPDVLayout = new GroupLayout(painelCabecalhoPDV);
        painelCabecalhoPDV.setLayout(painelCabecalhoPDVLayout);
        painelCabecalhoPDVLayout.setHorizontalGroup(
                painelCabecalhoPDVLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        painelCabecalhoPDVLayout.setVerticalGroup(
                painelCabecalhoPDVLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        painelCardVendas.setLayout(new CardLayout());

        jPanelItensPDV.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));

        jPanelCabecalhoItensPDV.setBackground(new Color(255, 255, 255));
        jPanelCabecalhoItensPDV.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));

        jLabelData.setFont(new Font("Verdana", 0, 18)); // NOI18N
        jLabelData.setText("DATA:");

        campoData.setFont(new Font("Verdana", 0, 18)); // NOI18N
        campoData.setText("27/10/2018");

        jLabelHora.setFont(new Font("Verdana", 0, 18)); // NOI18N
        jLabelHora.setText("HORA:");

        campoHora.setFont(new Font("Verdana", 0, 18)); // NOI18N
        campoHora.setText("23:11:54");

        jLabelCupom.setFont(new Font("Verdana", 0, 18)); // NOI18N
        jLabelCupom.setText("CUPOM:");

        campoCupom.setFont(new Font("Verdana", 0, 18)); // NOI18N
        campoCupom.setHorizontalAlignment(SwingConstants.RIGHT);
        campoCupom.setText("000000");

        GroupLayout jPanelCabecalhoItensPDVLayout = new GroupLayout(jPanelCabecalhoItensPDV);
        jPanelCabecalhoItensPDV.setLayout(jPanelCabecalhoItensPDVLayout);
        jPanelCabecalhoItensPDVLayout.setHorizontalGroup(
                jPanelCabecalhoItensPDVLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelCabecalhoItensPDVLayout.createSequentialGroup()
                                .addComponent(jLabelData)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoData, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelHora)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoHora, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelCupom)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoCupom)
                                .addContainerGap())
        );
        jPanelCabecalhoItensPDVLayout.setVerticalGroup(
                jPanelCabecalhoItensPDVLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelCabecalhoItensPDVLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelData)
                                .addComponent(campoData)
                                .addComponent(jLabelHora)
                                .addComponent(campoHora)
                                .addComponent(campoCupom)
                                .addComponent(jLabelCupom))
        );

        tbItensPDV.setFont(new Font("Verdana", 0, 18));
        tbItensPDV.setFocusable(false);
        tbItensPDV.setOpaque(false);
        tbItensPDV.setRowHeight(60);
        jScrollPaneItensPDV.setViewportView(tbItensPDV);

        GroupLayout jPanelItensPDVLayout = new GroupLayout(jPanelItensPDV);
        jPanelItensPDV.setLayout(jPanelItensPDVLayout);
        jPanelItensPDVLayout.setHorizontalGroup(
                jPanelItensPDVLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPaneItensPDV, GroupLayout.PREFERRED_SIZE, 552, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanelCabecalhoItensPDV, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelItensPDVLayout.setVerticalGroup(
                jPanelItensPDVLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelItensPDVLayout.createSequentialGroup()
                                .addComponent(jPanelCabecalhoItensPDV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jScrollPaneItensPDV))
        );

        painelCardValores.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        painelCardValores.setLayout(new CardLayout());

        jLabelCodBarras.setFont(new Font("Verdana", 0, 18)); // NOI18N
        jLabelCodBarras.setText("CÓDIGO DE BARRAS");

        campoCodBarras.setFont(new Font("Verdana", 0, 36)); // NOI18N

        jLabelQtd.setFont(new Font("Verdana", 0, 18)); // NOI18N
        jLabelQtd.setText("QUANTIDADE");

        campoQuantidade.setEditable(false);
        campoQuantidade.setBackground(Color.WHITE);
        campoQuantidade.setFont(new Font("Verdana", 0, 36)); // NOI18N
        campoQuantidade.setHorizontalAlignment(JTextField.RIGHT);
        campoQuantidade.setFocusable(false);

        jLabelPrecoProduto.setFont(new Font("Verdana", 0, 18)); // NOI18N
        jLabelPrecoProduto.setText("PREÇO DO PRODUTO");

        jLabelRS1.setBackground(new Color(255, 255, 255));
        jLabelRS1.setFont(new Font("Verdana", 0, 36)); // NOI18N
        jLabelRS1.setText("R$");
        jLabelRS1.setOpaque(true);

        campoPrecoProduto.setEditable(false);
        campoPrecoProduto.setBackground(Color.WHITE);
        campoPrecoProduto.setFont(new Font("Verdana", 0, 36)); // NOI18N
        campoPrecoProduto.setHorizontalAlignment(JTextField.RIGHT);
        campoPrecoProduto.setFocusable(false);
        campoPrecoProduto.setLayout(new BorderLayout());
        campoPrecoProduto.add(jLabelRS1, BorderLayout.LINE_START);

        jLabelSubTotalProduto.setFont(new Font("Verdana", 0, 18)); // NOI18N
        jLabelSubTotalProduto.setText("SUBTOTAL DO PRODUTO");

        jLabelRS2.setBackground(new Color(255, 255, 255));
        jLabelRS2.setFont(new Font("Verdana", 0, 36)); // NOI18N
        jLabelRS2.setText("R$");
        jLabelRS2.setOpaque(true);

        campoSubTotalProduto.setEditable(false);
        campoSubTotalProduto.setBackground(Color.WHITE);
        campoSubTotalProduto.setFont(new Font("Verdana", 0, 36)); // NOI18N
        campoSubTotalProduto.setHorizontalAlignment(JTextField.RIGHT);
        campoSubTotalProduto.setFocusable(false);
        campoSubTotalProduto.setLayout(new BorderLayout());
        campoSubTotalProduto.add(jLabelRS2, BorderLayout.LINE_START);

        jLabelValTotalProdutos.setFont(new Font("Verdana", 0, 18)); // NOI18N
        jLabelValTotalProdutos.setText("VALOR TOTAL DO CUPOM");

        jLabelRS3.setBackground(new Color(255, 255, 255));
        jLabelRS3.setFont(new Font("Verdana", 0, 36)); // NOI18N
        jLabelRS3.setText("R$");
        jLabelRS3.setOpaque(true);

        campoValTotalProdutos.setEditable(false);
        campoValTotalProdutos.setBackground(Color.WHITE);
        campoValTotalProdutos.setFont(new Font("Verdana", 0, 36)); // NOI18N
        campoValTotalProdutos.setHorizontalAlignment(JTextField.RIGHT);
        campoValTotalProdutos.setFocusable(false);
        campoValTotalProdutos.setLayout(new BorderLayout());
        campoValTotalProdutos.add(jLabelRS3, BorderLayout.LINE_START);

        GroupLayout painelValProdutoLayout = new GroupLayout(painelValProduto);
        painelValProduto.setLayout(painelValProdutoLayout);
        painelValProdutoLayout.setHorizontalGroup(
                painelValProdutoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(painelValProdutoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(painelValProdutoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(campoCodBarras, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelCodBarras, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelQtd, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campoQuantidade, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelPrecoProduto, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campoPrecoProduto, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelSubTotalProduto, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campoSubTotalProduto, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelValTotalProdutos, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campoValTotalProdutos, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        painelValProdutoLayout.setVerticalGroup(
                painelValProdutoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(painelValProdutoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelCodBarras)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoCodBarras, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelQtd)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoQuantidade, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelPrecoProduto)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoPrecoProduto, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelSubTotalProduto)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoSubTotalProduto, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                .addComponent(jLabelValTotalProdutos)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoValTotalProdutos, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        painelCardValores.add(painelValProduto, "cardValProduto");

        jLabelValTotalCupom.setFont(new Font("Verdana", 0, 18)); // NOI18N
        jLabelValTotalCupom.setText("VALOR TOTAL DO CUPOM");

        jLabelRS4.setBackground(new Color(255, 255, 255));
        jLabelRS4.setFont(new Font("Verdana", 0, 36)); // NOI18N
        jLabelRS4.setText("R$");
        jLabelRS4.setOpaque(true);

        campoValTotalCupom.setEditable(false);
        campoValTotalCupom.setBackground(Color.WHITE);
        campoValTotalCupom.setFont(new Font("Verdana", 0, 36)); // NOI18N
        campoValTotalCupom.setHorizontalAlignment(JTextField.RIGHT);
        campoValTotalCupom.setFocusable(false);
        campoValTotalCupom.setLayout(new BorderLayout());
        campoValTotalCupom.add(jLabelRS4, BorderLayout.LINE_START);

        jLabelValTotalDesconto.setFont(new Font("Verdana", 0, 18)); // NOI18N
        jLabelValTotalDesconto.setText("DESCONTO");

        jLabelRS5.setBackground(new Color(255, 255, 255));
        jLabelRS5.setFont(new Font("Verdana", 0, 36)); // NOI18N
        jLabelRS5.setText("R$");
        jLabelRS5.setOpaque(true);

        campoValTotalDesconto.setEditable(false);
        campoValTotalDesconto.setBackground(Color.WHITE);
        campoValTotalDesconto.setFont(new Font("Verdana", 0, 36)); // NOI18N
        campoValTotalDesconto.setHorizontalAlignment(JTextField.RIGHT);
        campoValTotalDesconto.setFocusable(false);
        campoValTotalDesconto.setLayout(new BorderLayout());
        campoValTotalDesconto.add(jLabelRS5, BorderLayout.LINE_START);

        jLabelValTotalAReceber.setFont(new Font("Verdana", 0, 18)); // NOI18N
        jLabelValTotalAReceber.setText("TOTAL A RECEBER");

        jLabelRS6.setBackground(new Color(255, 255, 255));
        jLabelRS6.setFont(new Font("Verdana", 0, 36)); // NOI18N
        jLabelRS6.setText("R$");
        jLabelRS6.setOpaque(true);

        campoValTotalAReceber.setEditable(false);
        campoValTotalAReceber.setBackground(Color.WHITE);
        campoValTotalAReceber.setFont(new Font("Verdana", 0, 36)); // NOI18N
        campoValTotalAReceber.setHorizontalAlignment(JTextField.RIGHT);
        campoValTotalAReceber.setFocusable(false);
        campoValTotalAReceber.setLayout(new BorderLayout());
        campoValTotalAReceber.add(jLabelRS6, BorderLayout.LINE_START);

        jLabelValTotalRecebido.setFont(new Font("Verdana", 0, 18)); // NOI18N
        jLabelValTotalRecebido.setText("TOTAL RECEBIDO");

        jLabelRS7.setBackground(Color.WHITE);
        jLabelRS7.setFont(new Font("Verdana", 0, 36)); // NOI18N
        jLabelRS7.setText("R$");
        jLabelRS7.setOpaque(true);
        campoValTotalRecebido.setBackground(Color.WHITE);
        campoValTotalRecebido.setFont(new Font("Verdana", 0, 36)); // NOI18N
        campoValTotalRecebido.setHorizontalAlignment(JTextField.RIGHT);
        campoValTotalRecebido.setLayout(new BorderLayout());
        campoValTotalRecebido.add(jLabelRS7, BorderLayout.LINE_START);

        tbRecebimentos.setFont(new Font("Verdana", 0, 18)); // NOI18N
        tbRecebimentos.setFocusable(false);
        tbRecebimentos.setOpaque(false);
        tbRecebimentos.setRowHeight(25);
        jScrollPaneRecebimentos.setViewportView(tbRecebimentos);

        GroupLayout painelValCupomLayout = new GroupLayout(painelValCupom);
        painelValCupom.setLayout(painelValCupomLayout);
        painelValCupomLayout.setHorizontalGroup(
                painelValCupomLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(painelValCupomLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(painelValCupomLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(painelValCupomLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabelValTotalCupom, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(campoValTotalCupom, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabelValTotalDesconto, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(campoValTotalDesconto, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabelValTotalAReceber, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(campoValTotalAReceber, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jScrollPaneRecebimentos, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, painelValCupomLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabelValTotalRecebido, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(campoValTotalRecebido, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        painelValCupomLayout.setVerticalGroup(
                painelValCupomLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(painelValCupomLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelValTotalCupom)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoValTotalCupom, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelValTotalDesconto)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoValTotalDesconto, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelValTotalAReceber)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoValTotalAReceber, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelValTotalRecebido)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoValTotalRecebido, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPaneRecebimentos, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                .addContainerGap())
        );

        painelCardValores.add(painelValCupom, "cardValCupom");

        painelCardLogo.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        painelCardLogo.setLayout(new CardLayout());

        imgLogo.setHorizontalAlignment(SwingConstants.CENTER);
        imgLogo.setText("LOGO");

        GroupLayout painelLogoLayout = new GroupLayout(painelLogo);
        painelLogo.setLayout(painelLogoLayout);
        painelLogoLayout.setHorizontalGroup(
                painelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(painelLogoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(imgLogo, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                                .addContainerGap())
        );
        painelLogoLayout.setVerticalGroup(
                painelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(painelLogoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(imgLogo, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                                .addContainerGap())
        );

        painelCardLogo.add(painelLogo, "cardLogo");

        tbFPagamento.setFont(new Font("Verdana", 0, 18)); // NOI18N
        tbFPagamento.setFocusable(false);
        tbFPagamento.setOpaque(false);
        tbFPagamento.setRowHeight(25);
        jScrollPaneFPagamento.setViewportView(tbFPagamento);

        GroupLayout painelFormasPagamentoLayout = new GroupLayout(painelFormasPagamento);
        painelFormasPagamento.setLayout(painelFormasPagamentoLayout);
        painelFormasPagamentoLayout.setHorizontalGroup(
                painelFormasPagamentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPaneFPagamento, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );
        painelFormasPagamentoLayout.setVerticalGroup(
                painelFormasPagamentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPaneFPagamento, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
        );

        painelCardLogo.add(painelFormasPagamento, "cardFormasPagamento");

        campoLabelLocalDesconto.setFont(new Font("Verdana", 0, 18)); // NOI18N
        campoLabelLocalDesconto.setHorizontalAlignment(SwingConstants.CENTER);
        campoLabelLocalDesconto.setText("DESCONTO NO ITEM");
        campoLabelLocalDesconto.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));

        jLabelDescontoRS.setFont(new Font("Verdana", 0, 18)); // NOI18N
        jLabelDescontoRS.setText("DESCONTO R$");

        jLabelRS8.setBackground(new Color(255, 255, 255));
        jLabelRS8.setFont(new Font("Verdana", 0, 36)); // NOI18N
        jLabelRS8.setText("R$");
        jLabelRS8.setOpaque(true);

        campoDescontoRS.setFont(new Font("Verdana", 0, 36)); // NOI18N
        campoDescontoRS.setHorizontalAlignment(JTextField.RIGHT);
        campoDescontoRS.setLayout(new BorderLayout());
        campoDescontoRS.add(jLabelRS8, BorderLayout.LINE_START);

        jLabelDescontoPer.setFont(new Font("Verdana", 0, 18)); // NOI18N
        jLabelDescontoPer.setText("DESCONTO %");

        campoDescontoPer.setFont(new Font("Verdana", 0, 36)); // NOI18N
        campoDescontoPer.setHorizontalAlignment(JTextField.RIGHT);

        btnConfirmarDesconto.setFont(new Font("Verdana", 0, 18)); // NOI18N
        btnConfirmarDesconto.setText("CONFIRMAR DESCONTO");
        btnConfirmarDesconto.setFocusable(false);

        GroupLayout painelDescontoLayout = new GroupLayout(painelDesconto);
        painelDesconto.setLayout(painelDescontoLayout);
        painelDescontoLayout.setHorizontalGroup(
                painelDescontoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(painelDescontoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(painelDescontoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(campoLabelLocalDesconto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(campoDescontoRS)
                                        .addComponent(jLabelDescontoRS, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                                        .addComponent(jLabelDescontoPer, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                                        .addComponent(campoDescontoPer)
                                        .addComponent(btnConfirmarDesconto, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
                                .addContainerGap())
        );
        painelDescontoLayout.setVerticalGroup(
                painelDescontoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(painelDescontoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(campoLabelLocalDesconto)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelDescontoRS)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoDescontoRS, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelDescontoPer)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoDescontoPer, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(btnConfirmarDesconto, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                .addContainerGap())
        );

        painelCardLogo.add(painelDesconto, "cardDesconto");

        btnAtalho1.setText("Atalho 1");
        btnAtalho1.setFocusable(false);

        btnAtalho2.setText("Atalho 2");
        btnAtalho2.setFocusable(false);

        btnAtalho3.setText("Atalho 3");
        btnAtalho3.setFocusable(false);

        btnAtalho4.setText("Atalho 4");
        btnAtalho4.setFocusable(false);

        btnAtalho5.setText("Atalho 5");
        btnAtalho5.setFocusable(false);

        btnAtalho6.setText("Atalho 6");
        btnAtalho6.setFocusable(false);

        btnAtalho7.setText("Atalho 7");
        btnAtalho7.setFocusable(false);

        btnAtalho8.setText("Atalho 8");
        btnAtalho8.setFocusable(false);

        btnAtalho9.setText("Atalho 9");
        btnAtalho9.setFocusable(false);

        btnAtalho10.setText("Atalho 0");
        btnAtalho10.setFocusable(false);

        GroupLayout painelBtnTouchLayout = new GroupLayout(painelBtnTouch);
        painelBtnTouch.setLayout(painelBtnTouchLayout);
        painelBtnTouchLayout.setHorizontalGroup(
                painelBtnTouchLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(painelBtnTouchLayout.createSequentialGroup()
                                .addComponent(btnAtalho1, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAtalho2, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                        .addGroup(painelBtnTouchLayout.createSequentialGroup()
                                .addGroup(painelBtnTouchLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnAtalho9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAtalho5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAtalho3, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAtalho7, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelBtnTouchLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAtalho8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAtalho6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAtalho4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAtalho10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        painelBtnTouchLayout.setVerticalGroup(
                painelBtnTouchLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, painelBtnTouchLayout.createSequentialGroup()
                                .addGroup(painelBtnTouchLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAtalho2, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                        .addComponent(btnAtalho1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelBtnTouchLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAtalho4, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                        .addComponent(btnAtalho3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelBtnTouchLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAtalho5, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                        .addComponent(btnAtalho6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelBtnTouchLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAtalho8, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                        .addComponent(btnAtalho7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelBtnTouchLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAtalho9, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                        .addComponent(btnAtalho10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        painelCardLogo.add(painelBtnTouch, "cardBtnTouch");

        painelBotonsNumericos.setPreferredSize(new Dimension(364, 238));

        btn7.setBackground(new Color(0, 0, 0));
        btn7.setFont(new Font("Verdana", 0, 18)); // NOI18N
        btn7.setForeground(new Color(255, 255, 255));
        btn7.setText("7");
        btn7.setFocusable(false);

        btn8.setBackground(new Color(0, 0, 0));
        btn8.setFont(new Font("Verdana", 0, 18)); // NOI18N
        btn8.setForeground(new Color(255, 255, 255));
        btn8.setText("8");
        btn8.setFocusable(false);

        btn9.setBackground(new Color(0, 0, 0));
        btn9.setFont(new Font("Verdana", 0, 18)); // NOI18N
        btn9.setForeground(new Color(255, 255, 255));
        btn9.setText("9");
        btn9.setFocusable(false);

        btn4.setBackground(new Color(0, 0, 0));
        btn4.setFont(new Font("Verdana", 0, 18)); // NOI18N
        btn4.setForeground(new Color(255, 255, 255));
        btn4.setText("4");
        btn4.setFocusable(false);

        btn5.setBackground(new Color(0, 0, 0));
        btn5.setFont(new Font("Verdana", 0, 18)); // NOI18N
        btn5.setForeground(new Color(255, 255, 255));
        btn5.setText("5");
        btn5.setFocusable(false);

        btn6.setBackground(new Color(0, 0, 0));
        btn6.setFont(new Font("Verdana", 0, 18)); // NOI18N
        btn6.setForeground(new Color(255, 255, 255));
        btn6.setText("6");
        btn6.setFocusable(false);

        btn1.setBackground(new Color(0, 0, 0));
        btn1.setFont(new Font("Verdana", 0, 18)); // NOI18N
        btn1.setForeground(new Color(255, 255, 255));
        btn1.setText("1");
        btn1.setFocusable(false);

        btn2.setBackground(new Color(0, 0, 0));
        btn2.setFont(new Font("Verdana", 0, 18)); // NOI18N
        btn2.setForeground(new Color(255, 255, 255));
        btn2.setText("2");
        btn2.setFocusable(false);

        btn3.setBackground(new Color(0, 0, 0));
        btn3.setFont(new Font("Verdana", 0, 18)); // NOI18N
        btn3.setForeground(new Color(255, 255, 255));
        btn3.setText("3");
        btn3.setFocusable(false);

        btn00.setBackground(new Color(0, 0, 0));
        btn00.setFont(new Font("Verdana", 0, 18)); // NOI18N
        btn00.setForeground(new Color(255, 255, 255));
        btn00.setText("00");
        btn00.setFocusable(false);

        btn0.setBackground(new Color(0, 0, 0));
        btn0.setFont(new Font("Verdana", 0, 18)); // NOI18N
        btn0.setForeground(new Color(255, 255, 255));
        btn0.setText("0");
        btn0.setFocusable(false);

        btnVirgula.setBackground(new Color(0, 0, 0));
        btnVirgula.setFont(new Font("Verdana", 0, 18)); // NOI18N
        btnVirgula.setForeground(new Color(255, 255, 255));
        btnVirgula.setText(",");
        btnVirgula.setFocusable(false);

        btnBackspace.setFont(new Font("Verdana", 0, 18)); // NOI18N
        btnBackspace.setText("<-");
        btnBackspace.setFocusable(false);

        btnSairNumerico.setFont(new Font("Verdana", 0, 18)); // NOI18N
        btnSairNumerico.setText("Sair");
        btnSairNumerico.setFocusable(false);

        btnTotalizar.setFont(new Font("Verdana", 0, 18)); // NOI18N
        btnTotalizar.setText("Total");
        btnTotalizar.setFocusable(false);

        btnFPagCartaoCred.setFont(new Font("Verdana", 0, 18)); // NOI18N
        btnFPagCartaoCred.setText("Cred");
        btnFPagCartaoCred.setFocusable(false);

        btnFPagDinheiro.setFont(new Font("Verdana", 0, 18)); // NOI18N
        btnFPagDinheiro.setText("Dinh");
        btnFPagDinheiro.setFocusable(false);

        btnFPagCartaoDeb.setFont(new Font("Verdana", 0, 18)); // NOI18N
        btnFPagCartaoDeb.setText("Debt");
        btnFPagCartaoDeb.setFocusable(false);

        btnQuantidade.setFont(new Font("Verdana", 0, 18)); // NOI18N
        btnQuantidade.setText("Qtd");
        btnQuantidade.setFocusable(false);

        btnEnterNumerico.setFont(new Font("Verdana", 0, 18)); // NOI18N
        btnEnterNumerico.setText("Entr");
        btnEnterNumerico.setFocusable(false);

        GroupLayout painelBotonsNumericosLayout = new GroupLayout(painelBotonsNumericos);
        painelBotonsNumericos.setLayout(painelBotonsNumericosLayout);
        painelBotonsNumericosLayout.setHorizontalGroup(
                painelBotonsNumericosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(painelBotonsNumericosLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(painelBotonsNumericosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(painelBotonsNumericosLayout.createSequentialGroup()
                                                .addGroup(painelBotonsNumericosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(painelBotonsNumericosLayout.createSequentialGroup()
                                                                .addComponent(btn1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btn2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btn3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnFPagDinheiro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(painelBotonsNumericosLayout.createSequentialGroup()
                                                                .addComponent(btn00, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btn0, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnVirgula, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnQuantidade, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnEnterNumerico, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, painelBotonsNumericosLayout.createSequentialGroup()
                                                .addGroup(painelBotonsNumericosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(painelBotonsNumericosLayout.createSequentialGroup()
                                                                .addComponent(btn4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btn5, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btn6, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnTotalizar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(painelBotonsNumericosLayout.createSequentialGroup()
                                                                .addComponent(btn7, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btn8, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btn9, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnBackspace, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(painelBotonsNumericosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnSairNumerico, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnFPagCartaoDeb, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnFPagCartaoCred, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        painelBotonsNumericosLayout.setVerticalGroup(
                painelBotonsNumericosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(painelBotonsNumericosLayout.createSequentialGroup()
                                .addGroup(painelBotonsNumericosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn7, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                        .addComponent(btn8, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                        .addComponent(btn9, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                        .addComponent(btnBackspace, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                        .addComponent(btnSairNumerico, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelBotonsNumericosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(painelBotonsNumericosLayout.createSequentialGroup()
                                                .addGroup(painelBotonsNumericosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btn4, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                                        .addComponent(btn5, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                                        .addComponent(btn6, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                                        .addComponent(btnTotalizar, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(painelBotonsNumericosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btn1, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                                        .addComponent(btn2, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                                        .addComponent(btn3, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(painelBotonsNumericosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btn00, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                                        .addComponent(btn0, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                                        .addComponent(btnVirgula, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                                        .addComponent(btnQuantidade, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)))
                                        .addGroup(painelBotonsNumericosLayout.createSequentialGroup()
                                                .addComponent(btnFPagCartaoCred, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(painelBotonsNumericosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnFPagCartaoDeb, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                                        .addComponent(btnFPagDinheiro, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnEnterNumerico, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))))
        );

        GroupLayout painelInserirItensLayout = new GroupLayout(painelInserirItens);
        painelInserirItens.setLayout(painelInserirItensLayout);
        painelInserirItensLayout.setHorizontalGroup(
                painelInserirItensLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(painelInserirItensLayout.createSequentialGroup()
                                .addComponent(painelCardValores, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelInserirItensLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(painelCardLogo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(painelBotonsNumericos, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)))
        );
        painelInserirItensLayout.setVerticalGroup(
                painelInserirItensLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(painelCardValores, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painelInserirItensLayout.createSequentialGroup()
                                .addComponent(painelCardLogo, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(painelBotonsNumericos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        GroupLayout painelVendasLayout = new GroupLayout(painelVendas);
        painelVendas.setLayout(painelVendasLayout);
        painelVendasLayout.setHorizontalGroup(
                painelVendasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, painelVendasLayout.createSequentialGroup()
                                .addComponent(jPanelItensPDV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(painelInserirItens, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelVendasLayout.setVerticalGroup(
                painelVendasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(painelVendasLayout.createSequentialGroup()
                                .addGroup(painelVendasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanelItensPDV, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(painelInserirItens, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(2, 2, 2))
        );

        painelCardVendas.add(painelVendas, "cardPDVVenda");

        GroupLayout painelTrocoLayout = new GroupLayout(painelTroco);
        painelTroco.setLayout(painelTrocoLayout);
        painelTrocoLayout.setHorizontalGroup(
                painelTrocoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 1280, Short.MAX_VALUE)
        );
        painelTrocoLayout.setVerticalGroup(
                painelTrocoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 576, Short.MAX_VALUE)
        );

        painelCardVendas.add(painelTroco, "cardPDVTroco");

        tbItensVendidosPDV.setFont(new Font("Verdana", 0, 18)); // NOI18N
        //tbItensVendidosPDV.setFocusable(false);
        tbItensVendidosPDV.setOpaque(false);
        tbItensVendidosPDV.setRowHeight(25);
        jScrollPaneItensVendidosPDV.setViewportView(tbItensVendidosPDV);

        GroupLayout painelItensVendidosLayout = new GroupLayout(painelItensVendidos);
        painelItensVendidos.setLayout(painelItensVendidosLayout);
        painelItensVendidosLayout.setHorizontalGroup(
                painelItensVendidosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPaneItensVendidosPDV, GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        painelItensVendidosLayout.setVerticalGroup(
                painelItensVendidosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPaneItensVendidosPDV, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
        );

        painelCardVendas.add(painelItensVendidos, "cardPDVItens");

        GroupLayout painelBtnBuscarProdutosLayout = new GroupLayout(painelBtnBuscarProdutos);
        painelBtnBuscarProdutos.setLayout(painelBtnBuscarProdutosLayout);
        painelBtnBuscarProdutosLayout.setHorizontalGroup(
                painelBtnBuscarProdutosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 350, Short.MAX_VALUE)
        );
        painelBtnBuscarProdutosLayout.setVerticalGroup(
                painelBtnBuscarProdutosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        tbBuscarProdutos.setFont(new Font("Verdana", 0, 18)); // NOI18N
        tbBuscarProdutos.setOpaque(false);
        tbBuscarProdutos.setRowHeight(25);
        jScrollPaneBuscarProdutos.setViewportView(tbBuscarProdutos);

        GroupLayout painelBuscarProdutoLayout = new GroupLayout(painelBuscarProduto);
        painelBuscarProduto.setLayout(painelBuscarProdutoLayout);
        painelBuscarProdutoLayout.setHorizontalGroup(
                painelBuscarProdutoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, painelBuscarProdutoLayout.createSequentialGroup()
                                .addComponent(jScrollPaneBuscarProdutos, GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(painelBtnBuscarProdutos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        painelBuscarProdutoLayout.setVerticalGroup(
                painelBuscarProdutoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(painelBtnBuscarProdutos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPaneBuscarProdutos, GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
        );

        painelCardVendas.add(painelBuscarProduto, "cardPDVBuscar");

        painelRodapePDV.setBackground(new Color(0, 0, 51));

        jLabelPDV.setFont(new Font("Verdana", 0, 16)); // NOI18N
        jLabelPDV.setForeground(new Color(255, 255, 255));
        jLabelPDV.setText("PDV:");

        campoCodPDV.setFont(new Font("Verdana", 0, 16)); // NOI18N
        campoCodPDV.setForeground(new Color(255, 255, 255));
        campoCodPDV.setText("000");

        jLabelFilial.setFont(new Font("Verdana", 0, 16)); // NOI18N
        jLabelFilial.setForeground(new Color(255, 255, 255));
        jLabelFilial.setText("FILIAL:");

        campoCodFilial.setFont(new Font("Verdana", 0, 16)); // NOI18N
        campoCodFilial.setForeground(new Color(255, 255, 255));
        campoCodFilial.setText("000");

        jSeparator1.setOrientation(SwingConstants.VERTICAL);

        jSeparator2.setOrientation(SwingConstants.VERTICAL);

        jLabelVersao.setFont(new Font("Verdana", 0, 16)); // NOI18N
        jLabelVersao.setForeground(new Color(255, 255, 255));
        jLabelVersao.setText("VERSÃO:");

        campoVersao.setFont(new Font("Verdana", 0, 16)); // NOI18N
        campoVersao.setForeground(new Color(255, 255, 255));
        campoVersao.setText("0.0.00");

        jSeparator3.setOrientation(SwingConstants.VERTICAL);

        jLabelOperador.setFont(new Font("Verdana", 0, 16)); // NOI18N
        jLabelOperador.setForeground(new Color(255, 255, 255));
        jLabelOperador.setText("OPERADOR:");

        campoCodOperador.setFont(new Font("Verdana", 0, 16)); // NOI18N
        campoCodOperador.setForeground(new Color(255, 255, 255));
        campoCodOperador.setText("000");

        campoNomeOperador.setFont(new Font("Verdana", 0, 16)); // NOI18N
        campoNomeOperador.setForeground(new Color(255, 255, 255));
        campoNomeOperador.setText("NOME OPERADOR");

        GroupLayout painelRodapePDVLayout = new GroupLayout(painelRodapePDV);
        painelRodapePDV.setLayout(painelRodapePDVLayout);
        painelRodapePDVLayout.setHorizontalGroup(
                painelRodapePDVLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(painelRodapePDVLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelPDV)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoCodPDV, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelFilial)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoCodFilial, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelVersao)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoVersao)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator3, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelOperador)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoCodOperador)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoNomeOperador)
                                .addContainerGap())
        );
        painelRodapePDVLayout.setVerticalGroup(
                painelRodapePDVLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(painelRodapePDVLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(painelRodapePDVLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, painelRodapePDVLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabelPDV, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(campoCodPDV, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabelFilial, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(campoCodFilial, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabelOperador, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(campoNomeOperador, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(campoCodOperador, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(campoVersao, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabelVersao, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jSeparator3, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSeparator2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSeparator1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        );

        GroupLayout painelPDVLayout = new GroupLayout(painelPDV);
        painelPDV.setLayout(painelPDVLayout);
        painelPDVLayout.setHorizontalGroup(
                painelPDVLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(painelRodapePDV, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(painelCardVendas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(painelCabecalhoPDV, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painelPDVLayout.setVerticalGroup(
                painelPDVLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, painelPDVLayout.createSequentialGroup()
                                .addComponent(painelCabecalhoPDV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(painelCardVendas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(painelRodapePDV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        painelCardPDV.add(painelPDV, "cardPDV");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(painelCardPDV, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(painelCardPDV, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private JButton btn0;
    private JButton btn00;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnAtalho1;
    private JButton btnAtalho10;
    private JButton btnAtalho2;
    private JButton btnAtalho3;
    private JButton btnAtalho4;
    private JButton btnAtalho5;
    private JButton btnAtalho6;
    private JButton btnAtalho7;
    private JButton btnAtalho8;
    private JButton btnAtalho9;
    private JButton btnBackspace;
    private JButton btnConfirmarDesconto;
    private JButton btnEnterNumerico;
    private JButton btnFPagCartaoCred;
    private JButton btnFPagCartaoDeb;
    private JButton btnFPagDinheiro;
    private JButton btnLoginEntrar;
    private JButton btnLoginSair;
    private JButton btnQuantidade;
    private JButton btnSairNumerico;
    private JButton btnTotalizar;
    private JButton btnVirgula;
    private JTextField campoCodBarras;
    private JLabel campoCodFilial;
    private JLabel campoCodOperador;
    private JLabel campoCodPDV;
    private JTextField campoCodUsuario;
    private JLabel campoCupom;
    private JLabel campoData;
    private JTextField campoDescontoPer;
    private JTextField campoDescontoRS;
    private JLabel campoHora;
    private JLabel campoLabelLocalDesconto;
    private JLabel campoNomeOperador;
    private JTextField campoPrecoProduto;
    private JTextField campoQuantidade;
    private JPasswordField campoSenhaUsuario;
    private JTextField campoSubTotalProduto;
    private JTextField campoValTotalAReceber;
    private JTextField campoValTotalCupom;
    private JTextField campoValTotalDesconto;
    private JTextField campoValTotalProdutos;
    private JTextField campoValTotalRecebido;
    private JLabel jLabelRS1;
    private JLabel jLabelRS2;
    private JLabel jLabelRS3;
    private JLabel jLabelRS4;
    private JLabel jLabelRS5;
    private JLabel jLabelRS6;
    private JLabel jLabelRS7;
    private JLabel jLabelRS8;
    private JLabel campoVersao;
    private JLabel imgLogo;
    private JLabel jLabelCodBarras;
    private JLabel jLabelCupom;
    private JLabel jLabelData;
    private JLabel jLabelDescontoPer;
    private JLabel jLabelDescontoRS;
    private JLabel jLabelFilial;
    private JLabel jLabelHora;
    private JLabel jLabelOperador;
    private JLabel jLabelPDV;
    private JLabel jLabelPrecoProduto;
    private JLabel jLabelQtd;
    private JLabel jLabelSubTotalProduto;
    private JLabel jLabelValTotalAReceber;
    private JLabel jLabelValTotalCupom;
    private JLabel jLabelValTotalDesconto;
    private JLabel jLabelValTotalProdutos;
    private JLabel jLabelValTotalRecebido;
    private JLabel jLabelVersao;
    private JPanel jPanelCabecalhoItensPDV;
    private JPanel jPanelItensPDV;
    private JPanel jPanelLogin;
    private JScrollPane jScrollPaneBuscarProdutos;
    private JScrollPane jScrollPaneFPagamento;
    private JScrollPane jScrollPaneItensPDV;
    private JScrollPane jScrollPaneItensVendidosPDV;
    private JScrollPane jScrollPaneRecebimentos;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JSeparator jSeparator3;
    private JLabel labelSenhaLogin;
    private JLabel labelUsuarioLogin;
    private JPanel painelBotonsNumericos;
    private JPanel painelBtnBuscarProdutos;
    private JPanel painelBtnTouch;
    private JPanel painelBuscarProduto;
    private JPanel painelCabecalhoPDV;
    private JPanel painelCardLogo;
    private JPanel painelCardPDV;
    private JPanel painelCardValores;
    private JPanel painelCardVendas;
    private JPanel painelDesconto;
    private JPanel painelFormasPagamento;
    private JPanel painelInserirItens;
    private JPanel painelItensVendidos;
    private JPanel painelLogin;
    private JPanel painelLogo;
    private JPanel painelPDV;
    private JPanel painelRodapePDV;
    private JPanel painelTroco;
    private JPanel painelValCupom;
    private JPanel painelValProduto;
    private JPanel painelVendas;
    private JTable tbBuscarProdutos;
    private JTable tbFPagamento;
    private JTable tbItensPDV;
    private JTable tbItensVendidosPDV;
    private JTable tbRecebimentos;

    @Override
    public String getIdUser() {
        return campoCodUsuario.getText();
    }

    @Override
    public void setIdUser(String id) {
        campoCodUsuario.setText(id);
    }

    @Override
    public String getPassword() {
        return new String(campoSenhaUsuario.getPassword());
    }

    @Override
    public String getBarcode() {
        return campoCodBarras.getText();
    }

    @Override
    public String getQuantity() {
        return campoQuantidade.getText();
    }

    @Override
    public void setQuantity(String quantity) {
        campoQuantidade.setText(quantity);
    }

    @Override
    public void setSalePrice(String salePrice) {
        campoPrecoProduto.setText(salePrice);
    }

    @Override
    public void setTotalProductValue(String totalProductValue) {
        campoSubTotalProduto.setText(totalProductValue);
    }

    @Override
    public void setTotalCouponValue(String totalCouponValue) {
        campoValTotalProdutos.setText(totalCouponValue);
        campoValTotalCupom.setText(totalCouponValue);
    }

    @Override
    public String getDiscountValue() {
        return campoDescontoRS.getText();
    }

    @Override
    public String getDiscountPercentage() {
        return campoDescontoPer.getText();
    }

    @Override
    public void setLoginActionPerformed(ActionListener listener) {
        btnLoginEntrar.addActionListener(listener);
    }

    @Override
    public void setExitActionPerformed(ActionListener listener) {
        btnLoginSair.addActionListener(listener);
        btnSairNumerico.addActionListener(listener);
    }

    @Override
    public void setFieldIDKeyPressed(KeyAdapter adapter) {
        campoCodUsuario.addKeyListener(adapter);
    }

    @Override
    public void setFieldPasswordKeyPressed(KeyAdapter adapter) {
        campoSenhaUsuario.addKeyListener(adapter);
    }

    @Override
    public void setFieldBarcodeKeyPressed(KeyAdapter adapter) {
        campoCodBarras.addKeyListener(adapter);
    }

    @Override
    public void setProductTableBackKeyPressed(KeyAdapter adapter) {
        tbItensVendidosPDV.addKeyListener(adapter);
    }

    @Override
    public void setProductSearchtableKeyPressed(KeyAdapter adapter) {
        tbBuscarProdutos.addKeyListener(adapter);
    }

    @Override
    public void setFieldTotalValueReceivedKeyPressed(KeyAdapter adapter) {
        campoValTotalRecebido.addKeyListener(adapter);
    }

    @Override
    public void setFieldDiscountValueKeyPressed(KeyAdapter adapter) {
        campoDescontoRS.addKeyListener(adapter);
    }

    @Override
    public void setFieldDiscountPercentageKeyPressed(KeyAdapter adapter) {
        campoDescontoPer.addKeyListener(adapter);
    }

    @Override
    public void setFieldBarcodeDocument(Document document) {
        campoCodBarras.setDocument(document);
    }

    @Override
    public void setFieldIDDocument(Document document) {
        campoCodUsuario.setDocument(document);
    }

    @Override
    public void setFieldSalePriceDocument(Document document) {
        campoPrecoProduto.setDocument(document);
    }

    @Override
    public void setFieldTotalProductValueDocument(Document document) {
        campoSubTotalProduto.setDocument(document);
    }

    @Override
    public void setFieldTotalCouponValueDocument(Document document) {
        campoValTotalProdutos.setDocument(document);
        campoValTotalCupom.setDocument(document);
    }

    @Override
    public void setFieldTotalDiscountDocument(Document document) {
        campoValTotalDesconto.setDocument(document);
    }

    @Override
    public void setFieldTotalOutstandingAmountDocument(Document document) {
        campoValTotalAReceber.setDocument(document);
    }

    @Override
    public void setFieldTotalValueReceivedDocument(Document document) {
        campoValTotalRecebido.setDocument(document);
    }

    @Override
    public void setFieldDiscountValueDocument(Document document) {
        campoDescontoRS.setDocument(document);
    }

    @Override
    public void setFieldDiscountPercentageDocument(Document document) {
        campoDescontoPer.setDocument(document);
    }

    @Override
    public void setFocusFieldID() {
        campoCodUsuario.requestFocus();
        campoCodUsuario.selectAll();
    }

    @Override
    public void setFocusFieldPassword() {
        campoSenhaUsuario.requestFocus();
        campoSenhaUsuario.selectAll();
    }

    @Override
    public void setFocusFieldBarcode() {
        campoCodBarras.requestFocus();
        campoCodBarras.selectAll();
    }

    @Override
    public void setFocusProductTableBack() {
        tbItensVendidosPDV.requestFocus();
    }

    @Override
    public void setFocusProductSearchTable() {
        tbBuscarProdutos.requestFocus();
    }

    @Override
    public void setFocusFieldTotalValueReceived() {
        campoValTotalRecebido.requestFocus();
    }

    @Override
    public void setFocusFieldDiscountValue() {
        campoDescontoRS.requestFocus();
    }

    @Override
    public void setFocusFieldDiscountPercentage() {
        campoDescontoPer.requestFocus();
    }

    @Override
    public void setFocusableFieldBarcode(boolean focus) {
        campoCodBarras.setFocusable(focus);
    }

    @Override
    public void setFocusableFieldTotalValueReceived(boolean focus) {
        campoValTotalRecebido.setFocusable(focus);
    }

    @Override
    public void cleanBarcodeField() {
        campoCodBarras.setText("");
    }

    @Override
    public void cleanDiscountValue() {
        campoDescontoRS.setText("");
    }

    @Override
    public void cleanDiscountPercentage() {
        campoDescontoPer.setText("");
    }

    @Override
    public void setStartCardL(String cardName) {
        CardLayout cardLayout = (CardLayout) painelCardPDV.getLayout();
        cardLayout.show(painelCardPDV, cardName);
    }

    @Override
    public void setSaleCardL(String cardName) {
        CardLayout cardLayout = (CardLayout) painelCardVendas.getLayout();
        cardLayout.show(painelCardVendas, cardName);
    }

    @Override
    public void setValueCardL(String cardName) {
        CardLayout cardLayout = (CardLayout) painelCardValores.getLayout();
        cardLayout.show(painelCardValores, cardName);
    }

    @Override
    public void setLogoCardL(String cardName) {
        CardLayout cardLayout = (CardLayout) painelCardLogo.getLayout();
        cardLayout.show(painelCardLogo, cardName);
    }

    @Override
    public JTable getProductTableFront() {
        return tbItensPDV;
    }

    @Override
    public JTable getProductTableBack() {
        return tbItensVendidosPDV;
    }

    @Override
    public JTable getProductSearchTable() {
        return tbBuscarProdutos;
    }

    @Override
    public JTable getPaymentMethodTable() {
        return tbFPagamento;
    }

    @Override
    public void setBackgroundLogin(JImagePanel imagePanel) {
        painelLogin.add(imagePanel);
    }

    @Override
    public void packAndShow() {
        pack();
        setVisible(true);
    }
}