package customKW

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class LoginSecurityWebBrowser {

	// Metode untuk mendapatkan nama paket
	static String getPackageName() {
		Package packageName = LoginSecurityWebBrowser.class.getPackage()
		return packageName != null ? packageName.getName() : ""
	}

	// Metode untuk mendapatkan nama kelas
	static String getClassName() {
		return LoginSecurityWebBrowser.class.getSimpleName()
	}


	/**
	 * type : General Opration (WebUI)
	 * Proses Login menggunakan AutoITFile profile
	 *
	 * @param stepNo : Nomor Step flow proses
	 * @param pathAutoITFile: alamat/path untuk file AutoIT (.exe)
	 * @Return No (Last Step is a write Report)
	 *
	 * another Method : loginAutoITProfileWithNextStep
	 *
	 **/
	@Keyword
	def loginAutoITProfile(boolean maxWindows, String filename) {

		def defaultVar = new customKW.BLCommon().defaultVar();
		String tcTitle = "LOGIN WITH AutoIT Profile"
		defaultVar["messageList"] << ["message" : "TestCase : ${tcTitle}"]


		String packageName = getPackageName()
		String className = getClassName()

		String currentMethodName = new Object(){}.getClass().getEnclosingMethod().name
		defaultVar["messageList"] << ["message" : "MethodName : $currentMethodName "]

		String userDirectory = System.getProperty('user.dir')
		String filePath = userDirectory + '/Data Files/OtherFiles/LoginProfile/'+filename

		try {
			/* Running AutoIT flow*/
			Process process = Runtime.getRuntime().exec(filePath);
			process.waitFor();

			if(maxWindows) {
				WebUI.maximizeWindow()
			}

			// defaultVar["messageList"] << ["message" : "LOGIN User : OK "]
		} catch (Exception e) {

			new customKW.BLCommon().cetak(" PackageName:[$packageName] | $className | Method:[$currentMethodName]")
			new customKW.BLCommon().cetak("__> Msg : _Err_Exception ${e.message}")
		}
	}
}


