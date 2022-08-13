<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <!-- AOS  -->
        <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
        <!-- LINK UI J QUERY  -->
        <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
        <!-- LINK STYLE -->
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
        
        <div id="error-box"></div>
        
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
                            <div class="col-md-12 mt-4">
                                <div class="title h3 mt-1 mb-5">Set appointment</div>
                                <form action="${pageContext.request.contextPath}/booking" method="post" class="row g-3 " id="form-1">
                                    <div class="col-md-6 col-lg-3 form-group">
                                        <label for="fullName" class="form-label">Full Name</label>
                                        <div class="setting-form_input">
                                            <input type="text" id="fullName" class="form-input" name="fullName" readonly value="${sessionScope.LOGIN_USER.fullName}">
                                        </div>
                                    </div>

                                    <div class="col-md-6 col-lg-3 form-group">
                                        <label for="phoneNumber" class="form-label">Phone Number</label>
                                        <div class="setting-form_input">
                                            <input type="number" id="phoneNumber" class="form-input" name="phoneNumber" readonly value="${sessionScope.LOGIN_USER.userPhone}">
                                        </div>
                                    </div>

                                    <div class="col-md-6 col-lg-3 form-group">
                                        <label for="gender" class="form-label">Gender</label>
                                        <div class="setting-form_input">
                                            <c:choose>
                                                <c:when test = "${sessionScope.LOGIN_USER.sex.equals('M')}">
                                                   <input type="text" id="gender" class="form-input" name="gender" readonly value="Male">
                                                </c:when>

                                                <c:when test = "${sessionScope.LOGIN_USER.sex.equals('F')}">
                                                    <input type="text" id="gender" class="form-input" name="gender" readonly value="Female">
                                                </c:when>
                                                <c:otherwise>
                                                    <input type="text" id="gender" class="form-input" name="gender" readonly value="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>

                                    <div class="col-md-6 col-lg-3 form-group">
                                        <label for="dateOfBirth" class="form-label">Date Of Birth</label>
                                        <div class="setting-form_input">
                                            <input type="text" id="dateOfBirth" class="form-input" name="dateOfBirth" readonly value="${sessionScope.LOGIN_USER.dateOfBirth}">
                                        </div>
                                    </div>

                                    <div class="col-md-7 form-group">
                                        <label for="address" class="form-label">Address</label>
                                        <div class="setting-form_input">
                                            <input type="text" id="address" class="form-input" name="address" readonly value="${sessionScope.LOGIN_USER.userAddress}">
                                        </div>
                                    </div>

                                    <div class="col-md-5 form-group">
                                        <label for="email" class="form-label">Email</label>
                                        <div class="setting-form_input">
                                            <input type="email" id="email" class="form-input" name="email" readonly value="${sessionScope.LOGIN_USER.userEmail}">
                                        </div>
                                    </div>

                                    <div class="col-md-12 form-group" id="service-div">
                                        <label for="inputService" class="form-label">Service</label>
                                        <div class="setting-form_input">
                                            <select name="service" onchange="CheckService();" onblur="CheckService()" id="inputService" class="form-select">
                                                <option value="" disabled selected>Select service</option>
                                                <c:forEach items="${SERVICE_SELECT}" var="service">
                                                    <option value="${service.serviceID}">${service.serviceName}</option>
                                                </c:forEach>
                                            </select>
                                            <i class='bx bx-check-circle' id="inputService-icon-check"></i>
                                            <i class='bx bx-error-circle' id="inputService-icon-error"></i>
                                        </div>
                                        <div class="message">
                                            <span class="error-message" id="inputService-error"></span>
                                        </div>
                                    </div>

                                    <div class="col-md-12 form-group" id="date-div">
                                        <label class="form-label">Appointment date</label>
                                        <div class="setting-form_input">
                                            <input onblur="CheckDateOfAppointment()" onchange="CheckDateOfAppointment(); CheckSlot('${pageContext.request.contextPath}/booking');" type="date" id="datepicker-2" class="form-input" readonly accept="dd/MM/yyyy" name="dateOfAppointment"/>
                                            <i class='bx bx-check-circle' id="dateOfAppointment-icon-check"></i>
                                            <i class='bx bx-error-circle' id="dateOfAppointment-icon-error"></i>
                                        </div>
                                        <div class="message">
                                            <span class="error-message" id="dateOfAppointment-error"></span>
                                        </div>
                                    </div>

                                    <div class="col-md-5 col-lg-2 slot--note__title mt-lg-4">
                                        <p>Select Slot <span>*</span></p>
                                    </div>

                                    <div class="col-md-7 col-lg-10 slot--note mt-lg-4">
                                        <div class="slot__color">
                                            <div class="color color1"></div>
                                            <p>Full</p>
                                        </div>

                                        <div class="slot__color">
                                            <div class="color color2"></div>
                                            <p>Open</p>
                                        </div>

                                        <div class="slot__color">
                                            <div class="color color3"></div>
                                            <p>Selected</p>
                                        </div>
                                    </div>

                                    <div class="col-12">
                                        <div class="slot--booking">
                                            <table class="table table-bordered border-secondary">
                                                <tbody>
                                                    <tr class="time--booking">
                                                        <td data-slot="yVAxOtLaWr" class="pick can-choose">9:00</td>
                                                        <td data-slot="ZguYjvDv99" class="pick can-choose">9:30</td>
                                                        <td data-slot="E4cIHlnfq2" class="pick can-choose">10:00</td>
                                                        <td data-slot="xRnDdJtora" class="pick can-choose">10:30</td>
                                                    </tr>

                                                    <tr class="time--booking">
                                                        <td data-slot="pP1aF1VZUi" class="pick can-choose">11:00</td>
                                                        <td data-slot="bgLxb9lAxf" class="pick can-choose">11:30</td>
                                                        <td data-slot="t2125plsQ8" class="pick can-choose">12:00</td>
                                                        <td data-slot="KCiI4OVEqV" class="pick can-choose">12:30</td>
                                                    </tr>

                                                    <tr class="time--booking">
                                                        <td data-slot="uwYyBL34N4" class="pick can-choose">13:00</td>
                                                        <td data-slot="GG0A6gfXKg" class="pick can-choose">13:30</td>
                                                        <td data-slot="NGn4m3rhzv" class="pick can-choose">14:00</td>
                                                        <td data-slot="pemqrC91A4" class="pick can-choose">14:30</td>
                                                    </tr>

                                                    <tr class="time--booking">
                                                        <td data-slot="LiLb3564jz" class="pick can-choose">15:00</td>
                                                        <td data-slot="oTjkSc9QCI" class="pick can-choose">15:30</td>
                                                        <td data-slot="dyNW3IM3IL" class="pick can-choose">16:00</td>
                                                        <td data-slot="Ew5m6XIGHb" class="pick can-choose">16:30</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <div id="slot-value"></div>
                                        </div>
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
        <!-- JQUERY -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- AOS  -->
        <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
        <!-- LINK MOMENT -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
        <!-- LINK UI J QUERY -->
        <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
        <!-- Script  -->
        <script src="./js/user/UserRoot.js"></script>
        <script src="./js/user/NavBar.js"></script>
        <script src="./js/ScrollBackToTop.js"></script>
        <script src="./js/user/Booking.js"></script>
        <script>
            window.onload = CheckValueUser('${sessionScope.LOGIN_USER.userID}', '${pageContext.request.contextPath}/${sessionScope.LOGIN_USER != null ? "edit-profile" : "login"}', '${pageContext.request.contextPath}/home');
            setActiveMenuBar();
        </script>
        <script src="./js/CheckNetworkStatus.js"></script>
    </body>
</html>
