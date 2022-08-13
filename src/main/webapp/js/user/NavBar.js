function ReadNotification(userID, urlServlet) {
    $.ajax({
        url: urlServlet,
        type: "get",
        data: {
            UserID: userID
        },
        success: function (data) {
            const numberNotification = document.querySelector("#bell-number");
            numberNotification.innerHTML = 0;
        }
    });
}

function searchByName(valueSearch, urlServlet) {
    const textSearch = valueSearch.value;
    const viewMore = document.querySelector(".view-more");

    $.ajax({
        url: urlServlet,
        type: "get",
        data: {
            search: textSearch
        },
        success: function (data) {
            const returnList = document.querySelector("#return-list");
            returnList.innerHTML = data;
            if (viewMore !== null) {
                viewMore.style.display = "none";
            }
        }
    });
}

function showLoadMoreButton() {
    const viewMore = document.querySelector(".view-more");
    viewMore.style.display = "block";
}