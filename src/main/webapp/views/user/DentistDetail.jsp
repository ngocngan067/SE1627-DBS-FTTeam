<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>${ACCOUNT_DETAIL.fullName}</title>
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
        <link rel="stylesheet" href="./css/user/DentistDetail.css" />
        <link rel="stylesheet" href="./css/user/FooterPage.css" />
        <link rel="stylesheet" href="./css/user/SupportOnline.css" />
    </head>
    <body>
        <jsp:include page="../../layouts/ScrollBackToTop.html"></jsp:include>
        <jsp:include page="../../layouts/CheckNetworkStatus.html"></jsp:include>
        
        <header class="header-background">
            <jsp:include page="../../layouts/user/NavBar.jsp"></jsp:include>
        </header>
        
        <!-- Doctor Profile Start -->
        <section class="doctor-detail">
            <div class="container-fluid" style="background-image: url(./images/bgn-doctor.jpg);"></div>

            <div class="container-fluid background" style="background-image: url(./images/post-27.jpg);">
                <div class="background-color"></div>
            </div>

            <div class="container container-top">
                <div class="row">
                    <div class="col-lg-5 slideInLeft">
                        <img src="data:image/png;base64,${ACCOUNT_DETAIL.imageAvatar}" alt="" srcset="" width="100%">
                    </div>
                    <div class="col-lg-7 slideInRight">
                        <div class="mt-lg-5">
                            <h1 class="doctor-name">${ACCOUNT_DETAIL.fullName}</h1>
                            <p style="padding-right: 20px;">${DENTIST_DETAIL.skill}</p>
                            <hr style="width: 90%;">
                        </div>
                    </div>
                </div>
            </div>

            <div class="container">
                <div class="row">
                    <div class="col-lg-4 mt-5 explain">
                        <div class="work-box">
                            <p class="consult">Consult ${ACCOUNT_DETAIL.fullName}</p>
                            <hr class="table-hr">
                            <div class="calling-us mt-4 mb-4 row">
                                <div class="col-4 icon-calling-us">
                                    <i class="fa-solid fa-mobile-button"></i>
                                </div>
                                <div class="phone-number col-8">
                                    <p class="text-calling-us">Call Us Anytime</p>
                                    <p class="phone-number-1">${ACCOUNT_DETAIL.userPhone}</p>
                                </div>
                            </div>
                            <hr class="table-hr">
                            <div class="email-us mt-4 mb-4 row">
                                <div class="col-4 icon-email-us">
                                    <i class="fa-solid fa-envelope-open-text"></i>
                                </div>
                                <div class="email-address col-8">
                                    <p class="text-email-us">Email us</p>
                                    <p class="email-address-1">${ACCOUNT_DETAIL.userEmail}</p>
                                </div>
                            </div>
                            <hr class="table-hr">
                            <div class="dr-year-experience row mt-4">
                                <div class="col-4 icon-year-experience">
                                    <i class="fa-solid fa-briefcase"></i>
                                </div>
                                <div class="col-8 year-experience">
                                    <p class="text-year-experience">Years Experience</p>
                                    <p class="number-year-experience">${DENTIST_DETAIL.yearsOfExp}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-8 mt-5 explain-second">${DENTIST_DETAIL.descriptionDentist}</div>
                </div>
            </div>
        </section>
        <!-- Doctor Profile End -->
        
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
        <script src="./js/user/DentistDetail.js"></script>
        <script src="./js/ScrollBackToTop.js"></script>
        <script src="./js/CheckNetworkStatus.js"></script>
        <script>
            setActiveMenuBar();
        </script>
    </body>
</html>
