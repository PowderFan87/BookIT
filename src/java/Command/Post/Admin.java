package Command.Post;

import App.Data.User;
import App.Data.Userprofile;
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
        
        if(Util.isEmptyArray(arrErrors)) {
            User        objUser     = new User();
            Userprofile objProfile  = new Userprofile();
            
            objUser
                .setStrUsername((String)this.getParameter("strUsername"))
                .setTblUsertype_UID(Integer.parseInt((String)this.getParameter("lngUsertype")))
                .setStrPassword((String)this.getParameter("strPassword"))
                .setTblUsertype_UID(Integer.parseInt((String)this.getParameter("lngUsertype")))
                .setDtmActivated(new Date())
                .doInsert();
            
            objProfile
                .setStrEmail((String)this.getParameter("strEmail"))
                .setTblUser_UID(objUser.getUID())
                .doInsert();
        }
        
        this.objRequest.setAttribute("errors", arrErrors);
        
        this.objRequest.setAttribute("tplView", "Post/Admin/NewUser.jsp");
        this.objRequest.setAttribute("strTitle", "NewUser");
    }
    
    private String[] validateNewUser() {
        String[] arrErrors = new String[4];
        
        if(!Validator.isValidUsername((String)this.getParameter("strUsername"))) {
            arrErrors[0] = "strUsername";
        }
        
        if(!Validator.isValidEmail((String)this.getParameter("strEmail"))) {
            arrErrors[1] = "strEmail";
        }
        
        if(!Validator.isValidPassword((String)this.getParameter("strPassword"))) {
            arrErrors[2] = "strPassword";
        }
        
        return arrErrors;
    }
}
