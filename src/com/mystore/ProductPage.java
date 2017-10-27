package com.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.beans.ProductData;
import com.mystore.dao.ProductDAO;

public class ProductPage extends Core {

	@Test
	@Parameters("testCaseID")
	public void productPage(String testCaseID) {
		PageFactory.initElements(driver, this);
		ProductDAO productdao = new ProductDAO();
		ProductData productdata = productdao.getProductDetails(testCaseID);
		driver.findElement(By.id("quantity_wanted")).clear();
		driver.findElement(By.id("quantity_wanted")).sendKeys(productdata.getQuantity());
		Select size = new Select(driver.findElement(By.id("group_1")));
		size.selectByVisibleText(productdata.getSize());

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='add_to_cart']/button/span"))));

		driver.findElement(By.xpath("//*[@id='add_to_cart']/button/span[contains(text(), 'Add to cart')]")).click();

	}
}
