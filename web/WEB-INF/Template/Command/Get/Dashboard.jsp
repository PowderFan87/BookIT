<%-- 
    Document   : Dashboard
    Created on : 23.04.2014, 13:21:45
    Author     : Holger Szuesz <hszuesz@live.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>Dashboard</h2>

<div class="cols2-left">
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
    
<div class="cols2-right">
    <div id="tasktab" class="tab">
        <ul>
            <li>
                <a href="#taskcontent">Tasks</a>
            </li>
        </ul>

        <div id="taskcontent" class="tabcontent">
            <table>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Deadline</th>
                        <th>Left minutes</th>
                        <th>Done minutes</th>
                        <th>&nbsp;</th>
                    </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>
    </div>
</div>
    
<br clear="all" />

<script type="text/javascript">
$(document).ready(function(){
    $(".tab").tabs();
    
    $.post("/BookIT/a/Dashboard/UpdateTasks", parseTasks);
    
    taskloader = window.setInterval(function(){
        $.post("/BookIT/a/Dashboard/UpdateTasks", parseTasks);
    }, 10000);
});

function parseTasks(data) {
    $("#taskcontent table tbody").html("");
    
    for(i in data.tasks) {
        $("#taskcontent table tbody").append("\
            <tr>\n\
                <td>" + data.tasks[i].UID + "</td>\n\
                <td>" + data.tasks[i].strName + "</td>\n\
                <td>" + data.tasks[i].strDeadline + "</td>\n\
                <td>" + data.tasks[i].lngMinutesleft + "</td>\n\
                <td>" + data.tasks[i].lngMiutesworked + "</td>\n\
                <td><button class=\"btnbook\" value=\"" + data.tasks[i].UID + "\">add booking</button></td>\n\
            </tr>\n\
        ");
    }
    
    $("#taskcontent button").button({
        icons: { primary: "ui-icon-disk" },
        text: false
    });
}
</script>