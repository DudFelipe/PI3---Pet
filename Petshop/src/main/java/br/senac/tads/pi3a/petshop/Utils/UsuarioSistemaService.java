/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.Utils;

import br.senac.tads.pi3a.petshop.DAO.ClienteDAO;
import br.senac.tads.pi3a.petshop.Modelos.Usuario;
import java.sql.SQLException;

/**
 *
 * @author fernando.tsuda
 */
public class UsuarioSistemaService {


    public Usuario buscarPorEmail(String email) throws SQLException {
        return ClienteDAO.buscarPorEmail(email);
    }
}
