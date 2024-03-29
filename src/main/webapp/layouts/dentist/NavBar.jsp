<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="d-none d-xxl-flex header__navbar d-flex justify-content-between pt-3 pb-3 container-fluid">
    <div class="header__logo">
        <a href="${pageContext.request.contextPath}/dentist/appointment">
            <div class="logo--FT">
                <img src=".././images/logoFT1.png" alt="Logo Fresh Tooth" id="logo-image" />
            </div>
        </a>
    </div>

    <div class="header__menu d-flex justify-content-center align-items-center">
        <ul class="d-flex" id="menu">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/dentist/appointment">Appointment</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/dentist/time-line">Time Line</a>
            </li>
            
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/dentist/feedback">FeedBack</a>
            </li>
        </ul>
    </div>

    <c:if test="${SEARCH != null}">
        <div class="header__tool">
            <div id="searchBox">
                <div class="button-search">
                    <i class="btn-search fa-solid fa-magnifying-glass"></i>
                </div>
                <input oninput="searchByName(this, '${pageContext.request.contextPath}/dentist/appointment')" class="search-place" type="text" placeholder="Search appointment...">
                    <button onclick="showMicrophoneBox('${pageContext.request.contextPath}/dentist/appointment')" type="button" class="button-mic">
                        <svg class="goxjub" focusable="false" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                            <path fill="#4285f4"
                                  d="m12 15c1.66 0 3-1.31 3-2.97v-7.02c0-1.66-1.34-3.01-3-3.01s-3 1.34-3 3.01v7.02c0 1.66 1.34 2.97 3 2.97z">
                            </path>
                            <path fill="#34a853" d="m11 18.08h2v3.92h-2z"></path>
                            <path fill="#fbbc04"
                                  d="m7.05 16.87c-1.27-1.33-2.05-2.83-2.05-4.87h2c0 1.45 0.56 2.42 1.47 3.38v0.32l-1.15 1.18z">
                            </path>
                            <path fill="#ea4335"
                                  d="m12 16.93a4.97 5.25 0 0 1 -3.54 -1.55l-1.41 1.49c1.26 1.34 3.02 2.13 4.95 2.13 3.87 0 6.99-2.92 6.99-7h-1.99c0 2.92-2.24 4.93-5 4.93z">
                            </path>
                        </svg>
                    </button>
            </div>
            <div class="microphone-wrapper" id="microphone-wrapper">
                <div class="microphone-box" role="dialog" tabindex="-1">
                    <div class="microphone-container" tabindex="-1">
                        <div class="microphone-header">
                            <div class="microphone-header__text">
                                <div id="microphone-header__prompt" class="microphone-header__prompt"></div>
                            </div>
                            <div class="microphone-exit__button">
                                <button onclick="hideMicrophoneBox()" class="icon-exit-button">
                                    <i class="fa-solid fa-xmark"></i>
                                </button>
                            </div>
                        </div>
                        <div class="microphone-body">
                            <div id="microphone-body-text" class="microphone-body-text"></div>
                        </div>
                        <div class="microphone-footer-button">
                            <div onclick="activeMicrophone('${pageContext.request.contextPath}/dentist/appointment')" class="microphone-footer-container">
                                <div class="microphone-pulse"></div>
                                <div class="microphone-levels"></div>
                                <div class="microphone-circle" role="button" tabindex="0">
                                    <i class="fa-solid fa-microphone-lines"></i>
                                </div>
                            </div>
                            <div id="microphone-footer-label" class="microphone-footer-label"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:if>

    <div class="header__action">
        <c:if test="${sessionScope.LOGIN_DENTIST != null}">
            <div class="header__action-user">
                <div onclick="menuToggle()" class="user-avatar">
                    <c:if test="${sessionScope.LOGIN_DENTIST.imageAvatar != null}">
                        <div class="img-user">
                            <img src="data:image/png;base64,${sessionScope.LOGIN_DENTIST.imageAvatar}" />
                        </div>
                    </c:if>
                </div>
                <div class="user-menu">
                    <ul>
                        <li>
                            <i class="uil uil-user-circle"></i>
                            <a href="${pageContext.request.contextPath}/dentist/info-profile">My Profile</a>
                        </li>
                        <li>
                            <i class="uil uil-padlock"></i>
                            <a href="${pageContext.request.contextPath}/dentist/change-password">Change Password</a>
                        </li>
                        <li>
                            <i class="uil uil-signout"></i>
                            <a href="${pageContext.request.contextPath}/logout">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </c:if>
    </div>
