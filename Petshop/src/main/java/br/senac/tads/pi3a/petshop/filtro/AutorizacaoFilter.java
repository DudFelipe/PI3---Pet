package br.senac.tads.pi3a.petshop.filtro;

import br.senac.tads.pi3a.petshop.Modelos.Cliente;
import br.senac.tads.pi3a.petshop.Modelos.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter(filterName = "AutorizacaoFilter", servletNames = { "ClienteServlet" }, 
        urlPatterns = { "/protegido/*" })
public class AutorizacaoFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        // CAST para objetos do tipo HttpServlet*
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Verifica se usuario ja esta logado
        HttpSession sessao = httpRequest.getSession();
        if (sessao.getAttribute("usuario") == null) {
            // Redirecionar para tela de login
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }
        
        chain.doFilter(request, response);
        // Verifica se o usuário possui o papel para acessar funcionalidade.
        Cliente usuario = (Cliente) sessao.getAttribute("usuario");
        
        if (redirecionaLogin(usuario, httpRequest, httpResponse)) {
            // Requisicao pode seguir para o Servlet
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/erro-nao-autorizado.jsp");
        }

    }

    private boolean redirecionaLogin(Cliente usuario, 
            HttpServletRequest request,
            HttpServletResponse response)throws ServletException, IOException {
        String pagina = request.getRequestURI();
        
        //Se usuario tipo RH, redireciona
        if(usuario.getTipoAcesso()==7){
            RequestDispatcher dispatcher
            = request.getRequestDispatcher(
                        "/WEB-INF/jsp/cliente.jsp");
        dispatcher.forward(request, response);
        }
        
        //Se usuario tipo Cliente ou Funcionario Filial
        if(usuario.getTipoAcesso()== 1 || usuario.getTipoAcesso()==2){
           RequestDispatcher dispatcher
            = request.getRequestDispatcher(
                        "/WEB-INF/jsp/vendas.jsp");
        dispatcher.forward(request, response); 
        }
        
        //Se usuario tipo TI ou Gerente Geral oou Gerente Filial
        if(usuario.getTipoAcesso()==5 || usuario.getTipoAcesso()==4
                || usuario.getTipoAcesso()==3){
            RequestDispatcher dispatcher
            = request.getRequestDispatcher(
                        "/WEB-INF/jsp/relatorio.jsp");
        dispatcher.forward(request, response);
        }
        
        
        return false;
        
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
