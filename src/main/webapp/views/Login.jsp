<%@page import="com.teamthree.freshtooth.models.AccountError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountError signinAccountError = (AccountError) request.getAttribute("LOGIN_ACCOUNT_ERROR");
    AccountError signupAccountError = (AccountError) request.getAttribute("SIGN_UP_ACCOUNT_ERROR");

    if (signinAccountError == null) {
        signinAccountError = new AccountError();
    }

    if (signupAccountError == null) {
        signupAccountError = new AccountError();
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Welcome to Fresh Tooth</title>
        <link rel="icon" type="image/png" sizes="200x138" href="./images/iconFT.png">
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!-- LINK FONTAWESOME -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.1.1/css/all.css">
        <link href="./css/Login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="preloader">
            <div class="preloader-image"></div>
        </div>

        <div class="body_container">
            <div class="forms_container">
                <div class="signin_signup">
                    <!-- Form Login -->
                    <form action="${pageContext.request.contextPath}/login" method="POST" class="sign_in_form">
                        <h2 class="title">Sign in</h2>
                        <div class="input_field" id="signinEmailField">
                            <i class='bx bx-user'></i>
                            <input type="email" placeholder="Email" id="signinEmail" name="email" value="${EMAIL != null ? EMAIL : ""}" oninput="CheckSignInEmail()" onblur="CheckSignInEmail()">
                            <i class='bx bx-check-circle signin_email_icon_check'></i>
                            <i class='bx bx-error-circle signin_email_icon_error'></i>
                        </div>
                        <div class="message">
                            <span class="error_message" id="email_error_signin"><%=signinAccountError.getEmailError()%></span>
                        </div>
                        <div class="input_field" id="signinPasswordField">
                            <i class='bx bx-lock-alt'></i>
                            <input type="password" placeholder="Password" id="signinPassword" name="password" oninput="CheckSignInPassword()" onblur="CheckSignInPassword()" onkeyup="PasswordSignInKeyUp()">
                            <i class="fa-solid fa-eye-slash" id="show-signin-password-icon"></i>
                            <i class='bx bx-check-circle signin_password_icon_check'></i>
                            <i class='bx bx-error-circle signin_password_icon_error'></i>
                        </div>
                        <div class="message">
                            <span class="error_message" id="password_error_signin"><%=signinAccountError.getPasswordError()%></span>
                        </div>
                        <div class="login-options">
                            <div class="remember-me">
                                <input type="checkbox" id="rememberMe" name="rememberMe" value="Y">
                                <label for="rememberMe">Remember me</label>
                            </div>
                            <div class="forgot_field">
                                <a href="${pageContext.request.contextPath}/forgot-password">Forgot password</a>
                            </div>
                        </div>
                        <input type="submit" value="Login" class="btn solid" name="Login">

<!--                        <p class="social_text">Or Sign up with social platforms</p>
                        <div class="social_media">
                            <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=https://freshtooth.herokuapp.com/login-google&response_type=code&client_id=149355289905-21ihaae2bsu9v7n1sje5r7qkbjtll4mm.apps.googleusercontent.com&approval_prompt=force" class="social_icon">
                                <i class='bx bxl-google'></i>
                            </a>
                            <a href="https://www.facebook.com/dialog/oauth?client_id=630860655061944&redirect_uri=https://freshtooth.herokuapp.com/login-facebook" class="social_icon">
                                <i class='bx bxl-facebook'></i>
                            </a>
                        </div>-->
                    </form>

                    <!-- Form Sign Up -->
                    <form action="${pageContext.request.contextPath}/register" method="POST" class="sign_up_form">
                        <h2 class="title">Sign up</h2>
                        <div class="input_field" id="signupFullNameField">
                            <i class='bx bx-user'></i>
                            <input type="text" placeholder="Full Name" id="signupFullName" name="fullName" value="${FULLNAME_REGISTER != null ? FULLNAME_REGISTER : ""}" oninput="CheckSignUpFullname()" onblur="CheckSignUpFullname()">
                            <i class='bx bx-check-circle signup_fullname_icon_check'></i>
                            <i class='bx bx-error-circle signup_fullname_icon_error'></i>
                        </div>
                        <div class="message">
                            <span class="error_message" id="fullname_error_signup"><%=signupAccountError.getFullNameError()%></span>
                        </div>
                        <div class="input_field" id="signupEmailField">
                            <i class='bx bx-envelope'></i>
                            <input type="text" placeholder="Email" id="signupEmail" name="email" value="${EMAIL_REGISTER != null ? EMAIL_REGISTER : ""}" oninput="CheckSignUpEmail()" onblur="CheckSignUpEmail()">
                            <i class='bx bx-check-circle signup_email_icon_check'></i>
                            <i class='bx bx-error-circle signup_email_icon_error'></i>
                        </div>
                        <div class="message">
                            <span class="error_message" id="email_error_signup"><%=signupAccountError.getEmailError()%></span>
                        </div>
                        <div class="input_field" id="signupPasswordField">
                            <i class='bx bx-lock-alt'></i>
                            <input type="password" placeholder="Password" id="signupPassword" name="password" oninput="CheckSignUpPassword()" onblur="CheckSignUpPassword()" onkeyup="PasswordSignUpKeyUp()">
                            <i class="fa-solid fa-eye-slash" id="show-signup-password-icon"></i>
                            <i class='bx bx-check-circle signup_password_icon_check'></i>
                            <i class='bx bx-error-circle signup_password_icon_error'></i>
                        </div>
                        <div class="message">
                            <span class="error_message" id="password_error_signup"><%=signupAccountError.getPasswordError()%></span>
                        </div>
                        <div class="input_field" id="confirmPasswordField">
                            <i class='bx bx-lock-alt'></i>
                            <input type="password" placeholder="Confirm Password" id="confirmPassword" name="confirmPassword" oninput="CheckSignUpConfirmPassword()" onblur="CheckSignUpConfirmPassword()" onkeyup="ConfirmPasswordSignUpKeyUp()">
                            <i class="fa-solid fa-eye-slash" id="show-signup-confirm-password-icon"></i>
                            <i class='bx bx-check-circle confirm_password_icon_check'></i>
                            <i class='bx bx-error-circle confirm_password_icon_error'></i>
                        </div>
                        <div class="message">
                            <span class="error_message" id="confirm_password_error_signup"><%=signupAccountError.getConfirmPasswordError()%></span>
                        </div>

                        <input type="submit" value="SignUp" class="btn solid">

<!--                        <p class="social_text">Or Sign in with social platforms</p>
                        <div class="social_media">
                            <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=https://freshtooth.herokuapp.com/login-google&response_type=code&client_id=149355289905-21ihaae2bsu9v7n1sje5r7qkbjtll4mm.apps.googleusercontent.com&approval_prompt=force" class="social_icon">
                                <i class='bx bxl-google'></i>
                            </a>
                            <a href="https://www.facebook.com/dialog/oauth?client_id=630860655061944&redirect_uri=https://freshtooth.herokuapp.com/login-facebook" class="social_icon">
                                <i class='bx bxl-facebook'></i>
                            </a>
                        </div>-->
                    </form>

                </div>
            </div>
            <div class="panels_container">
                <div class="panel left_panel">
                    <div class="content">
                        <h3>Do not have an account ?</h3>
                        <p>
                            Create an account to explore more about Fresh Tooth!
                        </p>
                        <button onclick="ClearDataInSignIn()" class="btn transparent" id="sign_up_btn">Sign up</button>
                    </div>
                    <img src="./images/undraw_maker_launch_crhe.svg" class="image" alt="">
                </div>

                <div class="panel right_panel">
                    <div class="content">
                        <h3>Already have an account ?</h3>
                        <p>
                            Sign in and visit Fresh Tooth Website! Let's Go!
                        </p>
                        <button onclick="ClearDataInSignUp()" class="btn transparent" id="sign_in_btn">Sign in</button>
                    </div>
                    <img src="./images/undraw_winter_designer_a2m7.svg" class="image" alt="">
                </div>
            </div>
        </div>

        <script src="./js/Login.js"></script>
        <script>
                            CheckURL("${sessionScope.VALUE_LOGIN}");
        </script>
    </body>
</html>
