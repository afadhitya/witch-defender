package com.afadhitya.witchdefender.controller.request;

import com.afadhitya.witchdefender.model.Person;

public class DefendWitchRequest {
    private Person personOne;
    private Person personTwo;

    public Person getPersonOne() {
        return personOne;
    }

    public void setPersonOne(Person personOne) {
        this.personOne = personOne;
    }

    public Person getPersonTwo() {
        return personTwo;
    }

    public void setPersonTwo(Person personTwo) {
        this.personTwo = personTwo;
    }
}
