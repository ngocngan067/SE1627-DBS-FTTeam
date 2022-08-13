<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="main-topbar">
    <!-- Menu Hamburger Button -->
    <div class="menu-button">
        <div class="menu-button__burger"></div>
    </div>
    
    <!-- Search Box -->
    <c:if test="${SEARCH != null}">
        <div class="topbar-search">
            <div id="searchBox">
                <div class="button-search">
                    <i class="fa-solid fa-magnifying-glass"></i>
                </div>
                <input ng-model="${SEARCH}" class="search-place" type="text" placeholder="Search...">
            </div>
        </div>
    </c:if>
    
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