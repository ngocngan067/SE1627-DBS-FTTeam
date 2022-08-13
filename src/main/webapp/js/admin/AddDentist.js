$("#cb1").on("click", () => {
    if ($("#cb1").hasClass("cb-uncheck")) {
        $("#cb1").removeClass("cb-uncheck");
    }
    $("#cb1").addClass("cb-check");
    $("#cb2").attr("checked", false);
    if ($("#cb2").hasClass("cb-check")) {
        $("#cb2").removeClass("cb-check");
        $("#cb2").addClass("cb-uncheck");
    }
});

$("#cb2").on("click", () => {
    if ($("#cb2").hasClass("cb-uncheck")) {
        $("#cb2").removeClass("cb-uncheck");
    }
    $("#cb2").addClass("cb-check");
    $("#cb1").attr("checked", false);
    if ($("#cb1").hasClass("cb-check")) {
        $("#cb1").removeClass("cb-check");
        $("#cb1").addClass("cb-uncheck");
    }
});

$("#imageInput").on("change", function () {
    $input = $(this);
    if ($input.val().length > 0) {
        fileReader = new FileReader();
        fileReader.onload = function (data) {
            $(".image-preview").attr("src", data.target.result);
            $(".image-hidden").attr({"value": data.target.result, "name": "dentistImage"});
        };
        fileReader.readAsDataURL($input.prop("files")[0]);
        $(".image-button").css("display", "none");
        $(".image-preview").css("display", "block");
        $(".image-preview").css("width", "100%");
        $(".image-preview").css("border-radius", "20px");
        $(".change-image").css("display", "block");
    }
});

$(".change-image").on("click", function () {
    $control = $(this);
    $("#imageInput").val("");
    $preview = $(".image-preview");
    $preview.attr("src", "");
    $preview.css("display", "none");
    $control.css("display", "none");
    $(".image-button").css("display", "block");
});

function CheckFullName() {
    const inputFullName = document.querySelector(".full-name"),
            fullNameErrorMessage = document.querySelector(".full-name-error p");

    if (inputFullName.value === "") {
        inputFullName.style.border = "1px solid red";
        fullNameErrorMessage.innerHTML = "Please enter full name!";
    } else {
        inputFullName.style.border = "1px solid green";
        fullNameErrorMessage.innerHTML = "";
    }
}

// function check email
function validateEmail(email) {
    const re =
            /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

function CheckEmail() {
    const emailInput = document.querySelector(".email"),
            errorEmail = document.querySelector(".email-error p");

    if (emailInput.value === "") {
        emailInput.style.border = "1px solid red";
        errorEmail.innerHTML = "Please enter your email!";
    } else if (!validateEmail(emailInput.value)) {
        emailInput.style.border = "1px solid red";
        errorEmail.innerHTML = "Please enter correct email format!";
    } else {
        emailInput.style.border = "1px solid green";
        errorEmail.innerHTML = "";
    }
}

function CheckPhoneNumber() {
    const inputPhoneNumber = document.querySelector(".phone-number"),
            phoneNumberErrorMessage = document.querySelector(".phone-number-error p");

    if (inputPhoneNumber.value === "") {
        inputPhoneNumber.style.border = "1px solid red";
        phoneNumberErrorMessage.innerHTML = "Please enter your phone number!";
    } else if (
            inputPhoneNumber.value.length < 10 ||
            inputPhoneNumber.value.length > 10
            ) {
        inputPhoneNumber.style.border = "1px solid red";
        phoneNumberErrorMessage.innerHTML = "Phone number must have 10 digits!";
    } else {
        inputPhoneNumber.style.border = "1px solid green";
        phoneNumberErrorMessage.innerHTML = "";
    }
}

function CheckAddress() {
    const inputAddress = document.querySelector(".address"),
            addressErrorMessage = document.querySelector(".address-error p");

    if (inputAddress.value === "") {
        inputAddress.style.border = "1px solid red";
        addressErrorMessage.innerHTML = "Please enter your address!";
    } else {
        inputAddress.style.border = "1px solid green";
        addressErrorMessage.innerHTML = "";
    }
}

function CheckYearsOfExp() {
    const inputYearsOfExp = document.querySelector(".years-of-exp"),
            yearsOfExpErrorMessage = document.querySelector(".years-of-exp-error p");

    if (inputYearsOfExp.value === "") {
        inputYearsOfExp.style.border = "1px solid red";
        yearsOfExpErrorMessage.innerHTML = "Please enter years of experience!";
    } else {
        inputYearsOfExp.style.border = "1px solid green";
        yearsOfExpErrorMessage.innerHTML = "";
    }
}

function CheckSkills() {
    const inputSkills = document.querySelector(".skills"),
            skillsErrorMessage = document.querySelector(".skills-error p");

    if (inputSkills.value === "") {
        inputSkills.style.border = "1px solid red";
        skillsErrorMessage.innerHTML = "Please enter skill!";
    } else {
        inputSkills.style.border = "1px solid green";
        skillsErrorMessage.innerHTML = "";
    }
}

function CheckSalary() {
    const inputSalary = document.querySelector(".salary"),
            salaryErrorMessage = document.querySelector(".salary-error p");

    if (inputSalary.value === "") {
        inputSalary.style.border = "1px solid red";
        salaryErrorMessage.innerHTML = "Please enter salary!";
    } else {
        inputSalary.style.border = "1px solid green";
        salaryErrorMessage.innerHTML = "";
    }
}

function CheckInsurance() {
    const inputInsurance = document.querySelector(".insurance"),
            insuranceErrorMessage = document.querySelector(".insurance-error p");

    if (inputInsurance.value === "") {
        inputInsurance.style.border = "1px solid red";
        insuranceErrorMessage.innerHTML = "Please enter insurance!";
    } else {
        inputInsurance.style.border = "1px solid green";
        insuranceErrorMessage.innerHTML = "";
    }
}

function CheckDateOfBirth() {
    const inputDateOfBirth = document.querySelector(".dateOfBirth"),
            dateOfBirthErrorMessage = document.querySelector(".dateOfBirth-error p");

    if (inputDateOfBirth.value === "") {
        inputDateOfBirth.style.border = "1px solid red";
        dateOfBirthErrorMessage.innerHTML = "Please select date of birth!";
    } else {
        inputDateOfBirth.style.border = "1px solid green";
        dateOfBirthErrorMessage.innerHTML = "";
    }
}