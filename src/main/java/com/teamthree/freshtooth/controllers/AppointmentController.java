package com.teamthree.freshtooth.controllers;

import com.teamthree.freshtooth.dbo.AccountFacade;
import com.teamthree.freshtooth.dbo.BookingFacade;
import com.teamthree.freshtooth.dbo.DentistFacade;
import com.teamthree.freshtooth.dbo.ServiceFacade;
import com.teamthree.freshtooth.dbo.SlotFacade;
import com.teamthree.freshtooth.models.Account;
import com.teamthree.freshtooth.models.Appointment;
import com.teamthree.freshtooth.models.Booking;
import com.teamthree.freshtooth.models.Dentist;
import com.teamthree.freshtooth.models.Services;
import com.teamthree.freshtooth.models.Slot;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppointmentController extends HttpServlet {

    private static final String APPOINTMENT_LIST = "APPOINTMENT_LIST";
    private static final String TOTAL_APPOINTMENT = "TOTAL_APPOINTMENT";
    private static final SimpleDateFormat SIMPLEDATEFORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat SIMPLETIMEFORMAT = new SimpleDateFormat("HH:mm:ss");
    private static final String SEARCH = "SEARCH";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String getBookingID = request.getParameter("BookingID");
            String getBookingAmount = request.getParameter("BookingAmount");
            String searchValue = request.getParameter("search");
            Appointment appointment;

            BookingFacade bookingFacade = new BookingFacade();
            ServiceFacade serviceFacade = new ServiceFacade();
            AccountFacade accountFacade = new AccountFacade();
            SlotFacade slotFacade = new SlotFacade();
            DentistFacade dentistFacade = new DentistFacade();
            Random randomGenerator = new Random();
            PrintWriter printWriter = response.getWriter();

            List<Appointment> appointmentList = new ArrayList<>();
            List<Booking> bookingList;

            if (getBookingAmount != null) {
                int bookingAmountInt = Integer.parseInt(getBookingAmount);
                bookingList = bookingFacade.getAllBooking(null, "GetPagingBooking", bookingAmountInt);

                if (!bookingList.isEmpty()) {
                    for (int i = 0; i < bookingList.size(); i++) {
                        Services services = serviceFacade.getServicesDetail(bookingList.get(i).getServiceID());
                        Account account = accountFacade.checkAccount(bookingList.get(i).getPatientID(), "GetAccountDentist");
                        Slot slot = slotFacade.getSlot(bookingList.get(i).getSlotID());

                        appointment = new Appointment(bookingList.get(i).getBookingID(), services.getServiceName(), services.getImageService(), account.getFullName(), account.getUserEmail(), account.getUserAddress(), account.getUserPhone(), account.getSex(), null, null, null, account.getDateOfBirth(), bookingList.get(i).getBookingDate(), bookingList.get(i).getBookingStatus(), slot.getSlotStart(), bookingList.get(i).getBookingCreated());
                        appointmentList.add(appointment);
                    }
                }

                returnPrintWriter(appointmentList, printWriter, request);

            } else if (searchValue != null) {
                List<Account> searchNameList = accountFacade.getAccount(searchValue, "SearchAccount", null);
                List<Booking> getValueSearchBooking = new ArrayList<>();

                if (!searchNameList.isEmpty()) {
                    for (int i = 0; i < searchNameList.size(); i++) {
                        getValueSearchBooking.add(bookingFacade.getBooking(searchNameList.get(i).getUserID(), "GetBookingWithPatient"));
                    }
                }

                if (!getValueSearchBooking.isEmpty()) {
                    for (int i = 0; i < getValueSearchBooking.size(); i++) {
                        Services services = serviceFacade.getServicesDetail(getValueSearchBooking.get(i).getServiceID());
                        Account account = accountFacade.checkAccount(getValueSearchBooking.get(i).getPatientID(), "GetAccountDentist");
                        Slot slot = slotFacade.getSlot(getValueSearchBooking.get(i).getSlotID());

                        appointment = new Appointment(getValueSearchBooking.get(i).getBookingID(), services.getServiceName(), services.getImageService(), account.getFullName(), account.getUserEmail(), account.getUserAddress(), account.getUserPhone(), account.getSex(), null, null, null, account.getDateOfBirth(), getValueSearchBooking.get(i).getBookingDate(), getValueSearchBooking.get(i).getBookingStatus(), slot.getSlotStart(), getValueSearchBooking.get(i).getBookingCreated());
                        appointmentList.add(appointment);
                    }
                }
                
                returnPrintWriter(appointmentList, printWriter, request);
            } else if (getBookingID != null) {
                String action = request.getParameter("Action");
                Booking booking = new Booking();
                booking.setBookingID(getBookingID);

                if (action.equals("Accept")) {
                    List<Dentist> dentistList = dentistFacade.getDentist(null, "GetAllDentist");
                    int index = randomGenerator.nextInt(dentistList.size());
                    Dentist dentist = dentistList.get(index);

                    booking.setBookingStatus(1);
                    booking.setDentistID(dentist.getDentistID());
                    bookingFacade.updateBooking(booking, "UpdateStatusInDentist");
                } else if (action.equals("Cancel")) {
                    booking.setBookingStatus(2);
                    bookingFacade.updateBooking(booking, "UpdateStatusInDentistNoDentist");
                } else if (action.equals("Done")) {
                    booking.setBookingStatus(3);
                    bookingFacade.updateBooking(booking, "UpdateStatusInDentistNoDentist");
                }

            } else {
                bookingList = bookingFacade.getAllBooking(null, "GetTop5PagingBooking", null);

                if (!bookingList.isEmpty()) {
                    for (int i = 0; i < bookingList.size(); i++) {
                        Services services = serviceFacade.getServicesDetail(bookingList.get(i).getServiceID());
                        Account account = accountFacade.checkAccount(bookingList.get(i).getPatientID(), "GetAccountDentist");
                        Slot slot = slotFacade.getSlot(bookingList.get(i).getSlotID());

                        appointment = new Appointment(bookingList.get(i).getBookingID(), services.getServiceName(), services.getImageService(), account.getFullName(), account.getUserEmail(), account.getUserAddress(), account.getUserPhone(), account.getSex(), null, null, null, account.getDateOfBirth(), bookingList.get(i).getBookingDate(), bookingList.get(i).getBookingStatus(), slot.getSlotStart(), bookingList.get(i).getBookingCreated());
                        appointmentList.add(appointment);
                    }
                }

                if (appointmentList.isEmpty()) {
                    request.setAttribute(APPOINTMENT_LIST, null);
                } else {
                    Collections.sort(appointmentList, new Comparator<Appointment>() {
                        @Override
                        public int compare(Appointment appointment1, Appointment appointment2) {
                            return appointment1.getBookingStatus() - appointment2.getBookingStatus();
                        }
                    });
                    request.setAttribute(APPOINTMENT_LIST, appointmentList);
                }

                request.setAttribute(TOTAL_APPOINTMENT, bookingFacade.countBooking(null, "GetTotalBooking", null));
                request.setAttribute(SEARCH, SEARCH);

                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/dentist/Appointment.jsp");
                requestDispatcher.forward(request, response);
            }

        } catch (IOException | NumberFormatException | SQLException | ServletException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

    private void returnPrintWriter(List<Appointment> appointmentList, PrintWriter printWriter, HttpServletRequest request) {
        for (Appointment appointment : appointmentList) {
            printWriter.println("<div class=\"col-12 booking-amount\">\n"
                    + "                                <div class=\"card-appointment disFlex my-2 p-4\">\n"
                    + "                                    <div class=\"card-start disFlex\">\n"
                    + "                                        <div class=\"card-left\">\n"
                    + "                                            <div class=\"appointments--avata\">\n"
                    + "                                                <img src=\"data:image/png;base64," + appointment.getImageService() + "\" alt=\"\">\n"
                    + "                                            </div>\n"
                    + "                                        </div>\n"
                    + "\n"
                    + "                                        <div class=\"middle--content\">\n"
                    + "                                            <div class=\"name\">\n"
                    + "                                                <h4>" + appointment.getFullName() + "</h4>\n"
                    + "                                            </div>\n"
                    + "                                            \n"
                    + "                                            <div class=\"info gender\">\n"
                    + "                                                <i class=\"fa-solid fa-transgender\"></i>\n"
                    + "                                                " + returnGender(appointment.getGender()) + ""
                    + "                                            </div>\n"
                    + "\n"
                    + "                                            <div class=\"info dateOfBirth\">\n"
                    + "                                                <i class=\"fa-solid fa-calendar-days\"></i>\n"
                    + "                                                <p>Date Of Birth: " + SIMPLEDATEFORMAT.format(appointment.getDateOfBirth()) + "</p>\n"
                    + "                                            </div>\n"
                    + "\n"
                    + "                                            <div class=\"info phoneNumber\">\n"
                    + "                                                <i class=\"fa-solid fa-mobile-screen\"></i>\n"
                    + "                                                <p>Phone Number: " + appointment.getPhoneNumber() + "</p>\n"
                    + "                                            </div>\n"
                    + "\n"
                    + "                                            <div class=\"info mail\">\n"
                    + "                                                <i class=\"fa-solid fa-envelope\"></i>\n"
                    + "                                                <p>Email: " + appointment.getEmail() + "</p>\n"
                    + "                                            </div>\n"
                    + "\n"
                    + "                                            <div class=\"info address\">\n"
                    + "                                                <i class=\"fa-solid fa-location-dot\"></i>\n"
                    + "                                                <p>Address: " + appointment.getAddress() + "</p>\n"
                    + "                                            </div>\n"
                    + "                                            \n"
                    + "                                            <div class=\"info serviceName\">\n"
                    + "                                                <i class=\"fa-solid fa-wrench\"></i>\n"
                    + "                                                <p>Service Name: " + appointment.getServiceName() + "</p>\n"
                    + "                                            </div>\n"
                    + "                                            \n"
                    + "                                            <div class=\"info bookingDate\">\n"
                    + "                                                <i class=\"fa-solid fa-calendar-days\"></i>\n"
                    + "                                                <p>Booking Date: " + SIMPLEDATEFORMAT.format(appointment.getBookingDate()) + "</p>\n"
                    + "                                            </div>\n"
                    + "                                            \n"
                    + "                                            <div class=\"info slotStart\">\n"
                    + "                                                <i class=\"fa-solid fa-clock\"></i>\n"
                    + "                                                <p>Slot Start: " + SIMPLETIMEFORMAT.format(appointment.getSlotStart()) + "</p>\n"
                    + "                                            </div>\n"
                    + "                                            \n"
                    + "                                            <div class=\"info bookingCreated\">\n"
                    + "                                                <i class=\"fa-solid fa-calendar-days\"></i>\n"
                    + "                                                <p>Booking Created: " + SIMPLEDATEFORMAT.format(appointment.getBookingCreated()) + "</p>\n"
                    + "                                            </div>\n"
                    + "                                        </div>\n"
                    + "                                    </div>\n"
                    + "\n"
                    + "                                    <div class=\"card-right\">\n"
                    + "                                        <div class=\"right--button disFlex\">\n"
                    + "                                            " + returnButton(appointment, request) + ""
                    + "                                        </div>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                            </div>");
        }
    }

    private String returnButton(Appointment appointment, HttpServletRequest request) {
        String template;

        switch (appointment.getBookingStatus()) {
            case 0:
                template = "<button onclick=\"confirmAccept('" + request.getContextPath() + "/dentist/appointment', '" + appointment.getBookingID() + "')\" class=\"info card__button btn--accept\">\n"
                        + "                                                        <i class=\"fa-solid fa-check\"></i>\n"
                        + "                                                        <p>Accept</p>\n"
                        + "                                                    </button>\n"
                        + "\n"
                        + "                                                    <button onclick=\"confirmCancel('" + appointment.getBookingID() + "')\" class=\"info card__button btn--cancel\">\n"
                        + "                                                        <i class=\"fa-solid fa-xmark\"></i>\n"
                        + "                                                        <p>Cancel</p>\n"
                        + "                                                    </button>";
                break;
            case 1:
                template = "<button onclick=\"confirmDone('" + request.getContextPath() + "/dentist/appointment', '" + appointment.getBookingID() + "')\" class=\"info card__button btn--done\">\n"
                        + "                                                        <i class=\"fa-solid fa-circle-check\"></i>\n"
                        + "                                                        <p>Done</p>\n"
                        + "                                                    </button>\n"
                        + "\n"
                        + "                                                    <button onclick=\"confirmCancel('" + appointment.getBookingID() + "')\" class=\"info card__button btn--cancel\">\n"
                        + "                                                        <i class=\"fa-solid fa-xmark\"></i>\n"
                        + "                                                        <p>Cancel</p>\n"
                        + "                                                    </button>";
                break;
            case 2:
                template = "<button class=\"info card__button btn--cancel\" disabled>\n"
                        + "                                                        <i class=\"fa-solid fa-xmark\"></i>\n"
                        + "                                                        <p>Cancel</p>\n"
                        + "                                                    </button>";
                break;
            default:
                template = "<button class=\"info card__comple btn--completed\" disabled>\n"
                        + "                                                        <i class=\"fa-solid fa-circle-check\"></i>\n"
                        + "                                                        <p>Completed</p>\n"
                        + "                                                    </button>";
                break;
        }

        return template;
    }

    private String returnGender(String bookingGender) {
        String template;

        if (bookingGender.equals("M")) {
            template = "<p>Gender: Male</p>";
        } else {
            template = "<p>Gender: FeMale</p>";
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
