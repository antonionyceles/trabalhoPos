 <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Despesa de Veículo 0.1</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="<%=request.getContextPath() != null ? request.getContextPath() + "/" : ""%>menu.jsp">Início</a></li>
                        <li><a href="<%=request.getContextPath() != null ? request.getContextPath() + "/" : ""%>LoginServlet?operacao=2"  >Sair</a></li>

                    </ul>
                </div>
            </div>
        </nav>