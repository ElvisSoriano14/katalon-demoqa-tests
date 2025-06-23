package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class WebTablesPage {
	
	/**
	 * Opens the browser and navigates to the Web Tables page.
	 * Maximizes the browser window after loading the page.
	 *
	 * <div style="background-color:#fff; border:1px solid #ddd; border-radius:10px; padding:12px 16px; width:fit-content; max-width:70%; font-family:monospace; box-shadow:0 2px 5px rgba(0,0,0,0.05);">
	 * <span style="color:#007acc; font-weight:bold;">WebTablesPage</span>.<span style="color:#2e8b57;">openWebTablesPage</span><span style="color:#000;">();</span>
	 * </div>
	 *
	 * @author Elvis Soriano
	 */
	def openWebTablesPage() {
		WebUI.openBrowser(GlobalVariable.baseUrl + 'webtables')
		WebUI.maximizeWindow()
	}

	/**
	 * Fills out the registration form with predefined data and submits it.
	 * Includes fields like first name, last name, email, age, salary, and department.
	 *
	 * <div style="background-color:#fff; border:1px solid #ddd; border-radius:10px; padding:12px 16px; width:fit-content; max-width:70%; font-family:monospace; box-shadow:0 2px 5px rgba(0,0,0,0.05);">
	 * <span style="color:#007acc; font-weight:bold;">WebTablesPage</span>.<span style="color:#2e8b57;">fillForm</span><span style="color:#000;">();</span>
	 * </div>
	 *
	 * @author Elvis Soriano
	 */
	def fillForm() {
		WebUI.click(findTestObject('WebTablesPage/button_Add_New_Record'))
		boolean isVisble = WebUI.verifyTextPresent('Registration Form', false)

		WebUI.setText(findTestObject('WebTablesPage/input_First_Name'), 'El pepe')
		WebUI.setText(findTestObject('WebTablesPage/input_Last_Name'), 'Torres')
		WebUI.setText(findTestObject('WebTablesPage/input_User_Email'), 'elpepe25@gmail.com')
		WebUI.setText(findTestObject('WebTablesPage/input_User_Age'), '25')
		WebUI.setText(findTestObject('WebTablesPage/input_User_Salary'), '998')
		WebUI.setText(findTestObject('WebTablesPage/input_User_Department'), 'Tecnologia')

		WebUI.click(findTestObject('WebTablesPage/button_Submit'))
	}

	def verifyNameInTheTable() {
		WebUI.verifyTextPresent('El pepe', false, FailureHandling.STOP_ON_FAILURE)
	}
}
