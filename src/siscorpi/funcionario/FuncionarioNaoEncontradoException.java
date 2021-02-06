/*
 * FuncionarioNaoEncontradoException.java
 *
 * Created on 11 de Setembro de 2005, 00:50
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package siscorpi.funcionario;

/**
 *
 * @author sergio
 */
public class FuncionarioNaoEncontradoException extends Exception {
    private String codigo;
    /** Creates a new instance of UsuarioNaoEncontradoException */
    public FuncionarioNaoEncontradoException(String codigo) {
        super ("Funcionário não encontrado!");
        this.codigo = codigo;
    }
    public String getcodigo(){
        return codigo;
    }
}

