package com.zkyf.invoking.common;

import com.zkyf.invoking.config.DateConverterConfig;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class RequestEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 函数名
	 */
	private String cmd;
	/**
	 * 用户token
	 */
	private String token;
	/**
	 * 参数
	 */
	private Map<String, Object> params;
	
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
	
	
	
	
	
	
	
	public Object getParam(String key){
		return getParam(key, null);
	}
	public void setParam(String key,Object value){
		this.params.put(key, value);
	}
	
	public Object getParam(String key,Object defaultValue){
		Object value  = this.params.get(key);
		if(value != null){
			return value;
		}
		return defaultValue;
	}
	
	public Date getDateParam(String key){
		return getDateParam(key, null);
	}
	
	public Integer getIntegerParam(String key){
		return getIntegerParam(key, null);
	}
	
	public String getStringParam(String key){
		return getStringParam(key, null);
	}
	
	public Double getDoubleParam(String key){
		return getDoubleParam(key, null);
	}
	public Date getDateParam(String key,Date defaultValue){
		Object value  = getParam(key);
		if(value != null){
			if(value instanceof Date){
				return (Date) value;
			}else if(value instanceof String){
				return new DateConverterConfig().convert(value+"");
			}
		}
		return defaultValue;
	}
	
	public Integer getIntegerParam(String key,Integer defaultValue){
		Object value  = getParam(key);
		if(value != null && value instanceof Integer){
			return (Integer) value;
		}
		return defaultValue;
	}
	
	public String getStringParam(String key,String defaultValue){
		Object value  = getParam(key);
		if(value != null && value instanceof String){
			return (String) value;
		}
		return defaultValue;
	}
	
	public Double getDoubleParam(String key,Double defaultValue){
		Object value  = getParam(key);
		if(value != null && value instanceof Double){
			return (Double) value;
		}
		return defaultValue;
	}
}
