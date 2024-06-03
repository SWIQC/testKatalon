package customKW

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class LoadingHandler {

	// Metode untuk mendapatkan nama paket
	static String getPackageName() {
		Package packageName = LoadingHandler.class.getPackage()
		return packageName != null ? packageName.getName() : ""
	}

	// Metode untuk mendapatkan nama kelas
	static String getClassName() {
		return LoadingHandler.class.getSimpleName()
	}

	boolean isLoadingHandler(TestObject Obj){
		String currentMethodName = new Object(){}.getClass().getEnclosingMethod().name
		try {

			WebDriver driver = DriverFactory.getWebDriver()

			/* STEP Loading : Handle Loading Process */
			WebDriverWait wait = new WebDriverWait(driver, 1)
			String xpathObj = Obj.findPropertyValue("xpath")

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathObj)))

			return true
		} catch (Exception e) {

			GlobalVariable.OBJTrying++
			if (GlobalVariable.OBJTrying == GlobalVariable.VERIFY_ELEMENT_TIMEOUT) {

				new customKW.BLCommon().cetak(" PackageName:[${getPackageName()}] | ${getClassName()} | Method:[$currentMethodName]")
				return false
			} else {

				isLoadingHandler(Obj)
			}
		}
	}
}
