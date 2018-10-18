/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.DAO;

import br.senac.tads.pi3a.petshop.Modelos.Cliente;
import br.senac.tads.pi3a.petshop.Utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Dud Felipe
 */
public class ClienteDAO {
    public static void inserir(Cliente c) throws SQLException, Exception{
        String sql = "INSERT INTO Clientes (Nome, DtNascimento, CPF, RG, Telefone, Email, Sexo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, c.getNome());
            
            Timestamp t = new Timestamp(c.getDtNascimento().getTime());
            pst.setTimestamp(2, t);
            
            pst.setString(3, c.getCpf());
            pst.setString(4, c.getRg());
            pst.setString(5, c.getTelefone());
            pst.setString(6, c.getEmail());
            pst.setString(7, c.getSexo() + "");
            
            pst.execute();
        }
        finally{
            if(pst != null && !pst.isClosed())
                pst.close();
            
            if(conn != null && !conn.isClosed())
                conn.close();
        }
    }
    
    public static void alterar(Cliente c){
        
    }
    
    public static void excluir(int id){
        
    }
    
    public static void listar(String filtro){
        
    }
}
