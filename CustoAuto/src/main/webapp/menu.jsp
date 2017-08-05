<%-- 
    Document   : form
    Created on : 17/06/2017, 14:47:58
    Author     : aluno
--%>

<%@page import="com.pos.entity.Usuario"%>
<%@ include file = "header.jsp" %>

<div class="container ">
    
    <div class="panel panel-default">
  <ul class="nav nav-tabs">
  <li class="active"><a data-toggle="tab" href="#veiculos">Veículos</a></li>
  <li><a data-toggle="tab" href="#despesas">Despesas</a></li>
</ul>

<div class="tab-content">
  <div id="veiculos" class="tab-pane fade in active">
    
  <br>  
                     
                            <a href="veiculo/list.jsp" class="btn btn-primary">Consultar Veículo</a> <br> <br>                       
                   
                            <a href="veiculo/form.jsp?operacao=1" class="btn btn-primary">Cadastrar Veículo</a>
                       
                  
  </div>
  <div id="despesas" class="tab-pane fade">
   
 <br>  
      <a href="movimento/list.jsp" class="btn btn-warning">Consultar Despesa</a> <br>  <br>  
                        <a href="movimento/form.jsp?operacao=1" class="btn btn-warning">Cadastrar Despesa</a>
                   
  </div>
  
</div>
</div>
</div>

<!--<div id="main" class="container" >
    
    <div class="row">
        
       <div class="col-md-10 col-md-offset-1" style="border-radius: 4px; border: 1px solid #ddd;">

    <form class="form" method="post" action="abastecer.jsp">
        <div id="sidebar">
            <div class="col-md-4">
                <h1>Seja bem vindo ${ sessionScope.usuario.getNome()}</h1>
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
</div>
</div>-->

