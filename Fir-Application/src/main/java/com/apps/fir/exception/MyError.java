package com.apps.fir.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MyError {

    private LocalDateTime timestamp;
    private String message;
    private String details;
}
