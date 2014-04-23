package App.Data;

import java.util.Map;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Userprofile extends Base
{
    private int     UID;
    private String  strSurname;
    private String  strName;
    private String  strEmail;
    private String  strCustomstartpage;
    private Boolean flgDeleted;
    private int     tblUser_UID;
    
    public Userprofile() {
        super();
    }
    
    public Userprofile(Map<String, String> mapData) {
        super();
        
        this.UID                = Integer.parseInt(mapData.get("UID"));
        this.strSurname         = mapData.get("STRSURNAME");
        this.strName            = mapData.get("STRNAME");
        this.strEmail           = mapData.get("STREMAIL");
        this.strCustomstartpage = mapData.get("STRCUSTOMESTARTPAGE");
        this.flgDeleted         = Boolean.parseBoolean(mapData.get("FLGDELETED"));
        this.tblUser_UID        = Integer.parseInt(mapData.get("TBLUSER_UID"));
    }

    public int getUID() {
        return UID;
    }

    public Userprofile setUID(int UID) {
        this.UID = UID;
        
        return this;
    }

    public String getStrSurname() {
        return strSurname;
    }

    public Userprofile setStrSurname(String strSurname) {
        this.strSurname = strSurname;
        
        return this;
    }

    public String getStrName() {
        return strName;
    }

    public Userprofile setStrName(String strName) {
        this.strName = strName;
        
        return this;
    }

    public String getStrEmail() {
        return strEmail;
    }

    public Userprofile setStrEmail(String strEmail) {
        this.strEmail = strEmail;
        
        return this;
    }

    public String getStrCustomstartpage() {
        return strCustomstartpage;
    }

    public Userprofile setStrCustomstartpage(String strCustomstartpage) {
        this.strCustomstartpage = strCustomstartpage;
        
        return this;
    }

    public Boolean isFlgDeleted() {
        return flgDeleted;
    }

    public Userprofile setFlgDeleted(Boolean flgDeleted) {
        this.flgDeleted = flgDeleted;
        
        return this;
    }

    public int getTblUser_UID() {
        return tblUser_UID;
    }

    public Userprofile setTblUser_UID(int tblUser_UID) {
        this.tblUser_UID = tblUser_UID;
        
        return this;
    }
    
    
}
