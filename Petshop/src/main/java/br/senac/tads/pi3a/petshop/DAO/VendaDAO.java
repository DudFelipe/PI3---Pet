/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.DAO;

import br.senac.tads.pi3a.petshop.Modelos.Cliente;
import br.senac.tads.pi3a.petshop.Modelos.Venda;
import br.senac.tads.pi3a.petshop.Utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;

/**
 *
 * @author Dud Felipe
 */
public class VendaDAO {
    public static void inserir(Venda v) throws SQLException, Exception{
      String sql = "INSERT INTO pedido (idcliente, idfuncionario, idFilial, data, precoVenda) " +
                     " VALUES (?, ?, ?, ?, ?);";
        
     String sql2 = "INSERT INTO detalhes_pedido(idPedido,idProduto, idServico,quantidade) VALUES(?,?,?,?) ";
     
        Connection conn = null;
        PreparedStatement pst = null;
        conn = ConnectionUtils.getConnection();
        pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        pst.setInt(1, v.getCliente().getId());
        pst.setInt(2, 3);
        pst.setInt(3, 1);
        Timestamp t = new Timestamp(System.currentTimeMillis());
        pst.setTimestamp(4, t);
        

        pst.setFloat(5, v.getValorTotal());
        pst.execute();
        
        ResultSet rs = pst.getGeneratedKeys();
        int idPedido = 0;
	if(rs.next()){
            idPedido = rs.getInt(1);
	}	
        
        pst = null;
        try{
            
            for(int p = 0; p < v.getServicos().size(); p++) {
                pst = conn.prepareStatement(sql2);
                pst.setInt(1, idPedido);
                pst.setNull(2, Types.INTEGER);
                pst.setInt(3, v.getServicos().get(p).getId());
                pst.setInt(4, v.getServicos().get(p).getQuantidade_comprada());
                pst.execute();
                pst = null;
            }

        }
        finally{
            if(pst != null && !pst.isClosed())
                pst.close();
            
            if(conn != null && !conn.isClosed())
                conn.close();
        }
        
    }
    
    public static void listar(String filtro){
        
    }
    
    public static Venda obterVenda(int id) throws SQLException{
        return null;
    }
}
