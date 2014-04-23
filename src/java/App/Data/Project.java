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

    public Project setUID(int UID) {
        this.UID = UID;
        
        return this;
    }

    public String getStrName() {
        return strName;
    }

    public Project setStrName(String strName) {
        this.strName = strName;
        
        return this;
    }

    public Date getDtmCreated() {
        return dtmCreated;
    }

    public Project setDtmCreated(Date dtmCreated) {
        this.dtmCreated = dtmCreated;
        
        return this;
    }

    public String getTxtDescription() {
        return txtDescription;
    }

    public Project setTxtDescription(String txtDescription) {
        this.txtDescription = txtDescription;
        
        return this;
    }

    public Boolean isFlgDeleted() {
        return flgDeleted;
    }

    public Project setFlgDeleted(Boolean flgDeleted) {
        this.flgDeleted = flgDeleted;
        
        return this;
    }

    public int getTblUser_UID() {
        return tblUser_UID;
    }

    public Project setTblUser_UID(int tblUser_UID) {
        this.tblUser_UID = tblUser_UID;
        
        return this;
    }

    public int getTblStatus_UID() {
        return tblStatus_UID;
    }

    public Project setTblStatus_UID(int tblStatus_UID) {
        this.tblStatus_UID = tblStatus_UID;
        
        return this;
    }
    
    
}
