package App.Data;

import java.util.Map;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Usertype extends Base
{
    private int     UID;
    private String  strName;
    private Boolean flgDeleted;
    
    public Usertype(Map<String, String> mapData) {
        super();
        
        this.UID        = Integer.parseInt(mapData.get("UID"));
        this.strName    = mapData.get("STRNAME");
        this.flgDeleted = Boolean.parseBoolean(mapData.get("FLGDELETED"));
    }

    public int getUID() {
        return UID;
    }

    public Usertype setUID(int UID) {
        this.UID = UID;
        
        return this;
    }

    public String getStrName() {
        return strName;
    }

    public Usertype setStrName(String strName) {
        this.strName = strName;
        
        return this;
    }

    public Boolean isFlgDeleted() {
        return flgDeleted;
    }

    public Usertype setFlgDeleted(Boolean flgDeleted) {
        this.flgDeleted = flgDeleted;
        
        return this;
    }
    
    
}
