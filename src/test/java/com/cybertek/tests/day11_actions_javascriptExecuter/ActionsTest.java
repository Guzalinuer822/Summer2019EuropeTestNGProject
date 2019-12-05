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

public class ActionsTest {

    WebDriver driver;  // have to declare driver outside the class not inside the method and make it global;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);

    }

    @Test
    public void hoverTest() {

        driver.get("http://practice.cybertekschool.com/hovers");

        driver.manage().window().maximize();

        // Actions:  this class is used for action on website
        // it is passing webdriver object ---driver ----------to constructor
        Actions action=new Actions(driver);

        WebElement img=driver.findElement(By.tagName("img"));

        //moveToElement()----inside pass my webElement, move your mouse to webElement that i pass(hover over)
        // perform()----> perform the action, complete the action
        action.moveToElement(img).perform();

        Assert.assertTrue(driver.findElement(By.linkText("View profile")).isDisplayed(),"verify view profile displayed");


    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        driver.manage().window().maximize();

        Actions actions=new Actions(driver);

        //small circle
        WebElement source=driver.findElement(By.id("draggable"));

        //big circle
        WebElement target=driver.findElement(By.id("droptarget"));

        // wait and then perform
        actions.pause(1000);

        driver.findElement(By.xpath("//button[.='Accept Cookies']")).click();

        // wait and then perform
        actions.pause(3000);

        //we have to provide source and target to this method, it will drag and drop
        // code below will be work too
        // actions.dragAndDrop(source,target).perform();



        //chain action ---> have to use build() then perform();
        //move to source -->click and hold --> move to target --> then release
        // such as:  actions.moveToElement(source).clickAndHold().moveToElement(targt).release()
        // after this build().perform();
        actions.moveToElement(source).clickAndHold().pause(3000).moveToElement(target).release().build().perform();

    }
}
