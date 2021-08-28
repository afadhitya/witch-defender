package com.afadhitya.witchdefender.service.impl;

import com.afadhitya.witchdefender.controller.request.DefendWitchRequest;
import com.afadhitya.witchdefender.controller.response.DefendWitchResponse;
import com.afadhitya.witchdefender.model.Person;
import com.afadhitya.witchdefender.service.WitchDefenderService;
import com.afadhitya.witchdefender.util.CalculationUtil;
import com.afadhitya.witchdefender.util.impl.CalculationUtilImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WitchDefenderServiceImplTest {

    private WitchDefenderService witchDefenderService;

    @BeforeEach
    void setUp() {
        CalculationUtil calculationUtil = new CalculationUtilImpl();
        witchDefenderService = new WitchDefenderServiceImpl(calculationUtil);
    }

    @Test
    void calculateAverageNumberKilledByWitch() {

        DefendWitchRequest request = new DefendWitchRequest();

        Person personOne = new Person();
        personOne.setAgeOfDeath(13);
        personOne.setYearOfDeath(17);
        request.setPersonOne(personOne);

        Person personTwo = new Person();
        personTwo.setAgeOfDeath(10);
        personTwo.setYearOfDeath(12);
        request.setPersonTwo(personTwo);

        DefendWitchResponse response = witchDefenderService.calculateAverageNumberKilledByWitch(request);
        Assertions.assertEquals(4.5f, response.getAverageNumberOfPeopleWitchKilled());
    }
}