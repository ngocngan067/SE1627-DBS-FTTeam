package com.teamthree.freshtooth.models;

import java.sql.Date;
import java.sql.Time;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistoryBooking {

    private String bookingID, patientID, imageService, serviceName, fullName, userPhone, userAddress, bookingNote;
    private int bookingStatus;
    private Date bookingDate;
    private Time slotStart;

    public HistoryBooking() {
    }

    public HistoryBooking(String bookingID, String patientID, String imageService, String serviceName, String fullName, String userPhone, String userAddress, String bookingNote, int bookingStatus, Date bookingDate, Time slotStart) {
        this.bookingID = bookingID;
        this.patientID = patientID;
        this.imageService = imageService;
        this.serviceName = serviceName;
        this.fullName = fullName;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.bookingNote = bookingNote;
        this.bookingStatus = bookingStatus;
        this.bookingDate = bookingDate;
        this.slotStart = slotStart;
    }

}
