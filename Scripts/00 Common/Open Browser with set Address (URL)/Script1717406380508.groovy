import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

'OPEN BROWSER + SET URL'
WebUI.openBrowser(baseurl)

'MAX WIN'
WebUI.maximizeWindow()

'LOGIN PROFIL with ActiveDirectory'
not_run: CustomKeywords.'customKW.LoginSecurityWebBrowser.loginAutoITProfile'(GlobalVariable.SCREEN_MAXSIZE, loginProfile)
