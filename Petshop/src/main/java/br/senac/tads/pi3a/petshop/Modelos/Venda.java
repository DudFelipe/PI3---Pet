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
    private Pet pet;
    private Funcionario funcionario;
    private List<Produto> produtos;
    private List<Servico> servicos;
    private BigDecimal valorTotal;
    private boolean fechada;

    public Venda() {
        
    }
    
    public Venda(Cliente cliente, Pet pet, List<Produto> produtos, List<Servico> servicos, Funcionario funcionario) {
        this.cliente = cliente;
        this.pet = pet;
        this.produtos = produtos;
        this.servicos = servicos;
        this.funcionario = funcionario;
        
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pet getPet() {
        return this.pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public void calculaTotal(){
        
    }
    
    public int registraConta(){
        return 0;
    }
}
