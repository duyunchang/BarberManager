package com.barber.server.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.digest.DigestUtils;


public class Md5Helper {
	public static String encode(String value) {  
        if (value == null) {  
            return null;  
        }  
        return DigestUtils.md5Hex(value);
    }
	
	
	public static String encode(byte[] value) {  
        if (value == null) {  
            return null;  
        }  
        return DigestUtils.md5Hex(value);
    }
	
	public static String encodeStr(String value) {  
		String str=null;
        try {
        	str= DigestUtils.md5Hex(value.getBytes("utf-8"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        return str;
    }

	
	
	public static void main(String...args) throws UnsupportedEncodingException{
		String str="111111";

		String md5 = encode(str.getBytes("utf-8"));
		System.out.println(md5);
		
	}
}
