package App.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private Date    dtmActivated;
    private boolean flgDeleted;
    private int     tblUsertype_UID;
    
    public User(Map<String, String> mapData) {
        super();
        
        SimpleDateFormat objParser = new SimpleDateFormat("yyyy-mm-dd");
        
        this.UID                = Integer.parseInt(mapData.get("UID"));
        this.strUsername        = mapData.get("STRUSERNAME");
        this.strPassword        = mapData.get("STRPASSWORD");
        this.blnActive          = Boolean.parseBoolean(mapData.get("BLNACTIVE"));
        try {
            this.dtmActivated   = objParser.parse(mapData.get("DTMACTIVATED"));
        } catch (ParseException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public Date getDtmActivated() {
        return dtmActivated;
    }

    public void setDtmActivated(Date dtmActivated) {
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
