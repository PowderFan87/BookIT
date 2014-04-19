package App.Data.Table;

import App.Data.Usertype;
import java.util.Map;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class tblUsertype extends Base
{
    public static Usertype getUserByUID(int lngUID) {
        Map mapData = tblUsertype.getByPK("TBLUSERTYPE", lngUID);
        
        Usertype objUsertype = new Usertype(mapData);
        
        return objUsertype;
    }
}
