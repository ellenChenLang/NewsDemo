package com.ellen.newsdemo.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.Context;

public class GetNewsUtil {
    //public static String url_address = "http://tech.qq.com/web/it/telerss.xml";
    public static String url_address = "http://www.kjson.com/h/c/news/169725_1.html";
	public static String getNews(Context mContext) {
		String s = "NULL";
		
		try {
			//建立URL对象
			URL url = new URL(url_address);
			//建立HttpURLConnection对象
			HttpURLConnection huc = (HttpURLConnection) url.openConnection();
			//为HttpURLConnection对象设置参数
			huc.setConnectTimeout(10*1000);
			huc.setRequestMethod("GET");
			
			int code = huc.getResponseCode();
			
			if(code == 200){
				InputStream is = huc.getInputStream();
				 s = IsToString.streamToString(is);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return s;
	}

}
