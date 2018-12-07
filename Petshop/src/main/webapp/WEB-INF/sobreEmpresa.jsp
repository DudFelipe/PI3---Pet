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
                <h1>Grupo PI 3</h1>
                <p> Alunos: </p>
                <ol>
                    <li>Evelyn Carmo</li>
                    <li>Eduardo Serra</li>
                    <li>Diogo Carauta</li>
                    <li>Marcos Limeira</li>
                    <li>Giovane Barreira</li>
                </ol>
            </div>
        </div>

        <script src="assets/js/jquery-1.12.0.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="assets/css/jquery.dataTables.css">
        <script type="text/javascript" charset="utf8" src="assets/js/jquery.dataTables.js"></script>
        <script src="assets/js/jquery-ui.min.js"></script>
        <link rel="stylesheet" href="assets/css/jquery-ui.css" />
    </body>
</html>