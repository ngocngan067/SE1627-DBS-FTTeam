let now = new Date();
const offSet = now.getDay() === 0 ? 6 : now.getDay() - 1;
const bodyTag = document.getElementsByTagName("BODY")[0];

let startOfWeek = new Date(now.getFullYear(), now.getMonth(), now.getDate() - offSet);
let endOfWeek = new Date(now.getFullYear(), now.getMonth(), now.getDate() + (6 - offSet));
var ch = document.querySelectorAll("#c-h > th"), i;

for (i = 1; i < ch.length; ++i) {
    const date = new Date(
            startOfWeek.getFullYear(),
            startOfWeek.getMonth(),
            startOfWeek.getDate() + (i - 1)
            );
    ch[i].innerHTML = `${
            ch[i].innerHTML.split(" ")[0]
            } <span>${date.toLocaleDateString(undefined, {day: "numeric"})}</span>`;
}

document.getElementById("start-date").innerHTML = startOfWeek.toLocaleDateString();
document.getElementById("end-date").innerHTML = endOfWeek.toLocaleDateString();

function changeWeek(direction) {
    startOfWeek.setDate(startOfWeek.getDate() + direction * 7);
    endOfWeek.setDate(endOfWeek.getDate() + direction * 7);

    document.getElementById("start-date").innerHTML = startOfWeek.toLocaleDateString();
    document.getElementById("end-date").innerHTML = endOfWeek.toLocaleDateString();

    var ch = document.querySelectorAll("#c-h > th"), i;

    for (i = 1; i < ch.length; ++i) {
        const date = new Date(
                startOfWeek.getFullYear(),
                startOfWeek.getMonth(),
                startOfWeek.getDate() + (i - 1)
                );
        ch[i].innerHTML = `${
                ch[i].innerHTML.split(" ")[0]
                } <span>${date.toLocaleDateString(undefined, {day: "numeric"})}</span>`;
    }

    renderEvents();
}

let events = [];

function getApiTimeLine(valueTimeLine) {
    events = valueTimeLine;
}

const listSlot = [
    "yVAxOtLaWr", "2jKy0KkhSo", "E4cIHlnfq2", "xRnDdJtora", "pP1aF1VZUi", "bgLxb9lAxf", "t2125plsQ8", "KCiI4OVEqV", "uwYyBL34N4", "GG0A6gfXKg", "296uoqx9Dv", "pemqrC91A4", "LiLb3564jz", "oTjkSc9QCI", "dyNW3IM3IL", "Ew5m6XIGHb"
];

function renderEvents() {
    for (let i = 0; i < 16; i++) {
        for (let j = 2; j <= 8; j++) {
            $("#" + `${listSlot[i]}`).find([j - 1]).html("");
        }
    }

    events.forEach((event) => {
        const date = new Date(Date.parse(event.bookingDate));

        if (date >= startOfWeek && date <= endOfWeek) {
            const dayOfWeek = date.getDay() === 0 ? 6 : date.getDay() === 6 ? 5 : date.getDay() - 1;
            const weekday = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"];

            document.querySelector("#" + event.slotID + " > #" + weekday[dayOfWeek]).innerHTML = `<div class="cell">${event.dentistName}</div>`;
            $("#" + event.slotID + " > #" + weekday[dayOfWeek]).attr("onclick", 'openSchedule("#' + event.slotID + '", "#' + weekday[dayOfWeek] + '")');
        }
    });
}

var modal = document.getElementById("id01");
var elements = document.querySelectorAll("td");
const weekday = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"];

function openSchedule(idRow, idColumn) {
    modal.style.display = "block";

    events.forEach((e) => {
        const date = new Date(Date.parse(e.bookingDate));
        const dayOfWeek = date.getDay() === 0 ? 6 : date.getDay() === 6 ? 5 : date.getDay() - 1;

        if ($(idColumn).hasClass(weekday[dayOfWeek])) {
            if ($(idRow)[0].id === e.slotID) {
                bodyTag.style.overflowY = "hidden";
                bodyTag.style.height = "100%";

                $(".modal .modal-content .modal-header .title").html(e.serviceName);

                $(".modal .modal-content .modal-body").html(
                        `<div class="container-fluid">
          <div class="row">
              <div class="col-12 col-md-5 cover my-2">
                  <p>Booking ID: 
                      <input type="text" readonly value="${e.bookingID}">
                  </p>
              </div>

              <div class="col-12 col-md-12 cover mb-3">
                  <p>Full Name: 
                      <input type="text" readonly value="${e.fullName}">
                  </p>
              </div>

              <div class="col-12 col-md-3 cover mb-3">
                  <p>Gender: 
                      <input type="text" readonly value="${e.gender === 'M' ? 'Male' : 'Female'}">
                  </p>
              </div>

              <div class="col-12 col-md-4 cover mb-3">
                  <p>Date Of Birth: 
                      <input type="text" readonly value="${e.dateOfBirth}">
                  </p>
              </div>

              <div class="col-12 col-md-5 cover mb-3">
                  <p>Phone Number: 
                      <input type="text" readonly value="${e.phoneNumber}">
                  </p>
              </div>

              <div class="col-12 col-md-12 cover mb-3">
                  <p>Email: 
                      <input type="text" readonly value="${e.email}">
                  </p>
              </div>

              <div class="col-12 col-md-12 cover mb-3">
                  <p>Address: 
                      <textarea name="" id="" readonly rows="1">${e.address}</textarea>
                  </p>
              </div>

              <div class="col-12 col-md-5 cover mb-3">
                  <p>Service Name: 
                      <input type="text" readonly value="${e.serviceName}">
                  </p>
              </div>
              
              <div class="col-12 col-md-7 cover mb-3">
                  <p>Dentist Name: 
                      <input type="text" readonly value="${e.dentistName === undefined ? '' : e.dentistName}">
                  </p>
              </div>

              <div class="col-12 col-md-12 cover mb-3">
                  <p>Booking Note: 
                      <textarea name="" id="" readonly rows="1">${e.bookingNote === undefined ? '' : e.bookingNote}</textarea>
                  </p>
              </div>
              
              <div class="col-12 col-md-6 cover mb-3">
                  <p>Slot: 
                      <input type="text" readonly value="${e.slotStart}">
                  </p>
              </div>

              <div class="col-12 col-md-6 cover mb-3">
                  <p>Booking Created: 
                      <input type="text" readonly value="${e.bookingCreated}">
                  </p>
              </div>

          </div>
      </div>`
                        );
            }
        }
    });
}

var close = document.getElementById("close");

close.addEventListener("click", function () {
    modal.style.display = "none";
    bodyTag.style.overflowY = "scroll";
    bodyTag.style.height = null;
});

window.onclick = function (event) {
    if (event.target === modal) {
        modal.style.display = "none";
    }
};