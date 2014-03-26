package App;

import Core.Web;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Security
{
    public static boolean isLoggedIn() {
        boolean blnReturn = false;
        
        if(Web.objSession.getAttribute("lngUserid") != null) {
            blnReturn = true;
        }
        
        return blnReturn;
    }
}
