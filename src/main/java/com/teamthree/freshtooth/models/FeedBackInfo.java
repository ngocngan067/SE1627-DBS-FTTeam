package com.teamthree.freshtooth.models;

import java.sql.Date;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedBackInfo {

    private String feedBackID, feedBackContent, serviceName, dentistName, imageAvatar, fullName, gender, phoneNumber, email, address, colorAvatar, defaultAvatar;
    private Date dateOfBirth;
    private int numberRating;
    private Timestamp feedBackCreated;

    public FeedBackInfo() {
    }

    public FeedBackInfo(String feedBackID, String feedBackContent, String serviceName, String dentistName, String imageAvatar, String fullName, String gender, String phoneNumber, String email, String address, String colorAvatar, String defaultAvatar, Date dateOfBirth, int numberRating, Timestamp feedBackCreated) {
        this.feedBackID = feedBackID;
        this.feedBackContent = feedBackContent;
        this.serviceName = serviceName;
        this.dentistName = dentistName;
        this.imageAvatar = imageAvatar;
        this.fullName = fullName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.colorAvatar = colorAvatar;
        this.defaultAvatar = defaultAvatar;
        this.dateOfBirth = dateOfBirth;
        this.numberRating = numberRating;
        this.feedBackCreated = feedBackCreated;
    }

}
