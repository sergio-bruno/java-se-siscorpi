/*
 * CadastroFuncionario.java
 *
 * Created on 11 de Setembro de 2005, 00:44
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package siscorpi.funcionario;
import java.util.Vector;
import  siscorpi.util.RepositorioException;
/**
 *
 * @author sergio
 */
public class CadastroFuncionario {
    private RepositorioFuncionario funcionarios;
    /** Creates a new instance of CadastroFuncionario */
    public CadastroFuncionario(RepositorioFuncionario repositorio) {
        this.funcionarios = repositorio;
    }
    public void cadastrar(Funcionario funcionario) throws 
    FuncionarioNaoEncontradoException, RepositorioException {
        if (funcionario != null) {
            if (!funcionarios.existe(funcionario.getCodigo())) {
                funcionarios.inserir(funcionario);
            } else {
                funcionarios.atualizar(funcionario);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
    public void remover(String codigo) throws 
    FuncionarioNaoEncontradoException, RepositorioException {
        funcionarios.remover(codigo);
    }
    public void atualizar(Funcionario funcionario) throws
    FuncionarioNaoEncontradoException, RepositorioException {
        funcionarios.atualizar(funcionario);
    }
    public Funcionario procurar(String codigo) throws 
    FuncionarioNaoEncontradoException, RepositorioException {
        return funcionarios.procurar(codigo);
    }
    public boolean existe(String codigo) throws RepositorioException {
        return funcionarios.existe(codigo);
    }
    public Vector listar(String sql) throws RepositorioException {
        return funcionarios.listar(sql);
    }
}
