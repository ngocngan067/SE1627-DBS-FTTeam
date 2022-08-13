<%@page import="com.teamthree.freshtooth.models.AccountError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountError accountError = (AccountError) request.getAttribute("CHANGE_PASSWORD_ERROR");
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
        <title>Change Password | ${sessionScope.LOGIN_DENTIST.fullName}</title>
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
        <!-- AOS  -->
        <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
        <!-- LINK STYLE -->
        <link rel="stylesheet" href=".././css/ScrollBackToTop.css" />
        <link rel="stylesheet" href=".././css/CheckNetworkStatus.css" />
        <link rel="stylesheet" href=".././css/dentist/DentistRoot.css" />
        <link rel="stylesheet" href=".././css/dentist/NavBar.css" />
        <link rel="stylesheet" href=".././css/dentist/ChangePassword.css" />
    </head>
    <body>
        <jsp:include page="../../layouts/ScrollBackToTop.html"></jsp:include>
        <jsp:include page="../../layouts/CheckNetworkStatus.html"></jsp:include>
        
        <header class="header-background">
            <jsp:include page="../../layouts/dentist/NavBar.jsp"></jsp:include>
        </header>
        
        <!------------- BODY ----------------->
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
                                <form action="${pageContext.request.contextPath}/dentist/change-password" method="POST">
                                    <div>
                                        <div class="row">
                                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                                <div class="setting-form_content">
                                                    <label for="oldPassword" class="setting-form_label">Old Password</label>
                                                    <div class="setting-form_input">
                                                        <input oninput="CheckOldPassword()" onblur="CheckOldPassword()" onkeyup="OldPasswordKeyUp()" type="password" name="oldPassword" id="oldPassword">
                                                        <span class="showBtn" id="show-old-password">
                                                            <i class="fas fa-eye-slash" id="show-old-password-icon"></i>
                                                        </span>
                                                        <i class='bx bx-check-circle' id="oldPassword-icon-check"></i>
                                                        <i class='bx bx-error-circle' id="oldPassword-icon-error"></i>
                                                    </div>
                                                    <div class="message">
                                                        <span class="error-message" id="oldPassword-error"><%=accountError.getPasswordError()%></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                                <div class="setting-form_content">
                                                    <label for="newPassword" class="setting-form_label">New Password</label>
                                                    <div class="setting-form_input">
                                                        <input oninput="CheckNewPassword()" onblur="CheckNewPassword()" onkeyup="CheckPasswordStrength()" type="password" name="newPassword" id="newPassword">
                                                        <span class="showBtn" id="show-new-password">
                                                            <i class="fas fa-eye-slash" id="show-new-password-icon"></i>
                                                        </span>
                                                        <i class='bx bx-check-circle' id="newPassword-icon-check"></i>
                                                        <i class='bx bx-error-circle' id="newPassword-icon-error"></i>
                                                    </div>
                                                    <div class="indicator">
                                                        <span class="weak"></span>
                                                        <span class="medium"></span>
                                                        <span class="strong"></span>
                                                    </div>
                                                    <div class="error-text"></div>
                                                    <div class="message">
                                                        <span class="error-message" id="newPassword-error"><%=accountError.getNewPasswordError()%></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                                <div class="setting-form_content">
                                                    <label for="confirmPassword" class="setting-form_label">Confirm Password</label>
                                                    <div class="setting-form_input">
                                                        <input oninput="CheckConfirmPassword()" onblur="CheckConfirmPassword()" onkeyup="ConfirmPasswordKeyUp()" type="password" name="confirmPassword" id="confirmPassword">
                                                        <span class="showBtn" id="show-confirm-password">
                                                            <i class="fas fa-eye-slash" id="show-confirm-password-icon"></i>
                                                        </span>
                                                        <i class='bx bx-check-circle' id="confirmPassword-icon-check"></i>
                                                        <i class='bx bx-error-circle' id="confirmPassword-icon-error"></i>
                                                    </div>
                                                    <div class="message">
                                                        <span class="error-message" id="confirmPassword-error"><%=accountError.getConfirmPasswordError()%></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                                <div class="setting-form_button">
                                                    <button type="submit" class="setting-form_save">Change Password</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="d-none d-xl-block col-xl-5">
                            <div class="setting-backgound">
                                <lottie-player src="https://assets7.lottiefiles.com/packages/lf20_jmtf164z.json"
                                    background="transparent" speed="1" loop autoplay class="setting-image"></lottie-player>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!------------- END BODY ------------->
        
        <!-- LINK BOOTSTRAP 5 -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
        <!-- J QUERY -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- Lottie Files -->
        <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
        <!-- Script  -->
        <script src=".././js/ScrollBackToTop.js"></script>
        <script src=".././js/CheckNetworkStatus.js"></script>
        <script src=".././js/dentist/DentistRoot.js"></script>
        <script src=".././js/dentist/ChangePassword.js"></script>
    </body>
</html>
