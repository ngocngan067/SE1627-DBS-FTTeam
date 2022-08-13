function myReadMoreFunction(element) {
    var trydot = element.parentNode.children;
    var dot = trydot[2].children;
    var dots = dot[1].children;
    var dotss = dots[0];
    var more = dots[1];

    if (dotss.style.display === "none") {
        dotss.style.display = "inline";
        element.innerHTML = "Read more";
        more.style.display = "none";
    } else {
        dotss.style.display = "none";
        element.innerHTML = "Read less";
        more.style.display = "inline";
    }
}

function myReadMoreFunction1(element) {
    var dots = element.getElementById("dots");
    var moreText = element.getElementById("more");
    var btnText = element.getElementById("myBtn");

    if (dots.style.display === "none") {
        dots.style.display = "inline";
        btnText.innerHTML = "Read more";
        moreText.style.display = "none";
    } else {
        dots.style.display = "none";
        btnText.innerHTML = "Read less";
        moreText.style.display = "inline";
    }
}
