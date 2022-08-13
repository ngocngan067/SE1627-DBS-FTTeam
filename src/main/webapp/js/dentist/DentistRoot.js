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

$(document).ready(function () {
    $(window).bind("scroll", function () {
        var gap = 50;
        if ($(window).scrollTop() > gap) {
            $("header").addClass("active");
        } else {
            $("header").removeClass("active");
        }
    });
});

function menuToggle() {
    const toggleMenu = document.querySelector(".user-menu");
    toggleMenu.classList.toggle("active");
}

function showSearchBox() {
    const toggleSearch = document.querySelector(".nav__bar-mobile-tool");
    toggleSearch.classList.toggle("active");
}

/* Mobile Menu */
function BlockScrollInUserMenu() {
    const bodyForUserMenu = document.getElementsByTagName("BODY")[0];
    const mobileMenuCheckbox = document.querySelector("#mobile-menu-checkbox");
    if (mobileMenuCheckbox.checked === true) {
        bodyForUserMenu.style.overflowY = "hidden";
    } else {
        bodyForUserMenu.style.overflowY = "scroll";
    }
}

/* Search With MicroPhone */
function activeMicrophone(urlServlet) {
    const SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition,
            microphoneHeader = document.querySelector("#microphone-header__prompt"),
            microphoneFooterLabel = document.querySelector("#microphone-footer-label"),
            microphoneBodyText = document.querySelector("#microphone-body-text");

    if (SpeechRecognition !== undefined) {
        let recognition = new SpeechRecognition();

        recognition.onstart = () => {
            microphoneHeader.innerHTML = "Listening...";
            microphoneFooterLabel.innerHTML = "";
            microphoneBodyText.innerHTML = "";
        };

        recognition.onspeechend = () => {
            microphoneHeader.innerHTML = "Microphone is off. Please speak again.";
            microphoneFooterLabel.innerHTML = "Tap the microphone to try again";
            recognition.stop();
        };

        recognition.onresult = (result) => {
            microphoneBodyText.innerHTML = `${result.results[0][0].transcript}`;

            $.ajax({
                url: urlServlet,
                type: "get",
                data: {
                    search: `${result.results[0][0].transcript}`
                },
                success: function (data) {
                    const returnList = document.querySelector("#return-list");
                    returnList.innerHTML = data;
                    hideMicrophoneBox();
                }
            });
        };

        recognition.start();
    }
}

function showMicrophoneBox(urlServlet) {
    const bodyForMicrophoneBox = document.getElementsByTagName("BODY")[0];
    const microphoneWrapper = document.querySelector("#microphone-wrapper");

    microphoneWrapper.classList.add("active");
    bodyForMicrophoneBox.style.overflowY = "hidden";
    activeMicrophone(urlServlet);
}

function hideMicrophoneBox() {
    const bodyForMicrophoneBox = document.getElementsByTagName("BODY")[0];
    const microphoneWrapper = document.querySelector("#microphone-wrapper");

    microphoneWrapper.classList.remove("active");
    bodyForMicrophoneBox.style.overflowY = "scroll";
}

/* End Search With MicroPhone */

/* Search With MicroPhone In Mobile */
function activeMicrophoneMobile(urlServlet) {
    const SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition,
            microphoneHeader = document.querySelector("#mobile-header__prompt"),
            microphoneFooterLabel = document.querySelector("#mobile__microphone-footer-label"),
            microphoneBodyText = document.querySelector("#mobile-microphone-body-text");

    if (SpeechRecognition !== undefined) {
        let recognition = new SpeechRecognition();

        recognition.onstart = () => {
            microphoneHeader.innerHTML = "Listening...";
            microphoneFooterLabel.innerHTML = "";
            microphoneBodyText.innerHTML = "";
        };

        recognition.onspeechend = () => {
            microphoneHeader.innerHTML = "Microphone is off. Please speak again.";
            microphoneFooterLabel.innerHTML = "Tap the microphone to try again";
            recognition.stop();
        };

        recognition.onresult = (result) => {
            microphoneBodyText.innerHTML = `${result.results[0][0].transcript}`;

            $.ajax({
                url: urlServlet,
                type: "get",
                data: {
                    search: `${result.results[0][0].transcript}`
                },
                success: function (data) {
                    const returnList = document.querySelector("#return-list");
                    returnList.innerHTML = data;
                    hideMicrophoneBox();
                }
            });
        };

        recognition.start();
    }
}

function showMicrophoneBoxMobile(urlServlet) {
    const bodyForMicrophoneBox = document.getElementsByTagName("BODY")[0];
    const microphoneWrapper = document.querySelector("#mobile__microphone-wrapper");

    microphoneWrapper.classList.add("active");
    bodyForMicrophoneBox.style.overflowY = "hidden";
    activeMicrophoneMobile(urlServlet);
}

function hideMicrophoneBoxMobile() {
    const bodyForMicrophoneBox = document.getElementsByTagName("BODY")[0];
    const microphoneWrapper = document.querySelector("#mobile__microphone-wrapper");

    microphoneWrapper.classList.remove("active");
    bodyForMicrophoneBox.style.overflowY = "scroll";
}