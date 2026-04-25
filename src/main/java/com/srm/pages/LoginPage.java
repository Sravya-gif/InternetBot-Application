package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.srm.base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By formAuthLink = By.linkText("Form Authentication");
    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.cssSelector("button[type='submit']");
    By successMsg = By.id("flash");
    By logoutBtn = By.linkText("Logout");

    public void navigateToLogin() {
        driver.findElement(formAuthLink).click();
    }

    public void login(String user, String pass) {
        driver.findElement(username).clear();
        driver.findElement(password).clear();
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public String getMessage() {
        waitForElement(successMsg);
        return driver.findElement(successMsg).getText();
    }

    public void logout() {
        driver.findElement(logoutBtn).click();
    }
}