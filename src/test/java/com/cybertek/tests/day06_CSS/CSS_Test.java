package com.cybertek.tests.day06_CSS;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_Test {

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        // # is only looking for id , so do not to write id in front of #disappearing_button
        WebElement dontClickButton=driver.findElement(By.cssSelector("#disappearing_button"));
        
        String message=dontClickButton.getText();

        System.out.println("message = " + message);

        // for home
        // one way----xpath
        // WebElement homeLink=driver.findElement(By.xpath("//a[@class='nav-link']"));


        //1.
        // syntax ---> tagname.value or .value
        // another way---css selector
        // " . " ----> this dot is only looking for class
      //  WebElement homeCss=driver.findElement((By.cssSelector("a.nav-link")));

        //2.
       // syntax ---> tagname.class
        // class="btn btn-primary"
        // this class value "btn btn-primary" has space between btn and btn
        // so have to put "." to replace space
        // .btn.btn-primary ---> it will locate class of multiple button
        // for the specific button can put id value with # write --> .btn.btn-primary#disappearing_button

        //3.
        //syntax ---> tagname[attribute='value']
        // write in xpath:  //button[@onclick='button1()']
        // write in css:   button[onclick='button1()']
        WebElement button1=driver.findElement(By.cssSelector("button[onclick='button1()']"));

        String message1=button1.getText();

        System.out.println("message1 = " + message1);


        //4. starts-with
        //syntax ---> tagname[attribute^='value']
        // for button 3
        // xpath: //button[starts-with(@id,'button_')]
        // css: button[id^='button_']
       //  "^"---looking for starting part of the value


        //5. end-with
        //syntax --->tagname[attribute$='value']



        // 6.*
        // syntax --->tagname[attribute*='value']
        // '*' ---> means contains in css
        // for button don't click
        // xpath: //button[contains(@id='g_button')]   or //button[contains(text(),'Don't click')]
        // css: button[id*='g_button']


        // ^ front part;  * middle ; $ end part

        // button[onclick^=‘button’]:nth-of-type(3)

        // xpath: //*[@class=‘navbar navbar-expand-sm bg-light’]//a
        // css: .navbar.navbar-expand-sm.bg-light a


        // <h1 class="diplay-inline strong wt-text-caption"
        // h1.display-inline.strong.wt-text-caption



        //-------------------------------------------------------------------//
        // difference between css Vs xpath
        // css is faster than xpath
        // css can not locate using text   xpath: //*[.='Don't Click']
        // it cannot find from matches based on index (different parent)
        //searching from parents /button/../ ---> going back to parent ,but no option for css
        // xpath can do more than css

        // when use locator:
        // first look for id, then name, tagname,classname...

        // xpath is more useful



    }
}
