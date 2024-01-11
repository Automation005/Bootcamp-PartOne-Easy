package com.SelenumFrameWorkEasyPart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigateToWebsite {
	public WebDriver driver;
	public ChromeOptions options;

	@BeforeMethod
	public void costcoVerifyTile() throws InterruptedException {
		options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(100));
		Thread.sleep(2000);
		driver.get("https://www.costco.com/");

		
	}
	@Test
	public void clickLinkAndVerifyElement() throws Exception {
		Thread.sleep(2000);
	driver.findElement(By.cssSelector("#cart-d")).click();
	driver.findElement(By.cssSelector("input[class='primary-button-v2']")).isDisplayed();
	
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
