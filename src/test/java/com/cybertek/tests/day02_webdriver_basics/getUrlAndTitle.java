package com.cybertek.tests.day02_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getUrlAndTitle {

    public static void main(String[] args) {

        // set up  WebDriverManager
        //create driver object
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://practice.cybertekschool.com");

        String title=driver.getTitle();

        // soutv will print with value automatically
        System.out.println("title = " + title);

        //.getCurrentUrl()---> gets current url of the page
        String currentUrl=driver.getCurrentUrl();

        System.out.println("currentUrl = " + currentUrl);
        // .getPageSource() --> gets the source code of page
        String pageSource=driver.getPageSource();
        System.out.println("pageSource = " + pageSource);


    }
}
