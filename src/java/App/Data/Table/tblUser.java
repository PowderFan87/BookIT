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
}
