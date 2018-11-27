//<<<<<<< HEAD
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.senac.tads.pi3a.petshop.Servlets;
//
//import br.senac.tads.pi3a.petshop.BLL.ProdutoBLL;
//import br.senac.tads.pi3a.petshop.Modelos.Produto;
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author Marcos
// */
//
//public class AlterarProdutoServlet extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
//       int id = Integer.parseInt(request.getParameter("id"));
//       
//       Produto p = null;
//       List<Produto> produtos = null;
//       
//       try{
//           p = ProdutoBLL.ObterProduto(id);
//           produtos = ProdutoBLL.listar();
//       }
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
//=======
//package br.senac.tads.pi3a.petshop.Servlets;
//>>>>>>> Diogo
//
//import br.senac.tads.pi3a.petshop.BLL.ProdutoBLL;
//import br.senac.tads.pi3a.petshop.Modelos.Produto;
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//public class AlterarProdutoServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
//       int id = Integer.parseInt(request.getParameter("id"));
//       
//       Produto p = null;
//       List<Produto> produtos = null;
//       
//       try{
//           p = ProdutoBLL.ObterProduto(id);
//           produtos = ProdutoBLL.listar();
//       }
//    }
//
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    } </editor-fold>
//
//<<<<<<< HEAD
//}
//=======
//}
//>>>>>>> Diogo
