/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.DAO;

import br.senac.tads.pi3a.petshop.Modelos.Cliente;
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
public class PetDAO {
    public static void inserir(Pet p) throws SQLException, Exception{

        String sql = "INSERT INTO pet (idCliente, nomepet, especie, porte, nascimento) " +
                     " VALUES (?, ?, ?, ?, ?);";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            pst.setInt(1, p.getIdCliente().getId());
            pst.setString(2, p.getNome());
            pst.setString(3, p.getEspecie());
            pst.setString(4, p.getPorte());
            
            Timestamp t = new Timestamp(p.getNascimento().getTime());
            pst.setTimestamp(5, t);
            
            pst.execute();
        }
        finally{
            if(pst != null && !pst.isClosed())
                pst.close();
            
            if(conn != null && !conn.isClosed())
                conn.close();
        }
    }
    
    public static void alterar(Pet p) throws SQLException, ClassNotFoundException{
        
        String sql = "UPDATE pet SET idCliente = ?, nomepet = ?, especie = ?, porte = ?, nascimento = ? "
                + " WHERE idPet = ?"; 

        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
           
            pst.setInt(1, p.getIdCliente().getId());
            pst.setString(2, p.getNome());
            pst.setString(3, p.getEspecie());
            pst.setString(4, p.getPorte());
            
            Timestamp t = new Timestamp(p.getNascimento().getTime());
            pst.setTimestamp(5, t);
            
            pst.setInt(6, p.getId());
            
            pst.execute();
        }
        finally{
            if(pst != null && !pst.isClosed())
                pst.close();
            
            if(conn != null && !conn.isClosed())
                conn.close();
        }
    }

    public static void excluir(int id) throws SQLException, ClassNotFoundException{
        
        String sql = "DELETE FROM pet WHERE idPet = ?"; 
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            pst.setInt(1, id);
            
            pst.execute();
        }
        finally{
            if(pst != null && !pst.isClosed())
                pst.close();
            
            if(conn != null && !conn.isClosed())
                conn.close();
        }
    }
    
    public static List<Pet> listar() throws SQLException, ClassNotFoundException{
        
        String sql = "SELECT * FROM pet";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        List<Pet> listaPet = new LinkedList<Pet>();
        
        try{
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Pet p = new Pet();
                
                p.setId(rs.getInt("idPet"));
                
                Cliente c = new Cliente();
                c = ClienteDAO.obterCliente(rs.getInt("idCliente"));
                p.setIdCliente(c);
                
                p.setNome(rs.getString("nomepet"));
                p.setEspecie(rs.getString("especie"));
                p.setPorte(rs.getString("porte"));
                p.setNascimento(rs.getDate("nascimento"));
                
                listaPet.add(p);
            }
            
            return listaPet;
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
    
    public static Pet obterPet(int id) throws SQLException{
        
        String sql = "SELECT * FROM pet WHERE idPet = ?";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                Pet p = new Pet();
                
                p.setId(rs.getInt("idPet"));
               
                Cliente c = new Cliente();
                c = ClienteDAO.obterCliente(rs.getInt("idCliente"));
                p.setIdCliente(c);
                
                p.setNome(rs.getString("nomepet"));
                p.setEspecie(rs.getString("especie"));
                p.setPorte(rs.getString("porte"));
                p.setNascimento(rs.getDate("nascimento"));
                
                return p;
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
