/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.Modelos;

import java.util.Date;

/**
 *
 * @author Marcos
 */
public class Pet {
    
    private String nome;
    private String tipo;
    private int porte;
    private Date nascimento;
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public int getPorte(){
        return this.porte;
    }
    
    public void setPorte(int porte){
        this.porte = porte;
    }
    
    public Date getNascimento(){
        return this.nascimento;
    }
    
    public void setNascimento(Date data){
        this.nascimento = data;
    }
}
