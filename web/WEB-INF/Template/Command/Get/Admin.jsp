<%-- 
    Document   : Test2
    Created on : 19.04.2014, 16:12:49
    Author     : Holger Szuesz <hszuesz@live.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<jsp:useBean id="User" class="App.Data.User" scope="request" />--%>

<form id="admin" name="admin"></form>

<h2>Administration</h2>

<strong>Administration for BookIT. Basic overview for users, projects and tasks is displayed</strong>

<h3>Userlist</h3>
<table>
    <thead>
        <tr>
            <th>#</th>
            <th>Username</th>
            <th>Password</th>
            <th style="text-align: right;">
                <button form="admin" formaction="/BookIT/g/Admin/NewUser" formmethod="GET">New</button>
            </th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="User" items="${requestScope['lisUser']}">
        <tr>
            <td><c:out value="${User.UID}" /></td>
            <td><c:out value="${User.strUsername}" /></td>
            <td><c:out value="${User.strPassword}" /></td>
            <td>
                <button form="admin" formaction="/BookIT/g/Admin/ViewUser" formmethod="GET" name="UID" value="<c:out value="${User.UID}" />">View</button>
                <button form="admin" formaction="/BookIT/p/Admin/EditUser" formmethod="POST" name="UID" value="<c:out value="${User.UID}" />">Edit</button>
                <button form="admin" formaction="/BookIT/p/Admin/DeleteUser" formmethod="POST" name="UID" value="<c:out value="${User.UID}" />">Delete</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>