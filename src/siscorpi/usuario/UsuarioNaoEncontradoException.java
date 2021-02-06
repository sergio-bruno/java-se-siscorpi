/*
 * UsuarioNaoEncontradoException.java
 *
 * Created on 9 de Setembro de 2005, 00:47
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package siscorpi.usuario;

/**
 *
 * @author sergio
 */
public class UsuarioNaoEncontradoException extends Exception {
    private String login;
    /** Creates a new instance of UsuarioNaoEncontradoException */
    public UsuarioNaoEncontradoException(String login) {
        super ("usuário não encontrado!");
        this.login = login;
    }
    public String getLogin(){
        return login;
    }
}
