package com.mystore;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Core {
	public static WebDriver driver;
	
	@BeforeTest
	public void openURL() {
		System.setProperty("webdriver.gecko.driver", "D:\\WI{PRO\\Selenium\\geckodriver-v0.19.0-win64\\geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
		PageFactory.initElements(driver, this);
	}
	@AfterTest
	public void closeAll() {
		/*driver.close();
		driver.quit();*/
	}


}
