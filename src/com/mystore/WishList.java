package com.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;



public class WishList extends Core {
	@FindBy(linkText = "Dresses")
	WebElement dresses;
	
	@FindBy(linkText = "Casual Dresses")
	WebElement casualDress;


	
	
	@Test
	public void createWishList(){
		
		driver.findElement(By.xpath("//*[contains(text(),'My wishlists')]")).click();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("WishList-Shirts");
		driver.findElement(By.xpath("//button[@id='submitWishlist']")).click();
		
		System.out.println(driver.findElement(By.xpath("//tbody/tr[]/td[1]")).getText());
		
		
			
		
		
		
		
	}

}
