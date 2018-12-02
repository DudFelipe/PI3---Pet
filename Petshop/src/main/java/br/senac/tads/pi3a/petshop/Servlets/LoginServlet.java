/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.Servlets;

import br.senac.tads.pi3a.petshop.Modelos.Usuario;
import br.senac.tads.pi3a.petshop.Utils.UsuarioSistemaService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String code = request.getParameter("code");
        if ("99".equals(code)) {
            request.setAttribute("msgErro", "Vc saiu do sistema");
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/jsp/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String senhaAberta = request.getParameter("senha");

        UsuarioSistemaService service = new UsuarioSistemaService();

        Usuario usuario = null;
        try {
            usuario = service.buscarPorEmail(email);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (usuario != null) {
            if (usuario.getSenha() == null ? senhaAberta == null : usuario.getSenha().equals(senhaAberta)) {
                // Login com sucesso.
                HttpSession sessao = request.getSession();
                sessao.setAttribute("usuario", usuario);
                response.sendRedirect(request.getContextPath() + "/VendaServlet");
                return;
            }
        }

        request.setAttribute("msgErro", "Usuário ou senha inválido");
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/login.jsp");
        dispatcher.forward(request, response);
    }
}
