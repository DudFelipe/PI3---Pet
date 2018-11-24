package br.senac.tads.pi3a.petshop.Servlets;

import br.senac.tads.pi3a.petshop.BLL.ClienteBLL;
import br.senac.tads.pi3a.petshop.BLL.PetBLL;
import br.senac.tads.pi3a.petshop.Modelos.Cliente;
import br.senac.tads.pi3a.petshop.Modelos.Pet;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlterarPetServlet", urlPatterns = {"/AlterarPetServlet"})
public class AlterarPetServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        Pet p = new Pet();
        List<Pet> listaPets = null;
        List<Cliente> listaClientes = null;
        
        try{
            p = PetBLL.obterPet(id);
            
            listaPets = PetBLL.listar();
            listaClientes = ClienteBLL.listar();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        request.setAttribute("pet", p);
        request.setAttribute("pets", listaPets);
        request.setAttribute("clientes", listaClientes);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/pets.jsp");
        dispatcher.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        Pet p = new Pet();
        List<Pet> listaPets = null;
        List<Cliente> listaClientes = null;
        
        try{
            p = PetBLL.obterPet(id);
            
            
            Cliente c = new Cliente();
            c = ClienteBLL.obterCliente(Integer.parseInt(request.getParameter("dono")));
            p.setIdCliente(c);
            
            p.setNome(request.getParameter("nomepet"));
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            p.setNascimento(sdf.parse(request.getParameter("nascimento")));
            
            p.setEspecie(request.getParameter("especie"));
            p.setPorte(request.getParameter("tamanhoanimal"));
            
            PetBLL.alterar(p);
            
            listaPets = PetBLL.listar();
            listaClientes = ClienteBLL.listar();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
     
        request.setAttribute("pet", p);
        request.setAttribute("pets", listaPets);
        request.setAttribute("clientes", listaClientes);
        
        response.sendRedirect(request.getContextPath() + "/PetsServlet");
        
    }
}
