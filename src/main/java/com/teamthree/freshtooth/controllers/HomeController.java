package com.teamthree.freshtooth.controllers;

import com.teamthree.freshtooth.dbo.AccountFacade;
import com.teamthree.freshtooth.dbo.DentistFacade;
import com.teamthree.freshtooth.dbo.ServiceTypeFacade;
import com.teamthree.freshtooth.dbo.ViewerFacade;
import com.teamthree.freshtooth.models.Account;
import com.teamthree.freshtooth.models.Dentist;
import com.teamthree.freshtooth.models.ServiceType;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
public class HomeController extends HttpServlet {

    private static final String SERVICE_TYPE_LIST = "SERVICE_TYPE_LIST";
    private static final String DENTIST_LIST = "DENTIST_LIST";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            HttpSession session = request.getSession();
            ViewerFacade viewerFacade = new ViewerFacade();
            ServiceTypeFacade serviceTypeFacade = new ServiceTypeFacade();
            DentistFacade dentistFacade = new DentistFacade();
            AccountFacade accountFacade = new AccountFacade();

            List<ServiceType> serviceTypeList = serviceTypeFacade.getAllServiceType("0", "GetAllServiceType");
            List<Dentist> dentistList = dentistFacade.getDentist(null, "ShowTop4Dentist");
            Map<Account, Dentist> listAccountDentist = new Hashtable<>();

            if (serviceTypeList.isEmpty()) {
                session.setAttribute(SERVICE_TYPE_LIST, null);
            } else {
                session.setAttribute(SERVICE_TYPE_LIST, serviceTypeList);
            }

            if (!dentistList.isEmpty()) {
                for (int i = 0; i < dentistList.size(); i++) {
                    listAccountDentist.put(accountFacade.checkAccount(dentistList.get(i).getDentistID(), "GetAccountDentist"), dentistList.get(i));
                }
            }
            
            request.setAttribute(DENTIST_LIST, listAccountDentist);

            if (session.isNew()) {
                viewerFacade.updateViewer();
            }

            RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/user/Home.jsp");
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
