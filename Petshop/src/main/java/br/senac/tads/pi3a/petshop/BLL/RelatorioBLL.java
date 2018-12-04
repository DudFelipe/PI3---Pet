/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.BLL;

import br.senac.tads.pi3a.petshop.DAO.RelatorioDAO;
import br.senac.tads.pi3a.petshop.Modelos.Relatorio;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author giovanebarreira
 */
public class RelatorioBLL {
    
    
    public static List<Relatorio> listar(int filtro)throws SQLException, ClassNotFoundException{
        return RelatorioDAO.listar(filtro);
    }
    
}
