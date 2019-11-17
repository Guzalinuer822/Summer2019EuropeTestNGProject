package com.cybertek.tests.day07_typesOfElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void radioButton() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton=driver.findElement(By.id("blue"));
        WebElement redRadioButton=driver.findElement(By.id("red"));

        // how to check radio button selected or not
        System.out.println("is blue RadioButton is selected: "+blueRadioButton.isSelected());

        System.out.println("is red RadioButton is selected: "+redRadioButton.isSelected());

        //verify that blue button is selected
        Assert.assertTrue(blueRadioButton.isSelected(),"verify blue button is selected");

        //verify that red is not selected
        Assert.assertFalse(redRadioButton.isSelected(),"verify red is not selected");

        // how to select radio button
        redRadioButton.click();

        System.out.println("is blue RadioButton is selected: "+blueRadioButton.isSelected());

        System.out.println("is red RadioButton is selected: "+redRadioButton.isSelected());

        Assert.assertFalse(blueRadioButton.isSelected(),"blue not selected");
        Assert.assertTrue(redRadioButton.isSelected(),"red is selected");


    }

    @AfterMethod
    public void tearDown(){

    }
}
