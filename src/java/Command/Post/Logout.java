package Command.Post;

import Core.Command.Base;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Logout extends Base
{
    @Override
    public void runDefault() {
        this.objRequest.getSession().invalidate();
    }
}
