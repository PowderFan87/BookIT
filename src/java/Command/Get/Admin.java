package Command.Get;

import App.Data.Table.tblUser;
import App.Data.User;
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
public class Admin extends Base implements IRestricted
{
    @Override
    public void runDefault() {
        List<User> lisUser = tblUser.getAll();
        
        this.objRequest.setAttribute("lisUser", lisUser);
        
        this.objRequest.setAttribute("tplView", "Get/Admin.jsp");
        this.objRequest.setAttribute("strTitle", "Admin");
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
        this.objRequest.setAttribute("tplView", "Get/Admin/NewUser.jsp");
        this.objRequest.setAttribute("strTitle", "NewUser");
    }
}
