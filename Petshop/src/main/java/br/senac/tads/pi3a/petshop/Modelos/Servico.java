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
    private Filial filial;
    private int quantidade_comprada;

    public Servico() {
    }

    public int getQuantidade_comprada() {
        return quantidade_comprada;
    }

    public void setQuantidade_comprada(int quantidade_comprada) {
        this.quantidade_comprada = quantidade_comprada;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    
    public Servico(int id, String descricao, BigDecimal preco, int tamanhoAnimal, Filial filial) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.tamanhoAnimal = tamanhoAnimal;
        this.filial = filial;
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
