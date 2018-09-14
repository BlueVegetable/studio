package cn.studio.zps.blue.ljy.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 蔡荣镔
 * @version 1.0
 */
public class MD5 {
    /**
     * 将字符串进行MD5加密
     * @param value 待加密的字符串
     * @return 加密后的字符串
     */
	public static String toMD5(String value) {
		byte[] secretBytes;
		
		try {
			secretBytes=MessageDigest.getInstance("md5").digest(value.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException("不存在MD5编码格式");
		}
		
		return new BigInteger(1,secretBytes).toString(16);
	}
}