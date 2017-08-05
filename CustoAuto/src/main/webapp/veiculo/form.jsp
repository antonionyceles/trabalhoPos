<%-- 
    Document   : form
    Created on : 17/06/2017, 14:47:58
    Author     : aluno
--%>
<%@ include file = "../header.jsp" %>

<%@page import="com.pos.entity.Usuario"%>
<div id="main" class="container" >
<div class="panel panel-default">
    <div class="col-md-12"><h1>Cadastro de veículo</h1></div>
    
    <form class="form" method="post" action="../VeiculoServlet">
        <input type="hidden" name="operacao" value="<%=request.getParameter("operacao")%>"/>
        <div class="row col-md-6">
            <div class="form-group col-md-6">
                <label for="tipo">Veículo</label> 
                <select name="tipo" class="form-control">
                    <option value="1" label="Carro"/>
                    <option value="2" label="Pickup"/>                    
                    <option value="3" label="Moto"/>
                    <option value="4" label="Caminhão"/>
                    <option value="5" label="Outros"/>
                </select>
            </div>
            <div class="form-group col-md-6">
                <label for="descricao">Descrição</label>
                <input type="text" name="descricao" class="form-control"/>
            </div>
            <div class="form-group col-md-6">
                <label for="placa">Placa</label>
                <input type="text" name="placa" class="form-control"/>
            </div>

         
                <div class="col-md-12 ">
                    <input type="submit" class="btn btn-primary" value="Adicionar Veículo" />
                </div>
           
        </div>
    </form>
        <div class="clearfix"></div>
</div>
</div>



<%@ include file = "../footer.jsp" %>
