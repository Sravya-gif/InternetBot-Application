package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.DynamicPage;

public class DynamicTest extends BaseTest {

    @Test
    public void testDynamicLoading() {

        DynamicPage dp = new DynamicPage(driver);
        dp.openDynamicPage();
        dp.clickStart();

        String text = dp.getText();

        Assert.assertEquals(text, "Hello World!");
        System.out.println("Dynamic test passed");
    }
}