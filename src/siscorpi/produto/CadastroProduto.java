/*
 * CadastroProduto.java
 *
 * Created on 12 de Setembro de 2005, 01:09
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
public class CadastroProduto {
    private RepositorioProduto produtos;
    /** Creates a new instance of CadastroProduto */
    public CadastroProduto(RepositorioProduto repositorio) {
        this.produtos = repositorio;
    }
    public void cadastrar(Produto produto) throws 
    ProdutoNaoEncontradoException, RepositorioException {
        if (produto != null) {
            if (!produtos.existe(produto.getCodigo())) {
                produtos.inserir(produto);
            } else {
                produtos.atualizar(produto);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
    public void remover(String codigo) throws 
    ProdutoNaoEncontradoException, RepositorioException {
        produtos.remover(codigo);
    }
    public void atualizar(Produto produto) throws
    ProdutoNaoEncontradoException, RepositorioException {
        produtos.atualizar(produto);
    }
    public Produto procurar(String codigo) throws 
    ProdutoNaoEncontradoException, RepositorioException {
        return produtos.procurar(codigo);
    }
    public boolean existe(String codigo) throws RepositorioException {
        return produtos.existe(codigo);
    }
    public Vector listar(String sql) throws RepositorioException {
        return produtos.listar(sql);
    }
}
