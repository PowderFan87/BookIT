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
public class Project extends Base
{
    private int     UID;
    private String  strName;
    private Date    dtmCreated;
    private String  txtDescription;
    private Boolean flgDeleted;
    private int     tblUser_UID;
    private int     tblStatus_UID;
    
    public Project(Map<String, String> mapData) {
        super();
        
        SimpleDateFormat objDateParser = new SimpleDateFormat("yyyy-mm-dd");
        
        this.UID            = Integer.parseInt(mapData.get("UID"));
        this.strName        = mapData.get("STRNAME");
        
        try {
            this.dtmCreated = objDateParser.parse(mapData.get("DTMCREATED"));
        } catch (ParseException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.txtDescription = mapData.get("TXTDESCRIPTION");
        this.flgDeleted     = Boolean.parseBoolean(mapData.get("FLGDELETED"));
        this.tblUser_UID    = Integer.parseInt(mapData.get("TBLUSER_UID"));
        this.tblStatus_UID  = Integer.parseInt(mapData.get("TBLSTATUS_UID"));
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

    public Date getDtmCreated() {
        return dtmCreated;
    }

    public void setDtmCreated(Date dtmCreated) {
        this.dtmCreated = dtmCreated;
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

    public int getTblUser_UID() {
        return tblUser_UID;
    }

    public void setTblUser_UID(int tblUser_UID) {
        this.tblUser_UID = tblUser_UID;
    }

    public int getTblStatus_UID() {
        return tblStatus_UID;
    }

    public void setTblStatus_UID(int tblStatus_UID) {
        this.tblStatus_UID = tblStatus_UID;
    }
    
    
}
