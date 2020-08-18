package com.wsl.flight.common.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Set;

import com.wsl.flight.common.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.CharSet;

/**
 * <p>
 * 基于java的API工具封装类
 * </p>
 * <strong>通用工具封装类，对常用处理进行封装</strong>
 * 
 * @author demliu
 * @version 1.0 2016-6-12
 * 基于java的API工具封装类
 */

@Slf4j
public class UtilAPI extends org.apache.commons.lang3.StringUtils {

    /**
     * ASCII 半角英文数字。
     */
    private static CharSet alphaNumChar = CharSet.getInstance("0-9A-Za-z");
	

	/**
	 * <p>
	 * 将对象转换为String
	 * </p>
	 * <strong>将对象转换为String, NULL返回""</strong>
	 * 
	 * @author demliu
	 * @param obj
	 *            对象
	 * @return String
	 */
	public static String convToString(Object obj) {

		if (obj == null) {
			return "";
		}
		String str = String.valueOf(obj);
		return str;
	}

	/**
	 * <p>
	 * 将对象转换为int
	 * </p>
	 * <strong>将对象转换为int, NULL返回0</strong>
	 * 
	 * @author demliu
	 * @param obj
	 *            对象
	 * @return int
	 */
	public static int convToInt(Object obj) {
		int i = 0;
		if (obj == null || "".equals(obj.toString().trim())) {
			return i;
		}
		if (obj instanceof Integer) {
			i = (Integer) obj;
		} else if (obj instanceof Long) {
			i = Integer.parseInt(String.valueOf(((Long) obj)));
		} else if (obj instanceof Double) {
			i = (int) ((Double) obj).doubleValue();
		} else {
			String str = obj.toString();
			// 判断是否是浮点数格式，如果是去除小数部分
			if (str.indexOf(".") > -1) {
				str = str.substring(0, str.indexOf("."));
			}
			try {
				i = Integer.valueOf(str);
			} catch (Exception e) {
				// 类型转换异常
				e.printStackTrace();
				log.error(e.getMessage());
			}
		}
		return i;
	}

	/**
	 * <p>
	 * 将对象转换为Long
	 * </p>
	 * <strong>将对象转换为Long, NULL返回0</strong>
	 * 
	 * @author demliu
	 * @param obj
	 *            对象
	 * @return Long
	 */
	public static long convToLong(Object obj) {
		long i = 0;
		if (obj == null || "".equals(obj.toString().trim())) {
			obj = "0";
		}
		if (obj instanceof Long) {
			i = (Long) obj;
		} else if (obj instanceof Double) {
			i = (long) ((Double) obj).doubleValue();
		} else {
			String str = obj.toString();
			// 判断是否是浮点数格式，如果是去除小数部分
			if (str.indexOf(".") > -1) {
				str = str.substring(0, str.indexOf("."));
			}

			try {
				i = Long.valueOf(str);
			} catch (Exception e) {
				// 类型转换异常
				log.error(e.getMessage());
			}
		}
		return i;
	}

	/**
	 * <p>
	 * 将对象转换为Double
	 * </p>
	 * <strong>将对象转换为double, NULL返回0.0</strong>
	 * 
	 * @author demliu
	 * @param obj
	 *            对象
	 * @return int
	 */
	public static double convToDouble(Object obj) {
		double i = 0.0;
		if (obj == null || "".equals(obj.toString().trim())) {
			return i;
		}

		String str = obj.toString();
		try {
			i = Double.parseDouble(str);
		} catch (Exception e) {
			// 类型转换异常
			log.error(e.getMessage());
		}
		return i;
	}

	/**
	 * <p>
	 * 将对象转换为指定小数据位数字符串
	 * </p>
	 * <strong>因为Double类型会以1.1E3方式显示，NULL返回0.0</strong>
	 * 
	 * @author demliu
	 * @param obj
	 *            对象
	 * @param decimalPalce
	 *            小数位数
	 * @return String
	 */
	public static String formatDouble(Object obj, int decimalPalce) {
		String s = "0.0";
		if (obj == null || "".equals(obj.toString().trim())) {
			return s;
		}

		String formatType = "#.";
		if (decimalPalce > 0) {
			for (int j = 0; j < decimalPalce; j++) {
				formatType += "0";
			}
		} else {
			formatType += "0";
		}
		String str = obj.toString();
		try {
			DecimalFormat df = new DecimalFormat(formatType);
			s = df.format(Double.parseDouble(str));
			// 将.000转换为0.000
			if (s != null && s.startsWith(".")) {
				s = "0" + s;
			}
		} catch (Exception e) {
			// 类型转换异常
			log.error(e.getMessage());
		}
		return s;
	}

