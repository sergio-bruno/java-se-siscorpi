/*
 * ConsultarGrafico.java
 *
 * Criado em 28 de Maio de 2005, 11:24
 */
package siscorpi.gui;
import  siscorpi.util.*;
import org.jfree.chart.ChartPanel;
import java.awt.Graphics;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.text.DecimalFormat;
// Gr�fico de pizza
import org.jfree.data.general.DefaultPieDataset;
// Gr�fico de barras
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * A classe ConsultarGrfico preenche um JTable com uma consulta SQL, gen�rica 
 * para qualquer tabela e o gr�fico correspondente aos valores da tabela.
 *
 * @author S�rgio Leite Bruno
 * @version 1.0
 */
public class ConsultarGrafico extends javax.swing.JFrame {
    String listaSQL, tituloConsulta, tituloGrafico, nome_CamposTabela[],
    titulo1, titulo2;        
    DefaultPieDataset dataset = new DefaultPieDataset();
    DefaultCategoryDataset datasetBar = new DefaultCategoryDataset();
    ClasseMontaGrafico cMontaGrafico = new ClasseMontaGrafico();
    
    /** Construtor da classe ConsultarGrafico */
    public ConsultarGrafico(String wListaSQL, String wNome_CamposTabela[],
    String wTituloConsulta, String wTituloGrafico, String wTitulo1, String wTitulo2) {
        initComponents();
        listaSQL          = wListaSQL;
        nome_CamposTabela = wNome_CamposTabela;
        tituloConsulta    = wTituloConsulta;
        tituloGrafico     = wTituloGrafico;
        titulo1           = wTitulo1;
        titulo2           = wTitulo2;
        jlTitulo.setText(tituloConsulta);  
        getTable();
        getGrafico();
        jPanel2.add(cMontaGrafico.MontaGrafico(0,tituloGrafico,dataset,
        datasetBar,titulo1,titulo2));
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jlTitulo = new javax.swing.JLabel();
        cbTipoGrafico = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabela = new javax.swing.JTable();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SisCorpI");
        setResizable(false);
        jPanel2.setBorder(new javax.swing.border.EtchedBorder());
        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 100, 690, 440);

        jPanel1.setLayout(null);

        jPanel1.setBorder(new javax.swing.border.EtchedBorder());
        jlTitulo.setFont(new java.awt.Font("Times New Roman", 1, 18));
        jlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlTitulo.setText(" T\u00edtulo do Gr\u00e1fico");
        jPanel1.add(jlTitulo);
        jlTitulo.setBounds(0, 0, 410, 30);

