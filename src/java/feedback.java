/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KHSCI5MCA16069
 */
public class feedback extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet feedback</title>");            
            out.println("</head>");
            out.println("<body>");
 
            
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Event","root","");
                PreparedStatement ps = con.prepareStatement("select * from feedback");
                
                ResultSet rs = ps.executeQuery();
                
                out.println("<html><head></head><body background='box2.jpeg'><center><img src=\"icon.PNG\" height=\"150px\" width=\"250px\"></center><p><font size='32px' face='monotype corsiva'><center> YOUR DETAILS HAVE BEEN ADDED....</center></font></p></body></html>\n ");

                out.println("<table border=5 width=100% height=100% align=center>"
                        + "<tr>"
                        + "<th>EVENT</th>"
                        +"<th>FEEDBACK</th>"
                        + "</tr>");
   
                while(rs.next())
                {
                    String event = rs.getString(1);
                    String feedback = rs.getString(2);
                    
                    out.println("<tr align=center >"+ "<td >" +event+"<td width ='20%' >"+feedback+"</tr>");
                    out.println("<br>");
                    out.println("<br>"); 
                    
                }
                 out.println("</table>");
                 
                    con.close();
            }
            catch(Exception e)
            {
                out.println("Exception : "+e);
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
