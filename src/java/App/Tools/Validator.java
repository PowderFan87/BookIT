package App.Tools;

import App.Data.Table.tblUser;
import App.Data.User;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Validator
{
    public static boolean isValidUsername(String strUsername) {
        boolean blnIsValidUser = true;
        
        if(strUsername.length() < 4) {
            blnIsValidUser = false;
        }
        
        if(strUsername.length() > 256) {
            blnIsValidUser = false;
        }
        
        if(tblUser.getUserByUsername(strUsername) instanceof User) {
            blnIsValidUser = false;
        }
        
        return blnIsValidUser;
    }
    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE
    );
    
    public static boolean isValidEmail(String strEmail) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(strEmail);
        
        return matcher.find();
    }
    
    public static boolean isValidPassword(String strPassword) {
        boolean blnIsValidPassword = true;
        
        if(strPassword.length() < 6) {
            blnIsValidPassword = false;
        }
        
        if(strPassword.length() > 256) {
            blnIsValidPassword = false;
        }
        
        return blnIsValidPassword;
    }
}
