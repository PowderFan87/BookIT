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

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getStrSurname() {
        return strSurname;
    }

    public void setStrSurname(String strSurname) {
        this.strSurname = strSurname;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getStrEmail() {
        return strEmail;
    }

    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    public String getStrCustomstartpage() {
        return strCustomstartpage;
    }

    public void setStrCustomstartpage(String strCustomstartpage) {
        this.strCustomstartpage = strCustomstartpage;
    }

    public Boolean isFlgDeleted() {
        return flgDeleted;
    }

    public void setFlgDeleted(Boolean flgDeleted) {
        this.flgDeleted = flgDeleted;
    }

    public int getTblUser_UID() {
        return tblUser_UID;
    }

    public void setTblUser_UID(int tblUser_UID) {
        this.tblUser_UID = tblUser_UID;
    }
    
    
}
