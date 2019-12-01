package com.cybertek.tests.day10_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitExamples {

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

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        driver.findElement(By.tagName("button")).click();

      WebElement username= driver.findElement(By.id("username"));

      // have to wait explicitly

       // create Explicit wait object
        WebDriverWait wait=new WebDriverWait(driver,10) ;

        //call until method from wait object
        //waiting for specific element to be visible (up to 10 seconds)
        wait.until(ExpectedConditions.visibilityOf(username));


      username.sendKeys("Mike Smith");
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        //click enable
        driver.findElement(By.xpath("//button[contains(text(),'Enable')]")).click();

        // input box
        WebElement inputBox=driver.findElement(By.cssSelector("input[type='text']"));

        // wait until element is enable or clickable
        WebDriverWait wait=new WebDriverWait(driver,30);

        wait.until(ExpectedConditions.elementToBeClickable(inputBox));

        inputBox.sendKeys("something something");
    }
}
