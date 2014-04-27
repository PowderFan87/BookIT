<%-- 
    Document   : ViewAssignment
    Created on : 27.04.2014, 15:34:26
    Author     : Holger Szuesz <hszuesz@live.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>Assignment (T#<jsp:getProperty name="UserHasTask" property="tblTask_UID" />, <jsp:getProperty name="UserHasTask" property="strUsername" />)</h2>

<h4>Details</h4>

<table>
    <tr>
        <th>Cap</th>
        <td><jsp:getProperty name="UserHasTask" property="lngGrantedminutes" /></td>
    </tr>
    <tr>
        <th>Minutes left</th>
        <td><jsp:getProperty name="UserHasTask" property="lngMinutesleft" /></td>
    </tr>
    <tr>
        <th>Amount of bookings</th>
        <td><jsp:getProperty name="UserHasTask" property="lngBookingscount" /></td>
    </tr>
    <tr>
        <th>Avg. time booked</th>
        <td><jsp:getProperty name="UserHasTask" property="lngAvgBookedMinutes" /> per booking</td>
    </tr>
</table>
    
<h4>Bookings</h4>

<table>
    <thead>
        <tr>
            <th>#</th>
            <th>Date</th>
            <th>Minutes</th>
            <th>Comment</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="Booking" items="${requestScope['UserHasTask'].lisBookings}">
        <tr>
            <td>B#<c:out value="${Booking.UID}" /></td>
            <td><c:out value="${Booking.strDate}" /></td>
            <td><c:out value="${Booking.lngMinutes}" /></td>
            <td><c:out value="${Booking.strComment}" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>