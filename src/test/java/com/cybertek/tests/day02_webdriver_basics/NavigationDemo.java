package com.cybertek.tests.day02_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {

    public static void main(String[] args) throws InterruptedException {

        // setting up the browser
        WebDriverManager.chromedriver().setup();

        // import class CMD+ENTER or ALT+enter or control +SPACE
        // selenium object
        WebDriver driver=new ChromeDriver();
//----------------------------------------------------------------------------------------------------------------------
     // Open website

        // navigate to browser, open website
        driver.get("https://www.amazon.com");

        //another way of opening website
        driver.navigate().to("https://www.facebook.com");

        // goes back to previous wepage  --- first amazon then FB then go back amazon
        driver.navigate().back();

        // goes forward   ------first amazon then FB then go back amazon then forward facebook
        driver.navigate().forward();

        // stop your code
        Thread.sleep(3000);  // it will give error at "sleep" first, then click"Add Exception " it will be gone

        // refresh the page
        driver.navigate().refresh();










    }
}
