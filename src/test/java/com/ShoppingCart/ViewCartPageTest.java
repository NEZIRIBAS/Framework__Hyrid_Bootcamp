package com.ShoppingCart;

	import org.openqa.selenium.WebDriver;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class ViewCartPageTest extends TestBase{
		public WebDriver driver;
		public HomePage homepage;
		public ProductSelectPage productSelectPage;

		public ViewCartPageTest() throws Exception {
			super();
		}


		@BeforeMethod
		public void setup() {
		driver = initalizeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
		}
		@Test(priority=1)
		public void verifyProductIsAddedToTheCart(){
			homepage.ClickOnLaptopNotebook();
			productSelectPage = new ProductSelectPage(driver);
			productSelectPage.ShoppingCart();

		}

	}

