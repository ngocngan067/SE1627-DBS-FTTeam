package com.teamthree.freshtooth.controllers;

import com.teamthree.freshtooth.dbo.ServiceTypeFacade;
import com.teamthree.freshtooth.models.ServiceType;
import com.teamthree.freshtooth.models.ServiceTypeError;
import com.teamthree.freshtooth.utils.FunctionRandom;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

public class ServiceTypeManagementController extends HttpServlet {

    private static final String SERVICE_TYPE_LIST = "SERVICE_TYPE_LIST";
    private static final String END_PAGE = "END_PAGE";
    private static final String CURRENT_PAGE = "CURRENT_PAGE";
    private static final String SERVICE_TYPE_ERROR = "DENTIST_ACCOUNT_ERROR";
    private static final String BUTTON_ACTION = "BUTTON_ACTION";
    private static final String NAME_SERVICE_TYPE = "NAME_SERVICE_TYPE";
    private static final String ACTION_URL = "ACTION_URL";
    private static final String MENU_BAR = "MENU_BAR";
    private static final String MENU_BAR_ICON = "MENU_BAR_ICON";
    private static final String SEARCH = "SEARCH";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String urlServlet = request.getServletPath();

            ServiceTypeFacade serviceTypeFacade = new ServiceTypeFacade();
            List<ServiceType> serviceTypeList;

            if (urlServlet.equals("/admin/add-service-type")) {
                request.setAttribute(MENU_BAR, MENU_BAR);
                request.setAttribute(MENU_BAR_ICON, "<i class=\"fa-solid fa-plus icon\"></i>");
                request.setAttribute(BUTTON_ACTION, "Add Service Type");
                request.setAttribute(ACTION_URL, "" + request.getContextPath() + "/admin/add-service-type");

                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/AddServiceType.jsp");
                requestDispatcher.forward(request, response);
            } else if (urlServlet.equals("/admin/edit-service-type")) {
                String serviceTypeID = request.getParameter("stid");

                ServiceType serviceType = serviceTypeFacade.getServiceType(serviceTypeID);

                request.setAttribute(NAME_SERVICE_TYPE, serviceType.getServiceTypeName());
                request.setAttribute(MENU_BAR, MENU_BAR);
                request.setAttribute(MENU_BAR_ICON, "<i class=\"fa-solid fa-pen-to-square icon\"></i>");
                request.setAttribute(BUTTON_ACTION, "Edit Service Type");
                request.setAttribute(ACTION_URL, "" + request.getContextPath() + "/admin/edit-service-type?stid=" + serviceTypeID + "");

                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/AddServiceType.jsp");
                requestDispatcher.forward(request, response);
            } else {
                String indexPage = request.getParameter("page");
                String getServiceTypeID = request.getParameter("ServiceTypeID");

                if (indexPage == null) {
                    indexPage = "1";
                }
                int index = Integer.parseInt(indexPage);

                if (getServiceTypeID != null) {
                    String actionButton = request.getParameter("Action");
                    ServiceType serviceType = new ServiceType();
                    serviceType.setServiceTypeID(getServiceTypeID);

                    if (actionButton.equals("Disable")) {
                        serviceType.setServiceTypeStatus(1);
                    } else {
                        serviceType.setServiceTypeStatus(0);
                    }

                    serviceTypeFacade.updateServiceType(serviceType, "UpdateServiceTypeStatus");
                } else {
                    int countServiceType = serviceTypeFacade.countServiceType();
                    int endPage = countServiceType / 5;
                    if (countServiceType % 5 != 0) {
                        endPage++;
                    }

                    serviceTypeList = serviceTypeFacade.getAllServiceType(index, "PagingServiceType");

                    if (serviceTypeList.isEmpty()) {
                        request.setAttribute(SERVICE_TYPE_LIST, null);
                    } else {
                        JSONArray jsArray = new JSONArray(serviceTypeList);
                        request.setAttribute(SERVICE_TYPE_LIST, jsArray.toString());
                    }

                    request.setAttribute(END_PAGE, endPage);
                    request.setAttribute(CURRENT_PAGE, index);
                    request.setAttribute(SEARCH, "serviceTypeName");

                    RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/ServiceTypeManagement.jsp");
                    requestDispatcher.forward(request, response);
                }
            }
        } catch (IOException | NumberFormatException | SQLException | ServletException e) {
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        try {
            String urlServlet = request.getServletPath();

            ServiceType serviceType;
            ServiceTypeFacade serviceTypeFacade = new ServiceTypeFacade();

            if (urlServlet.equals("/admin/add-service-type")) {
                String serviceTypeID = FunctionRandom.randomID(10);
                String getServiceTypeName = request.getParameter("serviceTypeName");

                ServiceTypeError serviceTypeError = new ServiceTypeError();
                boolean hasError = false;

                if (getServiceTypeName.equals("")) {
                    hasError = true;
                    serviceTypeError.setServiceTypeName("Please enter service type name");
                }

                if (hasError) {
                    request.setAttribute(NAME_SERVICE_TYPE, getServiceTypeName);
                    request.setAttribute(SERVICE_TYPE_ERROR, serviceTypeError);
                    request.setAttribute(MENU_BAR, MENU_BAR);
                    request.setAttribute(MENU_BAR_ICON, "<i class=\"fa-solid fa-plus icon\"></i>");
                    request.setAttribute(BUTTON_ACTION, "Add Service Type");
                    request.setAttribute(ACTION_URL, "" + request.getContextPath() + "/admin/add-service-type");

                    RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/AddServiceType.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    serviceType = new ServiceType();
                    serviceType.setServiceTypeID(serviceTypeID);
                    serviceType.setServiceTypeName(getServiceTypeName);

                    serviceTypeFacade.addServiceType(serviceType);

                    response.sendRedirect(request.getContextPath() + "/admin/service-type-management");
                }
            } else if (urlServlet.equals("/admin/edit-service-type")) {
                String serviceTypeID = request.getParameter("stid");
                String getServiceTypeName = request.getParameter("serviceTypeName");

                ServiceTypeError serviceTypeError = new ServiceTypeError();
                boolean hasError = false;

                if (getServiceTypeName.equals("")) {
                    hasError = true;
                    serviceTypeError.setServiceTypeName("Please enter service type name");
                }

                if (hasError) {
                    request.setAttribute(NAME_SERVICE_TYPE, getServiceTypeName);
                    request.setAttribute(SERVICE_TYPE_ERROR, serviceTypeError);
                    request.setAttribute(MENU_BAR, MENU_BAR);
                    request.setAttribute(MENU_BAR_ICON, "<i class=\"fa-solid fa-pen-to-square icon\"></i>");
                    request.setAttribute(BUTTON_ACTION, "Edit Service Type");
                    request.setAttribute(ACTION_URL, "" + request.getContextPath() + "/admin/edit-service-type?stid=" + serviceTypeID + "");

                    RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/AddServiceType.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    serviceType = new ServiceType();
                    serviceType.setServiceTypeID(serviceTypeID);
                    serviceType.setServiceTypeName(getServiceTypeName);

                    serviceTypeFacade.updateServiceType(serviceType, "EditServiceType");

                    response.sendRedirect(request.getContextPath() + "/admin/service-type-management");
                }
            }

        } catch (IOException | SQLException | ServletException e) {
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

}
