<%-- 
    Document   : index
    Created on : 02.04.2014, 13:34:25
    Author     : Holger Szuesz <hszuesz@live.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width">
        
        <link rel="stylesheet" href="/BookIT/css/main.css" />
        <link rel="stylesheet" href="/BookIT/js/libs/jqueryui/css/base/jquery.ui.all.css" />
        
        <title>BookIT - <%=request.getAttribute("strTitle")%></title>
    </head>
    <body>
        <nav>
            
        </nav>
        
        <section id="main">
            <jsp:include page="<%="/WEB-INF/" + request.getAttribute("tplView")%>"></jsp:include>
        </section>
        
        <footer>
            
        </footer>
        
        <script type="text/javascript" src="/BookIT/js/libs/jquery/jquery.js"></script>
        <script type="text/javascript" src="/BookIT/js/libs/jqueryui/jquery-ui.js"></script>
        <script type="text/javascript" src="/BookIT/js/libs/main.js"></script>
    </body>
</html>
