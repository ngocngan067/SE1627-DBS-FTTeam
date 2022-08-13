package com.teamthree.freshtooth.controllers;

import com.teamthree.freshtooth.dbo.AccountFacade;
import com.teamthree.freshtooth.dbo.DentistFacade;
import com.teamthree.freshtooth.models.Account;
import com.teamthree.freshtooth.models.Dentist;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DentistDetailController extends HttpServlet {
    
    private static final String DENTIST_DETAIL = "DENTIST_DETAIL";
    private static final String ACCOUNT_DETAIL = "ACCOUNT_DETAIL";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            String dentistID = request.getParameter("did");
            
            if (dentistID != null) {
                DentistFacade dentistFacade = new DentistFacade();
                AccountFacade accountFacade = new AccountFacade();
                
                Dentist dentist = dentistFacade.getDentistDetail(dentistID);
                Account account = accountFacade.checkAccount(dentistID, "GetAccountDentist");
                
                request.setAttribute(DENTIST_DETAIL, dentist);
                request.setAttribute(ACCOUNT_DETAIL, account);
                
                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/user/DentistDetail.jsp");
                requestDispatcher.forward(request, response);
            } else {
                response.sendRedirect(request.getHeader("referer"));
            }
            
        } catch (IOException | SQLException | ServletException e) {
            response.sendRedirect(request.getContextPath() + "/error");
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
