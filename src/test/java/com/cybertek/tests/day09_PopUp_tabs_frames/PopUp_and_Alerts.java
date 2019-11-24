package com.cybertek.tests.day09_PopUp_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUp_and_Alerts {

    WebDriver driver;  // have to declare driver outside the class not inside the method and make it global;

    @BeforeMethod
    public void setUpMethod(){
         driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);

    }
    @Test
    public void test1(){

        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        driver.findElement(By.xpath("//*[text()='Destroy the World']")).click();
        driver.findElement(By.xpath("//*[text()='No']")).click();


    }

    @Test
    public void alerts() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        // click JS alert
        driver.findElement(By.xpath("//button[1]")).click();

        // to control non html alert
        // we have special class in selenium----Alert
        Alert alert=driver.switchTo().alert();

        Thread.sleep(3000);

        alert.accept();
    /*------------------------------------------------------------------------*/
        // click JS confirm
        driver.findElement(By.xpath("//button[2]")).click();

        // to control non html alert
        // we have special class in selenium----Alert
        alert=driver.switchTo().alert();

        Thread.sleep(3000);

        alert.dismiss();

        /*------------------------------------------------------------------*/
        // click JS prompt
        driver.findElement(By.xpath("//button[3]")).click();

        // to control non html alert
        // we have special class in selenium----Alert
        alert=driver.switchTo().alert();

        Thread.sleep(3000);

        alert.sendKeys("Guzal");
        Thread.sleep(3000);
        alert.accept();


    }
}
