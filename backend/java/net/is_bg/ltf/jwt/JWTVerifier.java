package net.is_bg.ltf.jwt;

import java.io.IOException;
import java.net.URLDecoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JWT Java Implementation
 * <p/>
 * Adapted from https://bitbucket.org/lluisfaja/javajwt/wiki/Home See <a href=
 * "https://bitbucket.org/lluisfaja/javajwt/src/3941d23e8e70f681d8a9a2584760e58e79e498f1/JavaJWT/src/com/unblau/javajwt/JWTVerifier.java"
 * >JWTVerifier.java</a>
 */
public class JWTVerifier {

    private final String secret;
    private final String audience;
    private final String issuer;

    private Map<String, String> algorithms;

    private boolean secretBase64encoded = true;
    ObjectMapper om = new ObjectMapper();
    private boolean timeInGMT = true;
    

    public JWTVerifier(String secret,
		       String audience,
		       String issuer,
		       boolean secretBase64encoded,
		       boolean timeInGMT) {
	if (secret == null
	    || "".equals(secret)) {
	    throw new IllegalArgumentException("Secret cannot be null or empty");
	}

	algorithms = new HashMap<String, String>();
	algorithms.put("HS256",
		       "HmacSHA256");
	algorithms.put("HS384",
		       "HmacSHA384");
	algorithms.put("HS512",
		       "HmacSHA512");

	this.secret = secret;
	this.audience = audience;
	this.issuer = issuer;
	this.secretBase64encoded = secretBase64encoded;
	this.timeInGMT = timeInGMT;
    }

    public JWTVerifier(String secret,
		       String issuer,
		       boolean secretBase64encoded,
		       boolean timeInGMT) {
	this(secret, null, issuer, secretBase64encoded, timeInGMT);
    }

    public JWTVerifier(String secret) {
	this(secret, null, null, true, true);
    }

    /**
     * Performs JWT validation
     * 
     * @param token
     *            token to verify
     * @throws SignatureException
     *             when signature is invalid
     * @throws IllegalStateException
     *             when token's structure, expiration, issuer or audience are
     *             invalid
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> verify(String token) throws NoSuchAlgorithmException, InvalidKeyException, IllegalStateException, IOException, SignatureException {
	if (token == null
	    || "".equals(token)) {
	    throw new IllegalStateException("token not set");
	}
	token = replacer(token);
	String[] pieces = token.split("\\.");

	// check number of segments
	if (pieces.length != 3) {
	    throw new IllegalStateException("Wrong number of segments: "
					    + pieces.length);
	}

	// get JWTHeader JSON object. Extract algorithm
	JsonNode jwtHeader = decodeAndParse(pieces[0]);

	String algorithm = getAlgorithm(jwtHeader);

	// get JWTClaims JSON object
	JsonNode jwtPayload = decodeAndParse(pieces[1]);

	// check signature
	verifySignature(pieces,
			algorithm);

	// additional JWTClaims checks
	verifyExpiration(jwtPayload);
	verifyIssuer(jwtPayload);
	verifyAudience(jwtPayload);

	return     om.treeToValue(jwtPayload,
						Map.class);
    }

    private String replacer(String data) {
	try {
	    StringBuffer tempBuffer = new StringBuffer();
	    int incrementor = 0;
	    int dataLength = data.length();
	    while (incrementor < dataLength) {
		char charecterAt = data.charAt(incrementor);
		if (charecterAt == '+') {
		    tempBuffer.append("<plus>");
		} else {
		    tempBuffer.append(charecterAt);
		}
		incrementor++;
	    }
	    data = tempBuffer.toString();
	    data = URLDecoder.decode(data,
				     "UTF-8");
	    data = data.replaceAll("<plus>",
				   "+");
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return data;
    }

    void verifySignature(String[] pieces,
			 String algorithm)
	    throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
	Mac hmac = Mac.getInstance(algorithm);
	byte[] secretBytes = secret.getBytes();
	Decoder d =Base64.getDecoder();
	if (secretBase64encoded)
	    secretBytes = d.decode(secretBytes);
	hmac.init(new SecretKeySpec(secretBytes, algorithm));
	byte[] sig = hmac.doFinal(new StringBuilder(pieces[0]).append(".")
							      .append(pieces[1])
							      .toString()
							      .getBytes());

	if (!Arrays.equals(sig,
			   d.decode(pieces[2].getBytes()))) {
	    throw new SignatureException("signature verification failed");
	}
    }

    void verifyExpiration(JsonNode jwtClaims) {
	final long expiration = jwtClaims.has("exp") ? jwtClaims.get("exp")
								.asLong(0)
						     : 0;
	Calendar cal = Calendar.getInstance();
	long currTimeInMills = cal.getTimeInMillis();
	if (!timeInGMT)
	    currTimeInMills = cal.getTimeInMillis()
			      + cal.get(Calendar.ZONE_OFFSET);
	if (expiration != 0
	    && currTimeInMills >= expiration) {
	    System.out.println(expiration);
	    System.out.println(currTimeInMills);
	    throw new IllegalStateException("jwt expired");
	}
    }

    void verifyIssuer(JsonNode jwtClaims) {
	final String issuerFromToken = jwtClaims.has("iss") ? jwtClaims.get("iss")
								       .asText()
							    : null;

	if (issuerFromToken != null
	    && issuer != null
	    && !issuer.equals(issuerFromToken)) {
	    throw new IllegalStateException("jwt issuer invalid");
	}
    }

    void verifyAudience(JsonNode jwtClaims) {
	if (audience == null)
	    return;
	JsonNode audNode = jwtClaims.get("aud");
	if (audNode == null)
	    return;
	if (audNode.isArray()) {
	    for (JsonNode jsonNode : audNode) {
		if (audience.equals(jsonNode.asText()))
		    return;
	    }
	} else if (audNode.isTextual()) {
	    if (audience.equals(audNode.asText()))
		return;
	}
	throw new IllegalStateException("jwt audience invalid");
    }

    String getAlgorithm(JsonNode jwtHeader) {
	final String algorithmName = jwtHeader.has("alg") ? jwtHeader.get("alg")
								     .asText()
							  : null;

	if (jwtHeader.get("alg") == null) {
	    throw new IllegalStateException("algorithm not set");
	}

	if (algorithms.get(algorithmName) == null) {
	    throw new IllegalStateException("unsupported algorithm");
	}

	return algorithms.get(algorithmName);
    }

    JsonNode decodeAndParse(String b64String) throws IOException {
    Decoder d = Base64.getDecoder();
	String jsonString = new String(d.decode(b64String), "UTF-8");
	JsonNode jwtHeader =  // ObjectMapperProvider.getObjectMapper(MEDIA_TYPE.JSON)
						 om.readValue(jsonString,
							    JsonNode.class);
	return jwtHeader;
    }
}