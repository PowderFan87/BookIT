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
public class Booking extends Base
{
    private int     UID;
    private int     lngMinutes;
    private String  strComment;
    private Date    dtmDate;
    private Boolean flgDeleted;
    private int     tblUser_UID;
    private int     tblTask_UID;
    
    public Booking() {
        super();
    }
    
    public Booking(Map<String, String> mapData) {
        super();
        
        SimpleDateFormat objParser = new SimpleDateFormat("yyyy-MM-dd");
        
        this.UID            = Integer.parseInt(mapData.get("UID"));
        this.lngMinutes     = Integer.parseInt(mapData.get("LNGMINUTES"));
        this.strComment     = mapData.get("STRCOMMENT");
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

    public Booking setUID(int UID) {
        this.UID = UID;
        
        return this;
    }

    public int getLngMinutes() {
        return lngMinutes;
    }

    public Booking setLngMinutes(int lngMinutes) {
        this.lngMinutes = lngMinutes;
        
        return this;
    }

    public String getStrComment() {
        return strComment;
    }

    public Booking setStrComment(String strComment) {
        this.strComment = strComment;
        
        return this;
    }

    public Date getDtmDate() {
        return dtmDate;
    }

    public Booking setDtmDate(Date dtmDate) {
        this.dtmDate = dtmDate;
        
        return this;
    }
    
    public String getStrDate() {
        SimpleDateFormat objParser = new SimpleDateFormat("dd.MM.yyyy");
        
        return objParser.format(this.dtmDate);
    }

    public Boolean isFlgDeleted() {
        return flgDeleted;
    }

    public Booking setFlgDeleted(Boolean flgDeleted) {
        this.flgDeleted = flgDeleted;
        
        return this;
    }

    public int getTblUser_UID() {
        return tblUser_UID;
    }

    public Booking setTblUser_UID(int tblUser_UID) {
        this.tblUser_UID = tblUser_UID;
        
        return this;
    }

    public int getTblTask_UID() {
        return tblTask_UID;
    }

    public Booking setTblTask_UID(int tblTask_UID) {
        this.tblTask_UID = tblTask_UID;
        
        return this;
    }

    @Override
    public Base doInsert() {
        Map<String, String> mapData = new HashMap<>();
        
        SimpleDateFormat objParser = new SimpleDateFormat("yyyy-MM-dd");

        mapData.put("LNGMINUTES", String.valueOf(this.lngMinutes));
        mapData.put("STRCOMMENT", this.strComment);
        mapData.put("DTMDATE", objParser.format(this.dtmDate));
        mapData.put("TBLTASK_UID", String.valueOf(this.tblTask_UID));
        mapData.put("TBLUSER_UID", String.valueOf(this.tblUser_UID));
        
        return this.doInsert("TBLBOOKING", mapData);
    }

    @Override
    public Base doUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
