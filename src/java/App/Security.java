package App;

import App.Data.Table.tblUsertype;
import App.Data.Usertype;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Security
{
    public static boolean isLoggedIn(HttpServletRequest objRequest) {
        boolean blnReturn = false;
        
        if(objRequest.getSession().getAttribute("lngUserid") != null) {
            blnReturn = true;
        }
        
        return blnReturn;
    }
    
    public static boolean isAdmin(HttpServletRequest objRequest) {
        return ((int)objRequest.getSession().getAttribute("lngUsertype") == 0);
    }
    
    public static boolean isManager(HttpServletRequest objRequest) {
        Usertype objType = tblUsertype.getUserByUID((int)objRequest.getSession().getAttribute("lngUsertype"));
        
        return objType.isFlgCanManage();
    }
    
    public static String encodeString(String strText) {
        try {
            MessageDigest objCrypter = MessageDigest.getInstance("MD5");
            
            objCrypter.update(strText.getBytes("UTF-8"));
            
            BigInteger lngInt = new BigInteger(1,objCrypter.digest());
            
            String strHashed = lngInt.toString(16);
            
            return strHashed;
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
