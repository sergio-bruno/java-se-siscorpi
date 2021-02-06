/*
 * Cliente_fornecedorNaoEncontradoException.java
 *
 * Created on 23 de Agosto de 2005, 23:14
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package siscorpi.cliente_fornecedor;
/**
 *
 * @author sergio
 */
public class Cliente_fornecedorNaoEncontradoException extends Exception {
    private String codigo;
    public Cliente_fornecedorNaoEncontradoException(String codigo){
        super ("Cliente não encontrado!");
        this.codigo = codigo;
    }
    public String getCodigo(){
        return codigo;
    }
}
