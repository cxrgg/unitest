package com.hbsf.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CommonUtil {

	public static String md5(String str) {
		MessageDigest instance = null;
		try {
			instance = MessageDigest.getInstance("MD5");
			instance.update(str.getBytes());
			return new BigInteger(1, instance.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}
	

}
