package com.teamthree.freshtooth.models;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedBack {

    private String feedBackID, bookID, patientID, feedBackContent;
    private int numberRating;
    private Timestamp feedBackCreated;

    public FeedBack() {
    }

    public FeedBack(String feedBackID, String bookID, String patientID, String feedBackContent, int numberRating, Timestamp feedBackCreated) {
        this.feedBackID = feedBackID;
        this.bookID = bookID;
        this.patientID = patientID;
        this.feedBackContent = feedBackContent;
        this.numberRating = numberRating;
        this.feedBackCreated = feedBackCreated;
    }
}
