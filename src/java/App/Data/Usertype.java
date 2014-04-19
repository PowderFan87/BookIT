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

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public Boolean isFlgDeleted() {
        return flgDeleted;
    }

    public void setFlgDeleted(Boolean flgDeleted) {
        this.flgDeleted = flgDeleted;
    }
    
    
}
