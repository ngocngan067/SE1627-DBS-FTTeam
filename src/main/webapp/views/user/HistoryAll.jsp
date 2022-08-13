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
        <title>History Booking | ${sessionScope.LOGIN_USER.fullName}</title>
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
        <link rel="stylesheet" href="./css/user/NavHistory.css" />
        <link rel="stylesheet" href="./css/user/History.css" />
        <link rel="stylesheet" href="./css/user/FooterPage.css" />
        <link rel="stylesheet" href="./css/user/SupportOnline.css" />
    </head>
    <body>
        <jsp:include page="../../layouts/ScrollBackToTop.html"></jsp:include>
        <jsp:include page="../../layouts/CheckNetworkStatus.html"></jsp:include>
        
        <c:if test="${FEEDBACK != null}">
            <section class="feedback">
                <div class="wrapper">
                    <button onclick="closePopupFeedback()" class="btn-exit">
                        <i class="fa-solid fa-xmark"></i>
                    </button>
                    <input type="radio" name="rate" id="star-1" value="1">
                    <input type="radio" name="rate" id="star-2" value="2">
                    <input type="radio" name="rate" id="star-3" value="3">
                    <input type="radio" name="rate" id="star-4" value="4">
                    <input type="radio" name="rate" id="star-5" value="5">
                    <div class="content">
                        <div class="outer">
                            <div class="emojis">
                                <li class="slideImg"><img src="./images/emoji-1.png" alt=""></li>
                                <li><img src="./images/emoji-2.png" alt=""></li>
                                <li><img src="./images/emoji-3.png" alt=""></li>
                                <li><img src="./images/emoji-4.png" alt=""></li>
                                <li><img src="./images/emoji-5.png" alt=""></li>
                            </div>
                        </div>
                        <div class="stars">
                            <label for="star-1" class="star-1 fas fa-star"></label>
                            <label for="star-2" class="star-2 fas fa-star"></label>
                            <label for="star-3" class="star-3 fas fa-star"></label>
                            <label for="star-4" class="star-4 fas fa-star"></label>
                            <label for="star-5" class="star-5 fas fa-star"></label>
                        </div>
                    </div>
                    <div class="footer">
                        <span class="text"></span>
                        <span class="numb"></span>
                    </div>

                    <div class="feedback--content">
                        <textarea name="" id="feedback-content" rows="5"
                            placeholder="Please share your experience of the service at your FreshTooth clinic!"></textarea>
                    </div>

                    <div class="btn-sent">
                        <button type="button" onclick="SentFeedBack()" class="button-29" role="button">Sent</button>
                    </div>
                </div>
            </section>
        </c:if>
        
        <header class="header-background">
            <jsp:include page="../../layouts/user/NavBar.jsp"></jsp:include>
        </header>
        
        <section class="bookingHistory mt-5">
            <div class="container-fluid">
                <jsp:include page="../../layouts/user/NavHistory.jsp"></jsp:include>

                <div class="pb-3 mb-2">
                    <c:if test="${BOOKING_LIST == null}">
                        <lottie-player src="https://assets4.lottiefiles.com/packages/lf20_xEak8Q.json" background="transparent" speed="1" loop autoplay style="width: 30%; position: relative; left: 50%; transform: translateX(-50%);"></lottie-player>
                    </c:if>
                    <c:if test="${BOOKING_LIST != null}">
                        <div class="row" id="return-list">
                            <c:forEach items="${BOOKING_LIST}" var="booking">
                                <div class="col-12 my-2 booking-amount">
                                    <div class="card-booking">
                                        <div class="booking--top">
                                            <div class="booking--id ps-2">
                                                <p>Appointment code: <span class="id">${booking.bookingID}</span></p>
                                                <p>|</p>
                                                <p>Booking date: <span><fmt:formatDate value="${booking.bookingDate}" pattern="dd-MM-yyyy"/></span></p>
                                            </div>
                                            <c:if test="${booking.bookingStatus == 0}">
                                                <button class="btn-delete" onclick="confirmDelete('${pageContext.request.contextPath}/history-booking-all', '${booking.bookingID}', '${booking.patientID}')">
                                                    <i class="fa-solid fa-xmark"></i>
                                                </button>
                                            </c:if>
                                            <c:if test="${FEEDBACK != null}">
                                                <button onclick="openPopupFeedback()" id="btnFeedback" class="btn-comment" data-bs-toggle="tooltip" data-bs-placement="top" title="Feedback">
                                                    <i class="fa-solid fa-comment-dots"></i>
                                                </button>
                                            </c:if>
                                        </div>

                                        <div class="booking--bottom p-3">
                                            <div class="bottom-img">
                                                <div class="booking--img">
                                                    <img src="data:image/png;base64,${booking.imageService}" alt="${booking.serviceName}">
                                                </div>
                                            </div>
                                            <div class="bottom-content">
                                                <p>Name: <span class="name-booking">${booking.fullName}</span></p>
                                                <p>Phone: <span class="phone">${booking.userPhone}</span></p>
                                                <p>Address: <span class="address">${booking.userAddress}</span></p>
                                                <p>
                                                    Service: <span class="service">${booking.serviceName}</span>
                                                </p>
                                                <p>
                                                    Slot Time: <span class="service"><fmt:formatDate type="time" value="${booking.slotStart}"/></span>
                                                </p>
                                                <c:if test="${booking.bookingNote != null}">
                                                    <p>
                                                        Note: <span class="note">${booking.bookingNote}</span>
                                                    </p>
                                                </c:if>
                                            </div>
                                        </div>

                                        <c:choose>
                                            <c:when test = "${booking.bookingStatus == 0}">
                                               <div class="status pending">
                                                    <p>Pending</p>
                                                </div>
                                            </c:when>

                                            <c:when test = "${booking.bookingStatus == 1}">
                                                <div class="status confirm">
                                                    <p>Confirm</p>
                                                </div>
                                            </c:when>
                                            <c:when test = "${booking.bookingStatus == 2}">
                                                <div class="status cancelled">
                                                    <p>Cancelled</p>
                                                </div>
                                            </c:when>
                                            <c:when test = "${booking.bookingStatus == 3}">
                                                <div class="status completed">
                                                    <p>Completed</p>
                                                </div>
                                            </c:when>
                                        </c:choose>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>

                        <c:if test="<%=totalCourses > 5%>">
                            <div class="btn--loadMore mt-3">
                                <button type="button" class="btn btn-primary" width="100px" onclick="LoadMoreButton('<%=totalCourses%>', '${pageContext.request.contextPath}/history-booking-all')">Show More</button>
                            </div>
                        </c:if>
                    </c:if>
                </div>
            </div>
        </section>
        
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
        <!-- Sweet Alert -->
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <!-- Lottie Files -->
        <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
        <!-- Script  -->
        <script src="./js/user/UserRoot.js"></script>
        <script src="./js/user/NavBar.js"></script>
        <script src="./js/user/History.js"></script>
        <script src="./js/user/NavHistory.js"></script>
        <script src="./js/ScrollBackToTop.js"></script>
        <script src="./js/CheckNetworkStatus.js"></script>
        <script>
            setActiveMenuBar();
            setActiveMenuBarHistory();
            
            <c:if test="${FEEDBACK != null}">
                window.onload = function () {
                    setTimeout(function () {
                        document.querySelector('.feedback').classList.add('open');
                    }, 1);
                };
                
                window.onclick = function (event) {
                    var modal = document.querySelector(".feedback");

                    if (event.target === modal) {
                        modal.classList.remove('open');
                    }
                };
                
                function closePopupFeedback() {
                    document.querySelector('.feedback').classList.remove('open');
                }

                function SentFeedBack() {
                    $.ajax({
                        url: "${pageContext.request.contextPath}/history-booking-completed",
                        type: "get",
                        data: {
                            ServiceID: "${FEEDBACK}",
                            UserID: "${sessionScope.LOGIN_USER.userID}",
                            ValueRate: $('.feedback input[name=rate]:checked').val(),
                            FeedbackContent: $('#feedback-content').val()
                        },
                        complete: function () {
                            closePopupFeedback();
                        }
                    });
                }
            </c:if>
        </script>
    </body>
</html>
