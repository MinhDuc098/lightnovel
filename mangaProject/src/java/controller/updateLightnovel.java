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
import java.util.List;
import model.category;
import model.lightnovel;

/**
 *
 * @author AS
 */
@WebServlet(name = "updateLightnovel", urlPatterns = {"/updateLightnovel"})
public class updateLightnovel extends HttpServlet {

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
            out.println("<title>Servlet updateLightnovel</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateLightnovel at " + request.getContextPath() + "</h1>");
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
        String nid_raw = request.getParameter("nid");
        try {
            int nid = Integer.parseInt(nid_raw);
            Lightnovel L = new Lightnovel();
            lightnovel li = L.getLightnovelById(nid);
            Category c = new Category();
            List<category> lc = c.getAllCategory();
            request.setAttribute("listc", lc);
            request.setAttribute("lightnovel", li);
            request.getRequestDispatcher("updateLightnovel.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
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
        String nid_raw = request.getParameter("id");
        String name = request.getParameter("name");
        String othername = request.getParameter("othername");
        String img = request.getParameter("img");
        String des = request.getParameter("des");
        String status = request.getParameter("status");
        Lightnovel L = new Lightnovel();
        Category c = new Category();
        String[] cid_raw = new String[0]; 
          if(request.getParameterValues("category") != null){
              cid_raw = request.getParameterValues("category");
          }
        try{
        int nid = Integer.parseInt(nid_raw);
        L.updateLightnovel(nid, name, othername, img, des, status);

        if(cid_raw.length > 0){
        int [] cid = new int[cid_raw.length];
        for(int i = 0 ;i <cid_raw.length;i++){
            cid[i] = Integer.parseInt(cid_raw[i]);
        }
        // insert light novel
        // get the id of new light novel
        // add category for new light novel
        
        c.deteleCategory(nid);
        c.insertCategory(nid, cid);
        }
        response.sendRedirect("manageLightnovel");
        
        }
        catch(Exception e){
            System.out.println(e);
        }
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
