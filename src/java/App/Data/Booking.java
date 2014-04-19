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
public class Booking extends Base
{
    private int     UID;
    private int     lngMinutes;
    private String  strComment;
    private Date    dtmDate;
    private Boolean flgDeleted;
    private int     tblUser_UID;
    private int     tblTask_UID;
    
    public Booking(Map<String, String> mapData) {
        super();
        
        SimpleDateFormat objParser = new SimpleDateFormat("yyyy-mm-dd");
        
        this.UID            = Integer.parseInt(mapData.get("UID"));
        this.lngMinutes     = Integer.parseInt(mapData.get("LNGMINUTES"));
        this.strComment     = mapData.get("strComment");
        try {
            this.dtmDate    = objParser.parse(mapData.get("DTMDATE"));
        } catch (ParseException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.flgDeleted     = Boolean.parseBoolean(mapData.get("FLGDELETED"));
        this.tblTask_UID    = Integer.parseInt(mapData.get("TBLTASK_UID"));
        this.tblUser_UID    = Integer.parseInt(mapData.get("TBLUSER_UID"));
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public int getLngMinutes() {
        return lngMinutes;
    }

    public void setLngMinutes(int lngMinutes) {
        this.lngMinutes = lngMinutes;
    }

    public String getStrComment() {
        return strComment;
    }

    public void setStrComment(String strComment) {
        this.strComment = strComment;
    }

    public Date getDtmDate() {
        return dtmDate;
    }

    public void setDtmDate(Date dtmDate) {
        this.dtmDate = dtmDate;
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

    public int getTblTask_UID() {
        return tblTask_UID;
    }

    public void setTblTask_UID(int tblTask_UID) {
        this.tblTask_UID = tblTask_UID;
    }
    
    
}
