package com.lxt.common.utils;

import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.lang3.StringUtils;

import com.sun.org.apache.xml.internal.security.utils.Base64;

public class SecurityUtils {
	public final static String secretKey = PropertiesUtils.getProperties("/config.properties").getProperty("key");
	
	private final static String iv = "12345678";
	
	private final static String encoding = "UTF-8";

	
	
	public static String desEncrypt(String plainText) throws Exception {
		return desEncrypt(plainText, secretKey);
	}

	public static String desEncrypt(String plainText, String secretKey)
			throws Exception {
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);

		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
		byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
		return Base64.encode(encryptData);
	}
	
	public static String desDecrypt(String plainText) throws Exception {
		if (StringUtils.isBlank(plainText)) {
			return "";
		}
		return desDecrypt(plainText, secretKey);
	}

	public static String desDecrypt(String encryptText, String secretKey)
			throws Exception {
		if (StringUtils.isBlank(encryptText) || StringUtils.isBlank(secretKey)) {
			return "";
		}
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("desede/CBC/NoPadding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.DECRYPT_MODE, deskey, ips);

		byte[] decryptData = cipher.doFinal(Base64.decode(encryptText));

		return new String(decryptData, encoding).trim();
	}
	
	public static String md5Encrypt(String str){
		try {  
	        MessageDigest md = MessageDigest.getInstance("MD5");  
	        md.update(str.getBytes());  
	        byte[]byteDigest = md.digest();  
	        int i;  
	        StringBuffer buf = new StringBuffer("");  
	        for (int offset = 0; offset < byteDigest.length; offset++) {  
	            i = byteDigest[offset];  
	            if (i < 0)  
	                i += 256;  
	            if (i < 16)  
	                buf.append("0");  
	            buf.append(Integer.toHexString(i));  
	        }  
	        //32位加密  
	        return buf.toString();
	    } catch (NoSuchAlgorithmException e) {  
	        e.printStackTrace();  
	        return null;  
	    }  
	}
	
	public static void main(String[] args) throws Exception {
		String text = desEncrypt("1234567890-=~!@#$%^&*()_+qwertyuioplkjhfdgscxvnvbnm;',./");
		System.out.println(text);
		text = desDecrypt(text);
		System.out.println(text);
	}
}
