package com.rwt.arknights.common.constants;

import com.rwt.arknights.common.util.DateUtils;

import java.util.Date;

public class WebConstants {
    public static final int ADMIN_ID = 1;
    public static final String LOGIN_USER = "login_user";
    public static final String LOGIN_ROLE = "login_role";
    public static final String COOKIE_LOGIN_NAME = "loginName";
    public static final String COOKIE_LOGIN_PWD = "pwd";
    public static final String COOKIE_LOGIN_REMEMBER = "remember";
    public static final int SEVEN_DAY_SECOND = 60*60*24*7;
    public static final Date DEFAULT_DATE = DateUtils.parseStrToDate("1980-01-01",DateUtils.DATE_FORMAT_YYYY_MM_DD);
}
