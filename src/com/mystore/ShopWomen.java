package com.mystore;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.beans.ShopWomenData;
import com.mystore.dao.ShopWomenDAO;

public class ShopWomen extends Core {
	@FindBy(linkText = "Women")
	WebElement selectWomen;

	@FindBy(xpath = "//img[@src ='http://automationpractice.com/img/c/4-medium_default.jpg']")
	WebElement selectTops;

	@FindBy(xpath = "//img[@src='http://automationpractice.com/img/c/5-medium_default.jpg']")
	WebElement selectTshirts;

	@FindBy(xpath = "//img[@src='http://automationpractice.com/img/c/5-medium_default.jpg']")
	WebElement selectBlouses;

	@FindBy(xpath = "//img[@src='http://automationpractice.com/img/c/8-medium_default.jpg']")
	WebElement selectDresses;

	@FindBy(xpath = "//img[@src='http://automationpractice.com/img/c/9-medium_default.jpg']")
	WebElement casualDresses;

	@FindBy(xpath = "//img[@src='http://automationpractice.com/img/c/10-medium_default.jpg']")
	WebElement eveningDresses;

	@FindBy(xpath = "//img[@src='http://automationpractice.com/img/c/11-medium_default.jpg']")
	WebElement summerDresses;

	@FindBy(xpath = "//img[@src='http://automationpractice.com/img/p/1/1-home_default.jpg']")
	WebElement tshirtItem;

	@FindBy(xpath = "//img[@src='http://automationpractice.com/img/p/7/7-home_default.jpg']")
	WebElement blouseItem;

	@FindBy(xpath = "//img[@src='http://automationpractice.com/img/p/8/8-home_default.jpg']")
	WebElement casualDressItem;

	@FindBy(xpath = "//img[@src='http://automationpractice.com/img/p/1/0/10-home_default.jpg']")
	WebElement eveningDressItem;

	@FindBy(xpath = "//img[@src='http://automationpractice.com/img/p/1/6/16-home_default.jpg']")
	WebElement summerDressItem;

	@Test
	@Parameters("testCaseID")
	public void WomenCategory(String testCaseID) {
		PageFactory.initElements(driver, this);
		ShopWomenDAO shopwomendao = new ShopWomenDAO();
		ShopWomenData shopwomendata = shopwomendao.getShopWomenDetails(testCaseID);

		selectWomen.click();
		if (shopwomendata.getWomenCategory().equals("Dresses")) {
			selectDresses.click();
			if (shopwomendata.getDressesCategory().equals("Casual")) {
				casualDresses.click();
				casualDressItem.click();
			}
			if (shopwomendata.getDressesCategory().equals("Evening")) {
				eveningDresses.click();
				eveningDressItem.click();
			}
			if (shopwomendata.getDressesCategory().equals("Summer")) {
				summerDresses.click();
				summerDressItem.click();
			}

		}
		if (shopwomendata.getWomenCategory().equals("Tops")) {
			selectTops.click();
			if (shopwomendata.getTopsCategory().equals("Blouses")) {
				selectBlouses.click();
				blouseItem.click();
			}
			if (shopwomendata.getTopsCategory().equals("Tshirts")) {
				selectTshirts.click();
				tshirtItem.click();
			}

		}

	}
}
