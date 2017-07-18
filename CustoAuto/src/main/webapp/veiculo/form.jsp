<%-- 
    Document   : form
    Created on : 17/06/2017, 14:47:58
    Author     : aluno
--%>
<%@ include file = "../header.jsp" %>

<%@page import="com.pos.entity.Usuario"%>
<div id="main" class="container-fluid" >

    <form class="form" method="post" action="../VeiculoServlet">
        <input type="hidden" name="operacao" value="<%=request.getParameter("operacao")%>"/>
        <div class="row col-md-6">
            <div class="form-group col-md-6">
                <label for="tipo">Veículo</label> 
                <select name="tipo" class="form-control">
                    <option value="carro" label="Carro"/>
                    <option value="moto" label="Moto"/>
                </select>
            </div>
            <div class="form-group col-md-6">
                <label for="modelo">Modelo</label>
                <input type="text" name="modelo" class="form-control"/>
            </div>

            <div class="row pull-right">
                <div class="col-md-12 ">
                    <input type="submit" value="Adicionar Veículo" />
                </div>
            </div>
        </div>
    </form>
</div>



<%@ include file = "../footer.jsp" %>
