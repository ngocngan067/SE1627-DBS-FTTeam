package com.teamthree.freshtooth.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceType {

    private String serviceTypeID, serviceTypeName;

    public ServiceType() {
    }

    public ServiceType(String serviceTypeID, String serviceTypeName) {
        this.serviceTypeID = serviceTypeID;
        this.serviceTypeName = serviceTypeName;
    }
}
