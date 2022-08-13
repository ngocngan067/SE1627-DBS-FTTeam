package com.teamthree.freshtooth.controllers;

import com.restfb.types.User;
import com.teamthree.freshtooth.dbo.AccountFacade;
import com.teamthree.freshtooth.dbo.NotificationFacade;
import com.teamthree.freshtooth.models.Account;
import com.teamthree.freshtooth.models.AccountError;
import com.teamthree.freshtooth.models.GoogleAccount;
import com.teamthree.freshtooth.models.Notification;
import com.teamthree.freshtooth.services.RestFacebook;
import com.teamthree.freshtooth.services.RestGoogle;
import com.teamthree.freshtooth.utils.CalculatorTime;
import com.teamthree.freshtooth.utils.Encrypt;
import com.teamthree.freshtooth.utils.FunctionRandom;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;

public class LoginController extends HttpServlet {

    private static final String LOGIN_ADMIN = "LOGIN_ADMIN";
    private static final String LOGIN_USER = "LOGIN_USER";
    private static final String LOGIN_DENTIST = "LOGIN_DENTIST";
    private static final String LOGIN_ACCOUNT_ERROR = "LOGIN_ACCOUNT_ERROR";
    private static final String NOTIFICATION_LIST = "NOTIFICATION_LIST";
    private static final String TIME_NOTIFICATION = "TIME_NOTIFICATION";
    private static final String COUNT_NOTIFICATION_NOT_READ = "COUNT_NOTIFICATION_NOT_READ";
    private static final String REMEMBER_USER = "USER_FRESHTOOTH";
    private static final String SECRET_KEY = "ssshhhhhhhhhhh!!!!";
    private static final int TIME_COOKIE = 60 * 60 * 24;
    private static final String EMAIL = "EMAIL";
    private static final String VALUE_LOGIN = "VALUE_LOGIN";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            HttpSession session = request.getSession();
            session.removeAttribute("USER_FULLNAME");
            String codeGoogle = request.getParameter("code");
            String codeFacebook = request.getParameter("code");
            String accessToken = "", accessTokenFacebook = "";

