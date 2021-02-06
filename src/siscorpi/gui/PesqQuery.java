/*
 * PesqQuery.java
 *
 * Created on 8 de Junho de 2005, 14:58
 */

package siscorpi.gui;
import  java.sql.*;
import  javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;
import  java.util.*;
import  siscorpi.util.ConnectionManager;
import  siscorpi.pedido.*;
import  siscorpi.util.*;

/**
 * A classe Pesquisar � gen�rica para qualquer tabela no banco de dados SQL 
 * para isto � s� seguir os parametros solicitados pela rotina
 * wListaSQL            =>   "SELECT * FROM uf where "
 * wCamposTabela[]      =>   new String [] {"Sigla","Estado"}
 * wNome_CamposTabela[] =>   new String [] {"Sigla","Descricao"}
 * wItemSelecionado     =>   1
 * parent               =>   new java.awt.Frame() 
 * modal                =>   true
 *
 * @author S�rgio Leite Bruno
 * @version 1.0
 */
public class PesqQuery extends javax.swing.JDialog {
    /** A return status code - returned if Cancel button has been pressed */
    public static final int RET_CANCEL = 0;
    /** A return status code - returned if OK button has been pressed */
    public static final int RET_OK = 1;

    String listaSQL, campoRetorno;
    String camposTabela[], nome_CamposTabela[];
    int itemSelecionado, fachadaSelecionada;

    private Pedido fachada;
    
