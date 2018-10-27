/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.petshop.Servlets;

import br.senac.tads.pi3a.petshop.BLL.ClienteBLL;
import br.senac.tads.pi3a.petshop.Modelos.Cliente;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
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
@WebServlet(name = "AlterarClienteServlet", urlPatterns = {"/AlterarClienteServlet"})
public class AlterarClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //No momento que o usuário pressionar em "Alterar" na hora da listagem dos clientes,
        //o processamento será enviado para esse método.
        
        //Ao clicar em "Alterar", o valor do ID do cliente está sendo enviado como um parâmetro via URL.
        //Sendo assim, é possível utilizar o método request.getParameter() para armazenar esse valor para
        //futuramente realizar a buscar do cliente correto e realizar a alteração no cadastro
        int id = Integer.parseInt(request.getParameter("id"));
        
        boolean manutencao = false; //Como não deve ser exibida a listagem dos dados, passamos a flag para falso
        
        Cliente c = null;
        List<Cliente> clientes = null;
        
        try{
            c = ClienteBLL.obterCliente(id); //O cliente é obtido através do método obterCliente(), passando o ID resgatado por parâmetro
            clientes = ClienteBLL.listar();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        //Com os dados do cliente em mãos, podemos enviá-lo como atributo para a página cliente.jsp para que seja feita a alteração do seu cadastro
        request.setAttribute("cliente", c);
        request.setAttribute("manutencao", manutencao);
        request.setAttribute("clientes", clientes);
        
        //Caso não ocorra nenhum erro, a página cliente.jsp deve ser exibida com o formulário preenchido com os dados atuais do cliente
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/cliente.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        //Com a alteração do cadastro realizada, o processamento será enviado para esse método.
        
        //A primeira coisa que deve ser feita é armazenar novamente o ID do cliente que foi alterado
        int id = Integer.parseInt(request.getParameter("id"));
        Cliente c = null;
        List<Cliente> clientes = null;
        
        try{
            c = ClienteBLL.obterCliente(id); //Com isso, obtemos novamente o cliente para que seja realizado de fato a alteração de seu cadastro
            
            //É feito o armazenamento dos dados que foram preenchidos no formulário, da mesma forma que foi feito no servlet ClienteServlet
            c.setNome(request.getParameter("nome"));
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            c.setDtNascimento(sdf.parse(request.getParameter("dtnascimento")));
            
            c.setCpf(request.getParameter("cpf"));
            c.setSexo(request.getParameter("sexo").charAt(0));
            c.setRg(request.getParameter("rg"));
            c.setTelefone(request.getParameter("telefone"));
            c.setEmail(request.getParameter("email"));
            c.setEndereco(request.getParameter("endereco"));
            c.setSenha(request.getParameter("senha"));
            c.setTipoAcesso(Integer.parseInt(request.getParameter("tipoacesso")));
            
            //Depois de armazenar os novos dados do cliente, é chamado o método de validação alterar().
            //Esse método, por sua vez, chama o método responsável por realizar a alteração no banco de dados (caso todos os dados estejam válidos)
            ClienteBLL.alterar(c);
            
            clientes = ClienteBLL.listar();
            request.setAttribute("clientes", clientes);
            
            //Por fim, a página cliente.jsp é apresentada novamente ao usuário.
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/cliente.jsp");
            dispatcher.forward(request, response);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
