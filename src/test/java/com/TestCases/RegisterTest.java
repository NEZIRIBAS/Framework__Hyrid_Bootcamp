package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Pages.AccountSuccessPage;
import com.Pages.HomePage;
import com.Pages.RegisterPage;
import com.TestBase.TestBase;
import com.TestData.ExcelCode;
import com.Utilities.Util;

public class RegisterTest extends TestBase {
	
	public RegisterTest() throws Exception {
		super();
	}
	
		public WebDriver driver;
		public RegisterPage registerpage;
		public HomePage homepage;
		public AccountSuccessPage accountsuccesspage;
		

		@BeforeMethod
		public void registerSetup() {
		     driver = initalizeBrowserAndOpenApplication(prop.getProperty("browser"));
		    homepage = new HomePage(driver);
		     registerpage = homepage.combiningTwoActionsToNavigateToRegisterPage();
		  
		}

	@Test(priority=1, dataProvider = "getTNExcelRegisterData", dataProviderClass = ExcelCode.class)
	public void verifyRegisterwithMandatoryDetails(String firstname, String lastname, String telephone, String password, String confirmPassword) {
		
	    accountsuccesspage = registerpage.combiningMandatoryDetailsToNavigateToAccountSuccessPage(firstname, lastname, Util.emailWithDateTimeStamp(), telephone, password, confirmPassword);			
		Assert.assertTrue(accountsuccesspage.validateAccountSuccessCreatedMessage());
	
	}

	@Test(priority=2)
	public void verifyRegisterWithAllDetails() {
		
		 accountsuccesspage = registerpage.combiningMandatoryDetailsToNavigateToAccountSuccessPage(dataProp.getProperty("firstname"), dataProp.getProperty("lastname"),
				 Util.emailWithDateTimeStamp(), dataProp.getProperty("telephone"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		Assert.assertTrue(accountsuccesspage.validateAccountSuccessCreatedMessage());
	}

	@Test(priority=3)
	public void verifyRegisterWithExistingEmail() {

		registerpage.combiningMandatoryDetailsToNavigateToAccountSuccessPage(dataProp.getProperty("firstname"), dataProp.getProperty("lastname"),
				prop.getProperty("validEmail"), dataProp.getProperty("telephone"), prop.getProperty("validPassword"), 
				prop.getProperty("validPassword"));
		Assert.assertTrue( registerpage.retrieveDuplicateEmailWarningMessage().contains(registerpage.retrieveDuplicateEmailWarningMessage()));
	}


	@Test(priority=4)
	public void verifyRegisterWithWrongConfirmPassword() {
		
		registerpage.combiningMandatoryDetailsToNavigateToAccountSuccessPage(dataProp.getProperty("firstname"), dataProp.getProperty("lastname"),
				Util.emailWithDateTimeStamp(), dataProp.getProperty("telephone"), prop.getProperty("invalidPassword"), 
				prop.getProperty("validPassword"));	
		Assert.assertTrue( registerpage.retrieveWrongConfirmPasswordWarningMessage().contains(dataProp.getProperty("wrongconfirmPasswordWarning")));
	}

	@Test(priority=5)
	public void verifyRegisterWithNoDetails() {
		
		registerpage.clickOnContinueButton();
		Assert.assertTrue(registerpage.retrieveAllWarningMessages(dataProp.getProperty("privacyPolicyWarning"), dataProp.getProperty("firstNameWarning"), 
				dataProp.getProperty("lastNameWarning"), dataProp.getProperty("invalidEmailWarning"), 
				dataProp.getProperty("telephoneWarning"), dataProp.getProperty("passwordWarning")));
}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
