package com.cybertek.tests.day05_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath_Test {

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
/*
        WebElement homeLink=driver.findElement(By.xpath("/html/body/nav/ul/li/a"));
        homeLink.click();
*/
        // html/body/div/div[2]/div/div[1]/p

        //------>  //button[@onclick="button3()"]
        WebElement button3=driver.findElement(By.xpath("//button[@onclick='button3()']"));
        button3.click();

        // ----->  "//button[@onclick='button3()']"
        // ----->  "//button[@*='button3()]"    * means----any attribute
        // ----->  "//*[@onclick='button3()]"    * means----any element

        // using-----> text on the button
        // ----->  "//button[text()='Button 5']"  // this 'Button 5' is coming from text ---on the button
        // ----->  "//button[.='Button 5']"

       // http://practice.cybertekschool.com/sign_up

    //    driver.get("http://practice.cybertekschool.com/sign_up");

    //    WebElement signUpPage=driver.findElement(By.xpath("//*[.='Sign Up Page']"));


        // contains
      // ----->  "//button[contains(text(),'ton 1')]"
        WebElement button1=driver.findElement(By.xpath("//button[contains(text(),'Button 1')]"));
        button1.click();

        // "//button[starts-with(@id,'button_')]"

        WebElement button3again=driver.findElement(By.xpath("//button[starts-with(@id,'button_')]"));
        button3again.click();
    }
}
