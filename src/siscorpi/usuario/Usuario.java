/*
 * Usuario.java
 *
 * Created on 9 de Setembro de 2005, 00:43
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
public class Usuario {
    private String login;
    private String senha;
    
    /** Creates a new instance of Usuario */
    public Usuario(String login, String senha) {
        this.setLogin(login);
        this.setSenha(senha);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
