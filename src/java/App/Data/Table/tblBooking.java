package App.Data.Table;

import App.Data.Booking;
import java.util.Map;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class tblBooking extends Base
{
    public static Booking getUserByUID(int lngUID) {
        Map mapData = tblBooking.getByPK("TBLBOOKING", lngUID);
        
        Booking objBooking = new Booking(mapData);
        
        return objBooking;
    }
}
