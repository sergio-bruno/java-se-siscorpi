/*
 * MvPedidoNaoEncontradoException.java
 *
 * Created on 7 de Setembro de 2005, 15:57
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package siscorpi.mvpedido;
/**
 *
 * @author sergio
 */
public class MvPedidoNaoEncontradoException extends Exception {
    private String codigo;
    /** Creates a new instance of ProdutoNaoEncontradoException */
    public MvPedidoNaoEncontradoException(String codigo) {
        super ("Pedido de vendas não encontrado !");
        this.codigo = codigo;
    }
    public String getcodigo(){
        return codigo;
    }
}

