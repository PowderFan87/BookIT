package App.Data.Table;

import App.Data.UserHasTask;
import java.util.Map;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class tblUser_Has_tblTask extends Base
{
    public static UserHasTask getUserByUID(int lngUID) {
        Map mapData = tblUser_Has_tblTask.getByPK("TBLUSER_HAS_TBLTASK", lngUID);
        
        UserHasTask objUserHasTask = new UserHasTask(mapData);
        
        return objUserHasTask;
    }
}
