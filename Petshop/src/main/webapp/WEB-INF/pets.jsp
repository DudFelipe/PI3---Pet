<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>PetShop TADES - Pets</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/style.css">
    
</head>
<body>

    <div class="wrapper">
        <jsp:include page="menu.jsp"></jsp:include>
        <div id="content">
            <nav class="navbar navbar-default">
                <div style="font-size: 20px; text-align: center;">Gerenciar Usuários</div>
            </nav>



            <div style="margin-bottom: 15px;">
                <button type="button" class="btn btn-secondary btn-lg" id="liberacadastro">Cadastro</button>
                <button type="button" class="btn btn-secondary btn-lg" id="liberapesquisa">Listar</button>
            </div>

            <div id="cadastro">
                <form action="
                          <c:choose>
                              <c:when test="${pet != null}">
                                  ${pageContext.request.contextPath}/AlterarPetServlet?id=${pet.id}
                              </c:when>
                              <c:otherwise>
                                  ${pageContext.request.contextPath}/PetsServlet
                              </c:otherwise>
                          </c:choose>
                          " method="post">
                    <div class="form-row">
                        
                        <div class="form-group col-md-4">
                            <label for="produtos">Dono:</label>
                            <select id="dono" name="dono" value="${cliente.nome}">
                                <c:forEach items="${clientes}" var="c">
                                    <option value="${c.id}"><c:out value="${c.nome}"></c:out></option>
                                </c:forEach>
                            </select>
                        </div>
                        
                        <div class="form-group col-md-6">
                            <label for="produtos">Nome</label>
                            <input type="text" class="form-control" id="nomepet" name="nomepet" value="${pet.nome}">
                        </div>

                        <div class="form-group col-md-4">
                            <label for="calendario">Data de Nascimento</label>
                            <input type="text" class="form-control" id="calendario" name="nascimento" value="${pet.nascimentoStr}">
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="produtos">Especie</label>
                            <input type="text" class="form-control" id="especie" name="especie" value="${pet.especie}">
                        </div>

                        <div class="form-group col-md-6">
                            <label>Tamanho do Animal</label><br>
                            Pequeno: <input type="radio" class="form-check-input" name="tamanhoanimal" value="1" > | 
                            Médio: <input type="radio" class="form-check-input" name="tamanhoanimal" value="2" > |
                            Grande: <input type="radio" class="form-check-input" name="tamanhoanimal" value="3" >
                        </div>

                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-4">
                        </div>
                        <div class="form-group col-md-4 text-center">
                            <button type="submit" class="btn btn-secondary btn-lg btn-block">Cadastrar</button>
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
                            <th scope="col">Id</th>
                            <th scope="col">Nome Cliente</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Especie</th>
                            <th scope="col">Porte</th>
                            <th scope="col">Nascimento</th>
                             <th scope="col">Editar</th>
                             <th scope="col">Excluir</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${pets}" var="p">
                            <tr>
                                <td scope="row"><c:out value="${p.id}" /></td>
                                <td><c:out value="${p.getIdCliente().getNome()}" /></td>
                                <td><c:out value="${p.nome}" /></td>
                                <td><c:out value="${p.especie}" /></td>
                                <td><c:out value="${p.porte}" /></td>
                                <td><c:out value="${p.nascimento}" /></td>

                                <td><a href="${pageContext.request.contextPath}/AlterarPetServlet?id=${p.id}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                                <td><a href="${pageContext.request.contextPath}/ExcluirPetServlet?id=${p.id}"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>

        <script src="assets/js/jquery-1.12.0.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="assets/css/jquery.dataTables.css">
        <script type="text/javascript" charset="utf8" src="assets/js/jquery.dataTables.js"></script>
        <script src="assets/js/jquery-ui.min.js"></script>
        <link rel="stylesheet" href="assets/css/jquery-ui.css" />


        <script type="text/javascript">
            $(document).ready(function () {
                //$("#calendario").datepicker();
                $("#calendario").datepicker("option", "dateFormat", "dd/mm/yy");
                $('#tabelaservicos').DataTable({
                    "language": {
                        "lengthMenu": "Mostrando MENU resultados por página",
                        "zeroRecords": "Nada encontrado - desculpe.",
                        "info": "Mostrando página PAGE de PAGES",
                        "infoEmpty": "Não há dados para mostrar",
                        "infoFiltered": "(filtrado no total de MAX resultados)",
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
