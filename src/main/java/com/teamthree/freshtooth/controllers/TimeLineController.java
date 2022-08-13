package com.teamthree.freshtooth.controllers;

import com.teamthree.freshtooth.dbo.AccountFacade;
import com.teamthree.freshtooth.dbo.BookingFacade;
import com.teamthree.freshtooth.dbo.ServiceFacade;
import com.teamthree.freshtooth.dbo.SlotFacade;
import com.teamthree.freshtooth.models.Account;
import com.teamthree.freshtooth.models.Appointment;
import com.teamthree.freshtooth.models.Booking;
import com.teamthree.freshtooth.models.Services;
import com.teamthree.freshtooth.models.Slot;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

public class TimeLineController extends HttpServlet {

    private static final String TIME_LINE = "TIME_LINE";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            Appointment appointment;

            BookingFacade bookingFacade = new BookingFacade();
            ServiceFacade serviceFacade = new ServiceFacade();
            AccountFacade accountFacade = new AccountFacade();
            SlotFacade slotFacade = new SlotFacade();

            List<Appointment> appointmentList = new ArrayList<>();
            List<Booking> bookingList = bookingFacade.getAllBooking(null, "GetAllBooking", null);

            if (!bookingList.isEmpty()) {
                for (int i = 0; i < bookingList.size(); i++) {
                    Services services = serviceFacade.getServicesDetail(bookingList.get(i).getServiceID());
                    Account account = accountFacade.checkAccount(bookingList.get(i).getPatientID(), "GetAccountDentist");
                    Slot slot = slotFacade.getSlot(bookingList.get(i).getSlotID());
                    
                    if (bookingList.get(i).getDentistID() == null) {
                        appointment = new Appointment(bookingList.get(i).getBookingID(), services.getServiceName(), services.getImageService(), account.getFullName(), account.getUserEmail(), account.getUserAddress(), account.getUserPhone(), account.getSex(), null, bookingList.get(i).getBookingNote(), bookingList.get(i).getSlotID(), account.getDateOfBirth(), bookingList.get(i).getBookingDate(), bookingList.get(i).getBookingStatus(), slot.getSlotStart(), bookingList.get(i).getBookingCreated());
                    } else {
                        Account getAccountDentist = accountFacade.checkAccount(bookingList.get(i).getDentistID(), "GetAccountDentist");
                        appointment = new Appointment(bookingList.get(i).getBookingID(), services.getServiceName(), services.getImageService(), account.getFullName(), account.getUserEmail(), account.getUserAddress(), account.getUserPhone(), account.getSex(), getAccountDentist.getFullName(), bookingList.get(i).getBookingNote(), bookingList.get(i).getSlotID(), account.getDateOfBirth(), bookingList.get(i).getBookingDate(), bookingList.get(i).getBookingStatus(), slot.getSlotStart(), bookingList.get(i).getBookingCreated());
                    }
                    
                    appointmentList.add(appointment);
                }
            }

            if (appointmentList.isEmpty()) {
                request.setAttribute(TIME_LINE, null);
            } else {
                JSONArray jsArray = new JSONArray(appointmentList);
                request.setAttribute(TIME_LINE, jsArray.toString());
            }

            RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/dentist/TimeLine.jsp");
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
