/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.Modelos;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 *
 * @author Dud Felipe
 */
public class Venda {

    private Cliente cliente;

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    // private Pet pet;
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    private Date dataVenda;
    private Funcionario funcionario;
    private List<Produto> produtos;
    private List<Servico> servicos;
    private BigDecimal valorTotal;

    public int getPedido() {
        return Pedido;
    }

    //private boolean fechada;
    public void setPedido(int Pedido) {
        this.Pedido = Pedido;
    }
    private int Pedido;

    public Venda() {

    }

    public Venda(Cliente cliente, Pet pet, List<Produto> produtos, List<Servico> servicos,
            Funcionario funcionario, Date data) {
        this.cliente = cliente;
        //this.pet = pet;
        this.produtos = produtos;
        this.servicos = servicos;
        this.funcionario = funcionario;
        this.dataVenda = data;

    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }  

    /* public Pet getPet() {
       return this.pet;
    }

    public void setPet(Pet pet) {
       this.pet = pet;
    } */
    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Servico> getServicos() {
        return this.servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public Usuario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Usuario funcionario) {
        this.funcionario = funcionario;
    }

    public void calculaTotal() {

    }

    public int registraConta() {
        return 0;
    }
}
