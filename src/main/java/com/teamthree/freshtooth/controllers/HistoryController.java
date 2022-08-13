package com.teamthree.freshtooth.controllers;

import com.teamthree.freshtooth.dbo.AccountFacade;
import com.teamthree.freshtooth.dbo.BookingFacade;
import com.teamthree.freshtooth.dbo.FeedBackFacade;
import com.teamthree.freshtooth.dbo.ServiceFacade;
import com.teamthree.freshtooth.dbo.SlotFacade;
import com.teamthree.freshtooth.models.Account;
import com.teamthree.freshtooth.models.Booking;
import com.teamthree.freshtooth.models.FeedBack;
import com.teamthree.freshtooth.models.HistoryBooking;
import com.teamthree.freshtooth.models.Services;
import com.teamthree.freshtooth.models.Slot;
import com.teamthree.freshtooth.utils.FunctionRandom;
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
import javax.servlet.http.HttpSession;

public class HistoryController extends HttpServlet {

    private static final String BOOKING_LIST = "BOOKING_LIST";
    private static final String TOTAL_BOOKING_LIST = "TOTAL_BOOKING_LIST";
    private static final String COUNT_ALL_BOOKING = "COUNT_ALL_BOOKING";
    private static final String COUNT_PROCESS_BOOKING = "COUNT_PROCESS_BOOKING";
    private static final String COUNT_COMPLETED_BOOKING = "COUNT_COMPLETED_BOOKING";
    private static final String COUNT_CONFIRMED_BOOKING = "COUNT_CONFIRMED_BOOKING";
    private static final String COUNT_CANCEL_BOOKING = "COUNT_CANCEL_BOOKING";
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static final String FEEDBACK = "FEEDBACK";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String urlServlet = request.getServletPath();

            HttpSession session = request.getSession();
            Account getAccount = (Account) session.getAttribute("LOGIN_USER");
            BookingFacade bookingFacade = new BookingFacade();
            ServiceFacade serviceFacade = new ServiceFacade();
            AccountFacade accountFacade = new AccountFacade();
            FeedBackFacade feedBackFacade = new FeedBackFacade();
            SlotFacade slotFacade = new SlotFacade();
            PrintWriter printWriter = response.getWriter();

            List<Booking> bookingList;
            List<HistoryBooking> historyBookingList = new ArrayList<>();
            HistoryBooking historyBooking;
            Booking booking = new Booking();

            booking.setPatientID(getAccount.getUserID());

