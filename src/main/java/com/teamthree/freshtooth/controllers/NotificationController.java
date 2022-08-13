package com.teamthree.freshtooth.controllers;

import com.teamthree.freshtooth.dbo.AccountFacade;
import com.teamthree.freshtooth.dbo.NotificationFacade;
import com.teamthree.freshtooth.models.Account;
import com.teamthree.freshtooth.models.Notification;
import com.teamthree.freshtooth.utils.CalculatorTime;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NotificationController extends HttpServlet {
    
    private static final String NOTIFICATION_LIST = "NOTIFICATION_LIST";
    private static final String TIME_NOTIFICATION = "TIME_NOTIFICATION";
    private static final String COUNT_NOTIFICATION_NOT_READ = "COUNT_NOTIFICATION_NOT_READ";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String getUserID = request.getParameter("UserID");

            NotificationFacade notificationFacade = new NotificationFacade();
            AccountFacade accountFacade = new AccountFacade();
            HttpSession session = request.getSession();

            if (!getUserID.equals("")) {
                notificationFacade.updateNotification(getUserID);

                Account account = accountFacade.checkAccount(getUserID, "GetAccountDentist");
                List<Notification> notificationList = notificationFacade.getAllNotification(getUserID);
                
                if (notificationList.isEmpty()) {
                    session.setAttribute(NOTIFICATION_LIST, null);
                } else {
                    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
                    String currentDateString = dateFormatter.format(Calendar.getInstance().getTime());
                    Date currentDate = dateFormatter.parse(currentDateString);
                    String pastTimeInSecond = dateFormatter.format(account.getAccountCreated());
                    Date pastDate = dateFormatter.parse(pastTimeInSecond);
                    int totalNotification = notificationFacade.countNotification(account.getUserID());
                    session.setAttribute(TIME_NOTIFICATION, CalculatorTime.timeAgo(currentDate, pastDate));
                    session.setAttribute(NOTIFICATION_LIST, notificationList);
                    if (totalNotification == 0) {
                        session.setAttribute(COUNT_NOTIFICATION_NOT_READ, null);
                    } else {
                        session.setAttribute(COUNT_NOTIFICATION_NOT_READ, totalNotification);
                    }
                }
            }

        } catch (SQLException | ParseException e) {
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
