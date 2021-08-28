package com.afadhitya.witchdefender.controller;

import com.afadhitya.witchdefender.controller.request.DefendWitchRequest;
import com.afadhitya.witchdefender.controller.response.CommonResponse;
import com.afadhitya.witchdefender.controller.response.DefendWitchResponse;
import com.afadhitya.witchdefender.service.WitchDefenderService;
import com.afadhitya.witchdefender.util.ValidationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/witchDefender")
public class WitchDefenderController {

    private final WitchDefenderService service;
    private final ValidationService validationService;

    public WitchDefenderController(WitchDefenderService service, ValidationService validationService) {
        this.service = service;
        this.validationService = validationService;
    }

    @PostMapping("/getAverageNumberWitcherKilled")
    public CommonResponse<DefendWitchResponse> getAverageNumberWitcherKilled(@RequestBody DefendWitchRequest request) {
        validationService.validateRequestGetAverageNumberWitcherKilled(request);
        DefendWitchResponse response = service.calculateAverageNumberKilledByWitch(request);
        return new CommonResponse<>(response, HttpStatus.OK.value());
    }
}
