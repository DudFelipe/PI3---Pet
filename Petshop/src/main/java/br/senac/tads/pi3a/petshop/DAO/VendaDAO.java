/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.DAO;

import br.senac.tads.pi3a.petshop.Modelos.Cliente;
import br.senac.tads.pi3a.petshop.Modelos.Venda;
import java.sql.SQLException;

/**
 *
 * @author Dud Felipe
 */
public class VendaDAO {
    public static void inserir(Venda v) throws SQLException, Exception{
      String sql = "INSERT INTO pedido (idcliente, data, precoVenda) " +
                     " VALUES (?, null, ?, ?, ?, ?, ?, ?, ?, ?);";
        
     String sql2 = "INSERT NTO detalhes_pedido(idPedido,idProduto,idServico,quantidade,precoProdutos)"+
             "VALUES(?,?,?,?)";
    }
    
    public static void listar(String filtro){
        
    }
    
    public static Venda obterVenda(int id) throws SQLException{ 
        return null;
    }
}
