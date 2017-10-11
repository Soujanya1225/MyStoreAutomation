package com.mystore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mystore.beans.SearchData;

public class SearchDAO {
	
	private SearchData searchdata;
	
	public SearchData getsearchdata(String testCaseID){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "soujanya", "Hello123");
			PreparedStatement statement = connection.prepareStatement("select *from SEARCH_TABLE where TC_ID=?");
			statement.setString(1,testCaseID);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				searchdata = new SearchData(rs.getString("SEARCH_KEYWORD"));
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchdata;
	}
	}
	

