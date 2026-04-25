package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.srm.base.BaseTest;
import com.srm.pages.LoginPage;

public class Logintest extends BaseTest {

    @Test(dataProvider = "loginData")
    public void loginTest(String user, String pass, boolean isValid) {

        LoginPage lp = new LoginPage(driver);
        lp.navigateToLogin();
        lp.login(user, pass);
        String msg = lp.getMessage();

        if (isValid) {
            Assert.assertTrue(msg.contains("You logged into a secure area!"));
            lp.logout();
            System.out.println("Login message: " + msg);
           
        } else {
            Assert.assertTrue(msg.contains("Your username is invalid!"));
            System.out.println("Login message: " + msg);
           
        }
    }
    
    @Test
    public void testLoginWithEmptyCredentials() {

        LoginPage lp = new LoginPage(driver);
        lp.navigateToLogin();
        lp.login("", "");
        String message = lp.getMessage();

        System.out.println("Login message: " + message);

        Assert.assertTrue(message.contains("Your username is invalid!"),
                "Error message not displayed for empty credentials");
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][] {
                {"tomsmith", "SuperSecretPassword!", true},
                {"wrong", "wrong", false}
        };
    }
}