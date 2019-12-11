package com.tieto.testcasereports.controller;

import com.tieto.testcasereports.model.TestReport;
import com.tieto.testcasereports.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping(path = "/reports/{env}", produces = "application/json")
    public List<TestReport> getReport(@PathVariable("env") String env){
        return reportService.fetchReport(env);
    }
}
