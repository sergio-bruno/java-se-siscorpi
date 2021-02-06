/*
 * Pedido.java
 *
 * Created on 18 de Agosto de 2005, 23:33
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package siscorpi.pedido;
import java.util.Vector;
import  siscorpi.cliente_fornecedor.*;
import  siscorpi.usuario.*;
import  siscorpi.funcionario.*;
import  siscorpi.produto.*;
import  siscorpi.mvpedido.*;
import  siscorpi.mvitpedido.*;
import  siscorpi.util.RepositorioException;
/**
 *
 * @author sergio
 */
public class Pedido {
    private CadastroCliente_fornecedor clientes;
    private CadastroUsuario usuarios;
    private CadastroFuncionario funcionarios;
    private CadastroProduto produtos;
    private CadastroMvPedido mvpedidos;
    private CadastroMvItPedido mvitpedidos;
    /** Creates a new instance of Pedido */
    public Pedido() {
        initCadastros();
    }
    private void initCadastros(){
        RepositorioCliente_fornecedor repositorioCliente_fornecedor = new RepositorioCliente_fornecedorBDR();
        clientes = new CadastroCliente_fornecedor(repositorioCliente_fornecedor);
        
        RepositorioUsuario repositorioUsuario = new RepositorioUsuarioBDR();
        usuarios = new CadastroUsuario(repositorioUsuario);
        
        RepositorioFuncionario repositorioFuncionario = new RepositorioFuncionarioBDR();
        funcionarios = new CadastroFuncionario(repositorioFuncionario);

        RepositorioProduto repositorioProduto = new RepositorioProdutoBDR();
        produtos = new CadastroProduto(repositorioProduto);

        RepositorioMvPedido repositorioMvPedido = new RepositorioMvPedidoBDR();
        mvpedidos = new CadastroMvPedido(repositorioMvPedido);

        RepositorioMvItPedido repositorioMvItPedido = new RepositorioMvItPedidoBDR();
        mvitpedidos = new CadastroMvItPedido(repositorioMvItPedido);
    }
    // CLIENTES
    public void cadastrarCliente(Cliente_fornecedor cliente) throws 
    Cliente_fornecedorNaoEncontradoException, RepositorioException {
        clientes.cadastrar(cliente);  
    }
    public Cliente_fornecedor procurarCliente(String codigo) throws 
    Cliente_fornecedorNaoEncontradoException, RepositorioException  {
        return clientes.procurar(codigo);
    }
    public void atualizarCliente(Cliente_fornecedor cliente) throws 
    Cliente_fornecedorNaoEncontradoException, RepositorioException {
        clientes.atualizar(cliente);
    }
    public boolean existeCliente(String codigo) throws RepositorioException  {
        return clientes.existe(codigo);
    }
    public void removerCliente(String codigo) throws 
    Cliente_fornecedorNaoEncontradoException, RepositorioException {
        clientes.remover(codigo);
    }
    public Vector listarCliente(String sql) throws RepositorioException  {
        return clientes.listar(sql);
    }
    // USUÁRIOS
    public void cadastrarUsuario(Usuario usuario) throws 
    UsuarioNaoEncontradoException, RepositorioException {
        usuarios.cadastrar(usuario);  
    }
    public Usuario procurarUsuario(String login) throws 
    UsuarioNaoEncontradoException, RepositorioException  {
        return usuarios.procurar(login);
    }
    public void atualizarUsuario(Usuario usuario) throws 
    UsuarioNaoEncontradoException, RepositorioException {
        usuarios.atualizar(usuario);
    }
    public boolean existeUsuario(String login) throws RepositorioException  {
        return usuarios.existe(login);
    }
    public void removerUsuario(String login) throws 
    UsuarioNaoEncontradoException, RepositorioException {
        usuarios.remover(login);
    }
    public Vector listarUsuario(String sql) throws RepositorioException  {
        return usuarios.listar(sql);
    }
    // FUNCIONÁRIOS
    public void cadastrarFuncionario(Funcionario funcionario) throws 
    FuncionarioNaoEncontradoException, RepositorioException {
        funcionarios.cadastrar(funcionario);  
    }
    public Funcionario procurarFuncionario(String codigo) throws 
    FuncionarioNaoEncontradoException, RepositorioException  {
        return funcionarios.procurar(codigo);
    }
    public void atualizarFuncionario(Funcionario funcionario) throws 
    FuncionarioNaoEncontradoException, RepositorioException {
        funcionarios.atualizar(funcionario);
    }
    public boolean existeFuncionario(String codigo) throws RepositorioException  {
        return funcionarios.existe(codigo);
    }
    public void removerFuncionario(String codigo) throws 
    FuncionarioNaoEncontradoException, RepositorioException {
        funcionarios.remover(codigo);
    }    
    public Vector listarFuncionario(String sql) throws RepositorioException  {
        return funcionarios.listar(sql);
    }
    // PRODUTOS
    public void cadastrarProduto(Produto produto) throws 
    ProdutoNaoEncontradoException, RepositorioException {
        produtos.cadastrar(produto);  
    }
    public Produto procurarProduto(String codigo) throws 
    ProdutoNaoEncontradoException, RepositorioException  {
        return produtos.procurar(codigo);
    }
    public void atualizarProduto(Produto produto) throws 
    ProdutoNaoEncontradoException, RepositorioException {
        produtos.atualizar(produto);
    }
    public boolean existeProduto(String codigo) throws RepositorioException  {
        return produtos.existe(codigo);
    }
    public void removerProduto(String codigo) throws 
    ProdutoNaoEncontradoException, RepositorioException {
        produtos.remover(codigo);
    }
    public Vector listarProduto(String sql) throws RepositorioException  {
        return produtos.listar(sql);
    }
    // MVPEDIDOS
    public void cadastrarMvPedido(MvPedido mvpedido) throws 
    MvPedidoNaoEncontradoException, RepositorioException {
        //if ( clientes.existe( mvpedido.getCliente() ) ) {  
            mvpedidos.cadastrar(mvpedido);
        //}  
    }
    public MvPedido procurarMvPedido(String codigo) throws 
    MvPedidoNaoEncontradoException, RepositorioException  {
        return mvpedidos.procurar(codigo);
    }
    public void atualizarMvPedido(MvPedido mvpedido) throws 
    MvPedidoNaoEncontradoException, RepositorioException {
        mvpedidos.atualizar(mvpedido);
    }
    public boolean existeMvPedido(String codigo) throws RepositorioException  {
        return mvpedidos.existe(codigo);
    }
    public void removerMvPedido(String codigo) throws 
    MvPedidoNaoEncontradoException, RepositorioException {
        mvpedidos.remover(codigo);
    }
    public void atualizarMvPedidoSituacao(String codigo, String situacao) throws 
    MvPedidoNaoEncontradoException, RepositorioException {
        mvpedidos.atualizarSituacao(codigo,situacao);
    }
    public void atualizarMvPedidoTotal(String codigo, double total) throws 
    MvPedidoNaoEncontradoException, RepositorioException {
        mvpedidos.atualizarTotal(codigo,total);
    }
    public Vector listarMvPedido(String sql) throws RepositorioException  {
        return mvpedidos.listar(sql);
    }
    // MVITPEDIDOS
    public void cadastrarMvItPedido(MvItPedido mvitpedido) throws 
    MvItPedidoNaoEncontradoException, RepositorioException {
        mvitpedidos.cadastrar(mvitpedido);  
    }
    public MvItPedido procurarMvItPedido(String pedido, String produto) throws 
    MvItPedidoNaoEncontradoException, RepositorioException  {
        return mvitpedidos.procurar(pedido,produto);
    }
    public void atualizarMvItPedido(MvItPedido mvitpedido) throws 
    MvItPedidoNaoEncontradoException, RepositorioException {
        mvitpedidos.atualizar(mvitpedido);
    }
    public boolean existeMvItPedido(String pedido, String produto) throws RepositorioException  {
        return mvitpedidos.existe(pedido,produto);
    }
    public void removerMvItPedido(String pedido, String produto) throws 
    MvItPedidoNaoEncontradoException, RepositorioException {
        mvitpedidos.remover(pedido,produto);
    }
    public Vector listarMvItPedido(String pedido) throws RepositorioException  {
        return mvitpedidos.listarItensPedido(pedido);
    }
}