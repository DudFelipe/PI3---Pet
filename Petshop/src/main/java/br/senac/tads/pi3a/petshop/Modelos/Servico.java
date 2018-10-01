/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.Modelos;

import java.math.BigDecimal;

/**
 *
 * @author Dud Felipe
 */
public class Servico {
    private String nome;
    private BigDecimal preco;
    private int tamAnimal;

    public Servico() {
    }

    public Servico(String nome, BigDecimal preco, int tamAnimal) {
        this.nome = nome;
        this.preco = preco;
        this.tamAnimal = tamAnimal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getTamAnimal() {
        return tamAnimal;
    }

    public void setTamAnimal(int tamAnimal) {
        this.tamAnimal = tamAnimal;
    }
    
    
}
