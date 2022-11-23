/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import Dal.Chapter;
import Dal.Lightnovel;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.nio.file.Paths;
import java.nio.file.Files;

/**
 *
 * @author AS
 */
@WebServlet(name="addChapter", urlPatterns={"/addChapter"})
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class addChapter extends HttpServlet {
   
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
            out.println("<title>Servlet addChapter</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addChapter at " + request.getContextPath () + "</h1>");
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
 String name = request.getParameter("name");
        String file = request.getParameter("file");
        String nid_raw = request.getParameter("nid");
        Chapter c = new Chapter();
        Lightnovel L = new Lightnovel();
        try{
        int nid = Integer.parseInt(nid_raw);
        c.insertChapter(name, file, nid);
        L.updateDate(nid);
        
        response.sendRedirect("updateChapter?nid="+nid);
        }catch(Exception e){
            System.out.println(e);
        }    } 

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
 String name = request.getParameter("name");
        
        Part part = request.getPart("file");
        String fileName = part.getSubmittedFileName();
        
        String nid_raw = request.getParameter("nid");
        Chapter c = new Chapter();
        Lightnovel L = new Lightnovel();
        try{
        part.write("E:\\STUDT SE FORTH TERM\\PRJ301\\lightnovel\\mangaProject\\web\\lightnovel\\"+fileName);
        String file = "lightnovel/"+fileName;
            
        
        int nid = Integer.parseInt(nid_raw);
        c.insertChapter(name, file, nid);
        L.updateDate(nid);
        
        response.sendRedirect("updateChapter?nid="+nid);
        }catch(Exception e){
            System.out.println(e);
        }    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
