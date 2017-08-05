
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
       <link href="${pageContext.request.contextPath}/content/css/style.css"  rel="stylesheet" type="text/css"/>

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

        <%@ include file = "navbar.jsp" %>

        <c:if test="${messageType!=null}">

            <div class="alert alert-${messageType}" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <strong>${messageType}!</strong> ${message}
            </div>
        </c:if>

        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="panel panel-login">
                        <div class="panel-heading">
                            <div class="row">

                                <img src="${pageContext.request.contextPath}/resource/image/custo-auto-logo.png" alt="Logomarca CustoAuto" />


                                <!--							<div class="col-xs-6">
                                                                                                <a href="#" class="active" id="login-form-link">Login</a>
                                                                                        </div>
                                                                                        <div class="col-xs-6">
                                                                                                <a href="#" id="register-form-link">Register</a>
                                                                                        </div>
                                                                                </div>
                                                                                <hr>-->
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <form method="post" action="LoginServlet"  >
                                            <input type="hidden" name="operacao" value="1"/>

                                            <div class="form-group">
                                                <input type="text" name="login" class="form-control" value="" placeholder="Login"/>
                                            </div>
                                            <div class="form-group">
                                                <input type="password" name="senha" class="form-control" value="" placeholder="Senha" />									</div>
                                            <!--									<div class="form-group text-center">
                                                                                                                            <input type="checkbox" tabindex="3" class="" name="remember" id="remember">
                                                                                                                            <label for="remember"> Remember Me</label>
                                                                                                                    </div>-->
                                            <div class="form-group">
                                                <div class="row">
                                                    <div class="col-sm-6 col-sm-offset-3">
                                                        <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Entrar">
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div></div></div>

                    </div></div></div>
        </div>



        <!--        <div id="main" class="container-fluid" >
        
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
                </div>-->

        <%@ include file = "footer.jsp" %>