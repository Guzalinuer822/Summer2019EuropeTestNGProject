package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage{

    // we don't need to create constructor use PageFactory class here
    // because we are extending from BasePage



// if you want dynamic xpath , @FindBy will not work.
    @FindBy(xpath = "//td[contains(text(),'mbrackstone9@example.com')][@data-column-label='Email']")
    public WebElement email;

 // create a method , accepts email as a string , return webelement based on the email

    public WebElement getContactEmail(String email){

        String emailXpath = "//td[contains(text(),'"+email+"')][@data-column-label='Email']";

       return Driver.get().findElement(By.xpath(emailXpath));
    }








}


