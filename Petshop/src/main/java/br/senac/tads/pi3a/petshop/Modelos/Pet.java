/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.Modelos;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Marcos
 */
public class Pet {
    
    private int id;
    private Cliente idCliente;
    private String nome;
    private String especie;
    private String porte;
    private Date nascimento;

    public Pet() {
        
    }

    public Pet(int id, Cliente idCliente, String nome, String especie, String porte, Date nascimento) {
        this.id = id;
        this.idCliente = idCliente;
        this.nome = nome;
        this.especie = especie;
        this.porte = porte;
        this.nascimento = nascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public Date getNascimento() {
        return nascimento;
    }
    
    public String getNascimentoStr(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(this.nascimento);
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
}
