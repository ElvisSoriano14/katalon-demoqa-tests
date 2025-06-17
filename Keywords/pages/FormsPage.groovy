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
import com.kms.katalon.core.testobject.ObjectRepository as OR


import internal.GlobalVariable

public class FormsPage {

	/**
	 * Opens the browser and navigates to the automation practice form.
	 * Maximizes the browser window after loading the page.
	 *
	 * 	<div style="background-color:#fff; border:1px solid #ddd; border-radius:10px; padding:12px 16px; width:fit-content; max-width:70%; font-family:monospace; box-shadow:0 2px 5px rgba(0,0,0,0.05);">
	 <span style="color:#007acc; font-weight:bold;">FormsPage</span>.<span style="color:#2e8b57;">openBrowser</span><span style="color:#000;">();</span>
	 </div>
	 *
	 * @author Elvis Soriano
	 */
	def openBrowser() {
		WebUI.openBrowser("${GlobalVariable.baseUrl}automation-practice-form")
		WebUI.maximizeWindow()
	}


	/**
	 * Fills out the form with the provided information.
	 * Sets text values for all required fields and selects gender and hobby options.
	 *
	 * 	<div style="background-color:#fff; border:1px solid #ddd; border-radius:10px; padding:12px 16px; width:fit-content; max-width:70%; font-family:monospace; box-shadow:0 2px 5px rgba(0,0,0,0.05);">
	 <span style="color:#007acc; font-weight:bold;">FormsPage</span>.<span style="color:#2e8b57; height:80px;">fillForm</span><span style="color:#000;">);</span>
	 <span style="color:#444;">"John",</span>
	 <span style="color:#444;">"Doe",</span> 
	 <span style="color:#444;">"john.doe@email.com",</span> 
	 <span style="color:#444;">"1234567890",</span> 
	 <span style="color:#444;">"Math",</span> 
	 <span style="color:#444;">"123 Main St",</span>
	 <span style="color:#000;">);</span>
	 </div>
	 *
	 * @param firstName First name of the user
	 * @param lastName Last name of the user
	 * @param email User's email address
	 * @param mobile User's mobile number
	 * @param subject Subject to be selected
	 * @param address Address of the user
	 *
	 * @author Elvis Soriano
	 */
	def fillForm(String firstName, String lastName, String email, String mobile, String subject, String address ) {
		WebUI.setText(OR.findTestObject('FormsPage/input_FirstName'), firstName)
		WebUI.setText(OR.findTestObject('FormsPage/input_LastName'), lastName)
		WebUI.setText(OR.findTestObject('FormsPage/input_UserEmail'), email)
		WebUI.click(OR.findTestObject('FormsPage/radio_GenderMale'))
		WebUI.setText(OR.findTestObject('FormsPage/input_Mobile'), mobile)
		WebUI.setText(OR.findTestObject('FormsPage/input_subjects'), subject)
		WebUI.scrollToElement(OR.findTestObject('FormsPage/textarea_Address'), 50)
		WebUI.click(OR.findTestObject('FormsPage/checkbox_HobbySports'))
		WebUI.setText(OR.findTestObject('FormsPage/textarea_Address'), address)
	}

	/**
	 * Submits the completed form by clicking the submit button.
	 *
	 * 	<div style="background-color:#fff; border:1px solid #ddd; border-radius:10px; padding:12px 16px; width:fit-content; max-width:70%; font-family:monospace; box-shadow:0 2px 5px rgba(0,0,0,0.05);">
	 <span style="color:#007acc; font-weight:bold;">FormsPage</span><span style="color:#000;">.</span><span style="color:#2e8b57;">submitForm</span><span style="color:#000;">();</span>
	 </div>
	 *
	 * @author Elvis Soriano
	 */
	def submitForm() {
		WebUI.click(OR.findTestObject('FormsPage/btn_Submit'))
	}

	/**
	 * Verifies that the form was submitted successfully by checking for the confirmation message.
	 *
	 * 	<div style="background-color:#fff; border:1px solid #ddd; border-radius:10px; padding:12px 16px; width:fit-content; max-width:70%; font-family:monospace; box-shadow:0 2px 5px rgba(0,0,0,0.05);">
	 <span style="color:#007acc; font-weight:bold;">FormsPage</span><span style="color:#000;">.</span><span style="color:#2e8b57;">VerifySubmission</span><span style="color:#000;">();</span>
	 </div>
	 *
	 * @author Elvis Soriano
	 */
	def VerifySubmission() {
		WebUI.verifyTextPresent('Thanks for submitting the form', false)
	}


	/**
	 * Submits the form without filling any fields to trigger validation messages.
	 *
	 * 	<div style="background-color:#fff; border:1px solid #ddd; border-radius:10px; padding:12px 16px; width:fit-content; max-width:70%; font-family:monospace; box-shadow:0 2px 5px rgba(0,0,0,0.05);">
	 <span style="color:#007acc; font-weight:bold;">FormsPage</span><span style="color:#000;">.</span><span style="color:#2e8b57;">submitEmptyForm</span><span style="color:#000;">();</span>
	 </div>
	 *
	 * @author Elvis Soriano
	 */
	def submitEmptyForm() {
		WebUI.scrollToElement(OR.findTestObject('FormsPage/btn_Submit'), 50)
		WebUI.click(findTestObject('FormsPage/btn_Submit'))
	}


	/**
	 * Checks whether the First Name field is marked as required by inspecting the CSS class.
	 *
	 * 	<div style="background-color:#fff; border:1px solid #ddd; border-radius:10px; padding:12px 16px; width:fit-content; max-width:70%; font-family:monospace; box-shadow:0 2px 5px rgba(0,0,0,0.05);">
	 <span style="color:#007acc; font-weight:bold;">FormsPage</span><span style="color:#000;">.</span><span style="color:#2e8b57;">isFirstNameRequired</span><span style="color:#000;">();</span>
	 </div>
	 *
	 * @return boolean - true if the field shows a validation error, false otherwise.
	 * @author Elvis Soriano
	 */
	def isFirstNameRequired() {
		return WebUI.getAttribute(findTestObject('FormsPage/input_FirstName'), 'class').contains('field-error')
	}
}
