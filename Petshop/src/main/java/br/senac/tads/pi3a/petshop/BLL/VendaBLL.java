/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.BLL;

import br.senac.tads.pi3a.petshop.DAO.VendaDAO;
import br.senac.tads.pi3a.petshop.Modelos.Venda;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dud Felipe
 */
public class VendaBLL {

    public static void inserir(Venda v) throws Exception {
        if (v.getFuncionario() == null) {
             throw new Exception("Informe o nome do funcionário");
        }
        if (v.getProdutos() == null && v.getServicos() == null) {
             throw new Exception("Por favor, insira um item no carrinho");
        }
        if (v.getCliente() == null) {
           throw new Exception("Por favor, selecione um cliente "); 
        }
        
        VendaDAO.inserir(v);
    }

    public static List<Venda> listar(String filtro) throws SQLException, ClassNotFoundException {
        return VendaDAO.listar(filtro);
    }

    public static Venda obterVenda(int id) throws SQLException {
        return VendaDAO.obterVenda(id);
    }
}
