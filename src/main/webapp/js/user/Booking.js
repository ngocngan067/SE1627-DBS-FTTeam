$(document).ready(function () {
    $("#datepicker").datepicker();
});
//mảng ngày cân disable
var dates = ["15-05-2022", "31-05-2022", "18-05-2022", "20-05-2022"];

function disableDates(date) {
    var string = $.datepicker.formatDate("dd-mm-yy", date);
    return [dates.indexOf(string) == -1];
}
$("#datepicker").datepicker({
    beforeShowDay: disableDates,
});
var currentDate = $("#datepicker").datepicker({
    onSelect: function (dateText, inst) {
        var dateAsString = dateText; //the first parameter of this function
        var dateAsObject = $(this).datepicker("getDate"); //the getDate method
    },
});
console.log(currentDate);
// lay du lieu nagy thang
function getd() {
    var jsDate = $("#datepicker").datepicker("getDate");
    if (jsDate !== null) {
        // if any date selected in datepicker
        jsDate instanceof Date; // -> true
        jsDate.getDate();
        jsDate.getMonth();
        jsDate.getFullYear();
    }
    console.log(jsDate);
}

//Check full name
function CheckFullName() {
    const inputUsername = document.querySelector("#fullName"),
            usernameIconCheck = document.querySelector("#fullName-icon-check"),
            usernameIconError = document.querySelector("#fullName-icon-error"),
            usernameErrorMessage = document.querySelector("#fullName-error");

    if (inputUsername.value === "") {
        inputUsername.style.border = "1px solid red";
        usernameErrorMessage.innerHTML = "Please enter your full name!";
        usernameIconError.style.display = "block";
        usernameIconCheck.style.display = "none";
    } else {
        inputUsername.style.border = "1px solid green";
        usernameErrorMessage.innerHTML = "";
        usernameIconError.style.display = "none";
        usernameIconCheck.style.display = "block";
    }
}

//Check Phone Number
function CheckPhoneNumber() {
    const inputPhoneNumber = document.querySelector("#phoneNumber"),
            phoneNumberIconCheck = document.querySelector("#phoneNumber-icon-check"),
            phoneNumberIconError = document.querySelector("#phoneNumber-icon-error"),
            phoneNumberErrorMessage = document.querySelector("#phoneNumber-error");

    if (inputPhoneNumber.value === "") {
        inputPhoneNumber.style.border = "1px solid red";
        phoneNumberErrorMessage.innerHTML = "Please enter your phone number!";
        phoneNumberIconError.style.display = "block";
        phoneNumberIconCheck.style.display = "none";
    } else if (inputPhoneNumber.value.length < 10 || inputPhoneNumber.value.length > 10) {
        inputPhoneNumber.style.border = "1px solid red";
        phoneNumberErrorMessage.innerHTML = "Phone number must have 10 digits!";
        phoneNumberIconError.style.display = "block";
        phoneNumberIconCheck.style.display = "none";
    } else {
        inputPhoneNumber.style.border = "1px solid green";
        phoneNumberErrorMessage.innerHTML = "";
        phoneNumberIconError.style.display = "none";
        phoneNumberIconCheck.style.display = "block";
    }
}

//Check Address
function CheckAddress() {
    const inputAddress = document.querySelector("#address"),
            addressIconCheck = document.querySelector("#address-icon-check"),
            addressIconError = document.querySelector("#address-icon-error"),
            addressErrorMessage = document.querySelector("#address-error");

    if (inputAddress.value === "") {
        inputAddress.style.border = "1px solid red";
        addressErrorMessage.innerHTML = "Please enter your address!";
        addressIconError.style.display = "block";
        addressIconCheck.style.display = "none";
    } else {
        inputAddress.style.border = "1px solid green";
        addressErrorMessage.innerHTML = "";
        addressIconError.style.display = "none";
        addressIconCheck.style.display = "block";
    }
}