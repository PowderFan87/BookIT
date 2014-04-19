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

    public void setTblUser_UID(int tblUser_UID) {
        this.tblUser_UID = tblUser_UID;
    }

    public int getTblTask_UID() {
        return tblTask_UID;
    }

    public void setTblTask_UID(int tblTask_UID) {
        this.tblTask_UID = tblTask_UID;
    }

    public int getLngGrantedminutes() {
        return lngGrantedminutes;
    }

    public void setLngGrantedminutes(int lngGrantedminutes) {
        this.lngGrantedminutes = lngGrantedminutes;
    }

    public int getLngMinutesleft() {
        return lngMinutesleft;
    }

    public void setLngMinutesleft(int lngMinutesleft) {
        this.lngMinutesleft = lngMinutesleft;
    }

    public int getLngBookingscount() {
        return lngBookingscount;
    }

    public void setLngBookingscount(int lngBookingscount) {
        this.lngBookingscount = lngBookingscount;
    }

    public Boolean isFlgDeleted() {
        return flgDeleted;
    }

    public void setFlgDeleted(Boolean flgDeleted) {
        this.flgDeleted = flgDeleted;
    }
    
    
}
