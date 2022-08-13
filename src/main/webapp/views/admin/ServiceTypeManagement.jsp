<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Service Type Management | Page: ${CURRENT_PAGE}</title>
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
        <link href=".././css/admin/ServiceTypeManagement.css" rel="stylesheet" type="text/css"/>
    </head>
    <body ng-app="myapp" ng-controller="viewCril">
        <jsp:include page="../../layouts/ScrollBackToTop.html"></jsp:include>
        <jsp:include page="../../layouts/admin/MenuBar.jsp"></jsp:include>
        
        <div class="body-main">
            <jsp:include page="../../layouts/admin/NavBar.jsp"></jsp:include>
            
            <div class="management-container">
                <!-- User Management Header -->
                <main class="management-layout">
                    <div class="management-top">
                        <h2 class="management-title">
                            Service Type - <span>Management</span>
                        </h2>

                        <div class="management-alert">
                            You are in admin mode. You can edit the data.
                        </div>
                    </div>
                    
                    <div class="management-button">
                        <button ng-click="exportToExcel('#tableToExport')" type="button" class="button-export">
                            <i class="fa-solid fa-file-excel"></i>Export Excel
                        </button>
                        <button onclick="window.location.href='${pageContext.request.contextPath}/admin/add-service-type'" type="button" class="button-export button-add">
                            <i class="fa-solid fa-user-plus"></i>Add Service Type
                        </button>
                    </div>
                </main>

                <!-- User Management Table User -->
                <div class="table-users" id="tableToExport">
                    <table cellspacing="0">
                        <tr>
                            <th>STT</th>
                            <th>Service Type Name</th>
                            <th>Service Type Status</th>
                            <th>Actions</th>
                        </tr>

                        <tr ng-repeat="serviceType in listServiceType | filter: ${SEARCH}">
                            <td>{{$index + 1}}</td>
                            <td>{{serviceType.serviceTypeName}}</td>
                            <td>{{serviceType.serviceTypeStatus == 0 ? "Not disabled" : "Disabled"}}</td>
                            <td>
                                <div class="table-action-button">
                                    <a href="${pageContext.request.contextPath}/admin/edit-service-type?stid={{serviceType.serviceTypeID}}" class="users-control btn btn-primary">Edit</a>
                                    <button ng-click="disable(serviceType.serviceTypeID, serviceType.serviceTypeStatus === 0 ? 'Disable' : 'UnDisable')" type="button" class="users-control btn btn-danger">{{serviceType.serviceTypeStatus == 0 ? "Disable" : "UnDisable"}}</button>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>

                <!-- User Management Pagination -->
                <c:if test="${END_PAGE > 1}">
                    <div class="table-pagination">
                        <ul>
                            <c:if test="${CURRENT_PAGE > 1}">
                                <li class="pagination-button button-prev">
                                    <a href="${pageContext.request.contextPath}/admin/service-type-management?page=${CURRENT_PAGE - 1}">
                                        <i class="fas fa-angle-left"></i> Prev
                                    </a>
                                </li>
                            </c:if>
                            <c:forEach begin="1" end="${END_PAGE}" var="i">
                                <li class="pagination-number ${CURRENT_PAGE == i ? "active" : ""}">
                                    <a href="${pageContext.request.contextPath}/admin/service-type-management?page=${i}" class="pagination-link">${i}</a>
                                </li>
                            </c:forEach>
                            <c:if test="${CURRENT_PAGE < END_PAGE}">
                                <li class="pagination-button button-next">
                                    <a href="${pageContext.request.contextPath}/admin/service-type-management?page=${CURRENT_PAGE + 1}">
                                        Next <i class="fas fa-angle-right"></i>
                                    </a>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </c:if>
            </div>
        </div>
                                
        <!-- JQUERY -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- LINK BOOTSTRAP -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- LINK UNICONS -->
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <!-- LINK ANGULAR -->
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
        <!-- LINK Sweet Alert 2 -->
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <!-- Script -->
        <script src=".././js/admin/AdminRoot.js"></script>
        <script src=".././js/admin/NavBar.js"></script>
        <script src=".././js/admin/ServiceTypeManagement.js"></script>
        <script>
            ManageServiceTypeAPI("${pageContext.request.contextPath}/admin/service-type-management", ${SERVICE_TYPE_LIST});
            setActiveMenuBar();
        </script>
    </body>
</html>