</div>

<div class="d-flex d-xxl-none nav__bar-mobile pt-3 pb-3 container-fluid">
    <div class="col-xl-2 col-lg-2 col-md-2 col-sm-3 col-4 nav__bar-mobile-logo">
        <a href="${pageContext.request.contextPath}/dentist/appointment" class="nav__bar-logo-mobile-link">
            <img src=".././images/logoFT1.png" alt="">
        </a>
    </div>
    <div class="col-xl-10 col-lg-10 col-md-9 col-sm-8 col-7 nav__bar-mobile-tool">
        <div class="tool-button">
            <div onclick="showSearchBox()" id="button-icon-search" class="d-lg-none">
                <div class="tool-search">
                    <i class="fa-solid fa-magnifying-glass"></i>
                </div>
            </div>
            <div class="d-none d-lg-flex search-box">
                <div class="button-search">
                    <i class="btn-search fa-solid fa-magnifying-glass"></i>
                </div>
                <input oninput="searchByName(this, '${pageContext.request.contextPath}/dentist/appointment')" class="search-place" type="text" placeholder="Search appointment...">
                    <button onclick="showMicrophoneBox()" type="button" class="button-mic">
                        <svg class="goxjub" focusable="false" viewBox="0 0 24 24"
                             xmlns="http://www.w3.org/2000/svg">
                            <path fill="#4285f4"
                                  d="m12 15c1.66 0 3-1.31 3-2.97v-7.02c0-1.66-1.34-3.01-3-3.01s-3 1.34-3 3.01v7.02c0 1.66 1.34 2.97 3 2.97z">
                            </path>
                            <path fill="#34a853" d="m11 18.08h2v3.92h-2z"></path>
                            <path fill="#fbbc04"
                                  d="m7.05 16.87c-1.27-1.33-2.05-2.83-2.05-4.87h2c0 1.45 0.56 2.42 1.47 3.38v0.32l-1.15 1.18z">
                            </path>
                            <path fill="#ea4335"
                                  d="m12 16.93a4.97 5.25 0 0 1 -3.54 -1.55l-1.41 1.49c1.26 1.34 3.02 2.13 4.95 2.13 3.87 0 6.99-2.92 6.99-7h-1.99c0 2.92-2.24 4.93-5 4.93z">
                            </path>
                        </svg>
                    </button>
            </div>
