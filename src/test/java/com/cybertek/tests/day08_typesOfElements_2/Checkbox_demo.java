package com.cybertek.tests.day08_typesOfElements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkbox_demo {

    @Test
    public void test1(){

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/checkboxes");

        /*    <input type="checkbox">
        because there are two , so i can use index
         */
        WebElement checkbox1=driver.findElement(By.xpath("//input[1]"));
        WebElement checkbox2=driver.findElement(By.xpath("//input[2]"));


        // verify that checkbox1 is unselected and 2 is selected

        //checkbox1 is unselected, so checkbox1.isSelected() should return false , so i choose Assert.assertFalse()
        Assert.assertFalse(checkbox1.isSelected(),"checkbox1 is unselected");

        //checkbox2 is selected, so checkbox2.isSelected() should return true , so i choose Assert.assertTrue()
        Assert.assertTrue(checkbox2.isSelected(),"checkbox2 is selected");


      /*--------------------------------------------------------------------------------------------------------*/
        // select first checkbox
        checkbox1.click();   // i will click checkbox1

        // checkbox1 is selected, so checkbox1.isSelected() should return true , so i choose Assert.assertTrue()
        Assert.assertTrue(checkbox1.isSelected(),"checkbox1 is selected");

        //checkbox2 is already selected by default, so checkbox2.isSelected() should return true , so i choose Assert.assertTrue()
        Assert.assertTrue(checkbox2.isSelected(),"checkbox2 is selected");


    }
}
