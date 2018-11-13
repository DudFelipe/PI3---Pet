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
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Dud Felipe
 */
public class VendaDAO {

    public static void inserir(Venda v) throws SQLException, Exception {
        String sql = "INSERT INTO pedido (idPedido,idcliente, data, precoVenda, idfuncionario) "
                + " VALUES (?, null, ?, ?, ?, ?, ?, ?, ?, ?);";

        String sql2 = "INSERT NTO detalhes_pedido(idPedido,idProduto,idServico,quantidade,precoProdutos)"
                + "VALUES(?,?,?,?)";

        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setInt(1, v.getPedido());
            pst.setInt(2, v.getCliente().getId());
            Timestamp t = new Timestamp(v.getDataVenda().getTime());
            pst.setTimestamp(3, t);

            pst.setBigDecimal(4, v.getValorTotal());
            pst.setInt(5, v.getFuncionario().getId());

            pst.execute();

            try {
                conn = ConnectionUtils.getConnection();
                pst = conn.prepareStatement(sql2);

                pst.setInt(1, v.getPedido());

                pst.setObject(2, v.getProdutos().get(0));
                pst.setObject(3, v.getServicos().get(0));

                pst.setObject(4, v.getProdutos().get(0));
                pst.setObject(5, v.getServicos().get(0));
            } finally {
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                }

                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            }
        } finally {
            if (pst != null && !pst.isClosed()) {
                pst.close();
            }

            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
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

    public static Venda obterVenda(int id) throws SQLException {
        return null;
    }

}
