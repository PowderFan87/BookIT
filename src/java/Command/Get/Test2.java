package Command.Get;

import Core.Command.Base;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Test2 extends Base
{
    @Override
    public void runDefault() {
        this.objRequest.getSession().setAttribute("lngUserid", 7);
        
        this.objRequest.setAttribute("tplView", "Get/Test2.jsp");
        this.objRequest.setAttribute("strTitle", "Test 2");
    }
}
