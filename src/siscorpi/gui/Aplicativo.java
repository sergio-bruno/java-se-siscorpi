/*
 * Aplicativo.java
 *
 * Created on 25 de Agosto de 2005, 00:41
 */
package siscorpi.gui;
import  java.awt.BorderLayout;
import  java.awt.Container;
import  java.awt.FlowLayout;
import  java.awt.Frame;
import  java.awt.GridLayout;
import  java.awt.event.ActionEvent;
import  java.awt.event.ActionListener;
import  siscorpi.util.*;
import  java.util.*;
import  javax.swing.*;
import  javax.swing.border.*;
import  siscorpi.util.ConnectionManager;
import  java.sql.*;
/**
 * A classe Main � a classe principal do programa, para que ela funcione ser� 
 * necess�rio:
 * 1 - Cria��o de um alias no ODBC do windows denominado: cli_java com o driver
 *     do Microsoft Access. O login e senha para acessar o sistema �: usuario,
 *     usuario.  
 * 2 - Descompactar a pasta jasperreports-0.6.1.zip para a unidade C: que auto-
 *     maticamente ser� criada uma pasta com mesmo nome
 * 3 - Caso o projeto seja compilado fora do NetBeans voc� precisar� importar os
 *     seguintes pacotes do JasperRreports: commons-beanutils-1.5.jar, 
 *     commons-collections-2.1.jar, commons-digester-1.3.jar,
 *     commons-logging-1.0.2.jar, commons-logging-api-1.0.2.jar,
 *     itext-1.01.jar, c:\jasperreports-0.6.1\classes. E os seguintes pacotes do
 *     jfreechart: jfreechart-1.0.0-pre2.jar, jcommon-1.0.0-pre2.jar 
 * 4 - Requisitos para rodar o Sistema: J2SE 1.5, jasperreports-0.6.1.zip, 
 *     opcional NetBeans IDE 4.0 ou superior
 * 5 - O padr�o Singleton � usado na tela de pedido de vendas
 *
 * @author S�rgio Leite Bruno
 * @version 2.00-0
 */
