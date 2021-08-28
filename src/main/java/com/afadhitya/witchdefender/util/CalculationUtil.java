package com.afadhitya.witchdefender.util;

import com.afadhitya.witchdefender.model.VillagerKilledByWitcher;
import org.springframework.stereotype.Component;

@Component
public interface CalculationUtil {

    // to find number of villagers she should kill each year
    VillagerKilledByWitcher calculateVillagerWhichNeedToKilledByWitcher(VillagerKilledByWitcher villagerKilledByWitcher);
}
