package com.teamthree.freshtooth.controllers;

import com.teamthree.freshtooth.dbo.AccountFacade;
import com.teamthree.freshtooth.models.Account;
import com.teamthree.freshtooth.models.AccountError;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;

public class ChangePasswordController extends HttpServlet {

    private static final String LOGIN_USER = "LOGIN_USER";
    private static final String LOGIN_DENTIST = "LOGIN_DENTIST";
    private static final String CHANGE_PASSWORD_ERROR = "CHANGE_PASSWORD_ERROR";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String urlServlet = request.getServletPath();

            if (urlServlet.equals("/change-password")) {
                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/user/ChangePassword.jsp");
                requestDispatcher.forward(request, response);
            } else {
                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/dentist/ChangePassword.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (IOException | ServletException e) {
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            HttpSession session = request.getSession();
            String urlServlet = request.getServletPath();
            Account account, loginUser;
            AccountError accountError = new AccountError();
            AccountFacade accountFacade = new AccountFacade();
            boolean hasError = false;

            if (urlServlet.equals("/change-password")) {
                loginUser = (Account) session.getAttribute(LOGIN_USER);
            } else {
                loginUser = (Account) session.getAttribute(LOGIN_DENTIST);
            }

            String oldPassword = request.getParameter("oldPassword");
            String newPassword = request.getParameter("newPassword");
            String confirmPassword = request.getParameter("confirmPassword");
            String hashOldPassword = DigestUtils.md5Hex(oldPassword);
            String hashNewPassword = DigestUtils.md5Hex(newPassword);

            if (oldPassword.equals("") && newPassword.equals("") && confirmPassword.equals("")) {
                hasError = true;
                accountError.setPasswordError("Please enter your old password!");
                accountError.setNewPasswordError("Please enter your new password!");
                accountError.setConfirmPasswordError("Please enter your confirm password!");
            } else if (oldPassword.equals("")) {
                hasError = true;
                accountError.setPasswordError("Please enter your old password!");
            } else if (!hashOldPassword.equals(loginUser.getUserPassword())) {
                hasError = true;
                accountError.setPasswordError("Old password is incorrect!");
            } else if (newPassword.equals("")) {
                hasError = true;
                accountError.setNewPasswordError("Please enter your new password!");
            } else if (confirmPassword.equals("")) {
                hasError = true;
                accountError.setConfirmPasswordError("Please enter your confirm password!");
            } else if (!newPassword.equals(confirmPassword)) {
                hasError = true;
                accountError.setConfirmPasswordError("Password does not match!");
            }

            if (hasError) {
                request.setAttribute(CHANGE_PASSWORD_ERROR, accountError);

                if (urlServlet.equals("/change-password")) {
                    RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/user/ChangePassword.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/dentist/ChangePassword.jsp");
                    requestDispatcher.forward(request, response);
                }

            } else {
                account = new Account();
                account.setUserPassword(hashNewPassword);
                account.setUserEmail(loginUser.getUserEmail());

                boolean checkChangePassword = accountFacade.updateAccount(account, "ChangePassword");
                if (checkChangePassword) {
                    Account getAccount = accountFacade.checkAccount(account.getUserEmail(), "Login");

                    if (urlServlet.equals("/change-password")) {
                        session.setAttribute(LOGIN_USER, getAccount);
                    } else {
                        session.setAttribute(LOGIN_DENTIST, getAccount);
                    }
                }

                if (urlServlet.equals("/change-password")) {
                    RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/info-profile");
                    requestDispatcher.forward(request, response);
                } else {
                    RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/dentist/info-profile");
                    requestDispatcher.forward(request, response);
                }

            }
        } catch (IOException | SQLException | ServletException e) {
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
