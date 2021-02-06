/*
 * ClasseTrocaCaracteres.java
 *
 * Criado em 16 de Maio de 2005, 16:07
 */
package siscorpi.util;
/**
 * A classe ClasseTrocaCaracters substitui um caracter de um texto por outro
 *
 * @author Sérgio Leite Bruno
 * @version 1.0
 */
public class ClasseTrocaCaracteres {
    /** Creates a new instance of ClasseTrocaCaracteres */
    public String TrocaCaracteres( String xCaracRemover, String xCaracTrocar, String xTexto )
    {
        String s_aux, retorno;
        retorno = "";
        for (int i = 0; i < xTexto.length(); i++) 
        {
           s_aux = xTexto.substring ( i, i + 1 );
           if (xCaracRemover.indexOf(s_aux) == -1) 
              retorno = retorno + s_aux;
           else retorno = retorno + xCaracTrocar;
        }      
        return retorno;
   }
}
