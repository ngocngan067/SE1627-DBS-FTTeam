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
    private static final String NOT_EMPTY = "NOT_EMPTY";
    private static final String END_PAGE = "END_PAGE";
    private static final String CURRENT_PAGE = "CURRENT_PAGE";

    private static final String SERVICE_ERROR = "SERVICE_ERROR";
    private static final String SERVICE_NAME = "SERVICE_NAME";
    private static final String SERVICE_PRICE = "SERVICE_PRICE";
    private static final String SERVICE_DISCOUNT = "SERVICE_DISCOUNT";
    private static final String SERVICE_IMAGE = "SERVICE_IMAGE";
    private static final String SERVICE_DESCRIPTION = "SERVICE_DESCRIPTION";

    private void returnPrintWriter(List<Services> servicesList, PrintWriter printWriter, HttpServletRequest request) {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String serviceAmount = request.getParameter("serviceExits");
            String urlServlet = request.getServletPath();
            PrintWriter printWriter = response.getWriter();

            ServiceFacade serviceFacade = new ServiceFacade();

            List<Services> servicesList;

            if (urlServlet.equals("/service")) {
                if (serviceAmount != null) {
                    int serviceAmountInt = Integer.parseInt(serviceAmount);
                    servicesList = serviceFacade.getServices(serviceAmountInt, "GetNext6Course");
                    returnPrintWriter(servicesList, printWriter, request);
                } else {
                    servicesList = serviceFacade.getServices("", "Top6News");

                    request.setAttribute(TOTAL_SERVICE_LIST, serviceFacade.countServices());
                    request.setAttribute(SERVICE_LIST, servicesList);
                    request.setAttribute(NOT_EMPTY, NOT_EMPTY);

                    RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/user/Service.jsp");
                    requestDispatcher.forward(request, response);
                }
            } else if (urlServlet.equals("/admin/add-service")) {
                ServiceTypeFacade serviceTypeFacade = new ServiceTypeFacade();
                List<ServiceType> serviceTypeList = serviceTypeFacade.getAllServiceType();
                
                request.setAttribute(SERVICE_TYPE_LIST, serviceTypeList);
                
                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/AddService.jsp");
                requestDispatcher.forward(request, response);
            } else {
                String indexPage = request.getParameter("page");
                String serviceID = request.getParameter("serviceID");

                if (indexPage == null) {
                    indexPage = "1";
                }
                int index = Integer.parseInt(indexPage);

                if (serviceID != null) {

                } else {
                    int countService = serviceFacade.countServices();
                    int endPage = countService / 5;
                    if (countService % 5 != 0) {
                        endPage++;
                    }

                    servicesList = serviceFacade.getServices(index, "PagingService");
                    if (servicesList.isEmpty()) {
                        request.setAttribute(SERVICE_LIST, null);
                    } else {
                        JSONArray jsArray = new JSONArray(servicesList);
                        request.setAttribute(SERVICE_LIST, jsArray.toString());
                    }

                    request.setAttribute(END_PAGE, endPage);
                    request.setAttribute(CURRENT_PAGE, index);

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

            if (urlServlet.equals("/admin/add-service")) {
                String getServiceName = request.getParameter("serviceName");
                String getServicePrice = request.getParameter("servicePrice");
                String getDiscount = request.getParameter("discount");
                String getServiceType = request.getParameter("serviceType");
                String getServiceImage = request.getParameter("serviceImage");
                String getDescriptionService = request.getParameter("descriptionService");
                String serviceID = FunctionRandom.randomID(10);

                Services services;
                ServiceFacade serviceFacade = new ServiceFacade();
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
                    if (getServiceImage != null) {
                        String[] cutCodeImage = getServiceImage.split("\\,");
                        request.setAttribute(SERVICE_IMAGE, cutCodeImage[1]);
                    }
                    request.setAttribute(SERVICE_DESCRIPTION, getDescriptionService);
                    request.setAttribute(SERVICE_ERROR, servicesError);
                    RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/AddService.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    services = new Services();
                    services.setServiceID(serviceID);
                    services.setServiceName(getServiceName);
                    services.setServicePrice(Integer.parseInt(getServicePrice));
                    services.setDiscount(Integer.parseInt(getDiscount));
                    if (getServiceImage != null) {
                        String[] cutCodeImage = getServiceImage.split("\\,");
                        services.setImageService(cutCodeImage[1]);
                    }
                    services.setDescriptionService(getDescriptionService);
                    serviceFacade.addServices(services);
                    
                    RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/admin/service-management");
                    requestDispatcher.forward(request, response);
                }
            }

        } catch (IOException | NumberFormatException | SQLException | ServletException e) {
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
