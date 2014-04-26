package App.Data.Table;

import App.Data.Project;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class tblProject extends Base
{
    public static Project getProjectByUID(int lngUID) {
        Map mapData = tblProject.getByPK("TBLPROJECT", lngUID);
        
        Project objProject = new Project(mapData);
        
        return objProject;
    }
    
    public static Project getProjectByName(String strName) {
        List<String[]>  lisFilter = new ArrayList<>();
        
        lisFilter.add(new String[]{"", "strName","=",strName});
        
        Map mapData = tblUser.fetchSingleEntry("TBLPROJECT", lisFilter);
        
        if(mapData == null) {
            return null;
        }
        
        Project objProject = new Project(mapData);
        
        return objProject;
    }
    
    public static List<Project> getProjectByUserUID(int tblUser_UID) {
        List<Project>   lisProjects = new ArrayList<>();
        List<String[]>  lisFilter   = new ArrayList<>();
        
        lisFilter.add(new String[]{"","tblUser_UID","=",String.valueOf(tblUser_UID)});
        lisFilter.add(new String[]{"AND","flgDeleted","=","false"});
        
        List<Map> lisRows = tblProject.fetchAll("TBLPROJECT", lisFilter);
        
        if(lisRows != null && !lisRows.isEmpty()) {
            for(Map<String, String> mapData:lisRows) {
                lisProjects.add(new Project(mapData));
            }
        }
        
        return lisProjects;
    }
}
