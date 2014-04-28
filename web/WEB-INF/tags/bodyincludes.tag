<%-- 
    Document   : bodyincludes
    Created on : 23.04.2014, 10:18:51
    Author     : Holger Szuesz <hszuesz@live.com>
--%>

<%@tag description="Script includes at the end of the body" pageEncoding="UTF-8"%>

<%-- any content can be specified here e.g.: --%>
<div id="formBook" title="New Booking">
    <p class="validateTips">New booking for task T#<span id="taskiddisp"></span></p>
    <p class="errormessage ui-state-error ui-helper-hidden"></p>
    
    <form>
        <input type="hidden" id="taskid" name="taskid" value="" />
        
        <div class="cols2-left">
            <label for="dtmDate"><strong>Day</strong></label><br />
            <input type="date" name="dtmDate" id="dtmDate" value="" class="text ui-widget-content ui-corner-all" style="width: 100%;" />
        </div>
        
        <div class="cols2-right">
            <label for="lngMinutes"><strong>Minutes</strong></label><br />
            <input type="number" name="lngMinutes" id="lngMinutes" value="0" step="5" min="0" class="text ui-widget-content ui-corner-all" style="width: 100%;" />
        </div>
        
        <br clear="all" />&nbsp;<br />
        
        <label for="strComment"><strong>Comment</strong></label><br />
        <textarea id="strComment" name="strComment" class="text ui-widget-content ui-corner-all" style="width: 98%;"></textarea>
    </form>
</div>

<div id="errorBook" title="Booking error">
    <p class="validateTips">There was an error. Please try again</p>
</div>

<div id="successBook" title="Booking committed">
    <p class="validateTips">Booking successfull</p>
    <table>
        <tr>
            <th>Task:</th>
            <td class="taskid"></td>
        </tr>
        <tr>
            <th>Day</th>
            <td class="day"></td>
        </tr>
        <tr>
            <th>Minutes</th>
            <td class="minutes"></td>
        </tr>
        <tr>
            <td colspan="2">You can book <span class="left"></span> more minutes on this task</td>
        </tr>
    </table>
</div>

<script type="text/javascript" src="/BookIT/js/libs/jqueryui/jquery-ui.js"></script>
<script type="text/javascript" src="/BookIT/js/libs/main.js"></script>
<script type="text/javascript">
    Date.prototype.toDateInputValue = (function() {
        var local = new Date(this);
        local.setMinutes(this.getMinutes() - this.getTimezoneOffset());
        return local.toJSON().slice(0,10);
    });
    
    $(document).ready(function() {
        $(".btnnew").button({
            icons: {primary: "ui-icon-plusthick"},
            text: false
        });
        $(".btnedit").button({
            icons: {primary: "ui-icon-pencil"},
            text: false
        });
        $(".btnview").button({
            icons: {primary: "ui-icon-search"},
            text: false
        });
        $(".btndelete").button({
            icons: {primary: "ui-icon-trash"},
            text: false
        });
        $("body").on("click",".btnbook",function(){
            $("#taskiddisp").html($(this).attr("value"));
            $("#taskid").attr("value",$(this).attr("value"));
            $("#formBook").dialog("open");
        });
        $("#formBook").dialog({
            autoOpen: false,
            modal: true,
            buttons: {
                "Book minutes": function(){
                    $.ajax({
                        url: "/BookIT/a/Dashboard/NewBooking",
                        type: "POST",
                        data: {
                            "tblTask_UID": ""+$("#taskid").val(),
                            "dtmDate": ""+$("#dtmDate").val(),
                            "lngMinutes": ""+$("#lngMinutes").val(),
                            "strComment": ""+$("#strComment").val()
                        },
                        dataType: "json",
                        success: function(d){
                            if(d.code === 0) {
                                $("#formBook .errormessage").removeClass("ui-helper-hidden").html(d.errors[0]);
                                for(i in d.errors) {
                                    if(i == 0){continue;}
                                    $("label[for='" + d.errors[i] + "'], #" + d.errors[i] + "").addClass("ui-state-error");
                                }
                            } else if(d.code === 1) {
                                $("#successBook .taskid").html($("#taskid").val());
                                $("#successBook .day").html($("#dtmDate").val());
                                $("#successBook .minutes").html($("#lngMinutes").val());
                                $("#successBook .left").html(d.left);
                                
                                $("#successBook").dialog("open");
                                $("#formBook").dialog("close");
                            } else {
                                $("#errorBook").dialog("open");
                                $("#formBook").dialog("close");
                            }
                        },
                        error: function(d){
                            $("#errorBook").dialog("open");
                            $("#formBook").dialog("close");
                        }
                    });
                },
                "Cancel": function(){
                    $(this).dialog("close");
                }
            },
            close: function(){
                $("#formBook label, #formBook input, #formBook textarea").removeClass("ui-state-error");
                $("#formBook .errormessage").addClass("ui-helper-hidden").html("");
                
                $("#taskid").val("");
                $("#dtmDate").val(new Date().toDateInputValue());
                $("#lngMinutes").val("");
                $("#strComment").val("");
            }
        });
        $("#errorBook, #successBook").dialog({
            autoOpen: false,
            modal: true,
            buttons: {
                "OK": function(){
                    $(this).dialog("close");
                }
            }
        });
        $("input[type='date'][value='']").val(new Date().toDateInputValue());
    });
</script>