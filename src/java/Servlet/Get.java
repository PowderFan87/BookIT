package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Get extends HttpServlet
{
    private void processRequest(HttpServletRequest objRequest, HttpServletResponse objResponse) throws IOException {
        objResponse.setContentType("text/html;charset=UTF-8");
        
        PrintWriter objOutput   = objResponse.getWriter();
        
        try {
            objOutput.print("<!DOCTYPE html>"
                    + "<html>"
                    + "     <head>"
                    + "         <title>Dummy page</title>"
                    + "         <script type=\"text/javascript\" src=\"/BookIT/js/libs/jquery/jquery.js\"></script>"
                    + "     </head>"
                    + "     <body>"
                    + "         <h1>Just a dummy page</h1>"
                    + "         <br />&nbsp;<br />"
                    + "         <h3>Request Data</h3>"
                    + "         <br />"
                    + "         <div>"
                    + "             QueryString: " + objRequest.getQueryString() + "<br />"
                    + "             RequestURI:  " + objRequest.getRequestURI()+ "<br />"
                    + "             PathInfo:    " + objRequest.getPathInfo()+ "<br />"
                    + "             Protocol:    " + objRequest.getProtocol()+ "<br />"
                    + "             Method:      " + objRequest.getMethod()+ "<br />"
                    + "             RemoteAddr:  " + objRequest.getRemoteAddr()+ "<br />"
                    + "             SessionId:   " + objRequest.getRequestedSessionId()+ "<br />"
                    + "             XHttpReq:    " + objRequest.getHeader("X-Requested-With")+ "<br />"
                    + "         </div>"
                    + "     </body>"
                    + "</html>");
        } finally {
            objOutput.close();
        }
    }
    
    /**
     * Process get requests
     * 
     * @param objRequest
     * @param objResponse
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest objRequest, HttpServletResponse objResponse) throws ServletException, IOException {
        processRequest(objRequest, objResponse);
    }
    
    /**
     * Process Post requests
     * 
     * @param objRequest
     * @param objResponse
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest objRequest, HttpServletResponse objResponse) throws ServletException, IOException {
        processRequest(objRequest, objResponse);
    }
}
