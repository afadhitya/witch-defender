package com.afadhitya.witchdefender.service;

import com.afadhitya.witchdefender.controller.request.DefendWitchRequest;
import com.afadhitya.witchdefender.controller.response.DefendWitchResponse;

public interface WitchDefenderService {

    DefendWitchResponse calculateAverageNumberKilledByWitch(DefendWitchRequest request);
}
