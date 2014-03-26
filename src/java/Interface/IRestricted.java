package Interface;

import Core.Command.RestrictionException;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public interface IRestricted
{
    public  void    checkRestriction() throws RestrictionException;
    public  void    runFallback();
}
