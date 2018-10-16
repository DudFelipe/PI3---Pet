/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.BLL;

import br.senac.tads.pi3a.petshop.DAO.ClienteDAO;
import br.senac.tads.pi3a.petshop.Modelos.Cliente;

/**
 *
 * @author Dud Felipe
 */
public class ClienteBLL {
    
    public static void inserir(Cliente c) throws Exception{
        if(c.getNome().trim().length() == 0){
            throw new Exception("O nome deve ser preenchido!");
        }
        if(c.getDtNascimento().toString().trim().length() == 0){
            throw new Exception("A data de nascimento deve ser preenchida!");
        }
        if(c.getCpf().trim().length() == 0){
            throw new Exception("O CPF deve ser preenchido!");
        }
        if(c.getRg().trim().length() == 0){
            throw new Exception("O RG deve ser preenchido!");
        }
        if(c.getTelefone().trim().length() == 0){
            throw new Exception("O telefone deve ser preenchido!");
        }
        if(c.getEmail().trim().length() == 0){
            throw new Exception("O email deve ser preenchido!");
        }
        if(c.getSexo() != 'M' && c.getSexo() != 'F'){
            throw new Exception("O sexo deve ser selecionado!");
        }
        
        ClienteDAO.inserir(c);
    }
    
    public static void alterar(Cliente c){
        
    }
    
    public static void excluir(int id){
        
    }
    
    public static void listar(String filtro){
        
    }
}
