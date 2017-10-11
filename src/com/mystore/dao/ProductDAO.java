package com.mystore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mystore.beans.ProductData;

public class ProductDAO {

	private ProductData productInfo;
	
	public ProductDAO(){
		
	}
	
	public ProductData getProductDetails(String testCaseID){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "soujanya", "Hello123");
			PreparedStatement statement = connection.prepareStatement("select *from PRODUCT_TABLE where TC_ID=?");
			statement.setString(1,testCaseID);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				productInfo = new ProductData(rs.getString("SIZE_INFO"), rs.getString("QUANTITY"));
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productInfo;
	}


	}
