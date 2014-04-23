package App.Data.Table;

import Core.DB.Connector;
import java.sql.SQLException;
import java.util.List;
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
    
    protected static List<Map> getAll(String strTable) {
        try {
            return Connector.getInstance().execute("SELECT * FROM " + strTable);
        } catch (SQLException ex) {
            Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    protected static Map fetchSingleEntry(String strTable, List<String[]> lisFilter) {
        List lisRows = Base.fetchAll(strTable, lisFilter);
        
        if(lisRows == null || lisRows.isEmpty()) {
            return null;
        } else {
            return (Map)lisRows.get(0);
        }
    }
    
    protected static List<Map> fetchAll(String strTable, List<String[]> lisFilter) {
        try {
            String  strSql  = "SELECT * FROM " + strTable + " WHERE ";
            
            for(String[] arrFilter: lisFilter) {
                if(arrFilter[1].substring(0, 3).matches("str|txt|dtm")) {
                    arrFilter[3] = "'" + arrFilter[3] + "'";
                }
                
                strSql += arrFilter[0] + " " + arrFilter[1] + " " + arrFilter[2] + " " + arrFilter[3];
            }
            
            List lisRows = Connector.getInstance().execute(strSql);
            
            if(lisRows.isEmpty()) {
                return null;
            } else {
                return lisRows;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
