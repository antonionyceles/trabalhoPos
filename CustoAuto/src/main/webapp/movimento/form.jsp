<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="com.pos.entity.VeiculoUsuario"%>
<%@ include file = "../header.jsp" %>
<div id="main" class="container" >

    <div class="panel panel-default">
        <form id="movimentacao" action="../MovimentoServlet" method="post">
            <input type="hidden" name="operacao" value="<%=request.getParameter("operacao")%>"/>

            <div class="col-md-12">
                <div class="form-group col-md-6">
                    <label for="categoria"> Categoria de Gasto</label>
                    <select name="categoria" class="form-control">
                        <option value="CP" label="IPVA">Peças</option>
                        <option value="CO" label="Combustível"/>Combustível</option>
                        <option value="OF" label="Mecânico"/>Mecânico</option>
                        <option value="LA" label="Lavagem"/>Lavagem</option>
                        <option value="IM" label="Imposto"/>Imposto</option>

                    </select>
                </div>
                <div class="form-group col-md-6">
                    <label for="data">Data</label>
                    <input type="date" class="form-control" name="dataDespesa"/>

                </div>
            </div>


            <div class="col-md-12">

                <div class="form-group col-md-6">

                    <label for="valor">Valor R$</label>
                    <input type="number" class="form-control" name="valor" />
                </div>

                <div class="form-group col-md-6">
                    <label for="veiculo"> Veículo</label>
                    <select name="veiculo" class="form-control">

                        <c:forEach items="${veiculoL}" var="vc">

                            <option value="${vc.getId()}" label="${vc.getTipo}-${vc.getDescricao()}">${vc.getDescricao()}</option>
                        </c:forEach>


                    </select>


                    <label for="km">Km da despesa</label>
                    <input type="number" class="form-control" name="kilometragem"/>
                    <label for="descricao">Descrição</label>
                    <input type="text" class="form-control" name="descricao"/>
                </div>
            </div>


            <div class="col-md-12 ">
                <input type="submit" class="btn btn-primary" value="Adicionar Despesa" />
            </div>

        </form>
        <div class="clearfix"></div>
    </div>


</div>

<%@include file="../footer.jsp" %>