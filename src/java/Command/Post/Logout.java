package Command.Post;

import Core.Command.Base;
import Core.Web;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Logout extends Base
{
    public void runDefault() {
        Web.objSession.invalidate();
    }
}
