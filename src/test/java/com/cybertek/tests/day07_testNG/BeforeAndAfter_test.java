package com.cybertek.tests.day07_testNG;

import org.testng.annotations.*;

public class BeforeAndAfter_test {

    @Test
    public void test1(){
        System.out.println("This is test 1.");
    }

    @Ignore
    @Test
    public void test2(){
        System.out.println("This is test 2.");
    }

    @Test
    public void test3(){
        System.out.println("This is test 3.");
    }
    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before method");
        System.out.println("Opening the browser");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After method");
        System.out.println("Close browser");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class code");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After class code");
        System.out.println("Reporting");
    }

}
