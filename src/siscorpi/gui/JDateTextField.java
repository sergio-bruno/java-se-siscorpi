/*
 * JDateTextField.java
 *
 * Criado em 11 de Maio de 2005, 13:14
 */
package siscorpi.gui;
import javax.swing.text.*;
/**
 * A classe JDateTextField é responsável pela entrada de dados em um JTextField
 * só permirindo uma data com formato DD/MM/AAAA
 *
 * @author Desconhecido, Sérgio leite Bruno
 * @version 1.0
 */
class JDateTextField extends PlainDocument{
  public void insertString(int offs, String str, AttributeSet a) 
                           throws BadLocationException{
    char digito;
    boolean numerico = true;
    if((getLength() + str.length()) <= 10){
      for(int i = 0; i < str.length(); i++){
        digito = str.charAt(i);
      
        if(!Character.isDigit(digito)){
      	  numerico = false;
      	  break; 
        }
      }
      if(numerico)
      { 
        int tam = getLength() + str.length();
        if(tam == 2) 
          super.insertString(offs, str + "/", a);
	else if(tam == 5) 
	  super.insertString(offs, str + "/", a);
        else
          super.insertString(offs, str, a);
      }
    }
  } 
}