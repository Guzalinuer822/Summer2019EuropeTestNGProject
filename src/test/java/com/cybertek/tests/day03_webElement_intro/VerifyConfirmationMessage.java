package com.cybertek.tests.day03_webElement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyConfirmationMessage {

    /*
    Verify confirmation message

    open browser
    go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
    enter any email
    verify that email is displayed in the input box
    click on Retrieve password
    verify that confirmation message says 'Your e-mail's been sent!'
     */

    public static void main(String[] args) {

        // open browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));

        // verify that email is displayed in the input box
        String expectedEmail = "test@gmail.com";

        // send expected email
        emailInputBox.sendKeys(expectedEmail);

        // verify it is displayed
        // so first get text from web element use .getText()
        // or use getAttribute() -----> get value of attributes
        // example : String actualEmail=emailInputBox.getAttribute("value");
        String actualEmail = emailInputBox.getText();

        if (expectedEmail.equals(actualEmail)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
            System.out.println("actualEmail = " + actualEmail);
            System.out.println("expectedEmail = " + expectedEmail);
        }


        // click on Retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));

        // click
        retrievePasswordButton.click();

        //verify that confirmation message says 'Your e-mail's been sent!'

        String expectedConfirmation = "Your e-mail's been sent!";

        // get actual message
        WebElement confirmationElement = driver.findElement(By.name("confirmation_message"));
        String actualConfirmation = confirmationElement.getText();


        if (expectedConfirmation.equals(actualConfirmation)) {
            System.out.println("pass");
        } else {
            System.out.println("Fail");
            System.out.println("expectedConfirmation = " + expectedConfirmation);
            System.out.println("actualConfirmation = " + actualConfirmation);

        }

        // close the browse
        driver.quit();

    }
}
