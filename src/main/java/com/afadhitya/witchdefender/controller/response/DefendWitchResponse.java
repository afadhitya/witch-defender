package com.afadhitya.witchdefender.controller.response;

public class DefendWitchResponse {
    private float averageNumberOfPeopleWitchKilled;

    public DefendWitchResponse(float averageNumberOfPeopleWitchKilled) {
        this.averageNumberOfPeopleWitchKilled = averageNumberOfPeopleWitchKilled;
    }

    public float getAverageNumberOfPeopleWitchKilled() {
        return averageNumberOfPeopleWitchKilled;
    }

    public void setAverageNumberOfPeopleWitchKilled(float averageNumberOfPeopleWitchKilled) {
        this.averageNumberOfPeopleWitchKilled = averageNumberOfPeopleWitchKilled;
    }
}
