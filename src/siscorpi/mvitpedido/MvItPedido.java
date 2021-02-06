/*
 * MvItPedido.java
 *
 * Created on 7 de Setembro de 2005, 20:07
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package siscorpi.mvitpedido;

/**
 *
 * @author sergio
 */
public class MvItPedido {
    private String pedido;
    private String produto;
    private double qtde;
    private double v_unitario;
    private double v_frete;
    private double s_total;
    private double desconto;
    private double total;
    /** Creates a new instance of MvItPedido */
    public MvItPedido(String pedido, String produto, double qtde, double v_unitario,
    double v_frete, double s_total, double desconto, double total) {
        this.setPedido(pedido);
        this.setProduto(produto);
        this.setQtde(qtde);
        this.setV_unitario(v_unitario);
        this.setV_frete(v_frete);
        this.setS_total(s_total);
        this.setDesconto(desconto);
        this.setTotal(total);
    }
    public String getPedido() {
        return pedido;
    }
    public void setPedido(String pedido) {
        this.pedido = pedido;
    }
    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }
    public double getQtde() {
        return qtde;
    }
    public void setQtde(double qtde) {
        this.qtde = qtde;
    }
    public double getV_unitario() {
        return v_unitario;
    }
    public void setV_unitario(double v_unitario) {
        this.v_unitario = v_unitario;
    }
    public double getV_frete() {
        return v_frete;
    }
    public void setV_frete(double v_frete) {
        this.v_frete = v_frete;
    }
    public double getS_total() {
        return s_total;
    }
    public void setS_total(double s_total) {
        this.s_total = s_total;
    }
    public double getDesconto() {
        return desconto;
    }
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
}
