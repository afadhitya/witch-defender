package com.afadhitya.witchdefender.controller.advice;

import com.afadhitya.witchdefender.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    private final static Logger LOG = LoggerFactory.getLogger(ErrorHandler.class);
    private final static Integer ERROR_CODE = -1;

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Integer notValidHandler(ValidationException e) {
        LOG.error(e.getMessage());
        return ERROR_CODE;
    }
}
