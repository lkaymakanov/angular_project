package net.is_bg.ltf.businessmodels.softuni.userdata;


import net.is_bg.ltf.AbstractModel;

public class UserDataFrontEnd extends AbstractModel {
	
	private String  username;
	private String  email;
	private String  image;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}

