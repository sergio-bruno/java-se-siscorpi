/*
 * RepositorioFuncionario.java
 *
 * Created on 11 de Setembro de 2005, 00:51
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
public interface RepositorioFuncionario  {
    public Vector listar(String sql) throws RepositorioException;
    public void inserir(Funcionario funcionario) throws RepositorioException;
    public void remover(String codigo) throws FuncionarioNaoEncontradoException, RepositorioException;
    public Funcionario procurar(String codigo) throws FuncionarioNaoEncontradoException, RepositorioException;
    public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException, RepositorioException;
    public boolean existe(String codigo) throws RepositorioException;
}
