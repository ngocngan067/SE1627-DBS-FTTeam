function CheckServiceTypeName() {
    const inputServiceTypeName = document.querySelector(".service-type-name"),
            serviceTypeNameErrorMessage = document.querySelector(".service-type-name-error p");

    if (inputServiceTypeName.value === "") {
        inputServiceTypeName.style.border = "1px solid red";
        serviceTypeNameErrorMessage.innerHTML = "Please enter service type name!";
    } else {
        inputServiceTypeName.style.border = "1px solid green";
        serviceTypeNameErrorMessage.innerHTML = "";
    }
}