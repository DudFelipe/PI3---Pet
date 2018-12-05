/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.Modelos;

import java.util.List;
import java.math.BigDecimal;

/**
 *
 * @author Dud Felipe
 */
public class Venda {
    private Cliente cliente;
    private Usuario funcionario;
    private List<Produto> produtos;
    private List<Servico> servicos;
    private Float valorTotal;
    private Date data;


    public Venda() {
        
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
    public Venda(Cliente cliente, Pet pet, List<Produto> produtos, List<Servico> servicos, Funcionario funcionario, Date data) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.servicos = servicos;
        this.funcionario = funcionario;
        this.data = data;

    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }  

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
        //this.funcionario = funcionario;
    }
    
}
