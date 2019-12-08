package com.cybertek.tests.day11_actions_javascriptExecuter;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StaleTest {

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
    public void staleTest() {
        driver.get("http://google.com");

        WebElement input=driver.findElement(By.name("q"));
        input.sendKeys("Selenium"+ Keys.ENTER);  // this will click button

        WebElement result=driver.findElement(By.id("resultStats"));
        Assert.assertTrue(result.isDisplayed());


        // go to google second time
        driver.navigate().back();

        //
        // after refreshed or comingback again the web
        // the web element have to be located again
        // the old located web element will not  work
        // have to do
         input=driver.findElement(By.name("q"));
        input.sendKeys("amazon"+ Keys.ENTER);


        // if you directly use only :   input.sendKeys("amazon"+ Keys.ENTER);
        // but not locating element again  , not adding   WebElement input=driver.findElement(By.name("q"));
        // it will give stale element reference exception

    }
}
