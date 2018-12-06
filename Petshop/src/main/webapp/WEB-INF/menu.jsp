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
                    
                    <%--Verifica se o usuario tem o tipo de usuario para acessar a pagina vendas --%>
                    <c:choose>
                    <c:when test="${sessionScope.usuario.getTipoAcesso() == 1 ||
                                  sessionScope.usuario.getTipoAcesso() == 2 ||
                          sessionScope.usuario.getTipoAcesso() == 4||
                          sessionScope.usuario.getTipoAcesso() == 5}">
                    <li <% if( request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1).equals("vendas.jsp")){%> class="active" <%}%> >
                        <a href="VendaServlet">
                            <i class="glyphicon glyphicon-shopping-cart"></i>
                            Vender
                        </a>
                    </li>
                    </c:when>
                    <c:otherwise> </c:otherwise>
                    </c:choose>
                    
                    <%--Verifica se o usuario tem o tipo de usuario para acessar a pagina produtos --%>
                    <c:choose>
                    <c:when test="${sessionScope.usuario.getTipoAcesso() == 2 ||
                                  sessionScope.usuario.getTipoAcesso() == 4 ||
                          sessionScope.usuario.getTipoAcesso() == 5||
                          sessionScope.usuario.getTipoAcesso() == 6}">
                    
                    <li <% if( request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1).equals("produtos.jsp")){%> class="active" <%}%> >
                        <a href="#">
                            <i class="glyphicon glyphicon-heart"></i>
                            Produtos
                        </a>
                    </li>
                    </c:when>
                    <c:otherwise></c:otherwise>
                    </c:choose>
                    
                    <%--Verifica se o usuario tem o tipo de usuario para acessar a pagina serviços --%>
                    <c:choose>
                    <c:when test="${sessionScope.usuario.getTipoAcesso() == 2 ||
                                  sessionScope.usuario.getTipoAcesso() == 4 ||
                          sessionScope.usuario.getTipoAcesso() == 5||
                          sessionScope.usuario.getTipoAcesso() == 6}">
                    <li <% if( request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1).equals("servicos.jsp")){%> class="active" <%}%> >
                        <a href="ServicoServlet">
                            <i class="glyphicon glyphicon-home"></i>
                            Serviços
                        </a>

                    </li>
                    </c:when>
                    <c:otherwise></c:otherwise>
                    </c:choose>

                    <%--Verifica se o usuario tem o tipo de usuario para acessar a pagina clientes --%>
                    <c:choose>
                    <c:when test="${sessionScope.usuario.getTipoAcesso() == 2 ||
                                  sessionScope.usuario.getTipoAcesso() == 4 ||
                          sessionScope.usuario.getTipoAcesso() == 5||
                          sessionScope.usuario.getTipoAcesso() == 6  }">
                    
                    <li <% if( request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1).equals("cliente.jsp")){%> class="active" <%}%> >
                        <a href="ClienteServlet">
                            <i class="glyphicon glyphicon-user"></i>
                            Clientes 
                        </a>
                    </li>
                    </c:when>
                    <c:otherwise></c:otherwise>
                    </c:choose>
                    
                    <%--Verifica se o usuario tem o tipo de usuario para acessar a pagina pets --%>
                    <c:choose>
                    <c:when test="${sessionScope.usuario.getTipoAcesso() == 2 ||
                                  sessionScope.usuario.getTipoAcesso() == 4 ||
                          sessionScope.usuario.getTipoAcesso() == 5 }">
                    <li <% if( request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1).equals("pets.jsp")){%> class="active" <%}%> >
                        <a href="PetsServlet">
                            <i class="glyphicon glyphicon-star"></i>
                            Pets
                        </a>
                    </li>
                    </c:when>
                    <c:otherwise></c:otherwise>
                    </c:choose>
                    
                    <%--Verifica se o usuario tem o tipo de usuario para acessar a pagina relatorios --%>
                    <c:choose>
                    <c:when test="${sessionScope.usuario.getTipoAcesso() == 3 ||
                                  sessionScope.usuario.getTipoAcesso() == 4 ||
                          sessionScope.usuario.getTipoAcesso() == 5 }">
                    
                    <li>
                        <a href="#">
                            <i class="glyphicon glyphicon-stats"></i>
                            Relatórios
                        </a>
                    </li>
                    </c:when>
                    <c:otherwise></c:otherwise>
                    </c:choose>
                    
                    
                    <li>
                        <a href="LogoutServlet">
                            <i class="glyphicon glyphicon-off"></i>
                            Sair
                        </a>
                    </li>
                </ul>
            </nav>
