const checkNetworkBox = document.querySelector(".check-network"),
        checkNetworkToast = checkNetworkBox.querySelector(".check-network__toast"),
        wifiIcon = checkNetworkBox.querySelector(".toast-icon"),
        detailsTitle = checkNetworkBox.querySelector(".details-title"),
        detailsSubTitle = checkNetworkBox.querySelector(".details-subtitle"),
        closeIcon = checkNetworkToast.querySelector(".close-icon");

let isOfflineBefore = true;

window.onload = () => {
    function ajax() {
        let xhr = new XMLHttpRequest();
        xhr.open("GET", "https://jsonplaceholder.typicode.com/posts", true);
        xhr.onload = () => {
            if (xhr.status === 200 && xhr.status < 300) {
                if (sessionStorage.getItem("hasCodeRunBefore") === null || sessionStorage.getItem("hasCodeRunBefore") === "") {
                    checkNetworkBox.classList.remove("d-none");
                    checkNetworkBox.classList.remove("hide");
                    isOfflineBefore = false;
                    const hasCodeRunBefore = "checkNetworkToast.classList.remove(\"offline\");";
                    sessionStorage.setItem("hasCodeRunBefore", JSON.stringify(hasCodeRunBefore));
                    checkNetworkToast.classList.remove("offline");
                    detailsTitle.innerText = "You're online now";
                    detailsSubTitle.innerText = "Connected to Internet";
                    wifiIcon.innerHTML = '<i class="uil uil-wifi"></i>';
                }
                closeIcon.onclick = () => {
                    checkNetworkBox.classList.add("hide");
                };
                setTimeout(() => {
                    checkNetworkBox.classList.add("hide");
                }, 2000);
            } else {
                checkNetworkBox.classList.remove("hide");
                sessionStorage.setItem("hasCodeRunBefore", "");
                checkNetworkBox.classList.remove("d-none");
                isOfflineBefore = true;
                offline();
            }
        };
        xhr.onerror = () => {
            checkNetworkBox.classList.remove("hide");
            sessionStorage.setItem("hasCodeRunBefore", "");
            checkNetworkBox.classList.remove("d-none");
            isOfflineBefore = true;
            offline();
        };
        xhr.send();
    }

    setInterval(() => {
        ajax();
    }, 100);
};

function offline() {
    checkNetworkToast.classList.add("offline");
    detailsTitle.innerText = "You're offline now";
    detailsSubTitle.innerText = "Lost Connection to Internet";
    wifiIcon.innerHTML = '<i class="uil uil-wifi-slash"></i>';
    closeIcon.onclick = () => {
        checkNetworkBox.classList.add("hide");
    };
}