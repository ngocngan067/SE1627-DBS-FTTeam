package com.teamthree.freshtooth.models;

import lombok.Data;

@Data
public class ServicesError {

    private String serviceNameError, imageServiceError, descriptionServiceError, servicePriceError, serviceTypeIDError;

    public ServicesError() {
        this.serviceNameError = "";
        this.imageServiceError = "";
        this.descriptionServiceError = "";
        this.servicePriceError = "";
        this.serviceTypeIDError = "";
    }
}
