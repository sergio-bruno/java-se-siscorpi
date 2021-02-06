/*
 * ClasseValidaData.java
 *
 * Criado em 11 de Maio de 2005, 23:11
 */
package siscorpi.util;
import javax.swing.*;
/**
 * Validar a data supondo que esta vem no formato DD/MM/AAAA
 *
 * @author Sérgio Leite Bruno
 * @version 1.0
 */
public class ClasseValidaData {
    /** Creates a new instance of ClasseValidaData */
    public boolean ValidaData(String wData) 
    {
        if ( wData.equals("") )   
           return true; 
        else if ( wData.trim().length() != 10 )
        {    
            JOptionPane.showMessageDialog( null, "Data informada inválida !",
            "SisCorpI - Informação",JOptionPane.WARNING_MESSAGE );
            return false;    
        }   
        else
        try
        {
            String wDia = wData.substring(0, 2);
            String wMes = wData.substring(3, 5);
            String wAno = wData.substring(6, 10);
            Integer iDia = Integer.parseInt(wDia), 
                    iMes = Integer.parseInt(wMes),
                    iAno = Integer.parseInt(wAno);
            if ( iMes > 12 ) 
            {
                JOptionPane.showMessageDialog( null, "Mês informado inválido !",
                "SisCorpI - Informação",JOptionPane.WARNING_MESSAGE );
                return false;
            }
            else
            {    
                if ( iMes == 1 || iMes == 3 || iMes == 5 || iMes == 7 || iMes == 8 || iMes == 10 || iMes == 12)
                {    
                    if (iDia > 31)
                    {
                        JOptionPane.showMessageDialog( null, "Dia informado inválido !",
                        "SisCorpI - Informação",JOptionPane.WARNING_MESSAGE );
                        return false;
                    }    
                    else return true;
                }
                else if ( iMes == 4 || iMes == 6 || iMes == 9 || iMes == 11)
                {    
                    if (iDia > 30)
                    {
                        JOptionPane.showMessageDialog( null, "Dia informado inválido !",
                        "SisCorpI - Informação",JOptionPane.WARNING_MESSAGE );
                        return false;
                    }    
                    else return true;
                }        
                else
                {
                    Integer resto = (iAno % 4);
                    if ( resto == 0)
                    {    
                        if ( iDia > 29 )
                        {    
                            JOptionPane.showMessageDialog( null, "Dia informado inválido !",
                            "SisCorpI - Informação",JOptionPane.WARNING_MESSAGE );
                            return false;
                        }
                        else return true;
                    }    
                    else if ( iDia > 28 )
                    {    
                        JOptionPane.showMessageDialog( null, "Dia informado inválido !",
                        "SisCorpI - Informação",JOptionPane.WARNING_MESSAGE );
                        return false;
                    }
                    else return true;
                }    
            }    
        }        
        catch (Exception e) 
        { 
            JOptionPane.showMessageDialog( null, "Data informado inválida !",
            "SisCorpI - Informação",JOptionPane.WARNING_MESSAGE );
            return false; 
        }
    }
}
