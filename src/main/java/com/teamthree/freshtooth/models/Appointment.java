package com.teamthree.freshtooth.models;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Appointment {

    private String bookingID, serviceName, imageService, fullName, email, address, phoneNumber, gender, dentistName, bookingNote, slotID;
    private Date dateOfBirth, bookingDate;
    private int bookingStatus;
    private Time slotStart;
    private Timestamp bookingCreated;

    public Appointment() {
    }

    public Appointment(String bookingID, String serviceName, String imageService, String fullName, String email, String address, String phoneNumber, String gender, String dentistName, String bookingNote, String slotID, Date dateOfBirth, Date bookingDate, int bookingStatus, Time slotStart, Timestamp bookingCreated) {
        this.bookingID = bookingID;
        this.serviceName = serviceName;
        this.imageService = imageService;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dentistName = dentistName;
        this.bookingNote = bookingNote;
        this.slotID = slotID;
        this.dateOfBirth = dateOfBirth;
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
        this.slotStart = slotStart;
        this.bookingCreated = bookingCreated;
    }

}
