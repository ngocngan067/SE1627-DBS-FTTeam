<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    int totalCourses = 0;
    if (request.getAttribute("TOTAL_BOOKING_LIST") != null) {
        totalCourses = (int) request.getAttribute("TOTAL_BOOKING_LIST");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Appointment</title>
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
        <!-- LINK CSS -->
        <link rel="stylesheet" href=".././css/dentist/DentistRoot.css" />
        <link rel="stylesheet" href=".././css/ScrollBackToTop.css" />
        <link rel="stylesheet" href=".././css/CheckNetworkStatus.css" />
        <link rel="stylesheet" href=".././css/dentist/NavBar.css" />
        <link rel="stylesheet" href=".././css/dentist/Appointment.css" />
    </head>
    <body>
        <jsp:include page="../../layouts/ScrollBackToTop.html"></jsp:include>
        <jsp:include page="../../layouts/CheckNetworkStatus.html"></jsp:include>
        
        <header class="header-background">
            <jsp:include page="../../layouts/dentist/NavBar.jsp"></jsp:include>
        </header>
        
        <section class="appointments my-5">
            <div class="container">
                <div class="row" id="return-list">
                    <div id="myModal" class="modal">
                        <div class="modal-content">
                            <span class="close">&times;</span>
                            <i class="mb-2">*Reason for canceling dental appointment:</i>
                            <textarea class="p-2" name="" id="" rows="5" placeholder="Please enter your reason"></textarea>

                            <div class="btn-confirm d-grid gap-2 col-6 mx-auto">
                                <button onclick="confirmButton('${pageContext.request.contextPath}/dentist/appointment')" type="button" class="confirmCancel btn btn-outline-primary mt-3">Confirm</button>
                            </div>
                        </div>
                    </div>
                    <c:if test="${APPOINTMENT_LIST == null}">
                        <div class="col-12">
                            <lottie-player src="https://assets4.lottiefiles.com/packages/lf20_xEak8Q.json" background="transparent" speed="1" loop autoplay style="width: 30%; position: relative; left: 50%; transform: translateX(-50%);"></lottie-player>
                        </div>
                    </c:if>
                    <c:if test="${APPOINTMENT_LIST != null}">
                        <c:forEach items="${APPOINTMENT_LIST}" var="appointment">
                            <div class="col-12 booking-amount">
                                <div class="card-appointment d-block d-md-flex disFlex my-2 p-4">
                                    <div class="card-start disFlex">
                                        <div class="card-left">
                                            <div class="appointments--avata">
                                                <img src="data:image/png;base64,${appointment.imageService}" alt="">
                                            </div>
                                        </div>

                                        <div class="middle--content">
                                            <div class="name">
                                                <h4>${appointment.fullName}</h4>
                                            </div>
                                            
                                            <div class="info gender">
                                                <i class="fa-solid fa-transgender"></i>
                                                <c:choose>
                                                    <c:when test = "${appointment.gender.equals('M')}">
                                                       <p>Gender: Male</p>
                                                    </c:when>

                                                    <c:when test = "${appointment.gender.equals('F')}">
                                                        <p>Gender: FeMale</p>
                                                    </c:when>
                                                </c:choose>
                                            </div>

                                            <div class="info dateOfBirth">
                                                <i class="fa-solid fa-calendar-days"></i>
                                                <p>Date Of Birth: <fmt:formatDate value="${appointment.dateOfBirth}" pattern="dd-MM-yyyy"/></p>
                                            </div>

                                            <div class="info phoneNumber">
                                                <i class="fa-solid fa-mobile-screen"></i>
                                                <p>Phone Number: ${appointment.phoneNumber}</p>
                                            </div>

                                            <div class="info mail">
                                                <i class="fa-solid fa-envelope"></i>
                                                <p>Email: ${appointment.email}</p>
                                            </div>

                                            <div class="info address">
                                                <i class="fa-solid fa-location-dot"></i>
                                                <p>Address: ${appointment.address}</p>
                                            </div>
                                            
                                            <div class="info serviceName">
                                                <i class="fa-solid fa-wrench"></i>
                                                <p>Service Name: ${appointment.serviceName}</p>
                                            </div>
                                            
                                            <div class="info bookingDate">
                                                <i class="fa-solid fa-calendar-days"></i>
                                                <p>Booking Date: <fmt:formatDate value="${appointment.bookingDate}" pattern="dd-MM-yyyy"/></p>
                                            </div>
                                            
                                            <div class="info slotStart">
                                                <i class="fa-solid fa-clock"></i>
                                                <p>Slot Start: <fmt:formatDate type="time" value="${appointment.slotStart}"/></p>
                                            </div>
                                            
                                            <div class="info bookingCreated">
                                                <i class="fa-solid fa-calendar-days"></i>
                                                <p>Booking Created: <fmt:formatDate value="${appointment.bookingCreated}" pattern="dd-MM-yyyy"/></p>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="card-right mt-3 mt-md-0">
                                        <div class="right--button disFlex">
                                            <c:choose>
                                                <c:when test = "${appointment.bookingStatus == 0}">
                                                   <button onclick="confirmAccept('${pageContext.request.contextPath}/dentist/appointment', '${appointment.bookingID}')" class="info card__button btn--accept">
                                                        <i class="fa-solid fa-check"></i>
                                                        <p>Accept</p>
                                                    </button>

                                                    <button onclick="confirmCancel('${appointment.bookingID}')" class="info card__button btn--cancel">
                                                        <i class="fa-solid fa-xmark"></i>
                                                        <p>Cancel</p>
                                                    </button>
                                                </c:when>

                                                <c:when test = "${appointment.bookingStatus == 1}">
                                                    <button onclick="confirmDone('${pageContext.request.contextPath}/dentist/appointment', '${appointment.bookingID}')" class="info card__button btn--done">
                                                        <i class="fa-solid fa-circle-check"></i>
                                                        <p>Done</p>
                                                    </button>

                                                    <button onclick="confirmCancel('${appointment.bookingID}')" class="info card__button btn--cancel">
                                                        <i class="fa-solid fa-xmark"></i>
                                                        <p>Cancel</p>
                                                    </button>
                                                </c:when>
                                                
                                                <c:when test = "${appointment.bookingStatus == 2}">
                                                    <button class="info card__button btn--cancel" disabled>
                                                        <i class="fa-solid fa-xmark"></i>
                                                        <p>Cancel</p>
                                                    </button>
                                                </c:when>
                                                    
                                                <c:otherwise>
                                                    <button class="info card__comple btn--completed" disabled>
                                                        <i class="fa-solid fa-circle-check"></i>
                                                        <p>Completed</p>
                                                    </button>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>
                    
<!--                    <div class="col-12 mt-3">
                        <div class="btn--loadMore">
                            <button onclick="LoadMoreButton('<%=totalCourses%>', '${pageContext.request.contextPath}/dentist/appointment')" type="button" class="btn btn-primary" width="100px">Show More</button>
                        </div>
                    </div>-->
                </div>
            </div>
        </section>
        
        <!-- LINK BOOTSTRAP 5 -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
        <!-- J QUERY -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- Lottie Files -->
        <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
        <!-- Sweet Alert -->
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <!-- Script  -->
        <script src=".././js/dentist/DentistRoot.js"></script>
        <script src=".././js/dentist/Appointment.js"></script>
        <script src=".././js/ScrollBackToTop.js"></script>
        <script src=".././js/CheckNetworkStatus.js"></script>
    </body>
</html>
