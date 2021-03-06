/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.DAO;

import br.senac.tads.pi3a.petshop.Modelos.Cliente;
import br.senac.tads.pi3a.petshop.Modelos.Filial;
import br.senac.tads.pi3a.petshop.Modelos.Pet;
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
public class FilialDAO {

    
    public static List<Filial> listar() throws SQLException, ClassNotFoundException{
        
        String sql = "SELECT * FROM filiais";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        List<Filial> listaFiliais = new LinkedList<Filial>();
        
        try{
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Filial f = new Filial();
                
                f.setId(rs.getInt("idfiliais"));
                f.setCidade(rs.getString("cidade"));               
               
                Cliente c = new Cliente();
                c = ClienteDAO.obterCliente(rs.getInt("idGerente"));  
                f.setGerente(c);
                
                listaFiliais.add(f);
            }
            
            return listaFiliais;
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
    
    public static Filial obterFilial(int id) throws SQLException{
        
        String sql = "SELECT * FROM filiais WHERE idfiliais = ?";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                Filial f = new Filial();
                
                f.setId(id);
                f.setCidade(rs.getString("cidade"));
                
               
                Cliente c = new Cliente();
                c = ClienteDAO.obterCliente(rs.getInt("idGerente"));

                
                return f;
            }
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
        return null;
    }
}