    /** Creates new form PesqQuery */
    public PesqQuery(int wFachadaSelecionada, String wListaSQL,String wCamposTabela[], String 
    wNome_CamposTabela[],int wItemSelecionado,java.awt.Frame parent, boolean 
    modal) {
        super(parent, modal);
        try {
            this.fachada = new Pedido();
            initComponents();
            listaSQL          = wListaSQL;
            camposTabela      = wCamposTabela;
            nome_CamposTabela = wNome_CamposTabela;
            itemSelecionado   = wItemSelecionado;
            fachadaSelecionada = wFachadaSelecionada;
            // Preencher o combobox dbCampo com os t�tulos das colunas
            for ( int i = 0; i < wCamposTabela.length; ++i ) 
                cbCampo.addItem(wCamposTabela[i]);
            // SELECIONAR O CAMPO DE PESQUISA
            cbCampo.setSelectedIndex(itemSelecionado);
            tfArgumento.requestFocus();
            cbOrdenar.setSelected(true);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    /** @return the return status of this dialog - one of RET_OK or RET_CANCEL */
    public int getReturnStatus() {
        return returnStatus;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        buttonPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbCampo = new javax.swing.JComboBox();
        cbOrdenar = new javax.swing.JCheckBox();
        ckDecrescente = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        tfArgumento = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTabela = new javax.swing.JTable();

        setTitle("SisCorpI");
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        buttonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        buttonPanel.add(okButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        buttonPanel.add(cancelButton);

        getContentPane().add(buttonPanel, java.awt.BorderLayout.SOUTH);

        jPanel2.setBorder(new javax.swing.border.EtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(487, 70));
        jLabel1.setText("Campo de pesquisa:");
        jPanel2.add(jLabel1);

        cbCampo.setPreferredSize(new java.awt.Dimension(160, 22));
        jPanel2.add(cbCampo);

        cbOrdenar.setText("Ordenar");
        cbOrdenar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbOrdenarItemStateChanged(evt);
            }
        });

        jPanel2.add(cbOrdenar);

        ckDecrescente.setText("Ordem decrescente");
        jPanel2.add(ckDecrescente);

        jLabel2.setText("Argumento:");
        jPanel2.add(jLabel2);

        tfArgumento.setPreferredSize(new java.awt.Dimension(410, 20));
        tfArgumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfArgumentoKeyPressed(evt);
            }
        });

        jPanel2.add(tfArgumento);

        getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setOpaque(false);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(515, 165));
        jScrollPane2.setVerifyInputWhenFocusTarget(false);
        jtTabela.setBackground(new java.awt.Color(204, 255, 255));
        jtTabela.setBorder(new javax.swing.border.MatteBorder(null));
        jtTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtTabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jtTabela.setPreferredSize(new java.awt.Dimension(300, 170));
        jtTabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtTabelaKeyPressed(evt);
            }
        });
        jtTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTabelaMouseClicked(evt);
            }
        });

        jScrollPane2.setViewportView(jtTabela);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.WEST);

        pack();
    }
    // </editor-fold>//GEN-END:initComponents

    private void jtTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTabelaMouseClicked
        // TODO add your handling code here:
        if ( evt.getClickCount() >= 2 )
        {
            campoRetorno = String.valueOf( jtTabela.getValueAt(jtTabela.getSelectedRow(),0) );
            doClose(RET_OK);
        } 
    }//GEN-LAST:event_jtTabelaMouseClicked

    private void jtTabelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTabelaKeyPressed
        // TODO add your handling code here:
        if ( evt.getKeyText(evt.getKeyCode()).equals("Enter") ) 
        {
            campoRetorno = String.valueOf( jtTabela.getValueAt(jtTabela.getSelectedRow(),0) );
            doClose(RET_OK);
        } 
    }//GEN-LAST:event_jtTabelaKeyPressed

    private void tfArgumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfArgumentoKeyPressed
        // TODO add your handling code here:
        if ( evt.getKeyText(evt.getKeyCode()).equals("Enter") ) getTable();
    }//GEN-LAST:event_tfArgumentoKeyPressed

    private void cbOrdenarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbOrdenarItemStateChanged
        // TODO add your handling code here:
        if ( cbOrdenar.isSelected() != true ) ckDecrescente.setSelected(false);
        ckDecrescente.setEnabled( cbOrdenar.isSelected() );
    }//GEN-LAST:event_cbOrdenarItemStateChanged
    
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        try
        {        
            campoRetorno = String.valueOf( jtTabela.getValueAt(jtTabela.getSelectedRow(),0) );
            if ( ! campoRetorno.equals("") )
            {    
                doClose(RET_OK);            
            }
            else {
                doClose(RET_CANCEL);
            }
        }
        catch ( Exception ex ) 
        { 
        }
    }//GEN-LAST:event_okButtonActionPerformed
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed
   
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog
    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    /** Conecta com o banco e abre a tabela especificada anteriormente */
    private void getTable()
    {
      String wLista; 
      // PREPARANDO A LISTA SQL
      wLista = listaSQL + nome_CamposTabela[cbCampo.getSelectedIndex()] + 
      " LIKE '%" + tfArgumento.getText() + "%'";
      if (cbOrdenar.isSelected() )
      {
        wLista = wLista + " ORDER BY " + nome_CamposTabela[cbCampo.getSelectedIndex()];
        if (ckDecrescente.isSelected()) wLista = wLista + " DESC";
      }
      displayResultSet( wLista );
    }
    /**
    * Vai preenchendo o JTable com os itens de um banco de dados SQL
    * 
    * @param rs do tipo ResultSet que aponta para a posi��o do registro na 
    * tabela
    */    
    private void displayResultSet( String sql )
    {
      Vector columnHeads = new Vector();
      Vector rows        = new Vector();
      try {
        switch( fachadaSelecionada ) {
        case 1:
            rows = fachada.listarMvPedido(sql);
            break;
        case 2:
            rows = fachada.listarCliente(sql);
            break;
        case 3:
            rows = fachada.listarFuncionario(sql);
            break;
        case 4:
            rows = fachada.listarProduto(sql);
            break;
        case 5:
            rows = fachada.listarUsuario(sql);
            break;
        }
        boolean[] editavel = new boolean[camposTabela.length];
        for ( int i = 0; i < camposTabela.length; ++i ) 
        {    
            columnHeads.addElement(camposTabela[i]);
            editavel[i] = false;
        }    
        final boolean[] EDIT_COL = editavel;
        jtTabela.setModel(new javax.swing.table.DefaultTableModel( rows, columnHeads ) 
        { boolean[] canEdit = EDIT_COL ;             
           public boolean isCellEditable(int rowIndex, int columnIndex){
                return canEdit [columnIndex]; }
        }
        );
        validate();
      } catch(RepositorioException ex){ 
            JOptionPane.showMessageDialog(null,ex.getMessage(),"SisCorpI - Aten��o",
            JOptionPane.WARNING_MESSAGE);
      }
    }

    public String toString() { return campoRetorno; }
    /**
    * @param args the command line arguments
    */
    public void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesqQuery(fachadaSelecionada,listaSQL,camposTabela,nome_CamposTabela,
                itemSelecionado,new javax.swing.JFrame(), true).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox cbCampo;
    private javax.swing.JCheckBox cbOrdenar;
    private javax.swing.JCheckBox ckDecrescente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtTabela;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField tfArgumento;
    // End of variables declaration//GEN-END:variables
    
    private int returnStatus = RET_CANCEL;
}