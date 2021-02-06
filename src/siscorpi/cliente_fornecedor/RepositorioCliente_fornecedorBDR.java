/*
 * RepositorioCliente_fornecedorBDR.java
 *
 * Created on 23 de Agosto de 2005, 23:28
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package siscorpi.cliente_fornecedor;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.JOptionPane;
import siscorpi.util.*;
/**
 * 
 * @author sergio
 */
public class RepositorioCliente_fornecedorBDR implements RepositorioCliente_fornecedor {
    public RepositorioCliente_fornecedorBDR() {
    }
    public void inserir(Cliente_fornecedor cliente) throws RepositorioException {
        try {
            Statement statement = ConnectionManager.reservaStatement();
            if (cliente != null) {
                try {
                    statement.executeUpdate(
                    "INSERT INTO CLIENTES (CODIGO,RAZAO_SOCIAL,FANTASIA,CNPJ_CPF," +
                    "IE,ENDERECO,BAIRRO,CIDADE,ESTADO,CEP,NUMERO,FONE,FAX," +
                    "CELULAR,EMAIL,TIPO) Values ('"+cliente.getCodigo()+"','"+
                    cliente.getRazao_social()+"','"+cliente.getFantasia()+"','"+
                    cliente.getCnpj_cpf()+"','"+cliente.getIe()+"','"+
                    cliente.getEndereco()+"','"+cliente.getBairro()+"','"+
                    cliente.getCidade()+"','"+cliente.getEstado()+"','"+
                    cliente.getCep()+"','"+cliente.getNumero()+"','"+
                    cliente.getFone()+"','"+cliente.getFax()+"','"+
                    cliente.getCelular()+"','"+cliente.getEmail()+"',"+
                    cliente.getTipo()+")");
                }
                catch (SQLException e) {
                    throw new RepositorioException(e);
    		}
            }
        } finally {
            ConnectionManager.liberaStatement();
        }
    }
    public void remover(String codigo) throws Cliente_fornecedorNaoEncontradoException, 
    RepositorioException {
        try{
        Statement statement = ConnectionManager.reservaStatement();
	int resultado = statement.executeUpdate("DELETE FROM CLIENTES WHERE CODIGO='" + 
                        codigo + "'");
        if (resultado == 0) {
            throw new Cliente_fornecedorNaoEncontradoException(codigo);
        } 
        } catch(SQLException e){
            throw new RepositorioException(e);
        } finally {
            ConnectionManager.liberaStatement();
        }
    }
    public Cliente_fornecedor procurar(String codigo) throws 
    Cliente_fornecedorNaoEncontradoException, RepositorioException {
        Cliente_fornecedor cliente = null;
        try {
            Statement statement = ConnectionManager.reservaStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM CLIENTES WHERE CODIGO = '" + 
                                  codigo + "'");
            if (resultset.next()) {
                cliente = new Cliente_fornecedor(resultset.getString("CODIGO"),
                resultset.getString("RAZAO_SOCIAL"),resultset.getString("FANTASIA"),
                resultset.getString("CNPJ_CPF"),resultset.getString("IE"), 
                resultset.getString("ENDERECO"),resultset.getString("BAIRRO"), 
                resultset.getString("CIDADE"),resultset.getString("ESTADO"), 
                resultset.getString("CEP"),resultset.getString("NUMERO"), 
                resultset.getString("FONE"),resultset.getString("FAX"), 
                resultset.getString("CELULAR"),resultset.getString("EMAIL"), 
                resultset.getInt("TIPO"));
                resultset.close();
            } else {
                throw new Cliente_fornecedorNaoEncontradoException(codigo);
            }
        } catch (SQLException e) {
            throw new RepositorioException(e);
	} finally {
            ConnectionManager.liberaStatement();
	}
	return cliente;
	}
	public void atualizar(Cliente_fornecedor cliente) throws 
        Cliente_fornecedorNaoEncontradoException, RepositorioException {
	    try {
    	    Statement statement = ConnectionManager.reservaStatement();
            if (cliente != null) {
                try {
                    int resultado = statement.executeUpdate(
                    "UPDATE CLIENTES SET "+"CODIGO='"+cliente.getCodigo()+"',"+
                    "RAZAO_SOCIAL='"+cliente.getRazao_social()+"',"+"FANTASIA='"+
                    cliente.getFantasia()+"',"+"CNPJ_CPF='"+cliente.getCnpj_cpf()+"',"+
                    "IE='"+cliente.getIe()+"',"+"ENDERECO='"+
                    cliente.getEndereco()+"',"+"BAIRRO='"+cliente.getBairro()+"',"+
                    "CIDADE='"+cliente.getCidade()+"',"+"ESTADO='"+
                    cliente.getEstado()+"',"+"CEP='"+cliente.getCep()+"',"+
                    "NUMERO='"+cliente.getNumero()+"',"+"FONE='"+
                    cliente.getFone()+"',"+"FAX='"+cliente.getFax()+"',"+
                    "CELULAR='"+cliente.getCelular()+"',"+"EMAIL='"+
                    cliente.getEmail()+"',"+"TIPO='"+cliente.getTipo()+
                    "' WHERE codigo = '"+cliente.getCodigo()+"'");
                    if (resultado == 0) {
                        throw new Cliente_fornecedorNaoEncontradoException(cliente.getCodigo());
                    } 
                }
                catch (SQLException e) {
    			    throw new RepositorioException(e);
    		}
            }
        } finally {
            ConnectionManager.liberaStatement();
          }
	}
	public boolean existe(String codigo) throws RepositorioException {
   	    boolean resposta = false;
            try {
                Statement statement = ConnectionManager.reservaStatement();
                ResultSet resultset = statement.executeQuery(
                                      "SELECT CODIGO FROM CLIENTES WHERE CODIGO = '"+ 
                                      codigo + "'");
                resposta = resultset.next();
                resultset.close();
            } catch (SQLException e) {
                throw new RepositorioException(e);
            } finally {
                ConnectionManager.liberaStatement();
            }
            return resposta;
    }
    public Vector listar(String sql) throws RepositorioException {
        Vector linhas = new Vector();
        try {
            Statement statement = ConnectionManager.reservaStatement();
            ResultSet resultset = statement.executeQuery(sql);
            ResultSetMetaData rsmd = resultset.getMetaData();
            boolean moreRecords = resultset.next();  
            if (  moreRecords ) {
                ClasseRecebeLinhaGrafico cRecebeLinhaGrafico = new ClasseRecebeLinhaGrafico();
                do { linhas.addElement( cRecebeLinhaGrafico.RecebeLinhaGrafico( resultset, rsmd ) ); } while ( resultset.next() );  
                resultset.close();
                cRecebeLinhaGrafico = null;
            }
        } catch (SQLException e) {
            throw new RepositorioException(e);
        } finally {
            ConnectionManager.liberaStatement();
        }
        return linhas;
    }
}