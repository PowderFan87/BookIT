<%-- 
    Document   : navigation
    Created on : 23.04.2014, 10:17:52
    Author     : Holger Szuesz <hszuesz@live.com>
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- any content can be specified here e.g.: --%>
<a href="/BookIT/g/Dashboard">Dashboard</a>

<% if(App.Security.isAdmin(request)) { %>
<a href="/BookIT/g/Admin">Administration</a>
<% } %>

<% if(App.Security.canAccess("Project", request)) { %>
<a href="/BookIT/g/Project">Projects</a>
<% } %>

<a href="/BookIT/g/MyAccount">MyAccount</a>
<a href="#" onclick="">Logout</a>

<form action="/BookIT/p/Logout" method="POST">
    <input type="submit" value="LOGOUT" />
</form>