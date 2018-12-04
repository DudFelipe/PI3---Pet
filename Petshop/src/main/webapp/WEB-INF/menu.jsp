<%-- 
    Document   : menu
    Created on : Nov 29, 2018, 6:05:08 PM
    Author     : senacpi3
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav id="sidebar">
                <div class="sidebar-header">
                    <img src="assets/images/logo.png">
                    <strong></strong>
                </div>

                <ul class="list-unstyled components">
                    <p style="text-align: center; color: white">Nome do Funcionário</p>

                    <li <% if( request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1).equals("vendas.jsp")){%> class="active" <%}%> >
                        <a href="VendaServlet">
                            <i class="glyphicon glyphicon-shopping-cart"></i>
                            Vender
                        </a>
                    </li>

                    <li <% if( request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1).equals("produtos.jsp")){%> class="active" <%}%> >
                        <a href="#">
                            <i class="glyphicon glyphicon-heart"></i>
                            Produtos
                        </a>
                    </li>

                    <li <% if( request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1).equals("servicos.jsp")){%> class="active" <%}%> >
                        <a href="ServicoServlet">
                            <i class="glyphicon glyphicon-home"></i>
                            Serviços
                        </a>

                    </li>

                    <li <% if( request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1).equals("cliente.jsp")){%> class="active" <%}%> >
                        <a href="ClienteServlet">
                            <i class="glyphicon glyphicon-user"></i>
                            Clientes 
                        </a>
                    </li>
                    
                    <li <% if( request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1).equals("pets.jsp")){%> class="active" <%}%> >
                        <a href="PetsServlet">
                            <i class="glyphicon glyphicon-star"></i>
                            Pets
                        </a>
                    </li>

                    <li>
                        <a href="#">
                            <i class="glyphicon glyphicon-stats"></i>
                            Relatórios
                        </a>
                    </li>

                    <li>
                        <a href="LogoutServlet">
                            <i class="glyphicon glyphicon-off"></i>
                            Sair
                        </a>
                    </li>
                </ul>
            </nav>
