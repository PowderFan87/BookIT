package App.Data.Table;

import App.Data.UserHasTask;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class tblUser_Has_tblTask extends Base
{
    public static List<UserHasTask> getAssignmentsByTaskUID(int tblTask_UID) {
        List<UserHasTask>   lisAssignments  = new ArrayList<>();
        List<String[]>      lisFilter       = new ArrayList<>();
        
        lisFilter.add(new String[]{"","tblTask_UID","=",String.valueOf(tblTask_UID)});
        lisFilter.add(new String[]{" AND","flgDeleted","=","false"});
        
        List<Map> lisRows = tblProject.fetchAll("TBLUSER_HAS_TBLTASK", lisFilter);
        
        if(lisRows != null && !lisRows.isEmpty()) {
            for(Map<String, String> mapData:lisRows) {
                lisAssignments.add(new UserHasTask(mapData));
            }
        }
        
        return lisAssignments;
    }
    
    public static List<UserHasTask> getAssignmentsByUserUID(int tblUser_UID) {
        List<UserHasTask>   lisAssignments  = new ArrayList<>();
        List<String[]>      lisFilter       = new ArrayList<>();
        
        lisFilter.add(new String[]{"","tblUser_UID","=",String.valueOf(tblUser_UID)});
        lisFilter.add(new String[]{" AND","flgDeleted","=","false"});
        
        List<Map> lisRows = tblProject.fetchAll("TBLUSER_HAS_TBLTASK", lisFilter);
        
        if(lisRows != null && !lisRows.isEmpty()) {
            for(Map<String, String> mapData:lisRows) {
                lisAssignments.add(new UserHasTask(mapData));
            }
        }
        
        return lisAssignments;
    }
    
    public static UserHasTask getAssignmentByUserUIDAndTaskUID(int tblUser_UID, int tblTask_UID) {
        List<String[]> lisFilter = new ArrayList<>();
        
        lisFilter.add(new String[]{"","tblUser_UID","=",String.valueOf(tblUser_UID)});
        lisFilter.add(new String[]{" AND","tblTask_UID","=",String.valueOf(tblTask_UID)});
        lisFilter.add(new String[]{" AND","flgDeleted","=","false"});
        
        Map mapData = tblProject.fetchSingleEntry("TBLUSER_HAS_TBLTASK", lisFilter);
        
        if(mapData == null) {
            return null;
        }
        
        return new UserHasTask(mapData);
    }
}
