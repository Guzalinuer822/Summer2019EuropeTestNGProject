package com.cybertek.tests.day11_actions_javascriptExecuter;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest {

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
    public void click() {
        driver.get("http://practice.cybertekschool.com/");

        driver.manage().window().maximize();

        WebElement link=driver.findElement(By.linkText("Dropdown"));

        // if something blocking that element
        // we can create  JavaScript Executer object
        // run js code with that object

        // how to create  JavaScript Executer object?
        JavascriptExecutor jse=(JavascriptExecutor) driver;   // this is casting driver object

        // then
       //  choose method ----> executeScript(); ----------we write inside  JavaScript code

        //clicking using  JavaScript
        jse.executeScript("arguments[0].click();",link);

    }

    @Test
    public void type(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputbox = driver.findElement(By.cssSelector("input[type='text']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String str = "hello disable inputbox";
        jse.executeScript("arguments[0].setAttribute('value', '" + str +"')",inputbox);
    }

    @Test
    public void Scroll() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/infinite_scroll");

        JavascriptExecutor jse=(JavascriptExecutor) driver;

        // plus number : will be go down
        for (int i = 0; i < 10; i++) {
             Thread.sleep(5000);
             // have to know this scrollBy() method
             jse.executeScript("window.scrollBy(0,250)");

        }

        // minus number: will be go down
        for (int i = 0; i < 10; i++) {
            Thread.sleep(5000);
            // have to know this scrollBy() method
            jse.executeScript("window.scrollBy(0,-250)");

        }


    }
}
