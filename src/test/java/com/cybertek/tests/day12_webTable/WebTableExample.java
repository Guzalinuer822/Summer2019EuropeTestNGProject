package com.cybertek.tests.day12_webTable;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTableExample {

    WebDriver driver;  // have to declare driver outside the class not inside the method and make it global;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);

    }

    @Test
    public void test1() {

        WebElement table = driver.findElement(By.id("table"));

        String wholeTable = table.getText();

        // verify that jsmith@gmail.com is in the table.

        Assert.assertTrue(wholeTable.contains("jsmith@gmail.com"), "verify that jsmith@gmail.com is in the table");



    }

    @Test
    public void test2(){

        // how many column we have

        List<WebElement> headers=driver.findElements(By.xpath("//table[@id='table1']//th"));

        System.out.println("Number or column: "+ headers.size());
        
        // print each column name one by one

        for (WebElement header : headers) {

            System.out.println("header.getText() = " + header.getText());
            
        }
    }

    @Test
    public void test3(){

        // number of column
        List<WebElement> headers=driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Number or column: "+ headers.size());

        // number of rows with header
        List<WebElement> rowWithHeader=driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("Number or row with header: "+ rowWithHeader.size());

        // number of rows without header
        List<WebElement> rowWithOutHeader=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("Number or row without header: "+ rowWithOutHeader.size());

    }

    @Test
    public void test4(){

        /* second row
        WebElement secondRow=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));

        System.out.println(secondRow.getText());
        */

        //get all the rows dynamically. we can do in two steps
           //1. get the number or row
           //2. based on number of rows, iterate each row

        List<WebElement> rowWithOutHeader=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));


        for (int i = 1; i <=rowWithOutHeader.size() ; i++) {

            String rowXpath="//table[@id='table1']/tbody/tr[" + i + "]";

            WebElement singleRow=driver.findElement(By.xpath(rowXpath));
            System.out.println(singleRow.getText());

        }

    }


    @Test
    public void test5(){
        List<WebElement> allCellinOneRow=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));

        for (WebElement cell : allCellinOneRow) {
            System.out.println(cell.getText());

        }
    }

    @Test
    public void test6(){

        WebElement singleCell=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[2]"));

        System.out.println(singleCell.getText());

    }

    @Test
    public void printAllCellByIndex(){

        //number of rows
        int rowNumber=getNumberofRows();

        // number or column
        int columnNumber=getNumberofColumns();

        for (int i = 1; i <=rowNumber ; i++) {
            for (int j = 1; j <=columnNumber; j++) {

                //creating dynamic xpath
                String xpath="//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";

                //locating each cell value
                WebElement singleCell=driver.findElement(By.xpath(xpath));

                //getting each value and print it
                System.out.println(singleCell.getText());

            }
        }

    }

    private int getNumberofColumns() {
        List<WebElement> allColumns=driver.findElements(By.xpath("//table[@id='tabel1']//th"));
        return allColumns.size();
    }

    private int getNumberofRows() {

        List<WebElement> allRows=driver.findElements(By.xpath("//table[@id='tabel1']/tbody/tr"));
        return allRows.size();
    }



    //HOMEWORK
//Create a method that accepts row and col number, and returns the cell as a webelement


    @Test
    public void getCellInRelationToAnotherCellInSameRow(){
        String firstname = "Tim";

        // ..  ---> this two dot means go and find parent
        String xpath = "//table[@id='table1']//td[.='"+firstname +"']/../td[3]";
        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());
    }
}
