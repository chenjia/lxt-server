package com.lxt.common.utils;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.springframework.util.StringUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class SecurityUtils {
	public final static String key = PropertiesUtils.getProperties("/config.properties").getProperty("key");
	
	private final static String DES = "DES";
	
	private final static String encoding = "UTF-8";

	
	
    /**
     * Description 根据键值进行加密
     * @param data 
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    public static String desEncrypt(String data, String key) throws Exception {
    	// 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
 
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key.getBytes(encoding));
 
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
 
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);
 
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
 
        byte[] bt = cipher.doFinal(data.getBytes(encoding));
        String strs = new BASE64Encoder().encode(bt);
        return strs;
    }
 
    /**
     * Description 根据键值进行解密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String desDecrypt(String data, String key) throws IOException,Exception {
        if (data == null){
        	return null;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key.getBytes(encoding));
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
        byte[] bt = cipher.doFinal(decoder.decodeBuffer(data));
        return new String(bt);
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
		String data = "ed26d4cd99aa11e5b8a4c89cdc776729";
        String key = "ed26d4cd99aa11e5b8a4c89cdc776729";
        String key2 = "ed26d4cd99aa11e5b8a4c89cdc776729";
        System.err.println(desEncrypt(data, key));
        System.err.println(desDecrypt(desEncrypt(data, key), key2));
	}
}
