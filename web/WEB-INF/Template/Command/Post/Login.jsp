<%-- 
    Document   : Login
    Created on : 19.04.2014, 16:09:01
    Author     : Holger Szuesz <hszuesz@live.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% if(App.Security.isLoggedIn(request)) { %>
<h2>Login successfull</h2>

<strong>Welcome to BookIT</strong>
<% } else { %>
<h2>Login failed</h2>

<strong>
    Sorry we couldn't log you in :(<br />
    Please <a href="/BookIT">try again</a>
</strong>
<% } %>