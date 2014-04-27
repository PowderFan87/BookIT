package Core.Command;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
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
    protected   HttpServletRequest      objRequest;
    protected   HttpServletResponse     objResponse;
    
    private     String                  strAction;
    private     Map<String, String[]>   mapParams = new HashMap<>();
    
    public abstract void runDefault();
    
    public void run(HttpServletRequest objRequest, HttpServletResponse objResponse) {
        this.objRequest     = objRequest;
        this.objResponse    = objResponse;
        
        this.doSanitize();
        
        System.out.println(this.strAction);
        
        try {
            Method objMethod = this.getClass().getMethod("run" + this.strAction);
            
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
    
    public Object getParameter(String strName) {
        return this.mapParams.get(strName)[0];
    }
    
    private void doSanitize() {
        this.mapParams = this.objRequest.getParameterMap();
        
        for(String strKey: this.mapParams.keySet()) {
            String[] arrParam = this.mapParams.get(strKey);
            
            for(int i = 0; i < arrParam.length; i++) {
                arrParam[i] = arrParam[i]
                    .replace("\\", "\\\\")
                    .replace("'", "\\'")
                    .replace("\0", "\\0")
                    .replace("\n", "\\n")
                    .replace("\r", "\\r")
                    .replace("\"", "\\\"")
                    .replace("\\x1a", "\\Z");
                
                //todo striptags...
            }
        }
    }
}
