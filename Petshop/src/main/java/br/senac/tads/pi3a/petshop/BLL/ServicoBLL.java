/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.BLL;

import br.senac.tads.pi3a.petshop.DAO.ServicoDAO;
import br.senac.tads.pi3a.petshop.Modelos.Servico;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dud Felipe
 */
public class ServicoBLL {
    public static void inserir(Servico s) throws Exception{
        
        if(s.getDescricao().trim().length() == 0){
            throw new Exception("A descrição deve ser preenchido!");
        }
        
        ServicoDAO.inserir(s);
    }
    
    public static void alterar(Servico s) throws Exception{
        if(s.getDescricao().trim().length() == 0){
            throw new Exception("A descrição deve ser preenchido!");
        }
        
        ServicoDAO.alterar(s); 
    }
    
    public static void excluir(int id) throws SQLException, ClassNotFoundException{
        ServicoDAO.excluir(id);
    }
    
    public static List<Servico> listar() throws SQLException, ClassNotFoundException{
        return ServicoDAO.listar();
    }
    
    public static Servico obterServico(int id) throws SQLException{
        return ServicoDAO.obterServico(id);
    }
}
