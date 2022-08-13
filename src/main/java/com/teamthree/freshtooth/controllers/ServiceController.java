package com.teamthree.freshtooth.controllers;

import com.teamthree.freshtooth.dbo.ServiceFacade;
import com.teamthree.freshtooth.dbo.ServiceTypeFacade;
import com.teamthree.freshtooth.models.ServiceType;
import com.teamthree.freshtooth.models.Services;
import com.teamthree.freshtooth.models.ServicesError;
import com.teamthree.freshtooth.utils.FunctionRandom;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

public class ServiceController extends HttpServlet {

    private static final String SERVICE_LIST = "SERVICE_LIST";
    private static final String SERVICE_TYPE_LIST = "SERVICE_TYPE_LIST";
    private static final String TOTAL_SERVICE_LIST = "TOTAL_SERVICE_LIST";
    private static final String END_PAGE = "END_PAGE";
    private static final String CURRENT_PAGE = "CURRENT_PAGE";
    private static final String SERVICE_ERROR = "SERVICE_ERROR";
    private static final String SERVICE_NAME = "SERVICE_NAME";
    private static final String SERVICE_PRICE = "SERVICE_PRICE";
    private static final String SERVICE_DISCOUNT = "SERVICE_DISCOUNT";
    private static final String SERVICE_IMAGE = "SERVICE_IMAGE";
    private static final String SERVICE_DESCRIPTION = "SERVICE_DESCRIPTION";
    private static final String SERVICE_TYPE = "SERVICE_TYPE";
    private static final String BUTTON_ACTION = "BUTTON_ACTION";
    private static final String ACTION_URL = "ACTION_URL";
    private static final String MENU_BAR = "MENU_BAR";
    private static final String MENU_BAR_ICON = "MENU_BAR_ICON";
    private static final String SEARCH = "SEARCH";

