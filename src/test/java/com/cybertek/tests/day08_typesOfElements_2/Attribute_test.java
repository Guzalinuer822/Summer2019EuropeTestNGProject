package com.cybertek.tests.day08_typesOfElements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Attribute_test {

    @Test
    public void test1(){

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement radioButton=driver.findElement(By.id("blue"));

        /*   <input type="radio" id="blue" name="color" checked     */

        // because getAttribute is returning value radioButton.getAttribute("id");

        // so if i pass id it will give me the value--->blue
        System.out.println(radioButton.getAttribute("id"));

        // so if i pass name it will give me the value--->color
        System.out.println(radioButton.getAttribute("name"));

        // so if i pass type it will give me the value--->radio
        System.out.println(radioButton.getAttribute("type"));

        // so if i pass herf which is not existed , it will return null;
        System.out.println(radioButton.getAttribute("herf"));

        // so if i pass attribute without value  --- checked
        //checked attribute value is boolean if it is checked it will be true
        System.out.println(radioButton.getAttribute("checked"));

        // get full html of that element --- "outerHTML"
        System.out.println(radioButton.getAttribute("outerHTML"));

        // another way of getting text "innerHTML"



    }
}
