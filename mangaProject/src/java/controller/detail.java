/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import Dal.Category;
import Dal.Chapter;
import Dal.Comment;
import Dal.Lightnovel;
import addHistory.addHistory;
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
import model.account;
import model.category;
import model.catenovel;
import model.chapter;
import model.comment;
import model.lightnovel;

/**
 *
 * @author AS
 */
@WebServlet(name="loadCateForLightnovel", urlPatterns={"/loadCateForLightnovel"})
public class detail extends HttpServlet {
   
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
            out.println("<title>Servlet loadCateForLightnovel</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loadCateForLightnovel at " + request.getContextPath () + "</h1>");
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
        Comment comment = new Comment();
        Category c = new Category();
        Lightnovel L = new Lightnovel();
        Chapter chap  = new Chapter();
        addHistory ah = new addHistory();
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(864000);
        String nid_raw = request.getParameter("nid");
        
        if(session.getAttribute("history") == null){
            
        List<lightnovel> lnovel = new ArrayList<>();
        session.setAttribute("history", lnovel);
        }
        
        
        List<lightnovel> lnovel = (List<lightnovel>) session.getAttribute("history");
        
        try{
            
        int nid  = Integer.parseInt(nid_raw);
        
        if(session.getAttribute("user")!=null){
        lnovel = ah.addNewHistory(lnovel, nid);
        session.setAttribute("history", lnovel);
        }
        
        
        // lay light novel bang id
        lightnovel li = L.getLightnovelById(nid);
        // lay toan bo category
        List<category> lc = c.getAllCategory();
        
        // lay toan bo cac category cua  lightnovel
        List<catenovel> list =  c.getCategoryIdByLightnovelId(nid);
        List<category> category = c.getCategoryByLightnovelId(list);
        
        if(category.size()<=1){
            category.add(new category(0, ""));
        }
        // lay all chapter cua 1 lightnovel
        List<chapter> listChapter = chap.getChapterByNovelId(nid);
        if(listChapter.size() == 0){
            listChapter.add(new chapter(0, "no chapter", "",""));
        }
        
        
        // lay all comment
        
        List<comment> listComment = comment.getChapterByNovelId(nid);
        
            
        
        request.setAttribute("comment", listComment);
        request.setAttribute( "chapter", listChapter);
        request.setAttribute("category", category);
        request.setAttribute("lightnovel", li);
        request.setAttribute("listc", lc);
        request.getRequestDispatcher("lightnovel.jsp").forward(request, response);
        }
        catch(Exception e){
            System.out.println(e);
        }
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
