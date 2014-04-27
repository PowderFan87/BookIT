package Core;

import Core.Command.Factory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Web extends HttpServlet
{
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param objRequest servlet request
     * @param objResponse servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest objRequest, HttpServletResponse objResponse) throws ServletException, IOException {
        objResponse.setContentType("text/html;charset=UTF-8");
        
        Core.Command.Base objCommand = Factory.getCommand(objRequest);

        objCommand.run(objRequest, objResponse);

        if(!objResponse.isCommitted()) {
            objRequest.getRequestDispatcher("/WEB-INF/Template/index.jsp").forward(objRequest, objResponse);
        }
    }
    
    protected void processAjaxRequest(HttpServletRequest objRequest, HttpServletResponse objResponse) throws ServletException, IOException {
        objResponse.setContentType("application/json;charset=UTF-8");

        Core.Command.Base objCommand = Factory.getCommand(objRequest);

        objCommand.run(objRequest, objResponse);
        
        try(PrintWriter out = objResponse.getWriter()) {
            out.println("{");
            
            Map<String, Object> mapData = (Map<String, Object>)objRequest.getAttribute("mapData");
            
            int lngSize = mapData.size();
            for(String strKey: mapData.keySet()) {
                out.print(this.convertMapEntryToJSONString(strKey, mapData.get(strKey)));
                
                if(--lngSize != 0) {
                    out.println(",");
                } else {
                    out.println();
                }
            }
            
            out.println("}");
        }
    }
    
    private String convertMapEntryToJSONString(String strName, Object mixData) {
        String  strJson = "\"" + strName + "\" : ";
        int     lngSize;
        
        switch((mixData.getClass()).getSimpleName()) {
            case "Float":
            case "Double":
            case "Integer":
                strJson += String.valueOf(mixData);
                
                break;
            
            case "String":
                strJson += "\"" + mixData + "\"";
                
                break;
                
            case "String[]":
            case "Integer[]":
            case "Double[]":
            case "HashMap[]":
                strJson += "[";
                
                lngSize = ((Object[])mixData).length;
                for(Object mixEntry: (Object[])mixData) {
                    if(mixEntry instanceof String) {
                        strJson += "\"" + mixEntry + "\"";
                    } else if(mixEntry instanceof HashMap) {
                        strJson += "{";
                        
                        int lngSubsize = ((Map<String, Object>)mixEntry).size();
                        for(String strKey: ((Map<String, Object>)mixEntry).keySet()) {
                            strJson += this.convertMapEntryToJSONString(strKey, ((Map<String, Object>)mixEntry).get(strKey));

                            if(--lngSubsize != 0) {
                                strJson += ",";
                            }
                        }
                        
                        strJson += "}";
                    } else {
                        strJson += String.valueOf(mixEntry);
                    }
                    
                    if(--lngSize != 0) {
                        strJson += ",";
                    }
                }
                
                strJson += "]";
                
                break;
                
            case "HashMap":
                strJson += "{";
                
                lngSize = ((Map<String, Object>)mixData).size();
                for(String strKey: ((Map<String, Object>)mixData).keySet()) {
                    strJson += this.convertMapEntryToJSONString(strKey, ((Map<String, Object>)mixData).get(strKey));
                    
                    if(--lngSize != 0) {
                        strJson += ",";
                    }
                }
                
                strJson += "}";
        }
        
        return strJson;
    }
}
