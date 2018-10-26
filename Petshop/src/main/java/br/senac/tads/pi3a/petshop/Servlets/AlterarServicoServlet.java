/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.Servlets;

import br.senac.tads.pi3a.petshop.BLL.ServicoBLL;
import br.senac.tads.pi3a.petshop.Modelos.Servico;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
@WebServlet(name = "AlterarServicoServlet", urlPatterns = {"/AlterarServicoServlet"})
public class AlterarServicoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        boolean manutencao = false;
        
        Servico s = null;
        
        try{
            s = ServicoBLL.obterServico(id);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        request.setAttribute("servico", s);
        request.setAttribute("manutencao", manutencao);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/servicos.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        Servico s = null;
        
        try{
            s = ServicoBLL.obterServico(id);
            
            s.setDescricao(request.getParameter("descricao"));
            s.setPreco(new BigDecimal(request.getParameter("preco")));
            s.setTamanhoAnimal(Integer.parseInt(request.getParameter("tamanho")));
            
            ServicoBLL.alterar(s);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/servicos.jsp");
            dispatcher.forward(request, response);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
