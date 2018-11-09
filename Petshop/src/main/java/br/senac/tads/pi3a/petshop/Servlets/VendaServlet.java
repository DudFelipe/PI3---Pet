/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.Servlets;

import br.senac.tads.pi3a.petshop.BLL.ProdutoBLL;
import br.senac.tads.pi3a.petshop.BLL.ServicoBLL;
import br.senac.tads.pi3a.petshop.Modelos.Cliente;
import br.senac.tads.pi3a.petshop.Modelos.Produto;
import br.senac.tads.pi3a.petshop.Modelos.Servico;
import br.senac.tads.pi3a.petshop.Modelos.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vyvis
 */
@WebServlet(name = "VendaServlet", urlPatterns = {"/VendaServlet"})
public class VendaServlet extends HttpServlet {
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse responde)
            throws ServletException, IOException{
        List<Produto> produtos=null;
        List<Servico> servicos=null;
        
        try {
            servicos = ServicoBLL.listar();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        
        request.setAttribute("servicos", servicos);
        
        
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       Venda v = new Venda();
       List<Venda> venda= null;
       List<Cliente> cliente = null;
       List<Produto> produto = null;
       List<Servico> servico = null;
       
       
       
     
       
       
       
    }

}
