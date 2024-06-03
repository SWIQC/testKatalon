package customKW

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory

import groovy.json.JsonSlurper
import internal.GlobalVariable

public class BLCommon {

	@Keyword
	def cetak(def msg) {
		KeywordUtil.logInfo("(_dodoLog_) ${msg}")
	}

	@Keyword
	def defaultVar() {
		boolean isSuccess = true
		List<String> messageList = []
		return [ "isSuccess" : isSuccess, "messageList" : messageList ]
	}

	@Keyword
	def customStepReport(def messageList) {
		String rslMessage = ""

		for(int i=0; i < messageList.size(); i++) {
			rslMessage = "${rslMessage} \n${messageList[i]["message"]}"
		}
		return rslMessage
	}

	@Keyword
	def generateStepReport(boolean isSuccess, def messageList) {

		def output = customStepReport(messageList)

		if (isSuccess) {
			KeywordUtil.markPassed("${output} \n..")
		} else {
			KeywordUtil.markFailed("${output} \n..")
		}
	}

	@Keyword
	def toJSONByKey(TestData data,String key=null){
		String []columnNames = data.getColumnNames()
		JsonSlurper slurper = new JsonSlurper()

		Map dataJSON = key == null ? [:] : slurper.parseText('{}')
		for (def index : (1..data.getRowNumbers())){
			dataJSON[key == null ? index-1 : data.getValue(key, index)]=slurper.parseText('{}')
			for (def col : (1..data.getColumnNumbers())) {
				String columnName = columnNames[col-1]
				String cellValue = data.getValue(col,index).trim()
				dataJSON[key == null ? index-1 : data.getValue(key, index)][columnName]=cellValue
			}
		}
		return dataJSON
	}


	boolean waitingElementReadyUse(TestObject obj){
		String currentMethodName = new Object(){}.getClass().getEnclosingMethod().name
		try {

			WebDriver driver = DriverFactory.getWebDriver()

			/* STEP Loading : Handle Loading Process */
			WebDriverWait wait = new WebDriverWait(driver, GlobalVariable.VERIFY_ELEMENT_TIMEOUT)
			String xpath_Obj = obj.findPropertyValue("xpath")
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_Obj)))

			return true
		} catch (Exception e) {

			new customKW.BLCommon().cetak(" $currentMethodName | ERR_Exception $e.message")
			return false
		}
	}


	def delCookies() {

		// Mendapatkan instance WebDriver dari GlobalVariable
		WebDriver driver = DriverFactory.getWebDriver()

		// Menghapus semua cookies
		driver.manage().deleteAllCookies()
		// Mengkonfirmasi penghapusan cookies
		println("Cookies telah dihapus")

		// Menutup browser
		// driver.quit()
	}
}
