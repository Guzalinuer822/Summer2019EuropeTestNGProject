package com.cybertek.tests.day03_webElement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyURLchanged {
    /*
     *
     Verify URL changed

     open browser
     go to http://practice.cybertekschool.com/forgot_password Links to an external site.
     enter any email
     click on Retrieve password
     verify that url changed to http://practice.cybertekschool.com/email_sent
     */

    public static void main(String[] args) {

        //open browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("email@gmail.com");

        // click on Retrieve password
        WebElement retrievePassword = driver.findElement(By.id("form_submit"));
        retrievePassword.click();

        // verify that url changed to http://practice.cybertekschool.com/email_sent

        String expectedUrl = "http://practice.cybertekschool.com/email_sent";

        String actualUrl = driver.getCurrentUrl();

        if(expectedUrl.equals(actualUrl)){
            System.out.println("pass");

        }else{
            System.out.println("fail");
            System.out.println("actualUrl= "+actualUrl);
            System.out.println("expectedUrl= "+expectedUrl);
        }

        driver.quit();
    }

}
