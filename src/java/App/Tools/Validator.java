package App.Tools;

import App.Data.Project;
import App.Data.Table.tblProject;
import App.Data.Table.tblUser;
import App.Data.Table.tblUser_Has_tblTask;
import App.Data.User;
import App.Data.UserHasTask;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Validator
{
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE
    );
    
    public static final Pattern VALID_DATE_REGEX = Pattern.compile(
            "^[0-9]{4}-(0[0-9]{1}|1[0-2]{1})-([0-2]{1}[0-9]{1}|30|31)",
            Pattern.CASE_INSENSITIVE
    );
    
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
    
    public static boolean isValidDate(String strDate) {
        Matcher matcher = VALID_DATE_REGEX.matcher(strDate);
        
        return matcher.find();
    }
    
    public static boolean isFutureDate(Date dtmDate) {
        Date dtmCurrentDate = new Date();
        
        return dtmDate.after(dtmCurrentDate);
    }
    
    public static boolean isPastOrCurrentDate(Date dtmDate) {
        Date dtmCurrentDate = new Date();
        
        return dtmDate.compareTo(dtmCurrentDate) <= 0;
    }
    
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
    
    public static boolean isValidAssignment(int tblUser_UID, int tblTask_UID) {
        return !(tblUser_Has_tblTask.getAssignmentByUserUIDAndTaskUID(tblUser_UID, tblTask_UID) instanceof UserHasTask);
    }
    
    public static boolean isBetween(int lngValue, int lngMin, int lngMax) {
        boolean blnIsBetween = true;
        
        if(lngMin > 0 && lngValue < lngMin) {
            blnIsBetween = false;
        }
        
        if(lngMax > 0 && lngValue > lngMax) {
            blnIsBetween = false;
        }
        
        return blnIsBetween;
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
    
    public static boolean canBookOnTask(int tblUser_UID, int tblTask_UID) {
        return tblUser_Has_tblTask.getAssignmentByUserUIDAndTaskUID(tblUser_UID, tblTask_UID) instanceof UserHasTask;
    }
    
    public static boolean hasEnoughMinutesLeft(int tblUser_UID, int tblTask_UID, int lngMinutes) {
        UserHasTask objAssignment = tblUser_Has_tblTask.getAssignmentByUserUIDAndTaskUID(tblUser_UID, tblTask_UID);
        
        return lngMinutes <= objAssignment.getLngMinutesleft();
    }
}
