package com.ellen.newsdemo.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class IsToString {
	public static String streamToString(InputStream  in){
		String result ="";

		try{
			//����һ���ֽ�����д����
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			
			byte[] buffer = new byte[1024];
			int length = 0;
			while (  (length =  in.read(buffer)) !=-1) {
				out.write(buffer, 0, length);
				out.flush();
			}
			
			result =   new String(out.toByteArray(),"utf-8");
			
//			result = out.toString();//���ֽ���ת����string
			
			out.close();
		}catch (Exception e) {
			e.printStackTrace();
		}


		return result;
	}
}
