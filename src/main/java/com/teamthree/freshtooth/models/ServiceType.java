package com.teamthree.freshtooth.models;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceType implements Serializable {

    private String serviceTypeID, serviceTypeName;
    private int serviceTypeStatus;

    public ServiceType() {
    }

    public ServiceType(String serviceTypeID, String serviceTypeName, int serviceTypeStatus) {
        this.serviceTypeID = serviceTypeID;
        this.serviceTypeName = serviceTypeName;
        this.serviceTypeStatus = serviceTypeStatus;
    }

}
