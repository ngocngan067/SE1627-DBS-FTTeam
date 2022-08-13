<%@page import="com.teamthree.freshtooth.models.ServicesError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    ServicesError servicesError = (ServicesError) request.getAttribute("SERVICE_ERROR");
    if(servicesError == null) {
        servicesError = new ServicesError();
    }
    
    String imageService = (String) request.getAttribute("SERVICE_IMAGE");
    String concatStringImage = "";
    if (imageService != null) {
        concatStringImage = "data:image/png;base64," + imageService;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>${BUTTON_ACTION}</title>
        <link rel="icon" type="image/png" sizes="200x138" href=".././images/iconFT.png">
        <!-- LINK FONTAWESOME -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.1.1/css/all.css">
        <!-- LINK UNICONS -->
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
        <!-- LINK BOOTSTRAP -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- LINK CSS -->
        <link href=".././css/admin/AdminRoot.css" rel="stylesheet" type="text/css"/>
        <link href=".././css/ScrollBackToTop.css" rel="stylesheet" type="text/css"/>
        <link href=".././css/admin/NavBar.css" rel="stylesheet" type="text/css"/>
        <link href=".././css/admin/MenuBar.css" rel="stylesheet" type="text/css"/>
        <link href=".././css/admin/AddService.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="../../layouts/ScrollBackToTop.html"></jsp:include>
        <jsp:include page="../../layouts/admin/MenuBar.jsp"></jsp:include>
        
        <!-- Main -->
        <div class="body-main">
            <jsp:include page="../../layouts/admin/NavBar.jsp"></jsp:include>

            <div class="form_wrapper">
                <div class="form_container">
                    <div class="title_container">
                        <h2>${BUTTON_ACTION}</h2>
                    </div>
                    <div class="row clearfix">
                        <div>
                            <form action="${ACTION_URL}" method="post">
                                <div class="input_field">
                                    <span>
                                        <i class="fa-solid fa-font"></i>
                                    </span>
                                    <input type="text" class="service-name" name="serviceName" value="${SERVICE_NAME != null ? SERVICE_NAME : ""}" placeholder="Service Name" onblur="CheckServiceName()" oninput="CheckServiceName()" />
                                </div>
                                <div class="text-danger service-name-error">
                                    <p><%=servicesError.getServiceNameError()%></p>
                                </div>
                                <div class="input_field">
                                    <span>
                                        <i class="fa-solid fa-hand-holding-dollar"></i>
                                    </span>
                                    <input type="number" class="service-price" value="<fmt:formatNumber value="${SERVICE_PRICE}" type="currency" />" name="servicePrice" placeholder="Service Price" onblur="CheckServicePrice()" oninput="CheckServicePrice()" />
                                </div>
                                <div class="text-danger service-price-error">
                                    <p><%=servicesError.getServicePriceError()%></p>
                                </div>
                                <div class="input_field">
                                    <span>
                                        <i class="fa-solid fa-percent"></i>
                                    </span>
                                    <input type="number" class="service-discount" value="${SERVICE_DISCOUNT != null ? SERVICE_DISCOUNT : ""}" name="discount" placeholder="Discount" onblur="CheckServiceDiscount()" oninput="CheckServiceDiscount()"/>
                                </div>
                                <div class="text-danger service-discount-error">
                                    <p></p>
                                </div>
                                <div class="input_field">
                                    <span>
                                        <i class="fa-solid fa-id-badge"></i>
                                    </span>
                                    <select name="serviceType" id="serviceType" onblur="CheckServiceType()" onclick="CheckServiceType()">
                                        <option value="">Please select service type</option>
                                        <c:forEach items="${SERVICE_TYPE_LIST}" var="serviceType">
                                            <option value="${serviceType.serviceTypeID}" ${serviceType.serviceTypeID == SERVICE_TYPE ? "selected" : ""}>${serviceType.serviceTypeName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="text-danger service-type-error">
                                    <p><%=servicesError.getServiceTypeIDError()%></p>
                                </div>
                                <div class="input_field">
                                    <div class="image-input">
                                        <input type="file" accept="image/*" id="imageInput">
                                        <img src="<%=concatStringImage%>" class="image-preview image-edit">
                                        <input type="hidden" class="image-hidden" name="serviceImage" value="<%=concatStringImage%>">
                                        <label for="imageInput" class="image-button add-button">
                                            <i class="fa-solid fa-image"></i>Service Picture
                                        </label>
                                        <span class="change-image">Change Picture</span>
                                    </div>
                                </div>
                                <div class="text-danger service-image-error">
                                    <p><%=servicesError.getImageServiceError()%></p>
                                </div>
                                <div class="input_field">
                                    <textarea name="descriptionService" class="service-discription" required id="editor">${SERVICE_DESCRIPTION != null ? SERVICE_DESCRIPTION : ""}</textarea>
                                </div>
                                <div class="text-danger service-description-error">
                                    <p><%=servicesError.getDescriptionServiceError()%></p>
                                </div>
                                <input class="button add-service" type="submit" value="${BUTTON_ACTION}" />
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Main -->
        
        <!-- JQUERY -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- LINK BOOTSTRAP -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- LINK UNICONS -->
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <!-- LINK CKEDITOR -->
        <script src="//cdn.ckeditor.com/4.19.0/full/ckeditor.js"></script>
        <!-- Script -->
        <script src=".././js/admin/AdminRoot.js"></script>
        <script src=".././js/admin/NavBar.js"></script>
        <script src=".././js/admin/AddService.js"></script>
        <script>
            CKEDITOR.replace('editor', {
                language: 'en',
                editorplaceholder: 'Start typing here...'
            });
            setActiveMenuBar();
        </script>
    </body>
</html>
