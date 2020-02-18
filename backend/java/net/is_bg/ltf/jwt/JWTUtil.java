package net.is_bg.ltf.jwt;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.is_bg.ltf.jwt.JWTSigner.Options;

/*import authenticate.token.TokenConstants;
import authenticate.token.TokenData;
import net.is_bg.ltfn.jwt.Algorithm;
import net.is_bg.ltfn.jwt.JWTSigner;
import net.is_bg.ltfn.jwt.JWTSigner.Options;
import net.is_bg.ltfn.jwt.JWTVerifier;

*//**
 * Encrypts & decrypts Token data utilities using JWT.
 * @author Lubo
 *
 */
public class JWTUtil {
    private final static String issuer = "LTF";
    private final static String tokenKey = "key";// TokenConstants.TOKEN_ID_PARAM_NAME;
    private final static ObjectMapper 	om  = new ObjectMapper();

    /***
     * 
     * @param tokenData
     * @param secret
     * @param expireAfterXSeconds
     * @return
     */
    public static <T> String  generateToken(T tokenData, String secret, long expireAfterXSeconds) {
		String token = null;
		JWTSigner jwtSigner = new JWTSigner(secret);
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put(tokenKey, tokenData);
		Options signOptions = new Options();
		signOptions.setExpirySeconds(expireAfterXSeconds);
		signOptions.setAlgorithm(Algorithm.HS512);
		token = jwtSigner.sign(claims, signOptions);
		return token;
    }
    
    /***
     * 
     * @param jwt
     * @param secret
     * @return
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws IllegalStateException
     * @throws SignatureException
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
	public static <T> T getTokenData(String jwt, String secret, Class<T> c ) throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, SignatureException, IOException{
    	Map<String, Object> result = (Map<String, Object>)verifyToken(jwt, secret);
    	Object data = (result.get(tokenKey));
    	ObjectMapper om = new ObjectMapper();
    	data = om.convertValue(data, c);
		return (T)(data);
    }

    /**
     * Method that verifies token and returns payload
     * 
     * @param jwt
     * @param secret
     * @return
     * @throws IOException
     * @throws SignatureException
     * @throws IllegalStateException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws Exception
     */
    public static Map<String, Object> verifyToken(String jwt, String secret)
	    throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, SignatureException, IOException {
    	JWTVerifier jwtVerifier = new JWTVerifier(secret, issuer, false, true);
    	return jwtVerifier.verify(jwt);
    }

    
    /**
     * 
     * @param token
     * @return
     * @throws JsonProcessingException
     * @throws UnsupportedEncodingException
     */
    private static String tokenToBase64String(String token) throws JsonProcessingException, UnsupportedEncodingException{
        byte b [] =	token.getBytes("UTF-8");
    	return om.writeValueAsString(b);
    }
    
    private static String fromBase64toToken(String base64encodedToken) throws JsonParseException, JsonMappingException, IOException{
    	byte [] b =  om.readValue(base64encodedToken, byte[].class);
    	return new String(b, "UTF-8");
    }
    
}
