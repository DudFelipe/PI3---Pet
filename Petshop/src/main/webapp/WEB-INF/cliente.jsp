<%-- 
    Document   : cliente
    Created on : 15/10/2018, 21:16:55
    Author     : Dud Felipe
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>PetShop TADES - Clientes</title>
    </head>
    <body>
        <div>Gerenciar Clientes</div>

        <br>
        
        <form action="${pageContext.request.contextPath}/ClienteServlet" method="post">
            <div>
                <label>Nome</label>
                <input type="text" id="servico" name="nome">
            </div>
            
            <br>
            
            <div>
                <label for="calendario">Data de Nascimento</label>
                <input type="text" id="calendario" name="dtnascimento">
            </div>
            
            <br>
            
            <div>
                <label for="servico">CPF</label>
                <input type="text" id="servico" name="cpf">
            </div>
            
            <br>
            
            <div>
                <label for="inputState">Sexo</label>
                <select id="inputState" name="sexo">
                    <option selected>Selecione...</option>
                    <option value="M">Masculino</option>
                    <option value="F">Feminino</option>
                  </select>
            </div>
            
            <br>
            
            <div>
                <label for="servico">RG</label>
                <input type="text" id="servico" name="rg">
            </div>
            
            <br>
            
            <div>
                <label for="servico">Telefone</label>
                <input type="text" id="servico" name="telefone">
            </div>
            
            <br>
            
            <div>
                <label for="servico">Email</label>
                <input type="text" id="servico" name="email">
            </div>
            
            <br>
            
            <div>
                <button type="submit">Cadastrar</button>
            </div>
        </form>
    </body>
</html>

