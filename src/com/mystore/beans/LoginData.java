package com.mystore.beans;

public class LoginData {
	
	private String userName;
	private String password;
	
	
	LoginData(){
		
	}
		public LoginData(String username,String password){
		this.userName=username;
		this.password=password;
		
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		

}
