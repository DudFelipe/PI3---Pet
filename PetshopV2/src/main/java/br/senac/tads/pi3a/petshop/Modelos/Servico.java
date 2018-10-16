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
    private String tipoAnimal;
    private int porteAnimal;

    public Servico() {
    }

    public Servico(String nome, BigDecimal preco, int porte) {
        this.nome = nome;
        this.preco = preco;
        this.porteAnimal = porte;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return this.preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getTipoAnimal() {
        return this.tipoAnimal;
    }

    public void setTipoAnimal(String tipo) {
        this.tipoAnimal = tipo;
    }    
    
    
    public int getPorteAnimal() {
        return this.porteAnimal;
    }

    public void setPorteAnimal(int porteAnimal) {
        this.porteAnimal = porteAnimal;
    }
    
    
}
