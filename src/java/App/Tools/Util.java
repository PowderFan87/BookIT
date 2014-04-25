package App.Tools;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Util
{
    public static boolean isEmptyArray(Object[] arrArray) {
        boolean blnEmpty = true;
        
        for(Object mixElement: arrArray) {
            if(mixElement != null) {
                blnEmpty = false;
                
                break;
            }
        }
        
        return blnEmpty;
    }
}
