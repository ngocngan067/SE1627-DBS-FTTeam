package com.teamthree.freshtooth.models;

import lombok.Data;

@Data
public class ServiceTypeError {
    
    private String serviceTypeName;
    
    public ServiceTypeError() {
        this.serviceTypeName = "";
    }
}
