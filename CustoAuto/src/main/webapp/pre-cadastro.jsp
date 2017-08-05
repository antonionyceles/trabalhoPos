<%-- 
    Document   : pre-cadastro
    Created on : 19/07/2017, 10:29:06
    Author     : antoniony.lima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

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
  

      <style>
            
            #playground-container {
    height: 500px;
    overflow: hidden !important;
    -webkit-overflow-scrolling: touch;
}

.main{
 	margin:50px 15px;
}

h1.title { 
	font-size: 50px;
	font-family: 'Passion One', cursive; 
	font-weight: 400; 
}

hr{
	width: 10%;
	color: #fff;
}

.form-group{
	margin-bottom: 15px;
}

label{
	margin-bottom: 15px;
}

input,
input::-webkit-input-placeholder {
    font-size: 11px;
    padding-top: 3px;
}

.main-login{
 	background-color: #fff;
    /* shadows and rounded borders */
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-radius: 2px;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);

}
.form-control {
    height: auto!important;
padding: 8px 12px !important;
}
.input-group {
    -webkit-box-shadow: 0px 2px 5px 0px rgba(0,0,0,0.21)!important;
    -moz-box-shadow: 0px 2px 5px 0px rgba(0,0,0,0.21)!important;
    box-shadow: 0px 2px 5px 0px rgba(0,0,0,0.21)!important;
}
#button {
    border: 1px solid #ccc;
    margin-top: 28px;
    padding: 6px 12px;
    color: #666;
    text-shadow: 0 1px #fff;
    cursor: pointer;
    -moz-border-radius: 3px 3px;
    -webkit-border-radius: 3px 3px;
    border-radius: 3px 3px;
    -moz-box-shadow: 0 1px #fff inset, 0 1px #ddd;
    -webkit-box-shadow: 0 1px #fff inset, 0 1px #ddd;
    box-shadow: 0 1px #fff inset, 0 1px #ddd;
    background: #f5f5f5;
    background: -moz-linear-gradient(top, #f5f5f5 0%, #eeeeee 100%);
    background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #f5f5f5), color-stop(100%, #eeeeee));
    background: -webkit-linear-gradient(top, #f5f5f5 0%, #eeeeee 100%);
    background: -o-linear-gradient(top, #f5f5f5 0%, #eeeeee 100%);
    background: -ms-linear-gradient(top, #f5f5f5 0%, #eeeeee 100%);
    background: linear-gradient(top, #f5f5f5 0%, #eeeeee 100%);
    filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#f5f5f5', endColorstr='#eeeeee', GradientType=0);
}
.main-center{
 	margin-top: 30px;
 	margin: 0 auto;
 	max-width: 400px;
    padding: 10px 40px;
	background:#3498DB;
	    color: #FFF;
    text-shadow: none;
	-webkit-box-shadow: 0px 3px 5px 0px rgba(0,0,0,0.31);
-moz-box-shadow: 0px 3px 5px 0px rgba(0,0,0,0.31);
box-shadow: 0px 3px 5px 0px rgba(0,0,0,0.31);

}
span.input-group-addon i {
    color: #009edf;
    font-size: 17px;
}

.login-button{
	margin-top: 5px;
}

.login-register{
	font-size: 11px;
	text-align: center;
}
            
        </style>   
          </head>
    <body>
    </head>
    
    
    
    <body>
    <%@ include file = "navbar.jsp" %>
       
  
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
    
    
    	<div class="container">
			<div class="row main">
				<div class="main-login main-center">
				<h3>Cadastro de usuário</h3>					
                                            <form method="post"  id="preCadastro"  action="PreCadastroServlet">
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Nome</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                <input type="text" name="nome" class="form-control" value="${usuario.nome}" required="true" placeholder="Digite o seu nome"/> 
							</div>
						</div>
                                                </div>   

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Email</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                <input type="email" name="email" class="form-control" value="${usuario.email}" placeholder="Digite o seu email" alt="" required="true"/> 
								</div>
							</div>
						</div>

<!--						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">Username</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="username" id="username"  placeholder="Enter your Username"/>
								</div>
							</div>
						</div>-->

						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Senha</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                <input type="password" name="senha" class="form-control" value="" placeholder="Digite a sua senha" required="true"/> 
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">Confirmação de Senha</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
								
                                                                                <input type="password" name="confirmaSenha" class="form-control" value="${confirmaSenha}"  required="true" placeholder="Confirme a sua senha"/> 

                                                                </div>
							</div>
						</div>

						<div class="form-group ">
						                <input type="submit" value="Cadastrar" id="salvar"  class="btn btn-primary btn-lg btn-block login-button" />

                                                   
						</div>
						
					</form>
				</div>
			</div>
		</div>
    
<!--    <div class="row">
       <div class="col-md-6 col-md-offset-3">
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

                <input type="submit" value="Entrar" id="salvar"  class="btn-lg btn-primary" />
                <input type="reset" value="Limpar"  class="btn btn-default" />
            </div>


        </div>
    </form>
       </div>-->
            </div>
    <%@ include file = "footer.jsp" %>