package App.Data;

import Core.DB.Connector;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public abstract class Base
{
    public abstract int getUID();
    
    public abstract Base setUID(int UID);
    
    public abstract Base doInsert();
    
    public abstract Base doUpdate();
    
    protected Base doInsert(String strTable, Map<String, String> mapValues) {
        String  strSql = "";
        
        try {
            int UID;
            
            try {
                Map<String, String> mapUID = (Map)Connector.getInstance().execute("SELECT UID FROM " + strTable + " ORDER BY UID DESC FETCH FIRST 1 ROWS ONLY").get(0);
            
                UID = Integer.parseInt(mapUID.get("UID"));
            } catch (IndexOutOfBoundsException ex) {
                //No entry yet in DB so we set UID to -1 (increment to 0 follows)
                UID = -1;
            }
                
            UID++;
            
            this.setUID(UID);
            
            strSql      = "INSERT INTO " + strTable + "(UID";
            String  strValues   = "(" + this.getUID();
            
            for(String strKey: mapValues.keySet()) {
                strSql += ", " + strKey;
                
                if(strKey.substring(0, 3).matches("STR|TXT|DTM")) {
                    strValues += ", '" + mapValues.get(strKey) + "'";
                } else {
                    strValues += ", " + mapValues.get(strKey);
                }
            }
            
            strSql += ") VALUES " + strValues + ")";
            
            System.out.println(Connector.getInstance().insert(strSql));
        } catch (SQLException ex) {
            Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
            
            System.out.println(strSql);
            
            return null;
        }
        
        return this;
    }
    
    protected Base doUpdate(String strTable) {
        
        
        return this;
    }
}
