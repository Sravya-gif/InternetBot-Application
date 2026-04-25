package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.srm.base.BasePage;

public class DynamicPage extends BasePage {

    public DynamicPage(WebDriver driver) {
        super(driver);
    }

    By dynamicLink = By.linkText("Dynamic Loading");
    By example1 = By.linkText("Example 1: Element on page that is hidden");
    By startBtn = By.xpath("//button[text()='Start']");
    By finishText = By.id("finish");

    public void openDynamicPage() {
        driver.findElement(dynamicLink).click();
        driver.findElement(example1).click();
    }

    public void clickStart() {
        driver.findElement(startBtn).click();
    }

    public String getText() {
        waitForElement(finishText);
        return driver.findElement(finishText).getText();
    }
}