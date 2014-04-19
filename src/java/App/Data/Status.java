package App.Data;

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

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getTxtDescription() {
        return txtDescription;
    }

    public void setTxtDescription(String txtDescription) {
        this.txtDescription = txtDescription;
    }

    public Boolean isFlgDeleted() {
        return flgDeleted;
    }

    public void setFlgDeleted(Boolean flgDeleted) {
        this.flgDeleted = flgDeleted;
    }
    
    
}
