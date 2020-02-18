package net.is_bg.ltf.jwt;

/** 
 * http://jssha.sourceforge.net/ 
 * <br/><br/> 
 * Pulled from there, done in javascript, and ported to java for SHA512 
 * <br/><br/> 
 * (So GWT can compile it to SHA512 and it will work the same in JRE or browser) 
 * 
 * @author chris 
 * 
 */
public class Sha512 {

	/* 
	 * int_64 is a object/container for 2 32-bit numbers emulating a 64-bit number 
	 */
	/** 
	 * Allows emulation of long in javascript and maintains that cross compatibility for java 
	 * 
	 */
	private class int_64 {

		public int highOrder;
		public int lowOrder;

		public int_64(int msint_32, int lsint_32) {
			this.highOrder = msint_32;
			this.lowOrder = lsint_32;
		}
	}

	/* 
	 * Configurable variables. Defaults typically work 
	 */
	/** 
	 * Charwidth 
	 * 
	 */
	int charSize = 8; /* Number of Bits Per character (8 for ASCII, 16 
	for Unicode)      */

	/** 
	 * SHA seed values 
	 * 
	 */
	private int_64[] K = new int_64[] { new int_64(0x0428a2f98, 0x0d728ae22),
			new int_64(0x071374491, 0x023ef65cd),
			new int_64(0x0b5c0fbcf, 0x0ec4d3b2f),
			new int_64(0x0e9b5dba5, 0x08189dbbc),
			new int_64(0x03956c25b, 0x0f348b538),
			new int_64(0x059f111f1, 0x0b605d019),
			new int_64(0x0923f82a4, 0x0af194f9b),
			new int_64(0x0ab1c5ed5, 0x0da6d8118),
			new int_64(0x0d807aa98, 0x0a3030242),
			new int_64(0x012835b01, 0x045706fbe),
			new int_64(0x0243185be, 0x04ee4b28c),
			new int_64(0x0550c7dc3, 0x0d5ffb4e2),
			new int_64(0x072be5d74, 0x0f27b896f),
			new int_64(0x080deb1fe, 0x03b1696b1),
			new int_64(0x09bdc06a7, 0x025c71235),
			new int_64(0x0c19bf174, 0x0cf692694),
			new int_64(0x0e49b69c1, 0x09ef14ad2),
			new int_64(0x0efbe4786, 0x0384f25e3),
			new int_64(0x00fc19dc6, 0x08b8cd5b5),
			new int_64(0x0240ca1cc, 0x077ac9c65),
			new int_64(0x02de92c6f, 0x0592b0275),
			new int_64(0x04a7484aa, 0x06ea6e483),
			new int_64(0x05cb0a9dc, 0x0bd41fbd4),
			new int_64(0x076f988da, 0x0831153b5),
			new int_64(0x0983e5152, 0x0ee66dfab),
			new int_64(0x0a831c66d, 0x02db43210),
			new int_64(0x0b00327c8, 0x098fb213f),
			new int_64(0x0bf597fc7, 0x0beef0ee4),
			new int_64(0x0c6e00bf3, 0x03da88fc2),
			new int_64(0x0d5a79147, 0x0930aa725),
			new int_64(0x006ca6351, 0x0e003826f),
			new int_64(0x014292967, 0x00a0e6e70),
			new int_64(0x027b70a85, 0x046d22ffc),
			new int_64(0x02e1b2138, 0x05c26c926),
			new int_64(0x04d2c6dfc, 0x05ac42aed),
			new int_64(0x053380d13, 0x09d95b3df),
			new int_64(0x0650a7354, 0x08baf63de),
			new int_64(0x0766a0abb, 0x03c77b2a8),
			new int_64(0x081c2c92e, 0x047edaee6),
			new int_64(0x092722c85, 0x01482353b),
			new int_64(0x0a2bfe8a1, 0x04cf10364),
			new int_64(0x0a81a664b, 0x0bc423001),
			new int_64(0x0c24b8b70, 0x0d0f89791),
			new int_64(0x0c76c51a3, 0x00654be30),
			new int_64(0x0d192e819, 0x0d6ef5218),
			new int_64(0x0d6990624, 0x05565a910),
			new int_64(0x0f40e3585, 0x05771202a),
			new int_64(0x0106aa070, 0x032bbd1b8),
			new int_64(0x019a4c116, 0x0b8d2d0c8),
			new int_64(0x01e376c08, 0x05141ab53),
			new int_64(0x02748774c, 0x0df8eeb99),
			new int_64(0x034b0bcb5, 0x0e19b48a8),
			new int_64(0x0391c0cb3, 0x0c5c95a63),
			new int_64(0x04ed8aa4a, 0x0e3418acb),
			new int_64(0x05b9cca4f, 0x07763e373),
			new int_64(0x0682e6ff3, 0x0d6b2b8a3),
			new int_64(0x0748f82ee, 0x05defb2fc),
			new int_64(0x078a5636f, 0x043172f60),
			new int_64(0x084c87814, 0x0a1f0ab72),
			new int_64(0x08cc70208, 0x01a6439ec),
			new int_64(0x090befffa, 0x023631e28),
			new int_64(0x0a4506ceb, 0x0de82bde9),
			new int_64(0x0bef9a3f7, 0x0b2c67915),
			new int_64(0x0c67178f2, 0x0e372532b),
			new int_64(0x0ca273ece, 0x0ea26619c),
			new int_64(0x0d186b8c7, 0x021c0c207),
			new int_64(0x0eada7dd6, 0x0cde0eb1e),
			new int_64(0x0f57d4f7f, 0x0ee6ed178),
			new int_64(0x006f067aa, 0x072176fba),
			new int_64(0x00a637dc5, 0x0a2c898a6),
			new int_64(0x0113f9804, 0x0bef90dae),
			new int_64(0x01b710b35, 0x0131c471b),
			new int_64(0x028db77f5, 0x023047d84),
			new int_64(0x032caab7b, 0x040c72493),
			new int_64(0x03c9ebe0a, 0x015c9bebc),
			new int_64(0x0431d67c4, 0x09c100d4c),
			new int_64(0x04cc5d4be, 0x0cb3e42b6),
			new int_64(0x0597f299c, 0x0fc657e2a),
			new int_64(0x05fcb6fab, 0x03ad6faec),
			new int_64(0x06c44198c, 0x04a475817) };

