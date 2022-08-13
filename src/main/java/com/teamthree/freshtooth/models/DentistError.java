package com.teamthree.freshtooth.models;

import lombok.Data;

@Data
public class DentistError {

    private String skillError, yearsOfExpError, salaryError, insuranceError, descriptionDentistError;

    public DentistError() {
        this.skillError = "";
        this.yearsOfExpError = "";
        this.salaryError = "";
        this.insuranceError = "";
        this.descriptionDentistError = "";
    }
}
