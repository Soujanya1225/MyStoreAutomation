package com.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.beans.OrderData;
import com.mystore.dao.OrderDAO;

public class OrderStatus extends Core {

	@Test
	@Parameters("testCaseID")
	public void orderDetails(String testCaseID) throws InterruptedException {
		PageFactory.initElements(driver, this);
		OrderDAO orderdao = new OrderDAO();
		OrderData orderdata = orderdao.getOrderDetails(testCaseID);
		driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[1]/a/span")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'"+orderdata.getOrderNumber()+"')]")).click();
		System.out.println(driver
				.findElement(By.xpath("//*[@id='block-order-detail']/div[3]/table/tbody/tr/td[2]/span")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@id='submitReorder']/p/strong")).getText());

	}
}
