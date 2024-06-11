package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	public WebDriver driver;
	
	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;
	
	@FindBy (linkText = "HP LP3065")
	private WebElement validProduct;
	
	@FindBy(xpath = "//*[@id=\\\"content\\\"]/div[4]/div[1]/div/div[1]/a/img\")")
	private WebElement ProductImagine;
	
	@FindBy (xpath= "\"//input[@id='input-option225']\')]")
	private WebElement selectToDeliveryDate;
	
	@FindBy (xpath= "//input[@name='quantity')]")
	private WebElement selectToquantity;
	
	@FindBy (xpath= "//button[@id='button-cart']")
	private WebElement AddToCartButton;

	@FindBy (xpath = "//div[class='alert.alert-success.alert-dismissible')]")
	private WebElement AddedSuccesMessage;
	
	
	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
		
	public void SelectToDeliveryDate(String DeliveryDateText) {
		selectToDeliveryDate.sendKeys(DeliveryDateText);
	}
		
	public void AddToQuantity(String QuantityText) {
		selectToquantity.sendKeys(QuantityText);
	}
	public void ClickOnAddToCart() {
		AddToCartButton.click();
		
	}
	public void SearchButton(String searchButtonText) {
		searchButton.click();
	}
	
	public void validProduct(String validProductText) {
		validProduct.sendKeys("HP LP3065");
	}
	
	public void ProductImagine(String productImagineText) {
	ProductImagine.click();
		
	}
	
	public AccountPage navigateToAddToCartPageByCombining3Actions(String searchButtonText, String  validProductText, String  productImagineText) {
		searchButton.click();
		validProduct.sendKeys("HP LP3065");
		ProductImagine.click();
		return new AccountPage(driver);
	}
}

