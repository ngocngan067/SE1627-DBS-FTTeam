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
        <!-- LINK BOOTSTRAP ICON -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
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
            <div class="blog-page area-21 pt-5">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4 col-md-4">
                            <div class="page-head-blog">
                                <div class="single-blog-page">
                                    <div class="left-blog">
                                        <h4>recent post</h4>
                                        <div class="recent-post">
                                            <a href="#blog-1" class="recent-single-post">
                                                <div class="post-img">
                                                    <img src="https://upload.wikimedia.org/wikipedia/commons/1/1d/Dental-implant-illustration.jpg" alt="">
                                                </div>
                                                <div class="pst-content">
                                                    <p> Dental implants are the best solution for...</p>
                                                </div>
                                            </a>
                                            <a href="#blog-2" class="recent-single-post">
                                                <div class="post-img">
                                                    <img src="https://nhakhoaident.com/Images/filebrowser/tram-rang-bang-composite.jpg" alt="">
                                                </div>
                                                <div class="pst-content">
                                                    <p> Filling is a dental technique that uses artificial...</p>
                                                </div>
                                            </a>
                                            <a href="#blog-3" class="recent-single-post">
                                                <div class="post-img">
                                                    <img src="https://vinmec-prod.s3.amazonaws.com/images/20190806_045211_746039_pasted_image_0_25.max-800x800.png" alt="">
                                                </div>
                                                <div class="pst-content">
                                                    <p> Orthodontic braces is a commonly used term...</p>
                                                </div>
                                            </a>
                                            <a href="#blog-4" class="recent-single-post">
                                                <div class="post-img">
                                                    <img src="https://vinmec-prod.s3.amazonaws.com/images/20190331_095630_785542_nho-rang-khon.max-1800x1800.jpg" alt="">
                                                </div>
                                                <div class="pst-content">
                                                    <p> Wisdom teeth is the name used to refer to...</p>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-8 col-sm-8 col-xs-12">
                            <div class="row">
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="single-blog" id="blog-1">
                                        <div class="single-blog-img">
                                            <img src="https://upload.wikimedia.org/wikipedia/commons/1/1d/Dental-implant-illustration.jpg" alt="" width="888px">
                                        </div>
                                        <div class="blog-meta">
                                            <span class="comments-type">
                                                <i class="bi bi-chat"></i>11 comments
                                            </span>
                                            <span class="date-type">
                                                <i class="bi bi-calendar"></i>2016-03-05 / 09:10:16
                                            </span>
                                        </div>
                                        <div class="blog-text">
                                            <h4>
                                                Dental implants
                                            </h4>
                                            <p>
                                                Dental implants are the best solution for people who have lost their teeth
                                                for a long time.<span class="dots">...</span>
                                                <span class="more">Implant is a method of restoring lost teeth by implanting
                                                    a titanium post into the jawbone, without affecting adjacent teeth like
                                                    traditional bridge methods; does not cause bone loss, does not cause
                                                    obstruction, discomfort like removable dentures. This method is
                                                    especially effective for patients with long-term tooth loss and jaw bone
                                                    loss.</span>
                                            </p>
                                        </div>
                                        <button onclick="myReadMoreFunction(this)" id="myBtn" class="ready-btn">Read more</button>
                                    </div>
                                </div>
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="single-blog" id="blog-2">
                                        <div class="single-blog-img">
                                            <img src="https://nhakhoaident.com/Images/filebrowser/tram-rang-bang-composite.jpg" alt="" width="888px">
                                        </div>
                                        <div class="blog-meta">
                                            <span class="comments-type">
                                                <i class="bi bi-chat"></i>7 comments
                                            </span>
                                            <span class="date-type">
                                                <i class="bi bi-calendar"></i>2016-03-05 / 09:10:16
                                            </span>
                                        </div>
                                        <div class="blog-text">
                                            <h4>
                                                Dental filling
                                            </h4>
                                            <p>
                                                Filling is a dental technique that uses artificial materials to fill in
                                                missing tooth tissue.<span class="dots">...</span>
                                                <span class="more">This method can be effective both in aesthetics and in
                                                    improving chewing function. In addition to fillings due to tooth decay
                                                    is a common cause, you may need to consult a dentist when there is a
                                                    hole in the tooth. This method is usually applied to the following
                                                    cases: Filling with decayed teeth, chipped teeth, wide teeth, fillings
                                                    to replace the old fillings.</span>
                                            </p>
                                        </div>
                                        <button onclick="myReadMoreFunction(this)" id="myBtn" class="ready-btn">Read more</button>
                                    </div>
                                </div>
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="single-blog" id="blog-3">
                                        <div class="single-blog-img">
                                            <img src="https://vinmec-prod.s3.amazonaws.com/images/20190806_045211_746039_pasted_image_0_25.max-800x800.png" alt="" width="888px">
                                        </div>
                                        <div class="blog-meta">
                                            <span class="comments-type">
                                                <i class="bi bi-chat"></i>13 comments
                                            </span>
                                            <span class="date-type">
                                                <i class="bi bi-calendar"></i>2016-03-05 / 09:10:16
                                            </span>
                                        </div>
                                        <div class="blog-text">
                                            <h4>
                                                Orthodontic braces
                                            </h4>
                                            <p>
                                                Orthodontic braces is a commonly used term in dentistry; helps to move teeth
                                                by using specialized dental appliances, giving you a<span
                                                    class="dots">...</span>
                                                <span class="more">balanced and regular set of teeth. Usually, a person's
                                                    braces process can last for 1-3 years, even longer, depending on the
                                                    location, the degree of misalignment of the teeth and the orthodontic
                                                    plan that you and your doctor have chosen.</span>
                                            </p>
                                        </div>
                                        <button onclick="myReadMoreFunction(this)" id="myBtn" class="ready-btn">Read more</button>
                                    </div>
                                </div>
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="single-blog" id="blog-4">
                                        <div class="single-blog-img">
                                            <img src="https://vinmec-prod.s3.amazonaws.com/images/20190331_095630_785542_nho-rang-khon.max-1800x1800.jpg" alt="" width="888px">
                                        </div>
                                        <div class="blog-meta">
                                            <span class="comments-type">
                                                <i class="bi bi-chat"></i>1 comments
                                            </span>
                                            <span class="date-type">
                                                <i class="bi bi-calendar"></i>2016-03-05 / 09:10:16
                                            </span>
                                        </div>
                                        <div class="blog-text">
                                            <h4>
                                                Wisdom teeth
                                            </h4>
                                            <p>
                                                In fact, wisdom teeth is the name used to refer to the last molars that
                                                erupt on each side of the jaw, or tooth number 8.<span
                                                    class="dots">...</span>
                                                <span class="more">This tooth does not appear in young children when
                                                    teething or when teeth have been replaced. last, usually in adults 18
                                                    years of age or older.
                                                    Because wisdom teeth come in last, the roof of the human mouth often
                                                    does not have enough room for them to grow normally. As a result, wisdom
                                                    teeth grow misaligned, push each other, crowding other teeth, leading to
                                                    swelling and pain.
                                                    There are many cases where wisdom teeth grow underground, grow
                                                    misaligned without timely intervention, causing the gums to swell, easy
                                                    to accumulate food, causing bad breath, gingivitis ...</span>
                                            </p>
                                        </div>
                                        <button onclick="myReadMoreFunction(this)" id="myBtn" class="ready-btn">Read more</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
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
        <!-- Script  -->
        <script src="./js/user/UserRoot.js"></script>
        <script src="./js/user/NavBar.js"></script>
        <script src="./js/user/News.js"></script>
        <script src="./js/ScrollBackToTop.js"></script>
        <script src="./js/CheckNetworkStatus.js"></script>
        <script>
            setActiveMenuBar();
        </script>
    </body>
</html>
