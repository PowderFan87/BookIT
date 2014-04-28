package App.Data;

import App.Data.Table.tblBooking;
import App.Data.Table.tblTask;
import App.Data.Table.tblUser;
import Core.DB.Connector;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class UserHasTask extends Base
{
    private int     tblUser_UID;
    private int     tblTask_UID;
    private int     lngGrantedminutes;
    private int     lngMinutesleft;
    private int     lngBookingscount;
    private Boolean flgDeleted;
    private User    objUser;
    
    public UserHasTask() {
        super();
    }
    
    public UserHasTask(Map<String, String> mapData) {
        super();
        
        this.tblUser_UID        = Integer.parseInt(mapData.get("TBLUSER_UID"));
        this.tblTask_UID        = Integer.parseInt(mapData.get("TBLTASK_UID"));
        this.lngGrantedminutes  = Integer.parseInt(mapData.get("LNGGRANTEDMINUTES"));
        this.lngMinutesleft     = Integer.parseInt(mapData.get("LNGMINUTESLEFT"));
        this.lngBookingscount   = Integer.parseInt(mapData.get("LNGBOOKINGSCOUNT"));
        this.flgDeleted         = Boolean.parseBoolean(mapData.get("FLGDELETED"));
    }

    @Override
    public int getUID() {
        return 0;
    }

    @Override
    public Base setUID(int lngUid) {
        // nothing happens here
        
        return this;
    }

    public int getTblUser_UID() {
        return tblUser_UID;
    }

    public UserHasTask setTblUser_UID(int tblUser_UID) {
        this.tblUser_UID = tblUser_UID;
        
        return this;
    }

    public int getTblTask_UID() {
        return tblTask_UID;
    }

    public UserHasTask setTblTask_UID(int tblTask_UID) {
        this.tblTask_UID = tblTask_UID;
        
        return this;
    }

    public int getLngGrantedminutes() {
        return lngGrantedminutes;
    }

    public UserHasTask setLngGrantedminutes(int lngGrantedminutes) {
        this.lngGrantedminutes = lngGrantedminutes;
        
        return this;
    }

    public int getLngMinutesleft() {
        return lngMinutesleft;
    }

    public UserHasTask setLngMinutesleft(int lngMinutesleft) {
        this.lngMinutesleft = lngMinutesleft;
        
        return this;
    }

    public int getLngBookingscount() {
        return lngBookingscount;
    }

    public UserHasTask setLngBookingscount(int lngBookingscount) {
        this.lngBookingscount = lngBookingscount;
        
        return this;
    }

    public Boolean isFlgDeleted() {
        return flgDeleted;
    }

    public UserHasTask setFlgDeleted(Boolean flgDeleted) {
        this.flgDeleted = flgDeleted;
        
        return this;
    }
    
    public int getLngMinutesworked() {
        return this.lngGrantedminutes - this.lngMinutesleft;
    }
    
    public String getStrDisplayname() {
        if(!(this.objUser instanceof User)) {
            this.objUser = tblUser.getUserByUID(this.tblUser_UID);
        }
        
        return this.objUser.getStrDisplayname();
    }
    
    public String getStrUsername() {
        if(!(this.objUser instanceof User)) {
            this.objUser = tblUser.getUserByUID(this.tblUser_UID);
        }
        
        return this.objUser.getStrUsername();
    }
    
    public int getLngAvgBookedMinutes() {
        if(this.lngBookingscount == 0) {
            return 0;
        }
        
        return (this.getLngMinutesworked() / this.lngBookingscount);
    }
    
    public List<Booking> getLisBookings() {
        return tblBooking.getBookingsByUserUIDAndTaskUID(this.tblUser_UID, this.tblTask_UID);
    }
    
    public Task getTask() {
        return tblTask.getTaskByUID(this.tblTask_UID);
    }

    @Override
    public Base doInsert() {
        String strSql = ""
                + "INSERT INTO TBLUSER_HAS_TBLTASK "
                + "(TBLUSER_UID, TBLTASK_UID, LNGGRANTEDMINUTES, LNGMINUTESLEFT, LNGBOOKINGSCOUNT) "
                + "VALUES ("
                + "" + String.valueOf(this.tblUser_UID) + ", "
                + "" + String.valueOf(this.tblTask_UID) + ", "
                + "" + String.valueOf(this.lngGrantedminutes) + ", "
                + "" + String.valueOf(this.lngMinutesleft) + ", "
                + "" + String.valueOf(this.lngBookingscount) + ")";
        try {
            Connector.getInstance().insert(strSql);
        } catch (SQLException ex) {
            Logger.getLogger(UserHasTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this;
    }

    @Override
    public Base doUpdate() {
        String strSql = ""
                + "UPDATE TBLUSER_HAS_TBLTASK SET "
                + "LNGGRANTEDMINUTES = " + String.valueOf(this.lngGrantedminutes) + ", "
                + "LNGMINUTESLEFT = " + String.valueOf(this.lngMinutesleft) + ", "
                + "LNGBOOKINGSCOUNT = " + String.valueOf(this.lngBookingscount) + " "
                + "WHERE "
                + "TBLUSER_UID = " + String.valueOf(this.tblUser_UID) + " "
                + "AND "
                + "TBLTASK_UID = " + String.valueOf(this.tblTask_UID);
        
        try {
            Connector.getInstance().update(strSql);
        } catch (SQLException ex) {
            Logger.getLogger(UserHasTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this;
    }
}
