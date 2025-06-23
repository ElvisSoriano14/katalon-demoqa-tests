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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class CheckboxPage {

	/**
	 * Opens the browser and navigates to the Check Box page.
	 * Maximizes the browser window after opening the URL.
	 *
	 * <div style="background-color:#fff; border:1px solid #ddd; border-radius:10px; padding:12px 16px; width:fit-content; max-width:70%; font-family:monospace; box-shadow:0 2px 5px rgba(0,0,0,0.05);">
	 * <span style="color:#007acc; font-weight:bold;">CheckBoxPage</span>.<span style="color:#2e8b57;">openPage</span><span style="color:#000;">();</span>
	 * </div>
	 *
	 * @author Elvis Soriano
	 */
	def openPage() {
		WebUI.openBrowser(GlobalVariable.baseUrl + "checkbox")
		WebUI.maximizeWindow()
	}

	/**
	 * Clicks the 'Expand All' button to display all checkbox options on the page.
	 *
	 * <div style="background-color:#fff; border:1px solid #ddd; border-radius:10px; padding:12px 16px; width:fit-content; max-width:70%; font-family:monospace; box-shadow:0 2px 5px rgba(0,0,0,0.05);">
	 * <span style="color:#007acc; font-weight:bold;">CheckBoxPage</span>.<span style="color:#2e8b57;">clickExpandAllButton</span><span style="color:#000;">();</span>
	 * </div>
	 *
	 * @author Elvis Soriano
	 */
	def clickExpandAllButton() {
		WebUI.click(findTestObject('CheckBoxPage/btn_ExpandAll'))
	}

	/**
	 * Verifies that all main checkboxes (Desktop, Documents, Downloads) are visible.
	 *
	 * <div style="background-color:#fff; border:1px solid #ddd; border-radius:10px; padding:12px 16px; width:fit-content; max-width:70%; font-family:monospace; box-shadow:0 2px 5px rgba(0,0,0,0.05);">
	 * <span style="color:#007acc; font-weight:bold;">CheckBoxPage</span>.<span style="color:#2e8b57;">areAllCheckboxesVisible</span><span style="color:#000;">();</span>
	 * </div>
	 *
	 * @return true if all checkboxes are visible, false otherwise
	 * @author Elvis Soriano
	 */
	def areAllCheckboxesVisible(){
		return WebUI.verifyElementVisible(findTestObject('CheckBoxPage/checkbox_Desktop')) &&
				WebUI.verifyElementVisible(findTestObject('CheckBoxPage/checkbox_Documents')) &&
				WebUI.verifyElementVisible(findTestObject('CheckBoxPage/checkbox_Downloads'))
	}
}

