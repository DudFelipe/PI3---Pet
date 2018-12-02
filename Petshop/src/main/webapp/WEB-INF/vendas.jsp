<%-- 
    Document   : vendas
    Created on : 31/10/2018, 20:51:28
    Author     : vyvis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>PetShop TADES - Vendas</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"
        crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css">
</head>

<body>
<script type="text/javascript">

 function excluir(elemento) {
    console.log(elemento);
    $(elemento).closest('tr').remove();
}

</script>


    <div class="wrapper">
        <nav id="sidebar">
            <div class="sidebar-header">
                <img src="logo.png">
                <strong></strong>
            </div>

            <ul class="list-unstyled components">
                <p style="text-align: center; color: white">Nome do Funcionário</p>

                <li class="active">
                    <a href="vendas.html">
                        <i class="glyphicon glyphicon-shopping-cart"></i>
                        Vendas
                    </a>
                </li>

                <li>
                    <a href="produtos.html">
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
                <li>
                    <a href="pets.html">
                        <i class="fas fa-paw">
                        </i>
                        Pets
                    </a>
                </li>

                <li>
                    <a href="clientes.html">
                        <i class="glyphicon glyphicon-user"></i>
                        Clientes
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
        <div style="width: 600px; height: 263px; position: absolute; background-color: black; 
                 top: 50%; left: 50%; margin-top: -131px; margin-left: -300px; z-index: 99; display: none;">


        </div>

        <div id="content">
            <div class="row">
                <div class="col-md-8">
                    <nav class="navbar navbar-default">
                        <div style="font-size: 20px; text-align: center;">Nome do Cliente</div>
                    </nav>
                    <div class="navbar">
                        <table class="table" id="tabelaitens">
                            <thead>
                                <tr>
                                    <th>Cod.</th>
                                    <th>Nome</th>
                                    <th>Qtd</th>
                                    <th>Tamanho do animal</th>    
                                    <th>Valor</th>
                                    <th>Adicionar</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${servicos}" var="s">
                                <tr>
                                    <td><c:out value="${s.id}" /></th>
                                    <td><c:out value="${s.descricao}" /></td>
                                    <td>-</td>
                                    <td><c:out value="${s.tamanhoAnimal}" /></td>
                                    <td><c:out value="${s.preco}" /></td>
                                    <td style="text-align: center;"><span class="adicionarproduto glyphicon glyphicon-menu-right" aria-hidden="true"></span></td>
                                </tr>
                                </c:forEach>
                                <c:forEach items="${produtos}" var="p">
                                    <tr>
                                    <td><c:out value="${p.id}" /></th>
                                    <td><c:out value="${p.nome}" /></td>
                                    <td><c:out value="${p.quantidade}" /></td>
                                    <td>-</td>
                                    <td><c:out value="${p.preco}" /></td>
                                    <td style="text-align: center;"><span class="adicionarproduto glyphicon glyphicon-menu-right" aria-hidden="true"></span></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

                <div class="col-md-4">
                    <nav class="navbar navbar-default">
                        <div style="font-size: 10px; text-align: center;">
                            <select name="clientes" style="width: 100%">
                                <option>Selecione um cliente</option>
                                <c:forEach items="${clientes}" var="c">
                                    <option><c:out value="${c.nome}" /></option>
                                </c:forEach>
                            </select>

                    </nav>
                    <div class="navbar" style="height:150px; overflow: auto;">
                        <table class="table" id="tabelacarrinho">
                            <thead>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</th>
                                    <td>Coleira</td>
                                    <td>10</td>
                                    <td>R$14,00</td>
                                    <td><span id="testeXX" class="glyphicon glyphicon-remove" aria-hidden="true" onClick="excluir(this);"></span></td>
                                </tr>
           
                            </tbody>
                        </table>
                    </div>
                    <div class="navbar">
                        Valor total <h4 id="valortotal">R$0</h4>
                    </div>

                    <div class="navbar">
                        <button type="button" class="btn btn-secondary btn-lg" id="exportarcadastros" style="width: 100%">
                            Finalizar venda</button>
                        <br><br>
                        <button type="button" class="btn btn-secondary btn-lg" id="exportarcadastros" style="width: 100%">
                            Cancelar</button>
                    </div>

                </div>
            </div>



        </div>
    </div>

    <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

    <script type="text/javascript">
        var produtos_selecionados = [];
        var valor_total = 0;

        $(document).ready(function () {

            var produtos_disponiveis = [];
            var produtos_selecionados = [];

            $('#tabelaitens').DataTable({

                "language": {
                    "lengthMenu": "Mostrando _MENU_ resultados por página",
                    "zeroRecords": "Nada encontrado - desculpe.",
                    "infoEmpty": "Não há dados para mostrar",
                    "infoFiltered": "(filtrado no total de _MAX_ resultados)",
                    "search": "Procurar: ",
                    "info": "Mostrando página _PAGE_ de _PAGES_",
                    "paginate": {
                        "first": "Primeiro",
                        "last": "Último",
                        "next": "Próximo",
                        "previous": "Anterior"
                    },
                }
            });
            $(".adicionarproduto").on("click", function () {

                var qtd = prompt("Digite a quantidade:");
                if (qtd != null) {

                    $('#tabelacarrinho').append('<tr>' +
                        '<td>' + $(this).closest('tr').find('td').eq(0).text() + '</td>' +
                        '<td>' + $(this).closest('tr').find('td').eq(1).text() + '</td>' +
                        '<td>' + qtd + '</td>' +
                        '<td>' + $(this).closest('tr').find('td').eq(3).text() + '</td>' +
                        '<td><span class="glyphicon glyphicon-remove" aria-hidden="true" onClick="excluir(this)"></span></td>' +
                        '</tr>');
                }
            });

        });

        function excluir(elemento, idproduto) {
            $(elemento).closest('tr').remove();
            valor_total = 0;
            for( var i = 0; i < produtos_selecionados.length; i++){ 
               if ( produtos_selecionados[i].id == idproduto) {
                 produtos_selecionados.splice(i, 1);
               } 
            }

            for( var i = 0; i < produtos_selecionados.length; i++){
               valor_total += produtos_selecionados[i].valorunitario * produtos_selecionados[i].qtd;
            }

            $("#valortotal").text("R$" + valor_total);
        }

    </script>
</body>

</html>
