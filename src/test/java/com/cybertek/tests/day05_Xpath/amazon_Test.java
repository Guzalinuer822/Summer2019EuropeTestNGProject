package com.cybertek.tests.day05_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazon_Test {

       /*
    navigate to amazon.com
    type selenium in the search box
    click search button
     */

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://www.amazon.com/");

        WebElement searchInput=driver.findElement(By.id("twotabsearchtextbox"));
        searchInput.sendKeys("selenium");

        WebElement searchButton=driver.findElement(By.xpath("//*[@value='Go']"));
        searchButton.click();

        // other way to do it

        /*
         WebElement search = driver.findElement(By.xpath("//*[@type = 'text']"));
        search.sendKeys("Selenium");
​
        WebElement searchButton = driver.findElement(By.xpath("//*[@type = 'submit']"));
        searchButton.click();
         */

        //
        WebElement resultFor=driver.findElement(By.xpath("//span[contains(text(),'results')]"));
        String result=resultFor.getText();
        System.out.println(result);

    }
}


