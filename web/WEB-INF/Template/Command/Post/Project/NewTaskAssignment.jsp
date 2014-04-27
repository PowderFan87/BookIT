<%-- 
    Document   : NewTaskAssignment
    Created on : 27.04.2014, 15:30:37
    Author     : Holger Szuesz <hszuesz@live.com>
--%>

<%@page import="App.Tools.Util"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>
<% if(!Util.isEmptyArray((String[])request.getAttribute("errors"))) { %>
    <jsp:include page="../../Get/Project/NewTaskAssignment.jsp" />
    
    <myTags:formerrors />
<% } else { %>
    <h2>New User successfully assigned to task</h2>
<% } %>