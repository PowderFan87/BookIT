<%-- 
    Document   : Project
    Created on : 26.04.2014, 12:43:08
    Author     : Holger Szuesz <hszuesz@live.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form id="project" name="project"></form>

<h2>Project</h2>

<strong>Projectlist for user </strong>

<h3>Projectlist</h3>
<table>
    <thead>
        <tr>
            <th>#</th>
            <th>Title</th>
            <th>Description</th>
            <th>Status</th>
            <th style="text-align: right;">
                <button form="project" formaction="/BookIT/g/Project/NewProject" formmethod="GET">New</button>
            </th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="Project" items="${requestScope['lisProject']}">
        <tr>
            <td>P#<c:out value="${Project.UID}" /></td>
            <td><c:out value="${Project.strName}" /></td>
            <td><c:out value="${Project.txtDescription}" /></td>
            <td><c:out value="${Project.strStatus}" /></td>
            <td>
                <button form="project" formaction="/BookIT/g/Project/ViewProject" formmethod="GET" name="UID" value="<c:out value="${Project.UID}" />">View</button>
                <button form="project" formaction="/BookIT/p/Project/EditProject" formmethod="POST" name="UID" value="<c:out value="${Project.UID}" />">Edit</button>
                <button form="project" formaction="/BookIT/p/Project/DeleteProject" formmethod="POST" name="UID" value="<c:out value="${Project.UID}" />">Delete</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>