package Core.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Connector
{
    private static  Connector   objConnector    = null;
    
    private         Connection  objConnection   = null;
    
    public static Connector getInstance() {
        if(Connector.objConnector == null) {
            try {
                Connector.objConnector = new Connector();
            } catch (SQLException ex) {
                Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return Connector.objConnector;
    }
    
    private Connector() throws SQLException {
        super();
        
        this.objConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/bookitdb", "bookitdb", "800k17d8");
        
        this.objConnection.setAutoCommit(true);
    }
    
    public List<Map> execute(String strSql) throws SQLException {
        ResultSet objResult;
        
        try(Statement objStatement = this.objConnection.createStatement()) {
            objResult = objStatement.executeQuery(strSql);
            
            ResultSetMetaData   objMetaData     = objResult.getMetaData();
            int                 lngColumnCount  = objMetaData.getColumnCount();
            
            List<Map> lisRows = new ArrayList<>();
            
            while(objResult.next()) {
                Map<String, String> mapRow = new HashMap<>();
                
                for(int i = 1; i <= lngColumnCount; i++) {
                    mapRow.put(objMetaData.getColumnName(i), objResult.getString(i));
                }
                
                lisRows.add(mapRow);
            }
            
            return lisRows;
        }
    }
    
    public int update(String strSql) throws SQLException {
        return this.insert(strSql);
    }
    
    public int insert(String strSql) throws SQLException {
        try(Statement objStatement = this.objConnection.createStatement()) {
            System.out.println(strSql);
            return objStatement.executeUpdate(strSql);
        }
    }
}
