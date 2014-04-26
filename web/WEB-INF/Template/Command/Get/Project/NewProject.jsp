<%-- 
    Document   : NewProject
    Created on : 26.04.2014, 13:14:54
    Author     : Holger Szuesz <hszuesz@live.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>New Project</h2>

<form action="/BookIT/p/Project/NewProject" method="POST">
    <table>
        <tr>
            <th><label for="strName">Name:</label></th>
            <td><input type="text" id="strName" name="strName" value="<c:out value="${requestScope['strName']}" />" class="text ui-widget-content ui-corner-all" /></td>
        </tr>
        <tr>
            <th><label for="txtDescription">Description:</label></th>
            <td>
                <textarea id="txtDescription" name="txtDescription" class="text ui-widget-content ui-corner-all">
                    <c:out value="${requestScope['txtDescription']}" />
                </textarea>
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>
                <input type="submit" value="Create Project" class="ui-button ui-widget ui-state-default ui-corner-all" />
            </td>
        </tr>
    </table>
</form>