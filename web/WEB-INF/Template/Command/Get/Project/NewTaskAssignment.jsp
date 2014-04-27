<%-- 
    Document   : NewTaskAssignment
    Created on : 27.04.2014, 12:53:40
    Author     : Holger Szuesz <hszuesz@live.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>New task assignment</h2>

<form action="/BookIT/p/Project/NewTaskAssignment" method="POST">
    <input type="hidden" id="tblTask_UID" name="tblTask_UID" value="${param.tblTask_UID}" />
    <table>
        <tr>
            <th><label for="tblUser_UID">User: </label></th>
            <td>
                <select id="tblUser_UID" name="tblUser_UID" class="text ui-widget-content ui-corner-all">
                    <option value="">--- Auswahl ---</option>
                <c:forEach var="User" items="${requestScope['lisUser']}">
                    <option value="<c:out value="${User.UID}" />"><c:out value="${User.strUsername}" /></option>
                </c:forEach>
                </select>
                <script type="text/javascript">
                    $(document).ready(function(){
                        ($("#tblUser_UID option[value='${param.tblUser_UID}']").length === 1)?$("#tblUser_UID option[value='${param.tblUser_UID}']").attr('selected', 'selected'):null;
                    });
                </script>
            </td>
        </tr>
        <tr>
            <th><label for="lngGrantedminutes">Cap (in minutes)</label></th>
            <td><input type="number" id="lngGrantedminutes" name="lngGrantedminutes" value="${0 + param.lngGrantedminutes}" step="5" class="text ui-widget-content ui-corner-all" /></td>
        </tr>
        <tr>
            <th>&nbsp;</th>
            <td><input type="submit" value="Assign user" class="ui-button ui-widget ui-state-default ui-corner-all" /></td>
        </tr>
    </table>
</form>