PrintCopyRight();

function PrintCopyRight() {
    console.log("%cHello! \ud83d\ude4b", "color: #29c4a9;font-size: 16px;font-weight: 600;"),
            console.log("%cFresh Tooth front-end was built with HTML, CSS, and lots of love. \n\nFresh Tooth back-end was built with SQL Server, Java Web and lots of love. \n\n\ud83d\udc49 Want to learn with us? Check out ".concat(window.location.origin, "/FreshTooth/home"), "color: #29c4a9;font-size: 14px;");
}

function setActiveMenuBar() {
    const navLink = document.querySelectorAll(".nav-link");
    document.querySelectorAll(".nav-item").forEach((item) => {
        item.classList.remove("active");
    });
    navLink.forEach((item) => {
        if (item.getAttribute("href") === window.location.pathname) {
            item.parentElement.classList.add("active");
        }
    });
}