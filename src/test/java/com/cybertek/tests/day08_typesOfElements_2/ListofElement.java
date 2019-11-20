package com.cybertek.tests.day08_typesOfElements_2;

import com.cybertek.utilities.WebDriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ListofElement {

    // locate multiple element

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        
        // i will save these multiple elements to ArrayList, it will receive web element
        List<WebElement> buttons=driver.findElements(By.tagName("button"));

        int howManyButton=buttons.size();
        System.out.println("howManyButton = " + howManyButton);
        
        // verify that you got 6 web elements


        Assert.assertEquals(buttons.size(), 6,"verify that you got 6 web elements");

        // now run for each loop to get text from every element
        // for each loop ---- shortcut -----iter
        // for loop ----shortcut  ----itar
        for(WebElement button:buttons){
            System.out.println(button.getText());
        }

    }

    @Test
    public void test2() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        // if you pass wrong locator
        // we won't get error, we are getting empty list --- so size will be ---0
        List<WebElement> buttons=driver.findElements(By.tagName("buttonasdascscd"));
        System.out.println(buttons.size());

    }

}
