<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Booking | ${sessionScope.LOGIN_USER.fullName}</title>
        <!-- TẠO ICON TRÊN THANH WEB -->
        <link rel="icon" href="./images/iconFT.png" type="image/png" sizes="200x138" />
        <!-- LINK BOOTSTRAP 5 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" />
        <!-- LINK FONT AWESOME -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.1.1/css/all.css">
        <!-- Box Icons -->
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <!-- UN ICONS -->
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
        <!-- Malihu Custom Scrollbar -->
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.3/jquery.mCustomScrollbar.min.css'>
        <!-- AOS  -->
        <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
        <!-- LINK CSS -->
        <link rel="stylesheet" href="./css/user/UserRoot.css" />
        <link rel="stylesheet" href="./css/ScrollBackToTop.css" />
        <link rel="stylesheet" href="./css/CheckNetworkStatus.css" />
        <link rel="stylesheet" href="./css/user/NavBar.css" />
        <link rel="stylesheet" href="./css/user/Booking.css" />
        <link rel="stylesheet" href="./css/user/FooterPage.css" />
        <link rel="stylesheet" href="./css/user/SupportOnline.css" />
    </head>
    <body>
        <jsp:include page="../../layouts/ScrollBackToTop.html"></jsp:include>
        <jsp:include page="../../layouts/CheckNetworkStatus.html"></jsp:include>
        
        <header class="header-background">
            <jsp:include page="../../layouts/user/NavBar.jsp"></jsp:include>
        </header>
        
        <!------------- Booking Body ----------------->
        <div class="booking-body pt-5">
            <div class="container-fluid">
                <div class="row d-flex justify-content-center ">
                    <!-- card  -->
                    <div class="card mb-3 d-flex justify-content-center border-primary rounded-3 bg-white "
                        style="max-width: 80%;">
                        <div class="row g-0 ">
                            <!-- card text -->
                            <div class="col-md-6">
                                <div class="booking-backgound">
                                    <lottie-player src="https://assets8.lottiefiles.com/packages/lf20_l13zwx3i.json"
                                        background="transparent" speed="1" loop autoplay class="setting-image">
                                    </lottie-player>
                                </div>
                            </div>
                            <!-- card form -->
                            <div class="col-md-6 mt-4">
                                <div class="title h3">Set appointment</div>
                                <form action="${pageContext.request.contextPath}/booking" method="post" class="row g-3 " id="form-1">
                                    <div class="col-md-8 form-group">
                                        <label for="fullName" class="form-label">Full Name</label>
                                        <div class="setting-form_input">
                                            <input type="text" id="fullName" class="form-input" name="fullName" value="${sessionScope.LOGIN_USER.fullName}" readonly>
                                        </div>
                                    </div>
                                    <div class="col-md-4 form-group">
                                        <label for="gender" class="form-label">Gender</label>
                                        <div class="setting-form_input">
                                            <input type="text" id="gender" class="form-input" name="gender" value="${sessionScope.LOGIN_USER.sex}" readonly>
                                        </div>
                                    </div>
                                    <div class="col-md-8 form-group">
                                        <label for="email" class="form-label">Email</label>
                                        <div class="setting-form_input">
                                            <input type="email" id="email" class="form-input" name="email" value="${sessionScope.LOGIN_USER.userEmail}" readonly>
                                        </div>
                                    </div>
                                    <div class="col-md-4 form-group">
                                        <label for="dateOfBirth" class="form-label">Date Of Birth</label>
                                        <div class="setting-form_input">
                                            <input type="text" id="dateOfBirth" class="form-input" name="dateOfBirth" value="<fmt:formatDate value="${sessionScope.LOGIN_USER.dateOfBirth}" pattern="dd-MM-yyyy"/>" readonly>
                                        </div>
                                    </div>
                                    <div class="col-md-8 form-group">
                                        <label for="address" class="form-label">Address</label>
                                        <div class="setting-form_input">
                                            <input type="text" id="address" class="form-input" name="address" value="${sessionScope.LOGIN_USER.userAddress}" readonly>
                                        </div>
                                    </div>
                                    <div class="col-md-4 form-group">
                                        <label for="phoneNumber" class="form-label">Phone Number</label>
                                        <div class="setting-form_input">
                                            <input type="text" id="phoneNumber" class="form-input" name="phoneNumber" value="${sessionScope.LOGIN_USER.userPhone}" readonly>
                                        </div>
                                    </div>
                                    <div class="col-md-6 form-group" id="service-div">
                                        <label for="inputService" class="form-label">Service</label>
                                        <select id="inputService" class="form-select">
                                            <option selected>Consultation</option>
                                            <option>Implant</option>
                                            <option>Hygiene</option>
                                            <option>Oral surgery</option>
                                        </select>
                                    </div>
                                    <div class=" col-md-6 form-group " id="doctor-div">
                                        <label for="inputDoctor" class="form-label">Dentist</label>
                                        <select id="inputDoctor" class="form-select">
                                            <option selected>Dr: 1</option>
                                            <option>Dr: 2</option>
                                            <option>Dr: 3</option>
                                            <option>Dr: 4</option>
                                        </select>
                                    </div>
                                    <div class="col-md-6 form-group" id="date-div">
                                        <label class="form-label">Appointment date</label>
                                        <div>
                                            <input class="form-select" type="text" id="datepicker" placeholder="22/11/1998"
                                                autocomplete="off" value="11-22-1998" onchange="getd()">
                                        </div>
                                    </div>
                                    <div class=" col-md-6 form-group " id="slot-div">
                                        <label for="inputslot" class="form-label">slot</label>
                                        <select id="inputslot" class="form-select">
                                            <option selected>slot 1</option>
                                            <option>slot 2</option>
                                            <option>slot 3</option>
                                            <option>slot 4</option>
                                        </select>
                                    </div>
                                    <div class="button">
                                        <input type="submit" value="Booking">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!------------- End Booking Body ------------->
        
        <jsp:include page="../../layouts/user/FooterPage.jsp"></jsp:include>
        <jsp:include page="../../layouts/user/SupportOnline.jsp"></jsp:include>
        
        <!-- LINK BOOTSTRAP 5 -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
        <!-- Lottie Files -->
        <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
        <!-- JQUERY -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- AOS  -->
        <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
        <!-- Malihu Custom Scrollbar -->
        <script src='https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.3/jquery.mCustomScrollbar.concat.min.js'></script>
        <!-- Script  -->
        <script src="./js/user/UserRoot.js"></script>
        <script src="./js/ScrollBackToTop.js"></script>
        <script src="./js/CheckNetworkStatus.js"></script>
        <script src="./js/user/Booking.js"></script>
        <script>
            setActiveMenuBar();
        </script>
    </body>
</html>
