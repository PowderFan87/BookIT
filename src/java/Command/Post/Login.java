package Command.Post;

import Core.Command.Base;
import Core.Web;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Login extends Base
{
    public void runDefault() {
        Web.objSession.setAttribute("lngUserid", 5);
    }
}
