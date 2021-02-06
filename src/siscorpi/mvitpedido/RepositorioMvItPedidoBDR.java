/*
 * RepositorioMvItPedidoBDR.java
 *
 * Created on 7 de Setembro de 2005, 20:20
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package siscorpi.mvitpedido;
import  java.sql.*;
import  java.text.DecimalFormat;
import  java.util.Vector;
import  javax.swing.JOptionPane;
import  siscorpi.util.*;

/**
 *
 * @author sergio
 */
public class RepositorioMvItPedidoBDR implements RepositorioMvItPedido  {
    /** Creates a new instance of RepositorioMvItPedidoBDR */
    public RepositorioMvItPedidoBDR() {
    }
    public void inserir(MvItPedido mvitpedido) throws RepositorioException {
        try {
            Statement statement = ConnectionManager.reservaStatement();
            ClasseTrocaCaracteres  cTrocaCaracteres  = new ClasseTrocaCaracteres();
            String wxqtde =  cTrocaCaracteres.TrocaCaracteres( ".", ",",
                             Double.toString(mvitpedido.getQtde()));
            String wxvunt =  cTrocaCaracteres.TrocaCaracteres( ".", ",",
                             Double.toString(mvitpedido.getV_unitario()));
            String wxvfre =  cTrocaCaracteres.TrocaCaracteres( ".", ",",
                             Double.toString(mvitpedido.getV_frete()));
            String wxstot =  cTrocaCaracteres.TrocaCaracteres( ".", ",",
                             Double.toString(mvitpedido.getS_total()));
            String wxdesc =  cTrocaCaracteres.TrocaCaracteres( ".", ",",
                             Double.toString(mvitpedido.getDesconto()));
            String wxtota =  cTrocaCaracteres.TrocaCaracteres( ".", ",",
                             Double.toString(mvitpedido.getTotal()));
            cTrocaCaracteres = null;
            if (mvitpedido != null) {
                try {
                    statement.executeUpdate(
                    "INSERT INTO ITEMPDVENDA (PEDIDO,PRODUTO,QTDE,V_UNITARIO,V_FRETE,S_TOTAL,DESCONTO,TOTAL) Values ('"+
                    mvitpedido.getPedido()+"','"+mvitpedido.getProduto()+
                    "','"+wxqtde+"','"+wxvunt+"','"+wxvfre+"','"+wxstot+ 
                    "','"+wxdesc+"','"+wxtota+"')");
                }
                catch (SQLException e) {
                    throw new RepositorioException(e);
    		}
            }
        } finally {
            ConnectionManager.liberaStatement();
        }
    }
    public void remover(String pedido, String produto) throws MvItPedidoNaoEncontradoException, 
    RepositorioException {
        try{
        Statement statement = ConnectionManager.reservaStatement();
	int resultado = statement.executeUpdate("DELETE FROM ITEMPDVENDA WHERE PEDIDO='" + 
                        pedido + "' AND PRODUTO='"+ produto + "'");
        if (resultado == 0) {
            throw new MvItPedidoNaoEncontradoException(pedido,produto); 
        } 
        } catch(SQLException e){
            throw new RepositorioException(e);
        } finally {
            ConnectionManager.liberaStatement();
        }
    }
    public MvItPedido procurar(String pedido, String produto) throws 
    MvItPedidoNaoEncontradoException, RepositorioException {
        MvItPedido mvitpedido = null;
        try {
            Statement statement = ConnectionManager.reservaStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM ITEMPDVENDA WHERE PEDIDO = '" + 
                                  pedido + "' AND PRODUTO='" + produto + "'");
            if (resultset.next()) {
                mvitpedido = new MvItPedido(resultset.getString("PEDIDO"),
                resultset.getString("PRODUTO"),resultset.getDouble("QTDE"),
                resultset.getDouble("V_UNITARIO"),resultset.getDouble("V_FRETE"),
                resultset.getDouble("S_TOTAL"),resultset.getDouble("DESCONTO"),
                resultset.getDouble("TOTAL"));
                resultset.close();
            } else {
                throw new MvItPedidoNaoEncontradoException(pedido,produto);
            }
        } catch (SQLException e) {
            throw new RepositorioException(e);
	} finally {
            ConnectionManager.liberaStatement();
	}
	return mvitpedido;
    }
    public void atualizar(MvItPedido mvitpedido) throws 
    MvItPedidoNaoEncontradoException, RepositorioException {
        try {
    	    Statement statement = ConnectionManager.reservaStatement();
            ClasseTrocaCaracteres  cTrocaCaracteres  = new ClasseTrocaCaracteres();
            String wxqtde =  cTrocaCaracteres.TrocaCaracteres( ".", ",",
                             Double.toString(mvitpedido.getQtde()));
            String wxvunt =  cTrocaCaracteres.TrocaCaracteres( ".", ",",
                             Double.toString(mvitpedido.getV_unitario()));
            String wxvfre =  cTrocaCaracteres.TrocaCaracteres( ".", ",",
                             Double.toString(mvitpedido.getV_frete()));
            String wxstot =  cTrocaCaracteres.TrocaCaracteres( ".", ",",
                             Double.toString(mvitpedido.getS_total()));
            String wxdesc =  cTrocaCaracteres.TrocaCaracteres( ".", ",",
                             Double.toString(mvitpedido.getDesconto()));
            String wxtota =  cTrocaCaracteres.TrocaCaracteres( ".", ",",
                             Double.toString(mvitpedido.getTotal()));
            cTrocaCaracteres = null;
            if (mvitpedido != null) {
                try { 
                    int resultado = statement.executeUpdate(
                    "UPDATE ITEMPDVENDA SET "+"QTDE='"+wxqtde+
                    "', V_UNITARIO='"+wxvunt+"', V_FRETE='"+wxvfre+
                    "', S_TOTAL='"+wxstot+"', DESCONTO='"+wxdesc+
                    "', TOTAL='"+wxtota+"' WHERE pedido = '"+mvitpedido.getPedido()+
                    "' AND PRODUTO='" + mvitpedido.getProduto() + "'");
                    if (resultado == 0) {
                        throw new MvItPedidoNaoEncontradoException(
                        mvitpedido.getPedido(), mvitpedido.getProduto());
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
    public boolean existe(String pedido, String produto) throws RepositorioException {
        boolean resposta = false;
        try {
            Statement statement = ConnectionManager.reservaStatement();
            ResultSet resultset = statement.executeQuery(
                                  "SELECT PEDIDO,PRODUTO FROM ITEMPDVENDA WHERE PEDIDO = '"+ 
                                  pedido + "' AND PRODUTO='" + produto + "'");
            resposta = resultset.next();
            resultset.close();
        } catch (SQLException e) {
            throw new RepositorioException(e);
        } finally {
            ConnectionManager.liberaStatement();
        }
        return resposta;
    }
    public Vector listarItensPedido(String pedido) throws RepositorioException {
        Vector linhas = new Vector();
        try {
            String sql = "select itempdvenda.produto,produto.descricao,"+
                         "itempdvenda.qtde,itempdvenda.v_unitario,"+
                         "itempdvenda.v_frete,itempdvenda.s_total,"+
                         "itempdvenda.desconto,itempdvenda.total from "+
                         "itempdvenda, produto where "+
                         "itempdvenda.produto=produto.codigo and "+
                         "itempdvenda.pedido='"+pedido+"'"; 
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