package com.teamthree.freshtooth.models;

import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notification implements Serializable {

    private String notifyID, userID, notifyType;
    private int notifyStatus;
    private Timestamp notifyCreated;

    public Notification() {
    }

    public Notification(String notifyID, String userID, String notifyType, int notifyStatus, Timestamp notifyCreated) {
        this.notifyID = notifyID;
        this.userID = userID;
        this.notifyType = notifyType;
        this.notifyStatus = notifyStatus;
        this.notifyCreated = notifyCreated;
    }
}
