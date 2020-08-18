package com.wsl.flight.common.util;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JSONUtils {

	/**
	 * 返回json对象的值
	 * 
	 * @param obj
	 * @param key
	 * @return
	 */
	public static String getString(JSONObject obj, String key) {
		if (obj.containsKey(key)) {
			return obj.getString(key);
		} else {
			return "";
		}
	}
	
	/**
	 * 返回json对象的值
	 * 
	 * @param obj
	 * @param key
	 * @return
	 */
	public static int getInt(JSONObject obj, String key) {
		if (obj.containsKey(key)) {
			return obj.getInteger(key);
		} else {
			return 0;
		}
	}
	
	/**
	 * 返回json对象的值
	 * 
	 * @param obj
	 * @param key
	 * @return
	 */
	public static double getDouble(JSONObject obj, String key) {
		if (obj.containsKey(key)) {
			return obj.getDouble(key);
		} else {
			return 0D;
		}
	}

	/**
	 * 返回json对象的值
	 * 
	 * @param obj
	 * @param key
	 * @return
	 */
	public static JSONObject getJSONObject(JSONObject obj, String key) {
		if (obj.containsKey(key)) {
			return obj.getJSONObject(key);
		} else {
			return new JSONObject();
		}
	}
	
	/**
	 * 返回json对象的值
	 * 
	 * @param obj
	 * @param key
	 * @return
	 */
	public static JSONArray getJSONArray(JSONObject obj, String key) {
		if (obj.containsKey(key)) {
			return obj.getJSONArray(key);
		} else {
			return new JSONArray();
		}
	}
}
