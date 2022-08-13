package com.teamthree.freshtooth.controllers;

import com.teamthree.freshtooth.dbo.BookingFacade;
import com.teamthree.freshtooth.dbo.ServiceFacade;
import com.teamthree.freshtooth.dbo.SlotFacade;
import com.teamthree.freshtooth.models.Account;
import com.teamthree.freshtooth.models.Booking;
import com.teamthree.freshtooth.models.BookingError;
import com.teamthree.freshtooth.models.Services;
import com.teamthree.freshtooth.models.Slot;
import com.teamthree.freshtooth.utils.FunctionRandom;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BookingController extends HttpServlet {

    private static final String SERVICE_SELECT = "SERVICE_SELECT";
    private static final String SERVICE = "SERVICE";
    private static final String DATE_BOOKING = "DATE_BOOKING";
    private static final String SLOT_BOOKING = "SLOT_BOOKING";
    private static final String BOOKING_ERROR = "BOOKING_ERROR";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String getService = request.getParameter("Service");
            String getDate = request.getParameter("Date");
            ServiceFacade serviceFacade = new ServiceFacade();
            BookingFacade bookingFacade = new BookingFacade();
            PrintWriter printWriter = response.getWriter();

            if (getService != null && getDate != null) {
                Booking booking = new Booking();
                booking.setServiceID(getService);
                Date convertServiceDate = Date.valueOf(getDate);
                booking.setBookingDate(convertServiceDate);
                booking.setBookingStatus(0);

                List<Booking> bookingList = bookingFacade.getAllBooking(booking, "GetBookingWithService", null);

                if (!bookingList.isEmpty()) {
                    for (Booking sentBooking : bookingList) {
                        printWriter.println(sentBooking.getSlotID());
                    }
                }
            } else {
                List<Services> serviceList = serviceFacade.getServices(null, null, "GetAllService");
//                List<Slot> slotList = slotFacade.getAllSlot();

                if (serviceList.isEmpty()) {
                    request.setAttribute(SERVICE_SELECT, null);
                } else {
                    request.setAttribute(SERVICE_SELECT, serviceList);
                }

//                if (!slotList.isEmpty()) {
//                    System.out.println(slotList.size());
//                    List<Slot> slot1 = new ArrayList<>(slotList.subList(0, 4));
//                    List<Slot> slot2 = new ArrayList<>(slotList.subList(4, 8));
//                    List<Slot> slot3 = new ArrayList<>(slotList.subList(8, 12));
//                    List<Slot> slot4 = new ArrayList<>(slotList.subList(12, 16));
//
//                    request.setAttribute(LIST_SLOT_1, slot1);
//                    request.setAttribute(LIST_SLOT_2, slot2);
//                    request.setAttribute(LIST_SLOT_3, slot3);
//                    request.setAttribute(LIST_SLOT_4, slot4);
//                }

                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/user/Booking.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (IOException | SQLException | ServletException e) {
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        try {
            String getService = request.getParameter("service");
            if (getService == null) {
                getService = "";
            } else {
                getService = request.getParameter("service");
            }
            String getDateOfAppointment = request.getParameter("dateOfAppointment");
            String getSlotBooking = request.getParameter("slotBooking");
            String bookingID = FunctionRandom.randomID(10);

            Booking booking;
            BookingFacade bookingFacade = new BookingFacade();
            BookingError bookingError = new BookingError();
            boolean hasError = false;

            if (getService.equals("") && getDateOfAppointment.equals("") && getSlotBooking == null) {
                hasError = true;
                bookingError.setServiceIDError("Please select service!");
                bookingError.setBookingDateError("Please choose booking date!");
                bookingError.setSlotIDError("Please choose slot booking!");
            } else if (getService.equals("")) {
                hasError = true;
                bookingError.setServiceIDError("Please select service");
            } else if (getDateOfAppointment.equals("")) {
                hasError = true;
                bookingError.setBookingDateError("Please choose booking date");
            } else if (getSlotBooking == null) {
                hasError = true;
                bookingError.setSlotIDError("Please choose slot booking!");
            }

            if (hasError) {
                request.setAttribute(SERVICE, getService);
                request.setAttribute(DATE_BOOKING, getDateOfAppointment);
                request.setAttribute(SLOT_BOOKING, getSlotBooking);
                request.setAttribute(BOOKING_ERROR, bookingError);
                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/user/Booking.jsp");
                requestDispatcher.forward(request, response);
            } else {
                HttpSession session = request.getSession();
                Account getAccount = (Account) session.getAttribute("LOGIN_USER");

                booking = new Booking();
                booking.setBookingID(bookingID);
                booking.setServiceID(getService);
                booking.setPatientID(getAccount.getUserID());
                Date convertBookingDate = Date.valueOf(getDateOfAppointment);
                booking.setBookingDate(convertBookingDate);
                booking.setSlotID(getSlotBooking);
                bookingFacade.addBooking(booking);
                
                response.sendRedirect(request.getContextPath() + "/history-booking-all");
            }
        } catch (IOException | SQLException | ServletException e) {
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
