package com.Checkout;
	import org.openqa.selenium.WebDriver;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;


	public class CheckOutPageTest extends TestBase {

		public WebDriver driver;
		public HomePage homepage;
		public addToCartPage addtocartpage;
		public cartPage cartpage;
		public returningCustomerPage returningcustomerpage;
		public returningCustomerAfterLoginPage returningcustomerafterloginPage;
		public backToHomePage backtohomePage;

		public CheckOutPageTest() throws Exception {
			super();
		}


		@BeforeMethod
		public void setup() {
			driver = initalizeBrowserAndOpenApplication(prop.getProperty("browser"));
			homepage = new HomePage(driver);
		}
		
		@Test(priority=1)
		public void verifyCorrectProductBeignPurchased() {
			homepage.ClickOnLaptopNotebook();
			addtocartpage = new addToCartPage(driver);
			addtocartpage.ClickOnAddToCart();
			cartpage = new cartPage(driver);
			cartpage.clickOnCheckOutButton();
			returningcustomerpage = new returningCustomerPage(driver);
			returningcustomerpage.clickOnreturningCustomerlogin(prop.getProperty("email"), prop.getProperty("password"));
			
			returningcustomerafterloginPage = new returningCustomerAfterLoginPage(driver);
			returningcustomerafterloginPage.KeepClickOnContinueButton();
			backtohomePage = new backToHomePage(driver);
			backtohomePage.clickOnContinueButton();
			
		}

	}

