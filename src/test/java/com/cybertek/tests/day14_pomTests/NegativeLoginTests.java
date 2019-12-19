package com.cybertek.tests.day14_pomTests;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTests extends TestBase {

    @Test
    public void wrongPasswordTest(){


        LoginPage loginPage=new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("somewrong");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");
    }


    @Test
    public void wrongUsernameTest(){


        LoginPage loginPage=new LoginPage();

        loginPage.usernameInput.sendKeys("user1wrong");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");
    }


}
