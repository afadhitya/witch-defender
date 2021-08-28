package com.afadhitya.witchdefender.util.impl;

import com.afadhitya.witchdefender.TestPairModelHelper;
import com.afadhitya.witchdefender.model.VillagerKilledByWitcher;
import com.afadhitya.witchdefender.util.CalculationUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CalculationUtilImplTest {

    private final CalculationUtil calculationUtil = new CalculationUtilImpl();

    @Test
    void calculateVillagerWhichNeedToKilledByWitcher() {
        TestPairModelHelper<Integer, Integer> testData = new TestPairModelHelper<>(1, 1);
        TestPairModelHelper<Integer, Integer> testData2 = new TestPairModelHelper<>(2, 2);
        TestPairModelHelper<Integer, Integer> testData3 = new TestPairModelHelper<>(3, 4);
        TestPairModelHelper<Integer, Integer> testData4 = new TestPairModelHelper<>(4, 7);
        TestPairModelHelper<Integer, Integer> testData5 = new TestPairModelHelper<>(5, 12);
        TestPairModelHelper<Integer, Integer> testData6 = new TestPairModelHelper<>(6, 20);
        List<TestPairModelHelper<Integer, Integer>> testDataList =
                new ArrayList<>(Arrays.asList(testData, testData2, testData3, testData4, testData5, testData6));

        for (TestPairModelHelper<Integer, Integer>  testPairModelHelper : testDataList) {
            VillagerKilledByWitcher villagerKilledByWitcher = new VillagerKilledByWitcher();
            villagerKilledByWitcher.setYearOfDuty(testPairModelHelper.getTestData());
            int result = calculationUtil.calculateVillagerWhichNeedToKilledByWitcher(villagerKilledByWitcher).getKilledVillager();
            Assertions.assertEquals(testPairModelHelper.getExpectedResult(), result);
        }
    }

    @Test
    void calculateVillagerWhichNeedToKilledByWitcher_MemoryPerformance() {
        VillagerKilledByWitcher villagerKilledByWitcher = new VillagerKilledByWitcher();
        villagerKilledByWitcher.setYearOfDuty(Integer.MAX_VALUE);
        calculationUtil.calculateVillagerWhichNeedToKilledByWitcher(villagerKilledByWitcher);
    }
}