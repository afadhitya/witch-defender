package com.afadhitya.witchdefender.util;

import com.afadhitya.witchdefender.controller.request.DefendWitchRequest;
import org.springframework.stereotype.Component;

public interface ValidationService {
    void validateRequestGetAverageNumberWitcherKilled(DefendWitchRequest request);
}
