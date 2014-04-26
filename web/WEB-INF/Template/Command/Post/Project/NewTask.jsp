<%-- 
    Document   : NewTask
    Created on : 27.04.2014, 01:08:33
    Author     : Holger Szuesz <hszuesz@live.com>
--%>

<%@page import="App.Tools.Util"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>
<% if(!Util.isEmptyArray((String[])request.getAttribute("errors"))) { %>
    <jsp:include page="../../Get/Admin/NewTask.jsp" />
    
    <myTags:formerrors />
<% } else { %>
    <h2>New Task successfully created</h2>
<% } %>