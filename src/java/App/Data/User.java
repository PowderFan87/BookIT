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
    
    public User() {
        super();
    }
    
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

    public User setUID(int UID) {
        this.UID = UID;
        
        return this;
    }

    public String getStrUsername() {
        return strUsername;
    }

    public User setStrUsername(String strUsername) {
        this.strUsername = strUsername;
        
        return this;
    }

    public String getStrPassword() {
        return strPassword;
    }

    public User setStrPassword(String strPassword) {
        this.strPassword = strPassword;
        
        return this;
    }

    public boolean isBlnActive() {
        return blnActive;
    }

    public User setBlnActive(boolean blnActive) {
        this.blnActive = blnActive;
        
        return this;
    }

    public Date getDtmActivated() {
        return dtmActivated;
    }

    public User setDtmActivated(Date dtmActivated) {
        this.dtmActivated = dtmActivated;
        
        return this;
    }

    public boolean isFlgDeleted() {
        return flgDeleted;
    }

    public User setFlgDeleted(boolean flgDeleted) {
        this.flgDeleted = flgDeleted;
        
        return this;
    }

    public int getTblUsertype_UID() {
        return tblUsertype_UID;
    }

    public User setTblUsertype_UID(int tblUsertype_UID) {
        this.tblUsertype_UID = tblUsertype_UID;
        
        return this;
    }
}
