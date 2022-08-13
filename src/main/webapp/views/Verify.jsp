<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Welcome to Fresh Tooth</title>
        <link rel="icon" type="image/png" sizes="200x138" href="./images/iconFT.png">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="./css/Verify.css">
    </head>
    <body>
        <div class="root">
            <div>
                <div class="container-fluid root-container">
                    <div class="row">
                        <div class="col-12">
                            <div class="verify-body">
                                <table class="verify-table">
                                    <!-- LOGO -->
                                    <tr>
                                        <td class="verify-table_header">
                                            <table>
                                                <tr>
                                                    <td class="verify-table_background"></td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="verify-table_welcome">
                                            <table class="verify-welcome_content">
                                                <tr>
                                                    <td>
                                                        <h1 class="verify-content_header">
                                                            <c:choose>
                                                                <c:when test = "${VERIFY_STATUS.equals('Successful')}">
                                                                    Welcome!
                                                                </c:when>

                                                                <c:when test = "${VERIFY_STATUS.equals('Error')}">
                                                                    Fresh Tooth!
                                                                </c:when>
                                                            </c:choose>
                                                        </h1>
                                                        <div class="verify-content_body">
                                                            <c:choose>
                                                                <c:when test = "${VERIFY_STATUS.equals('Successful')}">
                                                                   <lottie-player src="https://assets10.lottiefiles.com/packages/lf20_c1hkermx.json" background="transparent" speed="1" loop autoplay class="verify-content_image"></lottie-player>
                                                                </c:when>

                                                                <c:when test = "${VERIFY_STATUS.equals('Error')}">
                                                                    <lottie-player src="https://assets8.lottiefiles.com/packages/lf20_k1rx9jox.json" background="transparent" speed="1" loop autoplay class="verify-content_image"></lottie-player>
                                                                </c:when>
                                                            </c:choose>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="verify-table_info">
                                            <table>
                                                <tr>
                                                    <td class="verify-info-start">
                                                        <c:choose>
                                                            <c:when test = "${VERIFY_STATUS.equals('Successful')}">
                                                                <p>Hey ${sessionScope.USER_FULLNAME},</p>
                                                                <p>We're excited to have you get started. First, you need to confirm
                                                                    your account, we have sent you a letter.</p>
                                                                <p>If you have any questions, just reply to this email—we're always
                                                                    happy to help out.</p>
                                                                <p>Cheers,<br>Fresh Tooth Team</p>
                                                            </c:when>

                                                            <c:when test = "${VERIFY_STATUS.equals('Error')}">
                                                                <p>
                                                                    Your account has expired. Please click the button below to be redirected to the page to reactivate your account.
                                                                </p>
                                                            </c:when>
                                                        </c:choose>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="verify-table_button">
                                                        <table>
                                                            <tr>
                                                                <td class="verify-button_home">
                                                                    <table>
                                                                        <tr>
                                                                            <td class="verify-button_content">
                                                                                <c:choose>
                                                                                    <c:when test = "${VERIFY_STATUS.equals('Successful')}">
                                                                                        <a href="${pageContext.request.contextPath}/login">Back To Login</a>
                                                                                    </c:when>

                                                                                    <c:when test = "${VERIFY_STATUS.equals('Error')}">
                                                                                        <a href="${pageContext.request.contextPath}/forgot-password">Reactive account</a>
                                                                                    </c:when>
                                                                                </c:choose>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
        <!-- LINK BOOTSTRAP 5 -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
        <script>
            console.log("%cHello! \ud83d\ude4b", "color: #29c4a9;font-size: 16px;font-weight: 600;"),
                    console.log("%cFresh Tooth front-end was built with HTML, CSS, and lots of love. \n\nFresh Tooth back-end was built with SQL Server, Java Web and lots of love. \n\n\ud83d\udc49 Want to learn with us? Check out ".concat(window.location.origin, "/FreshTooth/home"), "color: #29c4a9;font-size: 14px;");
        </script>
    </body>
</html>
