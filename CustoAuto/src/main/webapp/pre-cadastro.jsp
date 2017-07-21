<%-- 
    Document   : pre-cadastro
    Created on : 19/07/2017, 10:29:06
    Author     : antoniony.lima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "header.jsp" %>
<%@ page import="com.pos.entity.Cliente" %>
<%@ page import="com.pos.entity.Usuario" %>
<!DOCTYPE html>
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