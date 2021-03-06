/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.Servlets;

import br.senac.tads.pi3a.petshop.BLL.ClienteBLL;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ExcluirClienteServlet", urlPatterns = {"/ExcluirClienteServlet"})
public class ExcluirClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        //Na hora da listagem dos clientes, caso o usuário pressione o link 'Excluir', o processamento será enviado
        //para esse método.
        
        //Primeiro devemos armazenar o ID do cliente que desejamos remover para que seja utilizado na consulta SQL.
        int id = Integer.parseInt(request.getParameter("id"));
        
        try{
            //Com o ID correto armazenado, o método excluir() é chamado para que seja feita a exclusão desse cliente.
            ClienteBLL.excluir(id);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        //Quando a exclusão é finalizada, o usuário será redirecionado para a página de cadastro.
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ClienteServlet");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }
}
