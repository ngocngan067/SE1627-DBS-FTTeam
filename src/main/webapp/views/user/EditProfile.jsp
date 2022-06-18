<%@page import="com.teamthree.freshtooth.models.AccountError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    AccountError accountError = (AccountError) request.getAttribute("EDIT_PROFILE_ERROR");
    if(accountError == null) {
        accountError = new AccountError();
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Edit Profile | ${sessionScope.LOGIN_USER.fullName}</title>
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
        <link rel="stylesheet" href="./css/UploadImagePopup.css" />
        <link rel="stylesheet" href="./css/ScrollBackToTop.css" />
        <link rel="stylesheet" href="./css/CheckNetworkStatus.css" />
        <link rel="stylesheet" href="./css/user/NavBar.css" />
        <link rel="stylesheet" href="./css/user/EditProfile.css" />
        <link rel="stylesheet" href="./css/user/FooterPage.css" />
        <link rel="stylesheet" href="./css/user/SupportOnline.css" />
    </head>
    <body>
        <jsp:include page="../../layouts/ScrollBackToTop.html"></jsp:include>
        <jsp:include page="../../layouts/UploadImagePopup.html"></jsp:include>
        <jsp:include page="../../layouts/CheckNetworkStatus.html"></jsp:include>
        
        <header class="header-background">
            <jsp:include page="../../layouts/user/NavBar.jsp"></jsp:include>
        </header>
        
        <!------------- BODY ------------->
        <div class="container">
            <div class="row">
                <div class="setting-body">
                    <div class="setting-header">
                        <h2 class="setting-header_title">Account</h2>
                        <div class="setting-header_content">
                            <h3>Profile</h3>
                            <p>This information will be displayed publicly so be careful what you share</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-7 col-lg-12 col-md-12 col-sm-12 col-12">
                            <div class="setting-form">
                                <form action="${pageContext.request.contextPath}/edit-profile" method="POST">
                                    <div>
                                        <div class="row">
                                            <div class="setting-avatar">
                                                <label class="setting-avatar_label">Avatar</label>
                                                <div class="setting-avatar_content">
                                                    <div class="setting-avatar_photo" style="background: ${sessionScope.LOGIN_USER.imageAvatar == null ? sessionScope.LOGIN_USER.colorAvatar : ""}">
                                                        <c:choose>
                                                            <c:when test = "${sessionScope.LOGIN_USER.imageAvatar == null}">
                                                               <p>${sessionScope.LOGIN_USER.defaultAvatar.toUpperCase()}</p>
                                                            </c:when>

                                                            <c:when test = "${sessionScope.LOGIN_USER.imageAvatar != null}">
                                                               <img src="data:image/png;base64,${sessionScope.LOGIN_USER.imageAvatar}" />
                                                            </c:when>

                                                            <c:when test = "${IMAGE_AVATAR != null}">
                                                                <img src="${fileURL}" alt="" >
                                                                <input type="hidden" value="${fileURL}" name="imageAvatar">
                                                            </c:when>
                                                            <c:when test = "${IMAGE_AVATAR == null}">
                                                                <p>${sessionScope.LOGIN_USER.defaultAvatar.toUpperCase()}</p>
                                                            </c:when>
                                                        </c:choose>
                                                    </div>
                                                    <div class="setting-avatar_button">
                                                        <button type="button" class="setting-avatar_change">Change</button>
                                                        <button type="button" class="setting-avatar_remove">Remove</button>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                                <div class="setting-form_content">
                                                    <label for="username" class="setting-form_label">Username</label>
                                                    <div class="setting-form_input">
                                                        <input oninput="CheckUsername()" onblur="CheckUsername()"
                                                            type="text" name="username" id="username" value="${FULLNAME != null ? FULLNAME : sessionScope.LOGIN_USER.fullName}">
                                                        <i class='bx bx-check-circle' id="username-icon-check"></i>
                                                        <i class='bx bx-error-circle' id="username-icon-error"></i>
                                                    </div>
                                                    <div class="message">
                                                        <span class="error-message" id="username-error"><%=accountError.getFullNameError()%></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                                <div class="setting-form_content">
                                                    <p class="title">Gender</p>
                                                    <div class="radio-box">
                                                        <label class="radio-container">Male
                                                            <input type="radio" checked name="userSex" value="Male">
                                                            <span class="checkmark"></span>
                                                        </label>
                                                        <label class="radio-container">Female
                                                            <input type="radio" name="userSex" value="Female">
                                                            <span class="checkmark"></span>
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                                <div class="setting-form_content">
                                                    <p class="title">Birth Day</p>
                                                    <div class="select-date">
                                                        <div class="select-box">
                                                            <label for="day" class="setting-form_label">Day</label>
                                                            <select class="select-content" name="day" id="day"></select>
                                                        </div>
                                                        <div class="select-box">
                                                            <label for="month" class="setting-form_label">Month</label>
                                                            <select class="select-content" name="month" id="month"></select>
                                                        </div>
                                                        <div class="select-box">
                                                            <label for="year" class="setting-form_label">Year</label>
                                                            <select class="select-content" name="year" id="year"></select>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                                <div class="setting-form_content">
                                                    <label for="email" class="setting-form_label">Email</label>
                                                    <div class="setting-form_input">
                                                        <input type="email" name="email" id="email" value="${sessionScope.LOGIN_USER.userEmail}" readonly>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                                <div class="setting-form_content">
                                                    <label for="phone-number" class="setting-form_label">Phone Number</label>
                                                    <div class="setting-form_input">
                                                        <input oninput="CheckPhoneNumber()" onblur="CheckPhoneNumber()"
                                                            type="text" name="phoneNumber" id="phone-number" value="${PHONE_NUMBER != null ? PHONE_NUMBER : sessionScope.LOGIN_USER.userPhone}">
                                                        <i class='bx bx-check-circle' id="phone-number-icon-check"></i>
                                                        <i class='bx bx-error-circle' id="phone-number-icon-error"></i>
                                                    </div>
                                                    <div class="message">
                                                        <span class="error-message" id="phone-number-error"><%=accountError.getPhoneNumberError()%></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                                <div class="setting-form_content">
                                                    <label for="address" class="setting-form_label">Address</label>
                                                    <div class="setting-form_input">
                                                        <input oninput="CheckAddress()" onblur="CheckAddress()" type="text"
                                                            name="address" id="address" value="${ADDRESS != null ? ADDRESS : sessionScope.LOGIN_USER.userAddress}">
                                                        <i class='bx bx-check-circle' id="address-icon-check"></i>
                                                        <i class='bx bx-error-circle' id="address-icon-error"></i>
                                                    </div>
                                                    <div class="message">
                                                        <span class="error-message" id="address-error"><%=accountError.getAddressError()%></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                                <div class="setting-form_button">
                                                    <button type="submit" class="setting-form_save">Save</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="d-none d-xl-block col-xl-5">
                            <div class="setting-backgound">
                                <lottie-player src="https://assets9.lottiefiles.com/private_files/lf30_e6aaw5jt.json"
                                    background="transparent" speed="1" loop autoplay class="setting-image"></lottie-player>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!------------- END BODY ------------->
        
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
        <script src="./js/user/EditProfile.js"></script>
        <script src="./js/user/UploadImagePopup.js"></script>
        <script>
            setActiveMenuBar();
        </script>
    </body>
</html>
