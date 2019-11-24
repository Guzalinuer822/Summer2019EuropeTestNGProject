package com.cybertek.tests.day08_typesOfElements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {

    @Test
    public void test1(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropDownElement=driver.findElement(By.id("dropdownMenuLink"));

        // this is outer HTML
        /*  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Dropdown link </a>  */

        //

        // Select links=new Select(dropDownElement);

        //open the dropdown link
        dropDownElement.click();

        List<WebElement> listOfLinks=driver.findElements(By.className("dropdown-item"));

        // how many element
        System.out.println("Number of links: "+ listOfLinks.size());

        for (WebElement listOfLink : listOfLinks) {

            System.out.println("listOfLink.getText() = " + listOfLink.getText());
            
        }

        // if print only first one:  System.out.println(listOfLinks.get(0).getText());

        driver.findElement(By.linkText("Yahoo")).click();




    }
}
