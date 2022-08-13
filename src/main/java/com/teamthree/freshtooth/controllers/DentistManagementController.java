package com.teamthree.freshtooth.controllers;

import com.teamthree.freshtooth.dbo.AccountFacade;
import com.teamthree.freshtooth.dbo.DentistFacade;
import com.teamthree.freshtooth.models.Account;
import com.teamthree.freshtooth.models.AccountError;
import com.teamthree.freshtooth.models.Dentist;
import com.teamthree.freshtooth.models.DentistError;
import com.teamthree.freshtooth.utils.FunctionRandom;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONArray;

public class DentistManagementController extends HttpServlet {

    private static final String DENTIST_LIST = "DENTIST_LIST";
    private static final String END_PAGE = "END_PAGE";
    private static final String CURRENT_PAGE = "CURRENT_PAGE";
    private static final String DENTIST_ACCOUNT_ERROR = "DENTIST_ACCOUNT_ERROR";
    private static final String DENTIST_INFO_ERROR = "DENTIST_INFO_ERROR";
    private static final String BUTTON_ACTION = "BUTTON_ACTION";
    private static final String FULL_NAME = "FULL_NAME";
    private static final String DATE_OF_BIRTH = "DATE_OF_BIRTH";
    private static final String EMAIL = "EMAIL";
    private static final String PHONE_NUMBER = "PHONE_NUMBER";
    private static final String ADDRESS = "ADDRESS";
    private static final String DENTIST_IMAGE = "DENTIST_IMAGE";
    private static final String YEAR_OF_EXPERIENCE = "YEAR_OF_EXPERIENCE";
    private static final String SKILL = "SKILL";
    private static final String SALARY = "SALARY";
    private static final String INSURANCE = "INSURANCE";
    private static final String DESCRIPTION_DENTIST = "DESCRIPTION_DENTIST";
    private static final String ACTION_URL = "ACTION_URL";
    private static final String MENU_BAR = "MENU_BAR";
    private static final String MENU_BAR_ICON = "MENU_BAR_ICON";
    private static final String SEARCH = "SEARCH";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String urlServlet = request.getServletPath();

            AccountFacade accountFacade = new AccountFacade();

            List<Account> accountList;

