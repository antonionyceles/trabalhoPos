<%-- 
    Document   : form
    Created on : 17/06/2017, 14:47:58
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Seja bem vindo: <%=request.getParameter("nome")%></h1>
        <form class="form" method="post" action="abastecer.jsp">
            <input type="hidden" name="nome" value='<%=request.getParameter("nome")%>'/>
            Veículo 
            <select name="tipo" >
                <option value="carro" label="Carro"/>
                <option value="moto" label="Moto"/>
            </select>
            Modelo<input type="text" name="modelo"/>
            Consumo Km/L
            <ul>
                <li>Cidade KM<input type="number" name="cidade"/></li>
                <li>Estrada KM<input type="number" name="estrada"/></li>
            </ul>
            <input type="submit" value="Abastecer" />
            

        </form>
    </body>
</html>
