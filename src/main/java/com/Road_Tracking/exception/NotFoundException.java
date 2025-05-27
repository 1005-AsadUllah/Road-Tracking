package com.Road_Tracking.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class NotFoundException extends RuntimeException {
    private String errorMessage;

    public NotFoundException(String message, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }
}