            if (urlServlet.equals("/admin/add-dentist")) {
                request.setAttribute(MENU_BAR, MENU_BAR);
                request.setAttribute(MENU_BAR_ICON, "<i class=\"fa-solid fa-plus icon\"></i>");
                request.setAttribute(BUTTON_ACTION, "Add Dentist");
                request.setAttribute(ACTION_URL, "" + request.getContextPath() + "/admin/add-dentist");

                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/AddDentist.jsp");
                requestDispatcher.forward(request, response);
            } else if (urlServlet.equals("/admin/edit-dentist")) {
                String dentistID = request.getParameter("did");
                DentistFacade dentistFacade = new DentistFacade();

                Account account = accountFacade.checkAccount(dentistID, "GetAccountDentist");
                Dentist dentist = dentistFacade.getDentistDetail(dentistID);

                request.setAttribute(FULL_NAME, account.getFullName());
                request.setAttribute(DATE_OF_BIRTH, account.getDateOfBirth());
                request.setAttribute(EMAIL, account.getUserEmail());
                request.setAttribute(PHONE_NUMBER, account.getUserPhone());
                request.setAttribute(ADDRESS, account.getUserAddress());
                request.setAttribute(DENTIST_IMAGE, account.getImageAvatar());
                request.setAttribute(YEAR_OF_EXPERIENCE, dentist.getYearsOfExp());
                request.setAttribute(SKILL, dentist.getSkill());
                request.setAttribute(SALARY, dentist.getSalary());
                request.setAttribute(INSURANCE, dentist.getInsurance());
                request.setAttribute(DESCRIPTION_DENTIST, dentist.getDescriptionDentist());
                request.setAttribute(MENU_BAR, MENU_BAR);
                request.setAttribute(MENU_BAR_ICON, "<i class=\"fa-solid fa-pen-to-square icon\"></i>");
                request.setAttribute(BUTTON_ACTION, "Edit Dentist");
                request.setAttribute(ACTION_URL, "" + request.getContextPath() + "/admin/edit-dentist?did=" + dentistID + "");

                RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/AddDentist.jsp");
                requestDispatcher.forward(request, response);
            } else {
                String indexPage = request.getParameter("page");
                String userID = request.getParameter("ServiceID");

                if (indexPage == null) {
                    indexPage = "1";
                }
                int index = Integer.parseInt(indexPage);

                if (userID != null) {
                    String actionButton = request.getParameter("Action");
                    Account account = new Account();
                    account.setUserID(userID);

                    if (actionButton.equals("Disable")) {
                        account.setUserStatus(2);
                    } else {
                        account.setUserStatus(1);
                    }

                    accountFacade.updateAccount(account, "EditStatusWithID");
                } else {
                    int countAccount = accountFacade.countAccount("2");
                    int endPage = countAccount / 5;
                    if (countAccount % 5 != 0) {
                        endPage++;
                    }

                    accountList = accountFacade.getAccount(index, "PagingAccount", "2");
                    if (accountList.isEmpty()) {
                        request.setAttribute(DENTIST_LIST, null);
                    } else {
                        JSONArray jsArray = new JSONArray(accountList);
                        request.setAttribute(DENTIST_LIST, jsArray.toString());
                    }

                    request.setAttribute(END_PAGE, endPage);
                    request.setAttribute(CURRENT_PAGE, index);
                    request.setAttribute(SEARCH, "fullName");

                    RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/DentistManagement.jsp");
                    requestDispatcher.forward(request, response);
                }
            }

        } catch (IOException | NumberFormatException | SQLException | ServletException e) {
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        try {
            String urlServlet = request.getServletPath();

            Account account;
            Dentist dentist;
            AccountFacade accountFacade = new AccountFacade();
            DentistFacade dentistFacade = new DentistFacade();

            if (urlServlet.equals("/admin/add-dentist")) {
                String getFullName = request.getParameter("fullName");
                String getGender = request.getParameter("gender");
                if (getGender == null) {
                    getGender = "";
                } else {
                    getGender = request.getParameter("gender");
                }
                String getDateOfBirth = request.getParameter("dateOfBirth");
                String getEmail = request.getParameter("email");
                String getPhoneNumber = request.getParameter("phoneNumber");
                String getAddress = request.getParameter("address");
                String getDentistImage = request.getParameter("dentistImage");
                String getYearsOfExp = request.getParameter("yearsOfExp");
                String getSkills = request.getParameter("skills");
                String getSalary = request.getParameter("salary");
                String getInsurance = request.getParameter("insurance");
                String getDescriptionDentist = request.getParameter("descriptionDentist");
                String dentistID = FunctionRandom.randomID(10);

                AccountError accountError = new AccountError();
                DentistError dentistError = new DentistError();
                boolean hasError = false;

                if (getFullName.equals("") && getGender.equals("") && getDateOfBirth.equals("") && getEmail.equals("") && getPhoneNumber.equals("") && getAddress.equals("") && getDentistImage.equals("") && getYearsOfExp.equals("") && getSkills.equals("") && getSalary.equals("") && getInsurance.equals("") && getDescriptionDentist.equals("")) {
                    hasError = true;
                    accountError.setFullNameError("Please enter full name!");
                    accountError.setGenderError("Please choose gender!");
                    accountError.setDateOfBirthError("Please choose date of birth!");
                    accountError.setEmailError("Please enter email!");
                    accountError.setPhoneNumberError("Please enter phone number!");
                    accountError.setAddressError("Please enter address!");
                    accountError.setImageError("Please choose image avatar!");
                    dentistError.setYearsOfExpError("Please enter years of experience!");
                    dentistError.setSkillError("Please enter skill!");
                    dentistError.setSalaryError("Please enter salary!");
                    dentistError.setInsuranceError("Please enter insurance!");
                    dentistError.setDescriptionDentistError("Please enter description dentist!");
                } else if (getFullName.equals("")) {
                    hasError = true;
                    accountError.setFullNameError("Please enter full name!");
                } else if (getGender.equals("")) {
                    hasError = true;
                    accountError.setGenderError("Please choose gender!");
                } else if (getDateOfBirth.equals("")) {
                    hasError = true;
                    accountError.setDateOfBirthError("Please choose date of birth!");
                } else if (getEmail.equals("")) {
                    hasError = true;
                    accountError.setEmailError("Please enter email!");
                } else if (getPhoneNumber.equals("")) {
                    hasError = true;
                    accountError.setPhoneNumberError("Please enter phone number!");
                } else if (getAddress.equals("")) {
                    hasError = true;
                    accountError.setAddressError("Please enter address!");
                } else if (getDentistImage.equals("")) {
                    hasError = true;
                    accountError.setImageError("Please choose image avatar!");
                } else if (getYearsOfExp.equals("")) {
                    hasError = true;
                    dentistError.setYearsOfExpError("Please enter years of experience!");
                } else if (getSkills.equals("")) {
                    hasError = true;
                    dentistError.setSkillError("Please enter skill!");
                } else if (getSalary.equals("")) {
                    hasError = true;
                    dentistError.setSalaryError("Please enter salary!");
                } else if (getInsurance.equals("")) {
                    hasError = true;
                    dentistError.setInsuranceError("Please enter insurance!");
                } else if (getDescriptionDentist.equals("")) {
                    hasError = true;
                    dentistError.setDescriptionDentistError("Please enter description dentist!");
                }

                if (hasError) {
                    request.setAttribute(FULL_NAME, getFullName);
                    request.setAttribute(DATE_OF_BIRTH, getDateOfBirth);
                    request.setAttribute(EMAIL, getEmail);
                    request.setAttribute(PHONE_NUMBER, getPhoneNumber);
                    request.setAttribute(ADDRESS, getAddress);
                    if (!getDentistImage.equals("")) {
                        String[] cutCodeImage = getDentistImage.split("\\,");
                        request.setAttribute(DENTIST_IMAGE, cutCodeImage[1]);
                    } else {
                        request.setAttribute(DENTIST_IMAGE, null);
                    }
                    request.setAttribute(YEAR_OF_EXPERIENCE, getYearsOfExp);
                    request.setAttribute(SKILL, getSkills);
                    request.setAttribute(SALARY, getSalary);
                    request.setAttribute(INSURANCE, getInsurance);
                    request.setAttribute(DESCRIPTION_DENTIST, getDescriptionDentist);
                    request.setAttribute(DENTIST_ACCOUNT_ERROR, accountError);
                    request.setAttribute(DENTIST_INFO_ERROR, dentistError);
                    request.setAttribute(MENU_BAR, MENU_BAR);
                    request.setAttribute(MENU_BAR_ICON, "<i class=\"fa-solid fa-plus icon\"></i>");
                    request.setAttribute(BUTTON_ACTION, "Add Dentist");
                    request.setAttribute(ACTION_URL, "" + request.getContextPath() + "/admin/add-dentist");

                    RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/AddDentist.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    String generatePassword = DigestUtils.md5Hex("123456");

                    account = new Account();
                    dentist = new Dentist();
                    account.setUserID(dentistID);
                    account.setFullName(getFullName);
                    account.setUserPassword(generatePassword);
                    account.setSex(getGender);
                    if (getDateOfBirth != null) {
                        Date convertDateOfBirth = Date.valueOf(getDateOfBirth);
                        account.setDateOfBirth(convertDateOfBirth);
                    }
                    account.setUserEmail(getEmail);
                    account.setUserPhone(getPhoneNumber);
                    account.setUserAddress(getAddress);
                    if (!getDentistImage.equals("")) {
                        String[] cutCodeImage = getDentistImage.split("\\,");
                        account.setImageAvatar(cutCodeImage[1]);
                    }
                    String colorAvatar = FunctionRandom.colorAvatar();
                    char getFirstCharacter = getFullName.charAt(0);

                    account.setColorAvatar(colorAvatar);
                    account.setDefaultAvatar(Character.toString(getFirstCharacter));
                    account.setUserRole(2);
                    account.setUserStatus(1);

                    dentist.setDentistID(dentistID);
                    dentist.setYearsOfExp(Integer.parseInt(getYearsOfExp));
                    dentist.setSkill(getSkills);
                    dentist.setSalary(Double.parseDouble(getSalary));
                    dentist.setInsurance(Double.parseDouble(getInsurance));
                    dentist.setDescriptionDentist(getDescriptionDentist);

                    accountFacade.addAccount(account, "AddAccount");
                    dentistFacade.addDentist(dentist);

                    response.sendRedirect(request.getContextPath() + "/admin/dentist-management");
                }
            } else if (urlServlet.equals("/admin/edit-dentist")) {
                String dentistID = request.getParameter("did");
                String getFullName = request.getParameter("fullName");
                String getGender = request.getParameter("gender");
                if (getGender == null) {
                    getGender = "";
                } else {
                    getGender = request.getParameter("gender");
                }
                String getDateOfBirth = request.getParameter("dateOfBirth");
                String getEmail = request.getParameter("email");
                String getPhoneNumber = request.getParameter("phoneNumber");
                String getAddress = request.getParameter("address");
                String getDentistImage = request.getParameter("dentistImage");
                String getYearsOfExp = request.getParameter("yearsOfExp");
                String getSkills = request.getParameter("skills");
                String getSalary = request.getParameter("salary");
                String getDescriptionDentist = request.getParameter("descriptionDentist");
                String getInsurance = request.getParameter("insurance");

                AccountError accountError = new AccountError();
                DentistError dentistError = new DentistError();
                boolean hasError = false;

                if (getFullName.equals("") && getGender.equals("") && getDateOfBirth.equals("") && getEmail.equals("") && getPhoneNumber.equals("") && getAddress.equals("") && getDentistImage.equals("") && getYearsOfExp.equals("") && getSkills.equals("") && getSalary.equals("") && getInsurance.equals("") && getDescriptionDentist.equals("")) {
                    hasError = true;
                    accountError.setFullNameError("Please enter full name!");
                    accountError.setGenderError("Please choose gender!");
                    accountError.setDateOfBirthError("Please choose date of birth!");
                    accountError.setEmailError("Please enter email!");
                    accountError.setPhoneNumberError("Please enter phone number!");
                    accountError.setAddressError("Please enter address!");
                    accountError.setImageError("Please choose image avatar!");
                    dentistError.setYearsOfExpError("Please enter years of experience!");
                    dentistError.setSkillError("Please enter skill!");
                    dentistError.setSalaryError("Please enter salary!");
                    dentistError.setInsuranceError("Please enter insurance!");
                    dentistError.setDescriptionDentistError("Please enter description dentist!");
                } else if (getFullName.equals("")) {
                    hasError = true;
                    accountError.setFullNameError("Please enter full name!");
                } else if (getGender.equals("")) {
                    hasError = true;
                    accountError.setGenderError("Please choose gender!");
                } else if (getDateOfBirth.equals("")) {
                    hasError = true;
                    accountError.setDateOfBirthError("Please choose date of birth!");
                } else if (getEmail.equals("")) {
                    hasError = true;
                    accountError.setEmailError("Please enter email!");
                } else if (getPhoneNumber.equals("")) {
                    hasError = true;
                    accountError.setPhoneNumberError("Please enter phone number!");
                } else if (getAddress.equals("")) {
                    hasError = true;
                    accountError.setAddressError("Please enter address!");
                } else if (getDentistImage.equals("")) {
                    hasError = true;
                    accountError.setImageError("Please choose image avatar!");
                } else if (getYearsOfExp.equals("")) {
                    hasError = true;
                    dentistError.setYearsOfExpError("Please enter years of experience!");
                } else if (getSkills.equals("")) {
                    hasError = true;
                    dentistError.setSkillError("Please enter skill!");
                } else if (getSalary.equals("")) {
                    hasError = true;
                    dentistError.setSalaryError("Please enter salary!");
                } else if (getInsurance.equals("")) {
                    hasError = true;
                    dentistError.setInsuranceError("Please enter insurance!");
                } else if (getDescriptionDentist.equals("")) {
                    hasError = true;
                    dentistError.setDescriptionDentistError("Please enter description dentist!");
                }

                if (hasError) {
                    request.setAttribute(FULL_NAME, getFullName);
                    request.setAttribute(DATE_OF_BIRTH, getDateOfBirth);
                    request.setAttribute(EMAIL, getEmail);
                    request.setAttribute(PHONE_NUMBER, getPhoneNumber);
                    request.setAttribute(ADDRESS, getAddress);
                    if (!getDentistImage.equals("")) {
                        String[] cutCodeImage = getDentistImage.split("\\,");
                        request.setAttribute(DENTIST_IMAGE, cutCodeImage[1]);
                    } else {
                        request.setAttribute(DENTIST_IMAGE, null);
                    }
                    request.setAttribute(YEAR_OF_EXPERIENCE, getYearsOfExp);
                    request.setAttribute(SKILL, getSkills);
                    request.setAttribute(SALARY, getSalary);
                    request.setAttribute(INSURANCE, getInsurance);
                    request.setAttribute(DESCRIPTION_DENTIST, getDescriptionDentist);
                    request.setAttribute(DENTIST_ACCOUNT_ERROR, accountError);
                    request.setAttribute(DENTIST_INFO_ERROR, dentistError);
                    request.setAttribute(MENU_BAR, MENU_BAR);
                    request.setAttribute(MENU_BAR_ICON, "<i class=\"fa-solid fa-pen-to-square icon\"></i>");
                    request.setAttribute(BUTTON_ACTION, "Edit Dentist");
                    request.setAttribute(ACTION_URL, "" + request.getContextPath() + "/admin/edit-dentist?did=" + dentistID + "");

                    RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/views/admin/AddDentist.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    account = new Account();
                    dentist = new Dentist();

                    account.setFullName(getFullName);
                    account.setSex(getGender);
                    if (getDateOfBirth != null) {
                        Date convertDateOfBirth = Date.valueOf(getDateOfBirth);
                        account.setDateOfBirth(convertDateOfBirth);
                    }
                    account.setUserEmail(getEmail);
                    account.setUserPhone(getPhoneNumber);
                    account.setUserAddress(getAddress);
                    if (!getDentistImage.equals("")) {
                        String[] cutCodeImage = getDentistImage.split("\\,");
                        account.setImageAvatar(cutCodeImage[1]);
                    }

                    dentist.setDentistID(dentistID);
                    dentist.setYearsOfExp(Integer.parseInt(getYearsOfExp));
                    dentist.setSkill(getSkills);
                    dentist.setSalary(Double.parseDouble(getSalary));
                    dentist.setInsurance(Double.parseDouble(getInsurance));
                    dentist.setDescriptionDentist(getDescriptionDentist);

                    accountFacade.updateAccount(account, "EditProfile");
                    dentistFacade.updateDentist(dentist);
                    response.sendRedirect(request.getContextPath() + "/admin/dentist-management");
                }
            }

        } catch (IOException | NumberFormatException | SQLException | ServletException e) {
            response.sendRedirect(request.getContextPath() + "/error");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
