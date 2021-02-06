/*
 * RepositorioMvPedido.java
 *
 * Created on 7 de Setembro de 2005, 16:04
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package siscorpi.mvpedido;
import java.util.Vector;
import  siscorpi.util.RepositorioException;

/**
 *
 * @author sergio
 */
public interface RepositorioMvPedido {
    public Vector listar(String sql) throws RepositorioException;
    public void inserir(MvPedido mvpedido) throws RepositorioException; 
    public void remover(String codigo) throws MvPedidoNaoEncontradoException, RepositorioException;
    public MvPedido procurar(String codigo) throws MvPedidoNaoEncontradoException, RepositorioException;
    public void atualizar(MvPedido mvpedido) throws MvPedidoNaoEncontradoException, RepositorioException;
    public boolean existe(String codigo) throws RepositorioException;
    public void atualizarSituacao(String codigo, String situacao) throws MvPedidoNaoEncontradoException, RepositorioException;
    public void atualizarTotal(String codigo, double total) throws MvPedidoNaoEncontradoException, RepositorioException;
}