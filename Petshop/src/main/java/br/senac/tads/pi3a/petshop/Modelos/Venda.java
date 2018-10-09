/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.Modelos;

import java.util.List;

/**
 *
 * @author Dud Felipe
 */
public class Venda {
    private Cliente cliente;
    private Funcionario funcionario;
    private List<Produto> produtos;

    public Venda() {
        
    }
    
    public Venda(Cliente cliente, List<Produto> produtos, Funcionario funcionario) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    
}
