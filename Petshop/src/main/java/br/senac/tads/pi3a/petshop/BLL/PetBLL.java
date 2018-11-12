/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.BLL;

import br.senac.tads.pi3a.petshop.DAO.PetDAO;
import br.senac.tads.pi3a.petshop.Modelos.Pet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dud Felipe
 */
public class PetBLL {
    
    public static void inserir(Pet p) throws Exception{
        if(p.getNome().trim().length() <= 0){
            throw new Exception("O nome do pet deve ser preenchido!");
        }
        if(p.getEspecie().trim().length() <= 0){
            throw new Exception("A espécie deve ser preenchida!");
        }
        if(p.getPorte().trim().length() <= 0){
            throw new Exception("O porte deve ser preenchido!");
        }
        if(p.getNascimento().toString().trim().length() <= 0){
            throw new Exception("A data de nascimento deve ser preenchido!");
        }
        
        PetDAO.inserir(p);
    }
    
    public static void alterar(Pet p) throws Exception{
        if(p.getNome().trim().length() <= 0){
            throw new Exception("O nome do pet deve ser preenchido!");
        }
        if(p.getEspecie().trim().length() <= 0){
            throw new Exception("A espécie deve ser preenchida!");
        }
        if(p.getPorte().trim().length() <= 0){
            throw new Exception("O porte deve ser preenchido!");
        }
        if(p.getNascimento().toString().trim().length() <= 0){
            throw new Exception("A data de nascimento deve ser preenchido!");
        }
        
        PetDAO.alterar(p);
    }
    
    public static void excluir(int id) throws Exception{
        PetDAO.excluir(id);
    }
    
    public static List<Pet> listar() throws SQLException, ClassNotFoundException{
        return PetDAO.listar();
    }
    
    public static Pet obterPet(int id) throws SQLException{
        return PetDAO.obterPet(id);
    }
}