            if (urlServlet.equals("/history-booking-all")) {
                String bookingAmount = request.getParameter("BookingAmount");

                String getBookingID = request.getParameter("BookingID");
                String getPatientID = request.getParameter("PatientID");

                if (bookingAmount != null) {
                    int bookingAmountInt = Integer.parseInt(bookingAmount);
                    bookingList = bookingFacade.getAllBooking(booking, "GetNext5BookingWithUserId", bookingAmountInt);

                    for (int i = 0; i < bookingList.size(); i++) {
                        Services services = serviceFacade.getServicesDetail(bookingList.get(i).getServiceID());
                        Account account = accountFacade.checkAccount(bookingList.get(i).getPatientID(), "GetAccountDentist");
                        Slot timSlot = slotFacade.getSlot(bookingList.get(i).getSlotID());

                        historyBooking = new HistoryBooking(bookingList.get(i).getBookingID(), account.getUserID(), services.getImageService(), services.getServiceName(), account.getFullName(), account.getUserPhone(), account.getUserAddress(), bookingList.get(i).getBookingNote(), bookingList.get(i).getBookingStatus(), bookingList.get(i).getBookingDate(), timSlot.getSlotStart());
                        historyBookingList.add(historyBooking);
                    }

                    returnPrintWriter(historyBookingList, printWriter, request);
                } else if (getBookingID != null && getPatientID != null) {
                    booking.setBookingID(getBookingID);
                    booking.setPatientID(getPatientID);
                    booking.setBookingStatus(2);
                    bookingFacade.updateBooking(booking, "UpdateStatusInUser");
                } else {
                    bookingList = bookingFacade.getAllBooking(booking, "GetTop5BookingWithUserId", null);

                    if (!bookingList.isEmpty()) {
                        for (int i = 0; i < bookingList.size(); i++) {
                            Services services = serviceFacade.getServicesDetail(bookingList.get(i).getServiceID());
                            Account account = accountFacade.checkAccount(bookingList.get(i).getPatientID(), "GetAccountDentist");
                            Slot timSlot = slotFacade.getSlot(bookingList.get(i).getSlotID());

                            historyBooking = new HistoryBooking(bookingList.get(i).getBookingID(), account.getUserID(), services.getImageService(), services.getServiceName(), account.getFullName(), account.getUserPhone(), account.getUserAddress(), bookingList.get(i).getBookingNote(), bookingList.get(i).getBookingStatus(), bookingList.get(i).getBookingDate(), timSlot.getSlotStart());
                            historyBookingList.add(historyBooking);
                        }

                        request.setAttribute(BOOKING_LIST, historyBookingList);
                    } else {
                        request.setAttribute(BOOKING_LIST, null);
                    }

                    request.setAttribute(COUNT_ALL_BOOKING, bookingFacade.countBooking(null, "GetAllBookingWithID", booking.getPatientID()));
                    request.setAttribute(COUNT_PROCESS_BOOKING, bookingFacade.countBooking("0", "GetTotalBookingWithStatus", booking.getPatientID()));
                    request.setAttribute(COUNT_CONFIRMED_BOOKING, bookingFacade.countBooking("1", "GetTotalBookingWithStatus", booking.getPatientID()));
                    request.setAttribute(COUNT_CANCEL_BOOKING, bookingFacade.countBooking("2", "GetTotalBookingWithStatus", booking.getPatientID()));
                    request.setAttribute(COUNT_COMPLETED_BOOKING, bookingFacade.countBooking("3", "GetTotalBookingWithStatus", booking.getPatientID()));
                    request.setAttribute(TOTAL_BOOKING_LIST, bookingFacade.countBooking(null, "GetAllBookingWithID", booking.getPatientID()));
                    RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/user/HistoryAll.jsp");
                    requestDispatcher.forward(request, response);
                }
            } else {
                switch (urlServlet) {
                    case "/history-booking":
                        booking.setBookingStatus(0);
                        break;
                    case "/history-booking-confirmed":
                        booking.setBookingStatus(1);
                        break;
                    case "/history-booking-cancelled":
                        booking.setBookingStatus(2);
                        break;
                    case "/history-booking-completed":
                        String getServiceID = request.getParameter("ServiceID");
                        String getUserID = request.getParameter("UserID");
                        String getValueRate = request.getParameter("ValueRate");
                        String getFeedbackContent = request.getParameter("FeedbackContent");

                        if (getServiceID != null && getUserID != null && getValueRate != null && getFeedbackContent != null) {
                            String feedbackID = FunctionRandom.randomID(10);

                            FeedBack feedBack = new FeedBack();

                            feedBack.setFeedBackID(feedbackID);
                            feedBack.setBookID(getServiceID);
                            feedBack.setPatientID(getUserID);
                            feedBack.setFeedBackContent(getFeedbackContent);
                            feedBack.setNumberRating(Integer.parseInt(getValueRate));

                            feedBackFacade.addFeedBack(feedBack);
                            request.getSession().removeAttribute(FEEDBACK);
                        } else {
                            booking.setBookingStatus(3);
                        }
                        break;
                }

                String bookingAmount = request.getParameter("BookingAmount");
                String getBookingID = request.getParameter("BookingID");
                String getPatientID = request.getParameter("PatientID");

                if (bookingAmount != null) {
                    int bookingAmountInt = Integer.parseInt(bookingAmount);
                    bookingList = bookingFacade.getAllBooking(booking, "GetNext5BookingWithStatus", bookingAmountInt);

                    for (int i = 0; i < bookingList.size(); i++) {
                        Services services = serviceFacade.getServicesDetail(bookingList.get(i).getServiceID());
                        Account account = accountFacade.checkAccount(bookingList.get(i).getPatientID(), "GetAccountDentist");
                        Slot timSlot = slotFacade.getSlot(bookingList.get(i).getSlotID());

                        historyBooking = new HistoryBooking(bookingList.get(i).getBookingID(), account.getUserID(), services.getImageService(), services.getServiceName(), account.getFullName(), account.getUserPhone(), account.getUserAddress(), bookingList.get(i).getBookingNote(), bookingList.get(i).getBookingStatus(), bookingList.get(i).getBookingDate(), timSlot.getSlotStart());
                        historyBookingList.add(historyBooking);
                    }

                    returnPrintWriter(historyBookingList, printWriter, request);
                } else if (getBookingID != null && getPatientID != null) {
                    booking.setBookingID(getBookingID);
                    booking.setPatientID(getPatientID);
                    bookingFacade.updateBooking(booking, "UpdateStatusInUser");
                } else {
                    bookingList = bookingFacade.getAllBooking(booking, "GetTop5BookingWithStatus", null);

                    for (int i = 0; i < bookingList.size(); i++) {
                        Services services = serviceFacade.getServicesDetail(bookingList.get(i).getServiceID());
                        Account account = accountFacade.checkAccount(bookingList.get(i).getPatientID(), "GetAccountDentist");
                        Slot timSlot = slotFacade.getSlot(bookingList.get(i).getSlotID());

                        if (bookingList.get(i).getBookingStatus() == 3) {
                            if (feedBackFacade.getFeedBack(bookingList.get(i).getBookingID(), bookingList.get(i).getPatientID()) == null) {
                                request.setAttribute(FEEDBACK, bookingList.get(i).getBookingID());
                            }
                        }

                        historyBooking = new HistoryBooking(bookingList.get(i).getBookingID(), account.getUserID(), services.getImageService(), services.getServiceName(), account.getFullName(), account.getUserPhone(), account.getUserAddress(), bookingList.get(i).getBookingNote(), bookingList.get(i).getBookingStatus(), bookingList.get(i).getBookingDate(), timSlot.getSlotStart());
                        historyBookingList.add(historyBooking);
                    }

                    request.setAttribute(COUNT_ALL_BOOKING, bookingFacade.countBooking(null, "GetAllBookingWithID", booking.getPatientID()));
                    request.setAttribute(COUNT_PROCESS_BOOKING, bookingFacade.countBooking("0", "GetTotalBookingWithStatus", booking.getPatientID()));
                    request.setAttribute(COUNT_CONFIRMED_BOOKING, bookingFacade.countBooking("1", "GetTotalBookingWithStatus", booking.getPatientID()));
                    request.setAttribute(COUNT_CANCEL_BOOKING, bookingFacade.countBooking("2", "GetTotalBookingWithStatus", booking.getPatientID()));
                    request.setAttribute(COUNT_COMPLETED_BOOKING, bookingFacade.countBooking("3", "GetTotalBookingWithStatus", booking.getPatientID()));
                    request.setAttribute(TOTAL_BOOKING_LIST, bookingFacade.countBooking(booking.getBookingStatus(), "GetTotalBookingWithStatus", booking.getPatientID()));

                    if (historyBookingList.isEmpty()) {
                        request.setAttribute(BOOKING_LIST, null);
                    } else {
                        request.setAttribute(BOOKING_LIST, historyBookingList);
                    }

                    RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/user/HistoryAll.jsp");
                    requestDispatcher.forward(request, response);
                }
            }
        } catch (IOException | NumberFormatException | SQLException | ServletException e) {
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

    private void returnPrintWriter(List<HistoryBooking> historyBookingList, PrintWriter printWriter, HttpServletRequest request) {
        for (HistoryBooking historyBooking : historyBookingList) {
            printWriter.println("<div class=\"col-12 my-2 booking-amount\">\n"
                    + "                                <div class=\"card-booking\">\n"
                    + "                                    <div class=\"booking--top\">\n"
                    + "                                        <div class=\"booking--id ps-2\">\n"
                    + "                                            <p>Appointment code: <span class=\"id\">" + historyBooking.getBookingID() + "</span></p>\n"
                    + "                                            <p>|</p>\n"
                    + "                                            <p>Booking date: <span>" + simpleDateFormat.format(historyBooking.getBookingDate()) + "</span></p>\n"
                    + "                                        </div>\n"
                    + "                                        " + returnButton(historyBooking, request) + "\n"
                    + "                                    </div>\n"
                    + "\n"
                    + "                                    <div class=\"booking--bottom p-3\">\n"
                    + "                                        <div class=\"bottom-img\">\n"
                    + "                                            <div class=\"booking--img\">\n"
                    + "                                                <img src=\"data:image/png;base64," + historyBooking.getImageService() + "\" alt=\"" + historyBooking.getServiceName() + "\">\n"
                    + "                                            </div>\n"
                    + "                                        </div>\n"
                    + "                                        <div class=\"bottom-content\">\n"
                    + "                                            <p>Name: <span class=\"name-booking\">" + historyBooking.getFullName() + "</span></p>\n"
                    + "                                            <p>Phone: <span class=\"phone\">" + historyBooking.getUserPhone() + "</span></p>\n"
                    + "                                            <p>Address: <span class=\"address\">" + historyBooking.getUserAddress() + "</span></p>\n"
                    + "                                            <p>\n"
                    + "                                                Service: <span class=\"service\">" + historyBooking.getServiceName() + "</span>\n"
                    + "                                            </p>\n"
                    + "                                        </div>\n"
                    + "                                    </div>\n"
                    + "                                            \n"
                    + "                                    " + returnStatus(historyBooking.getBookingStatus()) + "\n"
                    + "                                </div>\n"
                    + "                            </div>");
        }
    }

    private String returnStatus(int bookingStatus) {
        String template = "";

        switch (bookingStatus) {
            case 0:
                template = "<div class=\"status pending\">\n"
                        + "                                                <p>Pending</p>\n"
                        + "                                            </div>";
                break;
            case 1:
                template = "<div class=\"status confirm\">\n"
                        + "                                                <p>Confirm</p>\n"
                        + "                                            </div>";
                break;
            case 2:
                template = "<div class=\"status cancelled\">\n"
                        + "                                                <p>Cancelled</p>\n"
                        + "                                            </div>";
                break;
        }

        return template;
    }

    private String returnButton(HistoryBooking historyBooking, HttpServletRequest request) {
        String template = "";

        if (historyBooking.getBookingStatus() == 0) {
            template = "<button class=\"btn-delete\" onclick=\"confirmDelete('" + request.getContextPath() + "/history-booking-all', '" + historyBooking.getBookingID() + "', '" + historyBooking.getPatientID() + "')\">\n"
                    + "                                                <i class=\"fa-solid fa-xmark\"></i>\n"
                    + "                                            </button>";
        }

        return template;
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
