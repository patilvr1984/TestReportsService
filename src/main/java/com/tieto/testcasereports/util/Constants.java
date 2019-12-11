package com.tieto.testcasereports.util;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final String PASS = "PASS";
    public static final String FAILED = "FAILED";
    public static final String TEST_SUITE_KEY = "Test Suite";
    public static final String TEST_CASE_KEY = "Test Case";
    public static final String TEST_STEP_KEY = "Test Step";
    public static final String TEST_STEP_TYPE_KEY = "Step Type";
    public static final String TEST_STEP_STATUS_KEY = "Step Status";
    public static final String TEST_RESULT_MSG_KEY = "Result message";
    public static final String TEST_EXEC_DATE_KEY = "Execution Date";

    public static final String TEST_SUITE_VALUE = "testSuite";
    public static final String TEST_CASE_VALUE = "testCase";
    public static final String TEST_STEP_VALUE = "testStep";
    public static final String TEST_STEP_TYPE_VALUE = "stepType";
    public static final String TEST_STEP_STATUS_VALUE = "stepStatus";
    public static final String TEST_RESULT_MSG_VALUE = "resultMessage";
    public static final String TEST_EXEC_DATE_VALUE = "executionDate";
    public static final String CSV_PATH_PREFIX = "CSV_PATH_";

    public static final Map<String, String> enviornment = new HashMap<String, String>(){{
        put("CSV_PATH_DEV2", "C:\\Repository\\Report_20-Nov-2019 18_19.csv");
        put("CSV_PATH_DEV3", "C:\\Repository\\Report_20-Nov-2019 18_19.csv");
        put("CSV_PATH_FAT3", "C:\\Repository\\Report_20-Nov-2019 18_19.csv");
        put("CSV_PATH_FAT4", "C:\\Repository\\Report_20-Nov-2019 18_19.csv");
    }};
}
