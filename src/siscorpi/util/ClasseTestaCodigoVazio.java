/*
 * ClasseTestaCodigoVazio.java
 *
 * Criado em 28 de Maio de 2005, 11:05
 */
package siscorpi.util;
import javax.swing.JOptionPane;
/**
 * Validar o campo não permitindo o conteúdo vazio
 *
 * @author Sérgio Leite Bruno
 * @version 1.0
 */
public class ClasseTestaCodigoVazio {
    /**
    * Verifica se um campo foi obrigatóriamente preenchido 
    * 
    * @param wpCampo do tipo String Campo a ser verificado o conteúdo,
    *        wpMsg do tipo String Mensagem a ser exibida caso não passe no teste
    * @return Verdadeiro se o campo foi preenchido ou falso se não preenchido
    */    
    public boolean TestaCodigoVazio(String wpCampo, String wpMsg) {
        if (wpCampo.equals("")) 
        {
            JOptionPane.showMessageDialog(null,"É necessário informar "+wpMsg,"SisCorpI - Atenção",
            JOptionPane.WARNING_MESSAGE);
            return false;
        }    
        else return true;  
    }
    
}
