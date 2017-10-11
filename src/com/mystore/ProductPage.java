package com.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.beans.ProductData;
import com.mystore.dao.ProductDAO;

public class ProductPage extends Core {

	
	
	@Test
	@Parameters("testCaseID")
	public void productPage(String testCaseID) {
		ProductDAO productdao=new ProductDAO();
		ProductData productdata = productdao.getProductDetails(testCaseID);
		driver.findElement(By.id("quantity_wanted")).clear();
		driver.findElement(By.id("quantity_wanted")).sendKeys(productdata.getQuantity());
		Select size = new Select(driver.findElement(By.id("group_1")));
		size.selectByVisibleText(productdata.getSize());
		driver.findElement(By.xpath("//*[@id='add_to_cart']/button/span")).click();
	}
}
