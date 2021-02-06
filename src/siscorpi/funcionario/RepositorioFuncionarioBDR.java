/*
 * RepositorioFuncionarioBDR.java
 *
 * Created on 11 de Setembro de 2005, 00:54
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package siscorpi.funcionario;
import  java.sql.*;
import java.text.DecimalFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import  siscorpi.util.*;
/**
 *
 * @author sergio
 */
public class RepositorioFuncionarioBDR implements RepositorioFuncionario  {
    
    /** Creates a new instance of RepositorioFuncionarioBDR */
    public RepositorioFuncionarioBDR() {
    }
    public void inserir(Funcionario funcionario) throws RepositorioException {
        try {
            Statement statement = ConnectionManager.reservaStatement();
            ClasseTrocaCaracteres  cTrocaCaracteres  = new ClasseTrocaCaracteres();
            String wxval =  cTrocaCaracteres.TrocaCaracteres( ".", ",",
                            Double.toString(funcionario.getComissao()));
            cTrocaCaracteres = null;
            if (funcionario != null) {
                try {
                    statement.executeUpdate(
                    "INSERT INTO FUNCIONARIO (CODIGO,NOME,IDENTIDADE,CPF,COMISSAO) Values ('"+
                    funcionario.getCodigo()+"','"+funcionario.getNome()+
                    "','"+funcionario.getIdentidade()+"','"+funcionario.getCpf()+        
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
    public void remover(String codigo) throws FuncionarioNaoEncontradoException, 
    RepositorioException {
        try{
        Statement statement = ConnectionManager.reservaStatement();
	int resultado = statement.executeUpdate("DELETE FROM FUNCIONARIO WHERE CODIGO='" + 
                        codigo + "'");
        if (resultado == 0) {
            throw new FuncionarioNaoEncontradoException(codigo);
        } 
        } catch(SQLException e){
            throw new RepositorioException(e);
        } finally {
            ConnectionManager.liberaStatement();
        }
    }
    public Funcionario procurar(String codigo) throws 
    FuncionarioNaoEncontradoException, RepositorioException {
        Funcionario funcionario = null;
        try {
            Statement statement = ConnectionManager.reservaStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM FUNCIONARIO WHERE CODIGO = '" + 
                                  codigo + "'");
            if (resultset.next()) {
                funcionario = new Funcionario(resultset.getString("CODIGO"),
                resultset.getString("NOME"),resultset.getString("IDENTIDADE"),
                resultset.getString("CPF"),resultset.getDouble("COMISSAO"));
                resultset.close();
            } else {
                throw new FuncionarioNaoEncontradoException(codigo);
            }
        } catch (SQLException e) {
            throw new RepositorioException(e);
	} finally {
            ConnectionManager.liberaStatement();
	}
	return funcionario;
	}
	public void atualizar(Funcionario funcionario) throws 
        FuncionarioNaoEncontradoException, RepositorioException {
	    try {
    	    Statement statement = ConnectionManager.reservaStatement();
            ClasseTrocaCaracteres  cTrocaCaracteres  = new ClasseTrocaCaracteres();
            String wxval =  cTrocaCaracteres.TrocaCaracteres( ".", ",",
                            Double.toString(funcionario.getComissao()));
            cTrocaCaracteres = null;
            if (funcionario != null) {
                try { 
                    int resultado = statement.executeUpdate(
                    "UPDATE FUNCIONARIO SET "+"NOME='"+funcionario.getNome()+
                    "', IDENTIDADE='"+funcionario.getIdentidade()+
                    "', CPF='"+funcionario.getCpf()+
                    "', COMISSAO='"+wxval+"' WHERE codigo = '"+funcionario.getCodigo()+"'");
                    if (resultado == 0) {
                        throw new FuncionarioNaoEncontradoException(
                        funcionario.getCodigo());
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
                                      "SELECT CODIGO FROM FUNCIONARIO WHERE CODIGO = '"+ 
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
