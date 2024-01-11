package com.SelenumFrameWorkEasyPart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FillOutLoginForm {
	public WebDriver driver;
	
	@BeforeMethod
	public void SwayLabLogin() {
	
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(100));
	driver.get("https://www.saucedemo.com/");
	
	}
	@Test
	public void LoginWithValidCredinrtials() {
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("#login-button")).click();
		
		Assert.assertTrue(driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).isDisplayed());
		
		
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
