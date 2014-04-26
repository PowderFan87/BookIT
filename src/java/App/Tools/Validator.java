package App.Tools;

import App.Data.Project;
import App.Data.Table.tblProject;
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
    
    public static boolean isValidProjectname(String strName) {
        boolean blnIsValidProjectname = true;
        
        if(strName.length() < 6) {
            blnIsValidProjectname = false;
        }
        
        if(strName.length() > 256) {
            blnIsValidProjectname = false;
        }
        
        if(tblProject.getProjectByName(strName) instanceof Project) {
            blnIsValidProjectname = false;
        }
        
        return blnIsValidProjectname;
    }
    
    public static boolean hasLengthBetween(String strText, int lngMin, int lngMax) {
        boolean blnHasLengthBetween = true;
        
        if(lngMin > 0 && strText.length() < lngMin) {
            blnHasLengthBetween = false;
        }
        
        if(lngMax > 0 && strText.length() > lngMax) {
            blnHasLengthBetween = false;
        }
        
        return blnHasLengthBetween;
    }
}
