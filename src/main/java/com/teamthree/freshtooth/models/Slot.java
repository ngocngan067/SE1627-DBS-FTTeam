package com.teamthree.freshtooth.models;

import java.sql.Time;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Slot {

    private String slotID;
    private Time slotStart;

    public Slot() {
    }

    public Slot(String slotID, Time slotStart) {
        this.slotID = slotID;
        this.slotStart = slotStart;
    }
}
