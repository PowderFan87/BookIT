package App.Data;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Status extends Base
{
    private int     UID;
    private String  strName;
    private String  txtDescription;
    private Boolean flgDeleted;
    
    public Status(Map<String, String> mapData) {
        super();
        
        this.UID            = Integer.parseInt(mapData.get("UID"));
        this.strName        = mapData.get("STRNAME");
        this.txtDescription = mapData.get("TXTDESCRIPTION");
        this.flgDeleted     = Boolean.parseBoolean(mapData.get("FLGDELETED"));
    }

    public int getUID() {
        return UID;
    }

    public Status setUID(int UID) {
        this.UID = UID;
        
        return this;
    }

    public String getStrName() {
        return strName;
    }

    public Status setStrName(String strName) {
        this.strName = strName;
        
        return this;
    }

    public String getTxtDescription() {
        return txtDescription;
    }

    public Status setTxtDescription(String txtDescription) {
        this.txtDescription = txtDescription;
        
        return this;
    }

    public Boolean isFlgDeleted() {
        return flgDeleted;
    }

    public Status setFlgDeleted(Boolean flgDeleted) {
        this.flgDeleted = flgDeleted;
        
        return this;
    }

    @Override
    public Base doInsert() {
        Map<String, String> mapData = new HashMap<>();
        
        mapData.put("STRNAME", this.strName);
        
        if(this.txtDescription != null) {
            mapData.put("TXTDESCRIPTION", this.txtDescription);
        }
        
        return this.doInsert("TBLSTATUS", mapData);
    }

    @Override
    public Base doUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
