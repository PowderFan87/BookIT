package App.Data;

import java.util.Map;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class User extends Base
{
    private int     UID;
    private String  strUsername;
    private String  strPassword;
    private boolean blnActive;
    private String  dtmActivated;
    private boolean flgDeleted;
    private int     tblUsertype_UID;
    
    public User(Map<String, String> mapData) {
        super();
        
        this.UID                = Integer.parseInt(mapData.get("UID"));
        this.strUsername        = mapData.get("STRUSERNAME");
        this.strPassword        = mapData.get("STRPASSWORD");
        this.blnActive          = Boolean.parseBoolean(mapData.get("BLNACTIVE"));
        this.dtmActivated       = mapData.get("DTMACTIVATED");
        this.flgDeleted         = Boolean.parseBoolean(mapData.get("FLGDELETED"));
        this.tblUsertype_UID    = Integer.parseInt(mapData.get("TBLUSERTYPE_UID"));
    }
    
    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getStrUsername() {
        return strUsername;
    }

    public void setStrUsername(String strUsername) {
        this.strUsername = strUsername;
    }

    public String getStrPassword() {
        return strPassword;
    }

    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    public boolean isBlnActive() {
        return blnActive;
    }

    public void setBlnActive(boolean blnActive) {
        this.blnActive = blnActive;
    }

    public String getDtmActivated() {
        return dtmActivated;
    }

    public void setDtmActivated(String dtmActivated) {
        this.dtmActivated = dtmActivated;
    }

    public boolean isFlgDeleted() {
        return flgDeleted;
    }

    public void setFlgDeleted(boolean flgDeleted) {
        this.flgDeleted = flgDeleted;
    }

    public int getTblUsertype_UID() {
        return tblUsertype_UID;
    }

    public void setTblUsertype_UID(int tblUsertype_UID) {
        this.tblUsertype_UID = tblUsertype_UID;
    }
}
