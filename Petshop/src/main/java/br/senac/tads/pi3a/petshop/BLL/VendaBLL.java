/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.BLL;

import br.senac.tads.pi3a.petshop.Modelos.Venda;

/**
 *
 * @author Dud Felipe
 */
public class VendaBLL {
    public static void inserir(Venda v){
        
    }

//    public static List<Venda> listar(String filtro) throws SQLException, ClassNotFoundException {
//        return VendaDAO.listar(filtro);
//    }

    public static Venda obterVenda(int id) throws SQLException {
        return VendaDAO.obterVenda(id);
    }
    
    public static void listar(String filtro){
        
    }
}
