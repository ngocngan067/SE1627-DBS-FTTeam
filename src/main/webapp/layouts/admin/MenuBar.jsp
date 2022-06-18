<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header class="navigation">
    <ul>
        <li>
            <a class="navigation-logo" href="${pageContext.request.contextPath}/admin/dashboard">
                <span class="navigation-icon">
                    <i class="fa-solid fa-hospital"></i>
                </span>
                <span class="navigation-title">Fresh Tooth</span>
            </a>
        </li>
        <li class="nav-item active">
            <a href="${pageContext.request.contextPath}/admin/dashboard" class="nav-link">
                <span class="navigation-icon">
                    <i class="fa-solid fa-house"></i>
                </span>
                <span class="navigation-title">Dashboard</span>
            </a>
        </li>
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/user-management" class="nav-link">
                <span class="navigation-icon">
                    <i class="fa-solid fa-user"></i>
                </span>
                <span class="navigation-title">Customers</span>
            </a>
        </li>
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/dentist-management" class="nav-link">
                <span class="navigation-icon">
                    <i class="fa-solid fa-user-doctor"></i>
                </span>
                <span class="navigation-title">Dentist</span>
            </a>
        </li>
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/service-management" class="nav-link">
                <span class="navigation-icon">
                    <i class="fa-solid fa-screwdriver"></i>
                </span>
                <span class="navigation-title">Service</span>
            </a>
        </li>
        <li class="nav-item">
            <a href="#" class="nav-link">
                <span class="navigation-icon">
                    <i class="fa-solid fa-gear"></i>
                </span>
                <span class="navigation-title">Setting</span>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/logout">
                <span class="navigation-icon">
                    <i class="fa-solid fa-right-from-bracket"></i>
                </span>
                <span class="navigation-title">Sign Out</span>
            </a>
        </li>
    </ul>
</header>