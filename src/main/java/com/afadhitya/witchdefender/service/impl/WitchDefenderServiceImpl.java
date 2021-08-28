package com.afadhitya.witchdefender.service.impl;

import com.afadhitya.witchdefender.controller.request.DefendWitchRequest;
import com.afadhitya.witchdefender.controller.response.DefendWitchResponse;
import com.afadhitya.witchdefender.model.Person;
import com.afadhitya.witchdefender.model.VillagerKilledByWitcher;
import com.afadhitya.witchdefender.service.WitchDefenderService;
import com.afadhitya.witchdefender.util.CalculationUtil;
import org.springframework.stereotype.Service;

@Service
public class WitchDefenderServiceImpl implements WitchDefenderService {

    private final CalculationUtil calculationUtil;

    public WitchDefenderServiceImpl(CalculationUtil calculationUtil) {
        this.calculationUtil = calculationUtil;
    }

    @Override
    public DefendWitchResponse calculateAverageNumberKilledByWitch(DefendWitchRequest request) {

        Person personOne = request.getPersonOne();
        personOne.setYearOfBorn(personOne.getYearOfDeath() - personOne.getAgeOfDeath());
        Person personTwo = request.getPersonTwo();
        personTwo.setYearOfBorn(personTwo.getYearOfDeath() - personTwo.getAgeOfDeath());

        VillagerKilledByWitcher villagerKilledOnPersonOneBornDay = new VillagerKilledByWitcher();
        villagerKilledOnPersonOneBornDay.setYearOfDuty(personOne.getYearOfBorn());
        villagerKilledOnPersonOneBornDay = calculationUtil.calculateVillagerWhichNeedToKilledByWitcher(villagerKilledOnPersonOneBornDay);

        VillagerKilledByWitcher villagerKilledOnPersonTwoBornDay = new VillagerKilledByWitcher();
        villagerKilledOnPersonTwoBornDay.setYearOfDuty(personTwo.getYearOfBorn());
        villagerKilledOnPersonTwoBornDay = calculationUtil.calculateVillagerWhichNeedToKilledByWitcher(villagerKilledOnPersonTwoBornDay);

        return new DefendWitchResponse(
                (float) (villagerKilledOnPersonOneBornDay.getKilledVillager() + villagerKilledOnPersonTwoBornDay.getKilledVillager()) / 2);
    }
}
