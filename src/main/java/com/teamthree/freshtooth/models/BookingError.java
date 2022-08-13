package com.teamthree.freshtooth.models;

import lombok.Data;

@Data
public class BookingError {

    private String serviceIDError, slotIDError, bookingDateError;

    public BookingError() {
        this.serviceIDError = "";
        this.slotIDError = "";
        this.bookingDateError = "";
    }
}
