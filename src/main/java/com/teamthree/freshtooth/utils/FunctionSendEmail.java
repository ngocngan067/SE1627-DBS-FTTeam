package com.teamthree.freshtooth.utils;

import com.teamthree.freshtooth.models.Account;
import com.teamthree.freshtooth.services.ConstantsSendEmail;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class FunctionSendEmail {

    private static final String SECRET_KEY = "ssshhhhhhhhhhh!!!!";
    private final Account account;
    private final String titleEmail;
    private String codeVerify;
    private final HttpServletRequest request;

    public FunctionSendEmail(Account account, String titleEmail, String codeVerify, HttpServletRequest request) {
        this.account = account;
        this.titleEmail = titleEmail;
        this.codeVerify = codeVerify;
        this.request = request;
    }

    public FunctionSendEmail(Account account, String titleEmail, HttpServletRequest request) {
        this.account = account;
        this.titleEmail = titleEmail;
        this.request = request;
    }

    public boolean sendMailVerifyAccount() {
        try {
            String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
            HtmlEmail email = new HtmlEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator(Encrypt.decrypt(ConstantsSendEmail.MY_EMAIL, SECRET_KEY), Encrypt.decrypt(ConstantsSendEmail.MY_PASSWORD, SECRET_KEY)));
            email.setSSLOnConnect(true);
            email.setFrom(Encrypt.decrypt(ConstantsSendEmail.MY_EMAIL, SECRET_KEY));

            email.addTo(account.getUserEmail());

            email.setSubject(titleEmail);

            email.setHtmlMsg("<html><section class=\"confirm-email\"\n"
                    + "        style=\"margin: auto; width: 700px; height: 100vh; display: flex; align-items: center; font-family: sans-serif; font-weight: 500;\">\n"
                    + "        <div class=\"container\"\n"
                    + "            style=\"overflow: hidden; box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;border-radius: 5px;\">\n"
                    + "            <div class=\"confirm-img\">\n"
                    + "                <img style=\"height: 300px;width: 700px; object-fit: cover;\"\n"
                    + "                    src=\"https://blog.trello.com/hubfs/They-Use-Email-You-Use-Trello-final.png\" alt=\"Xin chao\">\n"
                    + "            </div>\n"
                    + "\n"
                    + "            <div class=\"confirm-content\" style=\"margin-bottom: 2rem; padding: 0 1rem;\">\n"
                    + "                <div class=\"content\" style=\"margin-bottom: 3rem;\">\n"
                    + "                    <h1 style=\"padding-top: 5px; color: #6D5FCF; text-align: center; font-size: 38px;\">Email Confirmation</h1>\n"
                    + "                    <p style=\"padding-top: 15px; font-size: 17px; \">Dear <span\n"
                    + "                            style=\"color: #7D8EF0;\">" + account.getFullName() + "</span></p>\n"
                    + "                    <p style=\"font-size: 15px;\">Thank you for creating a Fresh Tooth account.</p>\n"
                    + "                    <p style=\"font-size: 15px;\">Please click the button below to complete the registration process.</p>\n"
                    + "                    <p style=\"font-size: 15px;\">Failure to confirm your email account within 10 minutes will result in\n"
                    + "                        account deletion.\n"
                    + "                        If so, you will have to start the membership registration process again and receive a new\n"
                    + "                        confirmation email.</p>\n"
                    + "                </div>\n"
                    + "\n"
                    + "                <div class=\"confirm-btn\" style=\"display: flex;\n"
                    + "                justify-content: center;\n"
                    + "                align-items: center;\">\n"
                    + "                    <a href=\""+ url +"/verify?uid=" + account.getUserEmail() + "\" style=\"text-decoration: none; background-color: #7D8EF0;\n"
                    + "                    color: white;\n"
                    + "                    border: none;\n"
                    + "                    border-radius: 2px;\n"
                    + "                    padding: 15px;\n"
                    + "                    font-size: medium;\n"
                    + "                    font-weight: 500;\n"
                    + "                    cursor: pointer;\n"
                    + "                    box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;\">Verify Email</a>\n"
                    + "                </div>\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "    </section></html>");

            email.setTextMsg("Your email client does not support HTML messages");
            email.send();
            return true;
        } catch (EmailException e) {
            return false;
        }
    }

    public boolean sendMailChangePassword() {
        try {
            HtmlEmail email = new HtmlEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator(Encrypt.decrypt(ConstantsSendEmail.MY_EMAIL, SECRET_KEY), Encrypt.decrypt(ConstantsSendEmail.MY_PASSWORD, SECRET_KEY)));
            email.setSSLOnConnect(true);
            email.setFrom(Encrypt.decrypt(ConstantsSendEmail.MY_EMAIL, SECRET_KEY));

            email.addTo(account.getUserEmail());

            email.setSubject(titleEmail);

            email.setHtmlMsg("<html><section class=\"confirm-email\">\n"
                    + "        <div class=\"container\" style=\"margin: 0 23rem; overflow: hidden; border: 1px solid #8412c0;\">\n"
                    + "            <div class=\"confirm-box\">\n"
                    + "                <div class=\"confirm-header\" style=\"background-color: #f3e6f8; width: 100%; height: 60px;\">\n"
                    + "                    <div class=\"logo-name\" style=\"margin-left: 10px;\n"
                    + "                    padding-top: 12px;\n"
                    + "                    font-size: 2rem;\n"
                    + "                    font-weight: 500;\">\n"
                    + "                        Fresh Tooth\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "            </div>\n"
                    + "            \n"
                    + "            <div class=\"confirm-img\" style=\"width: 100%;\">\n"
                    + "                <img src=\"https://img.freepik.com/free-vector/two-steps-verification-illustration-flat-design-illustration_108061-442.jpg?size=626&ext=jpg\" alt=\"Xin chao\" style=\"width: 100%;\">\n"
                    + "            </div>\n"
                    + "\n"
                    + "            <div class=\"confirm-content\" style=\"margin-bottom: 2rem; padding-left: 1rem;\">\n"
                    + "                <div class=\"content\" style=\"margin-bottom: 3rem;\">\n"
                    + "                    <h1 style=\"padding-top: 30px;\">Change Your Password</h1>\n"
                    + "                    <p style=\"padding-top: 30px; font-size: 18px;\">Dear " + account.getFullName() + ",</p>\n"
                    + "                    <p style=\"padding-top: 30px; font-size: 18px;\">Your reset code: " + codeVerify + "</p>\n"
                    + "                    <p style=\"padding-top: 30px; font-size: 18px;\">Thank you for trusting Fresh Tooth.</p>\n"
                    + "                </div>\n"
                    + "            </div>\n"
                    + "    </section></html>");

            email.setTextMsg("Your email client does not support HTML messages");
            email.send();
            return true;
        } catch (EmailException e) {
            return false;
        }
    }
}
