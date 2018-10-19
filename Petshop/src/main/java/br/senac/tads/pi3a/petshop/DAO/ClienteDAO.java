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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Dud Felipe
 */
public class ClienteDAO {
    //A classe ClienteDAO é responsável por realizar as operações no banco de dados
    //Como todas as validações relativas aos dados inseridos na hora do cadastro já foram feitas
    //não é necessário realiza-las novamente aqui.
    
    //Método inserir.
    //Responsável por inserir um novo cliente no banco de dados
    public static void inserir(Cliente c) throws SQLException, Exception{
        //Comando de inserção no banco de dados, com alguns parâmetros a serem preparados
        String sql = "INSERT INTO Clientes (Nome, DtNascimento, CPF, RG, Telefone, Email, Sexo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = ConnectionUtils.getConnection(); //Realiza a conexão com o banco de dados
            pst = conn.prepareStatement(sql); //Cria o PreparedStatement para que seja possível definir os parâmetros do INSERT
            
            //Preparando todos os parâmetros do método INSERT na ordem em que foram definidos na query
            pst.setString(1, c.getNome());
            
            Timestamp t = new Timestamp(c.getDtNascimento().getTime());
            pst.setTimestamp(2, t);
            
            pst.setString(3, c.getCpf());
            pst.setString(4, c.getRg());
            pst.setString(5, c.getTelefone());
            pst.setString(6, c.getEmail());
            pst.setString(7, c.getSexo() + "");
            
            pst.execute(); //Executando a query e realizando a inserção no banco de dados.
        }
        finally{
            if(pst != null && !pst.isClosed())
                pst.close(); //Caso o preparedStatement não esteja nullo e nem fechado, estamos fechando agora no final.
            
            if(conn != null && !conn.isClosed())
                conn.close(); //Mesma coisa para a conexão
        }
    }
    
    //Método alterar
    //Responsável por realizar a alteração dos dados de um determinado cliente
    public static void alterar(Cliente c) throws SQLException, ClassNotFoundException{
        //Comando de UPDATE no banco de dados com alguns parâmetros que irão receber os novos valores.
        String sql = "UPDATE Clientes SET Nome = ?, DtNascimento = ?, CPF = ?, RG = ?, Telefone = ?, Email = ?, Sexo = ? "
                + "WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = ConnectionUtils.getConnection(); //Abrindo conexão com o banco de dados
            pst = conn.prepareStatement(sql); //Cria o PreparedStatement para que seja possível definir os parâmetros do UPDATE
            
            //Preparando todos os parâmetros do comando UPDATE definido anteriormente
            pst.setString(1, c.getNome());
            
            Timestamp t = new Timestamp(c.getDtNascimento().getTime());
            pst.setTimestamp(2, t);
            
            pst.setString(3, c.getCpf());
            pst.setString(4, c.getRg());
            pst.setString(5, c.getTelefone());
            pst.setString(6, c.getEmail());
            pst.setString(7, c.getSexo() + "");
            
            pst.setInt(8, c.getId());
            
            pst.execute(); //Executando a instrução SQL e realizando a alteração dos dados
        }
        finally{
            if(pst != null && !pst.isClosed())
                pst.close(); //Caso o preparedStatement não esteja nullo e nem fechado, estamos fechando agora no final.
            
            if(conn != null && !conn.isClosed())
                conn.close(); //Mesma coisa para a conexão
        }
    }
    
    //Método excluir
    //Responsável por realizar a exclusão de um deterinado cliente
    public static void excluir(int id) throws SQLException, ClassNotFoundException{
        //Comando DELETE do banco de dados para realizar a exclusão de um determinado cliente utilizando o ID do mesmo
        String sql = "DELETE FROM Clientes WHERE id = ?"; 
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = ConnectionUtils.getConnection(); //Abrindo conexão com o banco de dados
            pst = conn.prepareStatement(sql); //Cria o PreparedStatement para que seja possível definir o parâmetro do DELETE
            
            //Preparando todos os parâmetros do comando DELETE definido anteriormente
            pst.setInt(1, id);
            
            pst.execute(); //Executando a instrução SQL e realizando a alteração dos dados
        }
        finally{
            if(pst != null && !pst.isClosed())
                pst.close(); //Caso o preparedStatement não esteja nullo e nem fechado, estamos fechando agora no final.
            
            if(conn != null && !conn.isClosed())
                conn.close(); //Mesma coisa para a conexão
        }
    }
    
    //Método listar
    //Responsável por resgatar todos os clientes cadastrados e retornar uma lista com os mesmos
    public static List<Cliente> listar() throws SQLException, ClassNotFoundException{
        //Comando SELECT para retornar todos os dados de todos os clientes
        String sql = "SELECT * FROM Clientes";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        List<Cliente> listaCliente = new LinkedList<Cliente>(); //Lista de cliente que será retornada ao final do método
        
        try{
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery(); //Executando o comando SELECT e armazenando os dados em um ResultSet
            
            while(rs.next()){ //Enquanto houver registro no ResultSet, criar um cliente e adiciona-lo na lista
                Cliente c = new Cliente(); //Cria um novo cliente
                
                //Armazenando os dados do cliente contidos no ResultSet.
                //Para isso, estamos utilizando os métodos set..() da classe Cliente e os métodos get... do ResultSet passando o nome do campo no banco de dados
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("Nome"));
                c.setDtNascimento(rs.getDate("DtNascimento"));
                c.setCpf(rs.getString("CPF"));
                c.setRg(rs.getString("RG"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                c.setSexo(rs.getString("sexo").charAt(0));
                
                listaCliente.add(c); //Com todos os dados do cliente armazenado, adiciona o cliente na lista.
            }
            
            return listaCliente; //Depois que todos os clientes estiverem na lista, retorna a lista
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
    
    //Método obterCliente
    //Responsável por retornar os dados de um cliente específico
    public static Cliente obterCliente(int id) throws SQLException{
        //Comando SELECT responsável por selecionar os dados de um determinado cliente filtrado pelo seu ID
        String sql = "SELECT * FROM Clientes WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = ConnectionUtils.getConnection();
            pst = conn.prepareStatement(sql);
            
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){ //Caso exista algum registro no ResultSet
                Cliente c = new Cliente(); //Cria um novo cliente
                
                //Armazena seus dados, da mesma forma que foi feito no método listar()
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("Nome"));
                c.setDtNascimento(rs.getDate("DtNascimento"));
                c.setCpf(rs.getString("CPF"));
                c.setRg(rs.getString("RG"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                c.setSexo(rs.getString("sexo").charAt(0));
                
                return c; //Retorna esse cliente depois de armazenar seus dados
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
