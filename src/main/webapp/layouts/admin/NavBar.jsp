<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="main-topbar">
    <!-- Menu Hamburger Button -->
    <div class="menu-button">
        <div class="menu-button__burger"></div>
    </div>
    
    <!-- Search Box -->
    <div class="topbar-search">
        <div id="searchBox">
            <div class="button-search">
                <i class="fa-solid fa-magnifying-glass"></i>
            </div>
            <input ng-model="searching" class="search-place" type="text" placeholder="Search service">
            <button type="button" class="button-mic">
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
    </div>
    
    <!-- User Avatar -->
    <div class="topbar-user" style="background: ${sessionScope.LOGIN_ADMIN.colorAvatar}">
        <c:if test="${sessionScope.LOGIN_ADMIN.imageAvatar != null}">
            <img src="data:image/png;base64,${sessionScope.LOGIN_ADMIN.imageAvatar}" />
        </c:if>
        <c:if test="${sessionScope.LOGIN_ADMIN.imageAvatar == null}">
            <p>${sessionScope.LOGIN_ADMIN.defaultAvatar.toUpperCase()}</p>
        </c:if>
    </div>
</div>