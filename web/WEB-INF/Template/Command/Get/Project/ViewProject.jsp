<%-- 
    Document   : ViewProject
    Created on : 27.04.2014, 09:08:40
    Author     : Holger Szuesz <hszuesz@live.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form id="project" name="project"></form>

<h2>P#<jsp:getProperty name="Project" property="UID" /> <jsp:getProperty name="Project" property="strName" /></h2>

<h4>Description:</h4>

<jsp:getProperty name="Project" property="txtDescription" />

<br />&nbsp;<br />

<h3>Tasks: </h3>

<table>
    <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Description</th>
            <th>Deadline</th>
            <th>Status</th>
            <th>Assigned Users</th>
            <th style="text-align: right;">
                <button class="btnnew" form="project" formaction="/BookIT/g/Project/NewTask" formmethod="GET" name="id" value="<jsp:getProperty name="Project" property="UID" />">New</button>
            </th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="Task" items="${requestScope['Project'].lisTasks}">
        <tr>
            <td>T#<c:out value="${Task.UID}" /></td>
            <td><c:out value="${Task.strName}" /></td>
            <td><c:out value="${Task.txtDescription}" /></td>
            <td><c:out value="${Task.strDeadline}" /></td>
            <td><c:out value="${Task.strStatus}" /></td>
            <td>
            <c:forEach var="User" items="${Task.lisAssignedUser}">
                <c:out value="${User.strDisplayname}" /><br />
            </c:forEach>
            </td>
            <td>
                <button class="btnview" form="project" formaction="/BookIT/g/Project/ViewTask" formmethod="GET" name="UID" value="<c:out value="${Task.UID}" />">View</button>
                <button class="btnedit" form="project" formaction="/BookIT/p/Project/EditTask" formmethod="POST" name="UID" value="<c:out value="${Task.UID}" />">Edit</button>
                <button class="btndelete" form="project" formaction="/BookIT/p/Project/DeleteTask" formmethod="POST" name="UID" value="<c:out value="${Task.UID}" />">Delete</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>