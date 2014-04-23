<%-- 
    Document   : NewUser
    Created on : 23.04.2014, 15:48:54
    Author     : Holger Szuesz <hszuesz@live.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>New User</h2>

<form action="/BookIT/p/Admin/NewUser" method="POST">
    <table>
        <tr>
            <th><label for="strUsername">Username:</label></th>
            <td><input type="text" id="strUsername" name="strUsername" value="<c:out value="${requestScope['strUsername']}" />" class="text ui-widget-content ui-corner-all" /></td>
        </tr>
        <tr>
            <th><label for="strEmail">E-Mail:</label></th>
            <td><input type="text" id="strEmail" name="strEmail" value="<c:out value="${requestScope['strEmail']}" />" class="text ui-widget-content ui-corner-all" /></td>
        </tr>
        <tr>
            <th><label for="lngUsertype">Usertype:</label></th>
            <td>
                <select id="lngUsertype" name="lngUsertype" class="text ui-widget-content ui-corner-all">
                    <option value="">--- Auswahl ---</option>
                    <option value="0">Admin</option>
                    <option value="1">Projectmanager</option>
                    <option value="2">Developer</option>
                    <option value="3">Designer</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>
                <input type="submit" value="Create User" class="ui-button ui-widget ui-state-default ui-corner-all" />
            </td>
        </tr>
    </table>
</form>