package Command.Get;

import Core.Command.Base;
import Core.Web;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Test2 extends Base
{
    @Override
    public void runDefault() {
        Web.objSession.setAttribute("lngUserid", 7);
        
        try {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
