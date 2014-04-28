package Command.Ajax;

import App.Data.Booking;
import App.Data.Table.tblTask;
import App.Data.Table.tblUser_Has_tblTask;
import App.Data.Task;
import App.Data.UserHasTask;
import App.Security;
import App.Tools.Util;
import App.Tools.Validator;
import Core.Command.Base;
import Core.Command.RestrictionException;
import Interface.IRestricted;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Dashboard extends Base implements IRestricted
{
    @Override
    public void runDefault() {
        Map<String, Object> mapData = new HashMap<>();
        
        mapData.put("strText", "Das ist ein String");
        mapData.put("lngNumber", 1337);
        mapData.put("decNumber", 13.37);
        mapData.put("arrString", new String[]{"a","b","c","d"});
        mapData.put("arrInt", new Integer[]{1,3,3,7});
        mapData.put("arrDec", new Double[]{1.1,3.3,3.3,7.7});
        
        Map<String, Object> mapSub1 = new HashMap<>();
        
        mapSub1.put("sub1", "subtext");
        mapSub1.put("sub2", 9);
        
        mapData.put("mapSubdata", mapSub1);
        
        Map[] arrMap = new HashMap[2];
        
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        
        map1.put("name", "foo");
        map1.put("age", 9);
        
        map2.put("name", "bar");
        map2.put("age", 5);
        
        arrMap[0] = map1;
        arrMap[1] = map2;
        
        mapData.put("arrMap", arrMap);
        
        mapData.put("strEnde", "So hier ist schluss");
        
        this.objRequest.setAttribute("mapData", mapData);
    }
    
    @Override
    public void checkRestriction(HttpServletRequest objRequest) throws RestrictionException {
        if(!Security.isLoggedIn(objRequest)) {
            throw new RestrictionException();
        }
    }

    @Override
    public void runFallback() {
        //header 418 raus finden
    }
    
    public void runUpdateTasks() {
        Map<String, Object> mapData         = new HashMap<>();
        List<UserHasTask>   lisAssignments  = tblUser_Has_tblTask.getAssignmentsByUserUID((int)this.objRequest.getSession().getAttribute("lngUserid"));
        Map[]               arrAssignments  = new HashMap[lisAssignments.size()];
        int                 lngCounter      = 0;
        
        for(UserHasTask objAssignment: lisAssignments) {
            Task objTask                        = objAssignment.getTask();
            Map<String, Object> mapAssignment   = new HashMap<>();
            
            mapAssignment.put("UID", objTask.getUID());
            mapAssignment.put("strName", objTask.getStrName());
            mapAssignment.put("strStatus", objTask.getStrStatus());
            mapAssignment.put("strDeadline", objTask.getStrDeadline());
            mapAssignment.put("lngMinutesleft", objAssignment.getLngMinutesleft());
            mapAssignment.put("lngMiutesworked", objAssignment.getLngMinutesworked());
            
            arrAssignments[lngCounter] = mapAssignment;
            
            lngCounter++;
        }
        
        mapData.put("tasks", arrAssignments);
        
        this.objRequest.setAttribute("mapData", mapData);
    }
    
    public void runNewBooking() {
        Map<String, Object> mapData     = new HashMap<>();
        String[]            arrErrors   = this.validateNewBooking();
        
        if(Util.isEmptyArray(arrErrors)) {
            UserHasTask objAssignment   = tblUser_Has_tblTask.getAssignmentByUserUIDAndTaskUID((int)this.objRequest.getSession().getAttribute("lngUserid"), Integer.parseInt((String)this.getParameter("tblTask_UID")));
            Booking     objBooking      = new Booking();
        
            SimpleDateFormat objParser = new SimpleDateFormat("yyyy-MM-dd");
            
            try {
                objBooking.setDtmDate(objParser.parse((String)this.getParameter("dtmDate")));
            } catch (ParseException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            objBooking
                .setTblUser_UID(objAssignment.getTblUser_UID())
                .setTblTask_UID(objAssignment.getTblTask_UID())
                .setLngMinutes(Integer.parseInt((String)this.getParameter("lngMinutes")))
                .setStrComment((String)this.getParameter("strComment"))
                .doInsert();
            
            objAssignment
                .setLngMinutesleft(objAssignment.getLngMinutesleft() - objBooking.getLngMinutes())
                .setLngBookingscount(objAssignment.getLngBookingscount() + 1)
                .doUpdate();
            
            mapData.put("code", 1);
            mapData.put("left", objAssignment.getLngMinutesleft());
        } else {
            arrErrors[0] = arrErrors[0].substring(4);
            
            mapData.put("code", 0);
            mapData.put("errors", arrErrors);
        }
        
        this.objRequest.setAttribute("mapData", mapData);
    }
    
    private String[] validateNewBooking() {
        String[] arrErrors = new String[5];
        
        if(!Validator.canBookOnTask((int)this.objRequest.getSession().getAttribute("lngUserid"), Integer.parseInt((String)this.getParameter("tblTask_UID")))) {
            arrErrors[0] += "Sorry. You can't book on this task<br />";
        }
        
        SimpleDateFormat objParser = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            if(!Validator.isPastOrCurrentDate(objParser.parse((String)this.getParameter("dtmDate")))) {
                arrErrors[0] += "Please select a date in the past (or current day)<br />";
                arrErrors[2] = "dtmDate";
            }
        } catch (ParseException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            arrErrors[2] = "dtmDate";
        }
        
        if(!Validator.hasEnoughMinutesLeft((int)this.objRequest.getSession().getAttribute("lngUserid"), Integer.parseInt((String)this.getParameter("tblTask_UID")), Integer.parseInt((String)this.getParameter("lngMinutes")))) {
            arrErrors[0] += "Sorry. You don't have enough minutes left.<br />I would talk to my projectmanager about that if I where you...<br />";
            arrErrors[3] = "lngMinutes";
        }
        
        if(!Validator.isBetween(Integer.parseInt((String)this.getParameter("lngMinutes")), 5, 0)) {
            arrErrors[0] += "Please enter some minutes<br />";
            arrErrors[3] = "lngMinutes";
        }
        
        if(!Validator.hasLengthBetween((String)this.getParameter("strComment"), 10, 256)) {
            arrErrors[0] += "Please enter a comment.<br />";
            arrErrors[4] = "strComment";
        }
        
        return arrErrors;
    }
}
