package com.wsl.flight.common.util;

import java.text.SimpleDateFormat;

import org.springframework.context.ApplicationContext;

/**
 * @ClassName: Constants
 * @Description: 常量类
 * @author EVDB
 * @date 2013-12-18 下午2:05:08
 *
 */
public class Constants {
	
	public static final SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	/** 系统编码*/
	public static final String SYS_DEFAULT_ENCODE = "UTF-8";

	public static final String SYS_DEFAULT_MAUSER = "1001";
	public static final String USER_KEY = "user";
	public static final String USERNAME_KEY = "username";
	public static final String USERID_KEY = "userid";
	public static final String USER_SEC_LEVEL = "user_sec_levle"; 
	public static final String ISSUPER = "isSuper"; 
	public static final String SYS_MANAGER = "sys_manager"; 
	public static final String USER_TYPE = "user_type"; 
	public static final String ACCOUNT_AUTH = "account_auth";
	public static final String MANAGER = "2";//对应choice属性文件用户权限：管理
	public static final String VIEW = "1";//对应choice属性文件用户权限：浏览
	public static final String SUPER = "3";//对应choice属性文件用户权限：超级管理

	public static final String JCDL_DATA_TYPE = "1";
	public static final String ZTDL_DATA_TYPE = "2";
	public static final String JSDL_DATA_TYPE = "3";
	public static final String JSXL_DATA_TYPE = "4";
	
	public static final String SUPERMANAGER = "1";

    /** 顶级菜单上级菜单ID */
    public static final String TOPMENU_PAR_MENUID = "0";
    
    /** 查询条件-排序字段映射名称 */
    public static final String QUERY_LIST_SORTNAME = "sortname";
    
    /** 查询条件-条件字段映射名称 */
    public static final String QUERY_LIST_QTYPE = "qtype";

	public static ApplicationContext WEB_APP_CONTEXT = null; //该值会在web容器启动时由WebAppContextListener初始化
	
	public static final String ACTIVITY_TRACK = "ot";
}
