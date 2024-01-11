package com.SelenumFrameWorkEasyPart;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigateToWebsiteAndVerifyTheTitleOfThePage {
	public WebDriver driver;
	
	@BeforeMethod
	public void navigateToWebSite() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(100));
		driver.get("https://www.costco.com/");
			
	}
	
	@Test
	public void titleOfThePage() {
		
	
		System.out.println("title of the page is :" + driver.getTitle());
		
		String actualPageTitle = driver.getTitle();
	    String expectedPageTitle = "Welcome to Costco Wholesale";
	    
	    
	   if(actualPageTitle.equals(expectedPageTitle)) {
			System.out.println("The landing page is correct");
		}else {
			System.out.println("The landing page is incorrect");

		}
			
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	

}
