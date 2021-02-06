/*
 * RepositorioMvPedidoBDR.java
 *
 * Created on 7 de Setembro de 2005, 16:06
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package siscorpi.mvpedido;
import  java.sql.*;
import java.text.DecimalFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import  siscorpi.util.*;
/**
 *
 * @author sergio
 */
public class RepositorioMvPedidoBDR implements RepositorioMvPedido  {
    /** Creates a new instance of RepositorioMvPedidoBDR */
    public RepositorioMvPedidoBDR() {
    }
    public void inserir(MvPedido mvpedido) throws RepositorioException {
        try {
            Statement statement = ConnectionManager.reservaStatement();
            ClasseTrocaCaracteres  cTrocaCaracteres  = new ClasseTrocaCaracteres();
            String wxval =  cTrocaCaracteres.TrocaCaracteres( ".", ",",
                            Double.toString(mvpedido.getTotal()));
            cTrocaCaracteres = null;
            if (mvpedido != null) {
                try {
                    statement.executeUpdate(
                    "INSERT INTO PDVENDAS (CODIGO,DATA,HORA,CLIENTE,FUNCIONARIO,PRAZO_PAGAMENTO,SITUACAO,TOTAL) Values ('"+
                    mvpedido.getCodigo()+"','"+mvpedido.getData()+
                    "','"+mvpedido.getHora()+"','"+mvpedido.getCliente()+ 
                    "','"+mvpedido.getFuncionario()+"','"+mvpedido.getPrazo_pagamento()+ 
                    "','"+mvpedido.getSituacao()+"','"+wxval+"')");
                }
                catch (SQLException e) {
                    throw new RepositorioException(e);
    		}
            }
        } finally {
            ConnectionManager.liberaStatement();
        }
    }
    public void remover(String codigo) throws MvPedidoNaoEncontradoException, 
    RepositorioException {
        try{
        Statement statement = ConnectionManager.reservaStatement();
	int resultado = statement.executeUpdate("DELETE FROM PDVENDAS WHERE CODIGO='" + 
                        codigo + "'");
        if (resultado == 0) {
            throw new MvPedidoNaoEncontradoException(codigo);
        } else { this.removeRelacionamento(statement,codigo); }
        } catch(SQLException e){
            throw new RepositorioException(e);
        } finally {
            ConnectionManager.liberaStatement();
        }
    }
    public MvPedido procurar(String codigo) throws 
    MvPedidoNaoEncontradoException, RepositorioException {
        MvPedido mvpedido = null;
        try {
            Statement statement = ConnectionManager.reservaStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM PDVENDAS WHERE CODIGO = '" + 
                                  codigo + "'");
            if (resultset.next()) {
                mvpedido = new MvPedido(resultset.getString("CODIGO"),
                resultset.getString("DATA"),resultset.getString("HORA"),
                resultset.getString("CLIENTE"),resultset.getString("FUNCIONARIO"),
                resultset.getInt("PRAZO_PAGAMENTO"),resultset.getString("SITUACAO"),
                resultset.getDouble("TOTAL"));
                resultset.close();
            } else {
                throw new MvPedidoNaoEncontradoException(codigo);
            }
        } catch (SQLException e) {
            throw new RepositorioException(e);
	} finally {
            ConnectionManager.liberaStatement();
	}
	return mvpedido;
	}
    public void atualizar(MvPedido mvpedido) throws 
    MvPedidoNaoEncontradoException, RepositorioException {
        try {
    	    Statement statement = ConnectionManager.reservaStatement();
            ClasseTrocaCaracteres  cTrocaCaracteres  = new ClasseTrocaCaracteres();
            String wxval =  cTrocaCaracteres.TrocaCaracteres( ".", ",",
                            Double.toString(mvpedido.getTotal()));
            cTrocaCaracteres = null;
            if (mvpedido != null) {
                try { 
                    int resultado = statement.executeUpdate(
                    "UPDATE PDVENDAS SET "+"DATA='"+mvpedido.getData()+
                    "', HORA='"+mvpedido.getHora()+
                    "', CLIENTE='"+mvpedido.getCliente()+
                    "', FUNCIONARIO='"+mvpedido.getFuncionario()+
                    "', PRAZO_PAGAMENTO='"+mvpedido.getPrazo_pagamento()+
                    "', SITUACAO='"+mvpedido.getSituacao()+
                    "', TOTAL='"+wxval+"' WHERE codigo = '"+mvpedido.getCodigo()+"'");
                    if (resultado == 0) {
                        throw new MvPedidoNaoEncontradoException(
                        mvpedido.getCodigo());
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
                                  "SELECT CODIGO FROM PDVENDAS WHERE CODIGO = '"+ 
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
    public void atualizarSituacao(String codigo, String situacao) throws 
    MvPedidoNaoEncontradoException, RepositorioException {
        try {
            Statement statement = ConnectionManager.reservaStatement();
            try { 
                int resultado = statement.executeUpdate(
                "UPDATE PDVENDAS SET SITUACAO='"+situacao+"' WHERE codigo = '"
                +codigo+"'");
                if (resultado == 0) {
                    throw new MvPedidoNaoEncontradoException(codigo);
                } 
            }
            catch (SQLException e) {
    		throw new RepositorioException(e);
            }
        } finally {
            ConnectionManager.liberaStatement();
        }
    }
    public void atualizarTotal(String codigo, double total) throws 
    MvPedidoNaoEncontradoException, RepositorioException {
        try {
            ClasseTrocaCaracteres  cTrocaCaracteres  = new ClasseTrocaCaracteres();
            String wxval =  cTrocaCaracteres.TrocaCaracteres( ".", ",",Double.toString(total) );
            cTrocaCaracteres = null;
            Statement statement = ConnectionManager.reservaStatement();
            try { 
                int resultado = statement.executeUpdate(
                "UPDATE PDVENDAS SET TOTAL='"+wxval+"' WHERE codigo = '"
                +codigo+"'");
                if (resultado == 0) {
                    throw new MvPedidoNaoEncontradoException(codigo);
                } 
            }
            catch (SQLException e) {
    		throw new RepositorioException(e);
            }
        } finally {
            ConnectionManager.liberaStatement();
        }
    }
    private void removeRelacionamento(Statement statement, String codigo) throws 
    SQLException, RepositorioException {
        statement.executeUpdate("DELETE FROM ITEMPDVENDA WHERE PEDIDO='" + 
        codigo + "'");
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