package com.cybertek.tests.day10_UploadFile;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class fileUpload {

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

        driver.get("http://practice.cybertekschool.com/upload");

        driver.findElement(By.name("file")).sendKeys("C:/Users/guzal/Desktop/Git-Github.txt");


    }
}
