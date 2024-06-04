import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser(GlobalVariable.OTOSUR_URL)

WebUI.maximizeWindow()

//Dashboard
if(WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboard/Side-Menu/Dashboard/LIPS-Logo_img'), 5, FailureHandling.CONTINUE_ON_FAILURE)) {
	WebUI.takeScreenshot(GlobalVariable.folderPath + 'Dashboard.jpg')
}

//Search Pefindo
WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboard/Side-Menu/LIPS/LIPS_lbl'), 5)

WebUI.click(findTestObject('Object Repository/Dashboard/Side-Menu/LIPS/Search-Cust-Data_lbl'))

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboard/Side-Menu/LIPS/Search-Pefindo_header'), 5, FailureHandling.CONTINUE_ON_FAILURE)) {
	WebUI.takeScreenshot(GlobalVariable.folderPath + 'Search_Pefindo.jpg')
}

//Eagle Score
WebUI.click(findTestObject('Object Repository/Dashboard/Side-Menu/LIPS/Eagle-Score_lbl'))

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboard/Side-Menu/LIPS/Eagle Score_header'), 5, FailureHandling.CONTINUE_ON_FAILURE)) {
	WebUI.takeScreenshot(GlobalVariable.folderPath + 'Eagle_Score.jpg')

}

//Upload Bulk
WebUI.click(findTestObject('Object Repository/Dashboard/Side-Menu/LIPS/Upload-Inquiry_lbl'))

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboard/Side-Menu/LIPS/Upload-Bulk_header'), 5, FailureHandling.CONTINUE_ON_FAILURE)) {
	WebUI.takeScreenshot(GlobalVariable.folderPath + 'Upload_Bulk_Header.jpg')
}

//Module List
WebUI.doubleClick(findTestObject('Object Repository/Dashboard/Side-Menu/User-Management/User-Management_lbl'))

WebUI.click(findTestObject('Object Repository/Dashboard/Side-Menu/User-Management/Module_lbl'))

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboard/Side-Menu/User-Management/Modul-List_header'), 5, FailureHandling.CONTINUE_ON_FAILURE)) {
	WebUI.takeScreenshot(GlobalVariable.folderPath + 'Module_List.jpg')
}

//Role List
WebUI.click(findTestObject('Object Repository/Dashboard/Side-Menu/User-Management/Roles_lbl'))

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboard/Side-Menu/User-Management/Role-List_header'), 5, FailureHandling.CONTINUE_ON_FAILURE)) {
	WebUI.takeScreenshot(GlobalVariable.folderPath + 'Role_List.jpg')
}

//User Module LIst
WebUI.click(findTestObject('Object Repository/Dashboard/Side-Menu/User-Management/User-Module_lbl'))

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboard/Side-Menu/User-Management/User-Module-List_header'), 5, FailureHandling.CONTINUE_ON_FAILURE)) {
	WebUI.takeScreenshot(GlobalVariable.folderPath + 'User_Module_List.jpg')
}

//Menu Settings
WebUI.click(findTestObject('Object Repository/Dashboard/Side-Menu/User-Management/Menu_lbl'))

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboard/Side-Menu/User-Management/Menu-Settings_header'), 5, FailureHandling.CONTINUE_ON_FAILURE)) {
	WebUI.takeScreenshot(GlobalVariable.folderPath + 'Menu_Settings.jpg')
}

//List API Report List
WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboard/Side-Menu/Reports/Reports_lbl'), 5)

WebUI.click(findTestObject('Object Repository/Dashboard/Side-Menu/Reports/Logs_lbl'))

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboard/Side-Menu/Reports/List-API-Report-Logs_header'), 5, FailureHandling.CONTINUE_ON_FAILURE)) {
	WebUI.takeScreenshot(GlobalVariable.folderPath + 'List_API_Report_Logs.jpg')
}

//Eagle Score History
WebUI.click(findTestObject('Object Repository/Dashboard/Side-Menu/Reports/Eagle-Score-History_lbl'))

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboard/Side-Menu/Reports/Eagle-Score-History_header'), 5, FailureHandling.CONTINUE_ON_FAILURE)) {
	WebUI.takeScreenshot(GlobalVariable.folderPath + 'Eagle_Score_History.jpg')
}

//Change Seting Parameter
WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboard/Side-Menu/Setting/Setting_lbl'), 5)

WebUI.click(findTestObject('Object Repository/Dashboard/Side-Menu/Setting/Parameter_lbl'))

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboard/Side-Menu/Setting/Parameter_header'), 5, FailureHandling.CONTINUE_ON_FAILURE)) {
	WebUI.takeScreenshot(GlobalVariable.folderPath + 'Change_Setting_Parameter.jpg')
}

WebUI.closeBrowser()
