package App.Data.Table;

import App.Data.Status;
import java.util.Map;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class tblStatus extends Base
{
    public static Status getUserByUID(int lngUID) {
        Map mapData = tblStatus.getByPK("TBLSTATUS", lngUID);
        
        Status objStatus = new Status(mapData);
        
        return objStatus;
    }
}
