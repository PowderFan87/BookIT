package Core.Command;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public abstract class Base
{
    private     String              strAction;
    
    protected   HttpServletRequest  objRequest;
    protected   HttpServletResponse objResponse;
    
    public abstract void runDefault();
    
    public void run(HttpServletRequest objRequest, HttpServletResponse objResponse) {
        Method objMethod    = null;
        this.objRequest     = objRequest;
        this.objResponse    = objResponse;
        
        try {
            objMethod = this.getClass().getMethod("run" + this.strAction);
            
            objMethod.invoke(this);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getstrAction() {
        return this.strAction;
    }
    
    public void setstrAction(String strAction) {
        this.strAction = strAction;
    }
}
