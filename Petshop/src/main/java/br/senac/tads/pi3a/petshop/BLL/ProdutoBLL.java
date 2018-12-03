/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.BLL;

import br.senac.tads.pi3a.petshop.DAO.ProdutoDAO;
import br.senac.tads.pi3a.petshop.Modelos.Produto;
import java.math.BigDecimal;

/**
 *
 * @author Dud Felipe
 */

public class ProdutoBLL {
    public static void inserir(Produto p) throws Exception{
        if(p.getNome().trim().length() == 0){
            throw new Exception("O nome deve ser preenchido!");
        }
        
        if(p.getPreco() == null || p.getPreco().compareTo(BigDecimal.ZERO) < 0){
            throw new Exception("O preço deve ser preenchido e maior que zero!");
        }
        
        

        //Caso todos os dados estejam corretos, o cliente é enviado para o método inserir da classe ClienteDAO.
        //Essa classe é responsável por realizar operações no banco de dados.
        ProdutoDAO.inserir(p);
    }
    
    
    public static void alterar(Produto p){
        
    }
    
    public static void excluir(int id){
        
    }
    
    public static void listar(String filtro){
        
    }
}
