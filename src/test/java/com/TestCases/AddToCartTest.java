package com.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.TestBase.TestBase;


public class AddToCartTest extends TestBase{
	
	public AddToCartTest() throws Exception {
		super ();
	} 
	
	public WebDriver driver;
	
	
	@Test 
	public void AddToCartValidProduct() {
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://tutorialsninja.com/demo/index.php?route=product/category&path=18");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[1]/div/div[1]/a/img")).click();
		driver.findElement(By.xpath("//input[@id='input-option225']")).sendKeys("2011-04-22");
 		driver.findElement(By.xpath("//input[@name='quantity']")).click();
 		driver.findElement(By.name("quantity")).clear();
 		driver.findElement(By.name("quantity")).sendKeys("2");
 		driver.findElement(By.xpath("//button[@id='button-cart']")).click();
 		driver.findElement(By.cssSelector("input#input-success+div")).getText();
 		Assert.assertTrue(driver.findElement(By.linkText("Success: You have added")).isDisplayed());
 		
	}
}
	