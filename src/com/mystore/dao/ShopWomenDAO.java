package com.mystore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mystore.beans.ShopWomenData;

public class ShopWomenDAO {

	public ShopWomenDAO() {

	}

	private ShopWomenData ShopWomenDetails;

	public ShopWomenData getShopWomenDetails(String testcaseID) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "soujanya", "Hello123");
			PreparedStatement statement = connection.prepareStatement("select * from WOMEN_SHOP WHERE TC_ID=?");
			statement.setString(1, testcaseID);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				ShopWomenDetails = new ShopWomenData(rs.getString("WOMEN_CATEGORY"), rs.getString("DRESSES_CATEGORY"),
						rs.getString("TOPS_CATEGORY"));
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ShopWomenDetails;

	}
}
