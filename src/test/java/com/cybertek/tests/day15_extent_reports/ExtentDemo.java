package com.cybertek.tests.day15_extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemo {

    // this class is used for starting and building reports
    ExtentReports report;

    // this class is used to create the HTML report file
    ExtentHtmlReporter htmlReporter;

    //this will define a test, enables adding logs, authors, test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){

        // initialize the class
        report=new ExtentReports();

        // create report path
        // so i am creating one folder for output file
        String projectPath=System.getProperty("user.dir");
        String path=projectPath + "/test-output/report.html";

        // initialize the html reporter with the report path
        htmlReporter=new ExtentHtmlReporter(path);

        // attach the html report to the report object
        report.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Vytrack smoke test");

        // set environment information
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser","chrome");
        report.setSystemInfo("Tester","Europe + UK testers");
    }


    @Test
    public void test1() {

        // give name to current test
        extentLogger = report.createTest("TC342 Login as Driver Test");

        // test steps
        extentLogger.info("Open chrome");

        extentLogger.info("go to URL");
        extentLogger.info("enter driver info");
        extentLogger.info("click submit");
        extentLogger.info("verify logged in");

        // pass() ---> marks the test case is passed
        extentLogger.pass("TC342 is passed");

    }

        @AfterMethod
        public void tearDown(){

            // this is when the report is actually created
            report.flush();
        }


}
