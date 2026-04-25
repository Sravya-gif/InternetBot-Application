package com.srm.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;
import java.util.function.Function;

public class WaitUtil {

    public static WebElement waitForVisibility(WebDriver driver, By locator) {

        org.openqa.selenium.support.ui.FluentWait<WebDriver> wait =
                new org.openqa.selenium.support.ui.FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(ConfigReader.getTimeout()))
                        .pollingEvery(Duration.ofSeconds(1))
                        .ignoring(NoSuchElementException.class);

        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(locator);
                return element.isDisplayed() ? element : null;
            }
        });
    }
}