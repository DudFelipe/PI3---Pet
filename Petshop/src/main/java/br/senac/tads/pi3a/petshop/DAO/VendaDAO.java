/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.DAO;

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
        
    }
    
    public static void alterar(Venda v){
        
    }
    
    public static void excluir(int id){
        

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

    public static List<Venda> listar(String filtro) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM pedido";
        String sql2 = "SELECT * FROM detalhes_pedido";

        List<Venda> listaVendas = new LinkedList<Venda>();

        Connection conn = null;
        PreparedStatement pst = null;

        conn = ConnectionUtils.getConnection();

        ResultSet rs = pst.executeQuery();

        try {
            pst = conn.prepareStatement(sql);

            while (rs.next()) {
                Venda v = new Venda();

                v.setPedido(rs.getInt("idPedido"));
                //v.setFuncionario(rs.getInt("idFuncionario"));
                v.setDataVenda(rs.getDate("data"));
                v.setValorTotal(rs.getBigDecimal("precoVenda"));

                listaVendas.add(v);
            }
            try {
                pst = conn.prepareStatement(sql2);
                
                while(rs.next()){
                  Venda v2 = new Venda();
                  
                  //v2.getProdutos(rs.getObject("idProduto"));
                  //v2.getServicos(rs.getObject("idServico"));
                  
                }

            } 
            catch (Exception ex) {
                return null;
            } 
            finally {
                 if (pst != null && !pst.isClosed()) {
                pst.close();
            }

            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
            }
        } 
        catch (Exception ex) {
            return null;
        } 
        finally {
            if (pst != null && !pst.isClosed()) {
                pst.close();
            }

            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
        return null;

    }
    
    public static Venda obterVenda(int id) throws SQLException{
        return null;
    }
}
