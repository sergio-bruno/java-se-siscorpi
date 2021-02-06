/*
 * CadastroMvItPedido.java
 *
 * Created on 7 de Setembro de 2005, 20:17
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
public class CadastroMvItPedido {
    private RepositorioMvItPedido mvitpedidos;  
    /** Creates a new instance of CadastroMvItPedido */
    public CadastroMvItPedido(RepositorioMvItPedido repositorio) {
        this.mvitpedidos = repositorio;
    }
    public void cadastrar(MvItPedido mvitpedido) throws 
    MvItPedidoNaoEncontradoException, RepositorioException {
        if (mvitpedido != null) {
            if (!mvitpedidos.existe(mvitpedido.getPedido(), mvitpedido.getProduto() )) {
                mvitpedidos.inserir(mvitpedido);
            } else {
                mvitpedidos.atualizar(mvitpedido);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
    public void remover(String pedido, String produto) throws 
    MvItPedidoNaoEncontradoException, RepositorioException {
        mvitpedidos.remover(pedido,produto);
    }
    public void atualizar(MvItPedido mvitpedido) throws
    MvItPedidoNaoEncontradoException, RepositorioException {
        mvitpedidos.atualizar(mvitpedido);
    }
    public MvItPedido procurar(String pedido, String produto) throws 
    MvItPedidoNaoEncontradoException, RepositorioException {
        return mvitpedidos.procurar(pedido,produto);
    }
    public boolean existe(String pedido, String produto) throws RepositorioException {
        return mvitpedidos.existe(pedido,produto);
    }
    public Vector listarItensPedido(String pedido) throws RepositorioException {
        return mvitpedidos.listarItensPedido(pedido);  
    }  
}
