<%-- 
    Document   : NewUser
    Created on : 23.04.2014, 16:23:10
    Author     : Holger Szuesz <hszuesz@live.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>
<% if(((String[])request.getAttribute("errors")).length > 0) { %>
    <jsp:include page="../../Get/Admin/NewUser.jsp" />
    
    <myTags:formerrors />
<% } else { %>
    <h2>New User successfully created</h2>
<% } %>