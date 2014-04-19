package App.Data.Table;

import App.Data.Project;
import java.util.Map;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class tblProject extends Base
{
    public static Project getUserByUID(int lngUID) {
        Map mapData = tblProject.getByPK("TBLPROJECT", lngUID);
        
        Project objProject = new Project(mapData);
        
        return objProject;
    }
}
