package Command.Get;

import App.Data.Table.tblProject;
import App.Security;
import Core.Command.Base;
import Core.Command.RestrictionException;
import Interface.IRestricted;
import java.io.IOException;
import java.util.List;
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
        List<App.Data.Project> lisProject = tblProject.getProjectByUserUID((int)this.objRequest.getSession().getAttribute("lngUserid"));
        
        this.objRequest.setAttribute("lisProject", lisProject);
        
        
        this.objRequest.setAttribute("tplView", "Get/Project.jsp");
        this.objRequest.setAttribute("strTitle", "Project");
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
        this.objRequest.setAttribute("tplView", "Get/Project/NewProject.jsp");
        this.objRequest.setAttribute("strTitle", "NewProject");
    }
    
    public void runViewProject() {
        App.Data.Project objProject = tblProject.getProjectByUID(Integer.parseInt((String)this.getParameter("UID")));
        
        this.objRequest.setAttribute("Project", objProject);
        
        this.objRequest.setAttribute("tplView", "Get/Project/ViewProject.jsp");
        this.objRequest.setAttribute("strTitle", "P#" + objProject.getUID() + " " + objProject.getStrName());
    }
    
    public void runNewTask() {
        this.objRequest.setAttribute("tblProject_UID", (String)this.getParameter("id"));
        
        this.objRequest.setAttribute("tplView", "Get/Project/NewTask.jsp");
        this.objRequest.setAttribute("strTitle", "NewTask");
    }
}
