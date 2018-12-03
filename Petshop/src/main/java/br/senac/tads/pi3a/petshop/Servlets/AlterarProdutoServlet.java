<<<<<<< HEAD
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
>>>>>>> Marcos
package br.senac.tads.pi3a.petshop.Servlets;

import br.senac.tads.pi3a.petshop.BLL.ProdutoBLL;
import br.senac.tads.pi3a.petshop.Modelos.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD

=======
/**
 *
 * @author Marcos
 */
@WebServlet(name = "AlterarProdutoServlet", urlPatterns = {"/AlterarProdutoServlet"})
>>>>>>> Marcos
public class AlterarProdutoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       int id = Integer.parseInt(request.getParameter("id"));
       
       Produto p = null;
       List<Produto> produtos = null;
       
       try{
<<<<<<< HEAD
           p = ProdutoBLL.ObterProduto(id);
           produtos = ProdutoBLL.listar();
       }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    } 

}
=======
           p = ProdutoBLL.obterProduto(id);
           produtos = ProdutoBLL.listar("");
       }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            int id = Integer.parseInt(request.getParameter("id"));
        Produto p = null;
        List<Produto> produtos = null;
        
        try{
            p = ProdutoBLL.obterProduto(id); //Com isso, obtemos novamente o cliente para que seja realizado de fato a alteração de seu cadastro
            
            //É feito o armazenamento dos dados que foram preenchidos no formulário, da mesma forma que foi feito no servlet ClienteServlet
                p.setNome(request.getParameter("nome"));
                p.setPreco(BigDecimal.valueOf(Double.parseDouble(request.getParameter("preco"))));
                p.setFabricante(request.getParameter("fabricante"));
                p.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                p.setModelo(request.getParameter("modelo"));
                p.setCodBarras(Integer.parseInt(request.getParameter("codbarras")));

            
            //Depois de armazenar os novos dados do cliente, é chamado o método de validação alterar().
            //Esse método, por sua vez, chama o método responsável por realizar a alteração no banco de dados (caso todos os dados estejam válidos)
            ProdutoBLL.alterar(p);
            
            produtos = ProdutoBLL.listar("");
            request.setAttribute("produtos", produtos);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/produtos.jsp");
        dispatcher.forward(request, response);
    }

}



>>>>>>> Marcos
