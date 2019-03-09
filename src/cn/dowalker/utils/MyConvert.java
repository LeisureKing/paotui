package cn.dowalker.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

public class MyConvert implements Converter{
	
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public Object convert(Class calzz, Object object) {
		try {
			Date date=sdf.parse((String) object);
			System.out.println(date);
			return date;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
