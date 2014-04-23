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
        
        Map mapData = tblUser.fetchSingleEntry("TBLUSER", lisFilter);
        
        if(mapData == null) {
            return null;
        }
        
        User objUser = new User(mapData);
        
        return objUser;
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
