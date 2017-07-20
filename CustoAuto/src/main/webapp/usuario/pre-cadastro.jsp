<%-- 
    Document   : pre-cadastro
    Created on : 19/07/2017, 10:29:06
    Author     : antoniony.lima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "header.jsp" %>
<!DOCTYPE html>
<form method="post" action="PreCadastroServlet"  >
    
    <div class="row">
        <div class="form-group col-md-4">
            <label for="nome">Nome</label> 
            <input type="text" name="nome" class="form-control" value="" /> 
        </div>
        <div class="form-group col-md-4">
            <label for="sobrenome">Sobrenome</label> 
            <input type="text" name="sobrenome" class="form-control" value="" /> 
        </div>
         <div class="form-group col-md-4">
            <label for="telefone">Telefone</label> 
            <input type="text" name="telefone" class="form-control" value=""  /> 
        </div>
        <div class="form-group col-md-4">
            <label for="celular">Celular</label> 
            <input type="text" name="celular" class="form-control" value="" /> 
        </div>
        
        <div class="form-group col-md-4">
            <label for="email">E-mail</label> 
            <input type="email" name="email" class="form-control" value="" placeholder="exemplo" alt="Exemplo exemplo@dominio.com"/> 
        </div>
      
        <div class="form-group col-md-4">
            <label for="senha">Senha</label> 
            <input type="password" name="senha" class="form-control" value="" alt="Senha forte utilizam letra, número e símbolos" /> 
        </div>
        <div class="form-group col-md-4">
            <label for="confirma-senha">Confirmação de Senha</label> 
            <input type="password" name="confirma-senha" class="form-control" value=""  /> 
        </div>
    </div>
    <hr />
    <div id="actions" class="row">
        <div class="col-md-12">
            <input type="submit" value="Entrar"  class="btn btn-default" />
        </div>
    </div>
</form>
<%@ include file = "footer.jsp" %>