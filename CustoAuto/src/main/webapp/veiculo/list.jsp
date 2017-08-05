<%-- 
    Document   : form
    Created on : 17/06/2017, 14:47:58
    Author     : aluno
--%>


<%@page import="java.math.BigInteger"%>
<%@page import="com.pos.bo.VeiculoBO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.pos.entity.VeiculoUsuario"%>
<%@page import="java.util.List"%>

<%@ include file = "../header.jsp" %>

<div id="main" class="container" >
    
     <div class="panel panel-default">

    <div id="top" class="row">
        <div class="col-sm-3">
            <h2>Veiculos Cadastrados</h2>
        </div>
        <div class="col-sm-6">
        </div>
        <div class="col-sm-3">
            <a href="form.jsp?operacao=1" class="btn btn-primary pull-right h2">Novo Item</a>
        </div>
    </div> <!-- /#top -->
    

    <hr />
    <div id="list" class="row">
        
        <div class="table-responsive col-md-12">
            <table class="table table-striped" cellspacing="0" cellpadding="0">
                <thead>
                    <tr>
                        <th>Cod</th>
                        <th>Tipo</th>
                        <th>Descrição</th>
                        <th>Placa</th>

                        <th class="actions">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    
                    <%  
                        List<VeiculoUsuario> lista = (List<VeiculoUsuario>)request.getAttribute("listaVeiculos");                        
                        if (lista == null ){
                            lista = new VeiculoBO().findByUser( BigInteger.valueOf(4) );
                        }
                        
                    %>                    
                        <% for (VeiculoUsuario vc : lista) { %>
                            </tr>
                                <td><%= vc.getId()%></td>
                                <td><%= vc.getNomeTipo() %></td>
                                <td><%= vc.getDescricao()%></td>
                                <td><%= vc.getPlaca()%></td>
                                
                                <td class="actions">
                                    <a class="btn btn-warning btn-xs" href="edit.jsp?operacao=2&id=<%=vc.getId()%>">Editar</a>
                                    <a class="btn btn-danger btn-xs"  href="../VeiculoServlet?operacao=3&id=<%=vc.getId()%>" data-toggle="modal" data-target="#delete-modal">Excluir</a>
                                </td>
                            <tr>                              

                        <%} %>>                        
                    </tr>

                </tbody>
            </table>
        </div>
    </div>

    </div> <!-- /#list -->

    
</div> <!-- /#main -->

<!-- Modal -->
<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="modalLabel">Excluir Item</h4>
            </div>
            <div class="modal-body">
                Deseja realmente excluir este item?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">Sim</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
            </div>
        </div>
    </div>
</div>


<%@include file="../footer.jsp" %>
