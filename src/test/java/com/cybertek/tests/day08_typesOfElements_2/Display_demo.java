package com.cybertek.tests.day08_typesOfElements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Display_demo {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInput = driver.findElement(By.id("username"));

        // isDisplayed()---- return true if it is visible on the page
        // if it is not visible, you have to

        System.out.println(usernameInput.isDisplayed());

        Assert.assertFalse(usernameInput.isDisplayed(), "Verify that username inputbox is not displayed");
        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();
        Thread.sleep(5000);
        System.out.println(usernameInput.isDisplayed());
        Assert.assertTrue(usernameInput.isDisplayed());

    }
}
