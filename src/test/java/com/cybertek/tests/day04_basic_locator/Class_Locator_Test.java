package com.cybertek.tests.day04_basic_locator;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Class_Locator_Test {

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement homeLink=driver.findElement(By.className("nav-link"));
        homeLink.click();


        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement multipleButtonsTitle=driver.findElement(By.className("h3"));

        String message=multipleButtonsTitle.getText();

        System.out.println(message);

        // if there is space in the class attribute value,  example: "btn btn-primary"
        // we can not use it because it has space in between "btn btn";

    }
}
