/*
 * RepositorioProdutoBDR.java
 *
 * Created on 12 de Setembro de 2005, 01:19
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package siscorpi.produto;
import  java.sql.*;
import java.text.DecimalFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import  siscorpi.util.*;

/**
 *
 * @author sergio
 */
public class RepositorioProdutoBDR implements RepositorioProduto  {
    
    /** Creates a new instance of RepositorioProdutoBDR */
    public RepositorioProdutoBDR() {
    }
    public void inserir(Produto produto) throws RepositorioException {
        try {
            Statement statement = ConnectionManager.reservaStatement();
            ClasseTrocaCaracteres  cTrocaCaracteres  = new ClasseTrocaCaracteres();
            String wxval =  cTrocaCaracteres.TrocaCaracteres( ".", ",",
                            Double.toString(produto.getPreco_venda()));
            cTrocaCaracteres = null;
            if (produto != null) {
                try {
                    statement.executeUpdate(
                    "INSERT INTO PRODUTO (CODIGO,DESCRICAO,UNIDADE,COD_BARRAS,PRECO_VENDA) Values ('"+
                    produto.getCodigo()+"','"+produto.getDescricao()+
                    "','"+produto.getUnidade()+"','"+produto.getCod_barras()+        
                    "','"+wxval+"')");
                }
                catch (SQLException e) {
                    throw new RepositorioException(e);
    		}
            }
        } finally {
            ConnectionManager.liberaStatement();
        }
    }
    public void remover(String codigo) throws ProdutoNaoEncontradoException, 
    RepositorioException {
        try{
        Statement statement = ConnectionManager.reservaStatement();
	int resultado = statement.executeUpdate("DELETE FROM PRODUTO WHERE CODIGO='" + 
                        codigo + "'");
        if (resultado == 0) {
            throw new ProdutoNaoEncontradoException(codigo);
        } 
        } catch(SQLException e){
            throw new RepositorioException(e);
        } finally {
            ConnectionManager.liberaStatement();
        }
    }
    public Produto procurar(String codigo) throws 
    ProdutoNaoEncontradoException, RepositorioException {
        Produto produto = null;
        try {
            Statement statement = ConnectionManager.reservaStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM PRODUTO WHERE CODIGO = '" + 
                                  codigo + "'");
            if (resultset.next()) {
                produto = new Produto(resultset.getString("CODIGO"),
                resultset.getString("DESCRICAO"),resultset.getString("UNIDADE"),
                resultset.getString("COD_BARRAS"),resultset.getDouble("PRECO_VENDA"));
                resultset.close();
            } else {
                throw new ProdutoNaoEncontradoException(codigo);
            }
        } catch (SQLException e) {
            throw new RepositorioException(e);
	} finally {
            ConnectionManager.liberaStatement();
	}
	return produto;
	}
	public void atualizar(Produto produto) throws 
        ProdutoNaoEncontradoException, RepositorioException {
	    try {
    	    Statement statement = ConnectionManager.reservaStatement();
            ClasseTrocaCaracteres  cTrocaCaracteres  = new ClasseTrocaCaracteres();
            String wxval =  cTrocaCaracteres.TrocaCaracteres( ".", ",",
                            Double.toString(produto.getPreco_venda()));
            cTrocaCaracteres = null;
            if (produto != null) {
                try { 
                    int resultado = statement.executeUpdate(
                    "UPDATE PRODUTO SET "+"DESCRICAO='"+produto.getDescricao()+
                    "', UNIDADE='"+produto.getUnidade()+
                    "', COD_BARRAS='"+produto.getCod_barras()+
                    "', PRECO_VENDA='"+wxval+"' WHERE codigo = '"+produto.getCodigo()+"'");
                    if (resultado == 0) {
                        throw new ProdutoNaoEncontradoException(
                        produto.getCodigo());
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
                                      "SELECT CODIGO FROM PRODUTO WHERE CODIGO = '"+ 
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
