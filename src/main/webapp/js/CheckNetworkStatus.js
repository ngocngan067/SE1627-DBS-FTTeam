const checkNetworkBox = document.querySelector(".check-network"),
        checkNetworkToast = checkNetworkBox.querySelector(".check-network__toast"),
        wifiIcon = checkNetworkBox.querySelector(".toast-icon"),
        detailsTitle = checkNetworkBox.querySelector(".details-title"),
        detailsSubTitle = checkNetworkBox.querySelector(".details-subtitle"),
        closeIcon = checkNetworkToast.querySelector(".close-icon");

window.onload = () => {
    function ajax() {
        let xhr = new XMLHttpRequest();
        xhr.open("GET", "https://jsonplaceholder.typicode.com/posts", true);
        xhr.onload = () => {
            if (xhr.status == 200 && xhr.status < 300) {
                checkNetworkToast.classList.remove("offline");
                detailsTitle.innerText = "You're online now";
                detailsSubTitle.innerText = "Hurray! Internet is connected.";
                wifiIcon.innerHTML = '<i class="uil uil-wifi"></i>';
                closeIcon.onclick = () => {
                    checkNetworkBox.classList.add("hide");
                };
                setTimeout(() => {
                    checkNetworkBox.classList.add("hide");
                }, 5000);
            } else {
                offline();
            }
        };
        xhr.onerror = () => {
            offline();
        };
        xhr.send();
    }

    function offline() {
        checkNetworkBox.classList.remove("hide");
        checkNetworkToast.classList.add("offline");
        detailsTitle.innerText = "You're offline now";
        detailsSubTitle.innerText = "Opps! Internet is disconnected.";
        wifiIcon.innerHTML = '<i class="uil uil-wifi-slash"></i>';
    }

    setInterval(() => {
        ajax();
    }, 100);
};
