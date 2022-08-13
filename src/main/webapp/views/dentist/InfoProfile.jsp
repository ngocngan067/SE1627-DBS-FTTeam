<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Profile | ${sessionScope.LOGIN_DENTIST.fullName}</title>
        <!-- TẠO ICON TRÊN THANH WEB -->
        <link rel="icon" href=".././images/iconFT.png" type="image/png" sizes="200x138" />
        <!-- LINK BOOTSTRAP 5 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" />
        <!-- LINK FONT AWESOME -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.1.1/css/all.css">
        <!-- Box Icons -->
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <!-- UN ICONS -->
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
        <!-- AOS  -->
        <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
        <!-- LINK CSS -->
        <link rel="stylesheet" href=".././css/dentist/DentistRoot.css" />
        <link rel="stylesheet" href=".././css/ScrollBackToTop.css" />
        <link rel="stylesheet" href=".././css/CheckNetworkStatus.css" />
        <link rel="stylesheet" href=".././css/dentist/NavBar.css" />
        <link rel="stylesheet" href=".././css/dentist/InfoProfile.css" />
    </head>
    <body>
        <jsp:include page="../../layouts/ScrollBackToTop.html"></jsp:include>
        <jsp:include page="../../layouts/CheckNetworkStatus.html"></jsp:include>
        
        <header class="header-background">
            <jsp:include page="../../layouts/dentist/NavBar.jsp"></jsp:include>
        </header>
        
        <div class="container">
            <div class="main-body">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="card">
                            <div class="card-body">
                                <div class="d-flex flex-column align-items-center text-center">
                                    <div class="avatar-photo">
                                        <img src="data:image/png;base64,${sessionScope.LOGIN_DENTIST.imageAvatar}" alt="${sessionScope.LOGIN_DENTIST.fullName}">
                                    </div>
                                    <div class="mt-3">
                                        <h4>${sessionScope.LOGIN_DENTIST.fullName}</h4>
                                        <p class="text-muted font-size-sm">${sessionScope.LOGIN_DENTIST.userEmail}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-8">
                        <div class="card">
                            <div class="card-body">
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">User Name</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="text" class="form-control" value="${sessionScope.LOGIN_DENTIST.fullName}" disabled>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Email</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="text" class="form-control" value="${sessionScope.LOGIN_DENTIST.userEmail}" disabled>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Sex</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <c:choose>
                                            <c:when test = "${sessionScope.LOGIN_DENTIST.sex.equals('M')}">
                                               <input type="text" class="form-control" value="Male" disabled>
                                            </c:when>
                                               
                                            <c:when test = "${sessionScope.LOGIN_DENTIST.sex.equals('F')}">
                                                <input type="text" class="form-control" value="Female" disabled>
                                            </c:when>
                                        </c:choose>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Date Of Birth</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="text" class="form-control" value="<fmt:formatDate value="${sessionScope.LOGIN_DENTIST.dateOfBirth}" pattern="dd-MM-yyyy"/>" disabled>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Phone Number</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="text" class="form-control" value="${sessionScope.LOGIN_DENTIST.userPhone}" disabled>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Address</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="text" class="form-control" value="${sessionScope.LOGIN_DENTIST.userAddress}" disabled>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Date Created</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="text" class="form-control" value="<fmt:formatDate value="${sessionScope.LOGIN_DENTIST.accountCreated}" pattern="dd-MM-yyyy"/>" disabled>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- LINK BOOTSTRAP 5 -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
        <!-- J QUERY -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- Script  -->
        <script src=".././js/dentist/DentistRoot.js"></script>
        <script src=".././js/ScrollBackToTop.js"></script>
        <script src=".././js/CheckNetworkStatus.js"></script>
    </body>
</html>