	/** 
	 * SHA512 seed values 
	 */
	int_64[] H_512 = new int_64[] { new int_64(0x06a09e667, 0x0f3bcc908),
			new int_64(0x0bb67ae85, 0x084caa73b),
			new int_64(0x03c6ef372, 0x0fe94f82b),
			new int_64(0x0a54ff53a, 0x05f1d36f1),
			new int_64(0x0510e527f, 0x0ade682d1),
			new int_64(0x09b05688c, 0x02b3e6c1f),
			new int_64(0x01f83d9ab, 0x0fb41bd6b),
			new int_64(0x05be0cd19, 0x0137e2179) };

	/** 
	 * Convert a string to an array of big-endian words<br/> 
	 * If charSize is ASCII, characters >255 have their hi-byte silently 
	ignored.<br/> 
	 * Taken from Paul Johnson 
	 * 
	 * @param input 
	 * @return 
	 */
	public int[] str2binb(String input) {
		//get size of array 
		int z = (input.length() * charSize) >> 5;

		//create input size 
		int[] bin = new int[z + 1];

		int mask = (1 << charSize) - 1;
		int length = input.length() * charSize;

		for (int i = 0; i < length; i += charSize) {

			bin[i >> 5] |= (input.charAt(i / charSize) & mask) << (32 - charSize - i % 32);
		}

		return bin;
	}

