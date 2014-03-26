package Command.Get;

import App.Data.Table.tblUser;
import App.Data.User;
import Core.Command.Base;
import Core.Command.RestrictionException;
import Interface.IRestricted;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Test extends Base implements IRestricted
{
    @Override
    public void runDefault() {
        User objUser = tblUser.getUserByUID(1);
        
        System.out.println("Username: " + objUser.getStrUsername());
        System.out.println("Password: " + objUser.getStrPassword());
    }
    
    @Override
    public void checkRestriction() throws RestrictionException {
        if(!App.Security.isLoggedIn()) {
            throw new RestrictionException();
        }
    }

    @Override
    public void runFallback() {
        
    }
}
