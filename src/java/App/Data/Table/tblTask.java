package App.Data.Table;

import App.Data.Task;
import java.util.Map;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class tblTask extends Base
{
    public static Task getUserByUID(int lngUID) {
        Map mapData = tblTask.getByPK("TBLTASK", lngUID);
        
        Task objTask = new Task(mapData);
        
        return objTask;
    }
}
