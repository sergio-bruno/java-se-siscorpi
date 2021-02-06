/*
 * ClasseRelatorio.java
 *
 * Criado em 15 de Maio de 2005, 18:49
 */
package siscorpi.util;
import  net.sf.jasperreports.engine.*;
import  net.sf.jasperreports.view.*;
import  java.util.*;
import  java.sql.*;
/**
 * A classe ClasseRelatorio é responsável pela visualização na tela em Swing do 
 * do relatório
 *
 * @author Sérgio Leite Bruno
 * @version 1.0
 */
public class ClasseRelatorio {
    /** Creates a new instance of ClasseRelatorio */
    public void Relatorio(String layout,Map parameters) 
    {
        try
        {
            layout = getClass().getResource("/relatorio/" + layout).toString();
            layout = layout.substring(6, layout.length());
            JasperReport relatorio = JasperManager.loadReport(layout);
            Statement statement = ConnectionManager.reservaStatement();
            Connection con = ConnectionManager.RetornaConnection();
            JasperPrint impressao = JasperFillManager.fillReport(layout, 
                                    parameters, con);
            JasperViewer viewer = new JasperViewer(impressao, false);
            viewer.show();
        }
        catch (JRException ex) { ex.printStackTrace(); }
	catch (Exception ex) { ex.printStackTrace(); }
        finally { ConnectionManager.liberaStatement(); }	 
    }
}
