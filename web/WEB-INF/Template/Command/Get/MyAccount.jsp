<%-- 
    Document   : MyAccount
    Created on : 30.04.2014, 11:28:45
    Author     : Holger Szuesz <hszuesz@live.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form id="account" name="account"></form>

<h2>MyAccount</h2>

<div class="cols2-left">
    <div id="datatab" class="tab">
        <ul>
            <li>
                <a href="#datacontent">Details</a>
            </li>
        </ul>
        
        <div id="datacontent" class="tabcontent">
            <table>
                <tr>
                    <th>Username</th>
                    <td><jsp:getProperty name="User" property="strUsername" /></td>
                </tr>
                <tr>
                    <th>Name</th>
                    <td><c:out value="${requestScope['Profile'].strName}" /></td>
                </tr>
                <tr>
                    <th>Surname</th>
                    <td><c:out value="${requestScope['Profile'].strSurname}" /></td>
                </tr>
                <tr>
                    <th>E-Mail</th>
                    <td><jsp:getProperty name="Profile" property="strEmail" /></td>
                </tr>
                <tr>
                    <th>Custom Start Page</th>
                    <td><c:out value="${requestScope['Profile'].strCustomstartpage}" /></td>
                </tr>
                <tr>
                    <th>&nbsp;</th>
                    <td>
                        <button form="account" formaction="/BookIT/g/MyAccount/Edit" formmethod="GET" class="ui-button ui-widget ui-state-default ui-corner-all">Edit Details</button>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>

<div class="cols2-right">
    <div id="statstab" class="tab">
        <ul>
            <li>
                <a href="#statscontent">Statistic</a>
            </li>
        </ul>
        
        <div id="statscontent" class="tabcontent">
            
        </div>
    </div>
</div>

<br clear="all" />&nbsp;<br />

<script type="text/javascript">
    $(document).ready(function(){
        $(".tab").tabs();
    });
</script>