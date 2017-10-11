package com.mystore.main;

import com.mystore.beans.ProductData;
import com.mystore.beans.SearchData;
import com.mystore.dao.ProductDAO;
import com.mystore.dao.SearchDAO;

public class MainTest {
	
	public static void main(String[] args) {
		
		/*LoginDAO logindao=new LoginDAO();
		LoginData logindata = logindao.getLoginDetails("2");
		System.out.println(logindata.getUserName());
		System.out.println(logindata.getPassword());*/
		
		/*ProductDAO productdao=new ProductDAO();
		ProductData productdata = productdao.getProductDetails("1");
		System.out.println(productdata.getQuantity());
		System.out.println(productdata.getSize());*/
		
		
		SearchDAO searchdao=new SearchDAO();
		SearchData searchdata = searchdao.getsearchdata("1");
		System.out.println(searchdata.getSearchKey());
		
	}

}
