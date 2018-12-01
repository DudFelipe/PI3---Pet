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
            <jsp:include page="menu.jsp"></jsp:include>

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
                            <div class="form-group col-md-4">
                                <label for="servico">Serviço</label>
                                <input type="text" class="form-control" id="servico" name="descricao" value="${servico.descricao}">
                            </div>

                            <div class="form-group col-md-4">
                                <label for="preco">Preço</label>
                                <input type="text" class="form-control" id="preco" name="preco" value="${servico.preco}">
                            </div>
                            
                            <div class="form-group col-md-4">
                                <label for="preco">Filial</label>
                                <select id="inputState" class="form-control" name="filial">
                                    <option selected>Selecione...</option>
                                    <option value="1" <c:if test="${servico.getFilial().getId() == 1}">selected</c:if>>São Paulo</option>
                                    <option value="2" <c:if test="${servico.getFilial().getId() == 2}">selected</c:if>>Campina Grande</option>
                                    <option value="3" <c:if test="${servico.getFilial().getId() == 3}">selected</c:if>>Brasília</option>
                                    <option value="4" <c:if test="${servico.getFilial().getId() == 4}">selected</c:if>>Joinville</option>
                                </select>
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
                                <th scope="col">Filial</th>
                                <th scope="col">Editar</th>
                                <th scope="col">Excluir</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${servicos}" var="s">
                                <tr>
                                    <td><c:out value="${s.descricao}" /></td>
                                    <td>
                                        <c:if test="${s.tamanhoAnimal == 1}"> Pequeno</c:if>
                                        <c:if test="${s.tamanhoAnimal == 2}"> Médio</c:if>
                                        <c:if test="${s.tamanhoAnimal == 3}"> Grande</c:if>
                                    </td>
                                    <td><c:out value="${s.preco}" /></td>
                                    <td><c:out value="${s.getFilial().getCidade()}" /></td>
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
