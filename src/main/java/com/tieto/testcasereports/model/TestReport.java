package com.tieto.testcasereports.model;

import java.io.Serializable;

public class TestReport implements Serializable {
    private static final long serialVersionUID = 1L;

    private String testSuite;
    private String testCase;
    private String testStep;
    private String stepStatus;
    private String stepType;
    private String resultMessage;
    private String executionDate;

    public String getTestSuite() {
        return testSuite;
    }

    public void setTestSuite(String testSuite) {
        this.testSuite = testSuite;
    }

    public String getTestCase() {
        return testCase;
    }

    public void setTestCase(String testCase) {
        this.testCase = testCase;
    }

    public String getTestStep() {
        return testStep;
    }

    public void setTestStep(String testStep) {
        this.testStep = testStep;
    }

    public String getStepStatus() {
        return stepStatus;
    }

    public void setStepStatus(String stepStatus) {
        this.stepStatus = stepStatus;
    }

    public String getStepType() {
        return stepType;
    }

    public void setStepType(String stepType) {
        this.stepType = stepType;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(String executionDate) {
        this.executionDate = executionDate;
    }

    @Override
    public String toString() {
        return "TestReport{" +
                "testSuite='" + testSuite + '\'' +
                ", testCase='" + testCase + '\'' +
                ", testStep='" + testStep + '\'' +
                ", stepStatus='" + stepStatus + '\'' +
                ", stepType='" + stepType + '\'' +
                ", resultMessage='" + resultMessage + '\'' +
                ", executionDate='" + executionDate + '\'' +
                '}';
    }
}
