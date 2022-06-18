<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Fresh Tooth | Home</title>
        <!-- TẠO ICON TRÊN THANH WEB -->
        <link rel="icon" href="./images/iconFT.png" type="image/png" sizes="200x138" />
        <!-- LINK BOOTSTRAP 5 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" />
        <!-- LINK FONTAWESOME -->
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
        <link rel="stylesheet" href="./css/user/Home.css" />
        <link rel="stylesheet" href="./css/user/FooterPage.css" />
        <link rel="stylesheet" href="./css/user/SupportOnline.css" />
    </head>
    <body>
        <jsp:include page="../../layouts/ScrollBackToTop.html"></jsp:include>
        <jsp:include page="../../layouts/CheckNetworkStatus.html"></jsp:include>
        
        <header class="header-top">
            <jsp:include page="../../layouts/user/NavBar.jsp"></jsp:include>
        </header>
        
        <!------------- HEADER BODY ------------->
        <div class="d-none d-xxl-flex container__home" style="background-image: url(./images/background.png);">
            <div class="content--home">
                <a href="" class="btn--login">
                    <script>document.write(new Date().getFullYear());</script> Collections
                </a>
                <h1>You should always<br>feel confident</h1>
                <p>A better life starts with a beautiful smile.</p>
            </div>

            <img src="./images/basi.png" alt="" class="doctor-img">
        </div>

        <div class="d-flex d-xxl-none container__home container__home--responsive"
            style="background-image: url(./images/background3.jpg);">
            <div class="content--home">
                <a href="" class="btn--login">
                    <script>document.write(new Date().getFullYear());</script> Collections
                </a>
                <h1>You should always feel confident</h1>
                <p>A better life starts with a beautiful smile.</p>
            </div>

            <img src="./images/basi.png" alt="" class="doctor-img">
        </div>
        <!------------- END HEADER BODY ------------->
        
        <!------------- DENTAL CLINIC INFORMATION  ------------->
        <section class="clinic--infor" style="background-image: url(./images/bgFT2.png);">
            <div class="dental--clinic">
                <div class="container">
                    <div class="row">
                        <div data-aos="zoom-in-up" data-aos-duration="1500" data-aos-offset="150"
                            class="col-12 col-md-6 col-lg-4 pb-5">
                            <div class="card" style="height:26rem;">
                                <a href="">
                                    <div class="card-body card-content pt-5">
                                        <h1>1-800-600-380</h1>
                                        <h3 class="card-title">EMERGENCY SERVICE</h3>
                                        <p class="card-text">Aliquam erat volutpat. Nullam imperdiet sapien felis, non
                                            lobortis
                                            odio mattis in. Quisque dapibus aliquet dictum. Integer dapibus ullamcorper est,
                                            ac
                                            .</p>
                                        <div class="detal--btn">
                                            <a href="#" class="detail--button">See More</a>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div data-aos="zoom-in-up" data-aos-duration="1500" data-aos-offset="150"
                            class="col-12 col-md-6 col-lg-4 pb-5">
                            <div class="card" style="height:26rem;">
                                <a href="">
                                    <div class="card-body card-content pt-5">
                                        <i class="fa-solid fa-calendar-days"></i>
                                        <h3 class="card-title">DO YOU WANT TO MAKE AN APPOINTMENT</h3>
                                        <p class="card-text">Aliquam erat volutpat. Nullam imperdiet sapien felis, non
                                            lobortis
                                            odio mattis in. Quisque dapibus aliquet dictum.
                                        </p>
                                        <div class="detal--btn">
                                            <a href="#" class="detail--button">Book Now</a>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div data-aos="zoom-in-up" data-aos-duration="1500" data-aos-offset="150"
                            class="col-12 col-md-6 col-lg-4 pb-5">
                            <div class="card" style="height:26rem;">
                                <a href="">
                                    <div class="card-body card-content pt-5">
                                        <i class="fa-solid fa-clock"></i>
                                        <h3 class="card-title">OPENING HOURS</h3>
                                        <p class="card-text">Monday – Friday</p>
                                        <p class="card-text">Saturtay – Sunday</p>
                                        <div class="detal--btn">
                                            <a href="#" class="detail--button">Contact Us</a>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!------------- END DENTAL CLINIC INFORMATION ------------->
        
        <!------------- OUR SERVICES ------------->
        <section class="our__services pb-5" style="background-image: url(./images/bgFT4.png);">
            <h2 data-aos="fade-up" data-aos-anchor-placement="top-bottom" data-aos-duration="1100"
                class="our__services--title">our <span>services</span></h2>

            <div class="container-fluid">
                <div class="row">
                    <div data-aos="fade-up" data-aos-anchor-placement="center-bottom" data-aos-duration="1500"
                        class="d-flex justify-content-center pb-5 pb-lg-0 col-md-6 col-lg-3">
                        <div class="card service--box">
                            <img src="./images/medical_care_movn.svg" class="card-img-top" alt="Best Treatment">
                            <div class="card-body box-body">
                                <h4>Best Treatment</h4>
                                <p class="card-text">Molestiae Iure Assumenda Cumque Perferendis Ad Libero Excepturi Amet Ex
                                    Aliquid Harum Velit Repellat Quaerat In. Amet, Unde!</p>
                            </div>
                        </div>
                    </div>

                    <div data-aos="fade-up" data-aos-anchor-placement="center-bottom" data-aos-duration="1500"
                        class="d-flex justify-content-center pb-5 pb-lg-0 col-md-6 col-lg-3">
                        <div class="card service--box">
                            <img src="./images/medicine_b-1-ol.svg" class="card-img-top" alt="Emergency Help">
                            <div class="card-body box-body">
                                <h4>Emergency Help</h4>
                                <p class="card-text">Molestiae Iure Assumenda Cumque Perferendis Ad Libero Excepturi Amet Ex
                                    Aliquid Harum Velit Repellat Quaerat In. Amet, Unde!</p>
                            </div>
                        </div>
                    </div>

                    <div data-aos="fade-up" data-aos-anchor-placement="center-bottom" data-aos-duration="1500"
                        class="d-flex justify-content-center pb-5 pb-lg-0 col-md-6 col-lg-3">
                        <div class="card service--box">
                            <img src="./images/treatment.svg" class="card-img-top" alt="Medical Staff">
                            <div class="card-body box-body">
                                <h4>Medical Staff</h4>
                                <p class="card-text">Molestiae Iure Assumenda Cumque Perferendis Ad Libero Excepturi Amet Ex
                                    Aliquid Harum Velit Repellat Quaerat In. Amet, Unde!</p>
                            </div>
                        </div>
                    </div>

                    <div data-aos="fade-up" data-aos-anchor-placement="center-bottom" data-aos-duration="1500"
                        class="d-flex justify-content-center pb-5 pb-lg-0 col-md-6 col-lg-3">
                        <div class="card service--box">
                            <img src="./images/doctor_kw-5-l.svg" class="card-img-top" alt="Qualified Doctor">
                            <div class="card-body box-body">
                                <h4>Qualified Doctor</h4>
                                <p class="card-text">Molestiae Iure Assumenda Cumque Perferendis Ad Libero Excepturi Amet Ex
                                    Aliquid Harum Velit Repellat Quaerat In. Amet, Unde!</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!------------- END OUR SERVICES ------------->
        
        <!------------- SPECIALIZED TEAM ------------->
        <section class="specialized" style="background-image: url(./images/background-3.jpg);">
            <div class="container">
                <div class="row">
                    <div class=" col-12 col-md-6 specialized--contain">
                        <div data-aos="flip-left" data-aos-easing="ease-out-cubic" data-aos-duration="1500"
                            class="specialized--title">
                            <h4>Fresh Tooth</h4>
                            <h1 class="our__services--title p-0">Specialized Team</h1>
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
        <section class="doctorTeam" style="background-image: url(./images/bgFT3.png);">
            <div class="doctorTeam pb-2">
                <div class="container">
                    <div class="row">
                        <div data-aos="flip-left" data-aos-duration="1500"
                            class="d-flex justify-content-center pb-5 pb-lg-0 col-md-6 col-lg-3">
                            <div class="card doctor--box">
                                <img src="./images/people-01.jpg" class="card-img-top" alt="Qualified Doctor">
                                <div class="card-body doctor-body">
                                    <h3>Alex Terrel</h3>
                                    <small>Senior Orthodontist</small>
                                    <p class="card-text">Appropriately empower dynamic leadership skills after business
                                        portals. Globally myocardinate interactive supply chains with quality.</p>
                                    <div class="card-social">
                                        <div class="social-link">
                                            <a href="" class="card-social__facebook">
                                                <i class="fa-brands fa-facebook-f"></i>
                                            </a>
                                        </div>
                                        <div class="social-link">
                                            <a href="" class="card-social__twitter">
                                                <i class="fa-brands fa-twitter"></i>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div data-aos="flip-left" data-aos-duration="1500"
                            class="d-flex justify-content-center pb-5 pb-lg-0 col-md-6 col-lg-3">
                            <div class="card doctor--box">
                                <img src="./images/people-02.jpg" class="card-img-top" alt="Qualified Doctor">
                                <div class="card-body doctor-body">
                                    <h3>Michél Anderson</h3>
                                    <small>Pediatric Dentist</small>
                                    <p class="card-text">Enthusiastically mesh long-term high-impact infrastructures
                                        vis-a-vis efficient customer service leadership rather than prospective experiences.
                                    </p>
                                    <div class="card-social">
                                        <div class="social-link">
                                            <a href="" class="card-social__facebook">
                                                <i class="fa-brands fa-facebook-f"></i>
                                            </a>
                                        </div>
                                        <div class="social-link">
                                            <a href="" class="card-social__twitter">
                                                <i class="fa-brands fa-twitter"></i>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div data-aos="flip-left" data-aos-duration="1500"
                            class="d-flex justify-content-center pb-5 pb-lg-0 col-md-6 col-lg-3">
                            <div class="card doctor--box">
                                <img src="./images/people-03.jpg" class="card-img-top" alt="Qualified Doctor">
                                <div class="card-body doctor-body">
                                    <h3>Pediatric Dentist</h3>
                                    <small>Senior Prosthodontist</small>
                                    <p class="card-text">Objectively integrate enterprise-wide strategic theme areas with
                                        good infrastructures. Interactively productize premium technologies.</p>
                                    <div class="card-social">
                                        <div class="social-link">
                                            <a href="" class="card-social__facebook">
                                                <i class="fa-brands fa-facebook-f"></i>
                                            </a>
                                        </div>
                                        <div class="social-link">
                                            <a href="" class="card-social__twitter">
                                                <i class="fa-brands fa-twitter"></i>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div data-aos="flip-left" data-aos-duration="1500"
                            class="d-flex justify-content-center pb-5 pb-lg-0 col-md-6 col-lg-3">
                            <div class="card doctor--box">
                                <img src="./images/people-04.jpg" class="card-img-top" alt="Qualified Doctor">
                                <div class="card-body doctor-body">
                                    <h3>Carlie Addison</h3>
                                    <small>Dental Nurse</small>
                                    <p class="card-text">Uniquely deploy cross-unit benefits with wireless testing
                                        procedures. Build backward compatible relationships whereas tactical paradigms.</p>
                                    <div class="card-social">
                                        <div class="social-link">
                                            <a href="" class="card-social__facebook">
                                                <i class="fa-brands fa-facebook-f"></i>
                                            </a>
                                        </div>
                                        <div class="social-link">
                                            <a href="" class="card-social__twitter">
                                                <i class="fa-brands fa-twitter"></i>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!------------- END DOCTOR TEAM ------------->
        
        <!------------- LIST TOOTH ------------->
        <section class="listTooth">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-lg-4">
                        <!--== Start Services Box Item ==-->
                        <div class="service-box" data-aos="fade-up">
                            <div class="inner-content">
                                <div class="icon">
                                    <img src="./images/s1.webp" width="68" height="72" alt="Image-HasTech">
                                </div>
                                <div class="content">
                                    <h4 class="title"><a href="service-details.html">General Dentistry</a></h4>
                                    <p>Dental care is the maintenance teeth the practice of keeping mouth clean sue pleasure
                                        rationally encounter</p>
                                </div>
                            </div>
                        </div>
                        <!--== End Services Box Item ==-->
                    </div>
                    <div class="col-sm-6 col-lg-4">
                        <!--== Start Services Box Item ==-->
                        <div class="service-box" data-aos="fade-up">
                            <div class="inner-content">
                                <div class="icon">
                                    <img src="./images/s2.webp" width="82" height="72" alt="Image-HasTech">
                                </div>
                                <div class="content">
                                    <h4 class="title"><a href="service-details.html">Cosmetic Braces</a></h4>
                                    <p>Dental care is the maintenance teeth the practice of keeping mouth clean sue pleasure
                                        rationally encounter</p>
                                </div>
                            </div>
                        </div>
                        <!--== End Services Box Item ==-->
                    </div>
                    <div class="col-sm-6 col-lg-4">
                        <!--== Start Services Box Item ==-->
                        <div class="service-box" data-aos="fade-up">
                            <div class="inner-content">
                                <div class="icon">
                                    <img src="./images/s3.webp" width="64" height="72" alt="Image-HasTech">
                                </div>
                                <div class="content">
                                    <h4 class="title"><a href="service-details.html">Prediatic Dentistry</a></h4>
                                    <p>Dental care is the maintenance teeth the practice of keeping mouth clean sue pleasure
                                        rationally encounter</p>
                                </div>
                            </div>
                        </div>
                        <!--== End Services Box Item ==-->
                    </div>
                    <div class="col-sm-6 col-lg-4">
                        <!--== Start Services Box Item ==-->
                        <div class="service-box" data-aos="fade-up" data-aos-delay="100">
                            <div class="inner-content">
                                <div class="icon">
                                    <img src="./images/s4.webp" width="77" height="72" alt="Image-HasTech">
                                </div>
                                <div class="content">
                                    <h4 class="title"><a href="service-details.html">Dental Bridge</a></h4>
                                    <p>Dental care is the maintenance teeth the practice of keeping mouth clean sue pleasure
                                        rationally encounter</p>
                                </div>
                            </div>
                        </div>
                        <!--== End Services Box Item ==-->
                    </div>
                    <div class="col-sm-6 col-lg-4">
                        <!--== Start Services Box Item ==-->
                        <div class="service-box" data-aos="fade-up" data-aos-delay="100">
                            <div class="inner-content">
                                <div class="icon">
                                    <img src="./images/s5.webp" width="87" height="72" alt="Image-HasTech">
                                </div>
                                <div class="content">
                                    <h4 class="title"><a href="service-details.html">Oral Surgery</a></h4>
                                    <p>Dental care is the maintenance teeth the practice of keeping mouth clean sue pleasure
                                        rationally encounter</p>
                                </div>
                            </div>
                        </div>
                        <!--== End Services Box Item ==-->
                    </div>
                    <div class="col-sm-6 col-lg-4">
                        <!--== Start Services Box Item ==-->
                        <div class="service-box" data-aos="fade-up" data-aos-delay="100">
                            <div class="inner-content">
                                <div class="icon">
                                    <img src="./images/s6.webp" width="89" height="70" alt="Image-HasTech">
                                </div>
                                <div class="content">
                                    <h4 class="title"><a href="service-details.html">Root Canals</a></h4>
                                    <p>Dental care is the maintenance teeth the practice of keeping mouth clean sue pleasure
                                        rationally encounter</p>
                                </div>
                            </div>
                        </div>
                        <!--== End Services Box Item ==-->
                    </div>
                </div>
            </div>
        </section>
        <!------------- END LIST TOOTH ------------->
        
        <jsp:include page="../../layouts/user/FooterPage.jsp"></jsp:include>
        <jsp:include page="../../layouts/user/SupportOnline.jsp"></jsp:include>
        
        <!-- LINK BOOTSTRAP 5 -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
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
    </body>
</html>
