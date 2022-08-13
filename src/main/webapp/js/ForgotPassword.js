PrintCopyRight();

function PrintCopyRight() {
    console.log("%cHello! \ud83d\ude4b", "color: #29c4a9;font-size: 16px;font-weight: 600;"),
            console.log("%cFresh Tooth front-end was built with HTML, CSS, and lots of love. \n\nFresh Tooth back-end was built with SQL Server, Java Web, and lots of love. \n\n\ud83d\udc49 Want to learn with us? Check out ".concat(window.location.origin, "/FreshTooth/home"), "color: #29c4a9;font-size: 14px;");
}

function validateEmail(email) {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

function CheckEmail() {
    const inputEmail = document.querySelector("#inputEmail");
    const emailInputField = document.querySelector("#email-input-field");
    const emailIconCheck = document.querySelector(".email-icon-check");
    const emailIconError = document.querySelector(".email-icon-error");
    const emailErrorMessage = document.querySelector("#email-error");

    if (inputEmail.value === '') {
        emailInputField.style.border = '1px solid red';
        emailErrorMessage.innerHTML = 'Please enter your Email';
        emailIconError.style.display = 'block';
        emailIconCheck.style.display = 'none';
    } else if (!validateEmail(inputEmail.value)) {
        emailInputField.style.border = '1px solid red';
        emailErrorMessage.innerHTML = 'Wrong email format';
        emailIconCheck.style.display = 'none';
        emailIconError.style.display = 'block';
    } else {
        emailInputField.style.border = '1px solid green';
        emailErrorMessage.innerHTML = '';
        emailIconCheck.style.display = 'block';
        emailIconError.style.display = 'none';
    }
}

function CheckPassword() {
    const inputOldPassword = document.querySelector("#inputOldPassword");
    const oldPasswordInputField = document.querySelector("#old-password-input-field");
    const oldPasswordIconCheck = document.querySelector(".old-password-icon-check");
    const oldPasswordIconError = document.querySelector(".old-password-icon-error");
    const oldPasswordErrorMessage = document.querySelector("#old-password-error");

    if (inputOldPassword.value === '') {
        oldPasswordInputField.style.border = '1px solid red';
        oldPasswordErrorMessage.innerHTML = 'Please enter your old password';
        oldPasswordIconError.style.display = 'block';
        oldPasswordIconCheck.style.display = 'none';
    } else {
        oldPasswordInputField.style.border = '1px solid green';
        oldPasswordErrorMessage.innerHTML = '';
        oldPasswordIconError.style.display = 'none';
        oldPasswordIconCheck.style.display = 'block';
    }
}

function OldPasswordKeyUp() {
    const inputOldPassword = document.querySelector("#inputOldPassword");
    const showOldPassword = document.querySelector("#show-old-password");
    const showOldPasswordIcon = document.querySelector("#show-old-password-icon");

    if (inputOldPassword.value !== '') {
        showOldPassword.style.display = "block";
        showOldPassword.onclick = function () {
            if (inputOldPassword.type === "password") {
                showOldPasswordIcon.className = "fas fa-eye";
                inputOldPassword.type = "text";
            } else {
                showOldPasswordIcon.className = "fas fa-eye-slash";
                inputOldPassword.type = "password";
            }
        };
    } else {
        showOldPassword.style.display = "none";
    }
}

function CheckNewPassword() {
    const inputNewPassword = document.querySelector("#inputNewPassword");
    const newPasswordInputField = document.querySelector("#new-password-input-field");
    const newPasswordIconCheck = document.querySelector(".new-password-icon-check");
    const newPasswordIconError = document.querySelector(".new-password-icon-error");
    const newPasswordErrorMessage = document.querySelector("#new-password-error");

    if (inputNewPassword.value === '') {
        newPasswordInputField.style.border = '1px solid red';
        newPasswordErrorMessage.innerHTML = 'Please enter your new password';
        newPasswordIconError.style.display = 'block';
        newPasswordIconCheck.style.display = 'none';
    } else {
        newPasswordInputField.style.border = '1px solid green';
        newPasswordErrorMessage.innerHTML = '';
        newPasswordIconError.style.display = 'none';
        newPasswordIconCheck.style.display = 'block';
    }
}

function CheckPasswordStrength() {
    const indicator = document.querySelector(".indicator-new-password");
    const inputNewPassword = document.querySelector("#inputNewPassword");
    const passwordWeak = document.querySelector(".weak");
    const passwordMedium = document.querySelector(".medium");
    const passwordStrong = document.querySelector(".strong");
    const errorNewPassword = document.querySelector(".error-indicator-text");
    const showNewPassword = document.querySelector("#show-new-password");
    const showNewPasswordIcon = document.querySelector("#show-new-password-icon");
    let regExpWeak = /[a-z]/;
    let regExpMedium = /\d+/;
    let regExpStrong = /.[!,@,#,$,%,^,&,*,?,_,~,(,)]/;
    let no;

    if (inputNewPassword.value !== "") {
        indicator.style.display = "block";
        indicator.style.display = "flex";
        if (inputNewPassword.value.length <= 3 && (inputNewPassword.value.match(regExpWeak) || inputNewPassword.value.match(regExpMedium) || inputNewPassword.value.match(regExpStrong)))
            no = 1;
        if (inputNewPassword.value.length >= 6 && ((inputNewPassword.value.match(regExpWeak) && inputNewPassword.value.match(regExpMedium)) || (inputNewPassword.value.match(regExpMedium) && inputNewPassword.value.match(regExpStrong)) || (inputNewPassword.value.match(regExpWeak) && inputNewPassword.value.match(regExpStrong))))
            no = 2;
        if (inputNewPassword.value.length >= 6 && inputNewPassword.value.match(regExpWeak) && inputNewPassword.value.match(regExpMedium) && inputNewPassword.value.match(regExpStrong))
            no = 3;
        if (no === 1) {
            passwordWeak.classList.add("active");
            errorNewPassword.style.display = "block";
            errorNewPassword.textContent = "Your password is too week";
            errorNewPassword.classList.add("weak");
        }
        if (no === 2) {
            passwordMedium.classList.add("active");
            errorNewPassword.textContent = "Your password is medium";
            errorNewPassword.classList.add("medium");
        } else {
            passwordMedium.classList.remove("active");
            errorNewPassword.classList.remove("medium");
        }
        if (no === 3) {
            passwordMedium.classList.add("active");
            passwordStrong.classList.add("active");
            errorNewPassword.textContent = "Your password is strong";
            errorNewPassword.classList.add("strong");
        } else {
            passwordStrong.classList.remove("active");
            errorNewPassword.classList.remove("strong");
        }
        showNewPassword.style.display = "block";
        showNewPassword.onclick = function () {
            if (inputNewPassword.type === "password") {
                showNewPasswordIcon.className = "fas fa-eye";
                inputNewPassword.type = "text";
            } else {
                showNewPasswordIcon.className = "fas fa-eye-slash";
                inputNewPassword.type = "password";
            }
        };
    } else {
        indicator.style.display = "none";
        errorNewPassword.style.display = "none";
        showNewPassword.style.display = "none";
    }
}

function CheckConfirmPassword() {
    const inputConfirmPassword = document.querySelector("#inputConfirmPassword");
    const confirmPasswordInputField = document.querySelector("#confirm-password-input-field");
    const confirmPasswordIconCheck = document.querySelector(".confirm-password-icon-check");
    const confirmPasswordIconError = document.querySelector(".confirm-password-icon-error");
    const confirmPasswordErrorMessage = document.querySelector("#confirm-password-error");

    if (inputConfirmPassword.value === '') {
        confirmPasswordInputField.style.border = '1px solid red';
        confirmPasswordErrorMessage.innerHTML = 'Please enter your confirm password';
        confirmPasswordIconError.style.display = 'block';
        confirmPasswordIconCheck.style.display = 'none';
    } else {
        confirmPasswordInputField.style.border = '1px solid green';
        confirmPasswordErrorMessage.innerHTML = '';
        confirmPasswordIconError.style.display = 'none';
        confirmPasswordIconCheck.style.display = 'block';
    }
}

function ConfirmPasswordKeyUp() {
    const inputConfirmPassword = document.querySelector("#inputConfirmPassword");
    const showConfirmPassword = document.querySelector("#show-confirm-password");
    const showConfirmPasswordIcon = document.querySelector("#show-confirm-password-icon");

    if (inputConfirmPassword.value !== '') {
        showConfirmPassword.style.display = "block";
        showConfirmPassword.onclick = function () {
            if (inputConfirmPassword.type === "password") {
                showConfirmPasswordIcon.className = "fas fa-eye";
                inputConfirmPassword.type = "text";
            } else {
                showConfirmPasswordIcon.className = "fas fa-eye-slash";
                inputConfirmPassword.type = "password";
            }
        };
    } else {
        showConfirmPassword.style.display = "none";
    }
}

function CheckVerifyCode() {
    const inputVerifyCode = document.querySelector("#inputVerifyCode");
    const verifyCodeInputField = document.querySelector("#verify-code-input-field");
    const verifyCodeIconCheck = document.querySelector(".verify-code-icon-check");
    const verifyCodeIconError = document.querySelector(".verify-code-icon-error");
    const verifyCodeErrorMessage = document.querySelector("#verify-code-error");

    if (inputVerifyCode.value === '') {
        verifyCodeInputField.style.border = '1px solid red';
        verifyCodeErrorMessage.innerHTML = 'Please enter your verify code';
        verifyCodeIconError.style.display = 'block';
        verifyCodeIconCheck.style.display = 'none';
    } else {
        verifyCodeInputField.style.border = '1px solid green';
        verifyCodeErrorMessage.innerHTML = '';
        verifyCodeIconError.style.display = 'none';
        verifyCodeIconCheck.style.display = 'block';
    }
}

function ButtonSend(value, url) {
    if (value !== "") {
        let tl = new gsap.timeline({defaults: {ease: Circ.easeOut}});
        const player = document.querySelector('.success-image');

        tl.paused(true);
        tl.to('.img-lock', {y: 40, opacity: 0, stagger: .05});
        tl.to('.reset-box', {opacity: 0, display: "none"}, "-=.4");
        tl.to('.success-title', {opacity: 1, duration: 2}, "+=1");
        tl.play();
        setTimeout(() => {
            player.play();
        }, 800);
        setTimeout(() => {
            window.location.href = url;
        }, 5000);
    }
}