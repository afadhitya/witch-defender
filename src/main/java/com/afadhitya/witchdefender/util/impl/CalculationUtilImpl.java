package com.afadhitya.witchdefender.util.impl;

import com.afadhitya.witchdefender.model.VillagerKilledByWitcher;
import com.afadhitya.witchdefender.model.YearNumberKeeper;
import com.afadhitya.witchdefender.util.CalculationUtil;
import org.springframework.stereotype.Component;

@Component
public class CalculationUtilImpl implements CalculationUtil {
    @Override
    public VillagerKilledByWitcher calculateVillagerWhichNeedToKilledByWitcher(VillagerKilledByWitcher villagerKilledByWitcher) {

        YearNumberKeeper current = new YearNumberKeeper();
        int totalKeeper = 0;
        int roundCalculation = 0;

        while (roundCalculation < villagerKilledByWitcher.getYearOfDuty()) {
            if (roundCalculation <= 1) {
                current.setNumber(1);
            } else {
                current.setNumber(current.getPrev().getNumber() + current.getPrev().getPrev().getNumber());

                //release prev->prev->prev object to keep memory
                current.getPrev().getPrev().setPrev(null);
            }
            totalKeeper = totalKeeper + current.getNumber();

            YearNumberKeeper prev = current;
            current = new YearNumberKeeper();
            current.setPrev(prev);
            roundCalculation++;
        }

        villagerKilledByWitcher.setKilledVillager(totalKeeper);
        return villagerKilledByWitcher;
    }
}
