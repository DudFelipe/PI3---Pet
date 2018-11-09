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
        
        if(p.getFabricante().trim().lenght() == 0) {
        	throw new Exception("O fabricante deve ser preenchido!");
        }
        
        if(p.getQuantidade() == null || p.getQuantidade() < 0){
            throw new Exception("A quantidade deve ser preenchida e maior que zero!");
        }
        
        if(p.getModelo().trim().lenght() == 0) {
        	throw new Exception("O modelo deve ser preenchido!");
        }

        ProdutoDAO.inserir(p);
    }
    
    
    public static void alterar(Produto p) throws Exception{
        if(p.getNome().trim().length() == 0){
            throw new Exception("O nome deve ser preenchido!");
        }
        
        if(p.getPreco() == null || p.getPreco().compareTo(BigDecimal.ZERO) < 0){
            throw new Exception("O preço deve ser preenchido e maior que zero!");
        }
        
        if(p.getFabricante().trim().lenght() == 0) {
        	throw new Exception("O fabricante deve ser preenchido!");
        }
        
        if(p.getQuantidade() == null || p.getQuantidade() < 0){
            throw new Exception("A quantidade deve ser preenchida e maior que zero!");
        }
        
        if(p.getModelo().trim().lenght() == 0) {
        	throw new Exception("O modelo deve ser preenchido!");
        }

        ProdutoDAO.alterar(p);        
    }
    
    public static void excluir(int id)throws SQLException, ClassNotFoundException{
        ProdutoDAO.excluir(id);
    }
    
    public static void listar(String filtro)throws SQLException, ClassNotFoundException{
        return ProdutoDAO.listar();
    }
}
