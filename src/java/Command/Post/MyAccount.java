package Command.Post;

import App.Data.Table.tblUser;
import App.Data.User;
import App.Data.Userprofile;
import App.Security;
import App.Tools.Util;
import App.Tools.Validator;
import Core.Command.Base;
import Core.Command.RestrictionException;
import Interface.IRestricted;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author hszüsz
 */
public class MyAccount extends Base implements IRestricted
{

    @Override
    public void runDefault() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            Logger.getLogger(Command.Get.Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void runEdit() {
        String[] arrErrors = this.validateEdit();

        if(Util.isEmptyArray(arrErrors)) {
            User        objUser     = tblUser.getUserByUID((int)this.objRequest.getSession().getAttribute("lngUserid"));
            Userprofile objProfile  = objUser.getProfile();

            if(((String)this.getParameter("strCustomstartpage")).equals("other")) {
                objProfile.setStrCustomstartpage((String)this.getParameter("strOthercustompage"));
            } else {
                objProfile.setStrCustomstartpage((String)this.getParameter("strCustomstartpage"));
            }

            objProfile
                .setStrName((String)this.getParameter("strName"))
                .setStrSurname((String)this.getParameter("strSurname"))
                .doUpdate();


        }

        this.objRequest.setAttribute("errors", arrErrors);

        this.objRequest.setAttribute("tplView", "/Post/MyAccount/Edit.jsp");
        this.objRequest.setAttribute("strTitle", "MyAccount - Edit");
    }

    private String[] validateEdit() {
        String[] arrErrors = new String[4];

        if(!Validator.hasLengthBetween((String)this.getParameter("strName"), 6, 256)) {
            arrErrors[0] = "strName";
        }

        if(!Validator.hasLengthBetween((String)this.getParameter("strSurname"), 6, 256)) {
            arrErrors[0] = "strSurname";
        }

        if(!Validator.isValidEmail((String)this.getParameter("strEmail"))) {
            arrErrors[1] = "strEmail";
        }

        if(!Validator.isValidStartPage((String)this.getParameter("strCustomstartpage"))) {
            arrErrors[2] = "strCustomstartpage";
        }

        return arrErrors;
    }

}
