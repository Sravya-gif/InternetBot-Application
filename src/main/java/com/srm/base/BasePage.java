package com.srm.base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.srm.utils.WaitUtil;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElement(org.openqa.selenium.By locator) {
        WaitUtil.waitForVisibility(driver, locator);
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void enterAlertText(String text) {
        driver.switchTo().alert().sendKeys(text);
    }
}