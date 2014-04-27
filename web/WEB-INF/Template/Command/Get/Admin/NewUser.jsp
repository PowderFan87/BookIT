<%-- 
    Document   : NewUser
    Created on : 23.04.2014, 15:48:54
    Author     : Holger Szuesz <hszuesz@live.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>New User</h2>

<form action="/BookIT/p/Admin/NewUser" method="POST">
    <table>
        <tr>
            <th><label for="strUsername">Username:</label></th>
            <td><input type="text" id="strUsername" name="strUsername" value="${param.strUsername}" class="text ui-widget-content ui-corner-all" /></td>
        </tr>
        <tr>
            <th><label for="strEmail">E-Mail:</label></th>
            <td><input type="text" id="strEmail" name="strEmail" value="${param.strEmail}" class="text ui-widget-content ui-corner-all" /></td>
        </tr>
        <tr>
            <th><label for="strPassword">Password:</label></th>
            <td><input type="text" id="strPassword" name="strPassword" value="${param.strPassword}" class="text ui-widget-content ui-corner-all" /></td>
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
                <script type="text/javascript">
                    $(document).ready(function(){
                        ($("#lngUsertype option[value='${param.lngUsertype}']").length === 1)?$("#lngUsertype option[value='${param.lngUsertype}']").attr('selected', 'selected'):null;
                    });
                </script>
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