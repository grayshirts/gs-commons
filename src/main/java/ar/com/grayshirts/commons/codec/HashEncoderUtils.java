package ar.com.grayshirts.commons.codec;

import org.apache.commons.lang3.StringUtils;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Encodes to different formats.
 */
public abstract class HashEncoderUtils {

	public static String encodeMd5Hex(CharSequence text) {
		MessageDigest md;
		byte[] array;
		try {
			md = MessageDigest.getInstance("MD5");
			array = md.digest(text.toString().getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; ++i) {
			sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		}
		return sb.toString();
	}

	public static String encodeSha256Hex(CharSequence text) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(text.toString().getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return StringUtils.leftPad(new BigInteger(1, md.digest()).toString(16), 40, "0");
	}
}
