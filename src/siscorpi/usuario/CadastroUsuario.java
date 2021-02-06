/*
 * CadastroUsuario.java
 *
 * Created on 9 de Setembro de 2005, 00:36
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package siscorpi.usuario;
import java.util.Vector;
import  siscorpi.util.RepositorioException;
/**
 *
 * @author sergio
 */
public class CadastroUsuario {
    private RepositorioUsuario usuarios;
    public CadastroUsuario (RepositorioUsuario repositorio) {
        this.usuarios = repositorio;
    }
    public void cadastrar(Usuario usuario) throws 
    UsuarioNaoEncontradoException, RepositorioException {
        if (usuario != null) {
            if (!usuarios.existe(usuario.getLogin())) {
                usuarios.inserir(usuario);
            } else {
                usuarios.atualizar(usuario);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
    public void remover(String login) throws 
    UsuarioNaoEncontradoException, RepositorioException {
        usuarios.remover(login);
    }
    public void atualizar(Usuario usuario) throws
    UsuarioNaoEncontradoException, RepositorioException {
        usuarios.atualizar(usuario);
    }
    public Usuario procurar(String login) throws 
    UsuarioNaoEncontradoException, RepositorioException {
        return usuarios.procurar(login);
    }
    public boolean existe(String login) throws RepositorioException {
        return usuarios.existe(login);
    }
    public Vector listar(String sql) throws RepositorioException {
        return usuarios.listar(sql);
    }
}