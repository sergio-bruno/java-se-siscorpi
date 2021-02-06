/*
 * RepositorioUsuario.java
 *
 * Created on 9 de Setembro de 2005, 00:53
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package siscorpi.usuario;
import java.util.Vector;
import siscorpi.util.RepositorioException;
/**
 *
 * @author sergio
 */
public interface RepositorioUsuario {
    public Vector listar(String sql) throws RepositorioException;
    public void inserir(Usuario usuario) throws RepositorioException;
    public void remover(String login) throws UsuarioNaoEncontradoException, RepositorioException;
    public Usuario procurar(String login) throws UsuarioNaoEncontradoException, RepositorioException;
    public void atualizar(Usuario usuario) throws UsuarioNaoEncontradoException, RepositorioException;
    public boolean existe(String login) throws RepositorioException;
}
