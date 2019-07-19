package com.kevin.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author caonanqing
 * @version 1.0
 * @description     加密使用
 * @createDate 2019/6/26
 */
public class MD5Utils {
	private static final String SALT = "ldsdkkP36";

	private static final String ALGORITH_NAME = "md5";

	private static final int HASH_ITERATIONS = 2;

	public static String encrypt(String pswd) {
		String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(SALT), HASH_ITERATIONS).toHex();
		return newPassword;
	}

	public static String encrypt(String username, String pswd) {
		String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(username),
				HASH_ITERATIONS).toHex();
		return newPassword;
	}
	public static void main(String[] args) {

		System.out.println(MD5Utils.encrypt("admin", "123456"));
		System.out.println(MD5Utils.encrypt("123456"));

	}

}
