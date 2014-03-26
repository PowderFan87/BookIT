package Core.Command;

import Interface.IRestricted;
import javax.servlet.http.HttpServletRequest;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Factory
{
    public static Core.Command.Base getCommand(HttpServletRequest objRequest) {
        String              strCommand  = objRequest.getRequestURI().substring(1).replaceAll("BookIT", "Command");
        String              strAction;
        Core.Command.Base   objCommand  = null;

        switch (objRequest.getMethod()) {
            case "GET":
                strCommand = strCommand.replaceFirst("/g/", "/Get/");

                break;
            case "POST":
                if(objRequest.getHeader("X-Requested-With") != null && objRequest.getHeader("X-Requested-With").equals("XMLHttpRequest")) {
                    strCommand = strCommand.replaceFirst("/a/", "/Ajax/");
                    
                    System.out.print("In Ajax " + strCommand);
                } else {
                    strCommand = strCommand.replaceFirst("/p/", "/Post/");
                    
                    System.out.print("In Post " + strCommand);
                }

                break;
        }

        if(strCommand.split("/").length < 4) {
            strAction   = "Default";
        } else {
            strAction   = strCommand.substring(strCommand.lastIndexOf("/")).substring(1);
            strCommand  = strCommand.substring(0, strCommand.lastIndexOf("/"));
        }

        strCommand = strCommand.replace('/', '.');
        
        try {
            Class<?> objClass   = Class.forName(strCommand);
            objCommand          = (Core.Command.Base)objClass.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(objCommand != null) {
            objCommand.setstrAction(strAction);
        }
        
        if(objCommand instanceof IRestricted) {
            try {
                ((IRestricted)objCommand).checkRestriction();
            } catch(RestrictionException ex) {
                objCommand.setstrAction("Fallback");
            }
        }
        
        return objCommand;
    }
}
