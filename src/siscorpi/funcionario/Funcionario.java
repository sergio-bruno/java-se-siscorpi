/*
 * Funcionario.java
 *
 * Created on 11 de Setembro de 2005, 01:07
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package siscorpi.funcionario;

/**
 *
 * @author sergio
 */
public class Funcionario {
    private String codigo;
    private String nome;
    private String identidade;
    private String cpf;
    private double comissao;
    
    /** Creates a new instance of Funcionario */
    public Funcionario(String codigo, String nome, String identidade,
    String cpf,double comissao) {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setIdentidade(identidade);
        this.setCpf(cpf);
        this.setComissao(comissao);
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getIdentidade() {
        return identidade;
    }
    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public double getComissao() {
        return comissao;
    }
    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
}
