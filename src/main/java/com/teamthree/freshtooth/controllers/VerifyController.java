package com.teamthree.freshtooth.controllers;

import com.teamthree.freshtooth.dbo.AccountFacade;
import com.teamthree.freshtooth.models.Account;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyController extends HttpServlet {
    
    private static final String VERIFY_STATUS = "VERIFY_STATUS";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            String userId = request.getParameter("uid");

            if (userId != null) {
                Account account = new Account();
                AccountFacade accountFacade = new AccountFacade();
                
                account.setUserEmail(userId);
                account.setUserStatus(1);
                
                Account checkAccount = accountFacade.checkAccount(account.getUserEmail(), "Login");

                if (checkAccount != null) {
                    Timestamp currentDate = new Timestamp(System.currentTimeMillis());

                    if ((currentDate.getMinutes() - checkAccount.getAccountCreated().getMinutes()) < 10) {
                        accountFacade.updateAccount(account, "EditStatusWithEmail");
                        request.setAttribute(VERIFY_STATUS, "Successful");
                    } else {
                        request.setAttribute(VERIFY_STATUS, "Error");
                    }
                }
                
                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/Verify.jsp");
                requestDispatcher.forward(request, response);
            } else {
                request.setAttribute(VERIFY_STATUS, "Successful");
                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/Verify.jsp");
                requestDispatcher.forward(request, response);
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
