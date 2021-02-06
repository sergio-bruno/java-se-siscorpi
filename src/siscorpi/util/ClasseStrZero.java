/*
 * ClasseStrZero.java
 *
 * Criado em 15 de Maio de 2005, 18:49
 */
package siscorpi.util;
/**
 * A classe ClasseStrZero preenche com zeros a esquerda o argumento recebido 
 * com o tamanho de retorno também recebido como parametro
 *
 * @author Sérgio Leite Bruno
 * @version 1.0
 */
public class ClasseStrZero {
    public String strzero( String wvalini, int qtdzeros )
    {
        String result = "";
        int tamstring, wfaltaCompletarString;

        tamstring = wvalini.length();
        wfaltaCompletarString =  qtdzeros - tamstring;

        if ( tamstring < qtdzeros )
        {
            for ( int z = 1 ; z <= wfaltaCompletarString ; z++ )
                result += "0";

            result += wvalini;
        }
        else result = wvalini;
        return result;
    }
}
