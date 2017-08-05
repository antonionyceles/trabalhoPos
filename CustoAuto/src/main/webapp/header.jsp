<%-- 
    Document   : header
    Created on : 29/06/2017, 14:39:09
    Author     : antoniony.lima
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.pos.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% if (session.getAttribute("usuario") == null) {
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content="<%=session.getMaxInactiveInterval()%>;url=<%=request.getContextPath()%>/index.jsp"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">  
           <link href="${pageContext.request.contextPath}/content/css/style.css"  rel="stylesheet" type="text/css"/>
           <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <title>JSP Page</title>
        <script>
            $(document).ready(function () {

                $('#loadingDiv').hide();
            });
            $('#loadingDiv')
                    .hide()  // Hide it initially
                    .ajaxStart(function () {
                        $(this).show();
                    })
                    .ajaxStop(function () {
                        $(this).hide();
                    })
                    ;

        </script>
    </head>
    <body>
<%@ include file = "navbar-painel.jsp" %>

       
   
        <c:if test="${messageType!=null}">

            <div class="alert alert-${messageType}" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <strong>${messageType}!</strong> ${message}
            </div>
        </c:if>

        <div id="loadingDiv">
            <img src="<c:url value="resource/image/ajax-loader.gif" />"/>
        </div>
