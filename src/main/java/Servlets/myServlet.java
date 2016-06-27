/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.ListManager;
import logic.Message;

/**
 *
 * @author gianlucamost
 */
@WebServlet(name = "myServlet", urlPatterns = {"/myServlet"})
public class myServlet extends HttpServlet {
    
    private List<Message> messages = new ArrayList<Message>();

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
            out.println("<title>Servlet myServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet myServlet at " + request.getContextPath() + "</h1>");
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
            
            ListManager lm = ListManager.getInstance();

            Message msg = new Message();
            if(request.getParameter("lesen")==null) {
                msg.setName(request.getParameter("Vorname"));
                msg.setSurname(request.getParameter("Nachname"));
                msg.setMail(request.getParameter("Mail"));
                msg.setDate(request.getParameter("Datum")); 
                msg.setCategory(request.getParameter("Kategorie")); 
                msg.setHeadline(request.getParameter("Ueberschrift")); 
                msg.setMessage(request.getParameter("Nachricht"));
                this.messages.add(msg);
                lm.addToList(msg);
            }else {
                int i = Integer.parseInt(request.getParameter("lesen"));
                msg = lm.getMessageList().get(i);
            }
            
            System.out.println("Nachrichten:");
            for (Message m : lm.getMessageList()) {
                System.out.println(m.toString());
                
            }
            System.out.println("");
            
            
            System.out.println(lm.getMessageList().size());
            
            request.setAttribute("myMessage", msg);
            
            RequestDispatcher dispatcher;
            dispatcher = request.getRequestDispatcher("/WEB-INF/detail.jsp");
            dispatcher.forward(request, response);
        
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
        //processRequest(request, response);
        doGet(request, response);
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
