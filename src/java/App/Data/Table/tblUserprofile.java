package App.Data.Table;

import App.Data.Userprofile;
import java.util.Map;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class tblUserprofile extends Base
{
    public static Userprofile getUserByUID(int lngUID) {
        Map mapData = tblUserprofile.getByPK("TBLUSERPROFILE", lngUID);
        
        Userprofile objUserprofile = new Userprofile(mapData);
        
        return objUserprofile;
    }
}
