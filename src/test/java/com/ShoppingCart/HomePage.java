package com.ShoppingCart;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class HomePage {

		public WebDriver driver;

		@FindBy(xpath = "//a[text()='Laptops & Notebooks']")
		private WebElement MenuLaptopsNotebooks;

		@FindBy(xpath = "//a[text()='Show AllLaptops & Notebooks']")
		private WebElement ShowAllLaptopsNotebooks;

		@FindBy(xpath = "//div[@class='button-group']/button[1]")
		private WebElement ProductPage_button_cart;


		public HomePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		//Actions to call these Object in the form of methods

		public ProductSelectPage ClickOnLaptopNotebook() {
			MenuLaptopsNotebooks.click();
			ShowAllLaptopsNotebooks.click();
			ProductPage_button_cart.click();
			return new ProductSelectPage(driver);
		}


	}

