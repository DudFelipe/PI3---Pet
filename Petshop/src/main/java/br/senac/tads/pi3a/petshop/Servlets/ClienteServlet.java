/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.Servlets;

import br.senac.tads.pi3a.petshop.BLL.ClienteBLL;
import br.senac.tads.pi3a.petshop.Modelos.Cliente;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dud Felipe
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/cliente.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Cliente c = new Cliente();
        
        c.setNome(request.getParameter("nome"));
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            c.setDtNascimento(sdf.parse(request.getParameter("dtnascimento")));
        } catch (ParseException ex) {
            
        }
        
        c.setCpf(request.getParameter("cpf"));
        c.setRg(request.getParameter("rg"));
        c.setTelefone(request.getParameter("telefone"));
        c.setEmail(request.getParameter("email"));
        c.setSexo(request.getParameter("sexo").charAt(0));
        
        try{
            ClienteBLL.inserir(c);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/cliente.jsp");
        dispatcher.forward(request, response);
    }
}
