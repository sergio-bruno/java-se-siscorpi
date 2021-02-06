/*
 * CadastroCliente_fornecedor.java
 *
 * Created on 24 de Agosto de 2005, 00:02
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package siscorpi.cliente_fornecedor;
import java.util.Vector;
import  siscorpi.util.RepositorioException;
/**
 *
 * @author sergio
 */
public class CadastroCliente_fornecedor {
    private RepositorioCliente_fornecedor clientes;
    public CadastroCliente_fornecedor(RepositorioCliente_fornecedor repositorio) {
        this.clientes = repositorio;
    }
    public void cadastrar(Cliente_fornecedor cliente) throws 
    Cliente_fornecedorNaoEncontradoException, RepositorioException {
        if (cliente != null) {
            if (!clientes.existe(cliente.getCodigo())) {
                clientes.inserir(cliente);
            } else {
                clientes.atualizar(cliente);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
    public void remover(String codigo) throws 
    Cliente_fornecedorNaoEncontradoException, RepositorioException {
        clientes.remover(codigo);
    }
    public void atualizar(Cliente_fornecedor cliente) throws
    Cliente_fornecedorNaoEncontradoException, RepositorioException {
        clientes.atualizar(cliente);
    }
    public Cliente_fornecedor procurar(String codigo) throws 
    Cliente_fornecedorNaoEncontradoException, RepositorioException {
        return clientes.procurar(codigo);
    }
    public boolean existe(String codigo) throws RepositorioException {
        return clientes.existe(codigo);
    }
    public Vector listar(String sql) throws RepositorioException {    
        return clientes.listar(sql);
    }
}