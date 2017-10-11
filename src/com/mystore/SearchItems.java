package com.mystore;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.beans.SearchData;
import com.mystore.dao.SearchDAO;

public class SearchItems extends Core {

	/*
	 * @FindAll({ @FindBy(linkText = "T-SHIRTS") }) List<WebElement>
	 * tshirtsLink;
	 */

	@FindBy(id = "search_query_top")
	WebElement searchQuery;

	@FindBy(name = "submit_search")
	WebElement searchButton;

	/*
	 * @FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[2]/h5/a")
	 * WebElement firstSearchItem;
	 */
	@FindAll({
		@FindBy(xpath="//div[@class='product-container']/div/h5/a[@class='product-name']")
	})
	List<WebElement> firstSearchItem;

	@Test
	@Parameters("testCaseID")
	public void searchItems(@Optional("2") String testCaseID) {
		try {
			PageFactory.initElements(driver, this);
			SearchDAO searchdao = new SearchDAO();
			SearchData searchdata = searchdao.getsearchdata(testCaseID);

			/* tshirtsLink.get(0).click(); */
			searchQuery.sendKeys(searchdata.getSearchKey());
			searchButton.click();

			/*
			 * WebDriverWait wait = new WebDriverWait(driver, 30);
			 * wait.until(ExpectedConditions.visibilityOf(firstSearchItem));
			 */
			System.out.println("Size: "+firstSearchItem.size());
			driver.navigate().to(firstSearchItem.get(0).getAttribute("href"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
