package com.mystore.beans;

public class ProductData {
	
	private String size;
	private String quantity;
	ProductData(){
		
	}
	public ProductData(String sizeInfo,String quantityInfo){
		this.size=sizeInfo;
		this.quantity = quantityInfo;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
