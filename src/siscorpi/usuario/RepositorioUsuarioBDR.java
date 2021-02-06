/*
 * RepositorioUsuarioBDR.java
 *
 * Created on 9 de Setembro de 2005, 00:55
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package siscorpi.usuario;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.JOptionPane;
import siscorpi.util.*;

/**
 *
 * @author sergio
 */
public class RepositorioUsuarioBDR implements RepositorioUsuario {
    
    /** Creates a new instance of RepositorioUsuarioBDR */
    public RepositorioUsuarioBDR() {
    }
    public void inserir(Usuario usuario) throws RepositorioException {
        try {
            Statement statement = ConnectionManager.reservaStatement();
            if (usuario != null) {
                try {
                    statement.executeUpdate(
                    "INSERT INTO USUARIO (LOGIN,SENHA) Values ('"+
                    usuario.getLogin()+"','"+usuario.getSenha()+"')");
                }
                catch (SQLException e) {
                    throw new RepositorioException(e);
    		}
            }
        } finally {
            ConnectionManager.liberaStatement();
        }
    }
    public void remover(String login) throws UsuarioNaoEncontradoException, 
    RepositorioException {
        try{
        Statement statement = ConnectionManager.reservaStatement();
	int resultado = statement.executeUpdate("DELETE FROM USUARIO WHERE LOGIN='" + 
                        login + "'");
        if (resultado == 0) {
            throw new UsuarioNaoEncontradoException(login);
        } 
        } catch(SQLException e){
            throw new RepositorioException(e);
        } finally {
            ConnectionManager.liberaStatement();
        }
    }
    public Usuario procurar(String login) throws 
    UsuarioNaoEncontradoException, RepositorioException {
        Usuario usuario = null;
        try {
            Statement statement = ConnectionManager.reservaStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM USUARIO WHERE LOGIN = '" + 
                                  login + "'");
            if (resultset.next()) {
                usuario = new Usuario(resultset.getString("LOGIN"),
                resultset.getString("SENHA"));
                resultset.close();
            } else {
                throw new UsuarioNaoEncontradoException(login);
            }
        } catch (SQLException e) {
            throw new RepositorioException(e);
	} finally {
            ConnectionManager.liberaStatement();
	}
	return usuario;
	}
	public void atualizar(Usuario usuario) throws 
        UsuarioNaoEncontradoException, RepositorioException {
	    try {
    	    Statement statement = ConnectionManager.reservaStatement();
            if (usuario != null) {
                try {
                    int resultado = statement.executeUpdate(
                    "UPDATE USUARIO SET "+"SENHA='"+usuario.getSenha()+
                    "' WHERE login = '"+usuario.getLogin()+"'");
                    if (resultado == 0) {
                        throw new UsuarioNaoEncontradoException(usuario.getLogin());
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
	public boolean existe(String login) throws RepositorioException {
   	    boolean resposta = false;
            try {
                Statement statement = ConnectionManager.reservaStatement();
                ResultSet resultset = statement.executeQuery(
                                      "SELECT LOGIN FROM USUARIO WHERE LOGIN = '"+ 
                                      login + "'");
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
