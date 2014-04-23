package Command.Post;

import App.Data.User;
import App.Data.Userprofile;
import App.Tools.Validator;
import Core.Command.Base;
import Core.Command.RestrictionException;
import Interface.IRestricted;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Admin extends Base implements IRestricted
{
    @Override
    public void runDefault() {
        
    }

    @Override
    public void checkRestriction(HttpServletRequest objRequest) throws RestrictionException {
        if(!App.Security.isLoggedIn(objRequest)) {
            throw new RestrictionException();
        }
        
        if(!App.Security.isAdmin(objRequest)) {
            throw new RestrictionException();
        }
    }

    @Override
    public void runFallback() {
        try {
            this.objResponse.sendRedirect("/BookIT");
        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void runNewUser() {
        String[] arrErrors = this.validateNewUser();
        
        if(arrErrors.length == 0) {
            User        objUser     = new User();
            Userprofile objProfile  = new Userprofile();
            
            objUser
                .setStrUsername((String)this.getParameter("strUsername"))
                .setTblUsertype_UID((int)this.getParameter("lngUsertype"));
            
            objProfile
                .setStrEmail((String)this.getParameter("strEmail"));
        }
        
        this.objRequest.setAttribute("errors", arrErrors);
        
        this.objRequest.setAttribute("tplView", "Post/Admin/NewUser.jsp");
        this.objRequest.setAttribute("strTitle", "NewUser");
    }
    
    private String[] validateNewUser() {
        String[] arrErrors = new String[3];
        
        if(!Validator.isValidUsername((String)this.getParameter("strUsername"))) {
            arrErrors[0] = "strUsername";
        }
        
        if(!Validator.isValidEmail((String)this.getParameter("strEmail"))) {
            arrErrors[1] = "strEmail";
        }
        
        if(arrErrors.length > 0) {
            this.paramToAttribute();
        }
        
        return arrErrors;
    }
}
