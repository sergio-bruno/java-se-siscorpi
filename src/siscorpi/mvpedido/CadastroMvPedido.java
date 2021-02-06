/*
 * CadastroMvPedido.java
 *
 * Created on 7 de Setembro de 2005, 15:53
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package siscorpi.mvpedido;
import java.util.Vector;
import  siscorpi.util.RepositorioException;
/**
 *
 * @author sergio
 */
public class CadastroMvPedido {
    private RepositorioMvPedido mvpedidos;  
    /** Creates a new instance of CadastroMvPedido */
    public CadastroMvPedido(RepositorioMvPedido repositorio) {
        this.mvpedidos = repositorio;
    }
    public void cadastrar(MvPedido mvpedido) throws 
    MvPedidoNaoEncontradoException, RepositorioException {
        if (mvpedido != null) {
            if (!mvpedidos.existe(mvpedido.getCodigo())) {
                mvpedidos.inserir(mvpedido);
            } else {
                mvpedidos.atualizar(mvpedido);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
    public void remover(String codigo) throws 
    MvPedidoNaoEncontradoException, RepositorioException {
        mvpedidos.remover(codigo);
    }
    public void atualizar(MvPedido mvpedido) throws
    MvPedidoNaoEncontradoException, RepositorioException {
        mvpedidos.atualizar(mvpedido);
    }
    public MvPedido procurar(String codigo) throws 
    MvPedidoNaoEncontradoException, RepositorioException {
        return mvpedidos.procurar(codigo);
    }
    public boolean existe(String codigo) throws RepositorioException {
        return mvpedidos.existe(codigo);
    }
    public void atualizarSituacao(String codigo, String situacao) throws
    MvPedidoNaoEncontradoException, RepositorioException {
        mvpedidos.atualizarSituacao(codigo,situacao); 
    }
    public void atualizarTotal(String codigo, double total) throws
    MvPedidoNaoEncontradoException, RepositorioException {
        mvpedidos.atualizarTotal(codigo,total); 
    }
    public Vector listar(String sql) throws RepositorioException {
        return mvpedidos.listar(sql); 
    } 
}
