package com.teamthree.freshtooth.models;

import java.sql.Date;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Booking {

    private String bookingID, serviceID, patientID, bookingNote, dentistID, slotID;
    private int bookingStatus;
    private Date bookingDate;
    private Timestamp bookingCreated;

    public Booking() {
    }

    public Booking(String bookingID, String serviceID, String patientID, String bookingNote, String dentistID, String slotID, int bookingStatus, Date bookingDate, Timestamp bookingCreated) {
        this.bookingID = bookingID;
        this.serviceID = serviceID;
        this.patientID = patientID;
        this.bookingNote = bookingNote;
        this.dentistID = dentistID;
        this.slotID = slotID;
        this.bookingStatus = bookingStatus;
        this.bookingDate = bookingDate;
        this.bookingCreated = bookingCreated;
    }
}
