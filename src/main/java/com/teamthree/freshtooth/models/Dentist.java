package com.teamthree.freshtooth.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dentist {

    private String dentistID, skill;
    private int yearsOfExp, salary, insurance;

    public Dentist() {
    }

    public Dentist(String dentistID, String skill, int yearsOfExp, int salary, int insurance) {
        this.dentistID = dentistID;
        this.skill = skill;
        this.yearsOfExp = yearsOfExp;
        this.salary = salary;
        this.insurance = insurance;
    }
}
