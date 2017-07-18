<%@page import="com.pos.entity.Movimentacao"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="com.pos.entity.Veiculo"%>
<%@ include file = "../header.jsp" %>


<% Map<String, Movimentacao> vcMap = (Map<String, Movimentacao>) (request.getSession().getAttribute("movimentacaoList"));
    Movimentacao mov = vcMap.get(request.getParameter("id"));
%>
<div id="main" class="container-fluid" >
    <form id="movimentacao" action="../MovimentoServlet" method="post">
        <input type="hidden" name="operacao" value="<%=request.getParameter("operacao")%>"/>
        <input type="hidden" name="id" value="<%=request.getParameter("id")%>"/>
        <div class="form-group col-md-6">
            <label for="categoria"> Categoria de Gasto</label>
            <select name="categoria" class="form-control">
                <option value="1" label="IPVA">IPVA</option>
                <option value="2" label="Combustível"/>Combustível</option>
                <option value="3" label="Mecânico"/>Mecânico</option>

            </select>
        </div>
        <div class="form-group col-md-6">
            <label for="data">Data</label>
            <input type="date" class="form-control" name="data"/>
            <label for="valor">Valor R$</label>
            <input type="number" class="form-control" name="valor" value="<%=mov.getValor()%>" />
        </div>
        <div class="form-group col-md-6">
            <label for="veiculo"> Veículo</label>
            <select name="veiculo" class="form-control">
                <%if (request.getSession().getAttribute("veiculoList") != null) {
                        Map<String, Veiculo> mp = (Map<String, Veiculo>) request.getSession().getAttribute("veiculoList");

                        Iterator it = mp.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry pair = (Map.Entry) it.next();
                            Veiculo vc
                                    = (Veiculo) pair.getValue();
                %>

                <option value="<%=vc.getId()%>" label="<%=vc.getTipo()%><%=vc.getModelo()%>"><%=vc.getTipo()%><%=vc.getModelo()%></option>

                <%}%>
            </select>

            <%   }%>
            <label for="km">Km da despesa</label>
            <input type="number" class="form-control" name="km" value="<%=mov.getKm()%>"/>
        </div>
        <div class="row pull-right">
            <div class="col-md-12 ">
                <input type="submit" value="Adicionar Despesa" />
            </div>
        </div>
    </form>
</div>

<%@include file="../footer.jsp" %>