        cbTipoGrafico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pizza", "Barras", "Linhas", "�rea" }));
        cbTipoGrafico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTipoGraficoItemStateChanged(evt);
            }
        });

        jPanel1.add(cbTipoGrafico);
        cbTipoGrafico.setBounds(520, 4, 150, 22);

        jLabel1.setText("Tipo do gr\u00e1fico:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(420, 10, 90, 14);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 690, 30);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jtTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtTabela);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 30, 690, 70);

        pack();
    }
    // </editor-fold>//GEN-END:initComponents
   /**
    * Seleciona o tipo de gr�fico se o jComboBox for alterado o valor
    */
    private void cbTipoGraficoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoGraficoItemStateChanged
        // TODO add your handling code here:
        jPanel2.removeAll();
        jPanel2.add( cMontaGrafico.MontaGrafico(cbTipoGrafico.getSelectedIndex(),
        tituloGrafico,dataset,datasetBar,titulo1,titulo2));
        jPanel2.validate();
        jPanel2.repaint();
    }//GEN-LAST:event_cbTipoGraficoItemStateChanged
   /**
    * Conecta com o banco e abre a tabela especificada anteriormente e preenche 
    * com os dados de compara��o do gr�fico
    */
    private void getGrafico()
   {
      double wvalor;
      String wcampo;
      int wi = 0;
      try {
            // PREPARANDO A LISTA SQL
            Statement statement = ConnectionManager.reservaStatement();
            ResultSet resultset = statement.executeQuery(listaSQL); 
            boolean moreRecords = resultset.next();  
            if ( ! moreRecords ) 
            {
                JOptionPane.showMessageDialog( this,  "Tabela vazia" );
                return;
            }
            else {
                do 
                { 
                    ++wi;
                    wvalor = resultset.getDouble( 3 );
                    wcampo = resultset.getString( 1 );
                    dataset.setValue( wcampo, wvalor );
                    datasetBar.setValue( wvalor, wcampo, "..." );
                } while ( resultset.next() ); }
      }
      catch ( SQLException sqlex ) 
      {
         sqlex.printStackTrace();
         JOptionPane.showMessageDialog(null,sqlex.toString(),"Aten��o",JOptionPane.WARNING_MESSAGE);	
      }
      finally { ConnectionManager.liberaStatement(); }
    }
   /**
    * Conecta com o banco e abre a tabela especificada anteriormente
    */
    private void getTable()
   {
      String wLista; 
      try {
            // PREPARANDO A LISTA SQL
            Statement statement = ConnectionManager.reservaStatement();
            ResultSet resultset = statement.executeQuery(listaSQL); 
            displayResultSet( resultset );
      }
      catch ( SQLException sqlex ) 
      {
         sqlex.printStackTrace();
         JOptionPane.showMessageDialog(null,sqlex.toString(),"Aten��o",JOptionPane.WARNING_MESSAGE);	
      }
      finally { ConnectionManager.liberaStatement(); }
   }
  /**
  * Vai preenchendo o JTable com os itens de um banco de dados SQL
  * 
  * @param rs do tipo ResultSet que aponta para a posi��o do registro na 
  * tabela
  */    
   private void displayResultSet( ResultSet rs ) throws SQLException
   {
      // position to first record
      boolean moreRecords = rs.next();  
      // If there are no records, display a message
      if ( ! moreRecords ) 
      {
         JOptionPane.showMessageDialog( this,  "Tabela vazia" );
         return;
      }
      Vector columnHeads = new Vector();
      Vector rows        = new Vector();
      boolean[] editavel = new boolean[nome_CamposTabela.length];
      try {
         // get column heads
         ResultSetMetaData rsmd = rs.getMetaData();
         for ( int i = 0; i < nome_CamposTabela.length; ++i ) 
         {    
             columnHeads.addElement(nome_CamposTabela[i]);
             editavel[i] = false;
         }    
         final boolean[] EDIT_COL = editavel;
         
         do 
         { 
            rows.addElement( getNextRow( rs, rsmd ) ); 
         } while ( rs.next() );
         
         jtTabela.setModel(new javax.swing.table.DefaultTableModel( rows, columnHeads ) 
         { boolean[] canEdit = EDIT_COL ;             
           public boolean isCellEditable(int rowIndex, int columnIndex){
                return canEdit [columnIndex]; }
         }
         );
         validate();
      }
      catch ( SQLException sqlex ) 
      { 
          sqlex.printStackTrace(); 
          JOptionPane.showMessageDialog(null,sqlex.toString(),"Aten��o",JOptionPane.WARNING_MESSAGE);	
      }
   }
   /**
   * Verifica o conte�do da linha atual de uma tabela e formata o campo caso seja 
   * real
   * 
   * @param rs do tipo ResultSet, rsmd do tipo ResultSetMetaData
   */    
   private Vector getNextRow( ResultSet rs, ResultSetMetaData rsmd ) throws 
   SQLException
   {
      Vector currentRow = new Vector();
      DecimalFormat doisDigitos = new DecimalFormat("0.00");
      for ( int i = 1; i <= rsmd.getColumnCount(); ++i )
         switch( rsmd.getColumnType( i ) ) {
            case Types.VARCHAR:
                  currentRow.addElement( rs.getString( i ) );
               break;
            case Types.INTEGER:
                  currentRow.addElement( 
                     new Long( rs.getLong( i ) ) );
               break;
            default: 
                try
                {        
                    currentRow.addElement( doisDigitos.format( Double.parseDouble(rs.getString( i )) ) );  
                }
                catch ( Exception ex ) 
                { 
                    System.out.println( "Campo do tipo: " + 
                    rsmd.getColumnTypeName( i ) + " - " +rsmd.getColumnType( i ));
                    ex.printStackTrace(); 
                    JOptionPane.showMessageDialog(null,ex.toString(),"Aten��o",
                    JOptionPane.WARNING_MESSAGE);	
                }
         }
      return currentRow;
   }
    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarGrafico(listaSQL, nome_CamposTabela,tituloConsulta,
                tituloGrafico,titulo1,titulo2).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbTipoGrafico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTable jtTabela;
    // End of variables declaration//GEN-END:variables
    
}
