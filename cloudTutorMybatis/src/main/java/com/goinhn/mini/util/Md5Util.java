package com.goinhn.mini.util;

import java.security.MessageDigest;

/**
 * 写一个MD5算法,运行结果与MySQL的md5()函数相同
 * 将明文密码转成MD5密码
 * 123456->e10adc3949ba59abbe56e057f20f883e
 */
public final class Md5Util {

	private static String[] hex = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

	private Md5Util(){}
	/**
	 * 将明文密码转成MD5密码 
	 */
	public static String encodeByMd5(String password) throws Exception{
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] byteArray = md5.digest(password.getBytes());
		//注意：MessageDigest只能将String转成byte[]，接下来的事情，由我们程序员来完成
		return byteArrayToHexString(byteArray);
	}

	/**
	 * 将byte[]转在16进制字符串 
	 */
	private static String byteArrayToHexString(byte[] byteArray) {
		StringBuffer sb = new StringBuffer();
		//遍历
		for(byte b : byteArray){//16次
			//取出每一个byte类型，进行转换
			String hex = byteToHexString(b);
			//将转换后的值放入StringBuffer中
			sb.append(hex);
		}
		return sb.toString();
	}

	/**
	 * 将byte转在16进制字符串 
	 */
	private static String byteToHexString(byte b) {//-31转成e1，10转成0a，。。。
		int n = b;
		if(n < 0){
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;

		return hex[d1] + hex[d2];
	}

	public static void main(String[] args) throws Exception{
		String password = "123456";
		String passwordMD5 = Md5Util.encodeByMd5(password);
		System.out.println(password);
		System.out.println(passwordMD5);
	}
}