public class Aplicativo extends javax.swing.JFrame {
    /** Creates new form Aplicativo */
    public Aplicativo() {
        LoginUsuario loginUsuario = new LoginUsuario(new java.awt.Frame(),true);
        loginUsuario.setSize(250,160);
        loginUsuario.setLocationRelativeTo(null);
        loginUsuario.setVisible(true);
        if ( loginUsuario.getReturnStatus() != 1 )
        {
            ConnectionManager.liberaRecursos();
            System.exit(0);
        }    
        initComponents();
        jLabel2.setText("FAPE - TAPD - 5� Per�odo      |       USU�RIO: " + 
        loginUsuario.toString());
        loginUsuario = null;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JSeparator();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        jMenuItem19 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Para Controle de Pedidos v[0.00.1]");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/tasks_tsk.gif")));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jToolBar1.add(jButton1);

        jLabel3.setText("  ");
        jToolBar1.add(jLabel3);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/GRPHBAR.gif")));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jToolBar1.add(jButton5);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/GRPHLINE.gif")));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jToolBar1.add(jButton6);

        jLabel4.setText("  ");
        jToolBar1.add(jLabel4);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/builder.gif")));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jToolBar1.add(jButton4);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/linkto_help.gif")));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jToolBar1.add(jButton2);

        jLabel1.setText("  ");
        jToolBar1.add(jLabel1);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/home_nav.gif")));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jToolBar1.add(jButton3);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.NORTH);

        jLabel2.setText("FAPE - TAPD - 5\u00ba Per\u00edodo");
        jLabel2.setBorder(new javax.swing.border.BevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel2, java.awt.BorderLayout.SOUTH);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenu1.setMnemonic('A');
        jMenu1.setText("Arquivo");
        jMenuItem1.setMnemonic('e');
        jMenuItem1.setText("Cliente/Fornecedor");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });

        jMenu1.add(jMenuItem1);

        jMenuItem2.setMnemonic('F');
        jMenuItem2.setText("Funcion\u00e1rio");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });

        jMenu1.add(jMenuItem2);

        jMenuItem3.setMnemonic('P');
        jMenuItem3.setText("Produto");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });

        jMenu1.add(jMenuItem3);

        jMenuItem4.setMnemonic('U');
        jMenuItem4.setText("Usu\u00e1rio");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });

        jMenu1.add(jMenuItem4);

        jMenu1.add(jSeparator1);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/home_nav.gif")));
        jMenuItem5.setMnemonic('r');
        jMenuItem5.setText("Sair");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });

        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setMnemonic('M');
        jMenu2.setText("Movimento");
        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/tasks_tsk.gif")));
        jMenuItem6.setMnemonic('P');
        jMenuItem6.setText("Controle de Pedidos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });

        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu3.setMnemonic('l');
        jMenu3.setText("Relat\u00f3rio");
        jMenuItem7.setMnemonic('l');
        jMenuItem7.setText("Cadastro Cliente/Fornecedor");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });

        jMenu3.add(jMenuItem7);

        jMenuItem8.setMnemonic('k');
        jMenuItem8.setText("Ranking de Clientes");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });

        jMenu3.add(jMenuItem8);

        jMenuItem9.setMnemonic('P');
        jMenuItem9.setText("Ranking de Produtos");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });

        jMenu3.add(jMenuItem9);

        jMenuItem10.setMnemonic('I');
        jMenuItem10.setText("Re-Impres\u00e3o de Pedido de vendas");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });

        jMenu3.add(jMenuItem10);

        jMenuItem11.setMnemonic('F');
        jMenuItem11.setText("Faturamento");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });

        jMenu3.add(jMenuItem11);

        jMenuBar1.add(jMenu3);

        jMenu4.setMnemonic('n');
        jMenu4.setText("Consulta");
        jMenuItem12.setMnemonic('e');
        jMenuItem12.setText("Cliente/Fornecedor");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });

        jMenu4.add(jMenuItem12);

        jMenuItem13.setMnemonic('F');
        jMenuItem13.setText("Funcion\u00e1rio");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });

        jMenu4.add(jMenuItem13);

        jMenuItem14.setMnemonic('P');
        jMenuItem14.setText("Produto");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });

        jMenu4.add(jMenuItem14);

        jMenuItem15.setMnemonic('U');
        jMenuItem15.setText("Usu\u00e1rio");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });

        jMenu4.add(jMenuItem15);

        jMenu4.add(jSeparator3);

        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/GRPHBAR.gif")));
        jMenuItem16.setMnemonic('k');
        jMenuItem16.setText("Ranking de Clientes");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });

        jMenu4.add(jMenuItem16);

        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/GRPHLINE.gif")));
        jMenuItem17.setMnemonic('d');
        jMenuItem17.setText("Ranking de Produtos");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });

        jMenu4.add(jMenuItem17);

        jMenuBar1.add(jMenu4);

        jMenu5.setMnemonic('U');
        jMenu5.setText("Utilit\u00e1rio");
        jMenuItem18.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/builder.gif")));
        jMenuItem18.setMnemonic('l');
        jMenuItem18.setText("Calculadora");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });

        jMenu5.add(jMenuItem18);

        jMenu5.add(jSeparator2);

        jMenuItem19.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/home_nav.gif")));
        jMenuItem19.setMnemonic('S');
        jMenuItem19.setText("Sobre");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });

        jMenu5.add(jMenuItem19);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }
    // </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AtivaPedido();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        AtivaPedido();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    void AtivaPedido(){
        // PADR�O SINGLETON
        MvPdVendas pedido_venda = MvPdVendas.obterInstancia();
        pedido_venda.setSize(726,465);
        pedido_venda.setLocationRelativeTo(null);
	pedido_venda.setVisible(true);
    }
    
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        CadastroProduto cadastro_prd = new CadastroProduto();
        cadastro_prd.setSize(522,175);
        cadastro_prd.setLocationRelativeTo(null);
	cadastro_prd.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
	CadastroFuncionario cadastro_fun = new CadastroFuncionario();
        cadastro_fun.setSize(535,150);
        cadastro_fun.setLocationRelativeTo(null);
	cadastro_fun.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        ConnectionManager.liberaRecursos();
    }//GEN-LAST:event_formWindowClosed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
	CadastroUsuario cadastro_usu = new CadastroUsuario();
        cadastro_usu.setSize(435,175);
        cadastro_usu.setLocationRelativeTo(null);
	cadastro_usu.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        GraficoProduto();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        GraficoCli();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        infoSistema();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        JCalc jcalc = new JCalc (); 
        jcalc.setVisible (true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        // TODO add your handling code here:
        JCalc jcalc = new JCalc (); 
        jcalc.setVisible (true);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
        infoSistema();
    }//GEN-LAST:event_jMenuItem19ActionPerformed
    private void infoSistema(){
        Info info = new Info(new java.awt.Frame(), true);
        info.setSize(420,200);
        info.setLocationRelativeTo(null);
        info.setVisible(true);
        info = null;
    }
    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        Consultar consulta = new Consultar(5,"SELECT Login From usuario",
        new String [] {"Login"},new String [] {"Login"},"Consulta Usu�rio");
        consulta.setSize(615,530);
        consulta.setLocationRelativeTo(null);
	consulta.setVisible(true);
        consulta = null;
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        Consultar consulta = new Consultar(4,"SELECT Codigo,Descricao,Preco_venda,Unidade,Cod_barras From produto",
        new String [] {"C�digo","Descri��o","P�o. Venda","Unidade","C�d. Barra"},
        new String [] {"Codigo","Descricao","Preco_venda","Unidade","Cod_barras"},
        "Consulta Produto");
        consulta.setSize(615,530);
        consulta.setLocationRelativeTo(null);
	consulta.setVisible(true);
        consulta = null;
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        Consultar consulta = new Consultar(3, "SELECT Codigo,Nome,Identidade,Cpf,Comissao From funcionario",
        new String [] {"C�digo","Nome","RG","CPF","% Comiss�o"},
        new String [] {"Codigo","Nome","Identidade","cpf","Comissao"},
        "Consulta Funcion�rio");
        consulta.setSize(615,530);
        consulta.setLocationRelativeTo(null);
	consulta.setVisible(true);
        consulta = null;
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        Consultar consulta = new Consultar(2, "SELECT Codigo,Razao_social,Fantasia,Cnpj_cpf,Ie From clientes",
        new String [] {"C�digo","Raz�o Social","Fantasia","CNPJ/CPF","Insc. Estadual"},
        new String [] {"Codigo","Razao_social","Fantasia","Cnpj_cpf","Ie"},
        "Consulta Cliente/Fornecedor");
        consulta.setSize(615,530);
        consulta.setLocationRelativeTo(null);
	consulta.setVisible(true);
        consulta = null;
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
        GraficoProduto();
    }//GEN-LAST:event_jMenuItem17ActionPerformed
    private void GraficoProduto() {                                            
        // TODO add your handling code here:
        ConsultarGrafico consultaGarfPrd = new ConsultarGrafico(
        "select c.codigo,c.descricao,sum(p.qtde) " +
        "from itempdvenda p,produto c " +
        "where p.produto=c.codigo " +
        "group by c.codigo,c.descricao order by 3 desc",
        new String [] {"C�digo","Produto","Vendido"},
        " Posi��o de produtos mais vendidos","Ranking de produtos",
        "Produtos","Quantidades");
        consultaGarfPrd.setSize(698,570);
        consultaGarfPrd.setLocationRelativeTo(null);
	consultaGarfPrd.setVisible(true);
        consultaGarfPrd = null;
    }                                           

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
        GraficoCli();
    }//GEN-LAST:event_jMenuItem16ActionPerformed
    private void GraficoCli(){
        ConsultarGrafico consultaGarfCli = new ConsultarGrafico(
        "select c.codigo,c.Razao_social,sum(p.total) " +
        "from pdvendas p,clientes c " +
        "where p.cliente=c.codigo and p.situacao<>'C' " +
        "group by c.codigo,c.Razao_social order by 3 desc",
        new String [] {"C�digo","Raz�o Social","Comprado"},
        " Posi��o de clientes que mais compram","Ranking de Clientes",
        "Clientes","Valor $");
        consultaGarfCli.setSize(698,570);
        consultaGarfCli.setLocationRelativeTo(null);
	consultaGarfCli.setVisible(true);
        consultaGarfCli = null;
    }
    
    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        InformaDatas info_data = new InformaDatas(new java.awt.Frame(),true);
        info_data.setLocationRelativeTo(null);
        info_data.setVisible(true);
        if (! info_data.cancelado)
        {
            String wData1 = info_data.retornaData1();
            String wData2 = info_data.retornaData2();
            Map parameters = new HashMap();
            parameters.put("idData1",wData1);
            parameters.put("idData2",wData2);
            ClasseRelatorio cRelatorio = new ClasseRelatorio();
            cRelatorio.Relatorio(new String("relfatanalitico.jasper"),parameters);
            cRelatorio = null;
        }    
        info_data = null;
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
           String nPedido;
           nPedido = JOptionPane.showInputDialog("Digite o n� do pedido");
           if ( ! nPedido.trim().equals("") ) 
           {
                 ClasseStrZero cStrZero = new ClasseStrZero();
                 nPedido = cStrZero.strzero( nPedido, 7);
                 Map parameters = new HashMap();
                 parameters.put("idCliente",nPedido);
                 ClasseRelatorio cRelatorio = new ClasseRelatorio();
                 cRelatorio.Relatorio(new String("relpedcliente.jasper"), parameters);
                 cStrZero = null;
                 cRelatorio = null;
           }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        ClasseRelatorio cRelatorio = new ClasseRelatorio();
        cRelatorio.Relatorio(new String("relrankingprodutos.jasper"),new HashMap());
        cRelatorio = null;
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        ClasseRelatorio cRelatorio = new ClasseRelatorio();
        cRelatorio.Relatorio(new String("relrankingclientes.jasper"),new HashMap());
        cRelatorio = null;
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        ClasseRelatorio cRelatorio = new ClasseRelatorio();
        cRelatorio.Relatorio(new String("relcadclientes.jasper"),new HashMap());
        cRelatorio = null;
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
	CadastroCliente cadastro_cli = new CadastroCliente();
        cadastro_cli.setSize(565,346);
        cadastro_cli.setLocationRelativeTo(null);
	cadastro_cli.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
   
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem5ActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aplicativo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
