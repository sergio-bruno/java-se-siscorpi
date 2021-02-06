/*
 * Produto.java
 *
 * Created on 12 de Setembro de 2005, 01:11
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package siscorpi.produto;

/**
 *
 * @author sergio
 */
public class Produto {
    private String codigo;
    private String descricao;
    private String unidade;
    private String cod_barras;
    private double preco_venda;
    
    /** Creates a new instance of Produto */
    public Produto(String codigo, String descricao, String unidade,
    String cod_barras,double preco_venda) {
        this.setCodigo(codigo);
        this.setDescricao(descricao);
        this.setUnidade(unidade);
        this.setCod_barras(cod_barras);
        this.setPreco_venda(preco_venda);
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getUnidade() {
        return unidade;
    }
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    public String getCod_barras() {
        return cod_barras;
    }
    public void setCod_barras(String cod_barras) {
        this.cod_barras = cod_barras;
    }
    public double getPreco_venda() {
        return preco_venda;
    }
    public void setPreco_venda(double preco_venda) {
        this.preco_venda = preco_venda;
    }
}
