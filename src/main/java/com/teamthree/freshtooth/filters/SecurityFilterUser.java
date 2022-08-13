package com.teamthree.freshtooth.filters;

import com.teamthree.freshtooth.models.Account;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityFilterUser implements Filter {

    private HttpServletRequest httpRequest;
    private HttpServletResponse httpResponse;

    private static final String[] loginRequiredURLs = {
        "/info-profile", "/edit-profile", "/change-password", "/history-booking-all",
        "/history-booking", "/history-booking-confirmed", "/history-booking-completed", "/history-booking-cancelled"
    };

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        httpRequest = (HttpServletRequest) request;
        httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        boolean isLoggedIn = (session != null && session.getAttribute("LOGIN_USER") != null);
        String loginURI = httpRequest.getContextPath() + "/login";
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);

        if (path.startsWith("/admin/")) {
            chain.doFilter(request, response);
            return;
        } else if (path.startsWith("/dentist/")) {
            chain.doFilter(request, response);
            return;
        } else {
            if (isLoggedIn && isLoginRequest) {
                Account account = (Account)session.getAttribute("LOGIN_USER");
                if (account.getUserStatus() == 1) {
                    httpRequest.getRequestDispatcher("/").forward(request, response);
                } else {
                    httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
                }
                
            } else if (!isLoggedIn && isLoginRequired()) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    private boolean isLoginRequired() {
        String requestURL = httpRequest.getRequestURL().toString();

        for (String loginRequiredURL : loginRequiredURLs) {
            if (requestURL.contains(loginRequiredURL)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void destroy() {
    }

}
