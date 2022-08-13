<%@page import="com.teamthree.freshtooth.models.AccountError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    AccountError accountError = (AccountError) request.getAttribute("FORGOT_ACCOUNT_ERROR");

    if (accountError == null) {
        accountError = new AccountError();
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Forgot Password</title>
        <!-- TẠO ICON TRÊN THANH WEB -->
        <link rel="icon" type="image/png" sizes="200x138" href="./images/iconFT.png">
        <!-- BOOTSTRAP 5 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Box Icons -->
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <!-- Font Awesome Icons -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
        <!-- CSS -->
        <link rel="stylesheet" href="./css/ForgotPassword.css">
    </head>
    <body>
        <section class="reset-pwd" style="width: ${CHANGE_PAGE_PASSWORD == null ? '100vw' : ''}; height: ${CHANGE_PAGE_PASSWORD == null ? '100vh' : ''};">
            <c:if test="${CHANGE_PASSWORD_SUCCESS != null}">
                <div class="success-body">
                    <lottie-player src="https://assets2.lottiefiles.com/private_files/lf30_4dfb546p.json" background="transparent"
                                   speed="1" loop class="success-image"></lottie-player>
                </div>
            </c:if>
            <div class="reset-box" style="height: ${CHANGE_PAGE_PASSWORD != null ? '840px' : '650px'}">
                <div class="overlay" style="height: ${CHANGE_PAGE_PASSWORD != null ? '860px' : '580px'}"></div>
                <div class="img-lock">
                    <img src="./images/lock4.png" alt="">
                    <div class="reset-contain">
                        <h1>Forgot your password?</h1>
                        <p>We received a request to reset your password. If you didn't make this request, simply ignore
                            this email.</p>
                    </div>

                    <div class="input-email">
                        <form action="${pageContext.request.contextPath}/forgot-password" method="post" class="row g-3">
                            <c:if test="${CURRENT_PAGE != null}">
                                <div class="col-12">
                                    <label for="inputEmail" class="visually-hidden">Email</label>
                                    <div class="input-field" id="email-input-field">
                                        <input oninput="CheckEmail()" onblur="CheckEmail()" type="email" class="form-control" id="inputEmail" placeholder="Your Email" name="email" value="${EMAIL != null ? EMAIL : ""}">
                                        <i class='bx bx-check-circle email-icon-check'></i>
                                        <i class='bx bx-error-circle email-icon-error'></i>
                                    </div>
                                </div>
                                <div class="col-12 mb-2">
                                    <span class="error_message" id="email-error"><%=accountError.getEmailError()%></span>
                                </div>
                            </c:if>
                            <c:if test="${CHANGE_PAGE_PASSWORD != null}">
                                <div class="col-12">
                                    <label for="inputNewPassword" class="visually-hidden">New Password</label>
                                    <div class="input-field" id="new-password-input-field">
                                        <input onkeyup="CheckPasswordStrength()" oninput="CheckNewPassword()" onblur="CheckNewPassword()" type="password" class="form-control" id="inputNewPassword" placeholder="Your New Password" name="newPassword">
                                        <span class="showBtn" id="show-new-password">
                                            <i class="fas fa-eye-slash" id="show-new-password-icon"></i>
                                        </span>
                                        <i class='bx bx-check-circle new-password-icon-check'></i>
                                        <i class='bx bx-error-circle new-password-icon-error'></i>
                                    </div>
                                    <div class="indicator-new-password">
                                        <span class="weak"></span>
                                        <span class="medium"></span>
                                        <span class="strong"></span>
                                    </div>
                                    <div class="error-indicator-text"></div>
                                </div>
                                <div class="col-12 mb-2">
                                    <span class="error_message" id="new-password-error"><%=accountError.getNewPasswordError()%></span>
                                </div>
                                <div class="col-12">
                                    <label for="inputConfirmPassword" class="visually-hidden">Confirm Password</label>
                                    <div class="input-field" id="confirm-password-input-field">
                                        <input onkeyup="ConfirmPasswordKeyUp()" oninput="CheckConfirmPassword()" onblur="CheckConfirmPassword()" type="password" class="form-control" id="inputConfirmPassword" placeholder="Your Confirm Password" name="confirmPassword">
                                        <span class="showBtn" id="show-confirm-password">
                                            <i class="fas fa-eye-slash" id="show-confirm-password-icon"></i>
                                        </span>
                                        <i class='bx bx-check-circle confirm-password-icon-check'></i>
                                        <i class='bx bx-error-circle confirm-password-icon-error'></i>
                                    </div>
                                </div>
                                <div class="col-12 mb-2">
                                    <span class="error_message" id="confirm-password-error"><%=accountError.getConfirmPasswordError()%></span>
                                </div>
                            </c:if>
                            <c:if test="${CHANGE_PAGE_VERIFY != null}">
                                <div class="col-12">
                                    <label for="inputVerifyCode" class="visually-hidden">Verify Code</label>
                                    <div class="input-field" id="verify-code-input-field">
                                        <input oninput="CheckVerifyCode()" onblur="CheckVerifyCode()" type="text" class="form-control" id="inputVerifyCode" placeholder="Your Verify Code" name="verifySMS">
                                        <i class='bx bx-check-circle verify-code-icon-check'></i>
                                        <i class='bx bx-error-circle verify-code-icon-error'></i>
                                    </div>
                                </div>
                                <div class="col-12 mb-2">
                                    <span class="error_message" id="verify-code-error"><%=accountError.getVerifySMSError()%></span>
                                </div>
                            </c:if>
                            <div class="col-12 btn-submit">
                                <button type="submit" class="btn-reset">${CHANGE_PAGE_VERIFY == null ? "RESET MY PASSWORD" : "SEND CODE"}</button>
                            </div>
                        </form>
                    </div>
                            
                    <div class="back-login" style="font-size: 17px; color: #8a3b8f;">
                        <p>Back to <a href="${pageContext.request.contextPath}/login" style="text-decoration: none;">Login</a></p>
                    </div>

                    <c:if test="${CHANGE_PAGE_VERIFY != null}">
                        <div class="reset-contain">
                            <p>Please check your email for the verification code for reset password your account.</p>
                        </div>
                    </c:if>
                </div>

                <div class="footer-copy-right">
                    <p>
                        ©
                        <script>document.write(new Date().getFullYear());</script> Fresh Tooth website.
                    </p>
                </div>
            </div>
            <c:if test="${CHANGE_PASSWORD_SUCCESS != null}">
                <h2 class="success-title">Success!</h2>
            </c:if>
        </section>
                            
        <!-- BOOTSTRAP 5 -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
        <!-- Lottiefiles -->
        <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
        <!-- Gsap -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.9.1/gsap.min.js"></script>
        <!-- jquery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- Style -->
        <script src="./js/ForgotPassword.js"></script>
        <script>
            ButtonSend('${CHANGE_PASSWORD_SUCCESS != null ? CHANGE_PASSWORD_SUCCESS : ""}', '${pageContext.request.contextPath}/login');
        </script>
    </body>
</html>
