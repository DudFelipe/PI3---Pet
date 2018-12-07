package br.senac.tads.pi3a.petshop.filtro;

import br.senac.tads.pi3a.petshop.Modelos.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter(filterName = "AutorizacaoFilter", servletNames = { "ClienteServlet", "RelatoriosServlet", "VendaServlet", "ServicoServlet", "ProdutoServlet" }, 
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
        
        // Verifica se o usuário possui o papel para acessar funcionalidade.
        //Usuario usuario = (Usuario) sessao.getAttribute("usuario");
        
        Usuario usuario = (Usuario) sessao.getAttribute("usuario");
        
        if (validaAcesso(usuario, httpRequest, httpResponse)) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/erro-nao-autorizado.jsp");
        }
        

    }
    
    private boolean validaAcesso(Usuario usuario, HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String pagina = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
        int tipoAcesso = usuario.getTipoAcesso();
        
        if(tipoAcesso == 1) 
            return false;
        
       if(pagina.equals("RelatoriosServlet")) {
            if(tipoAcesso == 2) {
                return false;
            }
        } else if(pagina.equals("VendaServlet")) {
            if(tipoAcesso >= 5) {
                return false;
            }
        } else if(pagina.equals("ServicoServlet")) {
            if(tipoAcesso == 2 || tipoAcesso == 5 || tipoAcesso == 7) {
                return false;
            }
        } else if(pagina.equals("ProdutoServlet")) {
            if(tipoAcesso == 2 || tipoAcesso == 5 || tipoAcesso == 7) {
                return false;
            }
        } else if(pagina.equals("PetsServlet")) {
            if(tipoAcesso >= 5) {
                return false;
            }
        } else if(pagina.equals("ClienteServlet")) {
            if(tipoAcesso >= 5) {
                return false;
            }
        }
       
        return true;
        
        
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
