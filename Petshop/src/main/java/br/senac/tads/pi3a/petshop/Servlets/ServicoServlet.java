package br.senac.tads.pi3a.petshop.Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.senac.tads.pi3a.petshop.BLL.ServicoBLL;
import br.senac.tads.pi3a.petshop.Modelos.Servico;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
 * @author Dud Felipe
 */
@WebServlet(name = "ServicoServlet", urlPatterns = {"/ServicoServlet"})
public class ServicoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        boolean manutencao = false;
        
        List<Servico> servicos = null;
        try{
            servicos = ServicoBLL.listar();
        }
        catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
        
        request.setAttribute("manutencao", manutencao);
        request.setAttribute("servicos", servicos);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/servicos.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Servico s = new Servico();
        
        s.setDescricao(request.getParameter("descricao"));
        s.setPreco(new BigDecimal(request.getParameter("preco")));
        s.setTamanhoAnimal(Integer.parseInt(request.getParameter("tamanho")));
        
        try{
            ServicoBLL.inserir(s);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/servicos.jsp");
        dispatcher.forward(request, response);
    }
}
