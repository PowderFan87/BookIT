package Command.Ajax;

import App.Security;
import Core.Command.Base;
import Core.Command.RestrictionException;
import Interface.IRestricted;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Dashboard extends Base implements IRestricted
{
    @Override
    public void runDefault() {
        Map<String, Object> mapData = new HashMap<>();
        
        mapData.put("strText", "Das ist ein String");
        mapData.put("lngNumber", 1337);
        mapData.put("decNumber", 13.37);
        mapData.put("arrString", new String[]{"a","b","c","d"});
        mapData.put("arrInt", new Integer[]{1,3,3,7});
        mapData.put("arrDec", new Double[]{1.1,3.3,3.3,7.7});
        
        Map<String, Object> mapSub1 = new HashMap<>();
        
        mapSub1.put("sub1", "subtext");
        mapSub1.put("sub2", 9);
        
        mapData.put("mapSubdata", mapSub1);
        
        Map[] arrMap = new HashMap[2];
        
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        
        map1.put("name", "foo");
        map1.put("age", 9);
        
        map2.put("name", "bar");
        map2.put("age", 5);
        
        arrMap[0] = map1;
        arrMap[1] = map2;
        
        mapData.put("arrMap", arrMap);
        
        mapData.put("strEnde", "So hier ist schluss");
        
        this.objRequest.setAttribute("mapData", mapData);
    }

    @Override
    public void checkRestriction(HttpServletRequest objRequest) throws RestrictionException {
        if(!Security.isLoggedIn(objRequest)) {
            throw new RestrictionException();
        }
    }

    @Override
    public void runFallback() {
        //header 418 raus finden
    }
    
}
