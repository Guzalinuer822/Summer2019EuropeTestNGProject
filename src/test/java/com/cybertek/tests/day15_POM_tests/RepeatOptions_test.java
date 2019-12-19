package com.cybertek.tests.day15_POM_tests;


import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/*
VERIFY RADIO BUTTONS
Open browser
Login as driver
Go to Activities->Calendar Events
Click on create calendar events
Click on repeat
Verfiy that repeat every days is checked
verify that repeat weekday is not checked
 */
public class RepeatOptions_test extends TestBase {

    // first have to extends from Testbase----inside have before and after method

    @Test
    public void RepeatRadioButtonTest(){

        //Login as driver

        LoginPage loginPage=new LoginPage();

        String username= ConfigurationReader.get("driver_username");
        String password= ConfigurationReader.get("driver_password");
        loginPage.login(username,password);


        //Go to Activities->Calendar Events

        DashboardPage dashboardPage=new DashboardPage();
            // this dashboard page is about common navigation bar
            // it is cooming from base page , so Dashboard class extends from Basepage class
           // so we are creating object from Dashboard class

        dashboardPage.navigateToModule("Activities","Calendar Events");

        //Click on create calendar events
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        BrowserUtils.waitFor(3);
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        calendarEventsPage.createCalendarEvent.click();

          //wait again
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        //Click on repeat
        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();
        BrowserUtils.waitFor(3);

        //Verify that repeat every days is checked
        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"Verify that repeat every days is checked");

        //verify that repeat weekday is not checked
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"verify that repeat weekday is not checked");
    }


      /*
    VERIFY REPEAT OPTIONS
        Open browser
        Login as driver
        Go to Activities->Calendar
        Click on create calendar events
        Click on repeat
        Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
     */



    @Test
    public void verifyRepeateOptions(){


        //Login as driver

        LoginPage loginPage=new LoginPage();

        String username= ConfigurationReader.get("driver_username");
        String password= ConfigurationReader.get("driver_password");
        loginPage.login(username,password);


        //Go to Activities->Calendar Events


           // this dashboard page is about common navigation bar
           // it is cooming from base page , so Dashboard class extends from Basepage class
           // so we are creating object from Dashboard class

        new DashboardPage().navigateToModule("Activities","Calendar Events");

        //Click on create calendar events
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        BrowserUtils.waitFor(3);
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        calendarEventsPage.createCalendarEvent.click();

        //wait again
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        //Click on repeat
        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();
        BrowserUtils.waitFor(3);


        //Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
        List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");
        List<WebElement> actualOptions = createCalendarEventsPage.repeatOptionsList().getOptions();

        //get text of each webelement and return as a list of String
        List<String> actualList = BrowserUtils.getElementsText(actualOptions);

//        List<String> actualList = new ArrayList<>();
//
//        for (WebElement option : actualOptions) {
//            //get each weblement text inside the dropdown and add to actual list
//            actualList.add(option.getText());
//        }


        //compare actual and expected list
        Assert.assertEquals(actualList,expectedList,"Compare dropdown values");
        //Assert.assertEquals(actualOptions,expectedList);




    }
}
