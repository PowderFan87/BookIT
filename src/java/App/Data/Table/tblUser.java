package App.Data.Table;

import App.Data.User;
import java.util.Map;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class tblUser extends Base
{
    public static User getUserByUID(int lngUID) {
        Map mapData = tblUser.getByPK("TBLUSER", lngUID);
        
        User objUser = new User(mapData);
        
        return objUser;
    }
}
