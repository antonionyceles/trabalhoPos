<%-- 
    Document   : form
    Created on : 17/06/2017, 14:47:58
    Author     : aluno
--%>


<%@page import="java.math.BigDecimal"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>

<%@page import="java.util.List"%>

<%@ include file = "../header.jsp" %>
<%BigDecimal total = new BigDecimal("0");%>

<div id="main" class="container-fluid" style="margin-top: 50px">

    <div id="top" class="row">
        <div class="col-sm-3">
            <h2>Movimentacao Cadastrada</h2>
        </div>
        <div class="col-sm-6">

            <!--            <div class="input-group h2">
                            <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Itens">
                            <span class="input-group-btn">
                                <button class="btn btn-primary" type="submit">
                                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                            </span>
                        </div>-->

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
                        <th>Veiculo</th>
                        <th>Km</th>
                        <th>Data</th>
                        <th>Ação</th>

                        <th class="actions">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${despesaVeiculoL}" var="despesa">
                        <tr>
                            <td>${despesa.getId()}</td>
                            <td>${despesa.getValor()}</td>
                            <td>${ despesa.getKm()}</td>
                            <td>${despesa.getDataCadastro()}</td>


                            <td class="actions">
                                <!--<a class="btn btn-success btn-xs" href="view.html">Visualizar</a>-->
                                <a class="btn btn-warning btn-xs" href="edit.jsp?operacao=2&id=${despesa.getId()}">Editar</a>
                                <a class="btn btn-danger btn-xs"  href="../MovimentoServlet?operacao=3&id=${despesa.getId()}" data-toggle="modal" data-target="#delete-modal">Excluir</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody >

            </table>
            <div class="row">Total: <%=total%></div>
        </div>

    </div> <!-- /#list -->

    <div id="bottom" class="row">
        <div class="col-md-12">
            <ul class="pagination">
                <li class="disabled"><a>&lt; Anterior</a></li>
                <li class="disabled"><a>1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li class="next"><a href="#" rel="next">Próximo &gt;</a></li>
            </ul><!-- /.pagination -->
        </div>
    </div> <!-- /#bottom -->
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


<%--<%@include file="../footer.jsp" %>--%>
