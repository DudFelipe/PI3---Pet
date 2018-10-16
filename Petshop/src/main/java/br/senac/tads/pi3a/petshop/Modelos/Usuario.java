/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.Modelos;

import java.util.Date;

/**
 *
 * @author Dud Felipe
 */
public abstract class Usuario {
    private String nome;
    private String cpf;
    private Date nascimento;
    private String telefone;
    private String email;
    private char sexo;
    
    public Usuario() {
        
    }

    public Usuario(String nome, String cpf, Date nascimento, String telefone, String email, char sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.email = email;
        this.sexo = sexo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
}
