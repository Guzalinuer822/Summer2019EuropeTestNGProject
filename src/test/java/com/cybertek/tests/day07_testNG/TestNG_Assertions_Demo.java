package com.cybertek.tests.day07_testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_Assertions_Demo {

    @Test
    public void test1(){

        System.out.println("First Assertions");
        Assert.assertEquals("one","one");

        System.out.println("Second Assertions");
        Assert.assertEquals("title","title");
        System.out.println("After second Assertions");

    }

    @Test
    public void test2(){
        System.out.println("This is test 2");

        // verify that title starts with C
        String actual="Cybertek";
        String expected="C";

        Assert.assertTrue(actual.startsWith(expected),"verify title starts with C");

        // verify that email includes @sign
        String actualEmail="guzalgmail.com";
        String expectedEmail="@";

        Assert.assertTrue(actualEmail.contains(expectedEmail),"verify @ sign is here");
    }

    @Test
    public void test3(){

        Assert.assertNotEquals("one","on","check not equal");
        //http://practice.cybertekschool.com/radio_buttons
    }
}
