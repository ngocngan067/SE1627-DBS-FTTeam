package com.teamthree.freshtooth.controllers;

import com.teamthree.freshtooth.dbo.AccountFacade;
import com.teamthree.freshtooth.dbo.NotificationFacade;
import com.teamthree.freshtooth.models.Account;
import com.teamthree.freshtooth.models.AccountError;
import com.teamthree.freshtooth.models.Notification;
import com.teamthree.freshtooth.utils.Encrypt;
import com.teamthree.freshtooth.utils.FunctionRandom;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;

public class RegisterController extends HttpServlet {

    private static final String WELCOME_USER = "WELCOME_USER";
    private static final String SIGN_UP_ACCOUNT_ERROR = "SIGN_UP_ACCOUNT_ERROR";
    private static final String SECRET_KEY = "ssshhhhhhhhhhh!!!!";
    private static final String FULLNAME_REGISTER = "FULLNAME_REGISTER";
    private static final String EMAIL_REGISTER = "EMAIL_REGISTER";
    private static final String VALUE_LOGIN = "VALUE_LOGIN";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String getFullName = request.getParameter("fullName");
            String getEmail = request.getParameter("email");
            String getPassword = request.getParameter("password");
            String getConfirmPassword = request.getParameter("confirmPassword");
            String userID = FunctionRandom.randomID(10);

            Account account;
            Notification notification;
            AccountError accountError = new AccountError();
            AccountFacade accountFacade = new AccountFacade();
            HttpSession session = request.getSession();
            boolean hasError = false;

            if (getFullName.equals("") && getEmail.equals("") && getPassword.equals("") && getConfirmPassword.equals("")) {
                hasError = true;
                accountError.setFullNameError("Please enter your full name!");
                accountError.setEmailError("Please enter your email!");
                accountError.setPasswordError("Please enter your password!");
                accountError.setConfirmPasswordError("Please enter your confirm password!");
            } else if (getFullName.equals("")) {
                hasError = true;
                accountError.setFullNameError("Please enter your full name!");
            } else if (getEmail.equals("")) {
                hasError = true;
                accountError.setEmailError("Please enter your email!");
            } else if (getPassword.equals("")) {
                hasError = true;
                accountError.setPasswordError("Please enter your password!");
            } else if (getConfirmPassword.equals("")) {
                hasError = true;
                accountError.setConfirmPasswordError("Please enter your confirm password!");
            } else if (!getPassword.equals(getConfirmPassword)) {
                hasError = true;
                accountError.setConfirmPasswordError("Password does not match!");
            } else {
                String colorAvatar = FunctionRandom.colorAvatar();
                String newPassword = DigestUtils.md5Hex(getPassword);
                char getFirstCharacter = getFullName.charAt(0);

                account = new Account();
                account.setFullName(getFullName);
                account.setUserEmail(getEmail);
                account.setUserPassword(newPassword);
                account.setUserID(userID);
                account.setDefaultAvatar(Character.toString(getFirstCharacter));
                account.setColorAvatar(colorAvatar);

                Account checkAccount = accountFacade.checkAccount(getEmail);
                if (checkAccount == null) {
                    boolean checkRegister = accountFacade.registerAccount(account);
                    if (checkRegister == false) {
                        hasError = true;
                        accountError.setFullNameError("System error please try again!");
                    } else {
                        accountFacade.updateAccount(account, "ActiveAccount");
                    }
                } else {
                    hasError = true;
                    accountError.setEmailError("Account already exists!");
                }
            }

            if (hasError) {
                request.setAttribute(SIGN_UP_ACCOUNT_ERROR, accountError);
                request.setAttribute(FULLNAME_REGISTER, getFullName);
                request.setAttribute(EMAIL_REGISTER, getEmail);
                session.setAttribute(VALUE_LOGIN, "VALUE_REGISTER");
                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/Login.jsp");
                requestDispatcher.forward(request, response);
            } else {
                notification = new Notification();
                notification.setNotifyID(FunctionRandom.randomID(10));
                notification.setUserID(userID);
                notification.setNotifyType("NewAccount");
                NotificationFacade checkNotification = new NotificationFacade();
                boolean addNotificationDone = checkNotification.addNotification(notification);
                if (addNotificationDone) {
                    String encryptedUsername = Encrypt.encrypt(getFullName, SECRET_KEY);
                    session.setAttribute(WELCOME_USER, encryptedUsername);
                    session.setMaxInactiveInterval(500);
                    response.sendRedirect(request.getContextPath() + "/verify");
                }
            }

        } catch (IOException | SQLException | ServletException e) {
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
