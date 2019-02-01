package com.zkyf.invoking.common;

import org.springframework.util.StringUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


/**
 * 数据校验
 */
public abstract class AssertUtil {
	
//	/**
//	 * 验证是否为数值类型
//	 * @param object
//	 * @return
//	 */
//	public static boolean isNumber(Object object){
//		if(object != null && object instanceof Number){
//			return true;
//		}
//		return false;
//	}
//	
//	/**
//	 * 
//	 * @param object
//	 * @param message
//	 */
//	public static void isNumber(Object object, String message){
//		if(!isNumber(object)){
//			throw new RRException(message);
//		}
//	}
	
	/**
	 * 验证对象是否为 null
	 * @param
	 * @return
	 */
    public static void isNull(Object object, String message) {
        if (isNull(object)) {
            throw new RRException(message);
        }
    }

	/**
	 * 验证对象是否为 null
	 *
	 * @param
	 * @return
	 */
	public static void isNull(Object object, String message, Integer code) {
		if (isNull(object)) {
			throw new RRException(message, code);
		}
	}
    /**
	 * 验证对象是否为 null
	 * @param
	 * @return
	 */
	public static <T> boolean isNull(T t) {
		if (null == t) {
			return true;
		}
		if (t instanceof Number && ((Number)t).doubleValue() == 0) {
			return true;
		}
		// t extends CharSequence
		if (t instanceof CharSequence && !StringUtils.hasText(t.toString())) {
			return true;
		}
		// t extends Collection
		if (t instanceof Collection && ((Collection<?>)t).isEmpty()) {
			return true;
		}
		// Map
		if (t instanceof Map && ((Map<?, ?>) t).isEmpty()) {
			return true;
		}
		// Array
		if (t.getClass().isArray() && Array.getLength(t) == 0) {
			return true;
		}
		return false;
	}

	public static <T> boolean isNotNull(T t) {
		return !isNull(t);
	}

	public static Object[] initParam(RequestEntity entity,Integer empNo){
		List<Object> list = new ArrayList<Object>();
		if(empNo != null){
			list.add(empNo);
		}
		switch (entity.getCmd()) {
			case "worker_acquit":
				AssertUtil.isNull(entity.getIntegerParam("oprno"), "oprno为空");
				AssertUtil.isNull(entity.getIntegerParam("no"), "no为空");
				list.add(entity.getIntegerParam("no"));
				list.add(entity.getIntegerParam("kind"));
				list.add(entity.getParam("conditions",""));
				list.add(entity.getIntegerParam("state",0));
				list.add(entity.getDateParam("startdate"));
				list.add(entity.getDateParam("enddate"));
				list.add(entity.getIntegerParam("page", 1));
				list.add(entity.getIntegerParam("ofpage", 10));
				break;
			case "worker_search":
				list.add(entity.getIntegerParam("prjno",0));
				list.add(entity.getParam("empname",""));
				list.add(entity.getIntegerParam("empstate",0));
				list.add(entity.getIntegerParam("workbreed",0));
				list.add(entity.getIntegerParam("advkind",255));
				list.add(entity.getIntegerParam("page", 1));
				list.add(entity.getIntegerParam("ofpage", 10));
				break;
			case "employee_loadby":
				list.add(entity.getIntegerParam("orgno",0));
				list.add(entity.getParam("conditions",""));
				list.add(entity.getParam("dept",""));
				list.add(entity.getIntegerParam("status",0));
				list.add(entity.getIntegerParam("advkinds",0));
				list.add(entity.getIntegerParam("page", 1));
				list.add(entity.getIntegerParam("ofpage", 10));
				break;
			case "blacklist_search":
				list.add(entity.getParam("empname",""));
				list.add(entity.getIntegerParam("page", 1));
				list.add(entity.getIntegerParam("ofpage", 10));
				break;
			case "locationattendance_loadby":
				list.add(entity.getIntegerParam("no",0));
				list.add(entity.getIntegerParam("kind",0));
				list.add(entity.getParam("empidcard",""));
				list.add(entity.getIntegerParam("page", 1));
				list.add(entity.getIntegerParam("ofpage", 10));
				break;
		}
		return list.toArray();
	}

}
