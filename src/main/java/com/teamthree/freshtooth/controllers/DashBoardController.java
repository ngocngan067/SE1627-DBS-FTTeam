package com.teamthree.freshtooth.controllers;

import com.teamthree.freshtooth.dbo.AccountFacade;
import com.teamthree.freshtooth.dbo.FeedBackFacade;
import com.teamthree.freshtooth.dbo.ViewerFacade;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DashBoardController extends HttpServlet {

    private static final String TOTAL_USER = "TOTAL_USER";
    private static final String STATISTIC_ACCOUNT = "STATISTIC_ACCOUNT";
    private static final String TOTAL_VIEWER = "TOTAL_VIEWER";
    private static final String TOTAL_FEEDBACK = "TOTAL_FEEDBACK";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            AccountFacade accountFacade = new AccountFacade();
            ViewerFacade viewerFacade = new ViewerFacade();
            FeedBackFacade feedBackFacade = new FeedBackFacade();

            int countUser = accountFacade.countAccount("0");

            Date date = new Date();

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            simpleDateFormat.applyPattern("yyyy");
            String format = simpleDateFormat.format(date);

            List<Integer> statisticAccountList = accountFacade.statisticAccount(format);
            
            request.setAttribute(STATISTIC_ACCOUNT, statisticAccountList);
            request.setAttribute(TOTAL_USER, countUser);
            request.setAttribute(TOTAL_VIEWER, viewerFacade.getViewer());
            request.setAttribute(TOTAL_FEEDBACK, feedBackFacade.countFeedBack());

            RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/Dashboard.jsp");
            requestDispatcher.forward(request, response);
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
