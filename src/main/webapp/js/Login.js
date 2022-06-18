PrintCopyRight();

function PrintCopyRight() {
    console.log("%cHello! \ud83d\ude4b", "color: #29c4a9;font-size: 16px;font-weight: 600;"),
            console.log("%cFresh Tooth front-end was built with HTML, CSS, and lots of love. \n\nFresh Tooth back-end was built with SQL Server, Java Web, and lots of love. \n\n\ud83d\udc49 Want to learn with us? Check out ".concat(window.location.origin, "/FreshTooth/home"), "color: #29c4a9;font-size: 14px;");
}

//Loader
const loader = document.querySelector("#preloader");

//Hàm check email
function validateEmail(email) {
    const re =
            /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

function ClearDataInSignIn() {
    const container = document.querySelector(".body_container"),
            emailSigninField = document.querySelector("#signinEmailField"),
            passwordSigninField = document.querySelector("#signinPasswordField"),
            errorEmailSignin = document.querySelector("#email_error_signin"),
            errorPasswordSignin = document.querySelector("#password_error_signin"),
            emailSigninInput = document.querySelector("#signinEmail"),
            passwordSigninInput = document.querySelector("#signinPassword"),
            iconCheckEmailSignin = document.querySelector(".signin_email_icon_check"),
            iconCheckPasswordSignin = document.querySelector(
                    ".signin_password_icon_check"
                    ),
            iconErrorEmailSignin = document.querySelector(".signin_email_icon_error"),
            iconErrorPasswordSignin = document.querySelector(
                    ".signin_password_icon_error"
                    ),
            showSignInPasswordIcon = document.querySelector(
                    "#show-signin-password-icon"
                    );

    container.classList.add("sign_up_mode");
    emailSigninField.style.border = "transparent";
    errorEmailSignin.innerHTML = "";
    passwordSigninField.style.border = "transparent";
    errorPasswordSignin.innerHTML = "";
    iconCheckEmailSignin.style.display = "none";
    iconErrorEmailSignin.style.display = "none";
    iconCheckPasswordSignin.style.display = "none";
    iconErrorPasswordSignin.style.display = "none";
    emailSigninInput.value = "";
    passwordSigninInput.value = "";
    showSignInPasswordIcon.style.display = "none";
}

function ClearDataInSignUp() {
    const container = document.querySelector(".body_container"),
            fullnameSignupField = document.querySelector("#signupFullNameField"),
            emailSignupField = document.querySelector("#signupEmailField"),
            passwordSignupField = document.querySelector("#signupPasswordField"),
            confirmPasswordField = document.querySelector("#confirmPasswordField"),
            errorFullNameSignup = document.querySelector("#fullname_error_signup"),
            errorEmailSignup = document.querySelector("#email_error_signup"),
            errorPasswordSignup = document.querySelector("#password_error_signup"),
            errorConfirmPassword = document.querySelector(
                    "#confirm_password_error_signup"
                    ),
            fullnameSignupInput = document.querySelector("#signupFullName"),
            emailSignupInput = document.querySelector("#signupEmail"),
            passwordSignupInput = document.querySelector("#signupPassword"),
            confirmPasswordInput = document.querySelector("#confirmPassword"),
            iconCheckFullNameSignup = document.querySelector(
                    ".signup_fullname_icon_check"
                    ),
            iconCheckEmailSignup = document.querySelector(".signup_email_icon_check"),
            iconCheckPasswordSignup = document.querySelector(
                    ".signup_password_icon_check"
                    ),
            iconCheckConfirmPasswordSignup = document.querySelector(
                    ".confirm_password_icon_check"
                    ),
            iconErrorFullNameSignup = document.querySelector(
                    ".signup_fullname_icon_error"
                    ),
            iconErrorEmailSignup = document.querySelector(".signup_email_icon_error"),
            iconErrorPasswordSignup = document.querySelector(
                    ".signup_password_icon_error"
                    ),
            iconErrorConfirmPasswordSignup = document.querySelector(
                    ".confirm_password_icon_error"
                    ),
            showSignUpPasswordIcon = document.querySelector(
                    "#show-signup-password-icon"
                    ),
            showSignUpConfirmPasswordIcon = document.querySelector(
                    "#show-signup-confirm-password-icon"
                    );

    container.classList.remove("sign_up_mode");
    fullnameSignupField.style.border = "transparent";
    emailSignupField.style.border = "transparent";
    passwordSignupField.style.border = "transparent";
    confirmPasswordField.style.border = "transparent";
    errorFullNameSignup.innerHTML = "";
    errorEmailSignup.innerHTML = "";
    errorPasswordSignup.innerHTML = "";
    errorConfirmPassword.innerHTML = "";
    fullnameSignupInput.value = "";
    emailSignupInput.value = "";
    passwordSignupInput.value = "";
    confirmPasswordInput.value = "";
    iconCheckFullNameSignup.style.display = "none";
    iconCheckEmailSignup.style.display = "none";
    iconCheckPasswordSignup.style.display = "none";
    iconCheckConfirmPasswordSignup.style.display = "none";
    iconErrorFullNameSignup.style.display = "none";
    iconErrorEmailSignup.style.display = "none";
    iconErrorPasswordSignup.style.display = "none";
    iconErrorConfirmPasswordSignup.style.display = "none";
    showSignUpPasswordIcon.style.display = "none";
    showSignUpConfirmPasswordIcon.style.display = "none";
}

function CheckURL(urlPage) {
    const container = document.querySelector(".body_container");

    if (urlPage.includes("VALUE_LOGIN")) {
        container.classList.remove("sign_up_mode");
    } else {
        container.classList.add("sign_up_mode");
    }
}

// Function check input email in Sign in
function CheckSignInEmail() {
    const emailSigninInput = document.querySelector("#signinEmail"),
            emailSigninField = document.querySelector("#signinEmailField"),
            errorEmailSignin = document.querySelector("#email_error_signin"),
            iconCheckEmailSignin = document.querySelector(".signin_email_icon_check"),
            iconErrorEmailSignin = document.querySelector(".signin_email_icon_error");

    if (emailSigninInput.value === "") {
        emailSigninField.style.border = "1px solid red";
        errorEmailSignin.innerHTML = "Please enter your email!";
        iconErrorEmailSignin.style.display = "block";
        iconCheckEmailSignin.style.display = "none";
    } else if (!validateEmail(emailSigninInput.value)) {
        emailSigninField.style.border = "1px solid red";
        errorEmailSignin.innerHTML = "Please enter correct email format!";
        iconErrorEmailSignin.style.display = "block";
        iconCheckEmailSignin.style.display = "none";
    } else {
        emailSigninField.style.border = "1px solid green";
        errorEmailSignin.innerHTML = "";
        iconErrorEmailSignin.style.display = "none";
        iconCheckEmailSignin.style.display = "block";
    }
}

// Function check input password in Sign in
function CheckSignInPassword() {
    const passwordSignInInput = document.querySelector("#signinPassword"),
            passwordSignInField = document.querySelector("#signinPasswordField"),
            errorPasswordSignIn = document.querySelector("#password_error_signin"),
            iconCheckPasswordSignIn = document.querySelector(
                    ".signin_password_icon_check"
                    ),
            iconErrorPasswordSignIn = document.querySelector(
                    ".signin_password_icon_error"
                    );

    if (passwordSignInInput.value === "") {
        passwordSignInField.style.border = "1px solid red";
        errorPasswordSignIn.innerHTML = "Please enter your password!";
        iconCheckPasswordSignIn.style.display = "none";
        iconErrorPasswordSignIn.style.display = "block";
    } else {
        passwordSignInField.style.border = "1px solid green";
        errorPasswordSignIn.innerHTML = "";
        iconCheckPasswordSignIn.style.display = "block";
        iconErrorPasswordSignIn.style.display = "none";
    }
}

// Function show hide password in sign in
function PasswordSignInKeyUp() {
    const inputSignInPassword = document.querySelector("#signinPassword"),
            showSignInPasswordIcon = document.querySelector(
                    "#show-signin-password-icon"
                    ),
            signinPasswordField = document.querySelector("#signinPasswordField");

    if (inputSignInPassword.value !== "") {
        showSignInPasswordIcon.style.display = "block";
        signinPasswordField.style.gridTemplateColumns = "15% 65% 10% 10%";
        showSignInPasswordIcon.onclick = function () {
            if (inputSignInPassword.type === "password") {
                showSignInPasswordIcon.className = "fa-solid fa-eye";
                inputSignInPassword.type = "text";
            } else {
                showSignInPasswordIcon.className = "fa-solid fa-eye-slash";
                inputSignInPassword.type = "password";
            }
        };
    } else {
        showSignInPasswordIcon.style.display = "none";
        signinPasswordField.style.gridTemplateColumns = "15% 70% 15%";
    }
}

// Function check input full name in Sign up
function CheckSignUpFullname() {
    const fullnameSignUpInput = document.querySelector("#signupFullName"),
            fullnameSignUpField = document.querySelector("#signupFullNameField"),
            errorFullNameSignUp = document.querySelector("#fullname_error_signup"),
            iconCheckFullNameSignUp = document.querySelector(
                    ".signup_fullname_icon_check"
                    ),
            iconErrorFullNameSignUp = document.querySelector(
                    ".signup_fullname_icon_error"
                    );

    if (fullnameSignUpInput.value === "") {
        fullnameSignUpField.style.border = "1px solid red";
        errorFullNameSignUp.innerHTML = "Please enter your full name!";
        iconCheckFullNameSignUp.style.display = "none";
        iconErrorFullNameSignUp.style.display = "block";
    } else if (fullnameSignUpInput.value.length > 100) {
        fullnameSignUpField.style.border = "1px solid red";
        errorFullNameSignUp.innerHTML =
                "Please enter full name less than 100 characters!";
        iconCheckFullNameSignUp.style.display = "block";
        iconErrorFullNameSignUp.style.display = "none";
    } else {
        fullnameSignUpField.style.border = "1px solid green";
        errorFullNameSignUp.innerHTML = "";
        iconCheckFullNameSignUp.style.display = "block";
        iconErrorFullNameSignUp.style.display = "none";
    }
}

// Function check input email in Sign up
function CheckSignUpEmail() {
    const emailSignUpInput = document.querySelector("#signupEmail"),
            emailSignUpField = document.querySelector("#signupEmailField"),
            errorEmailSignUp = document.querySelector("#email_error_signup"),
            iconCheckEmailSignUp = document.querySelector(".signup_email_icon_check"),
            iconErrorEmailSignUp = document.querySelector(".signup_email_icon_error");

    if (emailSignUpInput.value === "") {
        emailSignUpField.style.border = "1px solid red";
        errorEmailSignUp.innerHTML = "Please enter your email!";
        iconCheckEmailSignUp.style.display = "none";
        iconErrorEmailSignUp.style.display = "block";
    } else if (!validateEmail(emailSignUpInput.value)) {
        emailSignUpField.style.border = "1px solid red";
        errorEmailSignUp.innerHTML = "Please enter correct email format!";
        iconCheckEmailSignUp.style.display = "none";
        iconErrorEmailSignUp.style.display = "block";
    } else {
        emailSignUpField.style.border = "1px solid green";
        errorEmailSignUp.innerHTML = "";
        iconCheckEmailSignUp.style.display = "block";
        iconErrorEmailSignUp.style.display = "none";
    }
}

// Function check input password in Sign up
function CheckSignUpPassword() {
    const passwordSignUpInput = document.querySelector("#signupPassword"),
            passwordSignUpField = document.querySelector("#signupPasswordField"),
            errorPasswordSignUp = document.querySelector("#password_error_signup"),
            iconCheckPasswordSignUp = document.querySelector(
                    ".signup_password_icon_check"
                    ),
            iconErrorPasswordSignUp = document.querySelector(
                    ".signup_password_icon_error"
                    );

    if (passwordSignUpInput.value === "") {
        passwordSignUpField.style.border = "1px solid red";
        errorPasswordSignUp.innerHTML = "Please enter your password!";
        iconCheckPasswordSignUp.style.display = "none";
        iconErrorPasswordSignUp.style.display = "block";
    } else if (passwordSignUpInput.value.length < 8) {
        passwordSignUpField.style.border = "1px solid red";
        errorPasswordSignUp.innerHTML =
                "Your password must be at least 8 characters!";
        iconCheckPasswordSignUp.style.display = "none";
        iconErrorPasswordSignUp.style.display = "block";
    } else if (passwordSignUpInput.value.search(/[a-z]/i) < 0) {
        passwordSignUpField.style.border = "1px solid red";
        errorPasswordSignUp.innerHTML =
                "Your password must contain at least one letter!";
        iconCheckPasswordSignUp.style.display = "none";
        iconErrorPasswordSignUp.style.display = "block";
    } else if (passwordSignUpInput.value.search(/[0-9]/) < 0) {
        passwordSignUpField.style.border = "1px solid red";
        errorPasswordSignUp.innerHTML =
                "Your password must contain at least one digit!";
        iconCheckPasswordSignUp.style.display = "none";
        iconErrorPasswordSignUp.style.display = "block";
    } else {
        passwordSignUpField.style.border = "1px solid green";
        errorPasswordSignUp.innerHTML = "";
        iconCheckPasswordSignUp.style.display = "block";
        iconErrorPasswordSignUp.style.display = "none";
    }
}

// Function show hide password in sign up
function PasswordSignUpKeyUp() {
    const inputSignUpPassword = document.querySelector("#signupPassword"),
            showSignUpPasswordIcon = document.querySelector(
                    "#show-signup-password-icon"
                    ),
            signupPasswordField = document.querySelector("#signupPasswordField");

    if (inputSignUpPassword.value !== "") {
        showSignUpPasswordIcon.style.display = "block";
        signupPasswordField.style.gridTemplateColumns = "15% 65% 10% 10%";
        showSignUpPasswordIcon.onclick = function () {
            if (inputSignUpPassword.type === "password") {
                showSignUpPasswordIcon.className = "fa-solid fa-eye";
                inputSignUpPassword.type = "text";
            } else {
                showSignUpPasswordIcon.className = "fa-solid fa-eye-slash";
                inputSignUpPassword.type = "password";
            }
        };
    } else {
        showSignUpPasswordIcon.style.display = "none";
        signupPasswordField.style.gridTemplateColumns = "15% 70% 15%";
    }
}

// Function check input confirm password in Sign up
function CheckSignUpConfirmPassword() {
    const confirmPasswordInput = document.querySelector("#confirmPassword"),
            confirmPasswordField = document.querySelector("#confirmPasswordField"),
            errorConfirmPassword = document.querySelector(
                    "#confirm_password_error_signup"
                    ),
            iconCheckConfirmPassword = document.querySelector(
                    ".confirm_password_icon_check"
                    ),
            iconErrorConfirmPassword = document.querySelector(
                    ".confirm_password_icon_error"
                    ),
            passwordSignupInput = document.querySelector("#signupPassword");

    if (confirmPasswordInput.value === "") {
        confirmPasswordField.style.border = "1px solid red";
        errorConfirmPassword.innerHTML = "Please enter confirm Password!";
        iconCheckConfirmPassword.style.display = "none";
        iconErrorConfirmPassword.style.display = "block";
    } else if (confirmPasswordInput.value !== passwordSignupInput.value) {
        confirmPasswordField.style.border = "1px solid red";
        errorConfirmPassword.innerHTML = "Password does not match!";
        iconCheckConfirmPassword.style.display = "none";
        iconErrorConfirmPassword.style.display = "block";
    } else {
        confirmPasswordField.style.border = "1px solid green";
        errorConfirmPassword.innerHTML = "";
        iconCheckConfirmPassword.style.display = "block";
        iconErrorConfirmPassword.style.display = "none";
    }
}

// Function show hide confirm password in sign up
function ConfirmPasswordSignUpKeyUp() {
    const inputSignUpConfirmPassword = document.querySelector("#confirmPassword"),
            showSignUpConfirmPasswordIcon = document.querySelector(
                    "#show-signup-confirm-password-icon"
                    ),
            signupConfirmPasswordField = document.querySelector(
                    "#confirmPasswordField"
                    );

    if (inputSignUpConfirmPassword.value !== "") {
        showSignUpConfirmPasswordIcon.style.display = "block";
        signupConfirmPasswordField.style.gridTemplateColumns = "15% 65% 10% 10%";
        showSignUpConfirmPasswordIcon.onclick = function () {
            if (inputSignUpConfirmPassword.type === "password") {
                showSignUpConfirmPasswordIcon.className = "fa-solid fa-eye";
                inputSignUpConfirmPassword.type = "text";
            } else {
                showSignUpConfirmPasswordIcon.className = "fa-solid fa-eye-slash";
                inputSignUpConfirmPassword.type = "password";
            }
        };
    } else {
        showSignUpConfirmPasswordIcon.style.display = "none";
        signupConfirmPasswordField.style.gridTemplateColumns = "15% 70% 15%";
    }
}

window.addEventListener("load", function () {
    loader.style.display = "none";
});

function preventBack() {
    window.history.forward();
}
setTimeout("preventBack()", 0);
window.onunload = function () {
    null;
};