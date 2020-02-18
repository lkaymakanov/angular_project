package net.is_bg.ltf.jwt;

public class TokenData {

	private String user;
	private String pass;
	
	public  TokenData() {
		
	}
	
	public TokenData(String user, String pass){
		this.user = user;
		this.pass  = pass;
	}
	
	public String getUser() {
		return user;
	}
	
	public String getPass() {
		return pass;
	}
	
	@Override
	public String toString() {
		return "{user:" + user + ", pass:" + pass+"}";
	}
}
