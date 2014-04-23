<%-- 
    Document   : index
    Created on : 02.04.2014, 13:34:25
    Author     : Holger Szuesz <hszuesz@live.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <myTags:header />
    </head>
    <body>
        <nav class="ui-corner-all">
            <myTags:navigation />
        </nav>
        
        <section id="main" class="ui-corner-all">
            <jsp:include page="<%="/WEB-INF/Template/Command/" + request.getAttribute("tplView")%>"></jsp:include>
        </section>
        
        <footer>
            <myTags:footer />
        </footer>
        
        <myTags:bodyincludes />
    </body>
</html>
