package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.srm.base.BaseTest;
import com.srm.pages.AlertPage;

public class AlertTest extends BaseTest {

    @Test
    public void testAllAlerts() {

        AlertPage ap = new AlertPage(driver);
        ap.openAlertPage();
        ap.clickJSAlert();
        String alertResult = ap.getResultText();
        System.out.println("Alert Result: " + alertResult);
        Assert.assertTrue(alertResult.contains("You successfully clicked an alert"));

        ap.clickJSConfirmDismiss();
        String confirmResult = ap.getResultText();
        System.out.println("Confirm Result: " + confirmResult);
        Assert.assertTrue(confirmResult.contains("Cancel"));

        ap.clickJSPrompt("Hello");
        String promptResult = ap.getResultText();
        System.out.println("Prompt Result: " + promptResult);
        Assert.assertTrue(promptResult.contains("Hello"));

        Assert.assertNotEquals(alertResult, confirmResult,
                "Result text did not change after alert interaction");

        Assert.assertNotEquals(confirmResult, promptResult,
                "Result text did not update after prompt interaction");

        System.out.println("TestAllAlerts Passed");
    }
}