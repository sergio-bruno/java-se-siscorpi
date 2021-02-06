/*
 * ClasseRecebeLinhaGrafico.java
 *
 * Created on 26 de Setembro de 2005, 01:31
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package siscorpi.util;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DecimalFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
/**
 *
 * @author sergio
 */
public class ClasseRecebeLinhaGrafico {
    /** Creates a new instance of ClasseRecebeLinhaGrafico */
    public Vector RecebeLinhaGrafico( ResultSet rs, ResultSetMetaData rsmd ) throws SQLException {
        Vector currentRow = new Vector();
        DecimalFormat doisDigitos = new DecimalFormat("0.00"); 
        for ( int i = 1; i <= rsmd.getColumnCount(); ++i )
            switch( rsmd.getColumnType( i ) ) {
            case Types.VARCHAR:
                currentRow.addElement( rs.getString( i ) );
                break;
            case Types.INTEGER:
                currentRow.addElement(new Long( rs.getLong( i ) ) );
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
                    JOptionPane.showMessageDialog(null,ex.toString(),"Atenção",
                    JOptionPane.WARNING_MESSAGE);	
                }
            }
        return currentRow;
    }
}
