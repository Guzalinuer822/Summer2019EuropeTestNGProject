package com.cybertek.tests.day07_typesOfElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Disabled_RadioButton {

    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenRadioButton=driver.findElement(By.id("green"));
        System.out.println("greenRadioButton disabled: " + greenRadioButton.isEnabled());
        Assert.assertFalse(greenRadioButton.isEnabled());
    }

    @Test
    public void test2(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        //locating element: #input-example>input
        // locate element :[type=text]
        // this two is locating same element

        WebElement enableInputBox=driver.findElement(By.cssSelector("[type='text']"));

        System.out.println("enable/disable Input Box is Enabled: " + enableInputBox.isEnabled());
        enableInputBox.sendKeys("Mike Smith");  // it will fail , give error : ElementNotInteractableException: element not interactable


    }
}
