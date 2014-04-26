package App.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
    
    public Project() {
        super();
    }
    
    public Project(Map<String, String> mapData) {
        super();
        
        SimpleDateFormat objParser = new SimpleDateFormat("yyyy-MM-dd");
        
        this.UID            = Integer.parseInt(mapData.get("UID"));
        this.strName        = mapData.get("STRNAME");
        
        try {
            this.dtmCreated = objParser.parse(mapData.get("DTMCREATED"));
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

    @Override
    public Base doInsert() {
        Map<String, String> mapData = new HashMap<>();
        
        SimpleDateFormat objParser = new SimpleDateFormat("yyyy-MM-dd");
        
        mapData.put("STRNAME", this.strName);
        mapData.put("DTMDATE", objParser.format(this.dtmCreated));
        mapData.put("TXTDESCRIPTION", this.txtDescription);
        mapData.put("TBLUSER_UID", String.valueOf(this.tblUser_UID));
        mapData.put("TBLSTATUS_UID", String.valueOf(this.tblStatus_UID));
        
        return this.doInsert("TBLPROJECT", mapData);
    }

    @Override
    public Base doUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
