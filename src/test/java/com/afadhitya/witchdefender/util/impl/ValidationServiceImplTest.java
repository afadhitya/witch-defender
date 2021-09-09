package com.afadhitya.witchdefender.util.impl;

import com.afadhitya.witchdefender.controller.request.DefendWitchRequest;
import com.afadhitya.witchdefender.exception.ValidationException;
import com.afadhitya.witchdefender.model.Person;
import com.afadhitya.witchdefender.util.ValidationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationServiceImplTest {

    private ValidationService validationService;

    @BeforeEach
    void setUp() {
        validationService = new ValidationServiceImpl();
    }

    @Test
    void validateRequestGetAverageNumberWitcherKilled_notThrowException() {
        Person personOne = new Person();
        personOne.setAgeOfDeath(11);
        personOne.setYearOfDeath(20);

        Person personTwo = new Person();
        personTwo.setAgeOfDeath(14);
        personTwo.setYearOfDeath(50);

        DefendWitchRequest request = new DefendWitchRequest();
        request.setPersonOne(personOne);
        request.setPersonTwo(personTwo);
        validationService.validateRequestGetAverageNumberWitcherKilled(request);
    }

    @Test
    void validateRequestGetAverageNumberWitcherKilled_ageNegativeThenThrowException() {
        Person personOne = new Person();
        personOne.setAgeOfDeath(-1);
        personOne.setYearOfDeath(20);

        Person personTwo = new Person();
        personTwo.setAgeOfDeath(-1);
        personTwo.setYearOfDeath(50);

        DefendWitchRequest request = new DefendWitchRequest();
        request.setPersonOne(personOne);
        request.setPersonTwo(personTwo);
        assertThrows(ValidationException.class, () -> validationService.validateRequestGetAverageNumberWitcherKilled(request));
    }

    @Test
    void validateRequestGetAverageNumberWitcherKilled_yearOfDeathNegativeThenThrowException() {
        Person personOne = new Person();
        personOne.setAgeOfDeath(30);
        personOne.setYearOfDeath(-1);

        Person personTwo = new Person();
        personTwo.setAgeOfDeath(20);
        personTwo.setYearOfDeath(-1);

        DefendWitchRequest request = new DefendWitchRequest();
        request.setPersonOne(personOne);
        request.setPersonTwo(personTwo);
        assertThrows(ValidationException.class, () -> validationService.validateRequestGetAverageNumberWitcherKilled(request));
    }
}