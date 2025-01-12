package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
public WebDriver driver;
	
	@FindBy (id = "input-firstname")
	private WebElement firstnameTextBox;
	
	@FindBy (id = "input-lastname")
	private WebElement lastnameTextBox;
	
	@FindBy (id = "input-email")
	private WebElement emailTextBox;
	
	@FindBy (id = "input-telephone")
	private WebElement telephoneTextBox;
	
	@FindBy (id = "input-password")
	private WebElement passwordTextBox;
	
	@FindBy (id= "input-confirm")
	private WebElement confirmPasswordTextBox;
	
	@FindBy (xpath= "//input[@name='newsletter' and @value='1']")
	private WebElement subcribeNewsLetterYesRadioButton;
	
	@FindBy (css= "a.agree+input")
	private WebElement PrivacyPolicyCheckBox;
	
	@FindBy (css= "input.btn.btn-primary")
	private WebElement ContinueButton;
	
	@FindBy (xpath= "//div[contains(@class, 'alert-dismissible')]")
	private WebElement privacyPolicyWarningMessage;
	
	@FindBy (css= "input#input-firstname+div")
	private WebElement firstnameWarningMessage;
	
	@FindBy (css= "input#input-lastname+div")
	private WebElement lastnameWarningMessage;
	
	@FindBy (css= "input#input-email+div")
	private WebElement emailWarningMessage;
	
	@FindBy (css= "input#input-telephone+div")
	private WebElement telephoneWarningMessage;
	
	@FindBy (css = "input#input-password+div")
	private WebElement passwordWarningMessage;
	
	@FindBy (css = "input#input-confirm+div")
	private WebElement wrongConfirmPasswordWarningMessage;
	
	
	@FindBy (xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement duplicateEmailWarningMessage;

	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
		public void enterFirstName(String firstnameText) {
			firstnameTextBox.sendKeys(firstnameText);
			
		}
		public void enterLastName(String lastnameText) {
			lastnameTextBox.sendKeys(lastnameText);
		}
			
			
		public void enterEmail(String emailText) {
			emailTextBox.sendKeys(emailText);
		}
			
		
		public void enterTelephone(String telephoneText) {
			telephoneTextBox.sendKeys(telephoneText);
		}
			
		public void enterPassword(String passwordText) {
			passwordTextBox.sendKeys(passwordText);
		}
		
		public void enterConfirmPassword(String confirmpasswordText) {
			confirmPasswordTextBox.sendKeys(confirmpasswordText);
		}		
		
		public void clickOnNewsLetterRadioButton() {
			subcribeNewsLetterYesRadioButton.click();
	
		}
		
		public void checkPrivacyPolicyCheckBox() {
			PrivacyPolicyCheckBox.click();
		}
		
		public void clickOnContinueButton() {
			ContinueButton.click();
		}
		
		public String retrievePrivacyPolicyWarningMessage() {
			String text = privacyPolicyWarningMessage.getText();
			return text;
		}
		
		public String retrieveFirstnameWarningMessage() {
			String text = firstnameWarningMessage.getText();
			return text;	
		}
		public String retrieveLastnameWarningMessage() {
			String text = lastnameWarningMessage.getText();
			return text;	
		}
		
		public String retrieveEmailnameWarningMessage() {
			String text = emailWarningMessage.getText();
			return text;	
		}
		
		public String retrieveDuplicateEmailWarningMessage() {
			String text = duplicateEmailWarningMessage.getText();
			return text;	
		}
		
		public String retrieveTelephoneWarningMessage() {
			String text = telephoneWarningMessage.getText();
			return text;	
		}
		
		public String retrievePasswordWarningMessage() {
			String text = passwordWarningMessage.getText();
			return text;
		
		}
		
		public String retrieveWrongConfirmPasswordWarningMessage() {
			String text = wrongConfirmPasswordWarningMessage.getText();
			return text;
		}
		
		public AccountSuccessPage combiningMandatoryDetailsToNavigateToAccountSuccessPage(String firstnameText, 
				String lastnameText, String emailText, String telephoneText, String passwordText, String confirmpasswordText) {
			
			firstnameTextBox.sendKeys(firstnameText);
			lastnameTextBox.sendKeys(lastnameText);
			emailTextBox.sendKeys(emailText);
			telephoneTextBox.sendKeys(telephoneText);
			passwordTextBox.sendKeys(passwordText);
			confirmPasswordTextBox.sendKeys(confirmpasswordText);
			PrivacyPolicyCheckBox.click();
			ContinueButton.click();
			return new AccountSuccessPage(driver);
		}
		
		public AccountSuccessPage combiningAllDetailsToNavigateToAccountSuccessPage(String firstnameText, 
				String lastnameText, String emailText, String telephoneText, String passwordText, String confirmpasswordText) {
			
			firstnameTextBox.sendKeys(firstnameText);
			lastnameTextBox.sendKeys(lastnameText);
			emailTextBox.sendKeys(emailText);
			telephoneTextBox.sendKeys(telephoneText);
			passwordTextBox.sendKeys(passwordText);
			confirmPasswordTextBox.sendKeys(confirmpasswordText);
			subcribeNewsLetterYesRadioButton.click();
			PrivacyPolicyCheckBox.click();
			ContinueButton.click();
			return new AccountSuccessPage(driver);
		}
		
		public boolean retrieveAllWarningMessages(String expectedPrivacyPolicyWarning, String expectedFirstNameWarning, 
				String expectedLastNameWarning, String expectedEmailWarning, String expectedTelephoneWarning, String expectedPasswordWarning) {
			
			boolean privacyPolicyWarningStatus = privacyPolicyWarningMessage.getText().contains(expectedPrivacyPolicyWarning);
			boolean firstNameWarningStatus = firstnameWarningMessage.getText().contains(expectedFirstNameWarning);
			boolean lastNameWarningStatus = lastnameWarningMessage.getText().contains(expectedLastNameWarning);
			boolean emailWarningStatus = emailWarningMessage.getText().contains(expectedEmailWarning);
			boolean telephoneWarningStatus = telephoneWarningMessage.getText().contains(expectedTelephoneWarning);
			boolean passwordWarningStatus = firstnameWarningMessage.getText().contains(expectedPasswordWarning);
			
			return privacyPolicyWarningStatus  && firstNameWarningStatus &&  lastNameWarningStatus && emailWarningStatus &&  telephoneWarningStatus && passwordWarningStatus;
			
	}
}
