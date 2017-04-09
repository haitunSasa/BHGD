package com.util.base;

import java.io.UnsupportedEncodingException;

public class getChinaString {
	public static String ecChinaString(String str) throws UnsupportedEncodingException{
		str = new String(str.getBytes("ISO-8859-1"), "UTF-8");
        str = java.net.URLDecoder.decode(str, "UTF-8");
        return str;
	}
}
