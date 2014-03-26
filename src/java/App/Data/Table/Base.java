package App.Data.Table;

import Core.DB.Connector;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Base
{
    protected static Map getByPK(String strTable, int lngUID) {
        Map mapRow = null;
        
        try {
            String  strSql  = "SELECT * FROM " + strTable + " WHERE UID = " + lngUID;
            
            mapRow = (Map)Connector.getInstance().execute(strSql).get(0);
        } catch (SQLException ex) {
            Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mapRow;
    }
}
