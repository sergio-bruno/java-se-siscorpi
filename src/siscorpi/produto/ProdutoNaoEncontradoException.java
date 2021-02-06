/*
 * ProdutoNaoEncontradoException.java
 *
 * Created on 12 de Setembro de 2005, 01:16
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package siscorpi.produto;

/**
 *
 * @author sergio
 */
public class ProdutoNaoEncontradoException extends Exception {
    private String codigo;
    /** Creates a new instance of ProdutoNaoEncontradoException */
    public ProdutoNaoEncontradoException(String codigo) {
        super ("Produto não encontrado!");
        this.codigo = codigo;
    }
    public String getcodigo(){
        return codigo;
    }
}

