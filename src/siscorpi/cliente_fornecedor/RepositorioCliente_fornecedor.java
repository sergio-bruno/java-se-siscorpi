/*
 * RepositorioCliente_fornecedor.java
 *
 * Created on 23 de Agosto de 2005, 23:19
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package siscorpi.cliente_fornecedor;
import java.util.Vector;
import siscorpi.util.RepositorioException;
/**
 *
 * @author sergio
 */
public interface RepositorioCliente_fornecedor {
        public Vector listar(String sql) throws RepositorioException;
	public void inserir(Cliente_fornecedor cliente) throws RepositorioException;
	public void remover(String codigo) throws Cliente_fornecedorNaoEncontradoException, RepositorioException;
	public Cliente_fornecedor procurar(String codigo) throws Cliente_fornecedorNaoEncontradoException, RepositorioException;
	public void atualizar(Cliente_fornecedor cliente) throws Cliente_fornecedorNaoEncontradoException, RepositorioException;
	public boolean existe(String codigo) throws RepositorioException;
}