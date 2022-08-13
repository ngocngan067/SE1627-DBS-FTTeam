function LoadMoreButton(totalBooking, urlServlet) {
    const viewMore = document.querySelector('.btn--loadMore');
    const bookingAmount = document.querySelectorAll(".booking-amount").length;

    viewMore.innerHTML = `
                    <div class="spinner-loader">
                        <div class="spinner-border text-primary" role="status">
                            <span class="visually-hidden">Loading...</span>
                        </div>
                        <p class="spinner-title">Please Wait ...</p>
                    </div>
                `;


    $.ajax({
        url: urlServlet,
        type: "get",
        data: {
            BookingAmount: bookingAmount
        },
        success: function (data) {
            const bookingList = document.querySelector("#return-list");
            bookingList.innerHTML += data;
        }
    }).done(() => {
        if (totalBooking <= (bookingAmount + 9)) {
            viewMore.style.display = "none";
        } else {
            viewMore.innerHTML = `<button onclick="LoadMoreButton('${totalBooking}', '${urlServlet}')" type="button" class="btn btn-primary" width="100px">Show More</button>`;
        }
    });
}

function confirmAccept(urlServlet, bookingID) {
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-success',
            cancelButton: 'btn btn-danger'
        },
        buttonsStyling: false
    });

    swalWithBootstrapButtons.fire({
        title: 'Are you sure?',
        text: "Do you agree to this appointment?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Yes, accept it!',
        cancelButtonText: 'No, cancel!',
        reverseButtons: true
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url: urlServlet,
                type: "get",
                data: {
                    BookingID: bookingID,
                    Action: "Accept"
                },
                success: function () {
                    location.reload();
                }
            });
            swalWithBootstrapButtons.fire(
                    'Done!',
                    'This appointment successfully accepted.',
                    'success'
                    );
        }
    });
}

function confirmDone(urlServlet, bookingID) {
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-success',
            cancelButton: 'btn btn-danger'
        },
        buttonsStyling: false
    });

    swalWithBootstrapButtons.fire({
        title: 'Are you sure?',
        text: "Do you want done to this appointment?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Yes, done it!',
        cancelButtonText: 'No, cancel!',
        reverseButtons: true
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url: urlServlet,
                type: "get",
                data: {
                    BookingID: bookingID,
                    Action: "Done"
                },
                success: function () {
                    location.reload();
                }
            });
            swalWithBootstrapButtons.fire(
                    'Done!',
                    'This appointment successfully done.',
                    'success'
                    );
        }
    });
}

let events = "";

function confirmCancel(bookingID) {
    var modal = document.getElementById("myModal");
    var span = document.getElementsByClassName("close")[0];

    modal.style.display = "block";
    events = bookingID;

    span.onclick = function () {
        modal.style.display = "none";
    };

    window.onclick = function (event) {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    };
}

function confirmButton(urlServlet) {
    $.ajax({
        url: urlServlet,
        type: "get",
        data: {
            BookingID: events,
            Action: "Cancel"
        },
        success: function () {
            location.reload();
        }
    });
}

function searchByName(valueSearch, urlServlet) {
    const textSearch = valueSearch.value;

    $.ajax({
        url: urlServlet,
        type: "get",
        data: {
            search: textSearch
        },
        success: function (data) {
            const returnList = document.querySelector("#return-list");
            returnList.innerHTML = data;
        }
    });
}