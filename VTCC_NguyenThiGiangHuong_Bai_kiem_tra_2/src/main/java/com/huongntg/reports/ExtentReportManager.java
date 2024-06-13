package com.huongntg.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("exports/reports/extentreport/extentreport.html");
        reporter.config().setReportName("Extent Report | Giang Huong");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework Name", "Selenium Java | Giang Huong");
        extentReports.setSystemInfo("Author", "Giang Huong");
        return extentReports;
    }

}