	/**
	 * <p>
	 * 判断是不是为""或NULL
	 * </p>
	 * <strong>NULL、""返回True，其它返回False</strong>
	 * 
	 * @author demliu
	 *            对象
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str) || (str.trim()).length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * <p>
	 * 判断map集合是否为null或empty
	 * </p>
	 * <strong>null或empty返回true，其他返回false</strong>
	 * 
	 * @author demliu
	 * @param map
	 * @return
	 */
	public static boolean isMapNull(Map<Object, Object> map) {
		if (map == null || map.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * <p>
	 * 判断集合是否为null或empty
	 * </p>
	 * <strong>null或empty返回true，其他返回false</strong>
	 * 
	 * @author demliu
	 * @param list
	 * @return
	 */
	public static boolean isListNull(List<Object> list) {
		if (list == null || list.size() <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * <p>
	 * 处理以逗号相隔的字符串
	 * </p>
	 * <strong>源字符串——以逗号相隔的字符串；目标字符串——以符号','相隔的字符串</strong>
	 * 
	 * @author demliu
	 * @return
	 */
	public static String handleStr(String strs) {
		StringBuilder builder = new StringBuilder();
		// 将源字符串转换正数组类型
		String[] strArr = strs.split(",");
		for (int i = 0; i < strArr.length; i++) {
			String str = strArr[i];
			// 当i != 0时，加上分隔符-','
			if (i != 0) {
				builder.append("','");
			}
			builder.append(str);
		}

		return builder.toString();
	}


    /**
     * 文字列の前後のスペース（半角、全角）を取り除くメソッドです。
     *
     * @param orgstr 変換対象の文字列
     * @return 変換済みの文字列
     */
    public static String trim(String orgstr) {
        if (isEmpty(orgstr)) {
            return "";
        }
        /* 前方のスペースを取り除く */
        while (orgstr.startsWith(" ") || orgstr.startsWith("　")) {
            orgstr = orgstr.substring(1);
        }
        /* 後方のスペースを取り除く */
        while (orgstr.endsWith(" ") || orgstr.endsWith("　")) {
            orgstr = orgstr.substring(0, orgstr.length() - 1);
        }
        return orgstr;
    }

    /**
     * 指定した桁数にあわせて、左側を "0" で埋めるメソッドです。
     *
     * @param str 変換対象となる文字列
     * @param length 桁数
     * @return 左側0埋めされた文字列
     */
    public static String leftPad(String str, int length, char paddingChar) {
        str = org.apache.commons.lang3.StringUtils.leftPad(str, length, paddingChar);
        return str;
    }

    public static String rightPad(String str, int length, char paddingChar) {
        return org.apache.commons.lang3.StringUtils.rightPad(str, length, paddingChar);
    }

    /**
     * 文字列から無効な文字を削除した結果を返す関数
     *
     * @param str
     * @return strRtn
     */
    public static String ignoreString(String str) {
        if (null == str) {
            return "";
        }
        String strRtn = str.replace("%", "");
        strRtn = strRtn.replace("^", "");
        strRtn = strRtn.replace("*", "");
        strRtn = strRtn.replace("(", "");
        strRtn = strRtn.replace(")", "");
        strRtn = strRtn.replace("'", "");
        strRtn = strRtn.replace("[", "");
        strRtn = strRtn.replace("]", "");
//        strRtn = strRtn.replace("<", "");
//        strRtn = strRtn.replace(">", "");
        strRtn = strRtn.replace("\"", "");
        strRtn = strRtn.replace(",", "");
        strRtn = strRtn.replace("\t", "");
        return strRtn;
    }

    /**
     * 数字校验. <br>
     *
     * @param value String 条件
     * @return true, <br>
     *         false
     */
    public static boolean checkIsNum(String value) {
        if (isEmpty(value)) {
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    /**
     * 电话号码校验. <br>
     *
     * @param value String 条件
     * @return true, <br>
     *         false
     */
    public static boolean checkTellNum(String value) {
        if (isEmpty(value)) {
            return false;
        }
        Pattern pattern = Pattern.compile("(^0[\\d]{3}-?[\\d]{6,8}$)|([\\d]{6,11})");
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    /**
     * 邮箱格式校验
     *
     * @param str
     * @return true:正常　false:错误
     */
    public static boolean checkEmail(String str) {
    	if (isEmpty(str)) {
    		return false;
    	}
        boolean rtn;
        final String EMAIL_REGEX = "^([\\w\\.\\-~/]+)@([\\w_\\-]+)\\.([\\w_\\.\\-]*)[a-z][a-z]$";

        Pattern p = Pattern.compile(EMAIL_REGEX);
        Matcher m = p.matcher(str);
        rtn = m.find();

        if (rtn) {
            if (str.indexOf("..") >= 0 || str.indexOf(".@") >= 0) {
                rtn = false;
            }
        }

        return rtn;
    }

	/**
	 * int类型校验
	 * @param value
	 * @return
	 */
	public static boolean isInteger(String value){
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * float类型校验
	 * @param value
	 * @return
	 */
	public static boolean isFloat(String value){
		try {
			Float.parseFloat(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	/**
	 * 校验是否为正数
	 * @param value
	 * @return
	 */
	public static boolean isPositive(String value){
		if(isEmpty(value)){
			return false;
		}
		if(value.charAt(0) == '-'){
			return false;
		}
		return true;
	}
	
    /**
     * 日期时间校验. <br>
     *
     * @param strDate String 日期时间
     * @param mask String 日期时间格式
     */
    public static boolean isDateTime(String strDate, String mask) {
        if (isEmpty(strDate)) {
            return false;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(mask);
        Date date = null;
        try {
            date = dateFormat.parse(strDate);
        } catch (ParseException pe) {
            return false;
        }

        String strdate = dateFormat.format(date);
        if (!strdate.equals(strDate)) {
            return false;
        }

        return true;
    }
    
    public static boolean isBeforeNow(String value){
    	int day = 0;
    	try {
    	    String now = DateUtil.getNowdate(DateUtil.FORMAT_DATE);
			day = DateUtil.getBetweenDays(now, value, false);
		} catch (ParseException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
    	if(day<0){
    		return true;
    	}
    	return false;
    }

	/**
	 * <p>
	 * 功能说明：把Map里的数据为String[]数组的数据，取出来放到对应的KEY中
	 * </p>
	 * <strong>主要用途：页面中的Name="Map.key"处理</strong>
	 * 
	 * @author demliu
	 *            : 页面传给ACION里的Map
	 * @return 直接可以用KEY取值的Map
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String, String> mapValueToString(Map entityMap) {
		Map<String, String> dataMap = new HashMap();
		if (entityMap != null && entityMap.size() > 0) {

			Set setMap = entityMap.entrySet();
			Iterator itr = setMap.iterator();
			while (itr.hasNext()) {
				Entry entry = (Entry) itr.next();
				String key = convToString(entry.getKey());
				String[] value = null;
				try {
					value = (String[]) entry.getValue();
					if (value != null) {
						if (value.length > 1) {
							String keyValue = "";
							for (int i = 0; i < value.length; i++) {
								String tmp = !isEmpty(value[i].trim()) ? value[i]
										.trim() : "";
								if (tmp.length() > 0) {
									keyValue = keyValue + tmp + ",";
								}
							}
							// keyValue = removeStartAndEndCommaStr(keyValue);
							dataMap.put(key, keyValue);
						} else {
							dataMap.put(key,
									!isEmpty(value[0].trim()) ? value[0].trim()
											: "");
						}
					} else {
						dataMap.put(key, "");
					}
				} catch (Exception e) {
					dataMap.put(key, convToString(entityMap.get(key)));
				}
			}
		}

		return dataMap;
	}

    /**
     * 验证字符串是否包含半角英文数字以外的字符。
     * 空字符串返回 true。
     *
     * @param str 传入参数
     * @return 包含非半角英文数字 返回 false
     */
    public static boolean isAlphaNumCharOnly(String str) {
        boolean asciiOnly = true;
        if (isEmpty(str)) {
            return asciiOnly;
        }
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (!alphaNumChar.contains(cs[i])) {
                asciiOnly = false;
            }
        }
        return asciiOnly;
    }

    public static void main(String[] args) {
    	System.out.println(checkEmail("12345678@qq.com"));
	}
}