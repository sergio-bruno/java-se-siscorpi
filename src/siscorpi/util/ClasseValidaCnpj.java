/*
 * ClasseValidaCnpj.java
 *
 * Criado em 10 de Maio de 2005, 17:06
 */
package siscorpi.util;
/**
 * A classe ClasseValidaCnpj é responsável pela verificação do CNPJ passado a 
 * aplicação
 *
 * @author Sérgio Leite Bruno
 * @version 1.0
 */
public class ClasseValidaCnpj {
    public boolean ValidaCnpj( String xCGC )
    {
        if ( xCGC.equals("") )   
           return true; 
        else if ( xCGC.length() != 14 )
           return false;    
        else
        try
          {
 
                int d1,d4,xx,nCount,fator,resto,digito1,digito2;
                String Check, s_aux;
                String Separadores = "/-.";
                d1 = 0;
                d4 = 0;
                xx = 0;
                for (nCount = 0; nCount < xCGC.length()-2; nCount++) 
                {
                      s_aux = xCGC.substring (nCount, nCount+1);
                      if (Separadores.indexOf(s_aux) == -1) 
                      {
                            if (xx < 4) 
                               fator = 5 - xx; 
                            else fator = 13 - xx;
                            d1 = d1 + Integer.valueOf (s_aux).intValue() * fator;
                            if (xx < 5)
                               fator = 6 - xx;
                            else fator = 14 - xx;
                            d4 += Integer.valueOf (s_aux).intValue() * fator;
                            xx++;
                      };
                }
                resto = (d1 % 11);
                if (resto < 2)
                   digito1 = 0;
                else digito1 = 11 - resto;
                d4 = d4 + 2 * digito1;
                resto = (d4 % 11);
                if (resto < 2)
                   digito2 = 0;
                else digito2 = 11 - resto;
                Check = String.valueOf(digito1) + String.valueOf(digito2);
                //System.out.println (Check);
                //System.out.println (xCGC.substring(xCGC.length()-2, xCGC.length() ));
    
                if (Check.compareTo(xCGC.substring(xCGC.length()-2, xCGC.length() )) !=0)
                   return false;
                return true;
         }
         catch (Exception e) { return false; }
    }
}

