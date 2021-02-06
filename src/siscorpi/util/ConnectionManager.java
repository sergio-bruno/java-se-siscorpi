/*
 * ConnectionManager.java
 *
 * Criado em 11 de Maio de 2005, 23:11
 */
package siscorpi.util;
import javax.swing.*;
import java.sql.*;
/**
 * A classe ConnecionManager é responsável por conectar com a base de dados
 *
 * @author Sérgio Leite Bruno
 * @version 1.0
 */
public class ConnectionManager {
    private static Connection connection;
    private static Statement statement;
    public  static Statement reservaStatement() {
        if (connection == null) {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                connection = DriverManager.getConnection("jdbc:odbc:cli_java","Administrador","masterkey");
                //connection = DriverManager.getConnection("jdbc:odbc:psqlsiscorpi","postgres","master123");
            } catch(SQLException sqle) {
                    JOptionPane.showMessageDialog(null,"SQLException => ConnectionManager: " + sqle.getMessage(),
                    "SisCorpI - Atenção",JOptionPane.WARNING_MESSAGE);
    	    } catch(ClassNotFoundException cnfe) {
                    JOptionPane.showMessageDialog(null,"Driver nao encontrado => ConnectionManager: " + cnfe.getMessage(),
                    "SisCorpI - Atenção",JOptionPane.WARNING_MESSAGE);
    	    }
    	}
    	try {
    	    statement = connection.createStatement();
    	} catch(SQLException sqle) {
                    JOptionPane.showMessageDialog(null,"SQLException => ConnectionManager: " + sqle.getMessage(),
                    "SisCorpI - Atenção",JOptionPane.WARNING_MESSAGE);
    	}
    	return statement;
    }
    /**
     * Atenção, este método fecha o Statement!
     */
    public synchronized static void liberaStatement() {
        try {
            if (statement != null) statement.close();
	    } catch(SQLException sqle) {
                    JOptionPane.showMessageDialog(null,"Erro de BD => ConnectionManager" + sqle.getMessage(),
                    "SisCorpI - Atenção",JOptionPane.WARNING_MESSAGE);
	    }
	}
    public static void liberaRecursos() {
        try {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (Exception ex) {}
        try {
            connection.close();
        } catch (Exception ex) {}
    }
    public static Connection RetornaConnection() 
    {
        return connection;
    }
}