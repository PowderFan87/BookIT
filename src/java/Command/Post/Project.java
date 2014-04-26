package Command.Post;

import App.Security;
import App.Tools.Util;
import App.Tools.Validator;
import Core.Command.Base;
import Core.Command.RestrictionException;
import Interface.IRestricted;
import java.io.IOException;
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
    
    private String[] validateNewProject() {
        String[] arrErrors = new String[2];
        
        if(!Validator.isValidProjectname((String)this.getParameter("strName"))) {
            arrErrors[0] = "strName";
        }
        
        if(!Validator.hasLengthBetween((String)this.getParameter("txtDescription"), 10, 0)) {
            arrErrors[1] = "txtDescription";
        }
        
        return arrErrors;
    }
}
