package App.Data.Table;

import App.Data.Booking;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class tblBooking extends Base
{
    public static Booking getBookingByUID(int lngUID) {
        Map mapData = tblBooking.getByPK("TBLBOOKING", lngUID);
        
        Booking objBooking = new Booking(mapData);
        
        return objBooking;
    }
    
    public static List<Booking> getBookingsByUserUIDAndTaskUID(int tblUser_UID, int tblTask_UID) {
        List<Booking>   lisBookings = new ArrayList<>();
        List<String[]>  lisFilter   = new ArrayList<>();
        
        lisFilter.add(new String[]{"","tblUser_UID","=",String.valueOf(tblUser_UID)});
        lisFilter.add(new String[]{" AND","tblTask_UID","=",String.valueOf(tblTask_UID)});
        lisFilter.add(new String[]{" AND","flgDeleted","=","false"});
        
        List<Map> lisRows = tblBooking.fetchAll("TBLBOOKING", lisFilter);
        
        if(lisRows != null && !lisRows.isEmpty()) {
            for(Map<String, String> mapData:lisRows) {
                lisBookings.add(new Booking(mapData));
            }
        }
        
        return lisBookings;
    }
}
