package Command.Post;

import App.Data.Table.tblUser;
import App.Data.User;
import Core.Command.Base;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Login extends Base
{
    @Override
    public void runDefault() {
        User objUser = tblUser.getUserByLoginData(this.objRequest.getParameter("strUsername"), this.objRequest.getParameter("strPassword"));
        
        if(objUser instanceof User) {
            this.objRequest.getSession().setAttribute("lngUserid", objUser.getUID());
            this.objRequest.getSession().setAttribute("strUsername", objUser.getStrUsername());
            this.objRequest.getSession().setAttribute("lngUsertype", objUser.getTblUsertype_UID());
        
            //todo check custom redirect
        }
        
        this.objRequest.setAttribute("tplView", "Post/Login.jsp");
        this.objRequest.setAttribute("strTitle", "Login");
    }
}
