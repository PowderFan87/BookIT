package App.Data;

import java.util.Map;

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
    
    public UserHasTask(Map<String, String> mapData) {
        super();
        
        this.tblUser_UID        = Integer.parseInt(mapData.get("TBLUSER_UID"));
        this.tblTask_UID        = Integer.parseInt(mapData.get("TBLTASK_UID"));
        this.lngGrantedminutes  = Integer.parseInt(mapData.get("LNGGRANTEDMINUTES"));
        this.lngMinutesleft     = Integer.parseInt(mapData.get("LNGMINUTESLEFT"));
        this.lngBookingscount   = Integer.parseInt(mapData.get("LNGBOOKINGSCOUNT"));
        this.flgDeleted         = Boolean.parseBoolean(mapData.get("FLGDELETED"));
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
    
    
}
