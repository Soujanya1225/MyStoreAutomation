package com.mystore.beans;

public class ShopWomenData {
	
	ShopWomenData(){
		
	}

	private String womenCategory;
	private String dressesCategory;
	private String topsCategory;
	
public ShopWomenData(String womenCategory,String dressesCategory, String topsCategory ){
	this.womenCategory = womenCategory;
	this.dressesCategory = dressesCategory;
	this.topsCategory = topsCategory;
		
	}

	public String getWomenCategory() {
		return womenCategory;
	}

	public void setWomenCategory(String womenCategory) {
		this.womenCategory = womenCategory;
	}

	public String getDressesCategory() {
		return dressesCategory;
	}

	public void setDressesCategory(String dressesCategory) {
		this.dressesCategory = dressesCategory;
	}

	public String getTopsCategory() {
		return topsCategory;
	}

	public void setTopsCategory(String topsCategory) {
		this.topsCategory = topsCategory;
	}

}
