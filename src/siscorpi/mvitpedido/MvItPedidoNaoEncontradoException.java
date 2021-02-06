/*
 * MvItPedidoNaoEncontradoException.java
 *
 * Created on 7 de Setembro de 2005, 20:13
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package siscorpi.mvitpedido;

/**
 *
 * @author sergio
 */
public class MvItPedidoNaoEncontradoException extends Exception {
    private String pedido;
    private String produto;
    /** Creates a new instance of ProdutoNaoEncontradoException */
    public MvItPedidoNaoEncontradoException(String pedido, String produto) {
        super ("Pedido de vendas não encontrado !");
        this.pedido = pedido;
        this.produto = produto;
    }
    public String getPedido(){
        return pedido;
    }
    public String getProduto(){
        return produto;
    }
}
