package com.cybertek.tests.day04_basic_locator;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Linktext_And_Partiallinktext_Locator_Test {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        WebElement link3=driver.findElement(By.linkText("Example 3: Element on page that is hidden and become visible after 5 seconds"));

        link3.click();

        // lazy way of clicking home
       // driver.findElement(By.linkText("Home")).click();

        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        Thread.sleep(5000);

        WebElement link6=driver.findElement(By.partialLinkText("Example 6"));
        link6.click();


    }


}
