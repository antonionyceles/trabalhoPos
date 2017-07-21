<%-- 
    Document   : pre-cadastro
    Created on : 19/07/2017, 10:29:06
    Author     : antoniony.lima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "header.jsp" %>
<!DOCTYPE html>
<script>
   

</script>
<form method="post" id="preCadastro"   >

    <div class="row ">
        <div class="form-group col-md-4">
            <label for="nome">Nome</label> 
            <input type="text" name="nome" class="form-control" value="" required="true"/> 
        </div>
        <div class="form-group col-md-4">
            <label for="sobrenome">Sobrenome</label> 
            <input type="text" name="sobrenome" class="form-control" value="" required="true"/> 
        </div>
        <div class="form-group col-md-4">
            <label for="nascimento">Nascimento</label> 
            <input type="date" name="nascimento" class="form-control" value="" required="true"/> 
        </div>
    </div>
    <div class="row ">
        <div class="form-group col-md-4">
            <label for="telefone">Telefone</label> 
            <input type="text"  name="telefone" class="tel form-control" value=""  required="true"/> 
        </div>
        <div class="form-group col-md-4">
            <label for="celular">Celular</label> 
            <input type="text" name="celular" class="tel form-control" value="" required="true"/> 
        </div>

        <div class="form-group col-md-4">
            <label for="email">E-mail</label> 
            <input type="email" name="email" class="form-control" value="" placeholder="exemplo" alt="Exemplo exemplo@dominio.com" required="true"/> 
        </div>
    </div>
    <div class="row ">
        <div class="form-group col-md-4">
            <label for="senha">Senha</label> 
            <input type="password" name="senha" class="form-control" value="" alt="Senha forte utilizam letra, número e símbolos" required="true"/> 
        </div>
        <div class="form-group col-md-4">
            <label for="confirmaSenha">Confirmação de Senha</label> 
            <input type="password" name="confirmaSenha" class="form-control" value=""  required="true"/> 
        </div>
    </div>

    <hr />
    <div id="actions" class="row ">
        <div class="form-group col-md-6 pull-right">

            <input type="submit" value="Enviar" id="salvar" class="btn btn-default" />
            <input type="reset" value="Limpar"  class="btn btn-default" />
        </div>


    </div>
</form>
<%@ include file = "footer.jsp" %>