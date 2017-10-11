package com.mystore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mystore.beans.LoginData;

public class LoginDAO {

	public LoginDAO() {

	}

	private LoginData LoginDetails;

	public LoginData getLoginDetails(String testcaseID) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "soujanya", "Hello123");
			PreparedStatement statement = connection.prepareStatement("select * from MYSTORELOGIN WHERE TC_ID=?");
			statement.setString(1, testcaseID);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				LoginDetails = new LoginData(rs.getString("USERNAME"), rs.getString("PASSWORD"));
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return LoginDetails;
	}
}
