package com.mystore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mystore.beans.OrderData;

public class OrderDAO {

	
	public OrderDAO() {

		}

		private OrderData OrderDetails;

		public OrderData getOrderDetails(String testcaseID) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection connection = null;
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "soujanya", "Hello123");
				PreparedStatement statement = connection.prepareStatement("select * from ORDER_STATUS WHERE TC_ID=?");
				statement.setString(1, testcaseID);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					OrderDetails = new OrderData(rs.getString("ORDERNO"));
				}
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return OrderDetails;
		}
	}
