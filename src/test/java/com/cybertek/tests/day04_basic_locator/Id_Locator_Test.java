package com.cybertek.tests.day04_basic_locator;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Id_Locator_Test {

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        // to maximize window
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement dontCliclkButton=driver.findElement(By.id("disappearing_button"));
        dontCliclkButton.click();

       driver.quit();



    }
}
