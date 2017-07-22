<%-- 
    Document   : pre-cadastro
    Created on : 19/07/2017, 10:29:06
    Author     : antoniony.lima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="com.pos.entity.Cliente" %>
<%@ page import="com.pos.entity.Usuario" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : header
    Created on : 29/06/2017, 14:39:09
    Author     : antoniony.lima
--%>


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
                        <li><a href="<%=request.getContextPath() != null ? request.getContextPath() + "/" : ""%>index.jsp">Cadastre-se</a></li>                      

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


    <script>
        $(document).ready(function () {
            $('.tel').mask('(99) 99999-9999');
            //        $('#salvar').on('click', function () {
            //            $.ajax({url: "PreCadastroServlet",
            //                data: $('#preCadastro').serialize(),
            //                cache: false,
            //                contentType: false,
            //                processData: false,
            //                success: function (data) {
            //                    //alert("---"+data);
            //                    console.log(data);
            //                    alert("sucesso");
            //                },
            //                error: function (jqXHR, textStatus, errorThrown) {
            //                    console.log(textStatus);
            //                    console.log(jqXHR);
            //                    console.log(errorThrown);
            //                    alert("ERRO");
            //                }
            //            });
            //        });
        });

    </script>
    <form method="post"  id="preCadastro"  action="PreCadastroServlet">

        <div class="row ">
            <div class="form-group col-md-4">
                <label for="nome">Nome</label> 
                <input type="text" name="nome" class="form-control" value="${cliente.nmNome}" required="true"/> 
            </div>
            <div class="form-group col-md-4">
                <label for="sobrenome">Sobrenome</label> 
                <input type="text" name="sobrenome" class="form-control" value="${cliente.nmSobrenome}" required="true"/> 
            </div>
            <div class="form-group col-md-4">
                <label for="dtNascimento">Nascimento</label> 
                <input type="date" name="dtNascimento" class="form-control" value="" required="true"/> 
            </div>
        </div>
        <div class="row ">
            <div class="form-group col-md-4">
                <label for="telefone">Telefone</label> 
                <input type="text"  name="telefone" class="tel form-control" value="${cliente.nrTelefone}"  required="true"/> 
            </div>
            <div class="form-group col-md-4">
                <label for="celular">Celular</label> 
                <input type="text" name="celular" class="tel form-control" value="${cliente.nrCelular}" required="true"/> 
            </div>

            <div class="form-group col-md-4">
                <label for="email">E-mail</label> 
                <input type="email" name="email" class="form-control" value="${cliente.dsEmail}" placeholder="exemplo" alt="Exemplo exemplo@dominio.com" required="true"/> 
            </div>
        </div>
        <div class="row ">
            <div class="form-group col-md-4">
                <label for="senha">Senha</label> 
                <input type="password" name="senha" class="form-control" value="" alt="Senha forte utilizam letra, número e símbolos" required="true"/> 
            </div>
            <div class="form-group col-md-4">
                <label for="confirmaSenha">Confirmação de Senha</label> 
                <input type="password" name="confirmaSenha" class="form-control" value="${confirmaSenha}"  required="true"/> 
            </div>
        </div>

        <hr />
        <div id="actions" class="row ">
            <div class="form-group col-md-6 pull-right">

                <input type="submit" value="Entrar" id="salvar"  class="btn btn-default" />
                <input type="reset" value="Limpar"  class="btn btn-default" />
            </div>


        </div>
    </form>
    <%@ include file = "footer.jsp" %>