<!--            <div id="button-icon-bell">
                <div class="bell" id="bell">
                    <i class="fas fa-bell"></i>
                </div>
                <div class="bell-number" id="bell-number">99+</div>
            </div>-->
        </div>
        <div id="searchBox" class="d-lg-none container-fluid">
            <div class="col-md-1 col-sm-1 col-1 button-search">
                <i class="btn-search fa-solid fa-magnifying-glass"></i>
            </div>
            <input oninput="searchByName(this, '${pageContext.request.contextPath}/dentist/appointment')" class="col-md-9 col-sm-9 col-9 search-place" type="text" placeholder="Search appointment...">
                <button type="button" onclick="showMicrophoneBoxMobile('${pageContext.request.contextPath}/dentist/appointment')"
                        class="col-md-1 col-sm-1 col-1 button-mic">
                    <svg class="goxjub" focusable="false" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                        <path fill="#4285f4"
                              d="m12 15c1.66 0 3-1.31 3-2.97v-7.02c0-1.66-1.34-3.01-3-3.01s-3 1.34-3 3.01v7.02c0 1.66 1.34 2.97 3 2.97z">
                        </path>
                        <path fill="#34a853" d="m11 18.08h2v3.92h-2z"></path>
                        <path fill="#fbbc04"
                              d="m7.05 16.87c-1.27-1.33-2.05-2.83-2.05-4.87h2c0 1.45 0.56 2.42 1.47 3.38v0.32l-1.15 1.18z">
                        </path>
                        <path fill="#ea4335"
                              d="m12 16.93a4.97 5.25 0 0 1 -3.54 -1.55l-1.41 1.49c1.26 1.34 3.02 2.13 4.95 2.13 3.87 0 6.99-2.92 6.99-7h-1.99c0 2.92-2.24 4.93-5 4.93z">
                        </path>
                    </svg>
                </button>
                <button type="button" onclick="showSearchBox()" class="col-md-1 col-sm-1 col-1 button-close">
                    <i class="fa-solid fa-xmark"></i>
                </button>
        </div>
        <div class="mobile__microphone-wrapper" id="mobile__microphone-wrapper">
            <div class="mobile__microphone-box" role="dialog" tabindex="-1">
                <div class="mobile__microphone-container" tabindex="-1">
                    <div class="mobile__microphone-header">
                        <div class="mobile-header__text">
                            <div id="mobile-header__prompt" class="mobile-header__prompt"></div>
                        </div>
                        <div class="mobile-exit__button">
                            <button onclick="hideMicrophoneBoxMobile()" class="mobile-icon-exit-button">
                                <i class="fa-solid fa-xmark"></i>
                            </button>
                        </div>
                    </div>
                    <div class="mobile__microphone-body">
                        <div class="mobile-microphone-body-text" id="mobile-microphone-body-text"></div>
                    </div>
                    <div class="mobile__microphone-footer-button">
                        <div onclick="activeMicrophoneMobile('${pageContext.request.contextPath}/dentist/appointment')" class="mobile__microphone-footer-container">
                            <div class="mobile__microphone-pulse"></div>
                            <div class="mobile__microphone-levels"></div>
                            <div class="mobile__microphone-circle" role="button" tabindex="0">
                                <i class="fa-solid fa-microphone-lines"></i>
                            </div>
                        </div>
                        <div class="mobile__microphone-footer-label" id="mobile__microphone-footer-label"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-xl-1 col-lg-1 col-md-1 col-sm-1 col-1 nav__bar-mobile-menu">
        <label for="mobile-menu-checkbox" class="nav__bar-mobile-menu-label">
            <i class="fa-solid fa-bars"></i>
        </label>
    </div>
    <input type="checkbox" onclick="BlockScrollInUserMenu()" hidden id="mobile-menu-checkbox"
           class="nav__menu-mobile">
        <div class="user__mobile">
            <div class="user__mobile-header">
                <c:if test="${sessionScope.LOGIN_DENTIST != null}">
                    <div class="header__action-user">
                        <div class="user-avatar">
                            <c:if test="${sessionScope.LOGIN_DENTIST.imageAvatar != null}">
                                <div class="img-user">
                                    <img src="data:image/png;base64,${sessionScope.LOGIN_DENTIST.imageAvatar}" />
                                </div>
                            </c:if>
                        </div>
                        <div class="user-name">
                            <h4>${sessionScope.LOGIN_DENTIST.fullName}</h4>
                        </div>
                    </div>
                </c:if>

                <label for="mobile-menu-checkbox" class="user__mobile-header-close">
                    <i class="fa-solid fa-xmark" style="color: red;"></i>
                </label>
            </div>

            <ul class="user__mobile-list">
                <c:if test="${sessionScope.LOGIN_DENTIST != null}">
                    <li class="user__mobile-item">
                        <a href="${pageContext.request.contextPath}/dentist/info-profile" class="user__mobile-link">
                            <i class="fa-solid fa-user"></i>
                            <span class="user__mobile-name">My Profile</span>
                        </a>
                    </li>

                    <li class="user__mobile-item item-border">
                        <a href="${pageContext.request.contextPath}/dentist/change-password" class="user__mobile-link">
                            <i class="fa-solid fa-lock"></i>
                            <span class="user__mobile-name">Change Password</span>
                        </a>
                    </li>
                </c:if>

                <li class="user__mobile-item">
                    <a href="${pageContext.request.contextPath}/dentist/appointment" class="user__mobile-link">
                        <i class="fa-solid fa-house"></i>
                        <span class="user__mobile-name">Appointment</span>
                    </a>
                </li>

                <li class="user__mobile-item">
                    <a href="${pageContext.request.contextPath}/dentist/time-line" class="user__mobile-link">
                        <i class="fa-solid fa-wrench"></i>
                        <span class="user__mobile-name">Time Line</span>
                    </a>
                </li>
                        
                <li class="user__mobile-item">
                    <a href="${pageContext.request.contextPath}/dentist/feedback" class="user__mobile-link">
                        <i class="fa-solid fa-comment-dots"></i>
                        <span class="user__mobile-name">FeedBack</span>
                    </a>
                </li>

                <c:if test="${sessionScope.LOGIN_DENTIST != null}">
                    <li class="user__mobile-item">
                        <a href="${pageContext.request.contextPath}/logout" class="user__mobile-link">
                            <i class="fa-solid fa-right-from-bracket"></i>
                            <span class="user__mobile-name">Logout</span>
                        </a>
                    </li>
                </c:if>
            </ul>
        </div>
</div>