package com.afadhitya.witchdefender.util.impl;

import com.afadhitya.witchdefender.controller.request.DefendWitchRequest;
import com.afadhitya.witchdefender.exception.ValidationException;
import com.afadhitya.witchdefender.util.ValidationService;
import org.springframework.stereotype.Component;

@Component
public class ValidationServiceImpl implements ValidationService {
    @Override
    public void validateRequestGetAverageNumberWitcherKilled(DefendWitchRequest request) {
        if (request.getPersonOne().getAgeOfDeath() < 0 || request.getPersonTwo().getAgeOfDeath() < 0) {
            throw new ValidationException("Age must not be negative");
        }

        if (request.getPersonOne().getYearOfDeath() < 0 || request.getPersonTwo().getYearOfDeath() < 0) {
            throw new ValidationException("Year of death must not be negative");
        }
    }
}
