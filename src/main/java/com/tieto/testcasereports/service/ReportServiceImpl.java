package com.tieto.testcasereports.service;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.tieto.testcasereports.model.TestReport;
import com.tieto.testcasereports.model.TestReports;
import com.tieto.testcasereports.util.Constants;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

@Component("reportService")
public class ReportServiceImpl implements ReportService {

    public List<TestReport> fetchReport(String env){
        return populateTestDataFromCSV(env);
    }

    private List<TestReport> populateTestDataFromCSV(String env){
        CSVReader csvReader = null;
        CsvToBean csvToBean = new CsvToBean();
        Map<String, String> mapping = new HashMap<>();
        mapping.put(Constants.TEST_SUITE_KEY,Constants.TEST_SUITE_VALUE);
        mapping.put(Constants.TEST_CASE_KEY, Constants.TEST_CASE_VALUE);
        mapping.put(Constants.TEST_STEP_KEY,Constants.TEST_STEP_VALUE);
        mapping.put(Constants.TEST_STEP_TYPE_KEY,Constants.TEST_STEP_TYPE_VALUE);
        mapping.put(Constants.TEST_STEP_STATUS_KEY,Constants.TEST_STEP_STATUS_VALUE);
        mapping.put(Constants.TEST_RESULT_MSG_KEY,Constants.TEST_RESULT_MSG_VALUE);
        mapping.put(Constants.TEST_EXEC_DATE_KEY,Constants.TEST_EXEC_DATE_VALUE);

        HeaderColumnNameTranslateMappingStrategy<TestReport> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
        strategy.setType(TestReport.class);
        strategy.setColumnMapping(mapping);

        try {
            csvReader = new CSVReader(new FileReader(Constants.enviornment.get(Constants.CSV_PATH_PREFIX+env)));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        csvToBean.setCsvReader(csvReader);
        csvToBean.setMappingStrategy(strategy);
        List<TestReport> testReportLs = seperatePassFailedTestSuite(groupByTestSuite(csvToBean.parse()));

        return testReportLs;
    }

    private List<TestReport> seperatePassFailedTestSuite(Map<String, List<TestReport>> reportHm){
        List<TestReport> tReportLs = new ArrayList<>();
        for (String testSuite : reportHm.keySet()) {
            Optional<TestReport> optional = reportHm.get(testSuite).stream().filter(tr -> Constants.FAILED.equalsIgnoreCase(tr.getStepStatus())).findFirst();
            if(optional.isPresent()){
                tReportLs.add(optional.get());
            }else{
                TestReport tr = reportHm.get(testSuite).get(reportHm.get(testSuite).size()-1);
                tr.setStepStatus(Constants.PASS);
                tReportLs.add(tr);
            }
        }
        return tReportLs;
    }

    private Map<String, List<TestReport>> groupByTestSuite(List<TestReport> testReportsLs){
        Map<String, List<TestReport>> reportHm = new HashMap<>();
        for (TestReport tr : testReportsLs) {
            if (!reportHm.containsKey(tr.getTestSuite())) {
                List<TestReport> list = new ArrayList<>();
                list.add(tr);
                reportHm.put(tr.getTestSuite(), list);
            } else {
                reportHm.get(tr.getTestSuite()).add(tr);
            }
        }

        return reportHm;
    }



    public static void main(String[] args) {
        ReportServiceImpl i = new ReportServiceImpl();
        List<TestReport> ls = i.populateTestDataFromCSV("Dev2");
        for (TestReport r:ls) {
            System.out.println(r);
        }
    }
}
