<%-- 
    Document   : form
    Created on : 17/06/2017, 14:47:58
    Author     : aluno
--%>

<%@page import="com.pos.entity.Usuario"%>
<%@ include file = "header.jsp" %>

<div id="main" class="container-fluid" >

    <form class="form" method="post" action="abastecer.jsp">
        <div id="sidebar">
            <div class="col-md-4">
                <h3>Seja bem vindo: ${ sessionScope.usuario.getDsLogin()}</h3>
                <ul class="nav nav-pills nav-stacked">
                    <li class="active"><a href="#">Veículos</a></li>
                    <ul class="nav nav-pills nav-stacked">
                        <li>
                            <a href="veiculo/list.jsp">Consultar Veículo</a>
                        </li>
                        <li>
                            <a href="veiculo/form.jsp?operacao=1">Cadastrar Veículo</a>
                        </li>
                    </ul>
                    <li class="active"><a href="#">Despesas</a></li>
                    <ul class="nav nav-pills nav-stacked">
                        <li><a href="movimento/list.jsp">Consultar Despesa</a></li>
                        <li><a href="movimento/form.jsp?operacao=1">Cadastrar Despesa</a></li>
                    </ul>
                </ul>
            </div>
        </div>
    </form>
</div>


