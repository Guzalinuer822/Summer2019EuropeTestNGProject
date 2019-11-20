package com.cybertek.tests.day08_typesOfElements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClassTest {

    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        // locate the drop down element with unique locator

        WebElement dropdownElement = driver.findElement(By.id("state"));

        //   <select id="state">  ---- tag name has to be select

        // Select --- this class only works with web element which has select tag
        // from Select class I create one object and pass my webelement object as a argument to constructor;
        Select stateList = new Select(dropdownElement);

        // getOptions() ---> returns all the available options from the dropdown list

        List<WebElement> options=stateList.getOptions();

        for (WebElement option : options) {
            System.out.println(option.getText());

        }

    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        // locate the drop down element with unique locator

        WebElement dropdownElement = driver.findElement(By.id("state"));

        //   <select id="state">  ---- tag name has to be select

        // Select --- this class only works with web element which has select tag
        // from Select class I create one object and pass my webelement object as a argument to constructor;
        Select stateList = new Select(dropdownElement);

        // verify first option is selected -- "Select a State"

        // short way:   stateList.getFirstSelectedOption().getText();
        
        // right way and understandable way :
        WebElement firstOption=stateList.getFirstSelectedOption();
        String actualOption=firstOption.getText();

        String expectedOption="Select a State";

         Assert.assertEquals(actualOption,expectedOption,"");
       // Assert.assertEquals(actualOption,expectedOption,"verify first option is selected -- Select a state");
        
       // how to select option from the dropdown  ---3 way

        //HOW TO SELECT OPTIONS FROM THE DROPDOWN ?


        //1.USING VISIBLE TEXT
        //selectByVisibleText("text")--> selecting based on the visible text
        Thread.sleep(2000);
        //Selecting texas from the dropdown
        stateList.selectByVisibleText("Texas");
        actualOption = stateList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,"Texas");


        //2.USING INDEX NUMBER
        //total option -->52
        Thread.sleep(2000);
        stateList.selectByIndex(51);
        actualOption = stateList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,"Wyoming");


        //3.USING VALUE
        Thread.sleep(2000);
        stateList.selectByValue("VA");
        System.out.println(stateList.getFirstSelectedOption().getText());

    }


    }
