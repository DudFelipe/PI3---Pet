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
        <nav id="sidebar">
            <div class="sidebar-header">
                <img src="assets/images/logo.png">
                <strong></strong>
            </div>

            <ul class="list-unstyled components">
                <p style="text-align: center; color: white">Nome do Funcionário</p>

                <li >
                        <a href="vendas.html" >
                            <i class="glyphicon glyphicon-shopping-cart"></i>
                            Vendas
                        </a>
                    </li>
    
                    <li>
                        <a href="produtos.html" >
                            <i class="glyphicon glyphicon-list-alt"></i>
                            Produtos
                        </a>
                    </li>
    
                    <li>
                        <a href="servicos.html">
                            <i class="glyphicon glyphicon-home"></i>
                            Serviços
                        </a>
                       
                    </li>
                    <li  class="active">
                        <a href="pets.html">
                            <i class="fas fa-paw">
                            </i>
                            Pets
                        </a>
                    </li>
    
                    <li >
                        <a href="clientes.html" >
                            <i class="glyphicon glyphicon-user"></i>
                            Usuário
                        </a>
                    </li>
    
                    <li>
                        <a href="relatorio.html">
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
                    <div style="font-size: 20px; text-align: center;">Gerenciar Pets</div>
                </nav>

                <div style="margin-bottom: 15px;">
                    <button type="button" class="btn btn-secondary btn-lg" id="liberacadastro">Cadastro</button>
                    <button type="button" class="btn btn-secondary btn-lg" id="liberapesquisa">Pesquisar</button>
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
                        <div class="form-group col-md-6">
                            <label for="produtos">Nome</label>
                            <input type="text" class="form-control" id="nomepet" value="${pet.nome}" name="nomepet">
                        </div>

                        <div class="form-group col-md-4">
                            <label for="calendario">Data de Nascimento</label>
                            <input type="text" class="form-control" id="calendario" value="${pet.nascimentoStr}" name="nascimento" >
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="produtos">Especie</label>
                            <input type="text" class="form-control" id="especie" value="${pet.especie}" name="especie">
                        </div>

                        <div class="form-group col-md-6">
                            <label>Tamanho do Animal</label><br>
                            Pequeno: <input type="radio" class="form-check-input" name="tamanhoanimal" value="1" <c:if test="${pet.porte == '1'}">checked</c:if> > | 
                            Médio: <input type="radio" class="form-check-input" name="tamanhoanimal" value="2" <c:if test="${pet.porte == '2'}">checked</c:if> > |
                            Grande: <input type="radio" class="form-check-input" name="tamanhoanimal" value="3" <c:if test="${pet.porte == '3'}">checked</c:if> >
                        </div>
                        
                    </div>
                    <div class="form-row">
                            <div class="form-group col-md-4">
                                </div>
                                <div class="form-group col-md-4">
                                        <label for="dono">Nome do dono:</label>
                                        <select name="dono">
                                            <c:forEach items="${clientes}" var="c">
                                                <option value="${c.id}" <c:if test="${pet.idCliente.id == c.id}">selected</c:if>><c:out value="${c.nome}"></c:out></option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-4">
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
                <form>
                <table class="table" id="tabelaprodutos">
                  <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Nome Cliente</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Especie</th>
                            <th scope="col">Porte</th>
                            <th scope="col">Nascimento</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${pets}" var="p">
                            <tr>
                                <td scope="row"><c:out value="${p.id}" /></td>
                                <td><c:out value="${p.idCliente.nome}" /></td>
                                <td><c:out value="${p.nome}" /></td>
                                <td><c:out value="${p.especie}" /></td>
                                <td>
                                    <c:if test="${p.porte == 1}"> Pequeno</c:if>
                                    <c:if test="${p.porte == 2}"> Médio</c:if>
                                    <c:if test="${p.porte == 3}"> Grande</c:if>
                                </td>
                                <td><c:out value="${p.nascimento}" /></td>

                                <td><a href="${pageContext.request.contextPath}/AlterarPetServlet?id=${p.id}">Alterar</a></td>
                                <td><a href="${pageContext.request.contextPath}/ExcluirPetServlet?id=${p.id}">Excluir</a></td>
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
    $(document).ready( function () {

        $('#tabelaprodutos').DataTable( {
            "language": {
                "lengthMenu": "Mostrando _MENU_ resultados por página",
                "zeroRecords": "Nada encontrado - desculpe.",
                "info": "Mostrando página _PAGE_ de _PAGES_",
                "infoEmpty": "Não há dados para mostrar",
                "infoFiltered": "(filtrado no total de _MAX_ resultados)",
                "search": "Procurar: ",
                "paginate": {
                "first":      "Primeiro",
                "last":       "Último",
                "next":       "Próximo",
                "previous":   "Anterior"
            },
            }
        } );
    } );

    $("#liberacadastro").on("click", function() {
        $("#cadastro").show();
        $("#pesquisa").hide();
    });

    $("#liberapesquisa").on("click", function() {
        $("#cadastro").hide();
        $("#pesquisa").show();
    });
</script>
</body>
</html>