	/** 
	 * Convert an array of big-endian words to a hex string.<br/> 
	 * Taken from Paul Johnson 
	 * 
	 * @param binarray 
	 * @return 
	 */
	public String binb2hex(int[] binarray) {

		String str = "";
		for (int i : binarray) {

			String t = Integer.toHexString(i);

			if (t.length() == 7)
				t = "0" + t;

			str += t;
		}

		return str;
	}

	private int_64 ROTR(int_64 x, int n) {
		if (n < 32) return new int_64((x.highOrder >>> n) | (x.lowOrder << (32 - n)), (x.lowOrder >>> n) | (x.highOrder << (32 - n)));
		else if (n == 32) // Apparently in JS, shifting a 32-bit value by 32 yields original value
			return new int_64(x.lowOrder, x.highOrder);
		else
			return ROTR(ROTR(x, 32), n - 32);
	}

	private int_64 SHR(int_64 x, int n) {
		if (n < 32) return new int_64(x.highOrder >>> n, x.lowOrder >>> n | (x.highOrder << (32 - n)));
		else if (n == 32) // Apparently in JS, shifting a 32-bit value by 32 yields original value 
			return new int_64(0, x.highOrder);
		else
			return SHR(SHR(x, 32), n - 32);
	}

	private int_64 Ch(int_64 x, int_64 y, int_64 z) {
		return new int_64((x.highOrder & y.highOrder)
				^ (~x.highOrder & z.highOrder), (x.lowOrder & y.lowOrder)
				^ (~x.lowOrder & z.lowOrder));
	}

	private int_64 Maj(int_64 x, int_64 y, int_64 z) {
		return new int_64((x.highOrder & y.highOrder)
				^ (x.highOrder & z.highOrder) ^ (y.highOrder & z.highOrder),
				(x.lowOrder & y.lowOrder) ^ (x.lowOrder & z.lowOrder)
						^ (y.lowOrder & z.lowOrder));
	}

	private int_64 Sigma0(int_64 x) {
		int_64 ROTR28 = ROTR(x, 28);
		int_64 ROTR34 = ROTR(x, 34);
		int_64 ROTR39 = ROTR(x, 39);

		return new int_64(ROTR28.highOrder ^ ROTR34.highOrder
				^ ROTR39.highOrder, ROTR28.lowOrder ^ ROTR34.lowOrder
				^ ROTR39.lowOrder);
	}

	private int_64 Sigma1(int_64 x) {
		int_64 ROTR14 = ROTR(x, 14);
		int_64 ROTR18 = ROTR(x, 18);
		int_64 ROTR41 = ROTR(x, 41);

		return new int_64(ROTR14.highOrder ^ ROTR18.highOrder
				^ ROTR41.highOrder, ROTR14.lowOrder ^ ROTR18.lowOrder
				^ ROTR41.lowOrder);
	}

	private int_64 Gamma0(int_64 x) {
		int_64 ROTR1 = ROTR(x, 1);
		int_64 ROTR8 = ROTR(x, 8);
		int_64 SHR7 = SHR(x, 7);

		return new int_64(ROTR1.highOrder ^ ROTR8.highOrder ^ SHR7.highOrder,
				ROTR1.lowOrder ^ ROTR8.lowOrder ^ SHR7.lowOrder);
	}

	private int_64 Gamma1(int_64 x) {
		int_64 ROTR19 = ROTR(x, 19);
		int_64 ROTR61 = ROTR(x, 61);
		int_64 SHR6 = SHR(x, 6);

		return new int_64(ROTR19.highOrder ^ ROTR61.highOrder ^ SHR6.highOrder,
				ROTR19.lowOrder ^ ROTR61.lowOrder ^ SHR6.lowOrder);
	}

