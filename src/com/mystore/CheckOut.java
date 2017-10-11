package com.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CheckOut extends Core{
	
	@FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span")
	WebElement continueButton;
	
	@FindBy(xpath = "//*[@id='header']/div[3]/div/div/div[3]/div/a")
	WebElement cart;
	
	@FindBy(xpath="//*[@id='button_order_cart']/span")
	WebElement checkOutButton;
	
	@FindBy(xpath="//span[@id='total_price']")
	WebElement totalPrice;
	
	@FindBy(xpath="//*[@id='center_column']/p[2]/a[1]/span")
	WebElement proceedToCheckOut1;
	
	@FindBy(xpath="//*[@id='center_column']/form/p/button/span")
	WebElement proceedToCheckOut2;
	
	@FindBy(xpath="//*[@id='form']/div/div[2]/div[1]/div/div/table/tbody/tr/td[4]/div")
	WebElement shippingPrice;
	
	@FindBy(xpath="//input[@id='cgv' and @value='1']")
	WebElement agreeTerms;
	
	@FindBy(xpath = "//*[@id='form']/p/button/span")
	WebElement proceedToCheckOut3;
	
	@FindBy(xpath="//a[@title='Pay by check.']")
	WebElement payByCheck;
	
	@FindBy(xpath="//*[@id='cart_navigation']/button/span")
	WebElement confirmOrder;
	
	@Test
	public void checkOut(){
		PageFactory.initElements(driver, this);
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(continueButton));
		continueButton.click();
		
		Actions action = new Actions(driver);
		action.moveToElement(cart).build().perform();
		wait.until(ExpectedConditions.visibilityOf(checkOutButton));
		checkOutButton.click();
		System.out.println(totalPrice.getText());
		proceedToCheckOut1.click();
		proceedToCheckOut2.click();
		System.out.println("Shipping Price: "+shippingPrice.getText());
		agreeTerms.click();
		System.out.println(agreeTerms.isSelected());
		proceedToCheckOut3.click();
		payByCheck.click();
		System.out.println(driver.findElement(By.xpath("//*[@id='center_column']/form/div/p[2]")).getText());
		confirmOrder.click();
		
		System.out.println(driver.findElement(By.xpath("//*[@id='center_column']/p[1]")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@id='center_column']/div/br[4]")).getText());
		
	}
}
