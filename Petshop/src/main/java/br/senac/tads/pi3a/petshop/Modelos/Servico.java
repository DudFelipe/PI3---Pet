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
    private int id;
    private String descricao;
    private BigDecimal preco;
    private int tamanhoAnimal;

    public Servico() {
    }

    public Servico(int id, String descricao, BigDecimal preco, int tamanhoAnimal) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.tamanhoAnimal = tamanhoAnimal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getTamanhoAnimal() {
        return tamanhoAnimal;
    }

    public void setTamanhoAnimal(int tamanhoAnimal) {
        this.tamanhoAnimal = tamanhoAnimal;
    }

    
}
