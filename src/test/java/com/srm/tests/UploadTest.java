package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.srm.base.BaseTest;
import com.srm.pages.UploadPage;

public class UploadTest extends BaseTest {

    @Test(priority = 1)
    public void testFileUpload_SendKeys() {

        UploadPage up = new UploadPage(driver);
        up.openUploadPage();

        String filePath = "D:\\testfile.txt"; 
        up.uploadFile(filePath);

        String uploadedFile = up.getUploadedFileName();
        System.out.println("Uploaded File (SendKeys): " + uploadedFile);

        Assert.assertTrue(uploadedFile.contains("testfile.txt"));
        System.out.println("testFileUpload_SendKeys Passed");
    }

    @Test(priority = 2)
    public void testUploadWithoutFile_ShouldPass() {

        UploadPage up = new UploadPage(driver);
        up.openUploadPage();
        up.clickUploadButton();
        String uploadedText = "";

        try {
            uploadedText = up.getUploadedFileName();
        } catch (Exception e) {
            uploadedText = "";
        }

        System.out.println("Uploaded text: " + uploadedText);

        Assert.assertTrue(uploadedText.isEmpty(),
                "File should NOT be uploaded when no file is selected");

        System.out.println("testUploadWithoutFile_ShouldPass PASSED");
    }
    
    @Test(priority=3)
    public void testUnsupportedFileUpload() {

        UploadPage up = new UploadPage(driver);
        up.openUploadPage();

        up.uploadFile("D:\\fake.exe");

        String file = up.getUploadedFileName();

        Assert.assertFalse(file.contains("fake.exe"));
        System.out.println("Non existing file so failed");
    }
}