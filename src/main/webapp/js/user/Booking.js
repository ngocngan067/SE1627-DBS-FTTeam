const showErrorBox = document.querySelector("#error-box");
const bodyTag = document.getElementsByTagName("BODY")[0];

//Check Service
function CheckService() {
    const inputService = document.querySelector("#inputService"),
            serviceErrorMessage = document.querySelector("#inputService-error"),
            serviceIconError = document.querySelector("#inputService-icon-error"),
            serviceIconCheck = document.querySelector("#inputService-icon-check");

    if (inputService.value === "") {
        inputService.style.border = "1px solid red";
        serviceErrorMessage.innerHTML = "Please select service!";
        serviceIconError.style.display = "block";
        serviceIconCheck.style.display = "none";
    } else {
        inputService.style.border = "1px solid green";
        serviceErrorMessage.innerHTML = "";
        serviceIconError.style.display = "none";
        serviceIconCheck.style.display = "block";
    }
}

//Check dateOfAppointment
function CheckDateOfAppointment() {
    const inputDateOfAppointment = document.querySelector("#datepicker-2"),
            dateOfAppointmentIconCheck = document.querySelector(
                    "#dateOfAppointment-icon-check"
                    ),
            dateOfAppointmentIconError = document.querySelector(
                    "#dateOfAppointment-icon-error"
                    ),
            dateOfAppointmentErrorMessage = document.querySelector(
                    "#dateOfAppointment-error"
                    );

    if (inputDateOfAppointment.value === "") {
        inputDateOfAppointment.style.border = "1px solid red";
        dateOfAppointmentErrorMessage.innerHTML =
                "Please select date of appointment!";
        dateOfAppointmentIconError.style.display = "block";
        dateOfAppointmentIconCheck.style.display = "none";
    } else {
        inputDateOfAppointment.style.border = "1px solid green";
        dateOfAppointmentErrorMessage.innerHTML = "";
        dateOfAppointmentIconError.style.display = "none";
        dateOfAppointmentIconCheck.style.display = "block";
    }
}

$('#datepicker-2').datepicker({
    minDate: '0D',
    dateFormat: "yy-mm-dd"
});

function CheckSlot(urlServlet) {
    const dateOfAppointment = document.getElementById("datepicker-2");
    const service = document.getElementById("inputService");
    const pick = document.querySelectorAll(".pick");

    var dataList = $(".time--booking td").map(function () {
        return $(this).attr("data-slot");
    }).get();

    $.ajax({
        URL: urlServlet,
        type: "get",
        data: {
            Service: service.value,
            Date: dateOfAppointment.value
        },
        success: function (getData) {
            const pickItem = document.querySelectorAll('.pick');

            for (let i in dataList) {
                if (dataList[i] === getData.trim()) {
                    pickItem[i].classList.remove('can-choose');
                    pickItem[i].classList.add("no-choose");
                } else {
                    pickItem[i].classList.add('can-choose');
                    pickItem[i].classList.remove("no-choose");
                }
            }
        }
    });
}

// choose Time
setActiveSlot();
function setActiveSlot() {
    const pick = document.querySelectorAll(".pick");

    pick.forEach((item) => {
        item.addEventListener("click", function () {
            pick.forEach((item) => {
                item.classList.remove("still-choose");
            });

            if (item.className.includes("can-choose")) {
                item.classList.add("still-choose");
                var getDataSlot = $(this).attr("data-slot");
                document.getElementById("slot-value").innerHTML = `<input type="text" hidden name="slotBooking" value="${getDataSlot}">`;
            }
        });
    });
}

function CheckValueUser(userID, urlServlet, homeUrl) {
    var inputFullName = document.getElementById("fullName");
    var inputPhoneNumber = document.getElementById("phoneNumber");
    var inputGender = document.getElementById("gender");
    var inputDateOfBirth = document.getElementById("dateOfBirth");
    var inputAddress = document.getElementById("address");
    var inputEmail = document.getElementById("email");

    if (userID === "") {
        bodyTag.style.overflowY = "hidden";
        bodyTag.style.height = "100%";
        showErrorBox.innerHTML = `
          <div class="error-popup">
              <div class="wrapper">
                  <div class="content">
                      <div class="warn-icon">
                          <span><i class="uil uil-exclamation"></i></span>
                      </div>
                      <h2>No Login Detected!</h2>
                      <p>You are not logged in. Please login to use all website functions.</p>
                      <div class="buttons">
                          <button onclick="window.location.href='${urlServlet}';" id="login-btn">Login</button>
                          <button onclick="window.location.href='${homeUrl}';" id="cancel-btn">Cancel</button>
                      </div>
                  </div>
              </div>
          </div>
      `;
    } else if (
            inputFullName.value === "" ||
            inputPhoneNumber.value === "" ||
            inputGender.value === "" ||
            inputDateOfBirth.value === "" ||
            inputAddress.value === "" ||
            inputEmail.value === ""
            ) {
        bodyTag.style.overflowY = "hidden";
        bodyTag.style.height = "100%";
        showErrorBox.innerHTML = `
          <div class="error-popup">
              <div class="wrapper">
                  <div class="content">
                      <div class="warn-icon">
                          <span><i class="uil uil-exclamation"></i></span>
                      </div>
                      <h2>Incomplete information!</h2>
                      <p>You need to fully update your information to make an appointment.</p>
                      <div class="buttons">
                          <button onclick="window.location.href='${urlServlet}';" id="login-btn">Update</button>
                      </div>
                  </div>
              </div>
          </div>
      `;
    }
}