package com.cybertek.tests.day10_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExamples {

    WebDriver driver;  // have to declare driver outside the class not inside the method and make it global;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);

    }

    @Test
    public void test1() {

        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

        // set implicitwait , it will effect every find element not only one
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String message=driver.findElement(By.id("finish")).getText();
        System.out.println("message = " + message);

    }
}