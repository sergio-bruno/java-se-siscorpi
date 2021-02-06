/*
 * RepositorioMvItPedido.java
 *
 * Created on 7 de Setembro de 2005, 20:15
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package siscorpi.mvitpedido;
import  java.util.Vector;
import  siscorpi.util.RepositorioException;
/**
 *
 * @author sergio
 */
public interface RepositorioMvItPedido {
    public Vector listarItensPedido(String pedido) throws RepositorioException;
    public void inserir(MvItPedido mvitpedido) throws RepositorioException; 
    public void remover(String pedido, String produto) throws MvItPedidoNaoEncontradoException, RepositorioException;
    public MvItPedido procurar(String pedido, String produto) throws MvItPedidoNaoEncontradoException, RepositorioException;
    public void atualizar(MvItPedido mvitpedido) throws MvItPedidoNaoEncontradoException, RepositorioException;
    public boolean existe(String pedido, String produto) throws RepositorioException;
}
