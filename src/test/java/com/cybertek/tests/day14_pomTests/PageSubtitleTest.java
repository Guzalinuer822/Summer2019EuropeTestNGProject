package com.cybertek.tests.day14_pomTests;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /*
    open browser
    login as a driver
    verify that page subtitle is Quick Launchpad
    go to Activities  ---> Calendar Events
    verify that page subtitle is Calendar Events



     */

    @Test
    public void verifySubtitleTest(){

        LoginPage loginPage=new LoginPage();

        String username= ConfigurationReader.get("driver_username");
        String password=ConfigurationReader.get("driver_password");

        loginPage.login(username,password);

        DashboardPage dashboardPage=new DashboardPage();

        Assert.assertEquals(dashboardPage.getPageSubTitle(),"Quick Launchpad"," verify that page subtitle is quick Launchpad");

        dashboardPage.navigateToModule("Activities","Calendar Events");

   // another example:     dashboardPage.navigateToModule("Customers","Accounts");



        // we can do in this way
     //   Assert.assertEquals(dashboardPage.getPageSubTitle(),"Calendar Events"," verify that page subtitle is Calendar Events");


        // but proper way is :

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        Assert.assertEquals(calendarEventsPage.pageSubTitle,"Calendar Events"," verify that page subtitle is Calendar Events");

    }
}
