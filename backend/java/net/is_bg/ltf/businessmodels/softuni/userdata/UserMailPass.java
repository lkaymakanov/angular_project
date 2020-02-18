package net.is_bg.ltf.businessmodels.softuni.userdata;

import java.io.Serializable;

public class UserMailPass implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3780512279534856993L;
	private String email, pass;
	
	public UserMailPass() {
		
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
