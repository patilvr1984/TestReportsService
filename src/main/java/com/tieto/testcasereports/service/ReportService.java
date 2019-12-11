package com.tieto.testcasereports.service;

import com.tieto.testcasereports.model.TestReport;
import com.tieto.testcasereports.model.TestReports;

import java.util.List;

public interface ReportService {
    List<TestReport> fetchReport(String env);
}