    private void returnPrintWriter(List<Services> servicesList, PrintWriter printWriter, HttpServletRequest request) {
        for (Services services : servicesList) {
            printWriter.println("<div class=\"col-md-4 service-item service-amount\" data-aos=\"fade-up\" data-aos-duration=\"1000\">\n"
                    + "                                    <a href=\"" + request.getContextPath() + "/service-detail?sid=" + services.getServiceID() + "\">\n"
                    + "                                        <div class=\"rounded-top overflow-hidden service-image\">\n"
                    + "                                            <img class=\"img-fluid\" src=\"data:image/png;base64," + services.getImageService() + "\" alt=\"" + services.getServiceName() + "\">\n"
                    + "                                        </div>\n"
                    + "                                        <div class=\"position-relative bg-light rounded-bottom text-center p-4\">\n"
                    + "                                            <h5 class=\"m-0\">" + services.getServiceName() + "</h5>\n"
                    + "                                        </div>\n"
                    + "                                    </a>\n"
                    + "                                </div>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String urlServlet = request.getServletPath();

            PrintWriter printWriter = response.getWriter();
            ServiceFacade serviceFacade = new ServiceFacade();
            ServiceTypeFacade serviceTypeFacade = new ServiceTypeFacade();

            List<Services> servicesList;

            if (urlServlet.equals("/service")) {
                String serviceAmount = request.getParameter("serviceExits");
                String serviceType = request.getParameter("type");
                String searchValue = request.getParameter("search");

                if (serviceAmount != null) {
                    int serviceAmountInt = Integer.parseInt(serviceAmount);

                    if (serviceType != null) {
                        servicesList = serviceFacade.getServices(serviceType, serviceAmountInt, "GetNext6ServiceWithType");
                    } else {
                        servicesList = serviceFacade.getServices(null, serviceAmountInt, "GetNext6Service");
                    }

                    returnPrintWriter(servicesList, printWriter, request);
                } else if (searchValue != null) {
                    servicesList = serviceFacade.getServices(null, searchValue, "SearchByName");
                    returnPrintWriter(servicesList, printWriter, request);
                } else {
                    if (serviceType != null) {
                        servicesList = serviceFacade.getServices(serviceType, null, "Top6ServiceWithType");

                        if (servicesList.isEmpty()) {
                            request.setAttribute(SERVICE_LIST, null);
                        } else {
                            request.setAttribute(SERVICE_LIST, servicesList);
                        }
                    } else {
                        List<Services> servicesListExist = new ArrayList<>();

                        servicesList = serviceFacade.getServices(null, null, "Top6Service");

                        for (Services services : servicesList) {
                            ServiceType checkServiceType = serviceTypeFacade.getServiceType(services.getServiceTypeID());

                            if (checkServiceType.getServiceTypeStatus() == 0) {
                                servicesListExist.add(services);
                            }
                        }

                        if (servicesListExist.isEmpty()) {
                            request.setAttribute(SERVICE_LIST, null);
                        } else {
                            request.setAttribute(SERVICE_LIST, servicesListExist);
                        }
                    }

                    request.setAttribute(TOTAL_SERVICE_LIST, serviceFacade.countServices());

                    RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/user/Service.jsp");
                    requestDispatcher.forward(request, response);
                }
            } else if (urlServlet.equals("/admin/add-service")) {
                List<ServiceType> serviceTypeList = serviceTypeFacade.getAllServiceType(0, "GetAllServiceType");

                request.setAttribute(SERVICE_TYPE_LIST, serviceTypeList);
                request.setAttribute(MENU_BAR, MENU_BAR);
                request.setAttribute(MENU_BAR_ICON, "<i class=\"fa-solid fa-plus icon\"></i>");
                request.setAttribute(BUTTON_ACTION, "Add Service");
                request.setAttribute(ACTION_URL, "" + request.getContextPath() + "/admin/add-service");

                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/AddService.jsp");
                requestDispatcher.forward(request, response);
            } else if (urlServlet.equals("/admin/edit-service")) {
                String serviceID = request.getParameter("sid");
                List<ServiceType> serviceTypeList = serviceTypeFacade.getAllServiceType(null, "GetAllServiceType");

                Services services = serviceFacade.getServicesDetail(serviceID);

                request.setAttribute(SERVICE_NAME, services.getServiceName());
                request.setAttribute(SERVICE_PRICE, services.getServicePrice());
                request.setAttribute(SERVICE_DISCOUNT, services.getDiscount());
                request.setAttribute(SERVICE_IMAGE, services.getImageService());
                request.setAttribute(SERVICE_DESCRIPTION, services.getDescriptionService());
                request.setAttribute(SERVICE_TYPE, services.getServiceTypeID());
                request.setAttribute(SERVICE_TYPE_LIST, serviceTypeList);
                request.setAttribute(MENU_BAR, MENU_BAR);
                request.setAttribute(MENU_BAR_ICON, "<i class=\"fa-solid fa-pen-to-square icon\"></i>");
                request.setAttribute(BUTTON_ACTION, "Edit Service");
                request.setAttribute(ACTION_URL, "" + request.getContextPath() + "/admin/edit-service?sid=" + serviceID + "");

                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/AddService.jsp");
                requestDispatcher.forward(request, response);
            } else {
                String indexPage = request.getParameter("page");
                String serviceID = request.getParameter("ServiceID");

                if (indexPage == null) {
                    indexPage = "1";
                }
                int index = Integer.parseInt(indexPage);

                if (serviceID != null) {
                    String actionButton = request.getParameter("Action");
                    Services services = new Services();
                    services.setServiceID(serviceID);

                    if (actionButton.equals("Disable")) {
                        services.setServiceStatus(1);
                    } else {
                        services.setServiceStatus(0);
                    }

                    serviceFacade.updateServices(services, "DeleteServices");
                } else {
                    int countService = serviceFacade.countServices();
                    int endPage = countService / 5;
                    if (countService % 5 != 0) {
                        endPage++;
                    }

                    servicesList = serviceFacade.getServices(null, index, "PagingService");
                    if (servicesList.isEmpty()) {
                        request.setAttribute(SERVICE_LIST, null);
                    } else {
                        JSONArray jsArray = new JSONArray(servicesList);
                        request.setAttribute(SERVICE_LIST, jsArray.toString());
                    }

                    request.setAttribute(END_PAGE, endPage);
                    request.setAttribute(CURRENT_PAGE, index);
                    request.setAttribute(SEARCH, "serviceName");

                    RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/ServiceManagement.jsp");
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

            Services services;
            ServiceFacade serviceFacade = new ServiceFacade();

            if (urlServlet.equals("/admin/add-service")) {
                String getServiceName = request.getParameter("serviceName");
                String getServicePrice = request.getParameter("servicePrice");
                String getDiscount = request.getParameter("discount");
                String getServiceType = request.getParameter("serviceType");
                String getServiceImage = request.getParameter("serviceImage");
                String getDescriptionService = request.getParameter("descriptionService");
                String serviceID = FunctionRandom.randomID(10);

                ServicesError servicesError = new ServicesError();
                boolean hasError = false;

                if (getServiceName.equals("") && getServicePrice.equals("") && getServiceImage.equals("") && getDescriptionService.equals("") && getServiceType.equals("")) {
                    hasError = true;
                    servicesError.setServiceNameError("Please enter service name!");
                    servicesError.setServicePriceError("Please enter service price!");
                    servicesError.setImageServiceError("Please choose image service!");
                    servicesError.setDescriptionServiceError("Please enter service description!");
                    servicesError.setServiceTypeIDError("Please choose service type!");
                } else if (getServiceName.equals("")) {
                    hasError = true;
                    servicesError.setServiceNameError("Please enter service name!");
                } else if (getServicePrice.equals("")) {
                    hasError = true;
                    servicesError.setServicePriceError("Please enter service price!");
                } else if (getServiceImage.equals("")) {
                    hasError = true;
                    servicesError.setImageServiceError("Please choose image service!");
                } else if (getDescriptionService.equals("")) {
                    hasError = true;
                    servicesError.setDescriptionServiceError("Please enter service description!");
                } else if (getServiceType.equals("")) {
                    hasError = true;
                    servicesError.setServiceTypeIDError("Please choose service type!");
                }

                if (hasError) {
                    request.setAttribute(SERVICE_NAME, getServiceName);
                    request.setAttribute(SERVICE_PRICE, getServicePrice);
                    request.setAttribute(SERVICE_DISCOUNT, getDiscount);
                    if (!getServiceImage.equals("")) {
                        String[] cutCodeImage = getServiceImage.split("\\,");
                        request.setAttribute(SERVICE_IMAGE, cutCodeImage[1]);
                    } else {
                        request.setAttribute(SERVICE_IMAGE, null);
                    }
                    request.setAttribute(SERVICE_DESCRIPTION, getDescriptionService);
                    request.setAttribute(SERVICE_TYPE, getServiceType);
                    request.setAttribute(SERVICE_ERROR, servicesError);
                    request.setAttribute(MENU_BAR, MENU_BAR);
                    request.setAttribute(MENU_BAR_ICON, "<i class=\"fa-solid fa-plus icon\"></i>");
                    request.setAttribute(BUTTON_ACTION, "Add Service");
                    request.setAttribute(ACTION_URL, "" + request.getContextPath() + "/admin/add-service");

                    RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/AddService.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    services = new Services();
                    services.setServiceID(serviceID);
                    services.setServiceName(getServiceName);
                    services.setServicePrice(Double.parseDouble(getServicePrice));
                    services.setDiscount(Integer.parseInt(getDiscount));
                    if (!getServiceImage.equals("")) {
                        String[] cutCodeImage = getServiceImage.split("\\,");
                        services.setImageService(cutCodeImage[1]);
                    }
                    services.setDescriptionService(getDescriptionService);
                    services.setServiceTypeID(getServiceType);
                    serviceFacade.addServices(services);
                    response.sendRedirect(request.getContextPath() + "/admin/service-management");
                }
            } else if (urlServlet.equals("/admin/edit-service")) {
                String serviceID = request.getParameter("sid");
                String getServiceName = request.getParameter("serviceName");
                String getServicePrice = request.getParameter("servicePrice");
                String getDiscount = request.getParameter("discount");
                String getServiceType = request.getParameter("serviceType");
                String getServiceImage = request.getParameter("serviceImage");
                String getDescriptionService = request.getParameter("descriptionService");

                ServicesError servicesError = new ServicesError();
                boolean hasError = false;

                if (getServiceName.equals("") && getServicePrice.equals("") && getServiceImage.equals("") && getDescriptionService.equals("") && getServiceType.equals("")) {
                    hasError = true;
                    servicesError.setServiceNameError("Please enter service name!");
                    servicesError.setServicePriceError("Please enter service price!");
                    servicesError.setImageServiceError("Please choose image service!");
                    servicesError.setDescriptionServiceError("Please enter service description!");
                    servicesError.setServiceTypeIDError("Please choose service type!");
                } else if (getServiceName.equals("")) {
                    hasError = true;
                    servicesError.setServiceNameError("Please enter service name!");
                } else if (getServicePrice.equals("")) {
                    hasError = true;
                    servicesError.setServicePriceError("Please enter service price!");
                } else if (getServiceImage.equals("")) {
                    hasError = true;
                    servicesError.setImageServiceError("Please choose image service!");
                } else if (getDescriptionService.equals("")) {
                    hasError = true;
                    servicesError.setDescriptionServiceError("Please enter service description!");
                } else if (getServiceType.equals("")) {
                    hasError = true;
                    servicesError.setServiceTypeIDError("Please choose service type!");
                }

                if (hasError) {
                    request.setAttribute(SERVICE_NAME, getServiceName);
                    request.setAttribute(SERVICE_PRICE, getServicePrice);
                    request.setAttribute(SERVICE_DISCOUNT, getDiscount);
                    if (!getServiceImage.equals("")) {
                        String[] cutCodeImage = getServiceImage.split("\\,");
                        request.setAttribute(SERVICE_IMAGE, cutCodeImage[1]);
                    } else {
                        request.setAttribute(SERVICE_IMAGE, null);
                    }
                    request.setAttribute(SERVICE_DESCRIPTION, getDescriptionService);
                    request.setAttribute(SERVICE_TYPE, getServiceType);
                    request.setAttribute(SERVICE_ERROR, servicesError);
                    request.setAttribute(MENU_BAR, MENU_BAR);
                    request.setAttribute(MENU_BAR_ICON, "<i class=\"fa-solid fa-pen-to-square icon\"></i>");
                    request.setAttribute(BUTTON_ACTION, "Edit Service");
                    request.setAttribute(ACTION_URL, "" + request.getContextPath() + "/admin/edit-service?sid=" + serviceID + "");

                    RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/AddService.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    services = new Services();
                    services.setServiceID(serviceID);
                    services.setServiceName(getServiceName);
                    services.setServicePrice(Double.parseDouble(getServicePrice));
                    services.setDiscount(Integer.parseInt(getDiscount));
                    if (!getServiceImage.equals("")) {
                        String[] cutCodeImage = getServiceImage.split("\\,");
                        services.setImageService(cutCodeImage[1]);
                    }
                    services.setDescriptionService(getDescriptionService);
                    services.setServiceTypeID(getServiceType);
                    serviceFacade.updateServices(services, "EditServices");
                    response.sendRedirect(request.getContextPath() + "/admin/service-management");
                }
            }

        } catch (IOException | NumberFormatException | SQLException | ServletException e) {
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
