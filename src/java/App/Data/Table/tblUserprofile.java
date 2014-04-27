package App.Data.Table;

import App.Data.Userprofile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class tblUserprofile extends Base
{
    public static Userprofile getProfileByUID(int lngUID) {
        Map mapData = tblUserprofile.getByPK("TBLUSERPROFILE", lngUID);
        
        return new Userprofile(mapData);
    }
    
    public static Userprofile getProfileByUserUID(int tblUser_UID) {
        List<String[]>  lisFilter = new ArrayList<>();
        
        lisFilter.add(new String[]{"", "tblUser_UID","=",String.valueOf(tblUser_UID)});
        lisFilter.add(new String[]{" AND", "flgDeleted","=","false"});
        
        Map mapData = tblUser.fetchSingleEntry("TBLUSERPROFILE", lisFilter);
        
        if(mapData == null) {
            return null;
        }
        
        return new Userprofile(mapData);
    }
}
