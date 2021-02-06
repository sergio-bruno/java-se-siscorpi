/*
 * ClasseRemoveCaracters.java
 *
 * Criado em 10 de Maio de 2005, 17:06
 */
package siscorpi.util;
/**
 * A classe ClasseRemoveCaracters retira um caracter passado como argumento de 
 * um texto 
 *
 * @author Sérgio Leite Bruno
 * @version 1.0
 */
public class ClasseRemoveCaracteres {
    public String RemoveCaracteres( String xCaracRemover, String xTexto )
    {
        String s_aux, retorno;
        retorno = "";
        for (int i = 0; i < xTexto.length(); i++) 
        {
           s_aux = xTexto.substring ( i, i + 1 );
           if (xCaracRemover.indexOf(s_aux) == -1) 
              retorno = retorno + s_aux;
        }      
        return retorno;
   }
}

