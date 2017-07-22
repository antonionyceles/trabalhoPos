
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : header
    Created on : 29/06/2017, 14:39:09
    Author     : antoniony.lima
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.pos.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content="${session.maxInactiveInterval};url=${request.contextPath}/index.jsp"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">        
        <title>JSP Page</title>
        <script>
            $(document).ready(function () {

                $('#loadingDiv').hide();
            });
            $('#loadingDiv')
                    .hide()  // Hide it initially
                    .ajaxStart(function () {
                        $(this).show();
                    })
                    .ajaxStop(function () {
                        $(this).hide();
                    })
                    ;

        </script>
    </head>
    <body>

        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Depesa de Veículo 0.1</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="<%=request.getContextPath() != null ? request.getContextPath() + "/" : ""%>pre-cadastro.jsp">Cadastre-se</a></li>                      

                    </ul>
                </div>
            </div>
        </nav>
        <br>
        <br>
        <br>
        <br>
        <c:if test="${messageType!=null}">

            <div class="alert alert-${messageType}" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <strong>${messageType}!</strong> ${message}
            </div>
        </c:if>





        <div id="main" class="container-fluid" >

            <h3 class="page-header">LOGIN</h3>

            <form method="post" action="LoginServlet"  >
                <input type="hidden" name="operacao" value="1"/>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="login">Usuário</label> 
                        <input type="text" name="login" class="form-control" value="" /> 
                    </div>
                    <div class="form-group col-md-4">
                        <label for="senha">Senha</label> 
                        <input type="password" name="senha" class="form-control" value="" /> 
                    </div>
                </div>
                <hr />
                <div id="actions" class="row">
                    <div class="col-md-12">
                        <input type="submit" value="Entrar"  class="btn btn-default" />
                    </div>
                </div>
            </form>


        </div>

        <%@ include file = "footer.jsp" %>