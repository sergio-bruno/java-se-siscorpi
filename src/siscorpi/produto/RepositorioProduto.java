/*
 * RepositorioProduto.java
 *
 * Created on 12 de Setembro de 2005, 01:17
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package siscorpi.produto;
import java.util.Vector;
import  siscorpi.util.RepositorioException;
/**
 *
 * @author sergio
 */
public interface RepositorioProduto {
    public Vector listar(String sql) throws RepositorioException;
    public void inserir(Produto produto) throws RepositorioException;
    public void remover(String codigo) throws ProdutoNaoEncontradoException, RepositorioException;
    public Produto procurar(String codigo) throws ProdutoNaoEncontradoException, RepositorioException;
    public void atualizar(Produto produto) throws ProdutoNaoEncontradoException, RepositorioException;
    public boolean existe(String codigo) throws RepositorioException;
}
