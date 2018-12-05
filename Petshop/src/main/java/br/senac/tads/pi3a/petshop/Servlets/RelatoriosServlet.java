/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.Servlets;

import br.senac.tads.pi3a.petshop.BLL.ClienteBLL;
import br.senac.tads.pi3a.petshop.BLL.RelatorioBLL;
import br.senac.tads.pi3a.petshop.Modelos.Cliente;
import br.senac.tads.pi3a.petshop.Modelos.Relatorio;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author giovanebarreira
 */
@WebServlet(name = "RelatoriosServlet", urlPatterns = {"/RelatoriosServlet"})
public class RelatoriosServlet extends HttpServlet {


     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int filtro = 7;
        if(request.getParameter("filtro") != null) {
            filtro = Integer.parseInt(request.getParameter("filtro").toString());
        }

        
          List<Relatorio> relatorio = null; 
        try{
            relatorio = RelatorioBLL.listar(filtro); 
        }
        catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
        
        request.setAttribute("relatorio", relatorio);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/relatorio.jsp");
        dispatcher.forward(request, response);

    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


}
