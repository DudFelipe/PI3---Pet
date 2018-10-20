
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

        <a href="${pageContext.request.contextPath}/ClienteServlet">Cadastrar</a>
        <a href="${pageContext.request.contextPath}/ListaClienteServlet">Listagem</a>
        
        <br>
        
        <c:choose>
            <c:when test="${manutencao == false}">
                <br>
                <c:choose>
                    <c:when test="${cliente == null}">
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
                    </c:when>
                    <c:otherwise>
                        <form action="${pageContext.request.contextPath}/AlterarClienteServlet?id=${cliente.getId()}" method="post"> 
                            <div>
                                <label>Nome</label>
                                <input type="text" id="servico" name="nome" value="<c:out value="${cliente.getNome()}"/>">
                            </div>

                            <br>

                            <div>
                                <label for="calendario">Data de Nascimento</label>
                                <input type="text" id="calendario" name="dtnascimento" value="<c:out value="${cliente.getDtNascimento()}"/>">
                            </div>

                            <br>

                            <div>
                                <label for="servico">CPF</label>
                                <input type="text" id="servico" name="cpf" value="<c:out value="${cliente.getCpf()}"/>">
                            </div>

                            <br>

                            <div>
                                <label for="inputState">Sexo</label>
                                <select id="inputState" name="sexo">
                                    <option value="M" selected>Masculino</option>
                                    <option value="F">Feminino</option>
                                </select>
                            </div>

                            <br>

                            <div>
                                <label for="servico">RG</label>
                                <input type="text" id="servico" name="rg" value="<c:out value="${cliente.getRg()}"/>">
                            </div>

                            <br>

                            <div>
                                <label for="servico">Telefone</label>
                                <input type="text" id="servico" name="telefone" value="<c:out value="${cliente.getTelefone()}"/>">
                            </div>

                            <br>

                            <div>
                                <label for="servico">Email</label>
                                <input type="text" id="servico" name="email" value="<c:out value="${cliente.getEmail()}"/>">
                            </div>

                            <br>

                            <div>
                                <button type="submit">Cadastrar</button>
                            </div>
                        </form>
                    </c:otherwise>
                </c:choose>
            </c:when>
            
            <c:otherwise> 
                <br>
                <table border="1px">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Nascimento</th>
                    <th>CPF</th>
                    <th>RG
                </tr>
                
                <c:forEach items="${clientes}" var="c">
                    <tr>
                        <td><c:out value="${c.getId()}" /></td>
                        <td><c:out value="${c.getNome()}" /></td>
                        <td><c:out value="${c.getDtNascimento()}" /></td>
                        <td><c:out value="${c.getCpf()}" /></td>
                        <td><c:out value="${c.getRg()}" /></td>
                        
                        <td><a href="${pageContext.request.contextPath}/AlterarClienteServlet?id=${c.getId()}">Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/ExcluirClienteServlet?id=${c.getId()}">Excluir</a></td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </body>
</html>

