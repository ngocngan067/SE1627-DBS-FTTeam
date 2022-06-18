<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Fresh Tooth | News</title>
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
        <link rel="stylesheet" href="./css/user/News.css" />
        <link rel="stylesheet" href="./css/user/FooterPage.css" />
        <link rel="stylesheet" href="./css/user/SupportOnline.css" />
    </head>
    <body>
        <jsp:include page="../../layouts/ScrollBackToTop.html"></jsp:include>
        <jsp:include page="../../layouts/CheckNetworkStatus.html"></jsp:include>
        
        <header class="header-background">
            <jsp:include page="../../layouts/user/NavBar.jsp"></jsp:include>
        </header>
        
        <!------------- BODY ----------------->
        <main id="main">
            <!-- ======= Blog Page ======= -->
            <div class="blog-page area-21 pt-5">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4 col-md-4">
                            <div class="page-head-blog">
                                <div class="single-blog-page">
                                    <!-- search option start -->
                                    <form action="#">
                                        <div class="search-option">
                                            <input type="text" placeholder="Search...">
                                            <button class="button" type="submit">
                                                <i class="bi bi-search"></i>
                                            </button>
                                        </div>
                                    </form>
                                    <!-- search option end -->
                                </div>
                                <div class="single-blog-page">
                                    <!-- recent start -->
                                    <div class="left-blog">
                                        <h4>recent post</h4>
                                        <div class="recent-post">
                                            <!-- start single post -->
                                            <div class="recent-single-post">
                                                <div class="post-img">
                                                    <a href="#">
                                                        <img src="./images/1.jpg" alt="">
                                                    </a>
                                                </div>
                                                <div class="pst-content">
                                                    <p><a href="#"> Redug Lerse dolor sit amet consect adipis elit.</a></p>
                                                </div>
                                            </div>
                                            <!-- End single post -->
                                            <!-- start single post -->
                                            <div class="recent-single-post">
                                                <div class="post-img">
                                                    <a href="#">
                                                        <img src="./images/2.jpg" alt="">
                                                    </a>
                                                </div>
                                                <div class="pst-content">
                                                    <p><a href="#"> Redug Lerse dolor sit amet consect adipis elit.</a></p>
                                                </div>
                                            </div>
                                            <!-- End single post -->
                                            <!-- start single post -->
                                            <div class="recent-single-post">
                                                <div class="post-img">
                                                    <a href="#">
                                                        <img src="./images/3.jpg" alt="">
                                                    </a>
                                                </div>
                                                <div class="pst-content">
                                                    <p><a href="#"> Redug Lerse dolor sit amet consect adipis elit.</a></p>
                                                </div>
                                            </div>
                                            <!-- End single post -->
                                            <!-- start single post -->
                                            <div class="recent-single-post">
                                                <div class="post-img">
                                                    <a href="#">
                                                        <img src="./images/4.jpg" alt="">
                                                    </a>
                                                </div>
                                                <div class="pst-content">
                                                    <p><a href="#"> Redug Lerse dolor sit amet consect adipis elit.</a></p>
                                                </div>
                                            </div>
                                            <!-- End single post -->
                                        </div>
                                    </div>
                                    <!-- recent end -->
                                </div>
                                <div class="single-blog-page">
                                    <div class="left-blog">
                                        <h4>categories</h4>
                                        <ul>
                                            <li>
                                                <a href="#">Portfolio</a>
                                            </li>
                                            <li>
                                                <a href="#">Project</a>
                                            </li>
                                            <li>
                                                <a href="#">Design</a>
                                            </li>
                                            <li>
                                                <a href="#">wordpress</a>
                                            </li>
                                            <li>
                                                <a href="#">Joomla</a>
                                            </li>
                                            <li>
                                                <a href="#">Html</a>
                                            </li>
                                            <li>
                                                <a href="#">Website</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="single-blog-page">
                                    <div class="left-blog">
                                        <h4>archive</h4>
                                        <ul>
                                            <li>
                                                <a href="#">07 July 2016</a>
                                            </li>
                                            <li>
                                                <a href="#">29 June 2016</a>
                                            </li>
                                            <li>
                                                <a href="#">13 May 2016</a>
                                            </li>
                                            <li>
                                                <a href="#">20 March 2016</a>
                                            </li>
                                            <li>
                                                <a href="#">09 Fabruary 2016</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="single-blog-page">
                                    <div class="left-tags blog-tags">
                                        <div class="popular-tag left-side-tags left-blog">
                                            <h4>popular tags</h4>
                                            <ul>
                                                <li>
                                                    <a href="#">Portfolio</a>
                                                </li>
                                                <li>
                                                    <a href="#">Project</a>
                                                </li>
                                                <li>
                                                    <a href="#">Design</a>
                                                </li>
                                                <li>
                                                    <a href="#">Website</a>
                                                </li>
                                                <li>
                                                    <a href="#">Joomla</a>
                                                </li>
                                                <li>
                                                    <a href="#">Html</a>
                                                </li>
                                                <li>
                                                    <a href="#">wordpress</a>
                                                </li>
                                                <li>
                                                    <a href="#">Masonry</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- End left sidebar -->
                        <!-- Start single blog -->
                        <div class="col-md-8 col-sm-8 col-xs-12">
                            <div class="row">
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="single-blog">
                                        <div class="single-blog-img">
                                            <a href="blog-details.html">
                                                <img src="./images/1.jpg" alt="">
                                            </a>
                                        </div>
                                        <div class="blog-meta">
                                            <span class="comments-type">
                                                <i class="bi bi-chat"></i>
                                                <a href="#">11 comments</a>
                                            </span>
                                            <span class="date-type">
                                                <i class="bi bi-calendar"></i>2016-03-05 / 09:10:16
                                            </span>
                                        </div>
                                        <div class="blog-text">
                                            <h4>
                                                <a href="#">Post my imagine Items</a>
                                            </h4>
                                            <p>
                                                Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla
                                                mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget
                                                bibendum sodales, augue velit.
                                            </p>
                                        </div>
                                        <span>
                                            <a href="blog-details.html" class="ready-btn">Read more</a>
                                        </span>
                                    </div>
                                </div>
                                <!-- End single blog -->
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="single-blog">
                                        <div class="single-blog-img">
                                            <a href="blog-details.html">
                                                <img src="./images/2.jpg" alt="">
                                            </a>
                                        </div>
                                        <div class="blog-meta">
                                            <span class="comments-type">
                                                <i class="bi bi-chat"></i>
                                                <a href="#">7 comments</a>
                                            </span>
                                            <span class="date-type">
                                                <i class="bi bi-calendar"></i>2016-03-05 / 09:10:16
                                            </span>
                                        </div>
                                        <div class="blog-text">
                                            <h4>
                                                <a href="#">Post my imagine Items</a>
                                            </h4>
                                            <p>
                                                Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla
                                                mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget
                                                bibendum sodales, augue velit.
                                            </p>
                                        </div>
                                        <span>
                                            <a href="blog-details.html" class="ready-btn">Read more</a>
                                        </span>
                                    </div>
                                </div>
                                <!-- Start single blog -->
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="single-blog">
                                        <div class="single-blog-img">
                                            <a href="blog-details.html">
                                                <img src="./images/3.jpg" alt="">
                                            </a>
                                        </div>
                                        <div class="blog-meta">
                                            <span class="comments-type">
                                                <i class="bi bi-chat"></i>
                                                <a href="#">13 comments</a>
                                            </span>
                                            <span class="date-type">
                                                <i class="bi bi-calendar"></i>2016-03-05 / 09:10:16
                                            </span>
                                        </div>
                                        <div class="blog-text">
                                            <h4>
                                                <a href="#">Post my imagine Items</a>
                                            </h4>
                                            <p>
                                                Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla
                                                mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget
                                                bibendum sodales, augue velit.
                                            </p>
                                        </div>
                                        <span>
                                            <a href="blog-details.html" class="ready-btn">Read more</a>
                                        </span>
                                    </div>
                                </div>
                                <!-- End single blog -->
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="single-blog">
                                        <div class="single-blog-img">
                                            <a href="blog-details.html">
                                                <img src="./images/4.jpg" alt="">
                                            </a>
                                        </div>
                                        <div class="blog-meta">
                                            <span class="comments-type">
                                                <i class="bi bi-chat"></i>
                                                <a href="#">1 comments</a>
                                            </span>
                                            <span class="date-type">
                                                <i class="bi bi-calendar"></i>2016-03-05 / 09:10:16
                                            </span>
                                        </div>
                                        <div class="blog-text">
                                            <h4>
                                                <a href="#">Post my imagine Items</a>
                                            </h4>
                                            <p>
                                                Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla
                                                mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget
                                                bibendum sodales, augue velit.
                                            </p>
                                        </div>
                                        <span>
                                            <a href="blog-details.html" class="ready-btn">Read more</a>
                                        </span>
                                    </div>
                                </div>
                                <!-- Start single blog -->
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="single-blog">
                                        <div class="single-blog-img">
                                            <a href="blog-details.html">
                                                <img src="./images/5.jpg" alt="">
                                            </a>
                                        </div>
                                        <div class="blog-meta">
                                            <span class="comments-type">
                                                <i class="bi bi-chat"></i>
                                                <a href="#">10 comments</a>
                                            </span>
                                            <span class="date-type">
                                                <i class="bi bi-calendar"></i>2016-03-05 / 09:10:16
                                            </span>
                                        </div>
                                        <div class="blog-text">
                                            <h4>
                                                <a href="#">Post my imagine Items</a>
                                            </h4>
                                            <p>
                                                Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla
                                                mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget
                                                bibendum sodales, augue velit.
                                            </p>
                                        </div>
                                        <span>
                                            <a href="blog-details.html" class="ready-btn">Read more</a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Blog Page -->
        </main>
        <!------------- END BODY ------------->
        
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
