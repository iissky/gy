package com.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JsonDateFormat implements JsonValueProcessor {
	
	private String format = "yyyy-MM-dd hh:mm:ss";

	@Override
	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(arg0);
	}

	@Override
	public Object processObjectValue(String key, Object value, JsonConfig arg2) {
		 if (value instanceof java.util.Date) {  
	            String str = new SimpleDateFormat(format).format((Date) value);  
	            return str;  
	        }  
	        if (null != value) {  
	            return value.toString();  
	        }  
	        return "";  
	}

}
