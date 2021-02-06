/*
 * ClasseTestaCodigoVazio.java
 *
 * Criado em 28 de Maio de 2005, 11:05
 */
package siscorpi.util;
import javax.swing.JOptionPane;
/**
 * Validar o campo n�o permitindo o conte�do vazio
 *
 * @author S�rgio Leite Bruno
 * @version 1.0
 */
public class ClasseTestaCodigoVazio {
    /**
    * Verifica se um campo foi obrigat�riamente preenchido 
    * 
    * @param wpCampo do tipo String Campo a ser verificado o conte�do,
    *        wpMsg do tipo String Mensagem a ser exibida caso n�o passe no teste
    * @return Verdadeiro se o campo foi preenchido ou falso se n�o preenchido
    */    
    public boolean TestaCodigoVazio(String wpCampo, String wpMsg) {
        if (wpCampo.equals("")) 
        {
            JOptionPane.showMessageDialog(null,"� necess�rio informar "+wpMsg,"SisCorpI - Aten��o",
            JOptionPane.WARNING_MESSAGE);
            return false;
        }    
        else return true;  
    }
    
}
