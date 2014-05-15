<%-- 
    Document   : Edit
    Created on : 30.04.2014, 12:01:38
    Author     : Holger Szuesz <hszuesz@live.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>Edit</h2>

<form action="/BookIT/p/MyAccount/Edit" method="POST">
    <table>
        <tr>
            <th>
                <label for="strName">Name</label>
            </th>
            <td>
                <input type="text" id="strName" name="strName" value="${requestScope['Profile'].strName}" class="text ui-widget-content ui-corner-all" />
            </td>
        </tr>
        <tr>
            <th>
                <label for="strSurname">Surname</label>
            </th>
            <td>
                <input type="text" id="strSurname" name="strSurname" value="${requestScope['Profile'].strSurname}" class="text ui-widget-content ui-corner-all" />
            </td>
        </tr>
        <tr>
            <th>
                <label for="strEmail">E-Mail</label>
            </th>
            <td>
                <input type="text" id="strEmail" name="strEmail" value="${requestScope['Profile'].strEmail}" class="text ui-widget-content ui-corner-all" />
            </td>
        </tr>
        <tr>
            <th>
                <label for="strCustomstartpage">Custom start page</label>
            </th>
            <td>
                <select id="strCustomstartpage" name="strCustomstartpage" class="text ui-widget-content ui-corner-all">
                    <option value="">--- Default ---</option>
                    <option value="/BookIT/g/Dashboard">Dashboard</option>
                    <option value="/BookIT/g/Project">Projects</option>
                    <option value="/BookIT/g/MyAccount">MyAccount</option>
                    <option value="other">--- Other ---</option>
                </select>
            </td>
        </tr>
        <tr>
            <th style="text-align: right;"><label for="strOthercustompage">Other</label></th>
            <td>
                <input type="text" id="strOthercustompage" name="strOthercustompage" class="text ui-widget-content ui-corner-all" disabled="disabled" />
            </td>
        </tr>
    </table>
</form>
            
<script type="text/javascript">
    $(document).ready(function(){
        $("#strCustomstartpage").on("change", function(){
            ($(this).val()==="other")?$("#strOthercustompage").removeAttr("disabled"):$("#strOthercustompage").attr("disabled","disabled");
        });
        
        if($("option[value='${requestScope['Profile'].strCustomstartpage}']").length===1){
            $("option[value='${requestScope['Profile'].strCustomstartpage}']").attr("selected", "selected");
        } else if("${requestScope['Profile'].strCustomstartpage}" !== "") {
            $("option[value='other']").attr("selected", "selected");
            $("#strOthercustompage").val("${requestScope['Profile'].strCustomstartpage}");
        }
    });
</script>