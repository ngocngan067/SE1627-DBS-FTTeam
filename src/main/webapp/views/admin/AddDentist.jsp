<%@page import="com.teamthree.freshtooth.models.DentistError"%>
<%@page import="com.teamthree.freshtooth.models.AccountError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%  
    AccountError accountError = (AccountError) request.getAttribute("DENTIST_ACCOUNT_ERROR");
    DentistError dentistError = (DentistError) request.getAttribute("DENTIST_INFO_ERROR");
    if(accountError == null) {
        accountError = new AccountError();
    }
    
    if (dentistError == null) {
        dentistError = new DentistError();
    }
    
    String imageDentist = (String) request.getAttribute("DENTIST_IMAGE");
    String concatStringImage = "";
    if (imageDentist != null) {
        concatStringImage = "data:image/png;base64," + imageDentist;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>${BUTTON_ACTION}</title>
        <link rel="icon" type="image/png" sizes="200x138" href=".././images/iconFT.png">
        <!-- LINK FONTAWESOME -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.1.1/css/all.css">
        <!-- LINK UNICONS -->
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
        <!-- LINK BOOTSTRAP -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- LINK CSS -->
        <link href=".././css/admin/AdminRoot.css" rel="stylesheet" type="text/css"/>
        <link href=".././css/ScrollBackToTop.css" rel="stylesheet" type="text/css"/>
        <link href=".././css/admin/NavBar.css" rel="stylesheet" type="text/css"/>
        <link href=".././css/admin/MenuBar.css" rel="stylesheet" type="text/css"/>
        <link href=".././css/admin/AddDentist.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="../../layouts/ScrollBackToTop.html"></jsp:include>
        <jsp:include page="../../layouts/admin/MenuBar.jsp"></jsp:include>
        
        <!-- Main -->
        <div class="body-main">
            <jsp:include page="../../layouts/admin/NavBar.jsp"></jsp:include>

            <div class="form_wrapper">
                <div class="form_container">
                    <div class="title_container">
                        <h2>${BUTTON_ACTION}</h2>
                    </div>
                    <div class="row clearfix">
                        <div>
                            <form action="${ACTION_URL}" method="post">
                                <div class="input_field">
                                    <span>
                                        <i class="fa-solid fa-font"></i>
                                    </span>
                                    <input type="text" class="full-name" name="fullName" value="${FULL_NAME != null ? FULL_NAME : ""}" placeholder="Full Name" oninput="CheckFullName()" onblur="CheckFullName()" />
                                </div>
                                <div class="text-danger full-name-error">
                                    <p><%=accountError.getFullNameError()%></p>
                                </div>
                                <div class="input_field checkbox_option">
                                    <input type="checkbox" id="cb1" class="" name="gender" value="M">
                                    <label for="cb1">Male</label>
                                    <input type="checkbox" id="cb2" class="" name="gender" value="F">
                                    <label for="cb2">Female</label>
                                </div>
                                <div class="text-danger gender-error">
                                    <p><%=accountError.getGenderError()%></p>
                                </div>
                                <div class="input_field">
                                    <span>
                                        <i class="fa-solid fa-calendar-days"></i>
                                    </span>
                                    <input type="date" class="dateOfBirth" name="dateOfBirth" value="${DATE_OF_BIRTH != null ? DATE_OF_BIRTH : ""}" placeholder="Date Of Birth" onblur="CheckDateOfBirth()" />
                                </div>
                                <div class="text-danger dateOfBirth-error">
                                    <p><%=accountError.getDateOfBirthError()%></p>
                                </div>
                                <div class="input_field">
                                    <span>
                                        <i class="fa-solid fa-at"></i>
                                    </span>
                                    <input type="email" class="email" name="email" value="${EMAIL != null ? EMAIL : ""}" placeholder="Email" oninput="CheckEmail()" onblur="CheckEmail()" />
                                </div>
                                <div class="text-danger email-error">
                                    <p><%=accountError.getEmailError()%></p>
                                </div>
                                <div class="input_field">
                                    <span>
                                        <i class="fa-solid fa-mobile"></i>
                                    </span>
                                    <input type="number" class="phone-number" name="phoneNumber" value="${PHONE_NUMBER != null ? PHONE_NUMBER : ""}" placeholder="Phone Number" oninput="CheckPhoneNumber()" onblur="CheckPhoneNumber()" />
                                </div>
                                <div class="text-danger phone-number-error">
                                    <p><%=accountError.getPhoneNumberError()%></p>
                                </div>
                                <div class="input_field">
                                    <span>
                                        <i class="fa-solid fa-location-dot"></i>
                                    </span>
                                    <input type="text" class="address" name="address" value="${ADDRESS != null ? ADDRESS : ""}" placeholder="Address" oninput="CheckAddress()" onblur="CheckAddress()" />
                                </div>
                                <div class="text-danger address-error">
                                    <p><%=accountError.getAddressError()%></p>
                                </div>
                                <div class="input_field">
                                    <div class="image-input">
                                        <input type="file" accept="image/*" id="imageInput">
                                        <img src="<%=concatStringImage%>" class="image-preview image-edit">
                                        <input type="hidden" class="image-hidden" name="dentistImage" value="<%=concatStringImage%>">
                                        <label for="imageInput" class="image-button add-button">
                                            <i class="fa-solid fa-image"></i>Avatar Picture
                                        </label>
                                        <span class="change-image">Change Picture</span>
                                    </div>
                                </div>
                                <div class="text-danger image-error">
                                    <p><%=accountError.getImageError()%></p>
                                </div>
                                <div class="input_field">
                                    <span>
                                        <i class="fa-solid fa-calendar-days"></i>
                                    </span>
                                    <input type="number" class="years-of-exp" name="yearsOfExp" value="${YEAR_OF_EXPERIENCE != null ? YEAR_OF_EXPERIENCE : ""}" placeholder="Years Of Experience" oninput="CheckYearsOfExp()" onblur="CheckYearsOfExp()"/>
                                </div>
                                <div class="text-danger years-of-exp-error">
                                    <p><%=dentistError.getYearsOfExpError()%></p>
                                </div>
                                <div class="input_field">
                                    <span>
                                        <i class="fa-solid fa-brain"></i>
                                    </span>
                                    <input type="text" class="skills" name="skills" value="${SKILL != null ? SKILL : ""}" placeholder="Skill" oninput="CheckSkills()" onblur="CheckSkills()"/>
                                </div>
                                <div class="text-danger skills-error">
                                    <p><%=dentistError.getSkillError()%></p>
                                </div>
                                <div class="input_field">
                                    <span>
                                        <i class="fa-solid fa-money-bill"></i>
                                    </span>
                                    <input type="text" class="salary" name="salary" value="<fmt:formatNumber value="${SALARY}" type="currency" />" placeholder="Salary" oninput="CheckSalary()" onblur="CheckSalary()"/>
                                </div>
                                <div class="text-danger salary-error">
                                    <p><%=dentistError.getSalaryError()%></p>
                                </div>
                                <div class="input_field">
                                    <span>
                                        <i class="fa-solid fa-id-card"></i>
                                    </span>
                                    <input type="text" class="insurance" name="insurance" value="<fmt:formatNumber pattern="#,##0" value="${INSURANCE}"/>" placeholder="Insurance" oninput="CheckInsurance()" onblur="CheckInsurance()"/>
                                </div>
                                <div class="text-danger insurance-error">
                                    <p><%=dentistError.getInsuranceError()%></p>
                                </div>
                                <div class="input_field">
                                    <textarea name="descriptionDentist" class="dentist-discription" required id="editor">${DESCRIPTION_DENTIST != null ? DESCRIPTION_DENTIST : ""}</textarea>
                                </div>
                                <div class="text-danger dentist-description-error">
                                    <p><%=dentistError.getDescriptionDentistError()%></p>
                                </div>
                                <input class="button add-service" type="submit" value="${BUTTON_ACTION}" />
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Main -->
        
        <!-- JQUERY -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- LINK BOOTSTRAP -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- LINK UNICONS -->
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <!-- LINK CKEDITOR -->
        <script src="//cdn.ckeditor.com/4.19.0/full/ckeditor.js"></script>v
        <!-- Script -->
        <script src=".././js/admin/AdminRoot.js"></script>
        <script src=".././js/admin/NavBar.js"></script>
        <script src=".././js/admin/AddDentist.js"></script>
        <script>
            CKEDITOR.replace('editor', {
                language: 'en',
                editorplaceholder: 'Start typing here...'
            });
            setActiveMenuBar();
        </script>
    </body>
</html>
