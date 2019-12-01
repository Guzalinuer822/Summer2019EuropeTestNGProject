package com.cybertek.tests.day10_UploadFile;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilePathExamples {

    @Test
    public void test1(){
       String projectPath=System.getProperty("user.dir");

        String relativePath="src/test/resources/testFile.txt";

        String filePath=projectPath+"/"+relativePath;

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/upload");

        driver.findElement(By.name("file")).sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click();

        String actualFileName=driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actualFileName,"testFile.txt","verify whether it is same file");
    }
}
