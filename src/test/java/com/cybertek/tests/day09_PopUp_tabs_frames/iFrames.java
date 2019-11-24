package com.cybertek.tests.day09_PopUp_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.text.html.HTML;

public class iFrames {

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
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/iframe");

        //driver.findElement(By.id("tinymce")).sendKeys("Text test");
        // if we locate directly it gives error: NoSuchElementException

        // because of iframe-----html inside html

        // first have to switch frames
        driver.switchTo().frame("mce_0_ifr");


        Thread.sleep(5000);

        // clean text box
        driver.findElement(By.id("tinymce")).clear();

        // after clear box have to locate again and fill new text
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith");

        Thread.sleep(5000);
     /*----------------------------------------------------------------------------------------*/

        // switch between frame

        //1. defaultContent();
        // go back to first frame, useful when we have switched multiple frame
        driver.switchTo().defaultContent(); // this will go first one

        Thread.sleep(5000);


        //2. using index
        // or use index to switch frame

        driver.switchTo().frame(0);
        driver.findElement(By.id("tinymce")).sendKeys("Oh my god");

        // go back to parent frame
        driver.switchTo().parentFrame(); // this go one level up , not the first one

        //3. using web element
        WebElement frameElement=driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(frameElement);

        driver.findElement(By.id("tinymce")).sendKeys("hah hah hah");


    }

    @Test
    public void multipleFrames(){
        driver.get("http://practice.cybertekschool.com/nested_frames");

        // switching to frame top
        driver.switchTo().frame("frame-top");

        // frame top has 3 baby frame---- left,middle and right

        //switching to middle frame
        driver.switchTo().frame("frame-middle");
        // get the middle text and print
        System.out.println(driver.findElement(By.id("content")).getText());

        /*--------------------------------------------------------------------------*/

        /*
        HTML
                frame_top
                         frame_left
                         frame_middle
                         frame_right
                frame_bottom
     */

        // so for switch to frame-right
        //have to go back parent frame  then switch , we can not directly switch between baby

        // go back to parent frame
        driver.switchTo().parentFrame();

        // use index to switch frame-right
        driver.switchTo().frame(2);

        // print text from frame right
        System.out.println(driver.findElement(By.tagName("body")).getText());

        /*--------------------------------------------------------------------------*/

        /*
        HTML
                frame_top
                         frame_left
                         frame_middle
                         frame_right
                frame_bottom
     */

        // go up to top level html directly
        driver.switchTo().defaultContent(); // it will go first frame


        // now switch to frame-bottom


    }
}
