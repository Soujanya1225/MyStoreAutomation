package com.mystore;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DeleteItemsFromCart extends Core {
	@FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span")
	WebElement continueButton;
	
	@FindBy(xpath = "//*[@id='header']/div[3]/div/div/div[3]/div/a")
	WebElement cart;

	@FindBy(xpath = "//*[@id='header']/div[3]/div/div/div[3]/div/div/div/div/dl/dt/span/a")
	WebElement deleteItem;

	@Test
	public void deleteItems() {
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(continueButton));
		continueButton.click();
		Actions action = new Actions(driver);
		action.moveToElement(cart).build().perform();

		deleteItem.click();
		System.out.println("Deleted Item from Cart");
	}

}
