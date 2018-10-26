<%-- 
    Document   : servicos
    Created on : 15/10/2018, 21:18:35
    Author     : Dud Felipe
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>PetShop TADES</title>

        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/style.css">
    </head>
    <body>
        <div class="wrapper">
            <nav id="sidebar">
                <div class="sidebar-header">
                    <img src="assets/images/logo.png">
                    <strong></strong>
                </div>

                <ul class="list-unstyled components">
                    <p style="text-align: center; color: white">Nome do Funcionário</p>

                    <li>
                        <a href="#vendas" data-toggle="collapse" aria-expanded="false">
                            <i class="glyphicon glyphicon-shopping-cart"></i>
                            Vendas
                        </a>
                        <ul class="collapse list-unstyled" id="vendas">
                            <li><a href="#">Realizar uma venda</a></li>
                        </ul>
                    </li>

                    <li>
                        <a href="#produtos" data-toggle="collapse" aria-expanded="false">
                            <i class="glyphicon glyphicon-list-alt"></i>
                            Produtos
                        </a>
                        <ul class="collapse list-unstyled" id="produtos">
                            <li><a href="/Users/giovanebarreira/Desktop/PI3---Pet/Petshop/src/main/webapp/HTML/produtos.html">Cadastrar um produto</a></li>
                            <li><a href="#">Listar produtos</a></li>
                        </ul>
                    </li>

                    <li class="active">
                        <a href="#servicos" data-toggle="collapse" aria-expanded="false">
                            <i class="glyphicon glyphicon-home"></i>
                            Serviços
                        </a>
                        <ul class="collapse list-unstyled" id="servicos">
                            <li><a href="#">Cadastrar um serviço</a></li>
                            <li><a href="#">Listar serviços</a></li>
                        </ul>
                    </li>

                    <li>
                        <a href="#clientes" data-toggle="collapse" aria-expanded="false">
                            <i class="glyphicon glyphicon-user"></i>
                            Clientes
                        </a>
                        <ul class="collapse list-unstyled" id="clientes">
                            <li><a href="/Users/giovanebarreira/Desktop/PI3---Pet/Petshop/src/main/webapp/HTML/clientes.html">Cadastrar um cliente</a></li>
                            <li><a href="#">Listar clientes</a></li>
                        </ul>
                    </li>

                    <li>
                        <a href="#">
                            <i class="glyphicon glyphicon-stats"></i>
                            Relatórios
                        </a>
                    </li>

                    <li>
                        <a href="#">
                            <i class="glyphicon glyphicon-log-out"></i>
                            Sair
                        </a>
                    </li>
                </ul>
            </nav>

            <div id="content">
                <nav class="navbar navbar-default">
                    <div style="font-size: 20px; text-align: center;">Gerenciar Serviços</div>
                </nav>


                <div style="margin-bottom: 15px;">
                    <button type="button" class="btn btn-success btn-lg" id="liberacadastro" >Cadastro</button>
                    <button type="button" class="btn btn-secondary btn-lg" id="liberapesquisa">Pesquisar</button>
                </div>

                <div id="cadastro">


                    <form action="
                          <c:choose>
                              <c:when test="${servico != null}">
                                  ${pageContext.request.contextPath}/AlterarServicoServlet?id=${servico.id}
                              </c:when>
                              <c:otherwise>
                                  ${pageContext.request.contextPath}/ServicoServlet
                              </c:otherwise>
                          </c:choose>
                          " method="post" 
                          >
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="servico">Serviço</label>
                                <input type="text" class="form-control" id="servico" name="descricao" value="${servico.descricao}">
                            </div>

                            <div class="form-group col-md-6">
                                <label for="preco">Preço</label>
                                <input type="text" class="form-control" id="preco" name="preco" value="${servico.preco}">
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-12">
                                <label>Tamanho do Animal</label><br>
                                Pequeno:
                                <c:choose>
                                    <c:when test="${servico.tamanhoAnimal == 1}">
                                        <input type="radio" class="form-check-input" name="tamanho" value="1" checked="checked" > | 
                                    </c:when>
                                    <c:otherwise>
                                        <input type="radio" class="form-check-input" name="tamanho" value="1">
                                    </c:otherwise>
                                </c:choose>
                                Médio: 
                                <c:choose>
                                    <c:when test="${servico.tamanhoAnimal == 2}">
                                        <input type="radio" class="form-check-input" name="tamanho" value="2" checked="checked"> |
                                    </c:when>
                                    <c:otherwise>
                                        <input type="radio" class="form-check-input" name="tamanho" value="2">
                                    </c:otherwise>
                                </c:choose>
                                Grande:
                                <c:choose>
                                    <c:when test="${servico.tamanhoAnimal == 3}">
                                        <input type="radio" class="form-check-input" name="tamanho" value="3" checked="checked" >
                                    </c:when>
                                    <c:otherwise>
                                        <input type="radio" class="form-check-input" name="tamanho" value="3">
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-4">
                            </div>
                            <div class="form-group col-md-4 text-center">
                                <button type="submit" class="btn btn-primary btn-lg btn-block">Cadastrar</button>
                            </div>
                            <div class="form-group col-md-4">
                            </div>
                        </div>
                    </form>

                </div>

                <div id="pesquisa" style="display: none">

                    <table class="table" id="tabelaservicos">
                        <thead>
                            <tr>
                                <th scope="col">Serviço</th>
                                <th scope="col">Tamanho Animal</th>
                                <th scope="col">Preço</th>
                                <th scope="col">Editar</th>
                                <th scope="col">Excluir</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${servicos}" var="s">
                                <tr>
                                    <td><c:out value="${s.descricao}" /></td>
                                    <td><c:out value="${s.tamanhoAnimal}" /></td>
                                    <td><c:out value="${s.preco}" /></td>
                                    <td><a href="${pageContext.request.contextPath}/AlterarServicoServlet?id=${s.id}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                                    <td><a href="${pageContext.request.contextPath}/ExcluirServicoServlet?id=${s.id}"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>


        <script type="text/javascript">
            $(document).ready(function () {
                $('#tabelaservicos').DataTable({
                    "language": {
                        "lengthMenu": "Mostrando _MENU_ resultados por página",
                        "zeroRecords": "Nada encontrado - desculpe.",
                        "info": "Mostrando página _PAGE_ de _PAGES_",
                        "infoEmpty": "Não há dados para mostrar",
                        "infoFiltered": "(filtrado no total de _MAX_ resultados)",
                        "search": "Procurar: ",
                        "paginate": {
                            "first": "Primeiro",
                            "last": "Último",
                            "next": "Próximo",
                            "previous": "Anterior"
                        },
                    }
                });
            });

            $("#liberacadastro").on("click", function () {
                $("#cadastro").show();
                $("#pesquisa").hide();
            });

            $("#liberapesquisa").on("click", function () {
                $("#cadastro").hide();
                $("#pesquisa").show();
            });
        </script>
    </body>
</html>
