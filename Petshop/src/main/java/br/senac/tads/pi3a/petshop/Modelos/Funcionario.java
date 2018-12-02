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
public class Funcionario extends Usuario{

    public Funcionario() {
    }

    public Funcionario(int id, String nome, Date dtNascimento, String cpf, String rg, String telefone, String email, String endereco, String senha, int tipoAcesso, char sexo, Filial filial) {
        super(id, nome, dtNascimento, cpf, rg, telefone, email, endereco, senha, tipoAcesso, sexo, filial);
    }
    
}
