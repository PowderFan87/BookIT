package Interface;

import Core.Command.RestrictionException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public interface IRestricted
{
    public  void    checkRestriction(HttpServletRequest objRequest) throws RestrictionException;
    public  void    runFallback();
}
