/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import Dal.Category;
import Dal.Lightnovel;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.category;
import model.lightnovel;

/**
 *
 * @author AS
 */
@WebServlet(name="loadLightnovel", urlPatterns={"/loadLightnovel"})
public class loadLightnovel extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet loadLightnovel</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loadLightnovel at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Category c = new Category();
        Lightnovel l = new Lightnovel();
        String index_raw = "1";
       
        if(request.getParameter("index")!=null){
          index_raw =    request.getParameter("index");
        }
        
        int index = Integer.parseInt(index_raw);
        
        List<lightnovel>  listNovel = l.getLightnovelOrderByDate (index);

        
        // lay toan bo category trong database
        List<category> lc = c.getAllCategory();
        
        // lay toan bo lightnovel trong databbase
        List<lightnovel> ll = l.getAllLightnovel();
        int endPage = ll.size()/9;
        if(ll.size()%9!=0){
            endPage++;
        }
        request.setAttribute("tag", index);
        request.setAttribute("endPage", endPage);
        request.setAttribute("listll", listNovel);
        request.setAttribute("listc", lc);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
