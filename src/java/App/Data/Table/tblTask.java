package App.Data.Table;

import App.Data.Task;
import java.util.ArrayList;
import java.util.List;
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
    
    public static List<Task> getTaskByProjectUID(int tblProject_UID) {
        List<Task>      lisTasks    = new ArrayList<>();
        List<String[]>  lisFilter   = new ArrayList<>();
        
        lisFilter.add(new String[]{"","tblProject_UID","=",String.valueOf(tblProject_UID)});
        lisFilter.add(new String[]{"AND","flgDeleted","=","false"});
        
        List<Map> lisRows = tblProject.fetchAll("TBLTASK", lisFilter);
        
        if(lisRows != null && !lisRows.isEmpty()) {
            for(Map<String, String> mapData:lisRows) {
                lisTasks.add(new Task(mapData));
            }
        }
        
        return lisTasks;
    }
}
