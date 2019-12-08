package com.cybertek.tests.day11_actions_javascriptExecuter;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverTest {

    WebDriver driver;  // have to declare driver outside the class not inside the method and make it global;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);

    }


    // hover over each image in website
    // verify each name: user text is displayed
    @Test
    public void hover1() {

        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement img = driver.findElement(By.tagName("img"));
        Actions actions = new Actions(driver);
        actions.moveToElement(img).perform();
        WebElement text = driver.findElement(By.xpath("//h5[.='name: user1']"));
        Assert.assertTrue(text.isDisplayed());

    }

    @Test
    public void hover2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/hovers");

        for (int i = 1; i < 4; i++) {

            // creating dynamic xpath for image web element
            String imageXpath="(//img)[" + i + "]";     // for three picture,only index is changing
            WebElement img=driver.findElement(By.xpath(imageXpath));

            Actions actions = new Actions(driver);
            Thread.sleep(1000);
            actions.moveToElement(img).perform();


            // creating dynamic xpath for view profile web element
            String viewTextXpath="//h5[.='name: user" + i + "']";
            WebElement text = driver.findElement(By.xpath(viewTextXpath));
            Assert.assertTrue(text.isDisplayed(),"verify text 'view profile' text is displayed");

        }
    }


}
