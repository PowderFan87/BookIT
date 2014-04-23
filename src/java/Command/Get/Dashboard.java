package Command.Get;

import App.Data.Table.tblUser;
import App.Data.User;
import Core.Command.Base;
import Core.Command.RestrictionException;
import Interface.IRestricted;
import java.io.IOException;
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
        User objUser = tblUser.getUserByUID((int)this.objRequest.getSession().getAttribute("lngUserid"));
        
        this.objRequest.setAttribute("User", objUser);
        
        this.objRequest.setAttribute("tplView", "Get/Dashboard.jsp");
        this.objRequest.setAttribute("strTitle", "Dashboard");
    }
    
    @Override
    public void checkRestriction(HttpServletRequest objRequest) throws RestrictionException {
        if(!App.Security.isLoggedIn(objRequest)) {
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
}
