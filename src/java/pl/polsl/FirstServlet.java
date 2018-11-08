/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author wojte
 */
@WebServlet(name = "Test", urlPatterns = {"/First", "/FirstOne"})
public class FirstServlet extends HttpServlet {

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
//            Enumeration<String> paramNames = request.getParameterNames();
//            
//            while(paramNames.hasMoreElements()){
//                String name = paramNames.nextElement();
//                out.println(name + ": " + request.getParameter(name) + "<br>" );
//            }
            String name = request.getParameter("name");
            String age = request.getParameter("age");
            
            if(name != null && !name.isEmpty()) { 
                out.println("name" + ": " + name + "<br>" );
            }
            else {
                out.println("name is missing");
                request.setAttribute("msg", "Missing parameters");
//                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "name is missing");
                request.getRequestDispatcher("/ErrorServlet").forward(request,response);
            }
//            
            try {
                Integer.parseInt(age);
            }
            catch (NumberFormatException e) {
                request.setAttribute("msg", "Missing or empty paramater");
                request.getRequestDispatcher("/ErrorServlet").include(request, response);
            }
//            if (!age.matches("[0-9]"))
//            {
//                out.println("Non integer age!");
////                response.sendRedirect("http://www.google.com");
//            }
//            else if(age != null && !age.isEmpty()) { 
//                out.println("age" + ": " + age + "<br>" );
//            }
//            else {
//                out.println("age is missing");
//                request.getRequestDispatcher("/ErrorServlet").forward(request,response);
//
//            }
            

            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet FirstServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet FirstServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
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
