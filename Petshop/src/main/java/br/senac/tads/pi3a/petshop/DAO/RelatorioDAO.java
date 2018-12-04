/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.DAO;

import br.senac.tads.pi3a.petshop.Modelos.Cliente;
import br.senac.tads.pi3a.petshop.Modelos.Funcionario;
import br.senac.tads.pi3a.petshop.Modelos.Pet;
import br.senac.tads.pi3a.petshop.Modelos.Relatorio;
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
 * @author giovanebarreira
 */
public class RelatorioDAO {
   
    
    public static List<Relatorio> listar(int filtro) throws SQLException, ClassNotFoundException{
        
        String sql = "SELECT * FROM pedido where data >= (curdate() - INTERVAL " + filtro + " day)";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        List<Relatorio> listaRelatorio = new LinkedList<Relatorio>();
        
        try{
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Relatorio r = new Relatorio();
                
                r.setIdPedido(rs.getInt("idPedido"));
                
                int idCliente = rs.getInt("idCliente");
                int idFuncionario = rs.getInt("idFuncionario");
                
                Cliente c = ClienteDAO.obterCliente(idCliente);
                Funcionario f = ClienteDAO.obterFuncionario(idFuncionario);
                
                r.setCliente(c);
                r.setFuncionario(f);
                r.setIdTipoPagamento(rs.getInt("idTipoPagamento"));
                r.setIdFilial(rs.getInt("idFilial"));
                r.setData(rs.getDate("data"));
                r.setPrecovenda(rs.getDouble("precoVenda"));
                
   
                listaRelatorio.add(r);
            }
            
            return listaRelatorio;
        }
        catch(Exception ex){
            return null;
        }
        finally{
            if(pst != null && !pst.isClosed())
                pst.close();
            
            if(conn != null && !conn.isClosed())
                conn.close();
        }
    }
    

}
