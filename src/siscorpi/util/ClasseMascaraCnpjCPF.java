/*
 * ClasseMascaraCnpjCPF.java
 *
 * Criado em 10 de Maio de 2005, 17:06
 */
package siscorpi.util;
import javax.swing.*;
/**
 * A classe ClasseMascaraCnpjCPF é responsável pela formatação do parametro
 * recebido, podendo formatálo como CPF ou CNPJ de acordo com o tamanho do
 * parametro 11 e 14 respectivamente
 *
 * @author Sérgio Leite Bruno
 * @version 1.0
 */
public class ClasseMascaraCnpjCPF {
    private String wParte;
    public String MascaraCnpjCPF( String xCGC_CPF )
    {
          try
          {
            if ( xCGC_CPF.length() == 14 )
                 wParte = xCGC_CPF.substring (0, 2) + "." +
                          xCGC_CPF.substring (2, 5) + "." + 
                          xCGC_CPF.substring (5, 8) + "/" +
                          xCGC_CPF.substring (8,12) + "-" +
                          xCGC_CPF.substring (12);
            else wParte = xCGC_CPF.substring (0, 3) + "." +
                          xCGC_CPF.substring (3, 6) + "." + 
                          xCGC_CPF.substring (6, 9) + "-" +
                          xCGC_CPF.substring (9);
            return wParte;    
          }
          catch (Exception e) { return ""; }
    }
}

