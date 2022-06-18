var serviceName = $(".service-name-error").hasClass("d-none");
var servicePrice = $(".service-price-error").hasClass("d-none");
if (
        serviceName == false ||
        servicePrice == false
        ) {
    $(".add-service").attr("disabled", true);
} else {
    $(".add-service").removeAttr("disabled");
}

$(".service-name").on("input", () => {
    if ($(".service-name").val().toLowerCase() === "") {
        $(".service-name-error").removeClass("d-none");
    } else {
        $(".service-name-error").addClass("d-none");
    }
    var serviceName = $(".service-name-error").hasClass("d-none");
    var servicePrice = $(".service-price-error").hasClass("d-none");
    if (
            serviceName == false ||
            servicePrice == false
            ) {
        $(".add-service").attr("disabled", true);
    } else {
        $(".add-service").removeAttr("disabled");
    }
});

$(".service-price").on("input", () => {
    if ($(".service-price").val().toLowerCase() === "") {
        $(".service-price-error").removeClass("d-none");
    } else {
        $(".service-price-error").addClass("d-none");
    }
    var serviceName = $(".service-name-error").hasClass("d-none");
    var servicePrice = $(".service-price-error").hasClass("d-none");
    if (
            serviceName == false ||
            servicePrice == false
            ) {
        $(".add-service").attr("disabled", true);
    } else {
        $(".add-service").removeAttr("disabled");
    }
});

// function check email
function validateEmail(mail) {
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail)) {
        return true;
    } else {
        return false;
    }
}

// Show input picture
$("#imageInput").on("change", function () {
    $input = $(this);
    if ($input.val().length > 0) {
        fileReader = new FileReader();
        fileReader.onload = function (data) {
            $(".image-preview").attr("src", data.target.result);
            $(".image-hidden").attr({"value": data.target.result, "name": "serviceImage"});
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

function CheckServiceName() {
    const inputServiceName = document.querySelector(".service-name"),
            serviceNameErrorMessage = document.querySelector(".service-name-error p");

    if (inputServiceName.value === "") {
        inputServiceName.style.border = "1px solid red";
        serviceNameErrorMessage.innerHTML = "Please enter service name!";
    } else {
        inputServiceName.style.border = "1px solid green";
        serviceNameErrorMessage.innerHTML = "";
    }
}

function CheckServicePrice() {
    const inputServicePrice = document.querySelector(".service-price"),
            servicePriceErrorMessage = document.querySelector(".service-price-error p");

    if (inputServicePrice.value === "") {
        inputServicePrice.style.border = "1px solid red";
        servicePriceErrorMessage.innerHTML = "Please enter service price!";
    } else {
        inputServicePrice.style.border = "1px solid green";
        servicePriceErrorMessage.innerHTML = "";
    }
}

function CheckServiceDiscount() {
    const inputServiceDiscount = document.querySelector(".service-discount"),
            serviceDiscountErrorMessage = document.querySelector(".service-discount-error p");

    if (inputServiceDiscount.value === "") {
        inputServiceDiscount.style.border = "1px solid red";
        serviceDiscountErrorMessage.innerHTML = "Please enter discount!";
    } else if (inputServiceDiscount.value < 0 || inputServiceDiscount.value > 100) {
        inputServiceDiscount.style.border = "1px solid red";
        serviceDiscountErrorMessage.innerHTML = "Please enter between 0 and 100!";
    } else {
        inputServiceDiscount.style.border = "1px solid green";
        serviceDiscountErrorMessage.innerHTML = "";
    }
}

function CheckServiceType() {
    const inputServiceType = document.querySelector("#serviceType"),
            serviceTypeErrorMessage = document.querySelector(".service-type-error p");

    if (inputServiceType.value === "") {
        inputServiceType.style.border = "1px solid red";
        serviceTypeErrorMessage.innerHTML = "Please select service type!";
    } else {
        inputServiceType.style.border = "1px solid green";
        serviceTypeErrorMessage.innerHTML = "";
    }
}