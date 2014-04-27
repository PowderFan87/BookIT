package Command.Post;

import App.Data.Task;
import App.Data.UserHasTask;
import App.Security;
import App.Tools.Util;
import App.Tools.Validator;
import Core.Command.Base;
import Core.Command.RestrictionException;
import Interface.IRestricted;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Project extends Base implements IRestricted
{
    @Override
    public void runDefault() {
        
    }

    @Override
    public void checkRestriction(HttpServletRequest objRequest) throws RestrictionException {
        if(!Security.isLoggedIn(objRequest)) {
            throw new RestrictionException();
        }
        
        if(!Security.isManager(objRequest)) {
            throw new RestrictionException();
        }
    }

    @Override
    public void runFallback() {
        try {
            this.objResponse.sendRedirect("/BookIT");
        } catch (IOException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void runNewProject() {
        String[] arrErrors = this.validateNewProject();
        
        if(Util.isEmptyArray(arrErrors)) {
            App.Data.Project objProject = new App.Data.Project();
            
            objProject
                .setStrName((String)this.getParameter("strName"))
                .setTxtDescription((String)this.getParameter("txtDescription"))
                .setDtmCreated(new Date())
                .setTblUser_UID((int)this.objRequest.getSession().getAttribute("lngUserid"))
                .setTblStatus_UID(0)
                .doInsert();
        }
        
        this.objRequest.setAttribute("errors", arrErrors);
        
        this.objRequest.setAttribute("tplView", "Post/Project/NewProject.jsp");
        this.objRequest.setAttribute("strTitle", "NewProject");
    }
    
    public void runNewTask() {
        String[] arrErrors = this.validateNewTask();
        
        if(Util.isEmptyArray(arrErrors)) {
            SimpleDateFormat    objParser   = new SimpleDateFormat("yyyy-MM-dd");
            Task                objTask     = new Task();
            
            if(((String)this.getParameter("dtmDeadline")).length() == 10) {
                try {
                    objTask.setDtmDeadline(objParser.parse((String)this.getParameter("dtmDeadline")));
                } catch (ParseException ex) {
                    Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            objTask
                .setStrName((String)this.getParameter("strName"))
                .setStrStatus("open")
                .setDtmCreated(new Date())
                .setTxtDescription((String)this.getParameter("txtDescription"))
                .setTblProject_UID(Integer.parseInt((String)this.getParameter("tblProject_UID")))
                .setTblUser_UID((int)this.objRequest.getSession().getAttribute("lngUserid"))
                .doInsert();
        }
        
        this.objRequest.setAttribute("errors", arrErrors);
        
        this.objRequest.setAttribute("tplView", "Post/Project/NewTask.jsp");
        this.objRequest.setAttribute("strTitle", "NewTask");
    }
    
    public void runNewTaskAssignment() {
        String[] arrErrors = this.validateNewTaskAssignment();
        
        if(Util.isEmptyArray(arrErrors)) {
            UserHasTask objAssignment = new UserHasTask();
            
            objAssignment
                .setTblTask_UID(Integer.parseInt((String)this.getParameter("tblTask_UID")))
                .setTblUser_UID(Integer.parseInt((String)this.getParameter("tblUser_UID")))
                .setLngGrantedminutes(Integer.parseInt((String)this.getParameter("lngGrantedminutes")))
                .doInsert();
        }
        
        this.objRequest.setAttribute("errors", arrErrors);
        
        this.objRequest.setAttribute("tplView", "Post/Project/NewTaskAssignment.jsp");
        this.objRequest.setAttribute("strTitle", "New Assignment");
    }
    
    private String[] validateNewProject() {
        String[] arrErrors = new String[2];
        
        if(!Validator.isValidProjectname((String)this.getParameter("strName"))) {
            arrErrors[0] = "strName";
        }
        
        if(!Validator.hasLengthBetween((String)this.getParameter("txtDescription"), 10, 0)) {
            arrErrors[1] = "txtDescription";
        }
        
        if(arrErrors.length > 0) {
            this.paramToAttribute();
        }
        
        return arrErrors;
    }
    
    private String[] validateNewTask() {
        String[] arrErrors = new String[3];
        
        if(!Validator.hasLengthBetween((String)this.getParameter("strName"), 6, 256)) {
            arrErrors[0] = "strName";
        }
        
        if(!Validator.hasLengthBetween((String)this.getParameter("txtDescription"), 10, 0)) {
            arrErrors[1] = "txtDescription";
        }
        
        SimpleDateFormat objParser = new SimpleDateFormat("yyyy-MM-dd");

        try {
            if(!Validator.isValidDate((String)this.getParameter("dtmDeadline")) || !Validator.isFutureDate(objParser.parse((String)this.getParameter("dtmDeadline")))) {
                arrErrors[2] = "dtmDeadline";
            }
        } catch (ParseException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
            
            arrErrors[2] = "dtmDeadline";
        }
        
        if(!Util.isEmptyArray(arrErrors)) {
            this.paramToAttribute();
        }
        
        return arrErrors;
    }
    
    private String[] validateNewTaskAssignment() {
        String[] arrErrors = new String[2];
        
        if(!Validator.isValidAssignment(Integer.parseInt((String)this.getParameter("tblUser_UID")), Integer.parseInt((String)this.getParameter("tblTask_UID")))) {
            arrErrors[0] = "tblUser_UID";
        }
        
        if(!Validator.isBetween(Integer.parseInt((String)this.getParameter("lngGrantedminutes")), 5, 0)) {
            arrErrors[1] = "lngGrantedminutes";
        }
        
        if(arrErrors.length > 0) {
            this.paramToAttribute();
        }
        
        return arrErrors;
    }
}
