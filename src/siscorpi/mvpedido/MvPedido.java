/*
 * MvPedido.java
 *
 * Created on 7 de Setembro de 2005, 15:58
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package siscorpi.mvpedido;

/**
 *
 * @author sergio
 */
public class MvPedido {
    private String codigo;
    private String data;
    private String hora;
    private String cliente;
    private String funcionario;
    private int    prazo_pagamento;
    private String situacao;
    private double total;
    /** Creates a new instance of MvPedido */
    public MvPedido(String codigo, String data, String hora, String cliente,
    String funcionario, int prazo_pagamento, String situacao, double total) {
        this.setCodigo(codigo);
        this.setData(data);
        this.setHora(hora);
        this.setCliente(cliente);
        this.setFuncionario(funcionario);
        this.setPrazo_pagamento(prazo_pagamento);
        this.setSituacao(situacao);
        this.setTotal(total);
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public String getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }
    public int getPrazo_pagamento() {
        return prazo_pagamento;
    }
    public void setPrazo_pagamento(int prazo_pagamento) {
        this.prazo_pagamento = prazo_pagamento;
    }
    public String getSituacao() {
        return situacao;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
}
