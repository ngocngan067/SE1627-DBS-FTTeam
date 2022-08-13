package com.teamthree.freshtooth.controllers;

import com.teamthree.freshtooth.dbo.AccountFacade;
import com.teamthree.freshtooth.dbo.NotificationFacade;
import com.teamthree.freshtooth.dbo.PatientFacade;
import com.teamthree.freshtooth.models.Account;
import com.teamthree.freshtooth.models.AccountError;
import com.teamthree.freshtooth.models.Notification;
import com.teamthree.freshtooth.models.Patient;
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

    private static final String USER_FULLNAME = "USER_FULLNAME";
    private static final String WELCOME_USER = "WELCOME_USER";
    private static final String SIGN_UP_ACCOUNT_ERROR = "SIGN_UP_ACCOUNT_ERROR";
    private static final String SECRET_KEY = "ssshhhhhhhhhhh!!!!";
    private static final String FULLNAME_REGISTER = "FULLNAME_REGISTER";
    private static final String EMAIL_REGISTER = "EMAIL_REGISTER";
    private static final String VALUE_LOGIN = "VALUE_LOGIN";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        session.setAttribute(VALUE_LOGIN, "VALUE_REGISTER");

        RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/Login.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        try {
            String getFullName = request.getParameter("fullName");
            String getEmail = request.getParameter("email");
            String getPassword = request.getParameter("password");
            String getConfirmPassword = request.getParameter("confirmPassword");
            String userID = FunctionRandom.randomID(21);

            Account account = new Account();
            Notification notification;
            Patient patient;
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

                account.setFullName(getFullName);
                account.setUserEmail(getEmail);
                account.setUserPassword(newPassword);
                account.setUserID(userID);
                account.setDefaultAvatar(Character.toString(getFirstCharacter));
                account.setColorAvatar(colorAvatar);

                Account checkAccount = accountFacade.checkAccount(getEmail, "Login");
                if (checkAccount == null) {
                    String message = accountFacade.registerAccount(account, request);

                    if (message.equals("error")) {
                        hasError = true;
                        accountError.setFullNameError("System error please try again!");
                    }
                } else {
                    boolean exitAccountGoogle = false;
                    char[] charSearch = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                        'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
                        'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
                        'e', 'f', 'g', 'h', 'i', 'k', 'l', 'm', 'n', 'o', 'p',
                        'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

                    for (int i = 0; i < checkAccount.getUserID().length(); i++) {
                        char chr = checkAccount.getUserID().charAt(i);
                        for (int j = 0; j < charSearch.length; j++) {
                            if (charSearch[j] == chr) {
                                exitAccountGoogle = true;
                            }
                        }
                    }
                    if (exitAccountGoogle == true) {
                        String message = accountFacade.registerAccount(account, request);

                        if (message.equals("error")) {
                            hasError = true;
                            accountError.setFullNameError("System error please try again!");
                        }
                    } else {
                        hasError = true;
                        accountError.setEmailError("Account already exists!");
                    }
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
                patient = new Patient();

                notification.setNotifyID(FunctionRandom.randomID(10));
                notification.setUserID(userID);
                notification.setNotifyType("NewAccount");

                patient.setPatientID(userID);

                NotificationFacade checkNotification = new NotificationFacade();
                PatientFacade patientFacade = new PatientFacade();

                patientFacade.addPatient(patient);
                boolean addNotificationDone = checkNotification.addNotification(notification);

                if (addNotificationDone) {
                    String encryptedUsername = Encrypt.encrypt(getFullName, SECRET_KEY);
                    session.setAttribute(WELCOME_USER, encryptedUsername);
                    session.setAttribute(USER_FULLNAME, account.getFullName());
                    response.sendRedirect(request.getContextPath() + "/verify");
                }
            }

        } catch (IOException | SQLException | ServletException e) {
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
