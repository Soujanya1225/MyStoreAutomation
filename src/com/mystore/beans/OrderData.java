package com.mystore.beans;

public class OrderData {

	private String orderNumber;

	OrderData() {

	}

	public OrderData(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

}
