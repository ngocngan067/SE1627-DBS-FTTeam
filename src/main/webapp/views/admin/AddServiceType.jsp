<%@page import="com.teamthree.freshtooth.models.ServiceTypeError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%  
    ServiceTypeError serviceTypeError = (ServiceTypeError) request.getAttribute("DENTIST_ACCOUNT_ERROR");
    
    if(serviceTypeError == null) {
        serviceTypeError = new ServiceTypeError();
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
        <!-- LINK FONT AWESOME -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.1.1/css/all.css">
        <!-- LINK UN ICONS -->
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
        <!-- LINK BOOTSTRAP -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- LINK STYLE -->
        <link href=".././css/admin/AdminRoot.css" rel="stylesheet" type="text/css"/>
        <link href=".././css/ScrollBackToTop.css" rel="stylesheet" type="text/css"/>
        <link href=".././css/admin/NavBar.css" rel="stylesheet" type="text/css"/>
        <link href=".././css/admin/MenuBar.css" rel="stylesheet" type="text/css"/>
        <link href=".././css/admin/AddServiceType.css" rel="stylesheet" type="text/css"/>
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
                                    <input type="text" class="service-type-name" name="serviceTypeName" value="${NAME_SERVICE_TYPE != null ? NAME_SERVICE_TYPE : ""}" placeholder="Service Type Name" onblur="CheckServiceTypeName()" oninput="CheckServiceTypeName()" />
                                </div>
                                <div class="text-danger service-type-name-error">
                                    <p><%=serviceTypeError.getServiceTypeName()%></p>
                                </div>
                                <input class="button add-service" type="submit" value="${BUTTON_ACTION}" />
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Main -->
        
        <!-- LINK J QUERY -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- LINK BOOTSTRAP -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- LINK UN ICONS -->
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <!-- Script -->
        <script src=".././js/admin/AdminRoot.js"></script>
        <script src=".././js/admin/NavBar.js"></script>
        <script src=".././js/admin/AddServiceType.js"></script>
        <script>
            setActiveMenuBar();
        </script>
    </body>
</html>
