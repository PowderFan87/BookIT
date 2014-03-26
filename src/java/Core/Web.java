package Core;

import Core.Command.Factory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class Web extends HttpServlet
{
    public  static  HttpSession objSession;
    
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
        
        Web.objSession = objRequest.getSession();
        
        try (PrintWriter out = objResponse.getWriter()) {
            Core.Command.Base objCommand = Factory.getCommand(objRequest);
            
            objCommand.run(objRequest, objResponse);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Post</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Post at " + objRequest.getContextPath() + "</h1>");
            out.println("<pre>");
            out.println(objRequest.getRequestURI().substring(1));
            out.println(objCommand.getstrAction());
            out.println(objRequest.getMethod());
            out.println(objRequest.getHeader("X-Requested-With"));
            out.println(this.getServletInfo());
            out.println(Web.objSession.getAttribute("lngUserid"));
            out.println("</pre>");
            out.println("<form action=\"/BookIT/p/Logout\" method=\"POST\">");
            out.println("<input type=\"submit\" value=\"Logout\" />");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}