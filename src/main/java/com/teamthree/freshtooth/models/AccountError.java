package com.teamthree.freshtooth.models;

import lombok.Data;

@Data
public class AccountError {
    private String fullNameError, passwordError, emailError, newPasswordError, confirmPasswordError, phoneNumberError, addressError;
    
    public AccountError() {
        this.fullNameError = "";
        this.passwordError = "";
        this.newPasswordError = "";
        this.confirmPasswordError = "";
        this.emailError = "";
        this.phoneNumberError = "";
        this.addressError = "";
    }
}