	/** 
	 * Core, taken from http://jssha.sourceforge.net/ 
	 * 
	 * @param message 
	 * @param messageLength 
	 * @return 
	 */
	private int[] coreSHA2(int[] message, int messageLength) {
		int_64[] W = new int_64[80];
		int_64 a, b, c, d, e, f, g, h;
		int_64 T1, T2;
		int_64[] H = new int_64[8];

		//copy starting value 
		System.arraycopy(this.H_512, 0, H, 0, 8);

		//get values ??? 
		int x = messageLength >> 5;
		int z = ((messageLength + 1 + 128 >> 10) << 5) + 31;

		//copy array and make big enough 
		int[] arrayCopy = new int[z + 1];
		System.arraycopy(message, 0, arrayCopy, 0, message.length);
		message = arrayCopy;

		//copy 
		message[x] |= 0x080 << (24 - messageLength % 32); // Append '1' at the end of the binary string 

		message[z] = messageLength; // Append length of binary string in the position such that the new length is a multiple of 1024 

		int appendedMessageLength = message.length;

		for (int i = 0; i < appendedMessageLength; i += 32) {
			a = H[0];
			b = H[1];
			c = H[2];
			d = H[3];
			e = H[4];
			f = H[5];
			g = H[6];
			h = H[7];

			for (int t = 0; t < 80; t++) {
				if (t < 16)
					W[t] = new int_64(message[t * 2 + i],
							message[t * 2 + i + 1]);
				else
					W[t] = safeAdd(safeAdd(safeAdd(Gamma1(W[t - 2]), W[t - 7]),
							Gamma0(W[t - 15])), W[t - 16]);

				T1 = safeAdd(safeAdd(
						safeAdd(safeAdd(h, Sigma1(e)), Ch(e, f, g)), K[t]),
						W[t]);
				T2 = safeAdd(Sigma0(a), Maj(a, b, c));
				h = g;
				g = f;
				f = e;
				e = safeAdd(d, T1);
				d = c;
				c = b;
				b = a;
				a = safeAdd(T1, T2);
			}

			H[0] = safeAdd(a, H[0]);
			H[1] = safeAdd(b, H[1]);
			H[2] = safeAdd(c, H[2]);
			H[3] = safeAdd(d, H[3]);
			H[4] = safeAdd(e, H[4]);
			H[5] = safeAdd(f, H[5]);
			H[6] = safeAdd(g, H[6]);
			H[7] = safeAdd(h, H[7]);
		}

		return returnSHA2(H);
	}

	/* 
	 * The 64-bit counterpart to safeAdd_32 
	 */
	private int_64 safeAdd(int_64 x, int_64 y) {
		int lsw = (x.lowOrder & 0x0FFFF) + (y.lowOrder & 0x0FFFF);
		int msw = (x.lowOrder >>> 16) + (y.lowOrder >>> 16) + (lsw >>> 16);
		int lowOrder = ((msw & 0x0FFFF) << 16) | (lsw & 0x0FFFF);

		lsw = (x.highOrder & 0x0FFFF) + (y.highOrder & 0x0FFFF) + (msw >>> 16);
		msw = (x.highOrder >>> 16) + (y.highOrder >>> 16) + (lsw >>> 16);
		int highOrder = ((msw & 0x0FFFF) << 16) | (lsw & 0x0FFFF);

		return new int_64(highOrder, lowOrder);
	}

	private int[] returnSHA2(int_64[] hashArray) {
		return new int[] { hashArray[0].highOrder, hashArray[0].lowOrder,
				hashArray[1].highOrder, hashArray[1].lowOrder,
				hashArray[2].highOrder, hashArray[2].lowOrder,
				hashArray[3].highOrder, hashArray[3].lowOrder,
				hashArray[4].highOrder, hashArray[4].lowOrder,
				hashArray[5].highOrder, hashArray[5].lowOrder,
				hashArray[6].highOrder, hashArray[6].lowOrder,
				hashArray[7].highOrder, hashArray[7].lowOrder };
	}

	/** 
	 * Get the SHA512 digest of a given string input message 
	 * 
	 * @param input 
	 * @return 
	 */
	public String digest(String input) {

		int[] inputBinary = this.str2binb(input);
		int[] core = this.coreSHA2(inputBinary, input.length() * this.charSize);

		String hex = this.binb2hex(core);

		return hex;
	}

}
