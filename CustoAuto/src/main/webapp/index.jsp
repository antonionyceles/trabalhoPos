
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header.jsp" %>




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