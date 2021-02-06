/*
 * JCalc.java
 *
 * Criado em 11 de Maio de 2005, 13:14
 */
package siscorpi.gui;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * A classe JCalc é uma calculadora
 *
 * @author Java Magazine, Sérgio leite Bruno
 * @version 1.0
 */
class JCalc extends JFrame
{
    // atributos da calculadora
    
    private double n1, n2;
    private String op;
    private int estado = N1;
    
    Properties props;

    // A calculadora é uma máquina de estados    
    private static final int N1  = 1;
	
    private static final int OP1 = 2;
    private static final int N2  = 3;
    private static final int OP2 = 4;
    
    // Os poucos componente que necessitam ser manipulados depois de instanciados
    
    private JLabel display;
    
    // Construção da janela da calculadora
    public JCalc ()
    {
        setTitle ("Calculadora");
        setContentPane (constroiCalculadora ());
        //setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); // evitar que feche o aplicativo só fecha o form jcalc
        setVisible(true);
        setLocationRelativeTo(null);
        pack();
        display.setText("0");
    }
    /** 
     * Retorna parametros da calculadora 
     *
     * @return margem do tipo JComponent
     */
    private JComponent constroiCalculadora ()
    {
      JPanel margem = new JPanel ();
	margem.setBorder (BorderFactory.createEmptyBorder(2, 2, 2, 2));
	margem.setLayout (new BorderLayout (4, 4));
	margem.add (constroiDisplay (), BorderLayout.NORTH);
	margem.add (constroiBotoes (), BorderLayout.CENTER);
	return margem;
    }
    /** 
     * Retorna parametros do display 
     *
     * @return diplay do tipo JComponent
     */
    private JComponent constroiDisplay ()
    {
	display = new JLabel ("000000000000");
	display.setFont(new Font ("Sans Serif", Font.BOLD, 18));
        display.setBorder(BorderFactory.createLoweredBevelBorder());
	display.setHorizontalAlignment (JLabel.RIGHT);
	display.setBackground(Color.WHITE);
	return display;
    }
    /** Constroi os botões */
    private JComponent constroiBotoes ()
    {
	JPanel botoes = new JPanel ();
	JButton botao;
	botoes.setLayout (new GridLayout (5, 4));
	botoes.add (criaBotaoEdicao ("C"));
	botoes.add (criaBotaoEdicao ("CE"));
	botoes.add (criaBotaoEdicao ("BS"));
	botoes.add (criaBotaoOperacao ("%"));
	botoes.add (criaBotaoDigito ("7"));
	botoes.add (criaBotaoDigito ("8"));
	botoes.add (criaBotaoDigito ("9"));
	botoes.add (criaBotaoOperacao ("+"));
	botoes.add (criaBotaoDigito ("4"));
	botoes.add (criaBotaoDigito ("5"));
	botoes.add (criaBotaoDigito ("6"));
	botoes.add (criaBotaoOperacao ("-"));
	botoes.add (criaBotaoDigito ("1"));
	botoes.add (criaBotaoDigito ("2"));
	botoes.add (criaBotaoDigito ("3"));
	botoes.add (criaBotaoOperacao ("x"));
	botoes.add (criaBotaoDigito ("."));
	botoes.add (criaBotaoDigito ("0"));
	botoes.add (criaBotaoOperacao ("="));
	botoes.add (criaBotaoOperacao ("/"));
	return botoes;
    }
    /** 
     * Cria botão de edição
     *
     * @return botao do tipo JButton
     */
    private JButton criaBotaoEdicao (String text)
    {
	JButton botao = new JButton (text);
	botao.addActionListener (edicaoActionListener);
	return botao;
    }
    /** 
     * Cria botão de digito
     *
     * @return botao do tipo JButton
     */
    private JButton criaBotaoDigito (String text)
    {
	JButton botao = new JButton (text);
	botao.addActionListener (digitoActionListener);
	return botao;
    }
    /** 
     * Cria botão de operação
     *
     * @return botao do tipo JButton
     */
    private JButton criaBotaoOperacao (String text)
    {
	JButton botao = new JButton (text);
	botao.addActionListener (operacaoActionListener);
	return botao;
    }
    
    // Tratamento de eventos
    
    private ActionListener edicaoActionListener = new ActionListener () {
	public void actionPerformed (ActionEvent e)
	{
	    JButton botao = (JButton)e.getSource ();
	    String label = botao.getText ();
	    if (label.equals ("C")) {
		display.setText ("0");
		if (estado == N2)
		    estado = OP2;
	    }	    
	    else if (label.equals ("CE")) {
		display.setText ("0");
		estado = N1;
	    }
	    else if (label.equals ("BS")) {
		String texto = display.getText ();
		if (texto.length () > 1)
		    display.setText (texto.substring (0, texto.length () - 1));
		else
		    display.setText ("0");
	    }
	}
    };
    
    private ActionListener digitoActionListener = new ActionListener () {
	public void actionPerformed (ActionEvent e)
	{
	    JButton botao = (JButton)e.getSource ();
	    String label = botao.getText ();
	    if (display.getText ().equals ("0"))
		display.setText ("");
	    if (estado == OP1) {
		display.setText ("");
		estado = N1;
	    }
	    else if (estado == OP2) {
		display.setText ("0");
		estado = N2;
	    }
	    if (display.getText ().equals ("0"))
		display.setText (label);
	    else
		display.setText (display.getText () + label);
	}
    };
    
    private ActionListener operacaoActionListener = new ActionListener () {
	public void actionPerformed (ActionEvent e)
	{
	    JButton botao = (JButton)e.getSource ();
	    String label = botao.getText ();
	    if (estado == N1) {
		n1 = Double.parseDouble (display.getText ());
		n2 = 0;
		op = label;
		estado = OP2;
	    }
	    else if (estado == N2) {
		n2 = Double.parseDouble (display.getText ());
		if (op.equals ("%"))
		    n1 = (n2 * n1) / 100;
		else if (op.equals ("+"))
		    n1 = n1 + n2;
		else if (op.equals ("-"))
		    n1 = n1 - n2;
		else if (op.equals ("x"))
		    n1 = n1 * n2;
		else if (op.equals ("/"))
		    n1 = n1 / n2;
		op = label;
		display.setText ("" + n1);
		if (label.equals ("="))
		    estado = OP1;
		else
		    estado = OP2;
	    }
	}
    };
    // Para que seja possível executar a calculadora
    public static void main (String[] args)
    {
        //SwingWTUtils.setShowSwingWTInfoOnStartup(false);
	JCalc jcalc = new JCalc ();
	jcalc.setVisible (true);
    }
}

