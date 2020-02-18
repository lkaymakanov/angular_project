package net.is_bg.ltf.jwt;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

class JWTTest {
	
	public static void main(String [] args) throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, SignatureException, IOException {
		String secret = "BEU THAT S MY SECRET";
	    String s= null;
		s = JWTUtil.generateToken(new TokenData("lubo", "dylgiq"), secret, 500);
	    s = "eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFM1MTIifQ==.eyJleHAiOjE1ODE4MDAwODY3NTAsImtleSI6eyJ1c2VyIjoibHVibyIsInBhc3MiOiJkeWxnaXEifX0=.L82jW98KjLG87D5eU8ki/WEa4HISXguqmcv9eaAJxaDUwWBWsHIly+4h3ztEOcF4o6vMUTaror1WbgVYBrtosA==" ;
	    		System.out.println(s);
	    
	    TokenData d = JWTUtil.getTokenData(s, secret, TokenData.class);
	    System.out.println(d);
		
	}

}
