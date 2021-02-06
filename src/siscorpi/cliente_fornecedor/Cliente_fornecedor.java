/*
 * Cliente_fornecedor.java
 *
 * Created on 23 de Agosto de 2005, 23:07
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package siscorpi.cliente_fornecedor;
/**
 *
 * @author sergio
 */
public class Cliente_fornecedor {
    private String codigo;
    private String razao_social;
    private String fantasia;
    private String cnpj_cpf;
    private String ie;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String numero;
    private String fone;
    private String fax;
    private String celular;
    private String email;
    private Integer tipo;
    /** Creates a new instance of Cliente_fornecedor */
    public Cliente_fornecedor(String codigo, String razao_social, 
    String fantasia, String cnpj_cpf, String ie, String endereco,
    String bairro, String cidade, String estado, String cep, 
    String numero, String fone, String fax, String celular, 
    String email, Integer tipo) {
        this.setCodigo(codigo);
        this.setRazao_social(razao_social);
        this.setFantasia(fantasia);
        this.setCnpj_cpf(cnpj_cpf);
        this.setIe(ie);
        this.setEndereco(endereco);
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setEstado(estado);
        this.setCep(cep);
        this.setNumero(numero);
        this.setFone(fone);
        this.setFax(fax);
        this.setCelular(celular);
        this.setEmail(email);
        this.setTipo(tipo);
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getRazao_social() {
        return razao_social;
    }
    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }
    public String getFantasia() {
        return fantasia;
    }
    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }
    public String getCnpj_cpf() {
        return cnpj_cpf;
    }
    public void setCnpj_cpf(String cnpj_cpf) {
        this.cnpj_cpf = cnpj_cpf;
    }
    public String getIe() {
        return ie;
    }
    public void setIe(String ie) {
        this.ie = ie;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getFone() {
        return fone;
    }
    public void setFone(String fone) {
        this.fone = fone;
    }
    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getTipo() {
        return tipo;
    }
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
}
