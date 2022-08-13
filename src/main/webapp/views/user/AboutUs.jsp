<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Fresh Tooth | About Us</title>
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
        <!-- LINK CSS -->
        <link rel="stylesheet" href="./css/user/UserRoot.css" />
        <link rel="stylesheet" href="./css/ScrollBackToTop.css" />
        <link rel="stylesheet" href="./css/CheckNetworkStatus.css" />
        <link rel="stylesheet" href="./css/user/NavBar.css" />
        <link rel="stylesheet" href="./css/user/AboutUs.css" />
        <link rel="stylesheet" href="./css/user/FooterPage.css" />
        <link rel="stylesheet" href="./css/user/SupportOnline.css" />
    </head>
    <body>
        <jsp:include page="../../layouts/ScrollBackToTop.html"></jsp:include>
        <jsp:include page="../../layouts/CheckNetworkStatus.html"></jsp:include>
        
        <header class="header-background">
            <jsp:include page="../../layouts/user/NavBar.jsp"></jsp:include>
        </header>
        
        <!-- BODY -->
        <section class="about-us">
            <div class="aboutUs-bg">
                <div class="aboutUs--img" style="background-image: url(./images/bllurred-background.jpg);"></div>
                <div class="aboutUs--content">
                    <h5>About us</h5>
                    <h1>GENERAL INFORMATION</h1>
                    <p>
                        Information about Fresh Tooth dental clinic brings the best patient experience.
                    </p>
                    <button onclick="window.location.href='${pageContext.request.contextPath}/service'" type="button" class="btn-co1">VIEW OUR SERVICE</button>
                    <button onclick="window.location.href='${pageContext.request.contextPath}/booking'" type="button" class="btn-co2">BOOK A SERVICE</button>
                </div>
            </div>

            <div class="aboutUs">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6 aboutUs__img">
                            <img src="./images/about-us-img-1.jpg" class="aboutUs__img-overflow" alt="">
                        </div>

                        <div class="col-lg-6 aboutUs__content ms-2 ms-md-0">
                            <div class="aboutUs--title pt-4">
                                <h6>About Us</h6>
                                <h2>Our dentists work the best for your needs</h2>
                                <p>
                                    Fresh Tooth is committed to providing customers with top quality service packages at the best cost in the market today. And provide detailed price list of dental services that are being applied.
                                </p>
                            </div>
                            <ul class="list--check">
                                <div class="list">
                                    <i class="far fa-check-circle"></i>
                                    <li>Help customers easily follow up</li>
                                </div>

                                <div class="list">
                                    <i class="far fa-check-circle"></i>
                                    <li> Easy service reference</li>
                                </div>

                                <div class="list">
                                    <i class="far fa-check-circle"></i>
                                    <li>Reputation guarantee</li>
                                </div>

                                <div class="list">
                                    <i class="far fa-check-circle"></i>
                                    <li>The team is always professional and enthusiastic</li>
                                </div>
                            </ul>

                            <button onclick="location.href='${pageContext.request.contextPath}/news'" class="gradient-btn mr-20 d-none d-md-block">LEARN MORE</button>
                        </div>
                    </div>
                </div>
            </div>

            <!------------- SPECIALIZED TEAM ------------->
            <section class="specialized" style="background-image: url(./images/background-3.jpg);">
                <div class="container">
                    <div class="row">
                        <div class=" col-12 col-md-6 specialized--contain">
                            <div data-aos="flip-left" data-aos-easing="ease-out-cubic" data-aos-duration="1500"
                                class="aboutUs specialized--title">
                                <h4>Fresh Tooth</h4>
                                <h2 class="our__services--title p-0 mb-0">Specialized Team</h2>
                            </div>

                            <div data-aos="zoom-in" data-aos-duration="2000" class="specialized--content">
                                <i class="fa-solid fa-quote-left"></i>
                                <p class=" px-0 px-xl-5">We are a team of dentists, hygienists and receptionists who work
                                    together to ensure that you
                                    receive the best treatment that you require at a very time that suits you.</p>
                                <i class="fa-solid fa-quote-right"></i>
                            </div>
                        </div>
                    </div>

                </div>
            </section>
            <!------------- END SPECIALIZED TEAM ------------->

            <!------------- DOCTOR TEAM ------------->
            <section class="doctorTeam">
                <div class="doctorTeam pb-2">
                    <div class="container">
                        <div class="row">
                            <c:forEach items="${DENTIST_LIST}" var="dentist">
                                <a href="${pageContext.request.contextPath}/dentist-detail?did=<c:out value="${dentist.value.dentistID}"/>" data-aos="flip-left" data-aos-duration="1500" class="d-flex justify-content-center pb-5 pb-lg-0 col-md-6 col-lg-3">
                                    <div class="card doctor--box">
                                        <img src="data:image/png;base64,<c:out value="${dentist.key.imageAvatar}"/>" class="card-img-top" alt="Qualified Doctor">
                                        <div class="card-body doctor-body">
                                            <h3><c:out value="${dentist.key.fullName}"/></h3>
                                            <p class="card-text"><c:out value="${dentist.value.skill}"/></p>
                                        </div>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </section>
            <!------------- END DOCTOR TEAM ------------->
        </section>
        <!-- END BODY -->
        
        <jsp:include page="../../layouts/user/FooterPage.jsp"></jsp:include>
        <jsp:include page="../../layouts/user/SupportOnline.jsp"></jsp:include>
        
        <!-- LINK BOOTSTRAP 5 -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
        <!-- JQUERY -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- AOS  -->
        <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
        <!-- Script  -->
        <script src="./js/user/UserRoot.js"></script>
        <script src="./js/user/NavBar.js"></script>
        <script src="./js/ScrollBackToTop.js"></script>
        <script src="./js/CheckNetworkStatus.js"></script>
        <script>
            setActiveMenuBar();
        </script>
    </body>
</html>
