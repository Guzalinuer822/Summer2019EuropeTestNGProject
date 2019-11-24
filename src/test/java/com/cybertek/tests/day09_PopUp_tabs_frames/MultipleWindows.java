package com.cybertek.tests.day09_PopUp_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

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

        driver.get("http://practice.cybertekschool.com/windows");

        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("After click title is: "+ driver.getTitle());
        
        // 
        //driver.getWindowHandle();---will get handle ----which something unique for tab
        
        String currentWindowHandle=driver.getWindowHandle();
        System.out.println("currentWindowHandle = " + currentWindowHandle);

        /*-------------------------------------------------------------------------------------*/

        // After this line, i want to switch to new window

        /*--------------------------------------------------------------------------------------*/
        // Set is like array list, but without duplicate values
        // it returns set of string
        Set<String> windowHandles=driver.getWindowHandles();
        System.out.println(windowHandles.size());

        // for switching now opened window, have to pass handle

        // we can say , if it is not the current window handle then switch to new window handle;

        // we can loop through all the window handle ,
        // if it is not the current window handle then switch to new window handle;
        for (String windowHandle : windowHandles) {
            if(!currentWindowHandle.equals(windowHandle)){
                driver.switchTo().window(windowHandle);
            }
        }

        System.out.println("After switch to new window , title is: "+driver.getTitle());
    }

    @Test
    public void moreThanTwoWindows(){

        driver.get("http://practice.cybertekschool.com/windows");

        String targetWindowTitle="New Window";

        driver.findElement(By.linkText("Click Here")).click();

        // check how many window we have
        System.out.println(driver.getWindowHandles().size());

        Set<String> windowHandles=driver.getWindowHandles();

        //we will kee switching windows until our titles equals to targetWindowTitle

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);

            if(driver.getTitle().equals(targetWindowTitle)){

                // if they are equal stop looping, i want to keep that window driver
                break;
            }

        }
        System.out.println("After loop title is: "+driver.getTitle());


    }
}
