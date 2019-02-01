package com.zkyf.invoking.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;


import java.util.List;

public class FastJsonUtils {

	private static final SerializerFeature[] CONFIG = new SerializerFeature[]{
        SerializerFeature.WriteNullBooleanAsFalse,//boolean为null时输出false  
        SerializerFeature.WriteMapNullValue, //输出空置的字段  
        SerializerFeature.WriteNonStringKeyAsString,//如果key不为String 则转换为String 比如Map的key为Integer  
        SerializerFeature.WriteNullListAsEmpty,//list为null时输出[]  
        SerializerFeature.WriteNullNumberAsZero,//number为null时输出0  
        SerializerFeature.WriteNullStringAsEmpty//String为null时输出"" 
	};  
	
	/**
	 * 有格式形状的字符串
	 * @param bean
	 * @return
	 */
	public static String bean2JsonFormat(Object bean){
		if(bean==null)
			return "";
		try {
			return JSON.toJSONString(bean,true);
		} catch (Exception e) {
			throw new RRException("实体转JSON异常：", e);
		}
	}
	
	/**
	 * 有所有字段的字符串
	 * @param bean
	 * @return
	 */
	public static String bean2JsonAll(Object bean){
		if(bean==null)
			return "";
		try {
			return JSON.toJSONString(bean,CONFIG);
		} catch (Exception e) {
			throw new RRException("实体转JSON异常：", e);
		}
		
	}
	
	/**
	 * 实体转字符json字符串
	 * @param bean
	 * @return
	 */
	public static String bean2Json(Object bean) {
		if(bean==null)
			return "";
		try {
			return JSON.toJSONString(bean,false);
		} catch (Exception e) {
			throw new RRException("实体转JSON异常：", e);
		}
	}
	
	/**
	 * json字符串转实体
	 * @param jsonStr
	 * @param clazz
	 * @return
	 */
	public static <T> T json2Bean(String jsonStr,Class<T> clazz) {
		if(jsonStr==null || jsonStr.length()==0)
			return null;
		try {
			return JSON.parseObject(jsonStr,clazz);
		} catch (Exception e) {
			throw new RRException("JSON转实体异常：", e);
		}
	}
	
	/**
	 * list实体转字符串
	 * @param listBean
	 * @return
	 */
	public static <T> String list2Json(List<T> listBean) {
		if(listBean==null || listBean.size()==0)
			return "";
		try {
			return JSON.toJSONString(listBean,false);
		} catch (Exception e) {
			throw new RRException("List转JSON异常：", e);
		}
	}
	
	/**
	 * list实体字符串转实体
	 * @param listJson
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> json2List(String listJson,Class<T> clazz) {
		if(listJson==null || listJson.length()==0)
			return null;
		try {
			return JSON.parseArray(listJson,clazz);
		} catch (Exception e) {
			throw new RRException("JSON转实体异常：", e);
		}
	}
	
}
