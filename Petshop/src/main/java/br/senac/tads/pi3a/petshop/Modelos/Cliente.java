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
 * @author Dud Felipe
 */
public class Cliente extends Usuario{

    public Cliente() {
    }

    public Cliente(int id, String nome, Date dtNascimento, String cpf, String rg, String telefone, String email, String endereco, String senha, int tipoAcesso, char sexo) {
        super(id, nome, dtNascimento, cpf, rg, telefone, email, endereco, senha, tipoAcesso, sexo);
    }
}
