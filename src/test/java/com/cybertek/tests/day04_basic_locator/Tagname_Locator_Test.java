package com.cybertek.tests.day04_basic_locator;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tagname_Locator_Test {

    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/sign_up");

        // locate full name input box
        WebElement fullnameInput=driver.findElement(By.tagName("input"));

        // write name in it
        fullnameInput.sendKeys("Mike smith");

        // but for the email box can not use tagname "input" , because it is not unique;
       // WebElement emailbox=driver.findElement(By.tagName("input"));   I can not do this

        // tagname :
        // there should be used only one time and
        // it should be using for first matching web element

        // locate email input box
        WebElement emailbox=driver.findElement(By.name("email"));
        // write email address in it
        emailbox.sendKeys("mike@gmail.com");

        // locate sign up button
        WebElement signupButton=driver.findElement(By.tagName("button"));

        // cliclk it
        signupButton.click();

        // locate text element
        WebElement textRead=driver.findElement(By.tagName("h3"));

        // then get the text , then print out
        String message= textRead.getText();

        System.out.println(message);

    }
}
