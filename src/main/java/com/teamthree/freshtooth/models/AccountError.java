package com.teamthree.freshtooth.models;

import lombok.Data;

@Data
public class AccountError {
    private String fullNameError, genderError, dateOfBirthError, imageError, passwordError, emailError, newPasswordError, confirmPasswordError, phoneNumberError, addressError, verifySMSError;
    
    public AccountError() {
        this.fullNameError = "";
        this.genderError = "";
        this.dateOfBirthError = "";
        this.imageError = "";
        this.passwordError = "";
        this.newPasswordError = "";
        this.confirmPasswordError = "";
        this.emailError = "";
        this.phoneNumberError = "";
        this.addressError = "";
        this.verifySMSError = "";
    }
}
