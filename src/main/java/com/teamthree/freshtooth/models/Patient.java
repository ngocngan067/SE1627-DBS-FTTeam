package com.teamthree.freshtooth.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Patient {

    private String patientID, nameParent, phoneParent;

    public Patient() {
    }

    public Patient(String patientID, String nameParent, String phoneParent) {
        this.patientID = patientID;
        this.nameParent = nameParent;
        this.phoneParent = phoneParent;
    }
}
