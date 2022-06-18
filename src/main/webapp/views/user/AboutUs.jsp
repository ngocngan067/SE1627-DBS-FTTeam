<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <!-- Malihu Custom Scrollbar -->
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.3/jquery.mCustomScrollbar.min.css'>
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
                    <p>Praesent venenatis lobortis volutpat. Curabitur ultricies ex vel mi ornare fringilla. Aenean luctus
                        orci ac tellus rutrum posuere. Curabitur sit amet varius erat. Morbi placerat, nulla eu iaculis
                        condimentum.</p>
                    <button type="button" class="btn-co1">VIEW OUR SERVICE</button>
                    <button type="button" class="btn-co2">BOOK A SERVICE</button>
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
                                <p>Duis sed odio sit amet nibh vulputate cursus a sit am maur Morbi accumsan ipsum velit.
                                    Nam nec tellus a od tincidunt auctor a ornare odio sed. Cum prima putant equidem an. Eu
                                    his harum everti aeterno. Quod corpora referrentur quis.</p>
                            </div>
                            <ul class="list--check">
                                <div class="list">
                                    <i class="far fa-check-circle"></i>
                                    <li>Proin gravida nibh velit auctor</li>
                                </div>

                                <div class="list">
                                    <i class="far fa-check-circle"></i>
                                    <li>Aenean sollicitudin, lorem quis</li>
                                </div>

                                <div class="list">
                                    <i class="far fa-check-circle"></i>
                                    <li>Nisi elit consequat ipsum quam</li>
                                </div>

                                <div class="list">
                                    <i class="far fa-check-circle"></i>
                                    <li>Sem nibh id eliet duis sed odio</li>
                                </div>
                            </ul>

                            <button class="gradient-btn mr-20 d-none d-md-block">LEARN MORE</button>
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
                                <h4>FreshTooth</h4>
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
                                            vis-a-vis efficient customer service leadership rather than prospective
                                            experiences.
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
                                        <p class="card-text">Objectively integrate enterprise-wide strategic theme areas
                                            with
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
                                            procedures. Build backward compatible relationships whereas tactical paradigms.
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
        <!-- Malihu Custom Scrollbar -->
        <script src='https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.3/jquery.mCustomScrollbar.concat.min.js'></script>
        <!-- Script  -->
        <script src="./js/user/UserRoot.js"></script>
        <script src="./js/ScrollBackToTop.js"></script>
        <script src="./js/CheckNetworkStatus.js"></script>
        <script>
            setActiveMenuBar();
        </script>
    </body>
</html>
