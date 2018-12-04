///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.senac.tads.pi3a.petshop.Servlets;
//
//import br.senac.tads.pi3a.petshop.BLL.ProdutoBLL;
//import br.senac.tads.pi3a.petshop.BLL.ServicoBLL;
//import br.senac.tads.pi3a.petshop.DAO.ClienteDAO;
//import br.senac.tads.pi3a.petshop.DAO.ProdutoDAO;
//import br.senac.tads.pi3a.petshop.DAO.ServicoDAO;
//import br.senac.tads.pi3a.petshop.DAO.VendaDAO;
//import br.senac.tads.pi3a.petshop.Modelos.Cliente;
//import br.senac.tads.pi3a.petshop.Modelos.Produto;
//import br.senac.tads.pi3a.petshop.Modelos.Servico;
//import br.senac.tads.pi3a.petshop.Modelos.Usuario;
//import br.senac.tads.pi3a.petshop.Modelos.Venda;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.sql.SQLException;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//
//@WebServlet(name = "VendaServlet", urlPatterns = {"/VendaServlet"})
//public class VendaServlet extends HttpServlet {
//    
//    
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException{
//        //listando produtos para a venda
//        List<Servico> servicos = null;
//        
//        try {
//            servicos = ServicoDAO.listar();
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        request.setAttribute("servicos", servicos);
//         
//        //Listando clientes
//        List<Cliente> clientes =null;
//              try {
//            clientes = ClienteDAO.listar(true);
//        } catch (ClassNotFoundException | SQLException ex) {
//        }
//        request.setAttribute("clientes", clientes);
//        
//        
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/vendas.jsp");
//        dispatcher.forward(request, response);
//        
//    }
//    
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//     
//        Venda v = new Venda();
//        List<Servico> listaServico = new LinkedList<Servico>();
//        
//        int idCliente = Integer.parseInt(request.getParameter("cliente"));
//        Float valor_venda = Float.parseFloat(request.getParameter("valor_venda"));
//        String produtos = request.getParameter("produtos");
//        
//        JSONObject obj = new JSONObject(produtos);
//        JSONArray arr = obj.getJSONArray("venda");
//        
//        for (int i = 0; i < arr.length(); i++)
//        {
//            
//            if(arr.getJSONObject(i).getString("tipo").equals("Serviço")) {
//                Servico s = new Servico();
//                try {
//                    s = ServicoDAO.obterServico(Integer.parseInt(arr.getJSONObject(i).getString("id")));
//                } catch (SQLException ex) {
//                    Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                s.setQuantidade_comprada(arr.getJSONObject(i).getInt("qtd"));
//                
//                listaServico.add(s);
//            } else {
//                //Produto
//            }
//            
//            
//        
//        }
//        
//        Cliente c = new Cliente();
//        try {
//            c = ClienteDAO.obterCliente(idCliente);
//        } catch (SQLException ex) {
//            Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        v.setCliente(c);
//        
//        //v.setValorTotal(valor_venda);
//        
//        HttpSession sessao = request.getSession();
//        Usuario logado = (Usuario) sessao.getAttribute("usuario");
//        
//        v.setFuncionario(logado);
//        v.setServicos(listaServico);
//        
//        try {
//            VendaDAO.inserir(v);
//          
//        } catch (Exception ex) {
//            Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//      
//    }
//}
