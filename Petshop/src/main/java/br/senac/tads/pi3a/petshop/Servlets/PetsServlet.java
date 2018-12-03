package br.senac.tads.pi3a.petshop.Servlets;

import br.senac.tads.pi3a.petshop.BLL.ClienteBLL;
import br.senac.tads.pi3a.petshop.BLL.PetBLL;
import br.senac.tads.pi3a.petshop.DAO.ClienteDAO;
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

@WebServlet(name = "PetsServlet", urlPatterns = {"/PetsServlet"})
public class PetsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Cliente> clientes = null;
        List<Pet> pets = null;
        
        try {
            clientes = ClienteDAO.listar(true);
            pets = PetBLL.listar();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        request.setAttribute("clientes", clientes);
        request.setAttribute("pets", pets);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/pets.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Pet p = new Pet();
        List<Pet> listaPets = null;
        List<Cliente> listaClientes = null;

        Cliente c = new Cliente();

        try {
            c = ClienteBLL.obterCliente(Integer.parseInt(request.getParameter("dono")));
            
            p.setIdCliente(c);
            p.setNome(request.getParameter("nomepet"));
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            p.setNascimento(sdf.parse(request.getParameter("nascimento")));
            
            p.setEspecie(request.getParameter("especie"));
            p.setPorte("tamanhoanimal");
            
            listaPets = PetBLL.listar();
            listaClientes = ClienteBLL.listar();
            
            PetBLL.inserir(p);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        request.setAttribute("pets", listaPets);
        request.setAttribute("clientes", listaClientes);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/pets.jsp");
        dispatcher.forward(request, response);
    }
}
