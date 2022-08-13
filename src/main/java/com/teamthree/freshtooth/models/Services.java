package com.teamthree.freshtooth.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Services {

    private String serviceID, serviceName, imageService, descriptionService, serviceTypeID;
    private int discount, serviceStatus;
    private double servicePrice;

    public Services() {
    }

    public Services(String serviceID, String serviceName, String imageService, String descriptionService, String serviceTypeID, double servicePrice, int discount, int serviceStatus) {
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
