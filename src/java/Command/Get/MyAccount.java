package Command.Get;

import App.Data.Table.tblUser;
import App.Data.User;
import App.Security;
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
public class MyAccount extends Base implements IRestricted
{

    @Override
    public void runDefault() {
        User objUser = tblUser.getUserByUID((int)this.objRequest.getSession().getAttribute("lngUserid"));
        
        this.objRequest.setAttribute("User", objUser);
        this.objRequest.setAttribute("Profile", objUser.getProfile());
        
        this.objRequest.setAttribute("tplView", "/Get/MyAccount.jsp");
        this.objRequest.setAttribute("strTitle", "MyAccount");
    }

    @Override
    public void checkRestriction(HttpServletRequest objRequest) throws RestrictionException {
        if(!Security.isLoggedIn(objRequest)) {
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
    
    public void runEdit() {
        User objUser = tblUser.getUserByUID((int)this.objRequest.getSession().getAttribute("lngUserid"));
        
        this.objRequest.setAttribute("User", objUser);
        this.objRequest.setAttribute("Profile", objUser.getProfile());
        
        this.objRequest.setAttribute("tplView", "/Get/MyAccount/Edit.jsp");
        this.objRequest.setAttribute("strTitle", "MyAccount - Edit");
    }
}
