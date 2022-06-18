package com.teamthree.freshtooth.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Services {

    private String serviceID, serviceName, imageService, descriptionService, serviceTypeID;
    private int servicePrice, discount, serviceStatus;

    public Services() {
    }

    public Services(String serviceID, String serviceName, String imageService, String descriptionService, String serviceTypeID, int servicePrice, int discount, int serviceStatus) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.imageService = imageService;
        this.descriptionService = descriptionService;
        this.serviceTypeID = serviceTypeID;
        this.servicePrice = servicePrice;
        this.discount = discount;
        this.serviceStatus = serviceStatus;
    }
}
