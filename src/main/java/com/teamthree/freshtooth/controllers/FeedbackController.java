package com.teamthree.freshtooth.controllers;

import com.teamthree.freshtooth.dbo.AccountFacade;
import com.teamthree.freshtooth.dbo.BookingFacade;
import com.teamthree.freshtooth.dbo.FeedBackFacade;
import com.teamthree.freshtooth.dbo.ServiceFacade;
import com.teamthree.freshtooth.models.Account;
import com.teamthree.freshtooth.models.Booking;
import com.teamthree.freshtooth.models.FeedBack;
import com.teamthree.freshtooth.models.FeedBackInfo;
import com.teamthree.freshtooth.models.Services;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FeedbackController extends HttpServlet {

    private static final String FEEDBACK_LIST = "FEEDBACK_LIST";
    private static final String NOT_EMPTY = "NOT_EMPTY";
    private static final String TOTAL_FEEDBACK = "TOTAL_FEEDBACK";
    private static final SimpleDateFormat SIMPLEDATEFORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat SIMPLEDATETIMEFORMAT = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

    private void returnPrintWriter(List<FeedBackInfo> feedBackInfoList, PrintWriter printWriter) {
        for (FeedBackInfo feedBackInfo : feedBackInfoList) {
            printWriter.println("<div class=\"col-12 my-2 feedback-amount\">\n"
                    + "                                <div onclick=\"ViewInformation('"+ feedBackInfo.getFullName() +"', '"+ feedBackInfo.getGender() +"', '"+ SIMPLEDATEFORMAT.format(feedBackInfo.getDateOfBirth()) +"', '"+ feedBackInfo.getPhoneNumber() +"', '"+ feedBackInfo.getEmail() +"', '"+ feedBackInfo.getAddress() +"', '"+ feedBackInfo.getServiceName() +"', '"+ feedBackInfo.getDentistName() +"', '"+ feedBackInfo.getFeedBackContent() +"')\" class=\"card-feedback\">\n"
                    + "                                    <div class=\"feedback--top\">\n"
                    + "                                        <div class=\"feedback--id ps-2\">\n"
                    + "                                            <p>FeedBack code: <span class=\"id\">"+ feedBackInfo.getFeedBackID() +"</span></p>\n"
                    + "                                            <p>|</p>\n"
                    + "                                            <p>FeedBack date: <span>"+ SIMPLEDATETIMEFORMAT.format(feedBackInfo.getFeedBackCreated()) +"</span></p>\n"
                    + "                                        </div>\n"
                    + "\n"
                    + "                                        <button onclick=\"ViewInformation('"+ feedBackInfo.getFullName() +"', '"+ feedBackInfo.getGender() +"', '"+ SIMPLEDATEFORMAT.format(feedBackInfo.getDateOfBirth()) +"', '"+ feedBackInfo.getPhoneNumber() +"', '"+ feedBackInfo.getEmail() +"', '"+ feedBackInfo.getAddress() +"', '"+ feedBackInfo.getServiceName() +"', '"+ feedBackInfo.getDentistName() +"', '"+ feedBackInfo.getFeedBackContent() +"')\" class=\"btn-eye\">\n"
                    + "                                            <i class=\"fa-solid fa-eye\"></i>\n"
                    + "                                        </button>\n"
                    + "                                    </div>\n"
                    + "\n"
                    + "                                    <div class=\"feedback--bottom p-3\">\n"
                    + "                                        <div class=\"bottom-img\">\n"
                    + "                                            <div class=\"feedback--imgUser\" style=\"background-color: "+ returnTemplateColor(feedBackInfo) +";\">\n"
                    + "                                                "+ returnTemplateAvatar(feedBackInfo) +"\n"
                    + "                                            </div>\n"
                    + "                                        </div>\n"
                    + "                                        <div class=\"bottom-content\">\n"
                    + "                                            <p>Name: <span class=\"name-feedback\">"+ feedBackInfo.getFullName() +"</span></p>\n"
                    + "                                            <p>Phone: <span class=\"phone\">"+ feedBackInfo.getPhoneNumber() +"</span></p>\n"
                    + "                                            <p>\n"
                    + "                                                Service: <span class=\"service\">"+ feedBackInfo.getServiceName() +"</span>\n"
                    + "                                            </p>\n"
                    + "                                            <p>Doctor: <span>"+ feedBackInfo.getDentistName() +"</span></p>\n"
                    + "                                            <div class=\"reviewStart d-flex d-md-none\">\n"
                    + "                                                <p>Service review:</p>\n"
                    + "                                                <div class=\"review pending\">\n"
                    + "                                                    <div class=\"content\">\n"
                    + "                                                        <div class=\"stars\">"+ returnTemplateRating(feedBackInfo.getNumberRating()) +"</div>\n"
                    + "                                                    </div>\n"
                    + "                                                </div>\n"
                    + "                                            </div>\n"
                    + "                                        </div>\n"
                    + "                                    </div>\n"
                    + "\n"
                    + "                                    <div class=\"d-none d-md-flex status pending\">\n"
                    + "                                        <div class=\"content\">\n"
                    + "                                            <div class=\"stars\">"+ returnTemplateRating(feedBackInfo.getNumberRating()) +"</div>\n"
                    + "                                        </div>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                            </div>");
        }
    }

    private String returnTemplateRating(int lengthList) {
        String template = "";

        for (int i = 0; i < lengthList; i++) {
            template = "<label for=\"star-" + (i + 1) + "\" class=\"star-" + (i + 1) + " fas fa-star\"></label>";
        }

        return template;
    }
    
    private String returnTemplateAvatar(FeedBackInfo feedBackInfo) {
        String template;
        
        if (feedBackInfo.getImageAvatar() != null) {
            template = "<img src=\"data:image/png;base64,"+ feedBackInfo.getImageAvatar() +"\" alt=\"\">";
        } else {
            template = "<p>"+ feedBackInfo.getDefaultAvatar() +"</p>";
        }
        
        return template;
    }
    
    private String returnTemplateColor(FeedBackInfo feedBackInfo) {
        String color;
        
        if (feedBackInfo.getImageAvatar() != null) {
            color = feedBackInfo.getColorAvatar();
        } else {
            color = "transparent";
        }
        
        return color;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String feedBackAmount = request.getParameter("serviceExits");

            PrintWriter printWriter = response.getWriter();
            FeedBackFacade feedBackFacade = new FeedBackFacade();
            ServiceFacade serviceFacade = new ServiceFacade();
            AccountFacade accountFacade = new AccountFacade();
            BookingFacade bookingFacade = new BookingFacade();

            List<FeedBack> feedBackList;
            List<FeedBackInfo> feedBackInfoList = new ArrayList<>();

            if (feedBackAmount != null) {
                int feedBackAmountInt = Integer.parseInt(feedBackAmount);

                feedBackList = feedBackFacade.getAllFeedBack(feedBackAmountInt, "GetNext5FeedBack");

                if (!feedBackList.isEmpty()) {
                    for (FeedBack feedBack : feedBackList) {
                        Booking booking = bookingFacade.getBooking(feedBack.getBookID(), "GetBookingID");
                        Services services = serviceFacade.getServicesDetail(booking.getServiceID());
                        Account account = accountFacade.checkAccount(feedBack.getPatientID(), "GetAccountDentist");
                        Account dentistAccount = accountFacade.checkAccount(booking.getDentistID(), "GetAccountDentist");

                        FeedBackInfo feedBackInfo = new FeedBackInfo(feedBack.getFeedBackID(), feedBack.getFeedBackContent(), services.getServiceName(), dentistAccount.getFullName(), account.getImageAvatar(), account.getFullName(), account.getSex(), account.getUserPhone(), account.getUserEmail(), account.getUserAddress(), account.getColorAvatar(), account.getDefaultAvatar(), account.getDateOfBirth(), feedBack.getNumberRating(), feedBack.getFeedBackCreated());
                        feedBackInfoList.add(feedBackInfo);
                    }
                    returnPrintWriter(feedBackInfoList, printWriter);
                }

            } else {
                feedBackList = feedBackFacade.getAllFeedBack(null, "GetTop5FeedBack");

                if (!feedBackList.isEmpty()) {
                    for (FeedBack feedBack : feedBackList) {
                        Booking booking = bookingFacade.getBooking(feedBack.getBookID(), "GetBookingID");
                        Services services = serviceFacade.getServicesDetail(booking.getServiceID());
                        Account account = accountFacade.checkAccount(feedBack.getPatientID(), "GetAccountDentist");
                        Account dentistAccount = accountFacade.checkAccount(booking.getDentistID(), "GetAccountDentist");

                        FeedBackInfo feedBackInfo = new FeedBackInfo(feedBack.getFeedBackID(), feedBack.getFeedBackContent(), services.getServiceName(), dentistAccount.getFullName(), account.getImageAvatar(), account.getFullName(), account.getSex(), account.getUserPhone(), account.getUserEmail(), account.getUserAddress(), account.getColorAvatar(), account.getDefaultAvatar(), account.getDateOfBirth(), feedBack.getNumberRating(), feedBack.getFeedBackCreated());
                        feedBackInfoList.add(feedBackInfo);
                    }

                    if (feedBackInfoList.isEmpty()) {
                        request.setAttribute(FEEDBACK_LIST, null);
                    } else {
                        request.setAttribute(FEEDBACK_LIST, feedBackInfoList);
                    }
                }

                request.setAttribute(TOTAL_FEEDBACK, feedBackFacade.countFeedBack());
                request.setAttribute(NOT_EMPTY, NOT_EMPTY);

                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/dentist/Feedback.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (IOException | NumberFormatException | SQLException | ServletException e) {
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
