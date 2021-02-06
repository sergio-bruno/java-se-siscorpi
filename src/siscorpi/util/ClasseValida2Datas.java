/*
 * ClasseValida2Datas.java
 *
 * Criado em 19 de Maio de 2005, 21:21
 */
package siscorpi.util;
import  javax.swing.*;
/**
 * Validar as datas supondo que esta vem no formato DD/MM/AAAA e que a primeira 
 * seja menor ou igual a segunda data.
 *
 * @author Sérgio Leite Bruno
 * @version 1.0
 */
public class ClasseValida2Datas {
    /** Criando uma nova instância da ClasseValida2Datas */
    public boolean Valida2Datas(String wData1, String wData2) {
        if ( wData1.equals("") || wData2.equals("") )   
           return true; 
        else if ( wData1.trim().length() != 10 || wData2.trim().length() != 10 )
        {    
            JOptionPane.showMessageDialog( null, "Data(s) informada(s) inválida(s) !",
            "SisCorpI - Informação",JOptionPane.INFORMATION_MESSAGE );
            return false;    
        }   
        else
        try
        {
            String wDia1 = wData1.substring(0, 2);
            String wMes1 = wData1.substring(3, 5);
            String wAno1 = wData1.substring(6, 10);
            String wDia2 = wData2.substring(0, 2);
            String wMes2 = wData2.substring(3, 5);
            String wAno2 = wData2.substring(6, 10);
            
            Integer iData1 = Integer.parseInt( wAno1 + wDia1 + wMes1 ); 
            Integer iData2 = Integer.parseInt( wAno2 + wDia2 + wMes2 ); 
            
            if ( iData1 > iData2 )        
            {
                JOptionPane.showMessageDialog( null, "A data inicial tem que ser menor ou igual a final...",
                "SisCorpI - Informação",JOptionPane.INFORMATION_MESSAGE );
                return false;
            }
            else return true;
        }        
        catch (Exception e) 
        { 
            JOptionPane.showMessageDialog( null, "Data(s) informada(s) inválida(s) !",
            "SisCorpI - Informação",JOptionPane.WARNING_MESSAGE );
            return false; 
        }
    }
}
