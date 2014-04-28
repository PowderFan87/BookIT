package Command.Post;

import Core.Command.Base;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Logout extends Base
{
    @Override
    public void runDefault() {
        this.objRequest.getSession().invalidate();
        
        try {
            this.objResponse.sendRedirect("/BookIT");
        } catch (IOException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
