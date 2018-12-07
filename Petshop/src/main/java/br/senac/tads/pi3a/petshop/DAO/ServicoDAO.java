/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.DAO;

import br.senac.tads.pi3a.petshop.Modelos.Filial;
import br.senac.tads.pi3a.petshop.Modelos.Servico;
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
public class ServicoDAO {
    
    public static void inserir(Servico s) throws SQLException, Exception{
        String sql = "INSERT INTO Servico (descricao, preco, tamanho_animal, idFilial) "
                + "VALUES (?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, s.getDescricao());
            pst.setBigDecimal(2, s.getPreco());
            pst.setInt(3, s.getTamanhoAnimal());
            pst.setInt(4, s.getFilial().getId());
            
            pst.execute();
        }
        finally{
            if(pst != null && !pst.isClosed())
                pst.close();
            
            if(conn != null && !conn.isClosed())
                conn.close();
        }
    }
    
    public static void alterar(Servico s) throws SQLException, ClassNotFoundException{
        String sql = "UPDATE Servico SET descricao = ?, preco = ?, tamanho_animal = ?, idFilial = ? "
                + "WHERE idServico = ?";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, s.getDescricao());
            pst.setBigDecimal(2, s.getPreco());
            pst.setInt(3, s.getTamanhoAnimal());
            
            pst.setInt(4, s.getFilial().getId());
            
            pst.setInt(5, s.getId());
            
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
        String sql = "DELETE FROM servico WHERE idServico = ?"; 
        
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
    
    public static List<Servico> listar(String filtro) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM servico ";
         if(filtro.length() > 0)
                {sql = sql +"WHERE " + filtro;}
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        List<Servico> listaServico = new LinkedList<Servico>();
        
        try{
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                Servico s = new Servico();
                
                s.setId(rs.getInt("idServico"));
                s.setDescricao(rs.getString("descricao"));
                s.setPreco(rs.getBigDecimal("preco"));
                s.setTamanhoAnimal(rs.getInt("tamanho_animal"));
                
                Filial f = new Filial();
                f = FilialDAO.obterFilial(rs.getInt("idFilial"));
                s.setFilial(f);
                
                listaServico.add(s);
                

            }
            
            return listaServico;
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
    
    public static Servico obterServico(int id) throws SQLException{
        String sql = "SELECT * FROM Servico WHERE idServico = ?";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                Servico s = new Servico();
                
                s.setId(rs.getInt("idServico"));
                s.setDescricao(rs.getString("descricao"));
                s.setPreco(rs.getBigDecimal("preco"));
                s.setTamanhoAnimal(rs.getInt("tamanho_animal"));
                
                Filial f = new Filial();
                f = FilialDAO.obterFilial(rs.getInt("idFilial"));
                s.setFilial(f);
                
                return s;
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
