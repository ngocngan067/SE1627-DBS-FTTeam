package com.teamthree.freshtooth.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dentist {

    private String dentistID, skill, descriptionDentist;
    private int yearsOfExp;
    private double salary, insurance;

    public Dentist() {
    }

    public Dentist(String dentistID, String skill, String descriptionDentist, int yearsOfExp, double insurance, double salary) {
        this.dentistID = dentistID;
        this.skill = skill;
        this.descriptionDentist = descriptionDentist;
        this.yearsOfExp = yearsOfExp;
        this.insurance = insurance;
        this.salary = salary;
    }
}