            if (codeGoogle != null || codeFacebook != null) {
                if (codeGoogle != null) {
                    accessToken = RestGoogle.getGoogleToken(codeGoogle);
                } else {
                    accessTokenFacebook = RestFacebook.getToken(codeFacebook);
                }
                
                Account account = new Account();

                if (!accessToken.equals("")) {
                    GoogleAccount googleAccount = RestGoogle.getGoogleUserInfo(accessToken);

                    account.setUserID(googleAccount.getId());
                    account.setUserEmail(googleAccount.getEmail());
                    account.setColorAvatar(FunctionRandom.colorAvatar());
                    char getFirstCharacter = googleAccount.getEmail().charAt(0);
                    account.setDefaultAvatar(Character.toString(getFirstCharacter));
                    account.setUserRole(0);
                    account.setUserStatus(1);
                    
                } else if (!accessTokenFacebook.equals("")) {
                    User user = RestFacebook.getUserInfo(accessTokenFacebook);
                    
                    account.setUserID(user.getId());
                    account.setUserEmail(user.getEmail());
                    account.setColorAvatar(FunctionRandom.colorAvatar());
                    char getFirstCharacter = user.getEmail().charAt(0);
                    account.setDefaultAvatar(Character.toString(getFirstCharacter));
                    account.setUserRole(0);
                    account.setUserStatus(1);
                }

                AccountFacade accountFacade = new AccountFacade();
                Account checkLearnerAccount = accountFacade.checkAccount(account, "Login");

                if (checkLearnerAccount == null) {
                    accountFacade.addAccount(account, "AddAccountGoogle");
                    session.setAttribute(LOGIN_USER, account);
                } else {
                    boolean addAccountGoogle = false;
                    char[] charSearch = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                        'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
                        'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
                        'e', 'f', 'g', 'h', 'i', 'k', 'l', 'm', 'n', 'o', 'p',
                        'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

                    for (int i = 0; i < checkLearnerAccount.getUserID().length(); i++) {
                        char chr = checkLearnerAccount.getUserID().charAt(i);
                        for (int j = 0; j < charSearch.length; j++) {
                            if (charSearch[j] == chr) {
                                addAccountGoogle = true;
                            }
                        }
                    }

                    if (addAccountGoogle == true) {
                        accountFacade.addAccount(account, "AddAccountGoogle");
                        session.setAttribute(LOGIN_USER, account);
                    } else {
                        session.setAttribute(LOGIN_USER, checkLearnerAccount);
                    }

                }

                response.sendRedirect(request.getContextPath() + "/home");
            } else {
                session.setAttribute(VALUE_LOGIN, "VALUE_LOGIN");

                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/Login.jsp");
                requestDispatcher.forward(request, response);
            }

        } catch (IOException | SQLException | ServletException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String hashPassword = DigestUtils.md5Hex(password);
            String rememberMeString = request.getParameter("rememberMe");
            boolean rememberMe = "Y".equals(rememberMeString);

            Account account = null;
            AccountError accountError = new AccountError();
            HttpSession session = request.getSession();
            boolean hasError = false;
            Cookie cookieUserName;

            if (email.equals("") && password.equals("")) {
                hasError = true;
                accountError.setEmailError("Please enter your email!");
                accountError.setPasswordError("Please enter your password!");
            } else if (email.equals("")) {
                hasError = true;
                accountError.setEmailError("Please enter your email!");
            } else if (password.equals("")) {
                hasError = true;
                accountError.setPasswordError("Please enter your password!");
            } else {
                AccountFacade checkLogin = new AccountFacade();
                account = checkLogin.checkAccount(email, "Login");
                if (account == null) {
                    hasError = true;
                    accountError.setEmailError("Account does not exist!");
                } else if (account.getUserStatus() == 0) {
                    hasError = true;
                    accountError.setEmailError("Account not activated!");
                } else if (account.getUserStatus() == 2) {
                    hasError = true;
                    accountError.setEmailError("Your account has been locked!");
                } else if (!hashPassword.equals(account.getUserPassword())) {
                    hasError = true;
                    accountError.setPasswordError("Wrong password, please try again!");
                }
            }

            if (hasError) {
                request.setAttribute(LOGIN_ACCOUNT_ERROR, accountError);
                request.setAttribute(EMAIL, email);
                session.setAttribute(VALUE_LOGIN, "VALUE_LOGIN");
                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/Login.jsp");
                requestDispatcher.forward(request, response);
            } else {
                if (rememberMe) {
                    String encryptedUsername = Encrypt.encrypt(email, SECRET_KEY);
                    cookieUserName = new Cookie(REMEMBER_USER, encryptedUsername);
                    cookieUserName.setMaxAge(TIME_COOKIE);
                } else {
                    cookieUserName = new Cookie(REMEMBER_USER, null);
                    cookieUserName.setMaxAge(0);
                }
                response.addCookie(cookieUserName);

                switch (account.getUserRole()) {
                    case 0:
                        NotificationFacade checkNotification = new NotificationFacade();

                        List<Notification> notificationList = checkNotification.getAllNotification(account.getUserID());

                        if (notificationList.isEmpty()) {
                            session.setAttribute(NOTIFICATION_LIST, null);
                        } else {
                            NotificationFacade notificationFacade = new NotificationFacade();
                            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
                            String currentDateString = dateFormatter.format(Calendar.getInstance().getTime());
                            Date currentDate = dateFormatter.parse(currentDateString);
                            String pastTimeInSecond = dateFormatter.format(account.getAccountCreated());
                            Date pastDate = dateFormatter.parse(pastTimeInSecond);
                            int totalNotification = notificationFacade.countNotification(account.getUserID());
                            session.setAttribute(TIME_NOTIFICATION, CalculatorTime.timeAgo(currentDate, pastDate));
                            session.setAttribute(NOTIFICATION_LIST, notificationList);
                            if (totalNotification == 0) {
                                session.setAttribute(COUNT_NOTIFICATION_NOT_READ, null);
                            } else {
                                session.setAttribute(COUNT_NOTIFICATION_NOT_READ, totalNotification);
                            }
                        }

                        session.setAttribute(LOGIN_USER, account);
                        session.removeAttribute(VALUE_LOGIN);
                        String uri = (String) session.getAttribute("uri");
                        if (uri != null) {
                            response.sendRedirect(uri);
                        } else {
                            response.sendRedirect(request.getContextPath() + "/home");
                        }
                        break;
                    case 1:
                        session.setAttribute(LOGIN_ADMIN, account);
                        response.sendRedirect(request.getContextPath() + "/admin/dashboard");
                        break;
                    case 2:
                        session.setAttribute(LOGIN_DENTIST, account);
                        response.sendRedirect(request.getContextPath() + "/dentist/appointment");
                        break;
                }
            }

        } catch (IOException | SQLException | ParseException | ServletException e) {
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
