/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Dal.Category;
import Dal.Lightnovel;
import Dal.Save;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.category;
import model.lightnovel;
import model.save;

/**
 *
 * @author AS
 */
@WebServlet(name = "loadSaved", urlPatterns = {"/loadSaved"})
public class loadSaved extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loadSaved</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loadSaved at " + request.getContextPath() + "</h1>");
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
         HttpSession session =  request.getSession();
        
        if(session.getAttribute("user")==null){
            request.setAttribute("mess", "user should login to use this function!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else{
            
        String uID_raw = request.getParameter("uID");
        Lightnovel L = new Lightnovel();
        Save s = new Save();
        Category c = new Category();

        try {
            int uID = Integer.parseInt(uID_raw);
            List<save> l = s.getSavedNovelByUid(uID);
            List<lightnovel> light = new ArrayList<>();
            List<category> lc = c.getAllCategory();

            for (int i = 0; i < l.size(); i++) {
                lightnovel lt = L.getLightnovelById(l.get(i).getNid());
                light.add(lt);
            }
            request.setAttribute("delete", "Delete");
            request.setAttribute("listc", lc);
            request.setAttribute("mess", "Saved Lightnovel");
            request.setAttribute("history", light);
            request.getRequestDispatcher("myAccount.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
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
