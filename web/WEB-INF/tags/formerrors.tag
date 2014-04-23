<%-- 
    Document   : formerrors
    Created on : 23.04.2014, 16:55:09
    Author     : Holger Szuesz <hszuesz@live.com>
--%>

<%@tag description="Custom tag to mark form fields red on error" pageEncoding="UTF-8"%>

<%-- any content can be specified here e.g.: --%>
<script type="text/javascript">
    $(document).ready(function(){
    <% for(String strField: (String[])request.getAttribute("errors")) { %>
        $("#<%=strField%>").addClass("ui-state-error ");
        $("label[for='<%=strField%>']").parent().addClass("ui-state-error ");
    <% } %>
    });
</script>