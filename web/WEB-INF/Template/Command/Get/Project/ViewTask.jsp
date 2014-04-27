<%-- 
    Document   : ViewTask
    Created on : 27.04.2014, 09:08:22
    Author     : Holger Szuesz <hszuesz@live.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form id="task" name="task">
    <input type="hidden" name="tblTask_UID" value="<jsp:getProperty name="Task" property="UID" />" />
</form>

<h2>T#<jsp:getProperty name="Task" property="UID" /> <jsp:getProperty name="Task" property="strName" /></h2>

<table>
    <tr>
        <th>Description</th>
        <td><jsp:getProperty name="Task" property="txtDescription" /></td>
    </tr>
    <tr>
        <th>Status</th>
        <td><jsp:getProperty name="Task" property="strStatus" /></td>
    </tr>
    <tr>
        <th>Deadline</th>
        <td><jsp:getProperty name="Task" property="strDeadline" /></td>
    </tr>
</table>
    
<br />

<h4>Assignments</h4>

<table>
    <thead>
        <tr>
            <th>User</th>
            <th>Cap</th>
            <th>Worked</th>
            <th>Bookings</th>
            <th style="text-align: right;">
                <button class="btnnew" form="task" formaction="/BookIT/g/Project/NewTaskAssignment" formmethod="GET">New</button>
            </th>
        </tr>
    </thead>
    <tbody>
    <c:set var="lngSumGranted" value="${0}" />
    <c:set var="lngSumWorked" value="${0}" />
    <c:set var="lngSumBookings" value="${0}" />
        
    <c:forEach var="UserHasTask" items="${requestScope['Task'].lisAssignments}">
        <tr>
            <td><c:out value="${UserHasTask.strDisplayname}" /></td>
            <td>
                <c:out value="${UserHasTask.lngGrantedminutes}" />
                <c:set var="lngSumGranted" value="${lngSumGranted + UserHasTask.lngGrantedminutes}" />
            </td>
            <td>
                <c:out value="${UserHasTask.lngMinutesworked}" />
                <c:set var="lngSumWorked" value="${lngSumWorked + UserHasTask.lngMinutesworked}" />
            </td>
            <td>
                <c:out value="${UserHasTask.lngBookingscount}" />
                <c:set var="lngSumBookings" value="${lngSumBookings + UserHasTask.lngBookingscount}" />
            </td>
            <td>
                <button class="btnview" form="task" formaction="/BookIT/g/Project/ViewAssignment" formmethod="GET" name="tblUser_UID" value="<c:out value="${UserHasTask.tblUser_UID}" />">View</button>
                <button class="btnedit" form="task" formaction="/BookIT/p/Project/EditAssignment" formmethod="POST" name="tblUser_UID" value="<c:out value="${UserHasTask.tblUser_UID}" />">Edit</button>
                <button class="btndelete" form="task" formaction="/BookIT/p/Project/DeleteAssignment" formmethod="POST" name="tblUser_UID" value="<c:out value="${UserHasTask.tblUser_UID}" />">Delete</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    <tfoot>
        <tr>
            <td>=</td>
            <td><c:out value="${lngSumGranted}" /></td>
            <td><c:out value="${lngSumWorked}" /></td>
            <td><c:out value="${lngSumBookings}" /></td>
            <td>&nbsp;</td>
        </tr>
    </tfoot>
</table>