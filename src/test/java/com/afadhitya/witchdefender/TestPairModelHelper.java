package com.afadhitya.witchdefender;

public class TestPairModelHelper<T, E> {
    private T testData;
    private E expectedResult;

    public TestPairModelHelper(T testData, E expectedResult) {
        this.testData = testData;
        this.expectedResult = expectedResult;
    }

    public T getTestData() {
        return testData;
    }

    public void setTestData(T testData) {
        this.testData = testData;
    }

    public E getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(E expectedResult) {
        this.expectedResult = expectedResult;
    }
}
