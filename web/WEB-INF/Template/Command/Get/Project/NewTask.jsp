<%-- 
    Document   : NewTask
    Created on : 27.04.2014, 01:19:09
    Author     : Holger Szuesz <hszuesz@live.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>New Task</h2>

<form action="/BookIT/p/Project/NewTask" method="POST">
    <input type="hidden" id="tblProject_UID" name="tblProject_UID" value="${param.tblProject_UID}" />
    
    <table>
        <tr>
            <th><label for="strName">Name:</label></th>
            <td><input type="text" id="strName" name="strName" value="${param.strName}" class="text ui-widget-content ui-corner-all" /></td>
        </tr>
        <tr>
            <th><label for="txtDescription">Description:</label></th>
            <td>
                <textarea id="txtDescription" name="txtDescription" class="text ui-widget-content ui-corner-all">${param.txtDescription}</textarea>
            </td>
        </tr>
        <tr>
            <td><label for="dtmDeadline">Deadline:</label></td>
            <td><input type="date" id="dtmDeadline" name="dtmDeadline" value="${param.dtmDeadline}" class="text ui-widget-content ui-corner-all" /></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>
                <input type="submit" value="Create Project" class="ui-button ui-widget ui-state-default ui-corner-all" />
            </td>
        </tr>
    </table>
</form>