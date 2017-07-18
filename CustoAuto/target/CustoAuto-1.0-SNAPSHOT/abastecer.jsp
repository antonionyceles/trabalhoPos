<%-- 
    Document   : abastecer
    Created on : 17/06/2017, 15:06:30
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Abastecer</title>
    </head>
    <body>
   <form method="post" action="CalcularAutonomia">
            <input type="hidden" name="nome" value='<%=request.getParameter("nome")%>'/>
            <input type="hidden" name="tipo" value='<%=request.getParameter("tipo")%>'/>
            Veículo <%=request.getParameter("tipo")%>
           
            Modelo <input readonly type="text" name="modelo" value="<%=request.getParameter("modelo")%>" readonly="true"/>
            Consumo Km/L
            <ul>
                <li>Cidade <input readonly type="text" name="cidade" value="<%=request.getParameter("cidade")%>"/></li>
                <li>Estrada <input readonly type="text" name="estrada" value="<%=request.getParameter("estrada")%>"/></li>
            </ul>
            Abastecer Litros <input type="text" name='litros' />
            <input type="submit" value="Calcular Autonomia" />
            

        </form>
    </body>
</html>
