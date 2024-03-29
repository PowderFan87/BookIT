package App.Data.Table;

import App.Data.User;
import App.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class tblUser extends Base
{
    public static final String  strSalt = "800k17_54l7";
    
    public static User getUserByUID(int lngUID) {
        Map mapData = tblUser.getByPK("TBLUSER", lngUID);
        
        User objUser = new User(mapData);
        
        return objUser;
    }
    
    public static User getUserByLoginData(String strUsername, String strPassword) {
        List<String[]>  lisFilter = new ArrayList<>();
        
        lisFilter.add(new String[]{"", "strUsername","=",strUsername});
        lisFilter.add(new String[]{"AND", "strPassword","=",Security.encodeString(tblUser.strSalt + strPassword)});
        lisFilter.add(new String[]{"AND", "flgDeleted","=","false"});
        
        Map mapData = tblUser.fetchSingleEntry("TBLUSER", lisFilter);
        
        if(mapData == null) {
            return null;
        }
        
        User objUser = new User(mapData);
        
        return objUser;
    }
    
    public static User getUserByUsername(String strUsername) {
        List<String[]>  lisFilter = new ArrayList<>();
        
        lisFilter.add(new String[]{"", "strUsername","=",strUsername});
        
        Map mapData = tblUser.fetchSingleEntry("TBLUSER", lisFilter);
        
        if(mapData == null) {
            return null;
        }
        
        User objUser = new User(mapData);
        
        return objUser;
    }
    
    public static List<User> getUserAssignedToTask(int tblTask_UID) {
        List<User>      lisUsers    = new ArrayList<>();
        List<String[]>  lisFilter   = new ArrayList<>();
        
        lisFilter.add(new String[]{"","TBLUSER_HAS_TBLTASK.tblTask_UID","=",String.valueOf(tblTask_UID)});
        lisFilter.add(new String[]{" AND","TBLUSER_HAS_TBLTASK.flgDeleted","=","false"});
        lisFilter.add(new String[]{" AND","TBLUSER.flgDeleted","=","false"});
        
        List<Map> lisRows = tblProject.fetchAll("TBLUSER JOIN TBLUSER_HAS_TBLTASK ON (TBLUSER_HAS_TBLTASK.TBLUSER_UID = TBLUSER.UID)", lisFilter);
        
        if(lisRows != null && !lisRows.isEmpty()) {
            for(Map<String, String> mapData:lisRows) {
                lisUsers.add(new User(mapData));
            }
        }
        
        return lisUsers;
    }
    
    public static List<User> getAll() {
        List<User>  lisUser = new ArrayList<>();
        List<Map>   lisRows = tblUser.getAll("TBLUSER");
        
        if(lisRows != null && !lisRows.isEmpty()) {
            for(Map<String, String> mapData:lisRows) {
                lisUser.add(new User(mapData));
            }
        }
        
        return lisUser;
    }
}
