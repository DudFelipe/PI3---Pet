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
public class Produto {
    private String nome;
    private BigDecimal preco;
    private String fabricante;
    private int quantidade;
    private String modelo;
    private long codBarras;

    public Produto() {
    }

    public Produto(String nome, BigDecimal preco, String fabricante, int quantidade, String modelo, long codBarras) {
        this.nome = nome;
        this.preco = preco;
        this.fabricante = fabricante;
        this.quantidade = quantidade;
        this.modelo = modelo;
        this.codBarras = codBarras;
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

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public long getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(long codBarras) {
        this.codBarras = codBarras;
    }
    
    
}
