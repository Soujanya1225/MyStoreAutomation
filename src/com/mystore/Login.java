package com.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.beans.LoginData;
import com.mystore.dao.LoginDAO;

public class Login extends Core{

	@FindBy(linkText = "Sign in")
	WebElement signinLink;

	@FindBy(id = "email")
	WebElement emailID;

	@FindBy(id = "passwd")
	WebElement passwd;

	@FindBy(id = "SubmitLogin")
	WebElement submit;

	
	
	@Test
	@Parameters("testCaseID")
	public void loginToSite(String testCaseID) throws InterruptedException {
		PageFactory.initElements(driver, this);
		LoginDAO logindao=new LoginDAO();
		LoginData logindata = logindao.getLoginDetails(testCaseID);
		signinLink.click();
		Thread.sleep(3000);
		emailID.sendKeys(logindata.getUserName());
		passwd.sendKeys(logindata.getPassword());
		submit.click();

		System.out
				.println(driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a/span")).getText());
		System.out.println("Login successful");
	}

	}
