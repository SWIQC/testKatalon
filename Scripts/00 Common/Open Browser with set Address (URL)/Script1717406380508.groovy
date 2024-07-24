import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

// Open Browser and navigate to BASEURL
WebUI.openBrowser(GlobalVariable.BASEURL);
WebUI.maximizeWindow();
WebUI.delay(3);

// Click on Eagle Score Menu
WebUI.click(findTestObject('Object Repository/Page_LIPS.OTO/eagleScoreMenu'));

// Set text fields
WebUI.selectOptionByValue(findTestObject('Object Repository/Page_LIPS.OTO/companyNameField'), companyName);
WebUI.delay(2);
WebUI.selectOptionByValue(findTestObject('Object Repository/Page_LIPS.OTO/productTypeField'), productType);
WebUI.delay(3);
WebUI.sendKeys(findTestObject('Object Repository/Page_LIPS.OTO/ktpField'), ktp);
WebUI.sendKeys(findTestObject('Object Repository/Page_LIPS.OTO/nameField'), name);
WebUI.sendKeys(findTestObject('Object Repository/Page_LIPS.OTO/birthDateField'), birthDate);

// Click Submit Button
WebUI.click(findTestObject('Object Repository/Page_LIPS.OTO/submitBtn'));


//=======================DEBUGGING=========================

//// Number of retries allowed
//int maxRetries = 3;
//int retryCount = 0;
//boolean retry = true;
//
//while (retry && retryCount < maxRetries) {
//    try {
//        // Open Browser and navigate to BASEURL
//        WebUI.openBrowser(GlobalVariable.BASEURL);
//        WebUI.maximizeWindow();
//        WebUI.delay(3);
//
//        // Click on Eagle Score Menu
//        WebUI.click(findTestObject('Object Repository/Page_LIPS.OTO/eagleScoreMenu'));
//
//        // Set text fields
//        WebUI.setText(findTestObject('Object Repository/Page_LIPS.OTO/companyNameField'), companyName);
//        WebUI.setText(findTestObject('Object Repository/Page_LIPS.OTO/productTypeField'), productType);
//        WebUI.setText(findTestObject('Object Repository/Page_LIPS.OTO/ktpField'), ktp);
//        WebUI.setText(findTestObject('Object Repository/Page_LIPS.OTO/nameField'), name);
//        WebUI.setText(findTestObject('Object Repository/Page_LIPS.OTO/birthDateField'), birthDate);
//
//        // Click Submit Button
//        WebUI.click(findTestObject('Object Repository/Page_LIPS.OTO/submitBtn'));
//	
//		// failed condition
//        if (WebUI.verifyTextPresent("Criteria not match", false, FailureHandling.OPTIONAL)) {
//            WebUI.takeScreenshot();
//        } else if (WebUI.verifyTextPresent("Customer Info not Available", false, FailureHandling.OPTIONAL)) {
//            WebUI.takeScreenshot();
//        } else {
//            //success
//            WebUI.takeScreenshot();
//        }
//
//        // If there is no error , exit retry loop
//        retry = false;
//
//    } catch (StepFailedException e) {
//        retryCount++;
//        if (retryCount >= maxRetries) {
//            WebUI.takeScreenshot();
//        } else {
//            WebUI.comment("Attempt " + retryCount + " failed. Retrying...");
//        }
//    } finally {
//        // Close browser after each attempt (optional)
//        WebUI.closeBrowser();
//    }
//}