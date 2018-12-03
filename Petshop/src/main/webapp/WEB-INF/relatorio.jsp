<%-- 
    Document   : relatorio
    Created on : Dec 3, 2018, 7:51:03 PM
    Author     : giovanebarreira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
        <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>Relatórios</title>

        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/style.css">
    </head>
    <body>

        <div class="wrapper">
            <jsp:include page="menu.jsp"></jsp:include>
            <div id="content">
                <nav class="navbar navbar-default">
                    <div style="font-size: 20px; text-align: center;">Relatórios</div>
                </nav>

<!--
                <div style="margin-bottom: 4px;">
                    <div class="form-group col-md-3"></div>
                    <div class="form-group col-md-6">
                        <button type="button" class="btn btn-secondary btn-lg" id="liberavendas"  >
                            <i class="fas fa-shopping-cart"></i> Vendas</button>

                    </div>
                    <div class="form-group col-md-3"></div>
                </div>-->



                <div id="rvendas">
                    <div class="row">
                        <div class="form-group col-md-2">

                            <label for="inputState">Período:</label>
                            <select id="inputState" class="form-control" onChange="window.location.href=this.options[this.selectedIndex].value">
                                <option>Selecione...</option>
                                <option value="RelatoriosServlet?filtro=7" selected>Semanal</option>
                                <option value="RelatoriosServlet?filtro=15">Quinzenal</option>
                                <option value="RelatoriosServlet?filtro=30">Mensal</option>
                            </select>
                        </div> 
                    </div>
                    <table class="table" id="tabelavendas">
                        <thead>
                            <tr>
                                <th scope="col">Cod. do pedido</th>
                                <th scope="col">Cod. do Cliente</th>
                                <th scope="col">Cod. do Funcionario</th>
                                <th scope="col">Tipo Pagto</th>
                                <th scope="col">Filial</th>
                                <th scope="col">Data</th>
                                <th scope="col">Valor venda</th>
                                
                               
                            </tr>
                        </thead>
                        <tbody>
                             <c:forEach items="${relatorio}" var="r">
                                <tr>
                                    <td scope="row"><c:out value="${r.idPedido}" /></td>
                                    <td><c:out value="${r.idCliente}" /></td>
                                    <td><c:out value="${r.idFuncionario}" /></td>
                                    <td><c:out value="${r.idTipoPagamento}" /></td>
                                    <td><c:out value="${r.idFilial}" /></td>
                                    <td><c:out value="${r.data}" /></td>
                                    <td><c:out value="${r.precovenda}" /></td>
                                
                                </tr>
                            </c:forEach>
                            
                        </tbody>

                    </table>
                    <div style="margin-bottom: 2px;">
                        <button type="button" class="btn btn-secondary btn-lg" id="exportarcadastros">
                            <i class="fas fa-cloud-download-alt"></i> Exportar CSV</button>

                    </div>
                </div>

                <div id="inventario" style="display: none">
                    <div class="form-group col-md-2">
                        <div class="row">
                            <label for="inputState">Tipo de relatorio:</label>
                            <select id="inputState" class="form-control">
                                <option selected>Selecione...</option>
                                <option value="0">Semanal</option>
                                <option value="1">Quinzenal</option>
                                <option value="2">Mensal</option>
                            </select>
                        </div>    
                    </div>
 
                    <div style="margin-bottom: 2px;">
                        <button type="button" class="btn btn-secondary btn-lg" id="exportarcadastros">
                            <i class="fas fa-cloud-download-alt"></i> Exportar CSV</button>

                    </div>
                </div>

                <div id="cadastros" style="display: none">
                    <div class="form-group col-md-2">
                        <div class="row">
                            <label for="inputState">Tipo de relatorio:</label>
                            <select id="inputState" class="form-control" onChange="window.location.href=this.options[this.selectedIndex].value">
                                <option value="0" selected="">Semanal</option>
                                <option value="1">Quinzenal</option>
                                <option value="2">Mensal</option>
                            </select>
                        </div>    
                    </div>
                
                    <div style="margin-bottom: 2px;">

                        <button type="button" class="btn btn-secondary btn-lg" id="exportarcadastros">
                            <i class="fas fa-cloud-download-alt"></i> Exportar CSV</button>

                    </div>
                </div>

            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />


    <script type="text/javascript">
        $(document).ready(function () {
            $("#calendario").datepicker();

            $('#tabelaVendas').DataTable({
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

        $("#liberavendas").on("click", function () {
            $("#rvendas").show();
            $("#inventario").hide();
            $("#cadastros").hide();

        });

        $("#liberainventario").on("click", function () {
            $("#rvendas").hide();
            $("#inventario").show();
            $("#cadastros").hide();
        });

        $("#liberacadastros").on("click", function () {
            $("#rvendas").hide();
            $("#inventario").hide();
            $("#cadastros").show();
        });
        
        
    </script>
</body>
</html>